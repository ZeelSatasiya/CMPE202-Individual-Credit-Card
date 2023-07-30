package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class AmericanExpressCardTest {

    @Test
    public void testAmExCardNumFormat() {
    	String cardNum = "3.41E+14";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("AmericanExpress", result);
    }

    @Test
    public void testAmExCardNumSecondDigit7(){
    	String cardNum = "371000000000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("AmericanExpress", result);
    }
    
    @Test
    public void testAmExCardNumSecondDigit4(){
    	String cardNum = "341000000000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("AmericanExpress", result);
    }
    
    @Test
    public void testAmExCardNumLengthmoreThan19(){
    	String cardNum = "3410000000000000000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: more than 19 digits", result);
    }
    
    @Test
    public void testNoAmericanExpNumber(){
    	String cardNum = "340000ff0000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: non numeric characters", result);
    }

    @Test
    public void testAmExCardNumLength(){
    	String cardNum = "3410000000000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: card number length wrong", result);
    }

   

    @Test
    public void testAmExCardNumWithSpecialChar(){
    	String cardNum = "37100000,000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: non numeric characters", result);
    }

    @Test
    public void testAmExCardNumWithSpace(){
    	String cardNum = "37100000  000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: non numeric characters", result);
    }
    
    @Test
    public void testAmExCardNumWithLeadingSpace(){
    	String cardNum = "  371000000000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: non numeric characters", result);
    }

    @Test
    public void testAmExCardNumWithOnlySpace(){
    	String cardNum = "   ";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: non numeric characters", result);
    }

    @Test
    public void testAmExCardNumWithFirstDigitNot3(){
    	String cardNum = "771000000000000";
        AmericanExpressCard ax = new AmericanExpressCard(cardNum);
        String result = ax.validateCardType(ax.getCardNum());
        assertEquals("Invalid: Not a possible card number", result);
    }

}