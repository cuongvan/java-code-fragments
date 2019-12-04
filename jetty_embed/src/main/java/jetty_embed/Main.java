/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetty_embed;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 *
 * @author cuong
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(9999);
        server.setConnectors(new Connector[]{connector});
        
        
        ResourceConfig conf = new ResourceConfig();
        conf.packages(Main.class.getPackage().toString());
        conf.register(new ExceptionMapper<Throwable>() {
            @Override
            public Response toResponse(Throwable e) {
                e.printStackTrace();
                String exec = e.toString() + "\n" + e.getMessage() + "\n";
                return Response.ok(exec, MediaType.TEXT_PLAIN).build();
            }
        });
        
        conf.register(CustomObjectMapperResolver.class); // custom object mapper
        conf.register(JacksonFeature.class); // no need to defind BodyReader & MessageWriter anymore
        
        ServletContextHandler ctx
                = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        ctx.addServlet(new ServletHolder(new ServletContainer(conf)), "/*");
        server.setHandler(ctx);
        server.start();
        server.join();
    }
}
