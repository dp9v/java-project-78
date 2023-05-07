package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringValidatorTest {

    @Test
    public void testRequired() {
        var validator = Validator.string().required();

        assertThat(validator.isValid(null)).isFalse();
        assertThat(validator.isValid("")).isFalse();
        assertThat(validator.isValid("test")).isTrue();
    }

    @Test
    public void testMinLength() {
        var validator = Validator.string().minLength(3);
        assertThat(validator.isValid("12")).isFalse();
        assertThat(validator.isValid("123")).isTrue();
    }

    @Test
    public void testContains() {
        var validator = Validator.string().contains("test");
        assertThat(validator.isValid("adasdteast")).isFalse();
        assertThat(validator.isValid("123test231")).isTrue();
    }
}
