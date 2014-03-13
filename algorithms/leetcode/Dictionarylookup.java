public class Dictionarylookup {


	
	public static void main(String args[]) {
		
		Dictionarylookup test = new Dictionarylookup();
		PrefixTree tree = new PrefixTree('\0');

		 String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
       		 for (int i = 0; i < words.length; i++)
          		 test.insertWord(words[i],tree);
        
        	String searchWord = "an";
        	if (test.lookup(searchWord,tree))
        	{
           		 System.out.println("The word was found");
      		}
      	 	 else
       	 	{
         	   System.out.println("The word was NOT found");
       		 }
		


	}


	 public void insertWord(String word, PrefixTree root) {
                char[] chars = word.toCharArray();

                PrefixTree current = root;
                for (char c: chars) {
                        if (current.kids[c-97]==null)
                                current.kids[c-97] = new PrefixTree(c); 
                        current = current.kids[c-97];
                                
                }
                current.isWordMatch = true;

        }


        public boolean lookup(String word, PrefixTree root) {
                char[] chars = word.toCharArray();

                PrefixTree current = root;
                for (int i=0; i< chars.length; i++) {
                        if (current == null) {
                                return false;
                        }

                        current = current.kids[chars[i]-97];

                }

                if (current==null)
                        return false;
                else if (!current.isWordMatch)
                        return false;
                else
                        return true;


        }

}

class PrefixTree {

	char val;
	PrefixTree[] kids= new PrefixTree[26];
	boolean isWordMatch = false;	

	public PrefixTree(char v) {
		this.val = v;
	}
}
