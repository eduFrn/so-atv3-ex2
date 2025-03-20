package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread{

	private Semaphore semaphore;
	private int id;
	
	public ThreadCorredor(int id, Semaphore semaphore) {
		this.id = id;
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		correr();
		try {
			semaphore.acquire();
			cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
			passou();
		}
	}
	
	private void correr() {
		
		int distanciaPercorrida = 0;
		int velocidade = (int)(Math.random()*3)+4;
		
		while(distanciaPercorrida < 200) {
			distanciaPercorrida+=velocidade;
			try {		
				System.out.println("Faltam "+(200-distanciaPercorrida)+" metros até o corredor #"+id+" alcançar a porta!");
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void cruzar() {
		System.out.println("O corredor #"+id+" está abrindo e cruzando pela porta...");
		int tempo = (int)(Math.random()*1001)+1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void passou() {
		System.out.println("O corredor #"+id+" cruzou a porta.");
	}
}
