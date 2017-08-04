package convertor;
import java.util.logging.Logger;


/**
 * @author ASHISH MURGAI
 *
 */
/**
 * @author ASHISH MURGAI
 *
 */
/**
 * @author ASHISH MURGAI
 *
 */
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

    /**
     * @param number
     * @return String
     * Method check for Whole number and normal number logic, basis which it puts the 
     * Words conversion logic accordingly from NumNames and Tens Names array accordingly.
     */
    private String convertNumber(int numbertoconvert) {
        String current;
        Logger.getLogger("Inside convertLessThanOneThousand number"+" " +numbertoconvert);
        Logger.getLogger("Before Calculation for "+" "+ (numbertoconvert % 100));
        
        if (numbertoconvert % 100 < 20){
        	Logger.getLogger("Inside < 20 if condition");
            current = numNames[numbertoconvert % 100];
            Logger.getLogger("Value for Current variable"+" "+current);
            numbertoconvert /= 100;
            Logger.getLogger("Value for number/100"+" "+(numbertoconvert));
        }
        else {
        	Logger.getLogger("Inside else condition");
            current = numNames[numbertoconvert % 10];
            Logger.getLogger("Value for Current variable"+" "+current);
            numbertoconvert /= 10;
            Logger.getLogger("Value for number/10"+" "+(numbertoconvert));
            current = tensNames[numbertoconvert % 10] + current;
            Logger.getLogger("After tensNames"+" "+(numbertoconvert % 10));
            numbertoconvert /= 10;
            Logger.getLogger("After number /= 10"+" "+(numbertoconvert));
        }
        Logger.getLogger("Final number variable value before return"+" "+numbertoconvert);
        Logger.getLogger("Final current variable value before return"+" "+current);
        if (numbertoconvert == 0) return current;
        return numNames[numbertoconvert] + " hundred" + " "+current;
    }
    
    /**
     * @param number
     * @return String
     * Contains the Main Logic for Conversion of number to Words. Checks for 
     * Negative number as well and converts the same.It calls convertNumber method which
     * converts checks for number as whole number or not and puts logic accordingly.
     * Finally it checks whether the number is converted and then concatinate everything.
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
                String s = convertNumber(n);
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
     	
    /**
     * This is a main thread method and takes String Array as argument.
     */
    public static void main(String[] args) {
    	NumberToWordsConvertor obj = new NumberToWordsConvertor();
    	
    		System.out.println("Input Parameter is"+" "+args[0]);
    	if(obj.isValid(args[0]))
    	{
    		System.out.println("####   " + obj.convert(Integer.parseInt(args[0])));
    	}
    	else 
    	{
    		System.out.println("Not a Valid Number Entered");
    		return;
    	}
    }
    
    /**
     * @param val
     * @return boolean
     * This method is a main validation method which is called once user inputs its choice 
     * It checks for Space,User entry as Alphanumeric,and max three digit check, since it is for 
     * max 999 number which it converts into words.
     */
    public boolean isValid(String val)
    {
    	if((val.charAt(0))=='-')
    	{
    		val=val.replace("-","");
    	}
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
    
    /**
     * @param str
     * @return boolean
     * Checks for Alphanumeric number and returns from the method.The NUmber should be
     * Digital and should not contain any alphanumeric character.
     */
    public boolean isAlphanumeric(String str) {
    	int counter=0;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            Logger.getLogger("Character at"+c);
            Logger.getLogger("Is Digital"+Character.isDigit(c));
            Logger.getLogger("Is Character"+Character.isLetter(c));
            if (Character.isDigit(c) && !Character.isLetter(c))
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