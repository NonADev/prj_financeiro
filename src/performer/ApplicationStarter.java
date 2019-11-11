package performer;

import java.io.IOException;

import control.Funcionario_Controler;
import model.Funcionario;

public class ApplicationStarter {
	public static void main(String[] args) throws IOException {
		Funcionario f = new Funcionario();
		f.setBanco_Horas(13);
		f.setCarga_horaria(45);
		f.setCpf(45454545);
		f.setNome("edinelson perera");
		f.setSalario(10000);
		f.setFk_cargo(3);
		f.setBanco_Horas(45);
		f.setCarga_horaria(40);
		f.setDependentes(1);
		Funcionario_Controler c = new Funcionario_Controler();
		c.save(f);
		Funcionario[] li = c.getAll();
		for(Funcionario fi : li) {
			fi.printAllCamps_funcionario(fi);
		}
	}
}
