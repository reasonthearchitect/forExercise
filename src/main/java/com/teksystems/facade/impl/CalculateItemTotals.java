package com.teksystems.facade.impl;

import java.math.BigDecimal;

import com.teksystems.facade.ICalculateItemTotals;

/**
 * This is the placeholder class for candidates to add their calculation engine implementation.
 * 
 * Note that the candidate is recommended to keep all business logic outside of this file and instead simply wire in their own implementation.
 */
public class CalculateItemTotals implements ICalculateItemTotals {

	@Override
	public BigDecimal calculate(String sku) {
		return new BigDecimal(0.0);
	}
}
