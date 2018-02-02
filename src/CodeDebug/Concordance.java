
package CodeDebug;


import java.util.HashMap;
import java.util.Map;

public class Concordance {

       Map<Integer, Integer> FunctionTwo(int[] a, int[] b) {
              Map<Integer, Integer> m = new HashMap<>();
              for(int i = 0; i < a.length; i++) {
                     m.put(a[i],b[i]);
              }
              return m;
       }

       int FunctionOne(int a, int b) {
              //Zero and negative is check required
              //x value to be assigned with small number so logic to get small number is not mentioned
              int small = a <= b ? a : b;
              for(int x = small; x >= 0; x--) {
                     if (a % x == 0 && b % x == 0) {
                           //System.out.println("x Value is :" +x);
                           return x;

                     }
              }
              return -1;//Return Value must not be 1 here. It must be -1 to identify the negative scenario
       }

       int FunctionThird(int a, int b) {
              if(!(a<=0 || b<=0)) {
                     int small = a <= b ? a : b;
                     for(int x = small; x >= 0; x--) 
                           if (a % x == 0 && b % x == 0) 
                                  return x;     
              }
              return -1;
       }

       public static void main(String[] args) { 
              Concordance concordance = new Concordance();
              int[] a={1,2,3};
              int[] b={4,5,6};
              Map<Integer, Integer> mymap = concordance.FunctionTwo(a,b);
              System.out.println(mymap);
              System.out.println(concordance.FunctionThird(50, 10)); 

       }

}
