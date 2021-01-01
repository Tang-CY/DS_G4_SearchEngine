import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ranking {
	
	private HashMap<String, String> dough;
	private HashMap<String, String> donut;
	private WordList L;
	
	public Ranking(String searchKeyword) throws IOException {
		GoogleQuery  G= new GoogleQuery(searchKeyword);
		this.L = new WordList();
		dough = new HashMap<String, String>();
		donut = new HashMap<String, String>();
		dough = G.query();
		//ranking();
		System.out.println(dough);
	}
	
	/*public void ranking() throws NullPointerException{
		int max = 0;
		int score = 0;
		//while (dough.isEmpty() == false)
		//{
			for (Map.Entry in: dough.entrySet()) {
		          for (Keyword w: L.getList()) {
		        	  score += w.count * w.weight;
		          	  if (score > max) {
		          		  max = score; 
		          		  System.out.println("Max Score: "+ max + "#1: " + in);
		          	  }
		          }
		    }
			//dough.remove("fuck");
		//} 	  
	}
	
	/*public String display(){
		String result = "";
		for (int i = 0; i < donut.size(); i++)
			result += donut.get(i) + "\n";
		return result;
	}*/
	
}
