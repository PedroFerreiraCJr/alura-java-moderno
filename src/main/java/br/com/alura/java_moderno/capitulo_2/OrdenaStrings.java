package br.com.alura.java_moderno.capitulo_2;

import java.util.ArrayList;
import java.util.List;

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
		
		/*
		 * Antes do Java 8
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String value) {
				System.out.println(value);
			}
		});
		*/
		
		// ordenação no Java 8+
		palavras.sort((String s1, String s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});
		
		// essa é a forma mais enxuta de implementar comparator de String utilizando length()
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.forEach(value -> System.out.println(value));
	}
}
