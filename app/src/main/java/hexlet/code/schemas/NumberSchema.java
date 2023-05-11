package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        checks.add(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        checks.add(n -> n > 0);
        return this;
    }

    public NumberSchema range(int leftBorder, int rightBorder) {
        checks.add(n -> n >= leftBorder && n <= rightBorder);
        return this;
    }
}
