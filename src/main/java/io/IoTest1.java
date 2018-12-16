package io;

import java.io.*;

/**
 * @author vons0
 */
public class IoTest1 {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\vons0\\Desktop\\test.txt")));
        out.writeInt(11);
        out.writeUTF("起风了");
        out.writeDouble(11.00);
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\vons0\\Desktop\\test.txt")));
        System.out.println(in.readInt());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        in.close();

        PrintWriter out2 = new PrintWriter(System.out, true);
        out2.println("我曾难自拔于世界之大");
    }
}
