package hexlet.code;

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
}
