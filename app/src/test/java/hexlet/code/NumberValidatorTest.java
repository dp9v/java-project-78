package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberValidatorTest {
    @Test
    public void testRequired() {
        var validator = Validator.number();
        assertThat(validator.isValid(null)).isTrue();

        validator.required();
        assertThat(validator.isValid(null)).isFalse();
        assertThat(validator.isValid(1)).isTrue();
    }

    @Test
    public void testPositive() {
        var validator = Validator.number().positive();

        assertThat(validator.isValid(-1)).isFalse();
        assertThat(validator.isValid(0)).isFalse();
        assertThat(validator.isValid(1)).isTrue();
    }

    @Test
    public void testRange() {
        var validator = Validator.number().range(-1, 1);

        assertThat(validator.isValid(-2)).isFalse();

        assertThat(validator.isValid(-1)).isTrue();
        assertThat(validator.isValid(1)).isTrue();
        assertThat(validator.isValid(2)).isFalse();


    }
}
