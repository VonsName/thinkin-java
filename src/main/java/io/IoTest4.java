package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * @author vons0
 */
public class IoTest4 {

    public static void main(String[] args) throws IOException {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[12]);
        wrap.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(wrap.array()));
        //数据回到起始位置
        wrap.rewind();
        //ByteOrder.BIG_ENDIAN 高位优先存储
        wrap.order(ByteOrder.BIG_ENDIAN);
        wrap.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(wrap.array()));
        wrap.rewind();
        //低位优先存储
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        wrap.asCharBuffer().put("adcedf");
        System.out.println(Arrays.toString(wrap.array()));

        FileChannel in = new FileInputStream("C:\\Users\\vons0\\Desktop\\test.txt").getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //从FileInputStream读取数据到ByteBuffer
        in.read(allocate);
        FileChannel out = new FileOutputStream("test").getChannel();
        //切换读取模式,准备从ByteBuffer读取数据,此时将limit设置为position,position设置为0
        allocate.flip();
        //把ByteBuffer中的数据读取到FileOutputStream
        out.write(allocate);
        out.close();
    }
}
