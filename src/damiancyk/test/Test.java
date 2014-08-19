package damiancyk.test;

import java.util.ArrayList;

import damiancyk.data.Car;
import damiancyk.decorator.CarDecorator;
import damiancyk.decorator.utils.Decorator;

public class Test {

	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<Car>();
		for (long i = 0; i < 10; i++) {
			Car car = new Car(i, "car" + i);
			cars.add(car);
		}

		String json = Decorator.getJson(cars, CarDecorator.class);
		System.out.println(json);
	}

}
