package com.teksystems.facade;

import java.math.BigDecimal;

/**
 * Interface to calculate an items sales tax and import duty. This interface is used by the JBehave stories.
 */
public interface ICalculateItemTotals {
	
	/**
	 * Method to calculate an items sales tax and import duty.
	 * 
	 * @param sku - The SKU of the item being ordered.
	 * @return - The calculated results.
	 */
	BigDecimal calculate(String sku);
}
