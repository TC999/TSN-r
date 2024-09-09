package io.netty.channel.unix;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class Buffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private Buffer() {
    }

    public static int addressSize() {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.addressSize();
        }
        return addressSize0();
    }

    private static native int addressSize0();

    public static ByteBuffer allocateDirectWithNativeOrder(int i4) {
        return ByteBuffer.allocateDirect(i4).order(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
    }

    public static void free(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
    }

    public static long memoryAddress(ByteBuffer byteBuffer) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.directBufferAddress(byteBuffer);
        }
        return memoryAddress0(byteBuffer);
    }

    private static native long memoryAddress0(ByteBuffer byteBuffer);
}
