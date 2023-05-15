package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberValidatorTest {
    private static final Validator VALIDATOR = new Validator();

    @Test
    public void testRequired() {
        var schema = VALIDATOR.number();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(1)).isTrue();
    }

    @Test
    public void testPositive() {
        var schema = VALIDATOR.number().positive();

        assertThat(schema.isValid(-1)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(1)).isTrue();
    }

    @Test
    public void testRange() {
        var schema = VALIDATOR.number().range(-1, 1);

        assertThat(schema.isValid(-2)).isFalse();

        assertThat(schema.isValid(-1)).isTrue();
        assertThat(schema.isValid(1)).isTrue();
        assertThat(schema.isValid(2)).isFalse();


    }
}
