package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarLookupService {
	
	float minPrice;
	float maxPrice;
	List<CarModel> models;
	List<Type> types;
	List<Color> colors;
	List<CarForSale> availableCars;
	public CarLookupService() {
		minPrice = 0.0f;
		maxPrice = Float.MAX_VALUE;
		models = new ArrayList<CarModel>();
		types = new ArrayList<Type>();
		colors = new ArrayList<Color>();
		availableCars = new ArrayList<CarForSale>();
	}
	
	public List<CarForSale> findCar(float minPrice, float maxPrice, List<Type> types, List<CarModel> models, List<Color> colors) {
		List<CarForSale> carForSales = new ArrayList<CarForSale>();
		for(CarForSale c: availableCars) {
			if(c.price <= maxPrice && c.price >= minPrice && types.contains(c.type) && colors.contains(c.color) && models.contains(c.model)) {
				carForSales.add(c);
			}
		}
		return carForSales;
	}
	
	public List<CarForSale> findCar() {
		float minPrice = this.minPrice;
		float maxPrice = this.maxPrice;
		List<CarModel> models = this.models;
		List<Type> types = this.types;
		List<Color> colors = this.colors;
		
		if(maxPrice <= minPrice) { return null;}
		if(models.size() == 0) {
			models.addAll(Arrays.asList(CarModel.values()));
		}
		if(types.size() == 0) {
			types.addAll(Arrays.asList(Type.values()));
		}
		return findCar(minPrice, maxPrice, types, models, colors);
	}
	
	public void setMinPrice(float price) { this.minPrice = price;}
	public void setMaxPrice(float price) { this.maxPrice = price;}
	public void addModel(CarModel model) { this.models.add(model);}
	public void removeModel(CarModel model) { if(models.contains(model)) this.models.remove(model);}
	public void addType(Type type) { this.types.add(type);}
	public void removeType(Type type) { if(types.contains(type)) this.types.remove(types);}
	public void addColor(Color color) { this.colors.add(color);}
	public void removeColor(Color color) { if(colors.contains(color)) this.colors.remove(color);}
}

enum CarModel {
	
	BMW, Audi, Mercedes, Toyota, Ford;
}

enum Color {
	Red, White, Black, Silver, Grey;
}

enum Type {
	Sedan, SUV, Convertible;
}

class CarForSale {
	float price;
	Type type;
	CarModel model;
	Color color;
	String name;
	public CarForSale(float price, Type type, CarModel model, String name, Color color) {
		this.price = price;
		this.type = type;
		this.model = model;
		this.color = color;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Name: "+ model+" "+name+ "\nType: "+ type+ "\nColor: "+ color+ "\nPrice: $"+ price;
	}
}