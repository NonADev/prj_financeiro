package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import control.Funcionario_Controler;
import model.Funcionario;

public class tela_con_nome extends JDialog {

	JLabel titulo;
	JTextField pesquisa;
	JButton acao;
	JList lista;
	

	public tela_con_nome(Frame dono, boolean modal) {

		// geral (inicio)
		super(dono, "Consulta por Nome", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());

		// defini��es
		pesquisa = new JTextField("");
		acao = new JButton("Consultar");
		String[] teste = {""};
		lista = new JList();
		lista.setVisibleRowCount(5);
		JScrollPane rolagem = new JScrollPane(lista);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		titulo = new JLabel("Consulta por Nome");
		titulo.setFont(new Font("Arial", Font.BOLD, 16));

		// setBounds
		titulo.setBounds(59, 15, 200, 20);
		pesquisa.setBounds(38, 50, 200, 20);
		acao.setBounds(85, 80, 100, 20);
		rolagem.setBounds(20, 125, 234, 125);

		// eventos
		acao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Funcionario_Controler fc = new Funcionario_Controler();
				try {
					model.Funcionario[] f = fc.getAll();
					for(int i=0;i<f.length;i++) {
						DefaultListModel li = (DefaultListModel) lista.getModel();
						li.addElement(f[i].getCpf());
						lista = new JList(li);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});

		// add no container
		tela.add(pesquisa);
		tela.add(acao);
		tela.add(rolagem);
		tela.add(titulo);

		// geral (final)
		setSize(280, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}

}
