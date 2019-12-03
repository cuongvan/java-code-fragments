package using_fields_annotations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
    public String name;
    private int age; // private is also serialized

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(new Person("cuong", 100)));
    }
}
