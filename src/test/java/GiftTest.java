import com.candy.Candy;
import com.candy.ChocolateWithFillings;
import com.candy.Lollipops;
import com.functional.Gift;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class GiftTest {
    private Gift gift;

    @Before
    public void setUp(){
        gift = new Gift("gift");
        gift.addCandy(new ChocolateWithFillings("b", 2,2,2,"2"));
        gift.addCandy(new Lollipops("a",1,1,1,"1"));
    }
    @Test
    public void testPriceGift(){
        int result = 3;
        assertEquals(result, gift.priceGift());
    }
    @Test
    public void testAddCandy(){

        List<Candy> testList = new ArrayList<>(gift.getCandies());
        Candy testCandy = new Lollipops("c",3,3,3,"3");
        testList.add(testCandy);
        gift.addCandy(testCandy);
        Assert.assertArrayEquals(testList.toArray(), gift.getCandies().toArray());
    }
    @Test
    public void testDeleteExistingCandy(){
        List<Candy> testList = new ArrayList<>(gift.getCandies());
        testList.remove(1);
        gift.deleteCandy("a");
        Assert.assertArrayEquals(testList.toArray(), gift.getCandies().toArray());
    }
    @Test
    public void testDeleteNotExistingCandy(){
        List<Candy> testList = new ArrayList<>(gift.getCandies());
        gift.deleteCandy("c");
        Assert.assertArrayEquals(testList.toArray(), gift.getCandies().toArray());
    }
    @Test
    public void testSortGiftToABC(){
        List<Candy> testList = new ArrayList<>(gift.getCandies());
        testList.sort(new Comparator<Candy>() {
            @Override
            public int compare(Candy o1, Candy o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
        gift.sortGift("ABC");
        assertEquals(testList, gift.getCandies());
    }
    @Test
    public void testSortGiftToSugar(){
        List<Candy> testList = new ArrayList<>(gift.getCandies());
        testList.sort(new Comparator<Candy>() {
            @Override
            public int compare(Candy o1, Candy o2) {
                return -(o1.getSugarContent() - o2.getSugarContent());
            }
        });
        gift.sortGift("sugar");
        assertEquals(testList, gift.getCandies());
    }
}