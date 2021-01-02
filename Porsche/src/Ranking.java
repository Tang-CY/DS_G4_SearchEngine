import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.jasper.tagplugins.jstl.core.Url;

public class Ranking {
	
	private ArrayList<String> dough;
	private ArrayList<String> donut;
	private WordList L;
	private GoogleQuery G;
	
	public Ranking(String searchKeyword) throws IOException {
		G = new GoogleQuery(searchKeyword);
		this.L = new WordList();
		dough = new ArrayList<String>();
		donut = new ArrayList<String>();
		dough = G.cites;
		ranking();
	}
	
	public void ranking() throws NullPointerException{
		for (String c: dough) 
		{
	        System.out.println(new CiteUrl(c).score);
	    } 
	}
	
	/*public String display(){
		String result = "";
		for (int i = 0; i < donut.size(); i++)
			result += donut.get(i) + "\n";
		return result;
	}*/
	
}
