import com.candy.ChocolateWithFillings;
import com.candy.FruitJelly;
import com.candy.GlazedLiquor;
import com.candy.Lollipops;
import com.functional.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {
    private Store store;
    @Before
    public void setUp(){
        store = new Store(new ChocolateWithFillings("b", 2,2,2,"2"),
                new Lollipops("a",1,1,1,"1"),
        new FruitJelly("c",1,1,1,"1"),
        new GlazedLiquor("d",1,1,1,1));
    }
    @Test
    public void isCandyAvailableTestTrue(){
        assertTrue(store.isCandyAvailable("a"));
    }
    @Test
    public void isCandyAvailableTestFalse(){
        assertFalse(store.isCandyAvailable("e"));
    }
    @Test
    public void returnCandyTest(){
        String res = "a";
        assertEquals(res, store.returnCandy("a").getName());
    }
}
