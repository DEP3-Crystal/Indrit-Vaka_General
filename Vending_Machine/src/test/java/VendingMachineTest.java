import org.junit.jupiter.api.*;

class VendingMachineTest {

    VendingMachine vendingMachine;
    static int methodNo = 1;

    @BeforeEach
    public void beforeEach() {
        System.out.println("Im before method: " + methodNo);
        vendingMachine = new VendingMachine();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Im after method: " + methodNo);
        methodNo++;

    }

    @Test
    void getChange() {
        Assertions.assertArrayEquals(new int[]{1, 0, 0, 0, 0, 4},
                vendingMachine.getChange(5, 0.99));
    }

    @Test
    void throwExceptionOnNegativeValues() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> vendingMachine.getChange(-10, 0));
    }

    @Test
    public void getInputtedChangeBackOnNotEnoughMoney() {
        Assertions.assertArrayEquals(new int[]{1, 0, 0, 0, 0, 1},
                vendingMachine.getChange(1.01, 5));
    }

}