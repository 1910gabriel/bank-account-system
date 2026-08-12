package view;

import model.ContaCorrente;
import model.MovimentoConta;
import controller.SistemaBanco;

import java.io.IOException;

import javax.swing.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContaCorrente[] conta = new ContaCorrente[3];
		
		for(int i = 0; i < 3; i++) {
			
			conta[i] = new ContaCorrente();
		}
		
		
		MovimentoConta[] movimento = new MovimentoConta[3];
		
		for(int i = 0; i < 3; i++) {
			
			movimento[i] = new MovimentoConta();
		}
		
		
		ContaCorrente[] contaAtualizada = new ContaCorrente[3];
		
		for(int i = 0; i < 3; i++) {
			
			contaAtualizada[i] = new ContaCorrente();
		}
		
		
		SistemaBanco banco = new SistemaBanco();
		
		int opc = 0;
		
		while(opc != 9){
		
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Conta Corrente \n2 - Cadastrar Movimentação \n3 - Gerar Contas Atualizadas \n4 - Consultar Cadastros \n9 - Fim"));
			
			switch(opc) {
			
				case 1:
					
					try {
						
						conta = banco.cadastroContas(conta);
						banco.gravarContas(conta);
						JOptionPane.showMessageDialog(null, "Contas cadastradas com sucesso!");
						break;
					
					}catch(IOException e) {
						
						System.out.println("Erro ao cadastrar o arquivo.");
						e.printStackTrace();
					}
					
					break;
					
					
				case 2:	
					
					try {
						
						movimento = banco.cadastroMovimentos(movimento, conta);
						banco.gravarMovimentacao(movimento);
						JOptionPane.showMessageDialog(null, "Movimentações gravadas com sucesso!");
						break;
						
					}catch(IOException e){
						
						System.out.println("Não foi possível cadastrar a movimentação.");
						e.printStackTrace();
					}
					
					break;
				
					
				case 3: 
					
					try {
						
						contaAtualizada = banco.atualizacaoContas(conta, movimento, contaAtualizada);
						banco.gravarAtualizacao(contaAtualizada);
						JOptionPane.showMessageDialog(null, "As contas foram atualizadas com sucesso!");
						break;
						
					}catch(IOException e) {
						
						JOptionPane.showMessageDialog(null, "Não foi possível cadastrar as contas atualizadas");
						e.printStackTrace();
					}
					
					break;
				
					
				case 4:
					
					try {
						
						banco.consulta(conta, movimento, contaAtualizada);
						break;
						
					}catch(Exception e) {
						
						JOptionPane.showMessageDialog(null, "Erro ao efetuar a consulta");
						e.printStackTrace();
					}
			
					break;
					
					
				default:
						
					JOptionPane.showMessageDialog(null, "Número inválido, por favor digite um número válido.");
			}		
		}
	}
}
