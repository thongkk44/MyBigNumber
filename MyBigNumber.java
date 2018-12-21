/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author HuyThong
 * Trong class có một hàm là hàm sumtnum.
 */
public class MyBigNumber {
    /** 
     * 
     * Cộng các số từ hai chuôi. 
     * Không giới hạn độ dài hai chuỗi.
     * 
     */
    
    public String sumtnum(final String nu1, final String nu2) {
        // Xử lý hai hàm chuỗi 
        // Tạo biến final
        String step = "";// Chuỗi step sẽ làm tham số cho hàm send của interface
        String command = "";       
        int num1;        // Số của char1 ở vị trí index1
        int num2;        // Số của char2 ở trị ví index2        
        int total;    // Tổng tạm của số thứ nhất và số thứ hai;
        
        int cong;       // Biến nhớ nếu tổng tạm < 10                
        int nho = 0;    // Biến nhớ nếu total >= 10   
        
        int index1;     // Vị trí đang chạy của số thứ 1
        int index2;     // Vị trí đang chạy của số thứ 2
        
        char char1;     // kí tự vị trí 1 của chuỗi số thứ nhất
        char char2;     // kí tự vị trí 2 của chuỗi số thứ hai
        
        int len1 = nu1.length();// Độ dài của số thứ 1
        int len2 = nu2.length();// Độ dài của số thứ 2
        int nho2=0;
        int maxLen = (len1 > len2) ? len1 : len2; // Tìm độ dài của 2 số
        String resultfi = ""; // Hiển thị chuỗi đáp án của cộng 2 số        
        int j = 1;
        final String array = "\\d+"; // Chuỗi đại diện cho kí tự số từ [0-9]
        final boolean lt1;           // Lưu dữ kết quả xét chuỗi s1 
        final boolean lt2;           // Lưu dữ kết quả xét chuỗi s2
        //        
        // Lặp số lần của chuỗi dài nhất
        //
        for (int i = 0; i < maxLen; i++) {
            index1 = len1 - i - 1; //index1 của chuỗi 1
            index2 = len2 - i - 1; //index2 của chuỗi 2

            char1 = (index1 >= 0) ? nu1.charAt(index1) : '0'; //Ký tự char1 ở vị trí i
            char2 = (index2 >= 0) ? nu2.charAt(index2) : '0'; //Ký tự char2 ở vị trí i

            num1 = char1 - '0'; //Bảng mã ASCII chữ thứ nhất vị trí số char1
            num2 = char2 - '0'; //Bảng mã ASCII chữ thứ hai vị trí số char2

            total = num1 + num2 + nho; // Tổng cộng 2 số thứ nhất và số thứ 2 
            cong = num1 + num2; // Cộng tổng hai số

            resultfi = (total % 10) + resultfi; // Lấy số vừa tính gán vào biến resultfi
            nho = total / 10; //Biến nhớ
            if (i == 0) {
                command = "Bước " + j + " : lấy " + num1 + " cộng " + num2 + " được " + cong 
                    + " , " + " ghi " + (total % 10) + " , " + " nhớ " + nho + ", kết quả : " + resultfi + "\n";
            } else if (i == (maxLen - 1) && total >= 10) {
                command = "Bước " + j + " : lấy " + num1 + " cộng " + num2 + " cộng " + nho 
                    + " được " + total + " , " + "ghi " + (total % 10) + " , " + "nhớ " + nho + ", kết quả : 1" + resultfi + "\n";
            } else {
                command = "Bước " + j + " : lấy " + num1 + " cộng " + num2 + " cộng " + nho2 
                    + " được " + total + " , " + "ghi " + (total % 10) + " , " + "nhớ " + nho + ", kết quả : " + resultfi + "\n";
            }
            nho2 = nho;
            step = step + command;
            j++;
        }        
        //  
        //Nếu có biến nhớ ghép thêm biến nhớ vào phía trước đáp án
        //
        if (nho > 0) {
            resultfi = nho + resultfi; // Cộng số nhớ ở vị trí index = 1 
        }
        
        if (nu1.contains("-")) {
            resultfi ="Không hỗ trợ số âm !";
        }
        if (nu2.contains("-")) {
            resultfi ="Không hỗ trợ số âm !";
        }
        
        lt1 = nu1.matches(array);
        lt2 = nu2.matches(array);
        if (!lt1) {
            resultfi ="Vui lòng không nhập chữ hoặc ký tự đặt biệt !";
        }
        if (!lt2) {
            resultfi ="Vui lòng không nhập chữ hoặc ký tự đặt biệt !";
        }
        
        System.out.println(step);
        return resultfi;
    } 
}

