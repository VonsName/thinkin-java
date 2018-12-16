package io;

import java.io.*;
import java.net.URI;
import java.nio.file.Paths;

/**
 * @author vons0
 */
public class IoTest {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\vons0\\Desktop\\test.txt");
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream("HELLO".getBytes()));
        //dataInputStream.available() 返回可读的字符个数
        while (dataInputStream.available() != 0) {
            System.out.println((char) dataInputStream.readByte());
        }
//        dataInputStream.readInt();
//        dataInputStream.readByte();

        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file));
        outputStream.writeInt(1);

        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        int read = reader.read();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        bufferedInputStream.readAllBytes();
        bufferedInputStream.mark(1);
        bufferedInputStream.reset();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        bufferedReader.readLine();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader1.readLine()) != null) {
            System.out.println(line);
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        bufferedWriter.write("");
        bufferedWriter.newLine();


        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))), true);
        printWriter.println(1);
        printWriter.flush();
        printWriter.close();

        //相当于把DataInputStream和DataOutInputStream结合起来使用
        RandomAccessFile r = new RandomAccessFile(file, "r");
        //获取当前文件指向的位置
        r.getFilePointer();
        User user = new User();
        System.out.println(user);

        StringReader hello = new StringReader("HELLO");
        int c;
        while ((c = hello.read()) != -1) {
            System.out.printf("%s\n", (char) c);
        }

    }
}
