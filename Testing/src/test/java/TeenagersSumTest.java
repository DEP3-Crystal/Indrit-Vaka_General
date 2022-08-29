import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeenagersSumTest {
    TeenagersSum teenagersSum;

    @BeforeEach
    public void runBeforeEveryTest() {
        teenagersSum = new TeenagersSum();
    }

    @Test
    void checkTeenagersSumInsideInterval() {
        int actialSum = teenagersSum.teenagersSum(15, 16, 15);
        Assertions.assertEquals(15 + 16 + 15, actialSum);
    }

    @Test
    private void check() {

    }
}