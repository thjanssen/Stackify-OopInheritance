package org.thoughts.on.java.coffee;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestCoffeeMachine {

	@Test
	public void testEspresso() throws CoffeeException {
		// create a Map of available coffee beans
		Map<CoffeeSelection, CoffeeBean> beans = new HashMap<CoffeeSelection, CoffeeBean>();
		beans.put(CoffeeSelection.ESPRESSO, new CoffeeBean("My favorite espresso bean", 1000));
		beans.put(CoffeeSelection.FILTER_COFFEE, new CoffeeBean("My favorite filter coffee bean", 1000));
		
		// get a new CoffeeMachine object
		PremiumCoffeeMachine machine = new PremiumCoffeeMachine(beans);
		// brew a fresh coffee
		Coffee espresso = machine.brewCoffee(CoffeeSelection.ESPRESSO);
		
		Assert.assertEquals(CoffeeSelection.ESPRESSO, espresso.getSelection());
		Assert.assertEquals(28d, espresso.getQuantity(), 0.01);
	}
	
	@Test
	public void makeCoffee() throws CoffeeException {
		BasicCoffeeMachine coffeeMachine = createCoffeeMachine();	
		coffeeMachine.brewCoffee(CoffeeSelection.ESPRESSO);
	}
	
	private BasicCoffeeMachine createCoffeeMachine() {
		// create a Map of available coffee beans
		Map<CoffeeSelection, CoffeeBean> beans = new HashMap<CoffeeSelection, CoffeeBean>();
		beans.put(CoffeeSelection.ESPRESSO, new CoffeeBean("My favorite espresso bean", 1000));
		beans.put(CoffeeSelection.FILTER_COFFEE, new CoffeeBean("My favorite filter coffee bean", 1000));
		
		// instantiate a new CoffeeMachine object
		return new PremiumCoffeeMachine(beans);
	}
}
