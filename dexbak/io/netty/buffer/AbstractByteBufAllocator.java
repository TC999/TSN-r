package io.netty.buffer;

import io.netty.util.ResourceLeak;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    private static final int DEFAULT_INITIAL_CAPACITY = 256;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.AbstractByteBufAllocator$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C135941 {
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
        int i = C135941.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i == 1) {
            ResourceLeak open2 = AbstractByteBuf.leakDetector.open(byteBuf);
            if (open2 == null) {
                return byteBuf;
            }
            simpleLeakAwareByteBuf = new SimpleLeakAwareByteBuf(byteBuf, open2);
        } else if ((i != 2 && i != 3) || (open = AbstractByteBuf.leakDetector.open(byteBuf)) == null) {
            return byteBuf;
        } else {
            simpleLeakAwareByteBuf = new AdvancedLeakAwareByteBuf(byteBuf, open);
        }
        return simpleLeakAwareByteBuf;
    }

    private static void validate(int i, int i2) {
        if (i >= 0) {
            if (i > i2) {
                throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            return;
        }
        throw new IllegalArgumentException("initialCapacity: " + i + " (expectd: 0+)");
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        if (this.directByDefault) {
            return directBuffer();
        }
        return heapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("minNewCapacity: " + i + " (expectd: 0+)");
        } else if (i <= i2) {
            if (i == 4194304) {
                return 4194304;
            }
            if (i > 4194304) {
                int i3 = (i / 4194304) * 4194304;
                return i3 > i2 - 4194304 ? i2 : i3 + 4194304;
            }
            int i4 = 64;
            while (i4 < i) {
                i4 <<= 1;
            }
            return Math.min(i4, i2);
        } else {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
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

    protected abstract ByteBuf newDirectBuffer(int i, int i2);

    protected abstract ByteBuf newHeapBuffer(int i, int i2);

    public String toString() {
        return StringUtil.simpleClassName(this) + "(directByDefault: " + this.directByDefault + ')';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractByteBufAllocator(boolean z) {
        this.directByDefault = z && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i) {
        return directBuffer(i, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i) {
        return heapBuffer(i, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.emptyBuf;
        }
        validate(i, i2);
        return newDirectBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.emptyBuf;
        }
        validate(i, i2);
        return newHeapBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i) {
        if (this.directByDefault) {
            return directBuffer(i);
        }
        return heapBuffer(i);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i) {
        if (this.directByDefault) {
            return compositeDirectBuffer(i);
        }
        return compositeHeapBuffer(i);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i) {
        if (PlatformDependent.hasUnsafe()) {
            return directBuffer(i);
        }
        return heapBuffer(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        CompositeByteBuf simpleLeakAwareCompositeByteBuf;
        ResourceLeak open;
        int i = C135941.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i == 1) {
            ResourceLeak open2 = AbstractByteBuf.leakDetector.open(compositeByteBuf);
            if (open2 == null) {
                return compositeByteBuf;
            }
            simpleLeakAwareCompositeByteBuf = new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, open2);
        } else if ((i != 2 && i != 3) || (open = AbstractByteBuf.leakDetector.open(compositeByteBuf)) == null) {
            return compositeByteBuf;
        } else {
            simpleLeakAwareCompositeByteBuf = new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, open);
        }
        return simpleLeakAwareCompositeByteBuf;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i, int i2) {
        if (this.directByDefault) {
            return directBuffer(i, i2);
        }
        return heapBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i, int i2) {
        if (PlatformDependent.hasUnsafe()) {
            return directBuffer(i, i2);
        }
        return heapBuffer(i, i2);
    }
}
