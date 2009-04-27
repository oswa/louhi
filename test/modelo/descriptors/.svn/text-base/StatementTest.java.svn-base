/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.descriptors;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alos
 */
public class StatementTest {

    public StatementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getStatement method, of class Statement.
     */
    @Test
    public void testGetStatement() {
        System.out.println("getStatement");
        Statement instance = null;
        LinkedList<Token> expResult = null;
        LinkedList<Token> result = instance.getStatement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatement method, of class Statement.
     */
    @Test
    public void testSetStatement() {
        System.out.println("setStatement");
        LinkedList<Token> statement = null;
        Statement instance = null;
        instance.setStatement(statement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Statement.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        //Creamos la primera regla o statement de los autores
        Token t1 = new Token(TokenType.NAME);
        Token t2 = new Token(TokenType.SEPARATOR, ",");
        Token t3 = new Token(TokenType.NAME);

       //Ahora creamos el estatement con los tokens adecuados
        LinkedList<Token> listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        Statement statement = new Statement(listaDeTokens);
        boolean expResult = true;
        boolean result = statement.equals(statement);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Statement.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Statement instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}