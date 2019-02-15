package learning.refactoring.movecreationknowledgetofactory.htmlparser.parser;

import learning.refactoring.movecreationknowledgetofactory.htmlparser.nodes.Node;
import learning.refactoring.movecreationknowledgetofactory.htmlparser.nodes.StringNode;

public class StringParser {
    private Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node find(StringBuffer textBuffer, int textBegin, int textEnd) {
        // some logic here
        return StringNode.createStringNode(textBuffer, textBegin, textEnd, parser.shouldDecodeNodes());
    }
}
