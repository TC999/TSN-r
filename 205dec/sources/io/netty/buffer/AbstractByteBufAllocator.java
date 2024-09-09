package io.netty.buffer;

import io.netty.util.ResourceLeak;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    private static final int DEFAULT_INITIAL_CAPACITY = 256;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.buffer.AbstractByteBufAllocator$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        static {
            int[] iArr = new int[ResourceLeakDetector.Level.values().length];
            $SwitchMap$io$netty$util$ResourceLeakDetector$Level = iArr;
            try {
                iArr[ResourceLeakDetector.Level.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.PARANOID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected AbstractByteBufAllocator() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf) {
        ByteBuf simpleLeakAwareByteBuf;
        ResourceLeak open;
        int i4 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i4 == 1) {
            ResourceLeak open2 = AbstractByteBuf.leakDetector.open(byteBuf);
            if (open2 == null) {
                return byteBuf;
            }
            simpleLeakAwareByteBuf = new SimpleLeakAwareByteBuf(byteBuf, open2);
        } else if ((i4 != 2 && i4 != 3) || (open = AbstractByteBuf.leakDetector.open(byteBuf)) == null) {
            return byteBuf;
        } else {
            simpleLeakAwareByteBuf = new AdvancedLeakAwareByteBuf(byteBuf, open);
        }
        return simpleLeakAwareByteBuf;
    }

    private static void validate(int i4, int i5) {
        if (i4 >= 0) {
            if (i4 > i5) {
                throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i4), Integer.valueOf(i5)));
            }
            return;
        }
        throw new IllegalArgumentException("initialCapacity: " + i4 + " (expectd: 0+)");
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        if (this.directByDefault) {
            return directBuffer();
        }
        return heapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException("minNewCapacity: " + i4 + " (expectd: 0+)");
        } else if (i4 <= i5) {
            if (i4 == 4194304) {
                return 4194304;
            }
            if (i4 > 4194304) {
                int i6 = (i4 / 4194304) * 4194304;
                return i6 > i5 - 4194304 ? i5 : i6 + 4194304;
            }
            int i7 = 64;
            while (i7 < i4) {
                i7 <<= 1;
            }
            return Math.min(i7, i5);
        } else {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i4), Integer.valueOf(i5)));
        }
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        if (this.directByDefault) {
            return compositeDirectBuffer();
        }
        return compositeHeapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return compositeDirectBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return compositeHeapBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return directBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return heapBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        if (PlatformDependent.hasUnsafe()) {
            return directBuffer(256);
        }
        return heapBuffer(256);
    }

    protected abstract ByteBuf newDirectBuffer(int i4, int i5);

    protected abstract ByteBuf newHeapBuffer(int i4, int i5);

    public String toString() {
        return StringUtil.simpleClassName(this) + "(directByDefault: " + this.directByDefault + ')';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractByteBufAllocator(boolean z3) {
        this.directByDefault = z3 && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i4) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i4));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i4) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i4));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i4) {
        return directBuffer(i4, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i4) {
        return heapBuffer(i4, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return this.emptyBuf;
        }
        validate(i4, i5);
        return newDirectBuffer(i4, i5);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return this.emptyBuf;
        }
        validate(i4, i5);
        return newHeapBuffer(i4, i5);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i4) {
        if (this.directByDefault) {
            return directBuffer(i4);
        }
        return heapBuffer(i4);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i4) {
        if (this.directByDefault) {
            return compositeDirectBuffer(i4);
        }
        return compositeHeapBuffer(i4);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i4) {
        if (PlatformDependent.hasUnsafe()) {
            return directBuffer(i4);
        }
        return heapBuffer(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        CompositeByteBuf simpleLeakAwareCompositeByteBuf;
        ResourceLeak open;
        int i4 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i4 == 1) {
            ResourceLeak open2 = AbstractByteBuf.leakDetector.open(compositeByteBuf);
            if (open2 == null) {
                return compositeByteBuf;
            }
            simpleLeakAwareCompositeByteBuf = new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, open2);
        } else if ((i4 != 2 && i4 != 3) || (open = AbstractByteBuf.leakDetector.open(compositeByteBuf)) == null) {
            return compositeByteBuf;
        } else {
            simpleLeakAwareCompositeByteBuf = new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, open);
        }
        return simpleLeakAwareCompositeByteBuf;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i4, int i5) {
        if (this.directByDefault) {
            return directBuffer(i4, i5);
        }
        return heapBuffer(i4, i5);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i4, int i5) {
        if (PlatformDependent.hasUnsafe()) {
            return directBuffer(i4, i5);
        }
        return heapBuffer(i4, i5);
    }
}
