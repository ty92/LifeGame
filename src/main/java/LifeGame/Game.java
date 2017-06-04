package LifeGame;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {

	public static void main(String[] args) {
		LifeGame lifeGame = new LifeGame();
		int original[][];

		// 创建原始数组，并输出
		System.out.print("Please input Matrix row*col(row==col,only input one num): ");
		Scanner scanner = new Scanner(System.in);
		int arrayNum = scanner.nextInt();

		original = lifeGame.getArray(arrayNum);
		lifeGame.printArray(original);

		RunTask runTask = new RunTask();
		runTask.setLifeGame(lifeGame);
		runTask.setArray(original);

		Thread thread = new Thread(runTask);
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(thread, 1, 1, TimeUnit.SECONDS);
	}
}
