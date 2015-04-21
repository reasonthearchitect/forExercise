package com.teksystems.story.steps

import static org.junit.Assert.*

import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Named
import org.jbehave.core.annotations.Then

import com.teksystems.facade.ICalculateItemTotals
import com.teksystems.facade.impl.CalculateItemTotals

class SalesTaxSteps {
	
	ICalculateItemTotals calculateItemTotals = new CalculateItemTotals();
	
	BigDecimal itemCalculatedTotal;
	
	@Given("I order  <sku>")
	def "set up the initial balance"(@Named("sku") String sku) {
		this.itemCalculatedTotal = this.calculateItemTotals.calculate(sku);
	}

	@Then("the total cost for this item will be <total>")
	def "ensure the total is correct"(@Named("total") BigDecimal total) {
		assertTrue(this.itemCalculatedTotal == total);
	}
}
