import com.candy.Candy;
import com.functional.Gift;
import com.menu.Main;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import com.menu.Main;

import java.io.ByteArrayInputStream;

import static com.menu.Main.findGift;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class MainTest {
    @Mock
    public Gift gift = new Gift("s");
    @Test
    public void createGiftTest(){
        String simulatedUserInput = "gift" +  "\n"
                +"korivka" +  "\n"
                +"save" +  "\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertEquals("korivka", Main.createGift().getCandies().get(0).getName());
    }
    @Test
    public void SortGiftTest(){
        //Gift gift = new Gift("gift");
        gift.addCandy(new Candy("b",1,1,1));
        gift.addCandy(new Candy("a", 2,2,2));
        String simulatedUserInput = "0" + "\n" + "ABC" +  "\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        //when(findGift()).thenReturn(gift);
        given(findGift()).willReturn(gift);
        Assert.assertEquals("a", Main.sortGift().getCandies().get(0).getName());
    }
}
