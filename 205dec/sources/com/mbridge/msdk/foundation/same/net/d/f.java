package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import java.io.UnsupportedEncodingException;

/* compiled from: StringRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f extends i<String> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f39537c = f.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private String f39538d;

    public f(int i4, String str, String str2, com.mbridge.msdk.foundation.same.net.e<String> eVar) {
        super(i4, str, eVar);
        this.f39538d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.i
    public final k<String> a(com.mbridge.msdk.foundation.same.net.e.c cVar) {
        try {
            return k.a(new String(cVar.f39546b, com.mbridge.msdk.foundation.same.net.f.b.a(cVar.f39548d)), cVar);
        } catch (UnsupportedEncodingException e4) {
            x.d(f39537c, e4.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final byte[] e() {
        try {
            String str = this.f39538d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = f39537c;
            x.d(str2, "Unsupported Encoding while trying to get the bytes of " + this.f39538d + " using utf-8");
            return null;
        }
    }
}
