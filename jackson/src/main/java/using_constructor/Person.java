package using_constructor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author cuong
 */

@JsonAutoDetect(
        fieldVisibility=Visibility.ANY,
        getterVisibility=Visibility.NONE,
        isGetterVisibility=Visibility.NONE,
        setterVisibility=Visibility.NONE
)
public class Person {
    private final String name;
    private final int age; // private is also serialized

    @JsonCreator
    public Person(
            @JsonProperty("wtf") String name,
            @JsonProperty("hahaha") int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return String.format("[Person name=%s age=%d]", name, age);
    }
    
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(new Person("cuong", 100));
        System.out.println(mapper.readValue(json, Person.class));
        
        String json2 = "{\"wtf\": \"cuong\", \"hahaha\": 100}";
        System.out.println(mapper.readValue(json2, Person.class));
    }
}
