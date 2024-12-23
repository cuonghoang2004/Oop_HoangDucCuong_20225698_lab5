package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Phép nối chuỗi bằng String
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2); 
        }
        System.out.println("Time taken with String concatenation: " + (System.currentTimeMillis() - start) + "ms");
        
        System.out.println("Final String length: " + s.length());

        // Phép nối chuỗi bằng StringBuilder
        r = new Random(123); // Khởi tạo lại Random để kết quả giống nhau
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2)); // Thêm giá trị vào StringBuilder
        }
        String finalString = sb.toString();
        System.out.println("Time taken with StringBuilder: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Final String length (StringBuilder): " + finalString.length());
    }
}
