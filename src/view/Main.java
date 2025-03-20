package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;

public class Main {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		
		
		for (int i = 0; i < 4; i++) {
			Thread corredor = new ThreadCorredor(i, semaphore);
			corredor.start();
		}

	}

}
