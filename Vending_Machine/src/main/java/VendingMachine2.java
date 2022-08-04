public class VendingMachine2
{
    public static void main(String[] args)
    {
        int total = 1571;
        int a100 = total / 100;
        total %=  100;
        int a50 = total / 50;
        total %= 50;
        int a25 = total / 25;
        total %= 25;
        int a10 = total / 10;
        total %=  10;
        int a5 = total / 5;
        total %=  5;
        int a1 = total;

        System.out.printf(" %d x 1$ \n %d x 50c \n %d x 25c\n %d x 10c\n %d x 5c\n %d x 1c", a100, a50, a25, a10, a5, a1);
    }
}
