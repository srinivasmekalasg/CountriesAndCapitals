package com.srini.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountryCapitals {
    public static void main(String[] args) {
		Map<String,String> ctryMap =new HashMap<>();
		//Simple way to get the contries - Hardcoding values to MAP
		//ctryMap.put("SINGAPORE", "SINGAPORE");
		//ctryMap.put("INDIA", "NEW DELHI");
		//ctryMap.put("JAPAN", "TOKYO");
		//ctryMap.put("MALAYSIA", "K.LUMPUR");
		
		String inputFilePath= "C:\\app\\data\\CountryList.txt";
		try {
			ctryMap=getCtryMap(inputFilePath);
		String ctry="INDIA";
		System.out.println("CAPITAL OF "+ctry+" IS "+getCapitalOfCountrt(ctryMap,ctry));
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
    
    public static  String getCapitalOfCountrt( Map<String,String> ctryMap, String ctry){
    	String capital="";
    	if(ctryMap.containsKey(ctry)){
    		capital=ctryMap.get(ctry);
    	}
    	return capital;
    }
  public static Map<String,String>  getCtryMap(String inputFilePath) throws FileNotFoundException{
	  Map<String,String> ctryMap =new HashMap<>();
	  File file = new File(inputFilePath);
	  String line = "";
	  String[] crtyArry = null;
		try (BufferedReader br= new BufferedReader(new FileReader(file))){
			while((line=br.readLine())!=null){
				crtyArry=line.split(",");
				ctryMap.put(crtyArry[0], crtyArry[1]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ctryMap;
  }

}