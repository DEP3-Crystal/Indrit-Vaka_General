
public class TeenagersSum {


    public int teenagersSum(int a, int b, int c){
     if(a < 0 || b< 0|| c<0)
     {
         throw new IllegalArgumentException();
     }
     return checkTeen(a) + checkTeen(b) + checkTeen(c);
    }
    private int checkTeen(int n){
       if(n >= 13 && n<= 19 && n !=15 && n!= 16)
           return 0;
       return n;
    }
}
