package com.my_rest.Test_another;

import java.util.Scanner;

public class Test3 {
    // Here first we need to find the vowels
    public static void vowel(String str){
        String lowercase = str.toLowerCase();
        for (int i=0;i<lowercase.length();i++){
            if ((lowercase.charAt(i) == 'a') || (lowercase.charAt(i)== 'e')
            || (lowercase.charAt(i)== 'i') || (lowercase.charAt(i)) == 'o' || (lowercase.charAt(i) == 'u') ){
                System.out.println(str.charAt(i));

            }
        }
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = myObj.nextLine();
        System.out.println("Username to vowel is :");
        vowel(username);
    }
}