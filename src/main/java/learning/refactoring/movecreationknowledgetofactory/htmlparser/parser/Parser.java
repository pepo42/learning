package learning.refactoring.movecreationknowledgetofactory.htmlparser.parser;

public class Parser {
    private boolean shouldDecode;

    public Parser(boolean shouldDecode) {
        this.shouldDecode = shouldDecode;
    }

    public boolean shouldDecodeNodes() {
        return shouldDecode;
    }
}
