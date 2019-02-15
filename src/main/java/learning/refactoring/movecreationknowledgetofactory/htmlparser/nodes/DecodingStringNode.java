package learning.refactoring.movecreationknowledgetofactory.htmlparser.nodes;

public class DecodingStringNode implements Node {
    private StringNode stringNode;

    public DecodingStringNode(StringNode stringNode) {
        this.stringNode = stringNode;
    }
}
