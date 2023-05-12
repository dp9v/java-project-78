package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        checks.add(m -> m == null || m instanceof Map);
    }

    public MapSchema required() {
        checks.add(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        checks.add(m -> m == null || ((Map) m).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        checks.add(map ->
            schemas.entrySet()
                .stream()
                .allMatch(e -> e.getValue().isValid(((Map) map).get(e.getKey())))
        );
        return this;
    }
}
