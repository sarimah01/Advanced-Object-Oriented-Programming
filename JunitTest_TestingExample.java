package lab2;

import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest_TestingExample {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	
	@Test
	public void test1() {
		double spentamount = 0;
		double creditlimit = 4000;
		int expected = -1;
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);
		
		assertEquals("The function should give 1800 points in this situation", 1800, TestingExample.RewardPoints(1100, 500));
	}
	
	@Test
	 public void test2() {
		double spentamount = 5000;
		double creditlimit = 4500;
		int expected = 1500; //if (spent amount - credit limit >= 500)
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give 1500 points in this situation", 1500, TestingExample.RewardPoints(5000, 4500));
		
	}
	@Test
	public void test3() {
		double spentamount = 1000; //spent amount - credit limit >= 100 && spent amount - credit limit <= 299)
		double creditlimit = 800;
		int expected = 200; //200
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give 200 points in this situation", 200, TestingExample.RewardPoints(1000, 800));
		
	}
	@Test
	public void test4() {
		double spentamount = 1000;
		double creditlimit = -100; //if credit limit is less than zero
		int expected = -1;
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give -1 points in this situation", -1, TestingExample.RewardPoints(1000, -100));
		
	}
	@Test 
	public void test5() {
		//if (spent amount - credit limit >= 300 && spent amount - credit limit <= 499)
		double spentamount = 1000;
		double creditlimit = 501; // upper limit
		int expected = 998;//499
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);
		

		assertEquals("The function should give 998 points in this situation", 998, TestingExample.RewardPoints(1000, 501));
		
	}

	@Test
	public void test6() {
		double spentamount = -100;// if spent amount is less than zero
		double creditlimit = 500;
		int expected = -1;
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give -1 points in this situation", -1, TestingExample.RewardPoints(-100, 500));
		
	}
	
	//if (spent amount - credit limit >= 300 && spent amount - credit limit <= 499)
	@Test
	public void test7() {
		double spentamount = 4500;// if spent amount - credit limit is greater than 300 but less than 499
		double creditlimit = 4150;//350
		int expected = 700;
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give 700 points in this situation", 700, TestingExample.RewardPoints(4500, 4150));
		
	}
	@Test
	public void test8() {
		double spentamount = 200;// if spent amount - credit limit is less than 100
		double creditlimit = 200;
		int expected = 0; //0
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give 0 points in this situation", 0, TestingExample.RewardPoints(200, 200));
		
	}
	@Test
	public void test9() {
		double spentamount = 200;// if spent amount- credit limit is equal to 100
		double creditlimit = 100;
		int expected = 100; //100
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give 0 points in this situation", 100, TestingExample.RewardPoints(200, 100));
		
	}
	@Test 
	public void test10() {
		//if (spent amount - credit limit >= 100 && spent amount - credit limit <= 299)
		double spentamount = 1000;
		double creditlimit = 701; //299
		int expected = 299;
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);
		

		assertEquals("The function should give 299 points in this situation", 299, TestingExample.RewardPoints(1000, 701));
		
	}
	@Test 
	public void test11() {
		//if (spent amount - credit limit >= 300 && spent amount - credit limit <= 499)
		double spentamount = 1000;
		double creditlimit = 700;//lower limit 300
		int expected = 600;
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);
		

		assertEquals("The function should give 600 points in this situation", 600, TestingExample.RewardPoints(1000, 700));
		
	}
	@Test
	public void test12() {
		double spentamount = 200;// if spent amount - credit limit is less than 100
		double creditlimit = 101;//99
		int expected = 0;
		
		int actual = TestingExample.RewardPoints(spentamount, creditlimit);

		assertEquals("The function should give 0 points in this situation", 0, TestingExample.RewardPoints(200, 101));
		
	}
	
}
