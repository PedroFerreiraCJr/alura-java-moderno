package br.com.alura.java_8.capitulo_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Pedro

 * Os métodos default permitem que seja adiciona a uma interface um método com
 * implementação, ou seja, um método que tenha corpo (método concreto).
 *
 */
public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		// antes do Java 8, era necessário utilizar Collections
		//Collections.sort(palavras, comparador);
		palavras.sort(comparador);
		System.out.println(palavras);
		
		// antes do Java 8
//		for (String p : palavras) {
//			System.out.println(p);
//		}
		
		Consumer<String> consumer = new ImprimeNaLinha();
		palavras.forEach(consumer);
	}
}

// implementação de Comparator
class ComparadorPorTamanho implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}

class ImprimeNaLinha implements Consumer<String> {
	@Override
	public void accept(String value) {
		System.out.println(value);
	}
}
