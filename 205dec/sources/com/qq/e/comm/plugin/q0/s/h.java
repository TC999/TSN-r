package com.qq.e.comm.plugin.q0.s;

import android.net.Uri;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;

/* compiled from: A */
@Deprecated
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends a {

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.q0.g f45555e;

    public h(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.g gVar) {
        super(hVar);
        this.f45555e = gVar;
    }

    public com.qq.e.comm.plugin.q0.g a() {
        return this.f45555e;
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public void b(String str) {
        a(new String[0]);
        try {
            Uri parse = Uri.parse(str);
            if (i2.b(parse)) {
                d a4 = a(parse);
                if (a4 != null) {
                    com.qq.e.comm.plugin.q0.u.i a5 = this.f45525c.a(a4.a());
                    if (a5 != null) {
                        a5.a(this.f45523a, a4);
                    } else {
                        a(new e(a4, e.a.f45550e, "handler not found."));
                    }
                } else {
                    d1.a(String.format("ParseJSRequestReturn Null,reqUrl=%s", str));
                }
            }
        } catch (Throwable th) {
            d1.a(String.format("ExceptionWhileHandleJSRequest,reqUrl=%s", str), th);
        }
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public f<String> a(String str) {
        return new f<>(null);
    }
}
