import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class GoogleQuery {

	public String searchKeyword;
	public String url;
	public String content;

	public GoogleQuery(String searchKeyword){

		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q="+searchKeyword+"&oe=utf8&num=20";
	}

	private String fetchContent() throws IOException{
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in,"utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);	
		
		String line = null;
		while((line=bufReader.readLine())!=null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public HashMap<String, String> query() throws IOException{

		if(content==null)
			content= fetchContent();

		HashMap<String, String> retVal = new HashMap<String, String>();
			 //<Title, Url>
		Document doc = Jsoup.parse(content);		
		//System.out.println(doc.text()+"\n\n"); //Title	 
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		
		int count = 0;
		for(Element li : lis)
		{
			try 
			{			
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				//System.out.println(title + ","+citeUrl);					
									
				//count input keyword
				citeUrl = "https://www.google.com/" + citeUrl;
				URLEncoder.encode(citeUrl, "UTF-8");
				WordList wList = new WordList();
				WordCounter counter = new WordCounter(citeUrl);
				
				boolean hasError = false;						
					try 
					{
						for (Keyword w: wList.getList()) 
							w.count += counter.countKeyword(w.name); //update count
					} 
					catch(IOException e) {
						hasError = true;
						continue;
					}
					if (hasError == false)
					{
						//System.out.println(citeUrl);
						retVal.put(title, citeUrl);
						//for (Keyword w: wList.getList()) 
							//System.out.println(w);
					}			 								 				
			} 
			catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}
			
		} //for loop end
		return retVal; //show all search results' title and URL = last line in console
	}
}
