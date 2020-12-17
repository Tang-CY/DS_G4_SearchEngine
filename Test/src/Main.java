import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//User Input
		System.out.println("Enter Keyword: ");
		Scanner sc = new Scanner(System.in);
		String keyword = sc.next();
		
		// fetch URL on google
		try {
			System.out.println(new GoogleQuery(keyword).query());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		// word counter
		while(sc.hasNextLine())
		{
		    //String urlStr = ;
		     String keyword = sc.next();
		   
		    WordCounter counter = new WordCounter(urlStr);
		    System.out.println(counter.countKeyword(keyword));//times keyword appears
		}*/
	
	}}
