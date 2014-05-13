package constructor;

import java.util.Arrays;

import constructor.Sneijder;

public class Sneijder {
	private String name;
	private String position;
	private String friend[];
	public Sneijder() {
		name = "Wesley Sneijder";
		position = "AMC";
		friend = new String[]{"1.Klaas-Jan Huntelaar","\t2.John Heitinga","\t3.Rafael van der Vaart"};
	}
	public Sneijder(int a) {
		System.out.println("Sneijder Overloading 1");
	}
	public String getName(){			
		return name;		
	}
	public String getPosition(){			
		return position;		
	}
	public String[] getFriend(){			
		return friend;		
	}

	public static void main(String[] args) {
		Sneijder Sneijder = new Sneijder();
		System.out.println("name : "+Sneijder.getName());
		System.out.println("position : "+Sneijder.getPosition());
		System.out.println("friend : "+Arrays.toString(Sneijder.getFriend()));
		new Sneijder(1);

}
}
