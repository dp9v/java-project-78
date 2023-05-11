package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        checks.add(s -> s != null && s.length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        checks.add(s -> s.length() >= length);
        return this;
    }

    public StringSchema contains(String subString) {
        checks.add(s -> s.contains(subString));
        return this;
    }

}
