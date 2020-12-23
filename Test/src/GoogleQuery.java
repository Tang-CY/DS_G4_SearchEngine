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
		
		//conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

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
		
		Document doc = Jsoup.parse(content);
		
		System.out.println(doc.text()+"\n\n");
		 
		Elements lis = doc.select("div");
		// System.out.println(lis);
		
		lis = lis.select(".kCrYT");
		//System.out.println(lis.size());
		
		int count = 0;
		for(Element li : lis)
		{
			try 
			{			
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				//System.out.println(title + ","+citeUrl);
					
				//System.out.println(li);	//¦L­ìµ²ªG
				
				try {	
				//count input keyword
					citeUrl = "https://www.google.com/" + citeUrl;
					URLEncoder.encode(citeUrl, "UTF-8");
					System.out.println(citeUrl);
					WordCounter counter = new WordCounter(citeUrl);
					WordList wList = new WordList();
					for (Keyword w: wList.getList()) 
					{
						//System.out.println(w+": "+counter.countKeyword(w.name));
						w.count += counter.countKeyword(w.name);
						System.out.println(w);
					}
				    
					retVal.put(title, citeUrl);
					
				} catch(IOException e) {
					System.out.println("ERROR\n");
					continue;}
				
			} catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}
		}
		return retVal; //show all search results' title and URL
	}
}
