package com.amap.api.col.p047s;

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

/* compiled from: HeaderAddStrategy.java */
/* renamed from: com.amap.api.col.s.l3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2091l3 extends AbstractC2117p3 {

    /* renamed from: c */
    private Context f6269c;

    /* renamed from: d */
    private String f6270d;

    /* renamed from: e */
    private AbstractC2102n2 f6271e;

    /* renamed from: f */
    private Object[] f6272f;

    public C2091l3(Context context, AbstractC2117p3 abstractC2117p3, AbstractC2102n2 abstractC2102n2, String str, Object... objArr) {
        super(abstractC2117p3);
        this.f6269c = context;
        this.f6270d = str;
        this.f6271e = abstractC2102n2;
        this.f6272f = objArr;
    }

    /* renamed from: d */
    private String m52776d() {
        try {
            return String.format(C2079j1.m52857t(this.f6270d), this.f6272f);
        } catch (Throwable th) {
            th.printStackTrace();
            C2060g2.m52972o(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: b */
    protected final byte[] mo52644b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String m52870g = C2079j1.m52870g(bArr);
        if (TextUtils.isEmpty(m52870g)) {
            return null;
        }
        String m52870g2 = C2079j1.m52870g(this.f6271e.m52733b(C2079j1.m52862o(m52776d())));
        return C2079j1.m52862o("{\"pinfo\":\"" + m52870g2 + "\",\"els\":[" + m52870g + "]}");
    }
}
