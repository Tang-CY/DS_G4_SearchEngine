import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//User Input
		System.out.println("Enter Keyword: ");
		Scanner sc = new Scanner(System.in);
		String keyword = sc.next();
		System.out.println("running...");	
		
		try {
			System.out.println(new GoogleQuery(keyword).query());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}}
