package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tela_cad_cargo extends JDialog{
	
	JButton cadastrar;
	JLabel titulo;

	public tela_cad_cargo(Frame dono, boolean modal) {
		//geral (inicio)
		super(dono, "Cadastro de Cargo", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());
		
		//definições
		cadastrar = new JButton("Cadastrar");
		titulo = new JLabel("Cadastro de Cargo");
		titulo.setFont(new Font("Arial", Font.BOLD, 16));
		
		//setBounds
		titulo.setBounds(59, 15, 200, 20);
		cadastrar.setBounds(10, 250, 244, 30);
		
		//eventos
		cadastrar.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		               //inserir metodo cadastrar
		            }
		         }
		);
		
		//add no Container
		tela.add(titulo);
		tela.add(cadastrar);
		
		//geral (final)
		setSize(270, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}
}
