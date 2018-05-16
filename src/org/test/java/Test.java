package org.test.java;

class test1 {
	void v1() {
		System.out.println("abc");
	}
}
public class Test extends test1
{
	
		void v1() {
		System.out.println("xyz");
	}

	public void v2() {
		System.out.println("xyz");
	}

	public static void main(String[] args) {
		test1 t = new Test();
		t.v1();
		
		
	}

}
