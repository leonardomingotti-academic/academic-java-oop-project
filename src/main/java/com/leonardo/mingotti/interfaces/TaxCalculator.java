package com.leonardo.mingotti.interfaces;

import java.math.BigDecimal;

public interface TaxCalculator {
    BigDecimal tax(BigDecimal amount);
}