package Constants;

public enum XPositionChange {
    DEFAULT_TO_0(-60, "0");

    public int xPositionChange;
    public String setValue;

    XPositionChange(int xPositionChange, String setValue) {
        this.xPositionChange = xPositionChange;
        this.setValue = setValue;
    }
}
