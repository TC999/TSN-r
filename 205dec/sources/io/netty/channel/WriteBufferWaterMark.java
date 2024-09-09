package io.netty.channel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class WriteBufferWaterMark {
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
    private static final int DEFAULT_HIGH_WATER_MARK = 65536;
    private static final int DEFAULT_LOW_WATER_MARK = 32768;
    private final int high;
    private final int low;

    public WriteBufferWaterMark(int i4, int i5) {
        this(i4, i5, true);
    }

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("WriteBufferWaterMark(low: ");
        sb.append(this.low);
        sb.append(", high: ");
        sb.append(this.high);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteBufferWaterMark(int i4, int i5, boolean z3) {
        if (z3) {
            if (i4 < 0) {
                throw new IllegalArgumentException("write buffer's low water mark must be >= 0");
            }
            if (i5 < i4) {
                throw new IllegalArgumentException("write buffer's high water mark cannot be less than  low water mark (" + i4 + "): " + i5);
            }
        }
        this.low = i4;
        this.high = i5;
    }
}
