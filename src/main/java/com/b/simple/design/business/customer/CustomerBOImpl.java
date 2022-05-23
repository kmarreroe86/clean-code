package com.b.simple.design.business.customer;

import java.math.BigDecimal;
import java.util.List;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public Amount getCustomerProductsSum(List<Product> products) throws DifferentCurrenciesException {

        if (products.size() == 0) return new AmountImpl(BigDecimal.ZERO, Currency.EURO);

        if (!allProductsHasSameCurrency(products)) throw new DifferentCurrenciesException();

        return calculateProductsSum(products);
    }

    private AmountImpl calculateProductsSum(List<Product> products) {
        Currency currency = products.get(0).getAmount().getCurrency();
        BigDecimal result = products.stream()
                .map(prod -> prod.getAmount().getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new AmountImpl(result, currency);
    }

    private boolean allProductsHasSameCurrency(List<Product> products) {
        Currency firstCurrency = products.get(0).getAmount().getCurrency();

        return products.stream()
                .map(p -> p.getAmount().getCurrency())
                .allMatch(currency -> currency.equals(firstCurrency));
    }
}



















