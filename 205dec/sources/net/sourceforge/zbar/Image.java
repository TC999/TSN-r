package net.sourceforge.zbar;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class Image {
    private Object data;
    private long peer;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    public Image() {
        this.peer = create();
    }

    private native long convert(long j4, String str);

    private native long create();

    private native void destroy(long j4);

    private native long getSymbols(long j4);

    private static native void init();

    public Image convert(String str) {
        long convert = convert(this.peer, str);
        if (convert == 0) {
            return null;
        }
        return new Image(convert);
    }

    public synchronized void destroy() {
        long j4 = this.peer;
        if (j4 != 0) {
            destroy(j4);
            this.peer = 0L;
        }
    }

    protected void finalize() {
        destroy();
    }

    public native int[] getCrop();

    public native byte[] getData();

    public native String getFormat();

    public native int getHeight();

    public native int getSequence();

    public native int[] getSize();

    public SymbolSet getSymbols() {
        return new SymbolSet(getSymbols(this.peer));
    }

    public native int getWidth();

    public native void setCrop(int i4, int i5, int i6, int i7);

    public native void setCrop(int[] iArr);

    public native void setData(byte[] bArr);

    public native void setData(int[] iArr);

    public native void setFormat(String str);

    public native void setSequence(int i4);

    public native void setSize(int i4, int i5);

    public native void setSize(int[] iArr);

    public Image(int i4, int i5) {
        this();
        setSize(i4, i5);
    }

    public Image(int i4, int i5, String str) {
        this();
        setSize(i4, i5);
        setFormat(str);
    }

    public Image(String str) {
        this();
        setFormat(str);
    }

    Image(long j4) {
        this.peer = j4;
    }
}
