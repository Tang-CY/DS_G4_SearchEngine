import java.util.ArrayList;

public class WordList {

	public int count = 0 ;
	public ArrayList<Keyword> wordList;
	
	public WordList() {
		
		wordList = new ArrayList<Keyword>();
//		Porsche Taiwan - Dr. Ing. h.c. F. Porsche AG
		wordList.add(new Keyword("Porsche Taiwan - Dr. Ing. h.c. F. Porsche AG", count, 10000000));
		wordList.add(new Keyword("https://www.porsche.com/", count, 10000000));
		wordList.add(new Keyword("Official", count, 10000000));
		wordList.add(new Keyword("porsche", count, 100));
		wordList.add(new Keyword("Taycan", count, 5));
		wordList.add(new Keyword("Macan", count, 5));
		wordList.add(new Keyword("Cayenne", count, 5));
		wordList.add(new Keyword("718", count, 1));
		wordList.add(new Keyword("911", count, 1));
		wordList.add(new Keyword("Ferdinand", count, 2));
		wordList.add(new Keyword("Stuttgart", count, 2));
		wordList.add(new Keyword("Panamera", count, 5));
	}
	
	public void add(Keyword w) {
		wordList.add(w);
	}
	
	public ArrayList<Keyword> getList(){
		return wordList;
	}
	
}
