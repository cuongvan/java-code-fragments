
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
public class wrap_and_offset {
    public static void main(String[] args) {
        byte[] bytes = new byte[] { 1, 2, 3, 4, 5, 6 };
        ByteBuffer orig = ByteBuffer.wrap(bytes);
        System.out.println("orig " + orig + " " + orig.get() + " " + orig.get());
        
        // assume header = 2 bytes
        int headerSize = 2;
        ByteBuffer body = ByteBuffer.wrap(bytes, headerSize, bytes.length - headerSize);
        System.out.println("body " + body + " " + body.get() + " " + body.get() + " " + body.get());
        System.out.println("body get(0,1,2) " + body.get(0) + " " + body.get(1) + " " + body.get(2));
    }
}
