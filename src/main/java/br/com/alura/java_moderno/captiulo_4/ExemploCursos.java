package br.com.alura.java_moderno.captiulo_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.alura.java_moderno.captiulo_4.modelo.Curso;

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		// comparingInt recebe uma implementação de ToIntFunction<T>
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		// implementação utilizando Method Reference
		cursos.forEach(System.out::println);
		// implementação utilizando lambda expression
		cursos.forEach(c -> System.out.println(c.getNome()));
		System.out.println("-----------------------------------");
		
		cursos.stream()
			// filter recebe uma implementação de Predicate<T>
			.filter(c -> c.getAlunos() >= 50)
			// forEach recebe uma implementação de Consumer<T>
			.forEach(c -> System.out.println(c.getNome()));
		System.out.println("-----------------------------------");
		
		cursos.stream()
			// map recebe uma implementação de Function<T, R>
			.map(Curso::getNome)
			// forEach recebe uma implementação de Consumer<T>
			.forEach(System.out::println);
		System.out.println("-----------------------------------");
		
		cursos.stream()
			// filter recebe uma implementação de Predicate<T>
		   .filter(c -> c.getAlunos() > 50)
			// map recebe uma implementação de Function<T, R>
		   .map(Curso::getAlunos)
		   // forEach recebe uma implementação de Consumer<T>
		   .forEach(System.out::println);
		System.out.println("-----------------------------------");
		
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			// mapToInt retorna uma instância de IntStream
			.mapToInt(Curso::getAlunos)
			.sum();
		System.out.println(sum);
	}
}
