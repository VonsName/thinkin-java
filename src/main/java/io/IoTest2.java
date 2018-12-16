package io;

import java.io.*;

/**
 * @author vons0
 * 将标准输入输出重定向到了文件
 */
public class IoTest2 {

    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\vons0\\Desktop\\test.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\vons0\\Desktop\\out.txt")));
        //将标准输入流重定向到BufferedInputStream
        System.setIn(in);
        //将标准输出流重定向到BufferedOutputStream
        System.setOut(out);
        //将保准错误输出流重定向到BufferedOutputStream
        System.setErr(out);
        String s;
        //System.in已经被重定向到BufferedInputStream
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while ((s = reader.readLine()) != null) {
            //System.out以及被重定向到BufferedOutputStream
            System.out.println(s);
        }
        out.close();
        Test.test();
    }

    static class Test {
        public static void test() throws IOException {
            Process process = new ProcessBuilder("javap IoTest2").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("======" + reader.readLine());
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("getErrorStream======" + reader1.readLine());
        }
    }
}
