package org.happysathya.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.happysathya.model.Information;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Api(value = "/info", description = "All Information operations")
@Path("/info")
public class InformationResource {

    private static OkHttpClient httpClient = new OkHttpClient();
    private static TypeReference<Information> informationTypeReference = new TypeReference<Information>() {
    };
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private final HttpUrl httpUrl;

    public InformationResource(String url) {
        httpUrl = HttpUrl.parse(url);
    }

    @ApiOperation(value = "Get Information")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Information getInformation() {
        try {
            Request httpRequest = new Request.Builder()
                    .url(httpUrl.newBuilder()
                            .addPathSegment("get")
                            .build())
                    .get()
                    .build();
            Response httpResponse = httpClient.newCall(httpRequest).execute();
            if (httpResponse.code() == 200) {
                return objectMapper.readValue(httpResponse.body().byteStream(), informationTypeReference);
            } else {
                throw new InternalServerErrorException();
            }
        } catch (IOException ex) {
            throw new InternalServerErrorException();
        }
    }

}