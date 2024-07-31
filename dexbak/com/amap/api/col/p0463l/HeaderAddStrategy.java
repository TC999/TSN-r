package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.k7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class HeaderAddStrategy extends UpdateDataStrategy {

    /* renamed from: c */
    private Context f4600c;

    /* renamed from: d */
    private String f4601d;

    /* renamed from: e */
    private EncryptProcessor f4602e;

    /* renamed from: f */
    private Object[] f4603f;

    public HeaderAddStrategy(Context context, UpdateDataStrategy updateDataStrategy, EncryptProcessor encryptProcessor, String str, Object... objArr) {
        super(updateDataStrategy);
        this.f4600c = context;
        this.f4601d = str;
        this.f4602e = encryptProcessor;
        this.f4603f = objArr;
    }

    /* renamed from: d */
    private String m54634d() {
        try {
            return String.format(C1925p4.m54183u(this.f4601d), this.f4603f);
        } catch (Throwable th) {
            th.printStackTrace();
            SDKLogHandler.m53863p(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: b */
    protected final byte[] mo54164b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String m54197g = C1925p4.m54197g(bArr);
        if (TextUtils.isEmpty(m54197g)) {
            return null;
        }
        String m54197g2 = C1925p4.m54197g(this.f4602e.m54710b(C1925p4.m54189o(m54634d())));
        return C1925p4.m54189o("{\"pinfo\":\"" + m54197g2 + "\",\"els\":[" + m54197g + "]}");
    }
}
