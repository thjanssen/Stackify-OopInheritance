package org.thoughts.on.java.coffee;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCoffeeMachine {

	protected Map<CoffeeSelection, Configuration> configMap;
	
	public AbstractCoffeeMachine() {
		this.configMap = new HashMap<CoffeeSelection, Configuration>();
	}
	
	public abstract Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException;
}