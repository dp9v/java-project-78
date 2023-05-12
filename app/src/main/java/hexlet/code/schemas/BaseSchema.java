package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    protected final List<Predicate> checks = new ArrayList<>();

    public boolean isValid(Object validatedString) {
        return checks.stream()
            .allMatch(sp -> sp.test(validatedString));
    }
}
