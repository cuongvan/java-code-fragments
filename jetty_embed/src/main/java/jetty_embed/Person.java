/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetty_embed;

/**
 *
 * @author cuong
 */
public class Person {

    public String name;
    public int age;

//    @Provider
//    @Consumes(MediaType.APPLICATION_JSON)
//    public static class BodyReader implements MessageBodyReader<Person> {
//
//        @Override
//        public boolean isReadable(Class<?> type, Type genericType, Annotation[] antns, MediaType mt) {
//            return Person.class.isAssignableFrom(type);
//        }
//
//        @Override
//        public Person readFrom(Class<Person> type, Type genericType, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.readValue(in, Person.class);
//        }
//
//    }
//
//    @Provider // has @Provider -> no need to register to ResourceConfig
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public static class PersonWriter implements MessageBodyWriter<Person> {
//
//        @Override
//        public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
//            return Person.class.isAssignableFrom(type);
//        }
//
//        @Override
//        public void writeTo(Person t, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out) throws IOException, WebApplicationException {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(out, t);
//        }
//    }
}
