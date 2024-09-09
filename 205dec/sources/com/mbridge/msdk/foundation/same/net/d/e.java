package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.tools.x;
import java.io.UnsupportedEncodingException;

/* compiled from: JsonRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class e<T> extends i<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f39535c = e.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private final String f39536d;

    public e(int i4, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar) {
        super(i4, str, eVar);
        this.f39536d = str2;
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final byte[] e() {
        try {
            String str = this.f39536d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = f39535c;
            x.d(str2, "Unsupported Encoding while trying to get the bytes of " + this.f39536d + " using utf-8");
            return null;
        }
    }
}
