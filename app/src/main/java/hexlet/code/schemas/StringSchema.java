package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public StringSchema() {
        checks.add(s -> s == null || s instanceof String);
    }

    public StringSchema required() {
        checks.add(s -> s != null && ((String) s).length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        checks.add(s -> s == null || ((String) s).length() >= length);
        return this;
    }

    public StringSchema contains(String subString) {
        checks.add(s -> s == null || ((String) s).contains(subString));
        return this;
    }

}
