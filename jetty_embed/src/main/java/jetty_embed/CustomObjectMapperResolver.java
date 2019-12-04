/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetty_embed;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

/**
 *
 * @author cuong
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class CustomObjectMapperResolver implements ContextResolver<ObjectMapper> {
    private final ObjectMapper mapper;

    public CustomObjectMapperResolver() {
        System.out.println("object mappeer created");
        mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setVisibility(JsonMethod.GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(JsonMethod.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(JsonMethod.SETTER, JsonAutoDetect.Visibility.NONE);
        mapper.enable(Feature.INDENT_OUTPUT);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("ObjectMapperResolver.getContext(...)");
        return mapper;
    }
}
