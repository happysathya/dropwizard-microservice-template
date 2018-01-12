package org.happysathya;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class AppConfiguration extends Configuration {

    @NotNull
    @NotEmpty
    private String appName;

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @NotNull
    @NotEmpty
    private String connectionUri;

    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }

    public String getConnectionUri() {
        return connectionUri;
    }

    public String getAppName() {
        return appName;
    }
}
