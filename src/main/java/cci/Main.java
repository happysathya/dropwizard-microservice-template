package cci;

import cci.resource.OrderResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class Main extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        OrderResource orderResource = new OrderResource();
        environment.jersey().register(orderResource);
    }
}
