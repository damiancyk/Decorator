package damiancyk.test;

import java.util.ArrayList;

import damiancyk.data.Car;
import damiancyk.decorator.CarDecorator;
import damiancyk.decorator.utils.Decorator;

public class Test {

	public static void main(String[] args) {
		ArrayList<Car> saxophones = new ArrayList<Car>();
		for (long i = 0; i < 10; i++) {
			Car saxophone = new Car(i, "");
			saxophones.add(saxophone);
		}

		String json = Decorator.getJson(saxophones, CarDecorator.class);
		System.out.println(json);
	}

}
