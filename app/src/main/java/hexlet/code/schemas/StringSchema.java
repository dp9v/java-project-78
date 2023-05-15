package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        addCheck(s -> s == null || s instanceof String);
    }

    public StringSchema required() {
        addCheck(s -> s != null && ((String) s).length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck(s -> s == null || ((String) s).length() >= length);
        return this;
    }

    public StringSchema contains(String subString) {
        addCheck(s -> s == null || ((String) s).contains(subString));
        return this;
    }

}
