/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercises;

/**
 *
 * @author user
 */

import java.util.Scanner;

public class SitchonQ2AAPE1 {
    public static void main(String[] args) {
        SitchonQ2AAPE1 x=new SitchonQ2AAPE1();
        
        String s=x.getString();
        String newS=x.removeAllPuncs(s);
        boolean isPalindrome=x.determinePalindrome(newS);
        
        if(isPalindrome) System.out.println(s+" is a palindrome");
        else System.out.println(s+" is not a palindrome");
    }
    
    public String getString(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter String: ");
        String s=scan.nextLine();
        return s;
    }
    
    public String removeAllPuncs(String s){
        s=s.replaceAll(" ", "");
        s=s.replaceAll("\\?", "");
        s=s.replaceAll("\\!", "");
        s=s.replaceAll("\\'", "");
        s=s.replaceAll("\\,", "");
        s=s.replaceAll("\\-", "");
        return s;
    }
    
    public boolean determinePalindrome(String s){
        boolean isPalindrome=true;
        int i=0;
        int j=s.length()-1;
        while(i<s.length()/2){
            if(s.charAt(i)!=s.charAt(j)){
                isPalindrome=false;
            }
            i++;
            j--;
        }
        return isPalindrome;
    }
}
