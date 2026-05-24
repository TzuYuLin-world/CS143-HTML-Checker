import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;

  public HTMLManager(Queue<HTMLTag> html) {
    if(html == null) {
      throw new IllegalArgumentException();
    }
    
    tags = new LinkedList<HTMLTag>();
    
    for(HTMLTag tag : html) {
      tags.add(tag);
    }
    
  }

  public Queue<HTMLTag> getTags() {
    return tags;
  }

  public String toString() {
    String result = "";
    int size = tags.size();
    
    for(int i = 0; i < size; i++) {
      HTMLTag tag = tags.remove();
      result += tag.toString().trim();
      tags.add(tag);
    }

    return result;
    
  }

  public void fixHTML() {
    Stack<HTMLTag> stack = new Stack<HTMLTag>();
    Queue<HTMLTag> fixed = new LinkedList<HTMLTag>();

    while(!tags.isEmpty()) {
      HTMLTag tag = tags.remove();
      
      if(tag.isSelfClosing()) {
        fixed.add(tag);
      } else if(tag.isOpening()) {
        fixed.add(tag);
        stack.push(tag);
      } else if(tag.isClosing()) {
        if(!stack.isEmpty()) {
          HTMLTag top = stack.peek();

          if(top.matches(tag)) {
            fixed.add(tag);
            stack.pop();
          } else {
            fixed.add(top.getMatching());
            stack.pop();
            tags.add(tag);
          }
        }
      }
        
    }
    while(!stack.isEmpty()) {
      fixed.add(stack.pop().getMatching());
    }

    tags = fixed;

  }

  

  

  
}
