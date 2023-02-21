package Bank.BankApp.Tool;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import Bank.BankApp.Cliente;
import Bank.BankApp.Cuenta;

public class Ordenes {
	Herramientas hr = new Herramientas();
	Scanner scan = new Scanner(System.in);
	public List<Cuenta> cuentas = new ArrayList<Cuenta>();
	DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

	
	public Ordenes() { 
		
	
		String[] BankNames = {"caixa","sabadell","santander"};
    	
    	Herramientas hr = new Herramientas();
    	for (String name : BankNames)
    	{    		
    		
    		 cuentas.addAll( hr.getDataFromTxt(name));
        		
    	}
	
	}
	

	public List<Cuenta> getCuentaCif(String cif) {
		
		List<Cuenta> cuentaCif = new ArrayList <Cuenta>();
		
		
		
		
		for (Cuenta cuenta : cuentas){
			
			if (cif.equals(cuenta.getCliente().getDni())) {
				
				cuentaCif.add(cuenta);
				
			}
			
		}
		
		
		return cuentaCif;

		
	}
	
	public Cliente findCliente(String cif) {
		
		if (!getCuentaCif(cif).isEmpty() )
		{
			return getCuentaCif(cif).get(0).getCliente();	
		}
		
			return null;
	
		
	}
	
	public void fechaControl(String cif) {
		List<Cuenta> li =getCuentaCif(cif);
		List <LocalDate> masDeUnFechaNacimiento = null;
		if (getCuentaCif(cif).size() > 1) {
			
			LocalDate primeraFecha = li.get(0).getCliente().getFechaNacimiento();
			
			
			
			for (Cuenta time  : li)
			{
				
				
					if (primeraFecha.toString().equals(time.getCliente().getFechaNacimiento().toString())) 
					{
						
						
						if (time.getCliente().getCodigoPais().equals("ES")) {
							
							System.out.println("Hemos encontrado mas de una fecha de nacimiento. Por favor elige uno...");
							format = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
						}
						else {
							

							System.out.println("There is more than one date of birth! Please choose one...");
							format = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
							
						}
						int contador = 1;
						
						for (Cuenta fecha : li) {
							
							System.out.println(contador+"-->"+fecha.getCliente().getFechaNacimiento().format(format));
							contador++;
							
						}
						System.out.print("Sellect: ");
						
						int sellect = scan.nextInt();
						
						for( int i = 0 ; i < contador-1; i++)	
						{
							
							li.get(i).getCliente().setFechaNacimiento(li.get(sellect-1).getCliente().getFechaNacimiento());
							
						}
						
						
						
					}
						
						break;
						
				}
					
				for (Cuenta x : li)
				{
					
					System.out.println(x.getCliente().getNombre()+"-----"+x.getBank().getName()+"-----"+x.getCliente().getFechaNacimiento());
					
					
				}
				
			}
			
			
			
			
			
			
		}
		
	
	public double encontrarEdad(String cif)
	{
		
		List<Cuenta> cu = getCuentaCif(cif);
	
		for(Cuenta x : cu )
		{
			
			long difference = ChronoUnit.YEARS.between( x.getCliente().getFechaNacimiento(), LocalDate.now() );
			
			return difference;
			
		}
		return 0;
	}
	
	
	public double totalSaldo(String cif) {
		double total = 0;
		List<Cuenta> cu = getCuentaCif(cif);
		
		for(Cuenta x : cu) {
			
			total += x.getSaldo();
			
		}
		return total;
		
	}
	
	
	
	public String ofrecerProductoList(String cif){
		
		List <String> data = hr.getDataProduct("productosofertados");
		String[] dataArr = null;
    	List <String> productPosible = new ArrayList<String>();
    	Double min = Double.MIN_VALUE;
    	String oferta = null;
    	List<Cuenta> cu = this.getCuentaCif(cif);
    	String respuesta = null;
    	for ( String x : data) {
    		
    		dataArr = x.split(";"); 
    		
    		int minEdad = Integer.parseInt(dataArr[0]);
    		int maxEdad = Integer.parseInt(dataArr[1]);
    		double minSaldo = Double.parseDouble(dataArr[2]);
    		double maxSaldo = Double.parseDouble(dataArr[3]);
    		String producto = dataArr[4];
    		
    		
   
    		
    		if((this.totalSaldo(cif) > minSaldo) && (this.totalSaldo(cif) < maxSaldo) && (this.encontrarEdad(cif) > minEdad) && (this.encontrarEdad(cif) < maxEdad))
    		{
    			
    			
    			if ( maxSaldo > min) {
    		        min = maxSaldo;
    		        oferta = producto;
    		    }
    		
    		}
    		
    				
    		
    		}
    	
    		
		    	
				
				
		    		
		    		return oferta;
		
	}
	
	
	
	
	
	
	}
	
	
	
	

