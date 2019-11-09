package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Caixa_Controler {
	public void save(Double valor_caixa) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("./caixa.txt"));
		writer.write(""+valor_caixa);
		writer.close();
	}
	public Double read() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("./caixa.txt"));
		Double returnStatement = Double.parseDouble(reader.readLine());
		reader.close();
		return returnStatement;
	}
}
