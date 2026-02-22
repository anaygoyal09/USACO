/*
 * Problem 2: Strange Function
 * If number x has any digits not 0 or 1, replace it with 1 if num%2=1 and return x, else replace with 0 and return x
 * else return x-1
 * return number of iterations % (10^9+7)
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
public class StrangeFunction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numRepeat = in.nextInt();
        for (int i =0; i < numRepeat; i++)
        {
            int num = in.nextInt();
            int count = 0;
            ArrayList<Integer> arrListNum = convertToList(num);
            while(!arrListNum.isEmpty())
            {
                if(isAllZeroOrOne(num))
                {
                    num = num-1;
                    arrListNum = convertToList(num);
                }
                else
                {
                    for(int iterate = 0; iterate < arrListNum.size();iterate++)
                    {
                        //gets current digit
                        int digit = arrListNum.get(iterate);
                        if (digit != 0 && digit != 1) 
                            {
                            // If even set 0
                            if (digit % 2 == 0) 
                            {
                                arrListNum.set(iterate, 0);
                            } 
                            // If odd set 1
                            else 
                            {
                                arrListNum.set(iterate, 1);
                            }
                        }
                    }
                    num = convertListToInt(arrListNum);  // removes 0's from beginning
                    arrListNum = convertToList(num);
                }
                count++;
            }
            
            System.out.println(count%1000000007);
        }
        
    }
    //Checks if the whole number is 0's or 1's which tells if to return x-1
    public static boolean isAllZeroOrOne(int number)
    {
        String str = number+"";
        for(char c:str.toCharArray())
        {
            if(c != '0'&&c!='1')
                return false;
        }
        return true;
    }
    public static ArrayList<Integer> convertToList (int num)
    {
         //Convert number into ArrayList
            ArrayList<Integer> digits=new ArrayList<Integer>();
            while(num>0)
            {
                digits.add(0,num%10);
                num = num/10;

            }
            return digits;
    }
    
    public static int convertListToInt(ArrayList<Integer> digits)
    {
        //Convert ArrayList into integer number
        int num = 0;
        for(int digit : digits)
        {
            num = num * 10 + digit;
        }
        return num;
    }
    
   
}
