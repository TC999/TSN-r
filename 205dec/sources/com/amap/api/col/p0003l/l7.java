package com.amap.api.col.p0003l;

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
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: HeaderAddStrategy.java */
/* renamed from: com.amap.api.col.3l.l7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l7 extends p7 {

    /* renamed from: c  reason: collision with root package name */
    private Context f8298c;

    /* renamed from: d  reason: collision with root package name */
    private String f8299d;

    /* renamed from: e  reason: collision with root package name */
    private j6 f8300e;

    /* renamed from: f  reason: collision with root package name */
    private Object[] f8301f;

    public l7(Context context, p7 p7Var, j6 j6Var, String str, Object... objArr) {
        super(p7Var);
        this.f8298c = context;
        this.f8299d = str;
        this.f8300e = j6Var;
        this.f8301f = objArr;
    }

    private String d() {
        try {
            return String.format(q4.u(this.f8299d), this.f8301f);
        } catch (Throwable th) {
            th.printStackTrace();
            u5.p(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.p0003l.p7
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String g4 = q4.g(bArr);
        if (TextUtils.isEmpty(g4)) {
            return null;
        }
        String g5 = q4.g(this.f8300e.b(q4.o(d())));
        return q4.o("{\"pinfo\":\"" + g5 + "\",\"els\":[" + g4 + "]}");
    }
}
