package LifeGame;

import org.junit.Assert;
import org.junit.Test;

import LifeGame.LifeGame;

/**
 * Unit test for simple App.
 */
public class LifeGameTest {

	@Test
	public void testOne() throws Exception {
		int src[][] = { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } };
		int dest[][] = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		Assert.assertEquals(new LifeGame().getNextArray(src), dest);
	}

	@Test
	public void testTwo() throws Exception {
		int src[][] = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
		int dest[][] = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
		Assert.assertEquals(new LifeGame().getNextArray(src), dest);
	}

	@Test
	public void testThree() throws Exception {
		int src[][] = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
		int dest[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		Assert.assertEquals(new LifeGame().getNextArray(src), dest);
	}

}