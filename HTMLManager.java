import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;

  public HTMLManager(Queue<HTMLTag> html) {
    if(html = null) {
      throw new IllegalArgumentException();
    }
    tags = new LinkedList<HTMLTag>();
    for(HTMLTag tag : html) {}
    
  }

  public Queue<HTMLTag> getTags() {
    return tags;
  }

  public String toString() {
    String result = "";
    int size = tags.size();
    for(int i = 0; i < size; i++) {
      tags.remove();
      return += tag.toString.trim();
    }
    
  }

  public void fixHTML() {}

  

  

  
}
