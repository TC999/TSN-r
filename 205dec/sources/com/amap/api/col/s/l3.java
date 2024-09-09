package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HeaderAddStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l3 extends p3 {

    /* renamed from: c  reason: collision with root package name */
    private Context f9997c;

    /* renamed from: d  reason: collision with root package name */
    private String f9998d;

    /* renamed from: e  reason: collision with root package name */
    private n2 f9999e;

    /* renamed from: f  reason: collision with root package name */
    private Object[] f10000f;

    public l3(Context context, p3 p3Var, n2 n2Var, String str, Object... objArr) {
        super(p3Var);
        this.f9997c = context;
        this.f9998d = str;
        this.f9999e = n2Var;
        this.f10000f = objArr;
    }

    private String d() {
        try {
            return String.format(j1.t(this.f9998d), this.f10000f);
        } catch (Throwable th) {
            th.printStackTrace();
            g2.o(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String g4 = j1.g(bArr);
        if (TextUtils.isEmpty(g4)) {
            return null;
        }
        String g5 = j1.g(this.f9999e.b(j1.o(d())));
        return j1.o("{\"pinfo\":\"" + g5 + "\",\"els\":[" + g4 + "]}");
    }
}
