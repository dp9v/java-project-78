package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        addCheck(m -> m == null || m instanceof Map);
    }

    public MapSchema sizeof(int size) {
        addCheck(m -> m == null || ((Map) m).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(map ->
            schemas.entrySet()
                .stream()
                .allMatch(e -> e.getValue().isValid(((Map) map).get(e.getKey())))
        );
        return this;
    }
}
