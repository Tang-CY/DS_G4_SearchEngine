import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class GoogleQuery{

	public String searchKeyword;
	public String url;
	public String content;
	public PriorityQueue<WebNode> temp; 

	public GoogleQuery(String searchKeyword) throws IOException{

		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q="+searchKeyword+"&oe=utf8&num=20";
		this.temp = new PriorityQueue<WebNode>(new NodeComparator());
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
	
	public String[][] query() throws IOException{

		if(content==null)
			content= fetchContent();
			 //<Title, Url>
		Document doc = Jsoup.parse(content);		
		//System.out.println(doc.text()+"\n\n"); //Title	 
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		String[][] retVal = new String[lis.size()][2];
		
		for(Element li : lis)
		{
			try 
			{			
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();				
									
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
						temp.offer(new WebNode(new WebPage(citeUrl, title)));
					}			 								 				
			} 
			catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}		
		}
		WebNode n;
		for (int i = 0; i < temp.size(); i++)
		{
			if ((n = (WebNode)temp.poll()) != null)
			{	
				retVal[i][0] = n.webPage.name;
				retVal[i][1] = n.webPage.url;
			}
		}
		return retVal;
	}
}
