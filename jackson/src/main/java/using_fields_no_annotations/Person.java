package using_fields_no_annotations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author cuong
 */
public class Person {

    public String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("[Person name=%s age=%d]", name, age);
    }
    
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapperSimple = new ObjectMapper();
        
        ObjectMapper mapperComplex = new ObjectMapper()
                .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        
        
        System.out.println(mapperSimple.writeValueAsString(new Person(null, 100)));
        System.out.println(mapperComplex.writeValueAsString(new Person("cuong", 100)));
        
        String json = mapperComplex.writeValueAsString(new Person("cuong", 100));
        System.out.println(mapperComplex.readValue(json, Person.class));
    }
}
