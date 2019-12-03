/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author cuong
 */
public class _main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(new IntListParam()));
        System.out.println(mapper.writeValueAsString(new IntParam()));
        
        System.out.println(mapper.readValue("{\"type\": \"intlist\", \"value\": [1,2,3]}", Param.class));
        System.out.println(mapper.readValue("{\"type\": \"int\", \"value\": 1}", Param.class));
        System.out.println(mapper.readValue("{\"type\": \"string\", \"value\": \"hahaha\"}", Param.class));
    }
}
