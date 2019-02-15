package learning.refactoring.movecreationknowledgetofactory.htmlparser.parser;

import learning.refactoring.movecreationknowledgetofactory.htmlparser.factory.NodeFactory;
import learning.refactoring.movecreationknowledgetofactory.htmlparser.nodes.Node;

public class StringParser {
    private Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node find(StringBuffer textBuffer, int textBegin, int textEnd) {
        // some logic here

        NodeFactory nodeFactory = new NodeFactory();
        return nodeFactory.createStringNode(textBuffer, textBegin, textEnd, parser.shouldDecodeNodes());
    }
}
