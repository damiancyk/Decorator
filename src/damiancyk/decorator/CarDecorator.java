package damiancyk.decorator;

import damiancyk.data.Car;
import damiancyk.decorator.utils.DecoratorTable;

public class CarDecorator extends DecoratorTable {

	Long id;
	String name;
	String carLink;

	public CarDecorator(Car bean) {
		this.id = bean.getId();
		this.name = bean.getName();
		this.carLink = getLink("car-" + bean.getId() + ".html", bean.getName());
	}

}
