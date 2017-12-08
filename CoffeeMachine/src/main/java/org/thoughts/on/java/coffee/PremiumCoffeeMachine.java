package org.thoughts.on.java.coffee;

import java.util.Map;

public class PremiumCoffeeMachine extends BasicCoffeeMachine {

	public PremiumCoffeeMachine(Map<CoffeeSelection, CoffeeBean> beans) {
		// call constructor in superclass
		super(beans);

		// add configuration to brew espresso
		this.configMap.put(CoffeeSelection.ESPRESSO, new Configuration(8, 28));
	}

	private Coffee brewEspresso() {
		Configuration config = configMap.get(CoffeeSelection.ESPRESSO);

		// grind the coffee beans
		GroundCoffee groundCoffee = this.grinder.grind(
				this.beans.get(CoffeeSelection.ESPRESSO),
				config.getQuantityCoffee());

		// brew an espresso
		return this.brewingUnit.brew(CoffeeSelection.ESPRESSO, groundCoffee,
				config.getQuantityWater());
	}

	public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
		if (selection == CoffeeSelection.ESPRESSO)
			return brewEspresso();
		else
			return super.brewCoffee(selection);
	}
}
