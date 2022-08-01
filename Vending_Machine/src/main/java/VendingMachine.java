import java.util.Arrays;

public class VendingMachine
{
    public static void main(String[] args)
    {
        int[] a;
        a = getChange(5, 0.99);
        Arrays.stream(a).forEach(v -> System.out.print(v + ", "));

    }


    /*
     * Gets total money and the product cost
     * and returns an array of change [1c, 5c, 10c, 25c, 50c, 1$]
     * if the cost is greater than the product will return st-1 val to -1 and a message
     * */
    private static int[] getChange(double tMoney, double pCost)
    {
        int[] change = new int[6];
        //First we convert all money in cent, so we can use %
        //Second we get the total money we have to return

        int totalChange = (int) ((tMoney - pCost) * 100);

        //since we are using Big decimal for performance reasons we store the res

        if (totalChange > 0)
        {
            //[1c, 5c, 10c, 25c, 50c, 1$]
            change[5] = totalChange / 100;
            totalChange = totalChange % 100;
            change[4] = totalChange / 50;
            totalChange %= 50;
            change[3] = totalChange / 25;
            totalChange %= 25;
            change[2] = totalChange / 10;
            totalChange %= 10;
            change[1] = totalChange / 5;
            totalChange %= 5;
            change[0] = totalChange;
        }
        else if (totalChange < 0)
        {
            change[0] = -1;
            System.out.println("You don't have enough money to get that product");
        }

        return change;
    }


}
