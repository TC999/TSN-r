package io.netty.buffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ByteBufAllocator {
    public static final ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    ByteBuf buffer();

    ByteBuf buffer(int i4);

    ByteBuf buffer(int i4, int i5);

    int calculateNewCapacity(int i4, int i5);

    CompositeByteBuf compositeBuffer();

    CompositeByteBuf compositeBuffer(int i4);

    CompositeByteBuf compositeDirectBuffer();

    CompositeByteBuf compositeDirectBuffer(int i4);

    CompositeByteBuf compositeHeapBuffer();

    CompositeByteBuf compositeHeapBuffer(int i4);

    ByteBuf directBuffer();

    ByteBuf directBuffer(int i4);

    ByteBuf directBuffer(int i4, int i5);

    ByteBuf heapBuffer();

    ByteBuf heapBuffer(int i4);

    ByteBuf heapBuffer(int i4, int i5);

    ByteBuf ioBuffer();

    ByteBuf ioBuffer(int i4);

    ByteBuf ioBuffer(int i4, int i5);

    boolean isDirectBufferPooled();
}
