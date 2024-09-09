package net.sourceforge.zbar;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ImageScanner {
    private long peer = create();

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    private native long create();

    private native void destroy(long j4);

    private native long getResults(long j4);

    private static native void init();

    public synchronized void destroy() {
        long j4 = this.peer;
        if (j4 != 0) {
            destroy(j4);
            this.peer = 0L;
        }
    }

    public native void enableCache(boolean z3);

    protected void finalize() {
        destroy();
    }

    public SymbolSet getResults() {
        return new SymbolSet(getResults(this.peer));
    }

    public native void parseConfig(String str);

    public native int scanImage(Image image);

    public native void setConfig(int i4, int i5, int i6) throws IllegalArgumentException;
}
