package com.zhoujie;

import junit.framework.TestCase;

public class TestRegularExpression extends TestCase{

    @Override
    protected void setUp() throws Exception {
      super.setUp();

    }

    @Override
    protected void tearDown() throws Exception {
      super.tearDown();
    }
    
    public final void testValidateDigit(){
        assertEquals(true, RegularExpression.validateDigit("1212"));
        assertEquals(false, RegularExpression.validateDigit("9955555d"));
        assertEquals(false, RegularExpression.validateDigit(" "));
        assertEquals(false, RegularExpression.validateDigit("mmm"));
        
    }

    public final void testValidateNDigits(){
        assertEquals(true, RegularExpression.validateNDigits("1212", 4));
        assertEquals(false, RegularExpression.validateNDigits("1212", 3));
        assertEquals(false, RegularExpression.validateNDigits(" ", 1));
        assertEquals(false, RegularExpression.validateNDigits("995d", 4));
    }

    public final void testValidateMinNDigits(){
        assertEquals(false, RegularExpression.validateMinNDigits("1212", 5));
        assertEquals(true, RegularExpression.validateMinNDigits("1212", 4));
        assertEquals(true, RegularExpression.validateMinNDigits("1212", 3));
        assertEquals(false, RegularExpression.validateMinNDigits(" ", 1));
        assertEquals(false, RegularExpression.validateMinNDigits("995d", 4));
    }

    public final void testValidateMNDigits(){
        assertEquals(true, RegularExpression.validateMNDigits("1212", 1, 4));
        assertEquals(true, RegularExpression.validateMNDigits("1212", 1, 5));
        assertEquals(false, RegularExpression.validateMNDigits("1212", 1, 3));
        assertEquals(false, RegularExpression.validateMNDigits(" ", 1, 4));
        assertEquals(false, RegularExpression.validateMNDigits("995d", 1, 3));
    }
    
    public final void testValidatePositiveInteger(){
        assertEquals(false, RegularExpression.validatePositiveInteger("1d212"));
        assertEquals(true, RegularExpression.validatePositiveInteger("1212"));
        assertEquals(false, RegularExpression.validatePositiveInteger("-1212"));
        assertEquals(false, RegularExpression.validatePositiveInteger("0"));
        assertEquals(false, RegularExpression.validatePositiveInteger("995d"));
    }

}
