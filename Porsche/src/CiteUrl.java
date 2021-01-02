import org.apache.jasper.tagplugins.jstl.core.Url;

public class CiteUrl {
	
	public int score = 0;
	
	public CiteUrl(String citeUrl) {
		countScore();
	}
	
	public void countScore() {
		WordList wl = new WordList();
		for (Keyword k: wl.getList())
		{
			this.score += k.count * k.weight;
		}
	}
}
