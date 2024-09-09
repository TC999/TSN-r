package io.netty.channel;

import io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT;
    static final int DEFAULT_INITIAL = 1024;
    static final int DEFAULT_MAXIMUM = 65536;
    static final int DEFAULT_MINIMUM = 64;
    private static final int INDEX_DECREMENT = 1;
    private static final int INDEX_INCREMENT = 4;
    private static final int[] SIZE_TABLE;
    private final int initial;
    private final int maxIndex;
    private final int minIndex;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private boolean decreaseNow;
        private int index;
        private final int maxIndex;
        private final int minIndex;
        private int nextReceiveBufferSize;

        public HandleImpl(int i4, int i5, int i6) {
            super();
            this.minIndex = i4;
            this.maxIndex = i5;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(i6);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        private void record(int i4) {
            if (i4 <= AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, (this.index - 1) - 1)]) {
                if (this.decreaseNow) {
                    this.index = Math.max(this.index - 1, this.minIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                this.decreaseNow = true;
            } else if (i4 >= this.nextReceiveBufferSize) {
                this.index = Math.min(this.index + 4, this.maxIndex);
                this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                this.decreaseNow = false;
            }
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            record(totalBytesRead());
        }
    }

    static {
        int i4;
        ArrayList arrayList = new ArrayList();
        int i5 = 16;
        while (true) {
            if (i5 >= 512) {
                break;
            }
            arrayList.add(Integer.valueOf(i5));
            i5 += 16;
        }
        for (i4 = 512; i4 > 0; i4 <<= 1) {
            arrayList.add(Integer.valueOf(i4));
        }
        SIZE_TABLE = new int[arrayList.size()];
        int i6 = 0;
        while (true) {
            int[] iArr = SIZE_TABLE;
            if (i6 < iArr.length) {
                iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
                i6++;
            } else {
                DEFAULT = new AdaptiveRecvByteBufAllocator();
                return;
            }
        }
    }

    public AdaptiveRecvByteBufAllocator() {
        this(64, 1024, 65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSizeTableIndex(int i4) {
        int length = SIZE_TABLE.length - 1;
        int i5 = 0;
        while (length >= i5) {
            if (length == i5) {
                return length;
            }
            int i6 = (i5 + length) >>> 1;
            int[] iArr = SIZE_TABLE;
            int i7 = iArr[i6];
            int i8 = i6 + 1;
            if (i4 > iArr[i8]) {
                i5 = i8;
            } else if (i4 >= i7) {
                return i4 == i7 ? i6 : i8;
            } else {
                length = i6 - 1;
            }
        }
        return i5;
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
    }

    public AdaptiveRecvByteBufAllocator(int i4, int i5, int i6) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("minimum: " + i4);
        } else if (i5 < i4) {
            throw new IllegalArgumentException("initial: " + i5);
        } else if (i6 >= i5) {
            int sizeTableIndex = getSizeTableIndex(i4);
            int[] iArr = SIZE_TABLE;
            if (iArr[sizeTableIndex] < i4) {
                this.minIndex = sizeTableIndex + 1;
            } else {
                this.minIndex = sizeTableIndex;
            }
            int sizeTableIndex2 = getSizeTableIndex(i6);
            if (iArr[sizeTableIndex2] > i6) {
                this.maxIndex = sizeTableIndex2 - 1;
            } else {
                this.maxIndex = sizeTableIndex2;
            }
            this.initial = i5;
        } else {
            throw new IllegalArgumentException("maximum: " + i6);
        }
    }
}
