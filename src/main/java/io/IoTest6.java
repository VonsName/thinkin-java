package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author vons0
 * 对文件上锁,类似数据库可以不同用户访问
 */
public class IoTest6 {
    private static FileChannel in;

    public static void main(String[] args) throws IOException {
        in = new RandomAccessFile("C:\\Users\\vons0\\Desktop\\test.txt", "rw").getChannel();

        MappedByteBuffer map = in.map(FileChannel.MapMode.READ_WRITE, 0, in.size());
        new LockAndModify(map, 0, in.size() / 3);
        new LockAndModify(map, in.size() / 2, in.size() / 2 + in.size() / 4);
    }

    static class LockAndModify extends Thread {
        private ByteBuffer buffer;
        private long start, end;

        public LockAndModify(ByteBuffer map, long start, long end) {
            this.start = start;
            this.end = end;
            map.limit((int) this.end);
            map.position((int) this.start);
            this.buffer = map.slice();
            start();
        }

        @Override
        public void run() {
            FileLock fileLock = null;
            try {
                fileLock = in.tryLock(start, end, false);
                System.out.println("Locked:" + start + "-to:" + end);
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte) (buffer.get() + 1));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        System.out.println("release:" + start + "-to:" + end);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
