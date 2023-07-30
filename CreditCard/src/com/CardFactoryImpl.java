package com;

public class CardFactoryImpl implements CardFactory {
    public Card createCard(String card_number){

    	if(card_number.equals("")){
            return null;
        }
        try {
            long number = Double.valueOf(card_number).longValue();
            String value = Long.toString(number);
            if (value.length() <= 19) {

            	if(value.length() == 15) {
    	            if ((value.charAt(0) == '3') && (value.charAt(1) == '4' || value.charAt(1) == '7')) {
				    return new AmericanExpressCard(card_number);
				    }
				 }
                else if((value.length() == 16) && ((value.charAt(0) == '5') && (value.charAt(1) == '1' || value.charAt(1) == '2' || value.charAt(1) == '3' || value.charAt(1) == '4' || value.charAt(1) == '5'))) {
				    	return new MasterCard(card_number);
                } 
                else if((value.length() == 16) && (value.substring(0, 4).equals("6011"))) {
    	            	return new Discover(card_number);
    	           
                } 
                else if(value.length() == 13 || value.length() == 16) {
    	            if ((value.charAt(0) == '4') ) {
    	            	return new Visa(card_number);
    	            }
                }
                else {
                    return null;
                }
            }
            else {
            	return null;
            }
        }catch (Exception e) {
            return null;
        }
        return null;
    }
}
