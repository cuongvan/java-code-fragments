
import java.nio.ByteBuffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuong
 */
public class initial_offset {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(100);
        byte[] arr = buf.array();
        System.out.println(arr.length);
        
        ByteBuffer buf2 = ByteBuffer.wrap(buf.array(), 0, 99);
        System.out.println("buf2 " + buf2.toString());
        System.out.println(buf2.flip());
        System.out.println(buf2.flip());
    }
}
