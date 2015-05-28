import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class Wrdcnt2
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Enter String: ");
    	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String s = bufferRead.readLine();
	    String[] words = s.split(" ");
	    String word = "";
        Map dictionary = new HashMap();
	     for(int i=0;i<words.length;i++) 
	   {                 
                word = words[i];
                if(dictionary.containsKey(word)) 
                {
                    int val = (int)dictionary.get(word);
                    dictionary.put(word, val + 1);
                }
                else
                    dictionary.put(word, 1);
       }


   }
}