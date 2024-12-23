package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "C:\Users\cuong\Downloads\OOP_20225679_Lab05-main\OOP_20225679_Lab05-main\OtherProjects\src\hust\soict\dsai\garbage\\file.exe";
        byte[] inputBytes;
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            // Bắt đầu đo thời gian thực hiện
            startTime = System.currentTimeMillis();

            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            // Kết thúc đo thời gian thực hiện
            endTime = System.currentTimeMillis();
            System.out.println("Execution time: " + (endTime - startTime) + " ms");
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi đọc file
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            System.err.println("Reason: " + e.getMessage());
        }
    }
}
