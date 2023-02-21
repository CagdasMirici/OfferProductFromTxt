package Bank.BankApp.Tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Bank.BankApp.Cuenta;
import Bank.BankApp.Banks;
import Bank.BankApp.Caixa;
import Bank.BankApp.Cliente;
import Bank.BankApp.Sabadell;
import Bank.BankApp.Santander;
import java.time.format.DateTimeFormatter;

public class Herramientas {
	
	
	
	
	public List<Cuenta> getDataFromTxt(String fileName){
		
		
		String[] dataList = null;
		List<Cuenta> accounts=new ArrayList<Cuenta>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		
		
	   	File file = new File("/Users/jcteb1/Desktop/EOI/BankApp/BankApp/"+fileName+".txt");
	   	
	   	
	   	
	   	
	   	Banks bank = null;
	   	        
	   	        BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(file));
						
						if ( fileName == "caixa") {
							
							
							bank = new Caixa(fileName);
							
						}
						else if (fileName == "sabadell") {
							
							
							bank = new Sabadell(fileName);
							
						}
						else if (fileName == "santander") {
							
							
							bank = new Santander(fileName);
							
						}
						
						
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
	   	 
	   	        String st = null;
	   	        
	   	        try {
						while ((st = br.readLine()) != null) {
	 	 
						    
							
							dataList = st.split(";"); 
							
						     String dni = dataList[0];
						     
						     String nombre = dataList[1];   
						  
						     LocalDate fechaNacimiento = LocalDate.parse(dataList[2], formatter);  
						    
						     String codigoPais = dataList[3];
						     
						     double saldo =Double.parseDouble(dataList[4]);
						     
						     
						     Cliente cliente = new  Cliente(dni,nombre,fechaNacimiento,codigoPais);
						     
						     accounts.add(new Cuenta(cliente,bank,saldo));
						     
						     
						    
						}
						
						
						     
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			
	   	    
	   	     return(accounts);
	     		
	 
	 
	     		
	     	}
	
	
		public List<String> getDataProduct(String fileName){
			
			List<String> data = new ArrayList();
			
			File file = new File("/Users/jcteb1/Desktop/EOI/BankApp/BankApp/"+fileName+".txt");
		        BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        String st;
		        try {
					while ((st = br.readLine()) != null)
 
					    data.add(st);
					    
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        return data;
		        
		    }
			
		
	
	
	
	

	}

