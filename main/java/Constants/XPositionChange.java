package Constants;

public enum XPositionChange {
    DEFAULT_TO_0(-60, "0"),
    DEFAULT_TO_100(0, "100"),
    FROM_100_TO_0(-300, "0"),
    FROM_0_TO_0(-1, "0"),
    FROM_0_TO_100(300, "100"),
    FROM_100_TO_30(-195, "30"),
    FROM_100_TO_70(-85, "70");

    public int xPositionChange;
    public String setValue;

    XPositionChange(int xPositionChange, String setValue) {
        this.xPositionChange = xPositionChange;
        this.setValue = setValue;
    }
}
