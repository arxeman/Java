/*
A program to convert given date in "dd/mm/yyyy" format to words
this program also checks for invalid date
*/
import java.util.*;
class Date
{
    String date;
    int d,m,y;  //initializing variables for date, month and year
    /*public Date(String s)  //constructor
    {
        date=s;
    }*/
    void accept()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter date in dd/mm/yyyy format: ");
        date=sc.nextLine();
        d=Integer.parseInt(date. substring (0,2)); 
        m=Integer.parseInt(date.substring (3,5)); 
        y=Integer.parseInt(date.substring (6, 10)); 
        toWords();
    } 
    static boolean isLeap(int y)  //leap year check
    {
        if((y%4==0 && y%100!=100)||(y%400==0))
          return true;
        else
        {
            System.out.println("INVALID INPUT- Not a leap year!");
            return false;
        }
    }
    boolean isValid()  //checking for validation of date
    {
        if(y>=1947 && y<=2047)  //check for year
        {
            switch(m)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(!(d>=1 && d<=31))  //31 days month
                    {
                        System.out.print("Days not valid");
                        return false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(!(d>=1 && d<=30))  //30 days month
                    {
                        System.out.print("Days not valid");
                        return false;
                    }
                    break;
                case 2:
                    if(isLeap(y)==true)
                    {
                        if(!(d>=1 && d<=29))  //during leap year
                        {
                            System.out.print("Days not valid");
                            return false;
                        }
                    }
                    else
                    {
                        if(!(d>=1 && d<=28))  //during non leap year
                        {
                            System.out.print("Days not valid");
                            return false;
                        }
                    }
                    break;
                default:
                    System.out.print("Months not valid");  //when month<1 or month>12
                    return false;

            }
        }
        else
        {
            System.out.print("Year not valid");  //when year>2047 or year<1947
               return false;
        }
        return true;  //when all conditions are true
    }
    void toWords()
    {
        //array inputs for converting into words
        String sd[]={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String dd[]={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String tens[]={"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String td[]={"Hundred","Thousand"};
        String month[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        String word="";  //it will store the converted words from date
        if(isValid()==true)
        {
            //date conversion
            if(d>=10 && d<20)
               word=word+dd[d-10]+" ";
            if(d>20)
                word=word+tens[d/10-2]+" ";
            d=d%10;  //to extract the one's digit value
            if(d>=1 && d<10)
                word=word+sd[d-1]+" ";
            //month conversion
            word=word+month[m-1]+" ";
            //year conversion
            if(y/100<20)  //when year<2000
                word+=dd[y/100-10]+"v"+td[0]+" ";
            else  //when year>=2000
                word+=sd[y/1000-1]+" "+td[1]+" ";
            y=y%100;
            if(y>=10 && y<20)
                word+=dd[y-10]+" ";
            else
            {
                if(y/10>=2)
                    word+=tens[y/10-2]+" ";
                y=y%10;
                if(y>0 && y<10)
                    word+=sd[y-1]+" ";
            }
            System.out.print("Date in words: "+word);  //displaying date in words
        }
    }
    void main(String[]args)
    {
        accept();
    }
}