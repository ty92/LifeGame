package LifeGame;

/**
 * Created by Administrator on 2017/6/3.
 */
public class LifeGame {
	public int[][] getArray(int radnum) {
		if (radnum == 0)
			return null;
		int[][] array = new int[radnum][radnum];
		for (int i = 0; i < radnum; i++) {
			for (int j = 0; j < radnum; j++) {
				array[i][j] = ((int) (Math.random() * 10)) % 2;// radnum 即为 0或者1
			}
		}
		return array;
	}

	public void printArray(int[][] array) {
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 0)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}

	public int[][] getNextArray(int[][] array) {
		int tempArray[][];

		if (array == null)
			return null;

		// 构造中间细胞矩阵
		tempArray = getTempArray(array);

		int len = array.length;
		int[][] nextArray = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				nextArray[i][j] = getCellState(tempArray, i + 1, j + 1);
			}
		}
		return nextArray;
	}

	/*
	 * 创建临时细胞矩阵：在原矩阵外围边沿增加一圈，相当于比原矩阵行列大2 为的是，使得原数组每个节点都可以有8个节点，能够合法的使用数组形式计算
	 */
	public int[][] getTempArray(int[][] array) {
		int len = array.length;
		int[][] temp = new int[len + 2][len + 2];

		for (int i = 0; i < len + 2; i++) {
			for (int j = 0; j < len + 2; j++) {
				if (i == 0 || j == 0 || i == len + 1 || j == len + 1)
					temp[i][j] = 0;
				else
					temp[i][j] = array[i - 1][j - 1];
			}
		}

		return temp;
	}

	public int getCellState(int[][] array, int x, int y) {
		int count = 0, ret = 0;

		count += zeroOne(array[x - 1][y - 1]); // 上一行3个细胞
		count += zeroOne(array[x - 1][y]);
		count += zeroOne(array[x - 1][y + 1]);
		count += zeroOne(array[x][y - 1]); // 同行2个
		count += zeroOne(array[x][y + 1]);
		count += zeroOne(array[x + 1][y - 1]); // 下一行3个
		count += zeroOne(array[x + 1][y]);
		count += zeroOne(array[x + 1][y + 1]);

		/*
		 * 当前细胞周围有三个生细胞（为1），则其下一阶段为生； 有两个生，则下一阶段状态不变；其他情况，下一阶段均为死
		 */
		switch (count) {
		case 3:
			ret = 1;
			break;
		case 2:
			ret = array[x][y];
			break;
		default:
			ret = 0;
		}
		return ret;
	}

	/*
	 * 判断当前细胞生死
	 */
	public int zeroOne(int num) {
		return (num == 1) ? 1 : 0;
	}
}
