package br.com.alura.java_moderno.captiulo_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author Pedro
 * 
 *         Os métodos default permitem que seja adiciona a uma interface um
 *         método com implementação, ou seja, um método que tenha corpo (método
 *         concreto).
 *
 */
public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		/*
		 * Antes do Java 8 palavras.forEach(new Consumer<String>() {
		 * 
		 * @Override public void accept(String value) { System.out.println(value); } });
		 */

		// ordenação no Java 8+
		/*
		 * palavras.sort((String s1, String s2) -> { if (s1.length() < s2.length())
		 * return -1; if (s1.length() > s2.length()) return 1; return 0; });
		 */

		// essa é a forma mais enxuta de implementar comparator de String utilizando
		// length()
//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		// essa instrução tem a mesma função da instrução de cima
		palavras.sort(Comparator.comparing(s -> s.length()));

		// essa instrução tem a mesma função da instrução de cima
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);

		// outra possibilidade seria não utilizar a expressão lambda
		Function<String, Integer> anon = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		Comparator<String> comparador2 = Comparator.comparing(anon);
		palavras.sort(comparador2);

		// utilizando Method Reference, ficaria assim
		palavras.sort(Comparator.comparing(String::length));

		Function<String, Integer> methodRef = String::length;
		palavras.sort(Comparator.comparing(methodRef));

//		palavras.forEach(value -> System.out.println(value));
		
		palavras.forEach(System.out::println);
	}
}
