package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

/**
 * @author vons0
 */
public class IoTest3 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\vons0\\Desktop\\test.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        inputStreamChannel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println("ByteBuffer--" + buffer.asCharBuffer());
//            buffer.rewind();//回到数据开始的地方
            buffer.clear();
        }

        FileChannel out = new FileOutputStream("test.txt").getChannel();
        inputStreamChannel.transferTo(0, inputStreamChannel.size(), out);
//  or      out.transferFrom(inputStreamChannel, 0, inputStreamChannel.size());
    }
}
