package performer;

import java.io.IOException;

import control.Funcionario_Controler;
import model.Funcionario;
import view.login;
import view.splash;

public class ApplicationStarter {
	public static void main(String[] args) throws IOException {
		splash loading = new splash(1);
		loading.iniciar();
		login inicio = new login();
	}
}
