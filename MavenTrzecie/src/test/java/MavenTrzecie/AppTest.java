package MavenTrzecie;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    private App app; 
    
    public void testBinaryListIsEmpty()
    {
    	int[] lista = {};
        assertEquals(-1,app.BinSearch(lista, 3));
    }
    
    public void testBinary()
    {
    	int[] lista = {1,2,3,8,11,18,50};
        assertEquals(2,app.BinSearch(lista, 3));
    }
    
    public void testBinarySecond()
    {
    	int[] lista = {1,2,3,8,11,18,50};
        assertEquals(4,app.BinSearch(lista, 11));
    }
    
    public void testBinaryLast()
    {
    	int[] lista = {1,2,3,8,11,18,50};
        assertEquals(6,app.BinSearch(lista, 50));
    }
    
    public void testBinaryNotFound()
    {
    	int[] lista = {1,2,3,8,11,18,50};
        assertEquals(-1,app.BinSearch(lista, 5));
    }
}
