import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderI
{
       public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        //adding every words in set
       Set<String> st=new HashSet<>();
       for(int i=0;i<wordList.length;i++)
       {
           st.add(wordList[i]);
       }
       
       //declaring queue to put the words one by one
       Queue<Pair> queue=new LinkedList<>();
       queue.add(new Pair(startWord,1));
       
       //remove 1st word from set bcoz it was already addedin queue
       st.remove(startWord);
       
       while(!queue.isEmpty())
       {
           String word=queue.peek().word;
           int step=queue.peek().step;
           queue.remove();
           
           if(word.equals(targetWord)==true)
           return step;
           
           //we are now changing each char from the word form 'a' to 'z'
           for(int i=0;i<word.length();i++)
           {
               for(char ch='a';ch<='z';ch++)
               {
                   char wordarr[]=word.toCharArray();
                   wordarr[i]=ch;
                   //now taking the char array as single string
                   String newWord=new String(wordarr);
                   
                   //checking if newword in set
                   if(st.contains(newWord))
                   {
                       st.remove(newWord);
                       queue.add(new Pair(newWord,step+1));
                       
                   }
               }
           }
       }
       return 0;
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    class Pair
    {
        String word;
        int step;
        Pair(String w,int s)
        {
            this.word=w;
            this.step=s;
        }
    }
}