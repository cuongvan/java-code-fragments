
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
public class share_array {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(64);
        
        // need to read frame size (4 bytes) from network
        // use the original array, but change limit
        buf = ByteBuffer.wrap(buf.array(), 0, 4);
        System.out.println("Wrap: " + buf);
        // or
        buf.clear();
        buf.limit(4);
        System.out.println("Set limit: " + buf);
        
        // fake network reading: like socketChannel.read(buf)
        buf.putInt(100);
        System.out.println("Read frame size: " + buf);
        
        
        // put anymore to buffer -> exception!! good
        if (false) // want to test exception or not?
            buf.put((byte) 4);
        
        // read framesize
        buf.flip();
        int frameSize = buf.getInt();
        System.out.println("Frame size retrieved: " + frameSize);
        System.out.println("After read frame size: " + buf);
        
        // make buffer ready for use with another
        if (buf.capacity() < frameSize) {
            buf = ByteBuffer.allocate(frameSize);
        }
        buf.position(0);
        buf.limit(frameSize);
        System.out.println("Buf after change: " + buf);
        
        buf.putInt(frameSize); // push back 4 bytes read previously: frame size
        
        // fake network: read full frame
        for (int i = 0; i < frameSize - 4; i++) {
            buf.put((byte) 1);
        }
        
        System.out.println("Read whole packet: " + buf);
    }
    private static ByteBuffer prepareReadBuffer(ByteBuffer oldBuffer, int size) {
        if (oldBuffer.capacity() < size)
            return ByteBuffer.allocate(size);
        else {
            ByteBuffer newBuff = oldBuffer.duplicate();
            newBuff.position(0);
            newBuff.limit(size);
            return newBuff;
        }
    }
}
