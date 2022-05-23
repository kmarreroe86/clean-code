package com.b.simple.design.business.customer;

import java.math.BigDecimal;
import java.util.*;

import org.junit.jupiter.api.Test;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;
import com.b.simple.design.model.customer.ProductImpl;
import com.b.simple.design.model.customer.ProductType;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerBOTest {

    private CustomerBO customerBO = new CustomerBOImpl();

    private final Random rand = new Random();

    @Test
    public void testCustomerProductSum_TwoProductsSameCurrencies()
            throws DifferentCurrenciesException {

        // Given
        List<Product> products = Arrays.asList(
                getProduct(new AmountImpl(new BigDecimal("5.0"), Currency.EURO), ProductType.BANK_GUARANTEE),
                getProduct(new AmountImpl(new BigDecimal("6.0"), Currency.EURO), ProductType.BANK_GUARANTEE)
        );

        // When
        Amount temp = customerBO.getCustomerProductsSum(products);

        // Then
        assertEquals(Currency.EURO, temp.getCurrency());
        assertEquals(new BigDecimal("11.0"), temp.getValue());
    }

    @Test
    public void calculateProductSumWithDifferentCurrenciesShouldThrowDifferentCurrenciesException() {

        // Given
        List<Product> products = Arrays.asList(
                getProduct(new AmountImpl(new BigDecimal("5.0"), Currency.INDIAN_RUPEE), ProductType.BANK_GUARANTEE),
                getProduct(new AmountImpl(new BigDecimal("6.0"), Currency.EURO), ProductType.BANK_GUARANTEE));

        // Then
        assertThrows(DifferentCurrenciesException.class,
                () -> customerBO.getCustomerProductsSum(products));
    }

    @Test
    public void calculateCustomerProductSumWithEmptyProductListShouldReturnAmountWithZeroAndEuro()
            throws DifferentCurrenciesException {

        List<Product> products = new ArrayList<Product>();

        Amount amountExpected = customerBO.getCustomerProductsSum(products);

        assertEquals(Currency.EURO, amountExpected.getCurrency());
        assertEquals(BigDecimal.ZERO, amountExpected.getValue());
    }

    private Product getProduct(Amount amount, ProductType productType) {

        Product p = new ProductImpl(rand.nextLong(), UUID.randomUUID().toString(), productType, amount);

        return p;
    }

}