package model;

public class ContaCorrente {

	private int codigo;
	private String nomeCliente;
	private double saldoConta;
	private double limiteConta;
	private int tipoConta;
	
	
	public ContaCorrente(){
		
		this(0, "", 0.0, 0.0, 0);
	}
	
	ContaCorrente(int codigo, String nomeCliente, Double saldoConta, Double limiteConta, int tipoConta){
		
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.saldoConta = saldoConta;
		this.limiteConta = limiteConta;
		this.tipoConta = tipoConta;
	}
	
	
	public void setCodigo(int codigo) {
		
		this.codigo = codigo;
	}
	
	
	public void setNome(String nomeCliente) {
		
		this.nomeCliente = nomeCliente;
	}
	
	
	public void setSaldo(Double saldoConta) {
		
		this.saldoConta = saldoConta;
	}


	public void setLimite(Double limiteConta) {
		
		this.limiteConta = limiteConta;
	}

	
	public void setTipo(int tipoConta) {
		
		this.tipoConta = tipoConta;
	}

	
	public int getCodigo() {
		
		return this.codigo;
	}
	
	
	public String getNome() {
		
		return this.nomeCliente;
	}
	
	
	public Double getSaldo() {
		
		return this.saldoConta;
	}
	
	
	public Double getLimite() {
		
		return this.limiteConta;
	}
	
	
	public int getTipo() {
		
		return this.tipoConta;
	}
}
