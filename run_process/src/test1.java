
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cuong
 */
public class test1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process proc = Runtime.getRuntime().exec("/home/cuong/app/jdk1.8.0_231/bin/javac");
        System.out.println(proc.waitFor());
        proc.waitFor();
        String line;
        BufferedReader error = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        while ((line = error.readLine()) != null) {
            System.out.println(line);
        }
        error.close();
        
        BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        while((line=input.readLine()) != null){
            System.out.println(line);
        }
    }
}
