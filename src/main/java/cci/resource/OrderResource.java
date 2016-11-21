package cci.resource;

import cci.model.CCI_Order;
import cci.model.od.Order;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

@Path("/accounts/{accountId}/orders")
public class OrderResource {

    private static OkHttpClient httpClient = new OkHttpClient();
    private static TypeReference<List<CCI_Order>> listOrderReference = new TypeReference<List<CCI_Order>>() {
    };
    private static TypeReference<CCI_Order> orderReference = new TypeReference<CCI_Order>() {
    };
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static HttpUrl httpUrl = HttpUrl.parse("http://cci-uat-services.northeurope.cloudapp.azure.com:7004/");

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private static Order mapOrder(CCI_Order cci_order) {
        Order od_order = new Order();
        od_order.setBrand(cci_order.getBrandName());
        od_order.setOrderStatus(getOrderStatus(cci_order.getOrderStatus()));
        return od_order;
    }

    private static Order.OrderStatusEnum getOrderStatus(String orderStatus) {
        switch (orderStatus.toUpperCase()) {
            case "DRAFT":
                return Order.OrderStatusEnum.PENDING;
            case "APPROVED":
                return Order.OrderStatusEnum.APPROVED;
            default:
                return Order.OrderStatusEnum.REJECTED;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders(@PathParam("accountId") String accountId, @HeaderParam("Authorization") String token) {
        try {
            Request httpRequest = new Request.Builder()
                    .url(httpUrl.newBuilder()
                            .addPathSegment("customers")
                            .addPathSegment(accountId)
                            .addPathSegment("orders").build())
                    .addHeader("Authorization", token)
                    .addHeader("Accept-Encoding", "gzip")
                    .get()
                    .build();
            Response httpResponse = httpClient.newCall(httpRequest).execute();
            if (httpResponse.code() == 200) {
                List<CCI_Order> cci_orders = objectMapper.readValue(new GZIPInputStream(httpResponse.body().byteStream()), listOrderReference);
                return cci_orders.stream().map(OrderResource::mapOrder).collect(Collectors.toList());
            } else {
                throw new InternalServerErrorException();
            }
        } catch (IOException ex) {
            throw new InternalServerErrorException();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Order postOrder(@PathParam("accountId") String accountId,
                           @HeaderParam("Authorization") String token,
                           Order order) {
        try {
            CCI_Order cci_order = new CCI_Order();
            cci_order.setAdvertiserOrgId(order.getAccountId());
            cci_order.setBrandId(order.getBrand());
            System.out.println(objectMapper.writeValueAsString(cci_order));
            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json"), objectMapper.writeValueAsString(cci_order));
            Request httpRequest = new Request.Builder()
                    .url(httpUrl.newBuilder()
                            .addPathSegment("customers")
                            .addPathSegment(accountId)
                            .addPathSegment("orders").build())
                    .addHeader("Authorization", token)
                    .post(requestBody)
                    .build();
            Response httpResponse = httpClient.newCall(httpRequest).execute();
            if (httpResponse.code() == 200) {
                return mapOrder(objectMapper.readValue(httpResponse.body().byteStream(), orderReference));
            } else {
                System.out.println(httpResponse);
                throw new InternalServerErrorException();
            }
        } catch (IOException ex) {
            throw new InternalServerErrorException();
        }
    }

}