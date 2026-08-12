package model;

public class MovimentoConta {

	private int codigoConta;
	private double valorMovimento;
	private int tipoMovimento;
	private int statusMovimento;
	
	
	public MovimentoConta() {
		
		this(0, 0.0, 0, 0);
	}
	
	MovimentoConta(int codigoConta, double valorMovimento, int tipoMovimento, int statusMovimento) {
		
		this.codigoConta = codigoConta;
		this.valorMovimento = valorMovimento;
		this.tipoMovimento = tipoMovimento;
		this.statusMovimento = statusMovimento;
		
	}
	
	
	public void setCodigo(int codigoConta) {
		
		this.codigoConta = codigoConta;
	}
	
	
	public void setValor(double valorMovimento) {
		
		this.valorMovimento = valorMovimento;
	}

	
	public void setTipo(int tipoMovimento) {
		
		this.tipoMovimento = tipoMovimento;
	}

	
	public void setStatus(int statusMovimento) {
		
		this.statusMovimento = statusMovimento;
	}

	
	public int getCodigo() {
		
		return this.codigoConta;
	}
	
	
	public int getTipo() {
		
		return this.tipoMovimento;
	}
	
	
	public Double getValor() {
		
		return this.valorMovimento;
	}
	
	public int getStatus() {
		
		return this.statusMovimento;
	}
}
