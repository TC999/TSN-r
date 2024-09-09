package com.qq.e.lib.a.b.c;

import android.text.TextUtils;
import com.qq.e.lib.a.e.c;
import com.qq.e.lib.a.e.d;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends c {

    /* renamed from: d  reason: collision with root package name */
    private static ThreadLocal<byte[]> f47303d = new ThreadLocal<>();

    public a(d dVar) {
        super(dVar);
    }

    protected static byte[] b() {
        byte[] bArr = f47303d.get();
        if (bArr == null) {
            byte[] bArr2 = new byte[4];
            f47303d.set(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public boolean a(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int c4 = c();
        for (int i4 = 0; i4 < 4; i4++) {
            if (((c4 >> (i4 * 8)) & 255) != str.charAt(i4)) {
                return false;
            }
        }
        return true;
    }

    public int c() throws IOException {
        byte[] b4 = b();
        read(b4, 0, 4);
        return ((b4[3] & 255) << 24) | (b4[0] & 255) | ((b4[1] & 255) << 8) | ((b4[2] & 255) << 16);
    }

    public int d() throws IOException {
        byte[] b4 = b();
        read(b4, 0, 4);
        return ((b4[0] & 255) << 24) | (b4[3] & 255) | ((b4[2] & 255) << 8) | ((b4[1] & 255) << 16);
    }

    public short e() throws IOException {
        byte[] b4 = b();
        read(b4, 0, 2);
        return (short) (((b4[0] & 255) << 8) | (b4[1] & 255));
    }
}
