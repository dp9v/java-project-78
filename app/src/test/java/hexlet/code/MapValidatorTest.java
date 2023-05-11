package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MapValidatorTest {
    @Test
    public void testRequired() {
        var validator = Validator.map();
        assertThat(validator.isValid(null)).isTrue();

        validator.required();
        assertThat(validator.isValid(null)).isFalse();
        assertThat(validator.isValid(new HashMap())).isTrue();
    }

    @Test
    public void testSizeof() {
        var validator = Validator.map().sizeof(2);

        assertThat(validator.isValid(Map.of("1", "1", "2", "2"))).isTrue();

        assertThat(validator.isValid(Map.of("1", "1"))).isFalse();
    }

    @Test
    public void shapeTest() {

        var schema = Validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", Validator.string().required());
        schemas.put("age", Validator.number().positive());
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
