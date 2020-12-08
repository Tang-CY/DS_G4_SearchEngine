import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Spider extends LinkedList{
	private String urlStr;
	private LinkedList<String> pool;
	
	public Spider(String urlStr) {
		this.urlStr = urlStr;
	} 
	//網頁收集器gather
	public String gather() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line = null;
		
		String re = "";
		
		while((line = br.readLine()) != null)
		{
			re = re + line + "\n";
		}
		pool.add(re);
		return re;
	}
	
	/*網頁數據抓代碼 : 將收集到的網頁依據不同種類坐不同處理
		1. 放入網頁庫
	*	2. 分析->抽取URL->放入URL池
	*/
	public LinkedList<String> urlDetector(String htmlDoc){
		final String patternString = "[a|A]\\s+href = ([^>]*\\s*>)";
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		pool = new LinkedList<String>();
		Matcher matcher = pattern.matcher(htmlDoc);
		String tempURL;
		
		while (matcher.find()) {
			 tempURL = matcher.group();
			tempURL = tempURL.substring(tempURL.indexOf("\"") + 1);
			if (!tempURL.contains("\"")) continue;
			tempURL = tempURL.substring(0, tempURL.indexOf("\""));
		}
		return pool;
	}
	// URL 識別代碼

	
	
	
	
	
	
}
