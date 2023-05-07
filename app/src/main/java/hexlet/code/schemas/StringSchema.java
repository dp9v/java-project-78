package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private final List<Predicate<String>> checks = new ArrayList<>();

    public StringSchema required() {
        checks.add(s -> s != null && s.length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        checks.add(s -> s.length() >= length);
        return this;
    }

    public StringSchema contains(String subString) {
        checks.add(s -> s.contains(subString));
        return this;
    }

    public boolean isValid(String validatedString) {
        return checks.stream()
            .allMatch(sp -> sp.test(validatedString));
    }
}
