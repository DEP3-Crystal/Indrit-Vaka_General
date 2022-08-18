import java.net.SecureCacheResponse;
import java.util.Arrays;
import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        int[] charge;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter money");
        double inputtedMoney = in.nextDouble();

        System.out.println("Enter product cost");
        double pCost = in.nextDouble();

        charge = getChange(inputtedMoney, pCost);
        System.out.println("[1c, 5c, 10c, 25c, 50c, 1$]");
        Arrays.stream(charge).forEach(v -> System.out.print(v + ", "));

    }

    /*
     * Gets total money and the product cost
     * and returns an array of change [1c, 5c, 10c, 25c, 50c, 1$]
     * */
    public static int[] getChange(double inputtedMoney, double productCost) {
        int[] change = new int[6];
        //First we convert all money in cent, so we can use %
        //Second we get the total money we have to return

        int totalChange = (int) (inputtedMoney * 100 - productCost * 100);
        int[] money = new int[]{1, 5, 25, 50, 100};
        //since we are using Big decimal for performance reasons we store the res
        if (totalChange == 0)
            return change;
        else {
            if (totalChange < 0) {
                totalChange = (int) (inputtedMoney * 100);
                System.out.println("You don't have enough money. We are returning you the money you entered");
            }
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

//            for (int i = 5; i >= 0; i--) {
//                change[i] = totalChange / money[i];
//                totalChange %= money[i];
//            }
            return change;
        }
    }


}
