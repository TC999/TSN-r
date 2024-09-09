package defpackage;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: I0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class I0 extends ArrayList {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f31a = 0;

    public static int a(ByteBuffer byteBuffer) {
        byte b4 = byteBuffer.get();
        return (b4 & 128) != 0 ? ((b4 & Byte.MAX_VALUE) << 8) | (byteBuffer.get() & 255) : b4 & 255;
    }
}
