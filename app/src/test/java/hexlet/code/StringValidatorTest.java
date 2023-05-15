package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringValidatorTest {
    private static final Validator VALIDATOR = new Validator();

    @Test
    public void testRequired() {
        var schema = VALIDATOR.string();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("")).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("test")).isTrue();
    }

    @Test
    public void testMinLength() {
        var schema = VALIDATOR.string().minLength(3);
        assertThat(schema.isValid("12")).isFalse();
        assertThat(schema.isValid("123")).isTrue();
    }

    @Test
    public void testContains() {
        var schema = VALIDATOR.string().contains("test");
        assertThat(schema.isValid("adasdteast")).isFalse();
        assertThat(schema.isValid("123test231")).isTrue();
    }
}
