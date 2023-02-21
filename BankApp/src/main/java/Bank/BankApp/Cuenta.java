package Bank.BankApp;

public class Cuenta {
	
	private Cliente cliente;
	private Banks bank;
	private double saldo;
	
	
	
	
	
	
	
	public Cuenta(Cliente cliente, Banks bank, double saldo) {
		this.cliente = cliente;
		this.bank = bank;
		this.saldo = saldo;
	}
	
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Banks getBank() {
		return bank;
	}
	public void setBank(Banks bank) {
		this.bank = bank;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
