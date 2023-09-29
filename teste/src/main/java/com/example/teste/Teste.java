package com.example.teste;

import java.util.ArrayList;
import java.util.List;


public class Teste {
	
//	@Autowired
//	private CondominioController cd;
	
//	@Scheduled(fixedRate = 1000)
//	public void inicia(ModelMap model){
//		CondominioController cd = new CondominioController();
//		cd.listagem(model);
//	}
	

	private List<Integer> numbers;

	public Teste() {
		numbers = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			numbers.add(i);
		}
	}

	public void addNumber(int number) {
		if (numbers.contains(number)) {
			numbers.remove(Integer.valueOf(number));
		}
		numbers.add(2 * number - 1);
		numbers.add(2 * number);
	}

	public void printOrder() {
		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Teste order = new Teste();
		order.printOrder();

		order.addNumber(2);
		order.printOrder();

		order.addNumber(5);
		order.printOrder();
	}
}