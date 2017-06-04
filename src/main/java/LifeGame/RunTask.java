package LifeGame;

public class RunTask implements Runnable {
	private int[][] temp;
	private int[][] array;
	private LifeGame lifeGame = null;

	public void setLifeGame(LifeGame lifeGame) {
		this.lifeGame = lifeGame;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}

	public void run() {
		temp = lifeGame.getNextArray(array);
		lifeGame.printArray(temp);
		setArray(temp);
	}
}