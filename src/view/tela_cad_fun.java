package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import control.Funcionario_Controler;

public class tela_cad_fun extends JDialog {
	JLabel labelNome, labelCPF, labelCargo, titulo;
	String[] cargoTeste = { "1", "2", "3" };
	JTextField nome;
	JFormattedTextField cpf;
	MaskFormatter mascaraCPF;
	JComboBox cargo;
	JButton cadastrar;

	public tela_cad_fun(Frame dono, boolean modal) {
		// geral (inicio)
		super(dono, "Cadastro de Funcion�rio", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());

		// defini��es
		labelNome = new JLabel("Nome:");
		labelCPF = new JLabel("CPF:");
		labelCargo = new JLabel("Cargo:");
		nome = new JTextField("");
		cargo = new JComboBox(cargoTeste);
		cargo.setMaximumRowCount(5);
		cargo.setEditable(false);
		cadastrar = new JButton("Cadastrar");
		titulo = new JLabel("Cadastro de Funcion�rio");
		titulo.setFont(new Font("Arial", Font.BOLD, 16));

		// m�scara CPF
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCPF.setPlaceholderCharacter('_');
		} catch (ParseException e) {
		}
		cpf = new JFormattedTextField(mascaraCPF);

		// setBounds
		titulo.setBounds(37, 15, 200, 20);
		labelNome.setBounds(15, 50, 50, 20);
		labelCPF.setBounds(15, 80, 50, 20);
		labelCargo.setBounds(15, 110, 50, 20);
		cadastrar.setBounds(10, 250, 244, 30);
		nome.setBounds(70, 50, 170, 20);
		cpf.setBounds(70, 80, 94, 20);
		cargo.setBounds(70, 110, 170, 20);

		// eventos
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Funcionario_Controler cFuncionario = new Funcionario_Controler();
				model.Funcionario func = new model.Funcionario();
				func.setCpf(Long.parseLong(cpf.getText().replace("_", "").replace(".", "").replace("-", "")));
				func.setNome(nome.getText());
				func.setFk_cargo(Integer.parseInt(""+cargo.getSelectedItem()));
				try {
					cFuncionario.save(func);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// add no Container
		tela.add(titulo);
		tela.add(labelNome);
		tela.add(labelCPF);
		tela.add(labelCargo);
		tela.add(cadastrar);
		tela.add(cpf);
		tela.add(nome);
		tela.add(cargo);

		// geral (final)
		setSize(270, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}

}
