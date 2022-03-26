import java.util.*;
public class Main
{
    public static void main()
    {
        
        Scanner sc=new Scanner(System.in);
        String a[]=new String[4];
        String b[]=new String [6];
        String c[]=new String[4];
        String ans="c";
        System.out.println("\nWelcome to THE GRAND HOTEL");
        while(ans.equalsIgnoreCase("c"))
      {
        int tvstr=0,tnvstr=0,vfd,tvfd=0,nvfd,tnvfd=0,fd,tfd=0,amt=0,tamt=0,totalamt=0,d,totald=0,damt=0,ch;
        double vat=0.0;
        String str="",choice="Y";
        int n=0;
          
        System.out.println("\n For starters press :1");
        System.out.println("For main course press:2");
        System.out.println("For desserts and cold drinks :3");
        System.out.println();
        System.out.println("Enter your choice ");
        ch=sc.nextInt();
        switch(ch)
        {    
            case 1:
            {
                System.out.println("STARTERS");
                System.out.println("Enter VS for veg and NVS for non veg");
                str=sc.next();
                if(str.equalsIgnoreCase("VS"))
                {
                    a[0]="Panner Manchuri";
                    a[1]="Paneer Tikka";
                    a[2]="Spinach Manchuri";
                    a[3]="Spring roll";
                    System.out.println("Starters and \t\t\t price");
                    System.out.println("0.Panner Manchuri\t\t\t 200");
                    System.out.println("1.Paneer Tikka\t\t\t 200");
                    System.out.println("2.Spinach Manchuri\t\t\t 200");
                    System.out.println("3.Spring roll\t\t\t 200");
                    while(choice.equalsIgnoreCase("Y"))
                    {
                        System.out.println("Enter choice");
                        n=sc.nextInt();
                        System.out.println("Enter the number of starters");
                        tvstr=sc.nextInt();
                        amt=tvstr*200;
                        tamt=tamt+amt;
                        System.out.println("You ordered for "+a[n]+" "+"and the number of plates"+" "+tvstr);
                        System.out.println("Enter Y to continue or enter another alphabet to discontinue from starters ");
                        choice =sc.next();
                    }
                }
                else if(str.equalsIgnoreCase("NVS"))
                {
                    a[0]="Chicken Tikka";
                    a[1]="Chicken Kebab";
                    a[2]="Chilli Chicken";
                    a[3]="Fish Tikka";
                    System.out.println("Starters and \t\t\t price");
                    System.out.println("0.Chicken Tikka\t\t\t 250");
                    System.out.println("1.Chicken Kebab\t\t\t 250");
                    System.out.println("2.Chilli Chicken\t\t\t 250 ");
                    System.out.println("3.Fish Tikka\t\t\t 250");
                    while(choice.equalsIgnoreCase("Y"))
                    {
                        System.out.println("Enter choice");
                        n=sc.nextInt();
                        System.out.println("Enter the number of plates");
                        tnvstr=sc.nextInt();
                        amt=tnvstr*250;
                        tamt=amt+tamt;
                        System.out.println("You ordered for "+a[n]+" "+"and the number of plates"+" "+tnvstr);
                        System.out.println("Enter Y to continue or enter another alphabet to discontinue from starters");
                        choice =sc.next();
                    }
                }
                vat=Math.round(14.5/100.0*tamt);
                System.out.println("\nVAT is:"+vat);
                double sum=vat+tamt;
                System.out.println("Bill for starters ="+sum);
                System.out.println();
                break;
            }
            case 2:
            {
                System.out.println("MAIN COURSE");
                System.out.println("Press V for veg and NV for non veg");
                str=sc.next();
                if(str.equalsIgnoreCase("V"))
                {
                    b[0]="Paneer Butter Masala";
                    b[1]="Mixed Vegetable";
                    b[2]="Shahi Paneer";
                    b[3]="Roti";
                    b[4]="Naan";
                    b[5]="Kulcha";
                    System.out.println("Veg dishes\t\t\t price");
                    System.out.println("0.Paneer Butter Masala\t\t\t 250");
                    System.out.println("1.Mixed Vegetable\t\t\t 250 ");
                    System.out.println("2.Shahi Paneer\t\t\t 250");
                    System.out.println("3.Roti\t\t\t 150");
                    System.out.println("4.Naan\t\t\t 150");
                    System.out.println("5.Kulcha\t\t\t 150");
                    while(choice.equalsIgnoreCase("Y"))
                    {
                        System.out.println("Enter the dish by its number");
                        vfd=sc.nextInt();
                        System.out.println("Enter the number of plates");
                        tvfd=sc.nextInt();
                        if(vfd>=0&&vfd<=2)
                        amt=tvfd*250;
                        else if(vfd>=3&&vfd<=5)
                        amt=tvfd*150;
                        else
                        System.out.println("Wrong dish");
                        totalamt=amt+totalamt;
                        System.out.println("You ordered for "+b[vfd]+" "+"and the number of plates"+" "+tvfd);
                        System.out.println("Enter Y if you want to ontinue or enter another alphabet to discontinue from main course");
                        choice=sc.next();
                    }
                }
                else if(str.equalsIgnoreCase("NV"))
                {
                    b[0]="Chicken Tikka Masala";
                    b[1]="Chicken Tikka Labada";
                    b[2]="Prawn Malai Curry";
                    b[3]="Roti";
                    b[4]="Naan";
                    b[5]="Kulcha";
                    System.out.println("Non Veg dishes\t\t\t price");
                    System.out.println("0.Chicken Tikka Masala\t\t\t 300");
                    System.out.println("1.Chicken Tikka Labadar\t\t\t 300");
                    System.out.println("2.Prawn Malai Curry\t\t\t 300");
                    System.out.println("3.Roti\t\t\t 150");
                    System.out.println("4.Naan\t\t\t 150");
                    System.out.println("5.Kulcha\t\t\t 150");
                    while(choice.equalsIgnoreCase("Y"))
                    {
                        System.out.println("Enter the dish by its number");
                        nvfd=sc.nextInt();
                        System.out.println("Enter the number of plates");
                        tnvfd=sc.nextInt();
                        if(nvfd>=0&&nvfd<=2)
                        amt=tnvfd*300;
                        else if(nvfd>=3&&nvfd<=5)
                        amt=tnvfd*150;
                        else
                        System.out.println("Wrong dish");
                        totalamt=amt+totalamt;
                        System.out.println("You ordered for "+b[nvfd]+" "+"and the number of plates"+" "+tnvfd);
                        System.out.println("Enter Y to continue or enter another alphabet to discontinue from main course ");
                        choice=sc.next();
                    }
                }
                System.out.println("Main course bill:");
                vat=Math.round(14.5/100.0*totalamt);
                System.out.println("\n VAT is:"+vat);
                System.out.println("The total bill is :"+(totalamt+vat));
                break;
            }
            case 3:
            {
                c[0]="Any cold drink";
                c[1]="Choco Lava Cake";
                c[2]="Sizzling Brownie";
                c[3]="Any ice cream";
                System.out.println("Desserts and Cold Drinks\t\t\t price");
                System.out.println("0.Any cold drink\t\t\t 90");
                System.out.println("1.Choco Lava Cake\t\t\t 100");
                System.out.println("2.Sizzling Brownie\t\t\t 100");
                System.out.println("3.Any ice cream\t\t\t 100");
                while(choice.equalsIgnoreCase("Y"))
                {
                    System.out.println("Enter the dessert by the number");
                    d=sc.nextInt();
                    System.out.println("Enter the number of plates");
                    totald=sc.nextInt();
                    if(d==0)
                    amt=totald*90;
                    else if(d>=1&&d<=3)
                    amt=totald*100;
                    else
                    System.out.println("Wrong choice");
                    damt=damt+amt;
                    System.out.println("You ordered for "+c[d]+" "+"and the number of plates"+" "+totald);
                    System.out.println("Enter Y to continue or enter another alphabet to discontinue from deserts ");
                    choice=sc.next();
                }
                System.out.println("Dessert bill is:");
                vat=Math.round(14.5/100.0*damt);
                System.out.println("\n VAT is:"+vat);
                System.out.println("The total amount is :"+(vat+damt));
                break;
            }
            
            default :
            {
                System.out.println("Wrong choice .Execute again");
            }
        }
        System.out.println("Enter c  to  continue or press q to quit ");
        ans=sc.next();
        if(ans.equalsIgnoreCase("Q"))
        {
        System.out.println("Thank you for visiting .Hope you liked the food");
        break;
    }
        
    }
}
}
            
 
