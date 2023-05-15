package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MapValidatorTest {
    private static final Validator VALIDATOR = new Validator();

    @Test
    public void testRequired() {
        var schema = VALIDATOR.map();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap())).isTrue();
    }

    @Test
    public void testSizeof() {
        var schema = VALIDATOR.map().sizeof(2);

        assertThat(schema.isValid(Map.of("1", "1", "2", "2"))).isTrue();

        assertThat(schema.isValid(Map.of("1", "1"))).isFalse();
    }

    @Test
    public void shapeTest() {

        var schema = VALIDATOR.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", VALIDATOR.string().required());
        schemas.put("age", VALIDATOR.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = Map.of(
            "name", "Kolya",
            "age", 100
        );
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Kolya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue();

        Map<String, Object> human3 = Map.of(
            "name", "",
            "age", 100
        );
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = Map.of(
            "name", "Valya",
            "age", -5
        );
        assertThat(schema.isValid(human4)).isFalse();
    }
}
