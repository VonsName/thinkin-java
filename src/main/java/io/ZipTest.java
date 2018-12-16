package io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @author vons0
 */
public class ZipTest {

    public static void main(String[] args) throws IOException {

        //读取文件并压缩
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\Users\\Documents\\Java"))));
        //CheckedOutputStream
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new CheckedOutputStream(new FileOutputStream("C:\\Users\\vons0\\Desktop\\test.gz"), new Adler32()));
        BufferedOutputStream outputStream = new BufferedOutputStream(gzipOutputStream);
//        int c;
//        while ((c = reader.read()) != 0) {
//            outputStream.write(c);
//        }
        BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(outputStream));
        String s;
        while ((s = reader.readLine()) != null) {
            bufferedWriter1.write(s);
            bufferedWriter1.newLine();
        }
        reader.close();
        bufferedWriter1.close();

        //解压缩文件并重新写出
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("C:\\Users\\vons0\\Desktop\\test.gz"))));
        String line;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\vons0\\Desktop\\gz.txt"));
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();

        //zip压缩
        ZipOutputStream zipOutputStream = new ZipOutputStream(new CheckedOutputStream(new FileOutputStream("C:\\Users\\vons0\\Desktop\\test.zip"), new Adler32()));
        ZipEntry zip = new ZipEntry("啊啊啊");
        zip.setComment("zip测试机");
        zipOutputStream.putNextEntry(zip);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
        bufferedOutputStream.write("aa".getBytes());
        bufferedOutputStream.close();

        //解压缩zip1
        ZipInputStream zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream("C:\\Users\\vons0\\Desktop\\test.zip"), new Adler32()));
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);

        //解压缩zip2
        ZipFile zipFile = new ZipFile("C:\\Users\\vons0\\Desktop\\test.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()){
            ZipEntry zipEntry = entries.nextElement();
            System.out.println(zipEntry);
        }
    }
}
