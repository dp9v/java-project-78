package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super.addCheck(n -> n == null || n instanceof Integer);
    }

    public NumberSchema positive() {
        addCheck(n -> n == null || ((Integer) n) > 0);
        return this;
    }

    public NumberSchema range(int leftBorder, int rightBorder) {
        addCheck(n -> n == null || (((Integer) n) >= leftBorder && ((Integer) n) <= rightBorder));
        return this;
    }
}
