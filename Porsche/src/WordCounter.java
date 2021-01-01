import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
	private String urlStr;
	private String content;
	
	public WordCounter(String urlStr) {
		this.urlStr = urlStr;
	}
	
	private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String retVal = "";
		
		String line = null;
		
		while ((line = br.readLine()) != null) {
			retVal += line + "\n";
		}
		return retVal;
	}
	
	public int countKeyword(String keyword) throws IOException{
		
		if (content == null) {
			content = fetchContent();
		}
		//turn into upper-case
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		
		int retVal = 0;
		//calculate the appearances of keyword
		int curIndex = content.indexOf(keyword);
		while ((curIndex) != (-1)) {
			retVal++;
			curIndex = content.indexOf(keyword, ++curIndex);
		}
		return retVal;
	}
	
	
	
	
	
}
