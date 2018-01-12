package org.happysathya.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.happysathya.AppConfiguration;
import org.happysathya.BaseRouteForTest;
import org.happysathya.Main;
import org.happysathya.model.Information;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class InformationResourceTest {

    private static final int port = BaseRouteForTest.findFreePort();

    @ClassRule
    public static final DropwizardAppRule<AppConfiguration> RULE = new DropwizardAppRule<>(Main.class, ResourceHelpers.resourceFilePath("app-config.yml"),
            ConfigOverride.config("connectionUri", "http://localhost:" + port));
    @ClassRule
    public static final WireMockClassRule stub = new WireMockClassRule(port);
    private static final JerseyClient jerseyClient = new JerseyClientBuilder().build();

    @AfterClass
    public static void afterClassAction() {
        stub.stop();
    }

    private static String toJsonString(Object object) throws Exception {
        return new ObjectMapper().writeValueAsString(object);
    }

    @After
    public void reset() {
        stub.resetMappings();
    }

    @Test
    public void getInformation() throws Exception {
        Information information = new Information();
        information.setOrigin("mobile");
        information.setUrl("https://happysathya.blogspot.com");

        stub.givenThat(get(urlPathMatching(".*/get"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(toJsonString(information))));

        Response response = jerseyClient.target(String.format("http://localhost:%d/api/info", RULE.getLocalPort()))
                .request().get();
        Information result = response.readEntity(Information.class);

        assertEquals(200, response.getStatus());
        assertEquals("mobile", result.getOrigin());
        assertEquals("https://happysathya.blogspot.com", result.getUrl());
    }
}