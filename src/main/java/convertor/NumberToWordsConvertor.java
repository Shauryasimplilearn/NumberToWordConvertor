package convertor;
import java.util.logging.Level;
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
    static Logger logger = Logger.getLogger(NumberToWordsConvertor.class.getName()); 
    
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
          
        if (numbertoconvert % 100 < 20){
            current = numNames[numbertoconvert % 100];
            numbertoconvert /= 100;
        }
        else {
            current = numNames[numbertoconvert % 10];
            numbertoconvert /= 10;
            current = tensNames[numbertoconvert % 10] + current;
            numbertoconvert /= 10;
        }
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
            if (n != 0){
                String s = convertNumber(n);
                 current = s + current;
            }
          number /= 1000;
        } while (number > 0);
        return (prefix + current).trim();
    }
     	
    /**
     * This is a main thread method and takes String Array as argument.
     */
    public static void main(String[] args) {
    	NumberToWordsConvertor obj = new NumberToWordsConvertor();
    	
    	logger.log(Level.INFO, "Input Parameter is"+args[0]);
    	if(obj.isValid(args[0]))
    	{
    		logger.log(Level.INFO,"####      "+obj.convert(Integer.parseInt(args[0])));
    		logger.log(Level.INFO, "Successful Conversion");
    	}
    	else 
    	{
    		logger.log(Level.INFO, "Not a Valid Number");
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
       		return true;
        }
        else
        {   
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
            if (Character.isDigit(c) && !Character.isLetter(c))
            {
            	counter++;
            	continue;
            }
                
        }
        if(counter==str.length())
        	return false;
        else 
        	return true;
    }
}