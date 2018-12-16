package io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author vons0
 */
public class ZipTest1 {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Users\\Documents\\Java\\owner-vons\\common");
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("C:\\Users\\vons0\\Desktop\\test.zip"));
        BufferedOutputStream outputStream = new BufferedOutputStream(zipOutputStream);
        zip(file, zipOutputStream, outputStream);
        zipOutputStream.close();
        outputStream.close();
    }

    public static void zip(File sourceFile, ZipOutputStream zipOutputStream, BufferedOutputStream outputStream) throws IOException {

        if (sourceFile == null) {
            return;
        }
        if (sourceFile.isFile()) {
            System.out.println("执行中....");
            System.out.println(sourceFile.getName());
            ZipEntry zipEntry = new ZipEntry(sourceFile.getAbsolutePath() + count++);
            zipEntry.setComment(sourceFile.getName());
            zipOutputStream.putNextEntry(zipEntry);
            BufferedReader inReader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
            String line;
            while ((line = inReader.readLine()) != null) {
                outputStream.write(line.getBytes());
//                zipOutputStream.write(line.getBytes());
            }
//            zipOutputStream.closeEntry();
            outputStream.flush();
            inReader.close();
        } else {
            File[] files = sourceFile.listFiles();
            //如果是空文件夹,保存空文件路径
            if (files == null || files.length == 0) {
                zipOutputStream.putNextEntry(new ZipEntry(sourceFile.getAbsolutePath()));
                zipOutputStream.closeEntry();
            } else {
                for (File file : files) {
                    sourceFile = file;
                    zip(sourceFile, zipOutputStream, outputStream);
                }
            }
        }
        System.out.println("执行完毕");
    }
}
