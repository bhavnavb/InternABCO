import java.util.Date;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCount {

	public static void main(String[] args) throws IOException
	{
		long lStartTime = new Date().getTime();
		System.out.println("Enter file name: ");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String fname=bufferRead.readLine();
	    FileReader reader = new FileReader(fname);
	    BufferedReader br = new BufferedReader(reader);
	    String s = br.readLine();
	    String[] words = s.split(" ");
	    String word = "";
        HashMap dictionary = new HashMap();
	     for(int i=0;i<words.length;i++) 
	   {                 
                word = words[i];
                word = word.replace(".", "");
                word = word.replace(",", "");
               // System.out.println("\n "+word); 
                if(dictionary.containsKey(word)) 
                {     	 
                    int val = (int)dictionary.get(word);
                    dictionary.put(word, val + 1);
                }
                else
                    dictionary.put(word, 1);
       }
	    
	     Set set=dictionary.entrySet();
   	     System.out.println("\n\n\nWord count " + set);
   	   long lEndTime = new Date().getTime();
   	 
  	   long difference = lEndTime - lStartTime;
   
  	   System.out.println("Elapsed milliseconds: " + difference);
   	

}
}