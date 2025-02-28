/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void should_use_50_percentage_sales_promotion(){
        List<String> inputs = Arrays.asList("ITEM0001 x 1", "ITEM0013 x 2", "ITEM0022 x 1");
        App app = new App(new ItemRepositoryTestImpl(), new SalesPromotionRepositoryTestImpl());
        String receiptString = app.bestCharge(inputs);
        assertThat(receiptString, is("============= Order details =============\n" +
                "Braised chicken x 1 = 18 yuan\n" +
                "Chinese hamburger x 2 = 12 yuan\n" +
                "Cold noodles x 1 = 8 yuan\n" +
                "-----------------------------------\n" +
                "Promotion used:\n" +
                "Half price for certain dishes (Braised chicken，Cold noodles)，saving 13 yuan\n" +
                "-----------------------------------\n" +
                "Total：25 yuan\n" +
                "==================================="));
    }
    @Test
    public void should_use_buy_30_save_6_sales_promotion(){
        List<String> inputs = Arrays.asList("ITEM0013 x 4", "ITEM0022 x 1");

        App app = new App(new ItemRepositoryTestImpl(), new SalesPromotionRepositoryTestImpl());
        String receiptString = app.bestCharge(inputs);

        assertThat(receiptString, is("============= Order details =============\n" +
                "Chinese hamburger x 4 = 24 yuan\n" +
                "Cold noodles x 1 = 8 yuan\n" +
                "-----------------------------------\n" +
                "Promotion used:\n" +
                "Deduct 6 yuan when the order reaches 30 yuan, saving 6 yuan\n" +
                "-----------------------------------\n" +
                "Total：26 yuan\n" +
                "==================================="));

    }


    @Test
    public void should_use_no_sales_promotion(){
        List<String> inputs = Arrays.asList("ITEM0013 x 4");

        App app = new App(new ItemRepositoryTestImpl(), new SalesPromotionRepositoryTestImpl());
        String receiptString = app.bestCharge(inputs);

        assertThat(receiptString, is("============= Order details =============\n" +
                "Chinese hamburger x 4 = 24 yuan\n" +
                "-----------------------------------\n" +
                "Total：24 yuan\n" +
                "==================================="));
    }
}
