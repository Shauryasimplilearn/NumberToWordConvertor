package convertor;
import java.util.logging.Logger;


/**
 * @author ASHISH MURGAI
 *
 */
public class NumberToWordsConvertor  
{
    
    private static final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    
    private static final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };

    private String convertLessThanOneThousand(int number) {
        String current;
        System.out.println("Inside convertLessThanOneThousand number"+" " +number);
        System.out.println("Before Calculation for "+" "+ (number % 100));
        
        if (number % 100 < 20){
        	System.out.println("Inside < 20 if condition");
            current = numNames[number % 100];
            System.out.println("Value for Current variable"+" "+current);
            number /= 100;
            System.out.println("Value for number/100"+" "+(number));
        }
        else {
        	System.out.println("Inside else condition");
            current = numNames[number % 10];
            System.out.println("Value for Current variable"+" "+current);
            number /= 10;
            System.out.println("Value for number/10"+" "+(number));
            current = tensNames[number % 10] + current;
            System.out.println("After tensNames"+" "+(number % 10));
            number /= 10;
            System.out.println("After number /= 10"+" "+(number));
        }
        System.out.println("Final number variable value before return"+" "+number);
        System.out.println("Final current variable value before return"+" "+current);
        if (number == 0) return current;
        return numNames[number] + " hundred" + " "+current;
    }
    
    /**
     * @param number
     * @return String
     */
    public String convert(int number) {
    	System.out.println("Inside Convert() Function"+" "+number);

        if (number == 0) { return "zero"; }
        
        String prefix = "";
        
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        
        String current = "";
        int place = 0;
        
        do {
            int n = number % 1000;
            System.out.println("Int number is"+" "+n);
            if (n != 0){
            	System.out.println("Inside n!0 number"+" "+n);
                String s = convertLessThanOneThousand(n);
                System.out.println("String S variable value is"+" "+s);
                System.out.println("Value of Current variable value is"+" "+current);
                System.out.println("Value of place variable value is"+" "+place);
                current = s + current;
            }
          number /= 1000;
        } while (number > 0);
        System.out.println("Value of prefix variable value is"+"*****"+" "+prefix);
        System.out.println("Value of prefix current value is"+"*******"+" "+current);
        return (prefix + current).trim();
    }
    
    public static void main(String[] args) {
    	NumberToWordsConvertor obj = new NumberToWordsConvertor();
    	
    		System.out.println("ARGS[0] is"+" "+args[0]);
    	if(obj.isValid(args[0]))
    		System.out.println("####   " + obj.convert(Integer.parseInt(args[0])));
    	else 
    		return;
    }
    
    public boolean isValid(String val)
    {
      	
    	if(!(val.trim()).equals("") && !isAlphanumeric(val.trim()) && Integer.parseInt(val)!=0 && val.trim().length()<=3)
        {
    		System.out.println("Inside True Condition");
       		return true;
        }
        else
        {   
        	System.out.println("Inside False Condition");
        	return false;
        }

    }
    
    public boolean isAlphanumeric(String str) {
    	int counter=0;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            System.out.println("Character at"+c);
            System.out.println("Is Digital"+Character.isDigit(c));
            System.out.println("Is Character"+Character.isLetter(c));
            if (c=='-'|| Character.isDigit(c) && !Character.isLetter(c))
            {
            	counter++;
            	continue;
            }
                
        }
        System.out.println("Value for Counter is"+counter);
        System.out.println("Value for str is"+str.length());
        if(counter==str.length())
        	return false;
        else 
        	return true;
    }
}