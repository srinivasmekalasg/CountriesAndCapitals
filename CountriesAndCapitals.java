package com.main.countries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CountriesAndCapitals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		Map<String,String> countryMap = new HashMap<>();
	    String excelPath = "C:\\Apps\\countries\\countires.xlsx";
		String countryName = "MALAYSIA";
		try {
			//Get the country Map
			countryMap = readCountriesDataFromExcel(excelPath);
			//System.out.println("countryMap : "+ countryMap);
			
			String capital = getCountryCapital(countryMap, countryName);
			
			System.out.println("COUNTRY NAME:  "+countryName +"\n CAPITAL: "+ capital);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Map<String,String> readCountriesDataFromExcel(String excelPath) throws FileNotFoundException{
		Map<String,String> countryMap = new HashMap<>();
		Country country = new Country();
		try {
			FileInputStream file1 = new FileInputStream(new File(excelPath));
			 XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
	         // Get first sheet from the workbook
	         XSSFSheet sheet1 = workbook1.getSheetAt(0);
	         
	       // Get iterator to all the rows in current sheet1
	         Iterator<Row> rowIterator1 = sheet1.iterator();
	         while (rowIterator1.hasNext()) {
	             Row row = rowIterator1.next();
	             country=  readingCoutryDataFromRow(row);
	             countryMap.put(country.countryName, country.countryCapital);
	         }
	         workbook1.close();
	         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countryMap;
	}
	
	public static Country readingCoutryDataFromRow(Row row){
		Country country= new Country();
		//Cell cell=null;
		//System.out.println("row : "+row.toString());
		 Iterator<Cell> cellIterator = row.cellIterator();
		// Cell cell = cellIterator.next();
		 while (cellIterator.hasNext()) {
			// System.out.println("getColumnIndex : "+cell.getColumnIndex());
			 Cell cell = cellIterator.next();
			  switch (cell.getColumnIndex()) {
	            case 0:
	            	country.setCountryName(cell.getStringCellValue());
	            	break;
	            case 1:
	            	country.setCountryCapital(cell.getStringCellValue());
	            	break;
	            }
		 }
		return country;
	}
	
	public static String getCountryCapital(Map<String,String> countryMap,String countryName){
		String capital="";
		
		for (Map.Entry<String, String> country:countryMap.entrySet()){
			
			if (country.getKey().equals(countryName)){
				capital=country.getValue();
			}
		}
		// System.out.println("capital : "+capital);
		return capital;
	}

}
