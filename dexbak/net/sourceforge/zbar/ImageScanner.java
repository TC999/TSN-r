package net.sourceforge.zbar;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ImageScanner {
    private long peer = create();

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    private native long create();

    private native void destroy(long j);

    private native long getResults(long j);

    private static native void init();

    public synchronized void destroy() {
        long j = this.peer;
        if (j != 0) {
            destroy(j);
            this.peer = 0L;
        }
    }

    public native void enableCache(boolean z);

    protected void finalize() {
        destroy();
    }

    public SymbolSet getResults() {
        return new SymbolSet(getResults(this.peer));
    }

    public native void parseConfig(String str);

    public native int scanImage(Image image);

    public native void setConfig(int i, int i2, int i3) throws IllegalArgumentException;
}
