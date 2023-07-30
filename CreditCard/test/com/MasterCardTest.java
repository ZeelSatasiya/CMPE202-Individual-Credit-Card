package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class MasterCardTest {

    @Test
    public void testValidateMasterCardType() {
        MasterCard mc = new MasterCard("5.41E+15");
        String result = mc.validateCardType("5.41E+15");
        assertEquals("MasterCard", result);
    }

    @Test
    public void testValidMasterCardType() {
        MasterCard mc = new MasterCard("5410000000000000");
        String result = mc.validateCardType("5410000000000000");
        assertEquals("MasterCard", result);
    }
    
    @Test
    public void testSecondDigitNotInclusiveOneToFive(){
        MasterCard mc = new MasterCard("5.61E+15");
        String result = mc.validateCardType("5.61E+15");
        assertEquals("Invalid: Not a possible card number", result);
    }

    @Test
    public void testNullMasterCardNumber(){
        MasterCard mc = new MasterCard("");
        String result = mc.validateCardType("");
        assertEquals("Invalid: empty/null card number", result);
    }

    @Test
    public void testMasterCardNumberWithWhiteSpaces(){
        MasterCard mc = new MasterCard("  ");
        String result = mc.validateCardType("  ");
        assertEquals("Invalid: non numeric characters", result);
    }
    
    @Test
    public void testMasterCardNumberWithGreaterThan19(){
        MasterCard mc = new MasterCard("5410000000000000000000000");
        String result = mc.validateCardType("5410000000000000000000000");
        assertEquals("Invalid: more than 19 digits", result);
    }

    @Test
    public void testMasterCardNumberNot16(){
        MasterCard mc = new MasterCard("541000000000");
        String result = mc.validateCardType("541000000000");
        assertEquals("Invalid: card number length wrong", result);
    }

    @Test
    public void testMasterCardNumberWithSpecialCharacters(){
        MasterCard mc = new MasterCard("541000000+000000");
        String result = mc.validateCardType("541000000+000000");
        assertEquals("Invalid: non numeric characters", result);
    }

    @Test
    public void testMasterCardNumberWithCharacter(){
        MasterCard mc = new MasterCard("541000000v000000");
        String result = mc.validateCardType("541000000v000000");
        assertEquals("Invalid: non numeric characters", result);
    }
}