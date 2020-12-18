import java.io.IOException;
import java.util.ArrayList;

public class WebNode {
	public WebNode parent;
	public ArrayList<WebNode> children;//ADT arrayList
	public WebPage webPage;//child element
	public double nodeScore;//main element This node's score += all its children¡¦s nodeScore
	
	public WebNode(WebPage webPage){
		this.children = new ArrayList<WebNode>();
		this.webPage = webPage;
	}
	
	//this method should be called in post-order mode
	public void setNodeScore(ArrayList<Keyword> keywords) throws IOException{
		
		//compute webPage score
		webPage.setScore(keywords);
		//set webPage score to node Score
		nodeScore += webPage.score;
		//nodeScorer += all children's nodeScore
		for (WebNode child : children) 
		{
			nodeScore += child.nodeScore;
		}
	}
	
	//add the WebNode to its children list
	public void addChild(WebNode child) {
		this.children.add(child);
		child.parent = this;
	}
	
	public boolean isLastChild() {
		if (this.parent == null) return true;
		ArrayList<WebNode> siblings = this.parent.children;
		
		return this.equals(siblings.get(siblings.size() - 1));
	}
	
	public int getDepth() {
		int retVal = 1;
		WebNode currNode = this;
		while(currNode.parent != null) {
			retVal++;
			currNode = currNode.parent;
		}
		return retVal;
	}
}
