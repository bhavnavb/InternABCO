import java.io.*;
import java.util.Scanner;
class Dictionary
{
  String key;
  int val;
  public Dictionary()
  {
    key="";
    val=0;
  }
 void insert(String k)
  {
    key=k;
    val=0; 
  }
 void update()
  {
    val++;
  }
 String retkey()
 {
   return key;
 }
 int retval()
 {
   return val; 
 }
 public void display()
  {
    System.out.println("Word = "+key);
    System.out.println("Number = "+val);
  }
}
class stack
{
  Dictionary D[];
  int n;
  int top;
  public stack(int N)
  {
    n=N;
    top=-1;
  }
  public void push(String p)
  {
    D[++top].insert(p);
  }
  public void check(String p)
  {
    int i=0,flag=1;
    String q="";
    if(top==-1)
    {
      push(p);
      flag=0;
    }
    else
    {
     for(i=0;i<=top;i++)
     {
       q=D[i].retkey();
       if(q.equals(p))
         { 
          D[i].update();
          flag=0;
         }
        else
        flag=1;
     }
    if(flag==1)
     push(p);
    }
   }
 public void print()
 {
   D[top].display();
 }
}
public class Wrdcnt
{
  public static void main(String[] args)
  {
  //  Dictionary D[]=new Dictionary() ;
    String st="";
    String p="";
    System.out.println("Enter String: ");
    Scanner in= new Scanner(System.in);
    st=in.nextLine();
/*    no of words*/
    int n=count(st);
    int j=0;
    System.out.println("No of words: "+n);
    stack stck =new stack(n);
    for(int i=0;i<=st.length();i++)
     {
      if(i==st.length())
       {
        p = st.substring(j,i);
         System.out.println(""+p);
         stck.check(p);
         j=0;
        break;
       }       

       if(st.charAt(i)==' ')
        {
         p = st.substring(j,i);
         System.out.println(""+p);
         stck.check(p);
         j=i+1;
        }
     }
  }
  public static int count(String s)
  {
    int w=0;
    for(int i=0;i<s.length();i++)
     {
           if(s.charAt(i)==' ')
               {
                   w++;
               }
     }
   return (w+1);
  }
}
