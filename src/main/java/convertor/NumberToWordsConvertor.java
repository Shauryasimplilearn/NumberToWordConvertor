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
        Logger.getLogger("Inside convertLessThanOneThousand number"+" " +number);
        Logger.getLogger("Before Calculation for "+" "+ (number % 100));
        
        if (number % 100 < 20){
        	Logger.getLogger("Inside < 20 if condition");
            current = numNames[number % 100];
            Logger.getLogger("Value for Current variable"+" "+current);
            number /= 100;
            Logger.getLogger("Value for number/100"+" "+(number));
        }
        else {
        	Logger.getLogger("Inside else condition");
            current = numNames[number % 10];
            Logger.getLogger("Value for Current variable"+" "+current);
            number /= 10;
            Logger.getLogger("Value for number/10"+" "+(number));
            current = tensNames[number % 10] + current;
            Logger.getLogger("After tensNames"+" "+(number % 10));
            number /= 10;
            Logger.getLogger("After number /= 10"+" "+(number));
        }
        Logger.getLogger("Final number variable value before return"+" "+number);
        Logger.getLogger("Final current variable value before return"+" "+current);
        if (number == 0) return current;
        return numNames[number] + " hundred" + " "+current;
    }
    
    /**
     * @param number
     * @return String
     */
    public String convert(int number) {
    	Logger.getLogger("Inside Convert() Function"+" "+number);

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
            Logger.getLogger("Int number is"+" "+n);
            if (n != 0){
            	Logger.getLogger("Inside n!0 number"+" "+n);
                String s = convertLessThanOneThousand(n);
                Logger.getLogger("String S variable value is"+" "+s);
                Logger.getLogger("Value of Current variable value is"+" "+current);
                Logger.getLogger("Value of place variable value is"+" "+place);
                current = s + current;
            }
          number /= 1000;
        } while (number > 0);
        Logger.getLogger("Value of prefix variable value is"+"*****"+" "+prefix);
        Logger.getLogger("Value of prefix current value is"+"*******"+" "+current);
        return (prefix + current).trim();
    }
    
    public static void main(String[] args) {
    	NumberToWordsConvertor obj = new NumberToWordsConvertor();
    	
    		Logger.getLogger("ARGS[0] is"+" "+args[0]);
    	if(obj.isValid(args[0]))
    		Logger.getLogger("####   " + obj.convert(Integer.parseInt(args[0])));
    	else 
    		return;
    }
    
    public boolean isValid(String val)
    {
      	
    	if(!(val.trim()).equals("") && !isAlphanumeric(val.trim()) && Integer.parseInt(val)!=0 && val.trim().length()<=3)
        {
    		Logger.getLogger("Inside True Condition");
       		return true;
        }
        else
        {   
        	Logger.getLogger("Inside False Condition");
        	return false;
        }

    }
    
    public boolean isAlphanumeric(String str) {
    	int counter=0;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            Logger.getLogger("Character at"+c);
            Logger.getLogger("Is Digital"+Character.isDigit(c));
            Logger.getLogger("Is Character"+Character.isLetter(c));
            if (c=='-'|| Character.isDigit(c) && !Character.isLetter(c))
            {
            	counter++;
            	continue;
            }
                
        }
        Logger.getLogger("Value for Counter is"+counter);
        Logger.getLogger("Value for str is"+str.length());
        if(counter==str.length())
        	return false;
        else 
        	return true;
    }
}