package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        checks.add(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        checks.add(m -> m.size() == size);
        return this;
    }
}
