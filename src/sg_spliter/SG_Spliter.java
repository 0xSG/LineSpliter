/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg_spliter;

import java.util.StringTokenizer;
import javax.swing.JFrame;

/**
 *
 * @author sooryagangarajk
 */
public class SG_Spliter {///// S G K /////
    
    static String gotString="";
    static String token="";
    static String outString="";
    static StringTokenizer st;
    static void setStingValue(String str){
        gotString =str;
        System.out.println("setStingValue");
        
    }
     static void setTokenValue(String str){
        token =str;
        System.out.println("setTokenValue");
        
    }
    
    static String getStringValue (){
        System.out.println("getStringValue");
        return outString;
    }
    /**
     * @param args the command line arguments
     */
    static void processFn() throws InterruptedException{
        System.out.println("processFn");
        if(!gotString.isEmpty()&&!token.isEmpty()){
           // return;
        }
        st = new StringTokenizer(gotString,token);
        
        boolean tokenFirst=false;
        boolean tokenLast=false;
        int counter=0;
        for(int cnt=0;cnt<token.length();cnt++){
            
            if(token.charAt(cnt)==gotString.charAt(cnt)){
                counter++;
                if(counter==token.length()){
                    tokenFirst=true;
                counter=0;
                }
            }
            else{
                tokenFirst=false;
                break;
            }
                
        }
        counter=0;
        int j=gotString.length()-1;
        for(int cnt=token.length()-1;cnt>=0;cnt--,j--){
            
            if(token.charAt(cnt)==gotString.charAt(j)){
                     counter++;///// S G K /////

                if(counter==token.length()){
                    tokenLast=true;
                counter=0;
                }
            }
            else{
                tokenLast=false;
                break;
            }
        }
        System.out.println("First:"+tokenFirst+"Last:"+tokenLast);
        if(tokenFirst){
            outString+=token;
        }
        
        int count=st.countTokens(),i=0;
        while(st.hasMoreTokens()&&i<count){
        outString+=st.nextToken();
        System.out.println(outString);
        i++;
        try{
        Thread.sleep(30);}catch(Exception er){
            
        }
        if(i<count){
             outString+="\n"+token;
        }
        }
        if(tokenLast){
            outString+="\n"+token;
            
        }
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NF nf=new NF();
        nf.setAlwaysOnTop(true);
        nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nf.setVisible(true);
        // TODO code application logic here
    }
    
}
