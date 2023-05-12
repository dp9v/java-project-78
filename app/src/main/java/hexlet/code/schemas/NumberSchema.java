package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        checks.add(n -> n == null || n instanceof Integer);
    }

    public NumberSchema required() {
        checks.add(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        checks.add(n -> n == null || ((Integer) n) > 0);
        return this;
    }

    public NumberSchema range(int leftBorder, int rightBorder) {
        checks.add(n -> n == null || (((Integer) n) >= leftBorder && ((Integer) n) <= rightBorder));
        return this;
    }
}
