package Constants;

public enum Service {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with Pages"),
    DIFFERENT_ELEMENTS("Different elements");

    public String text;

    Service(String text) {
        this.text = text;
    }
}
