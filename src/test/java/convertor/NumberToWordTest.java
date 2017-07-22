package convertor;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Scanner;


public class NumberToWordTest extends TestCase
{
	NumberToWordsConvertor numberconvert = new NumberToWordsConvertor();
	
    public NumberToWordTest( String testName )
    {
    	super( testName );
        System.out.println("Inside test suit");
    }
    
    public void testForZero() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="0";
    	System.out.println("Inside testForZero()");
    	assertFalse(numberconvert.isValid(args[0]));
    	System.out.println("Exiting");
    }

     public void testForLengthGreaterthan3() throws Exception
    {
    	String args[]=new String[1];
    	args[0] = "7658";
    	System.out.println("Inside testForLengthGreaterthan3()");
    	assertFalse(numberconvert.isValid(args[0]));
    }
    
    public void testForAlphanumeric() throws Exception
    {
    	String args[]=new String[1];
    	args[0] = "abc";
    	System.out.println("Inside testAlphanumeric()");
    	assertFalse(numberconvert.isValid(args[0]));
    }
    
    public void testForNumberToWord() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="768";
    	System.out.println("Inside testAlphanumeric()");
    	assertTrue(numberconvert.isValid(args[0]));
    }    
    
    public void testForNumberToWordconvertMethod() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="zero";
    	System.out.println("Inside testAlphanumeric()");
    	Assert.assertEquals(args[0], numberconvert.convert(0));
    }    
    
    public void testForNumberToWordconvertNegative() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="negative ninety five";
    	System.out.println("Inside testAlphanumeric()");
    	Assert.assertEquals(args[0], numberconvert.convert(-95));
    }    
    
    public void testForNumberToWordconvertthreeDigit() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="nine hundred  ninety five";
    	System.out.println("Inside testAlphanumeric()");
    	Assert.assertEquals(args[0], numberconvert.convert(995));
    }
    
    public void testForNumberToWordconverttwoDigit() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="eighty five";
    	System.out.println("Inside testAlphanumeric()");
    	Assert.assertEquals(args[0], numberconvert.convert(85));
    }
    
    public void testForNumberToWordconvertoneDigit() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="eight";
    	System.out.println("Inside testAlphanumeric()");
    	Assert.assertEquals(args[0], numberconvert.convert(8));
    }
           
}
