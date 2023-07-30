package com;

import java.util.Scanner;

public class App {

    public static void main(String args[]){
        try {
            FileContext fc = new FileContext();
            
            Scanner sc= new Scanner(System.in); 
    		
    		System.out.println("Input file");
    		
    		String ip = sc.nextLine();
            //Read input file name
            String inputFilename = "/Users/zeelsatasiya/Downloads/CreditCard/src/com/" + ip;

            //Read the output file name
            System.out.println("Output file Name:");
    		
    		String op = sc.nextLine();
            
            String outputFilename = "/Users/zeelsatasiya/Downloads/CreditCard/src/com/out_file.json" + op;

            fc.parse(inputFilename, outputFilename);
        }catch(Exception e){
            System.out.print("Error: "+e);
        }
    }
}
