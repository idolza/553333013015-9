package com.rmuti.piority_queue;

import java.util.Arrays;

	public class Car implements Comparable {

		private String name;
		private String type;
		private int price;

	public Car(String name,String type,int price){
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public int compareTo(Object e) {
		 Car c = (Car) e;
		 if(this.price>c.price){
			 return 1;
		 }else if(this.price==c.price){
			return 0; 
		 }else {
			 return -1;
		 }

	}
	@Override
	public String toString() {
		return String.format("[Name = %s , Type = %s, Price = %d]\n",name,
				type, price);
	}
	
	public static void main(String[] args) {
		Car[] CarArrays = new Car[] {
				new Car("Ducati Monster 1200","Bigbike",899000),
				new Car("Ninja650","Bigbike",280000),
				new Car("Honda 1000rr","Bigbike",843000),};
				Arrays.sort(CarArrays);
				System.out.println("Bigbike Price");
				System.out.println(Arrays.toString(CarArrays)); 

	}

}
