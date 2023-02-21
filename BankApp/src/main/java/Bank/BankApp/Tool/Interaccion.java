package Bank.BankApp.Tool;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Bank.BankApp.Cliente;
import Bank.BankApp.Cuenta;

public class Interaccion {
	
	Scanner sc = new Scanner(System.in);
	Ordenes or = new Ordenes();
	
	public void pantallaBienvenida() {
	
		
		
		System.out.print("Por favor inicia el numero de cif  /  Please enter your identification number: ");
		
		String cif = sc.nextLine();
		
		bienVenida(cif);
	
	}
	
	
	public void bienVenida(String cif) {
		
		
		
		LocalDateTime fecha = LocalDateTime.now();
    	
    	DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");  
     
        
        
        
    	
		
		String diHola = "Welcome ";
		
		Cliente cli = or.findCliente(cif);
		
		
		if (cli != null)
		{
			
			if (cli.getCodigoPais().equals("ES")) {
				
				diHola = "Bienvenida ";
		    	format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	
				
			}
			
			   String formatDateTime = fecha.format(format);
		    	
			
			System.out.println(diHola+or.findCliente(cif).getNombre());
			System.out.println(formatDateTime);
			
			or.fechaControl(cif);
			
			
			String producto = or.ofrecerProductoList(cif);
		
				
	    		if (or.ofrecerProductoList(cif) != null && cli.getCodigoPais().equals("ES"))
				{
					
					System.out.println("El producto ofrecido es: "+ or.ofrecerProductoList(cif));
					
				}
	    		else if (or.ofrecerProductoList(cif) != null && !cli.getCodigoPais().equals("ES"))
				{
					
					 	System.out.println("The product offered is: "+ or.ofrecerProductoList(cif));
					
				}
				else
				{
					
					System.out.println("no hay ningun producto para esta cliente / There is no product for this customer");
				
					
				}
				
				
			}
		else
		{
			System.out.println("No hay cuenta con numero de: "+ cif);
		}
		
	}
}