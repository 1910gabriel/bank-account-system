package controller;

import model.ContaCorrente;
import model.MovimentoConta;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class SistemaBanco {

	public ContaCorrente[] cadastroContas(ContaCorrente[] conta){
		
		for(int i = 0; i < 3; i++) {
			
			conta[i].setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o código da conta:")));
			
			conta[i].setNome(JOptionPane.showInputDialog("Código da Conta: "+conta[i].getCodigo()+"\n\nDigite o nome do cliente:"));
			
			conta[i].setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Código da conta: "+conta[i].getCodigo()+"\nCliente: "+conta[i].getNome()+"\n\nDigite o saldo da conta:")));
			
			conta[i].setLimite(Double.parseDouble(JOptionPane.showInputDialog("Código da conta: "+conta[i].getCodigo()+"\nCliente: "+conta[i].getNome()+"\n\nDigite o limite da conta:")));
			
			conta[i].setTipo(Integer.parseInt(JOptionPane.showInputDialog("Código da conta: "+conta[i].getCodigo()+"\nCliente: "+conta[i].getNome()+"\n\nTIPOS: \n1 - Física \n2 - Conjunta \n3 - Jurídica \n4 - Especial \n\nDigite o tipo da conta:")));
		
			while((conta[i].getTipo() < 1) || (conta[i].getTipo() > 4)) {
				
				conta[i].setTipo(Integer.parseInt(JOptionPane.showInputDialog("Tipo de conta inválido. \n\nCódigo da conta: "+conta[i].getCodigo()+"\nCliente: "+conta[i].getNome()+"\n\nTIPOS: \n1 - Física \n2 - Conjunta \n3 - Jurídica \n4 - Especial \n\nDigite o tipo da conta:")));
			}
		}
		
		ContaCorrente aux = null;
		
		for(int i = 0; i < 2; i++) {
			
			for(int j = i+1; j < 3; j++) {
				
				if(conta[i].getCodigo() > conta[j].getCodigo()) {
				
					aux = conta[j];
				
					conta[j] = conta[i];
				
					conta[i] = aux;
				}
			}
		}
		
		return conta;
	}
	
	
	public void gravarContas(ContaCorrente[] conta)throws IOException{
		
		String fileName = "Contas Correntes.txt";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
		for(int i = 0; i < 3; i++) {
			
			writer.write("Código da conta: " +(Integer.toString(conta[i].getCodigo())));
			writer.newLine();
			writer.newLine();
			writer.write("Nome do cliente: " +conta[i].getNome());
			writer.newLine();
			writer.newLine();
			writer.write("Saldo da conta: R$" +(Double.toString(conta[i].getSaldo())));
			writer.newLine();
			writer.newLine();
			writer.write("Limite da conta: R$" +(Double.toString(conta[i].getLimite())));
			writer.newLine();
			writer.newLine();
			writer.write("Tipo da conta: " +(Integer.toString(conta[i].getTipo())));
			writer.newLine();
			writer.write("-------------------------");
			writer.newLine();
			writer.newLine();
			writer.newLine();
		}
		
		writer.close();
	}
	
	
	public MovimentoConta[] cadastroMovimentos(MovimentoConta[] movimento, ContaCorrente[] conta) {
		
		for(int i = 0; i < 3; i++) {
			
			boolean verificacao = false;
				
			while(verificacao == false) {
					
				movimento[i].setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o código da conta: ")));
					
				int inicio = 0;
				int fim = (conta.length - 1);
				int meio;
						
				while(inicio <= fim) {
							
					meio = ((inicio + fim)/2);
							
					if(movimento[i].getCodigo() == conta[meio].getCodigo()) {
								
						verificacao = true;
								
						break;
					}
							
					else if(movimento[i].getCodigo() < conta[meio].getCodigo()) {
								
						fim = (meio - 1);
							
					}else {
								
						inicio = (meio + 1);
					}
							
				}
					
				if(verificacao == false) {
						
					JOptionPane.showMessageDialog(null, "O código de conta inserido é inválido, por favor clique em " + "Ok" + " e insira um código válido");
				}
			}
			
			movimento[i].setTipo(Integer.parseInt(JOptionPane.showInputDialog("Código da conta: " +movimento[i].getCodigo()+ "\n\nDigite o tipo da movimentação: \n\n1 - Crédito \n2 - Débito")));
			
			while((movimento[i].getTipo() < 1) || (movimento[i].getTipo() > 2)) {
				
				movimento[i].setTipo(Integer.parseInt(JOptionPane.showInputDialog("Tipo de movimento inválido." + "\n\nCódigo da conta: " +movimento[i].getCodigo()+ "\n\nDigite o tipo da movimentação: \n\n1 - Crédito \n2 - Débito")));
				
			}
			
			movimento[i].setValor(Double.parseDouble(JOptionPane.showInputDialog("Código da conta: " +movimento[i].getCodigo()+ "\n\nDigite o valor da movimentação (R$): ")));
			
			while(movimento[i].getValor() < 0.0) {
				
				movimento[i].setValor(Double.parseDouble(JOptionPane.showInputDialog("Por favor, digite um valor válido. \n\nCódigo da conta: " +movimento[i].getCodigo()+ "\n\nDigite o valor da movimentação (R$): ")));
			}
			
			movimento[i].setStatus(Integer.parseInt(JOptionPane.showInputDialog("Código da conta: " +movimento[i].getCodigo()+ "\n\nDigite o status do movimento (1 ou 2): ")));
		
			while((movimento[i].getStatus() < 1) || (movimento[i].getStatus() > 2)) {
				
				movimento[i].setStatus(Integer.parseInt(JOptionPane.showInputDialog("Status inválido, insira somente 1 ou 2.\n\nCódigo da conta: " +movimento[i].getCodigo()+ "\n\nDigite o status do movimento (1 ou 2): ")));
			}
		}
		
		MovimentoConta aux = null;
		
		for(int i = 0; i < (movimento.length - 2); i++) {
			
			for(int j = (i+1); j < (movimento.length - 1); j++) {
				
				if(movimento[i].getCodigo() > movimento[j].getCodigo()) {
					
					aux = movimento[j];
					
					movimento[j] = movimento[i];
					
					movimento[i] = aux;
				}
			}
		}
		
		return movimento;
	}
	
	
	public void gravarMovimentacao(MovimentoConta[] movimento) throws IOException{
		
		String fileName = "Movimentação de contas.txt";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
		for(int i = 0; i < movimento.length; i++) {
			
			writer.write("Código da conta: " +(Integer.toString(movimento[i].getCodigo())));
			writer.newLine();
			writer.newLine();
			writer.write("Tipo da movimentação (1- Crédito | 2-Débito): " +(Integer.toString(movimento[i].getTipo())));
			writer.newLine();
			writer.newLine();
			writer.write("Valor da movimentação: R$" +(Double.toString(movimento[i].getValor())));
			writer.newLine();
			writer.newLine();
			writer.write("Status da movimentação: " +(Integer.toString(movimento[i].getStatus())));
			writer.newLine();
			writer.write("-------------------------");
			writer.newLine();
			writer.newLine();
			writer.newLine();
			
		}
		
		writer.close();
	}
	
	
	public ContaCorrente[] atualizacaoContas(ContaCorrente[] conta, MovimentoConta[] movimento, ContaCorrente[] contaAtualizada) {
			
		int i;
		
		for(i = 0; i < conta.length; i++) {
			
			int inicio = 0;
			int fim = (conta.length - 1);
			int meio;
			
			while(inicio <= fim) {
				
				meio = ((inicio + fim)/2);
				
				if(movimento[i].getCodigo() == conta[meio].getCodigo()) {
					
					if(movimento[i].getStatus() == 1) {
						
						contaAtualizada[i] = conta[meio];
						break;
						
					}else {
						
						if(movimento[i].getTipo() == 1) {
							
							contaAtualizada[i] = conta[meio];
							
							contaAtualizada[i].setSaldo((conta[meio].getSaldo() + movimento[i].getValor()));							
							break;
							
						}else {
							
							if((conta[meio].getSaldo() >= movimento[i].getValor()) || (conta[meio].getTipo() == 1)) {
								
								contaAtualizada[i] = conta[meio];
								
								contaAtualizada[i].setSaldo((conta[meio].getSaldo()) - (movimento[i].getValor()));
								break;
								
							}else {
								
								contaAtualizada[i] = conta[meio];
								
								if(contaAtualizada[i].getTipo() == 2) {
									
									double valor = ((contaAtualizada[i].getSaldo() - movimento[i].getValor()) + contaAtualizada[i].getLimite());
									
									contaAtualizada[i].setSaldo(valor);
									break;
								}
								
								else if(contaAtualizada[i].getTipo() == 3) {
									
									double valor = (contaAtualizada[i].getSaldo() - movimento[i].getValor());
								
									valor = (valor + (contaAtualizada[i].getLimite() + (contaAtualizada[i].getSaldo() * 0.5)));
									
									contaAtualizada[i].setSaldo(valor);
									break;
									
								}else {
									
									double valor = (contaAtualizada[i].getSaldo() - movimento[i].getValor());
									
									valor = (valor + (contaAtualizada[i].getLimite() + contaAtualizada[i].getSaldo()));
									
									contaAtualizada[i].setSaldo(valor);
									break;
								}
								
							}
						}
					}
				}
				
				else if(movimento[i].getCodigo() < conta[meio].getCodigo()) {
					
					fim = (meio - 1);
				
				}else {
					
					inicio = (meio + 1);
				}
			}
		}
		
		contaAtualizada[i - 1] = conta[i - 1];
		
		return contaAtualizada;
		
	}
	
	
	public void gravarAtualizacao(ContaCorrente[] contaAtualizada) throws IOException {;
		
		JOptionPane.showMessageDialog(null, "Method required");
		
		String fileName = "Contas Atualizadas.txt";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
		for(int i = 0; i < contaAtualizada.length; i++) {
			
			writer.write("Código da conta: " +(Integer.toString(contaAtualizada[i].getCodigo())));
			writer.newLine();
			writer.newLine();
			writer.write("Nome do cliente: " +contaAtualizada[i].getNome());
			writer.newLine();
			writer.newLine();
			writer.write("Saldo da conta: R$" +(Double.toString(contaAtualizada[i].getSaldo())));
			writer.newLine();
			writer.newLine();
			writer.write("Limite da conta: R$" +(Double.toString(contaAtualizada[i].getLimite())));
			writer.newLine();
			writer.newLine();
			writer.write("Tipo da conta: " +(Integer.toString(contaAtualizada[i].getTipo())));
			writer.newLine();
			writer.write("-------------------------");
			writer.newLine();
			writer.newLine();
			writer.newLine();
		}
		
		writer.close();
	}
	
	
	public void consulta(ContaCorrente[] conta, MovimentoConta[] movimento, ContaCorrente[] contaAtualizada) {
		
		int opc = 0;
		
		while(opc != 9) {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("CONSULTA \n\n1- Consultar Contas Correntes \n\n2-Consultar Movimentação \n\n3- Consultar Contas Atualizadas \n\n9- FIM"));
			
			switch(opc) {
			
				case 1:
					
					for(int i = 0; i < conta.length; i++) {
						
						JOptionPane.showMessageDialog(null, "Código da conta: " +conta[i].getCodigo()+ "\nNome do cliente: " +conta[i].getNome() +"\nSaldo da conta: " +conta[i].getSaldo() +"\nLimite da conta: " +conta[i].getLimite() +"\nTipo da conta: " +conta[i].getTipo());
					}
					
					break;
			
					
				case 2:
					
					for(int i = 0; i < conta.length; i++) {
						
						JOptionPane.showMessageDialog(null, "Código da conta: " +movimento[i].getCodigo()+ "\nTipo do movimento: " +movimento[i].getTipo() +"\nValor do movimento: " +movimento[i].getValor() +"\nStatus do movimento: " +movimento[i].getStatus());
					}
					
					break;
					
					
				case 3:	
					
					for(int i = 0; i < conta.length; i++) {
						
						JOptionPane.showMessageDialog(null, "Código da conta: " +conta[i].getCodigo()+ "\nNome do cliente: " +conta[i].getNome() +"\nSaldo da conta: " +conta[i].getSaldo() +"\nLimite da conta: " +conta[i].getLimite() +"\nTipo da conta: " +conta[i].getTipo());
					}
					
					break;
					
					
				case 9:
					
					break;
				
					
				default:
					
					JOptionPane.showMessageDialog(null, "Número inválido, por favor digite um número válido.");
			}
		}
	}

}
