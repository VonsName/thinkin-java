package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;

/**
 * @author vons0
 */
public class IoTest5 {

    public static void main(String[] args) throws IOException {
        //内存映射
        //
        FileChannel in = new RandomAccessFile("C:\\Users\\vons0\\Desktop\\test.txt", "rw").getChannel();
        //如果映射的模式设置为READ_WRITE,则输入流必须
        //使用RandomAccessFile创建并指定 "rw" 模式,
        // 否则会报错java.nio.channels.NonWritableChannelException
        //综上所述:映射文件中的所有输出必须使用RandomAccessFile
        MappedByteBuffer map = in.map(FileChannel.MapMode.READ_WRITE, 0, in.size());
        byte[] bytes = new byte[1024];
        ByteBuffer byteBuffer = map.get(bytes);
        System.out.println(new String(bytes, Charset.defaultCharset()));

        //获取整个文件的锁
        FileLock fileLock = in.tryLock(0, in.size(), true);
//        fileLock = in.lock();
        //查看是否是共享锁
        boolean shared = fileLock.isShared();
        System.out.println(shared);
//释放锁
        fileLock.release();
    }
}
