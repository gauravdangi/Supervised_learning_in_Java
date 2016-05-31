/*
This project is for linear regression with one variable
 */
package supervised.learning;
import java.util.*;

/*
 @author GauravSinghDangi
 */
public class SupervisedLearning {


    public static void main(String[] args) {
       SupervisedLearning sl = new SupervisedLearning();
       Scanner scan = new Scanner(System.in);
       int temp=0;
       int i;
       System.out.println("This project is based on Linear regression with one variable by gradient descent method");
       do{
       System.out.print("Enter number of training/data set: ");
       int m = scan.nextInt();
       double[] x = new double[m+1];
       double[] y = new double[m+1];
       for(i=0;i<m;i++){
        System.out.print("\nEnter input: ");
        x[i] = scan.nextDouble();
        System.out.print("\nEnter it's output: ");
        y[i] = scan.nextDouble();
       }
       sl.showdata(m, x, y);
        //System.out.print("\nGuess initial value for O1 and O2 for hypothesis function: ");
        double g1 = m;
        double g2 = m;
        double[] ans = new double[2];
        //--------calling gradient function-----------
          System.out.println("\nThis may take some time to calculate.......");
         ans = sl.gradient(g1, g2,x,y,m);  // calling gradient method
        
         g1 = ans[0];
         g2 = ans[1];
         System.out.println("\nBest values for O1 and O2 are: "+g1+" , "+g2);
         System.out.print("Enter value whose output you want: ");
         double ch = scan.nextDouble();
         double ans1 = g1 + (g2*ch);
         System.out.println("\nBest output for "+ch+" (by GRADIENT DESCENT) is = "+(double)Math.round(ans1*100)/100+" approximately");
         System.out.println("Do you want to continue? (Press y or Y to continue or yes)");
         String y1 = scan.next();
         if(y1.compareTo("y")==0 || y1.compareTo("Y")==0 )
             temp=1;
         else
             temp=0;
       }while(temp==1);
       System.exit(0);
       
    }
    //------------------show data-----------------------------------------------
    public void showdata(int n,double[] in, double[] out){
        int i;
        System.out.println("\nGiven data set is:-");
        System.out.println("    INPUT    |   OUTPUT   ");
        for(i=0;i<n;i++){
        System.out.println("    "+in[i]+"          "+out[i]+"   ");
       }
    }
    //------------------Hypothesis function -> h(x) = [O1 + O2 x]---------------
    public double hypth(double o1, double o2, double input){
     double h = 0;
     h = o1 + (o2*input);
     //System.out.println("hypth method is called and returned "+h);
     return h;   
    }
    /*
    //------------------cost function-------------------------------------------
    public double cost(){
    
    }
    */
    //------------------------Gradient descent----------------------------------
    public double[] gradient(double o1, double o2, double[] in, double[] out, int n){
     double a1=0,temp1=0,temp2=0;
     double a2=0;
     int i;
     try{
     while(Math.abs(a1-o1)>0.001 && Math.abs(a2-o2)>0.001){
     for(i=0;i<n;i++){
     a1 = o1;
     a2 = o2;
     //System.out.println((1/(double)n)+"*("+(hypth(o1,o2,in[i])+" - "+out[i]+") = "+(double)((1/n)*(hypth(o1,o2,in[i])-out[i])));
     temp1 = o1-(0.1)*((1/(double)n)*(hypth(o1,o2,in[i])-out[i]));
     temp2 = o2-(0.1)*((1/(double)n)*(hypth(o1,o2,in[i])-out[i])*in[i]);
     o1 = temp1;
     o2 = temp2;
     }
     }
     }
     catch(Exception e){
      System.exit(0);
     }
     double[] arr = new double[2];
     arr[0] = o1;
     arr[1] = o2;
     //System.out.println("This is in gradient function and values are-> "+o1+","+o2);
     return arr;
    }
}