package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BaseConfig {
		
	public static String getData(String value) throws Exception{
		
		
    String path ="/Users/waris/eclipse-workspace/Selenium-Automation-Framework/config.properties";//this location of config  file
		
	FileInputStream fis	=new FileInputStream(path);//Convert the file into stream 
	
	//now if i want read this file or data i need to bring properties  file.
	//so i need properties class 
	Properties pro =new Properties();
    pro.load(fis);
	
	//than i have make return value to  BaseConfig 
    
    return pro.get(value).toString();
	
	}



	public static void main(String[] args) throws Exception {
		
		System.out.println(getData("URL"));
	}
	}
	
