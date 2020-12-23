import java.util.ArrayList;

public class WordList {

	public int count = 0 ;
	public ArrayList<Keyword> wordList;
	
	public WordList() {
		
		wordList = new ArrayList<Keyword>();
		
		Keyword w1 = new Keyword("porsche", count, 5);
		wordList.add(w1);
		Keyword w2 = new Keyword("Taycan", count, 5);
		wordList.add(w2);
		Keyword w3 = new Keyword("Macan", count, 5);
		wordList.add(w3);
		Keyword w4 = new Keyword("Cayenne", count, 5);
		wordList.add(w4);
		Keyword w5 = new Keyword("718", count, 4);
		wordList.add(w5);
		Keyword w6 = new Keyword("911", count, 3);
		wordList.add(w6);
		Keyword w7 = new Keyword("Ferdinand", count, 2);
		wordList.add(w7);
		Keyword w8 = new Keyword("Stuttgart", count, 2);
		wordList.add(w8);
		Keyword w9 = new Keyword("Panamera", count, 5);
		wordList.add(w9);
	}
	
	public void add(Keyword w) {
		wordList.add(w);
	}
	
	public ArrayList<Keyword> getList(){
		return wordList;
	}
	
}
