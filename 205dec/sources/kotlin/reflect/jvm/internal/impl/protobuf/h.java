package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Internal.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f57662a;

    /* renamed from: b  reason: collision with root package name */
    public static final ByteBuffer f57663b;

    /* compiled from: Internal.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a {
        int getNumber();
    }

    /* compiled from: Internal.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface b<T extends a> {
        T a(int i4);
    }

    static {
        byte[] bArr = new byte[0];
        f57662a = bArr;
        f57663b = ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return u.e(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("UTF-8 not supported?", e4);
        }
    }
}
