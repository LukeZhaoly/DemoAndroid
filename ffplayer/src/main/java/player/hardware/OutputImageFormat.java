package player.hardware;

public enum OutputImageFormat {
    I420("I420"),
    NV21("NV21"),
    JPEG("JPEG");
    private final String friendlyName;

    private OutputImageFormat(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String toString() {
        return friendlyName;
    }
}
