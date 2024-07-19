/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import app.model.NhanVien;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class Constant {

    public static final int saltRoundPassword = 10;

    public static final boolean checkDoDaiCuaChuoi(String inputString) {
        if (inputString.length() < 3 || inputString.length() > 50) {
            return false;
        } else {
            return true;
        }
    }
    
    
      public static final boolean isValidEmail(String email) {
        // Biểu thức chính quy để kiểm tra định dạng email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Tạo Pattern object
        Pattern pattern = Pattern.compile(regex);
        
        // Tạo Matcher object
        Matcher matcher = pattern.matcher(email);
       
        // Kiểm tra xem email có khớp với biểu thức chính quy không
        return matcher.matches();
    }
    
    public  static final boolean isValidPhoneNumber(String phoneNumber) {
        // Biểu thức chính quy kiểm tra số điện thoại ở Việt Nam
        String regex = "0\\d{9,10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    public  static NhanVien NHAN_VIEN = null;
    
        
}
