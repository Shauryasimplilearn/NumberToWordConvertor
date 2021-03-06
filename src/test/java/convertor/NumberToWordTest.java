package convertor;
import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.logging.Logger;



public class NumberToWordTest extends TestCase
{
	NumberToWordsConvertor numberconvert = new NumberToWordsConvertor();
	
    public NumberToWordTest( String testName )
    {
    	super( testName );
    }
    
    public void testForZero() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="0";
    	assertFalse(numberconvert.isValid(args[0]));
    	Logger.getLogger("Exiting");
    }

     public void testForLengthGreaterthan3() throws Exception
    {
    	String args[]=new String[1];
    	args[0] = "7658";
    	assertFalse(numberconvert.isValid(args[0]));
    }
    
    public void testForAlphanumeric() throws Exception
    {
    	String args[]=new String[1];
    	args[0] = "abc";
    	assertFalse(numberconvert.isValid(args[0]));
    }
    
    public void testForNumberToWord() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="768";
    	assertTrue(numberconvert.isValid(args[0]));
    }    
    
    public void testForNumberToWordconvertMethod() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="zero";
    	Assert.assertEquals(args[0], numberconvert.convert(0));
    }    
    
    public void testForNumberToWordconvertNegative() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="negative ninety five";
    	Assert.assertEquals(args[0], numberconvert.convert(-95));
    }    
    
    public void testForNumberToWordconvertthreeDigit() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="nine hundred  ninety five";
    	Assert.assertEquals(args[0], numberconvert.convert(995));
    }
    
    public void testForNumberToWordconverttwoDigit() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="eighty five";
    	Assert.assertEquals(args[0], numberconvert.convert(85));
    }
    
    public void testForNumberToWordconvertoneDigit() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="eight";
    	Assert.assertEquals(args[0], numberconvert.convert(8));
    }
    
    public void testForNumberToWordconvertVariety1() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="ninety eight";
    	Assert.assertEquals(args[0], numberconvert.convert(98));
    }
    
    public void testForNumberToWordconvertVariety2() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="nine hundred  ninety eight";
    	Assert.assertEquals(args[0], numberconvert.convert(998));
    }
    
    public void testForNumberToWordconvertVariety3() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="nine";
    	Assert.assertEquals(args[0], numberconvert.convert(9));
    }
          
    public void testForNumberToWordconvertVariety4() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="negative nine hundred  ninety nine";
    	Assert.assertEquals(args[0], numberconvert.convert(-999));
    }
    
    public void testForNumberToWordconvertVariety5() throws Exception
    {
    	String args[]=new String[1];
    	args[0]="-9999";
    	assertFalse(numberconvert.isValid(args[0]));
    	Logger.getLogger("Exiting");
    }

}
