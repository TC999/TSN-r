package net.sourceforge.zbar;

import android.graphics.PointF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class Symbol {
    public static final int CODABAR = 38;
    public static final int CODE128 = 128;
    public static final int CODE39 = 39;
    public static final int CODE93 = 93;
    public static final int DATABAR = 34;
    public static final int DATABAR_EXP = 35;
    public static final int EAN13 = 13;
    public static final int EAN8 = 8;
    public static final int I25 = 25;
    public static final int ISBN10 = 10;
    public static final int ISBN13 = 14;
    public static final int NONE = 0;
    public static final int PARTIAL = 1;
    public static final int PDF417 = 57;
    public static final int QRCODE = 64;
    public static final int UPCA = 12;
    public static final int UPCE = 9;
    private long peer;
    private int type;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Symbol(long j4) {
        this.peer = j4;
    }

    private native void destroy(long j4);

    private native long getComponents(long j4);

    private native int getLocationSize(long j4);

    private native int getLocationX(long j4, int i4);

    private native int getLocationY(long j4, int i4);

    private native int getType(long j4);

    private static native void init();

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

    public int[] getBounds() {
        int locationSize = getLocationSize(this.peer);
        if (locationSize <= 0) {
            return null;
        }
        int[] iArr = new int[4];
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MAX_VALUE;
        for (int i8 = 0; i8 < locationSize; i8++) {
            int locationX = getLocationX(this.peer, i8);
            if (i6 > locationX) {
                i6 = locationX;
            }
            if (i4 < locationX) {
                i4 = locationX;
            }
            int locationY = getLocationY(this.peer, i8);
            if (i7 > locationY) {
                i7 = locationY;
            }
            if (i5 < locationY) {
                i5 = locationY;
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        iArr[2] = i4 - i6;
        iArr[3] = i5 - i7;
        return iArr;
    }

    public SymbolSet getComponents() {
        return new SymbolSet(getComponents(this.peer));
    }

    public native int getConfigMask();

    public native int getCount();

    public native String getData();

    public native byte[] getDataBytes();

    public int[] getLocationPoint(int i4) {
        return new int[]{getLocationX(this.peer, i4), getLocationY(this.peer, i4)};
    }

    public PointF[] getLocationPoints() {
        int locationSize = getLocationSize(this.peer);
        PointF[] pointFArr = new PointF[locationSize];
        for (int i4 = 0; i4 < locationSize; i4++) {
            pointFArr[i4] = new PointF(getLocationX(this.peer, i4), getLocationY(this.peer, i4));
        }
        return pointFArr;
    }

    public int getLocationSize() {
        return getLocationSize(this.peer);
    }

    public native int getModifierMask();

    public native int getOrientation();

    public native int getQuality();

    public int getType() {
        if (this.type == 0) {
            this.type = getType(this.peer);
        }
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long next();
}
