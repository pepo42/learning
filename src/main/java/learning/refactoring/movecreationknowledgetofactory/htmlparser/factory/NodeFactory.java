package learning.refactoring.movecreationknowledgetofactory.htmlparser.factory;

import learning.refactoring.movecreationknowledgetofactory.htmlparser.nodes.DecodingStringNode;
import learning.refactoring.movecreationknowledgetofactory.htmlparser.nodes.Node;
import learning.refactoring.movecreationknowledgetofactory.htmlparser.nodes.StringNode;

public class NodeFactory {

    // Nonstatic because I don't want client code statically bound to one Factory implementation
    public Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
        if (shouldDecode) {
            return new DecodingStringNode(new StringNode(textBuffer, textBegin, textEnd));
        }
        return new StringNode(textBuffer, textBegin, textEnd);
    }
}
