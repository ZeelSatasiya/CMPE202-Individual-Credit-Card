package com;

public class MasterCard extends Card {
	String card_num;
    public MasterCard(String card_number) {
        super(card_number);
        this.card_num = card_number;
    }
    
    public String getCardNum() {
		return this.card_num;
	}
    
    @Override
    String validateCardType(String card_number) {
    	if(card_number.equals("") ){
            return "Invalid: empty/null card number";
        }
    	if(card_number.charAt(0) == ' ') {
    		return "Invalid: non numeric characters";
    	}
        try {
            long number = Double.valueOf(card_number).longValue();
            String value = Long.toString(number);
            if(value.length() == 16) {
	            if ((value.charAt(0) == '5') && (value.charAt(1) == '1' || value.charAt(1) == '2' || value.charAt(1) == '3' || value.charAt(1) == '4' || value.charAt(1) == '5')) {
	                return "MasterCard";
	            }
	            else {
	            	return "Invalid: Not a possible card number";
	            }
            }
            else if(card_number.length() > 19) {
            		return "Invalid: more than 19 digits";
            }
            else {
            		return "Invalid: card number length wrong";
            }
        }catch(Exception e){
            return "Invalid: non numeric characters";
        }
    }
    
    
}


