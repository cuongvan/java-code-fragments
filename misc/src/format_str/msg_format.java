/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package format_str;

import java.text.MessageFormat;

/**
 *
 * @author cuong
 */
public class msg_format {
    public static void main(String[] args) {
        String msg = MessageFormat.format("{0}, {1,number}!", "Hello", 1000);
        System.out.println(msg);
    }
}
