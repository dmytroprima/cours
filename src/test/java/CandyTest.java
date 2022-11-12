import com.candy.Candy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {
    private Candy candy;
    @Before
    public void setUp(){
        candy = new Candy("1", 1,1,1);
    }
    @Test
    public void getNameTest(){
        String name = "1";
        assertEquals(name, candy.getName());
    }
    @Test
    public void getSugarContentTest(){
        int sugar = 1;
        assertEquals(sugar, candy.getSugarContent());
    }
    @Test
    public void getPriceTest(){
        int price = 1;
        assertEquals(price, candy.getPrice());
    }
    @Test
    public void toStringTest(){
        assertEquals("Name: 1 weight: 1 price: 1 sugar content: 1", candy.toString());
    }
}
