package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0463l.BinaryRequest;
import com.amap.api.col.p0463l.SDKInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.autonavi.aps.amapapi.trans.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LocationRequest extends BinaryRequest {

    /* renamed from: d */
    Map<String, String> f8266d;

    /* renamed from: e */
    String f8267e;

    /* renamed from: f */
    String f8268f;

    /* renamed from: g */
    byte[] f8269g;

    /* renamed from: h */
    byte[] f8270h;

    /* renamed from: i */
    boolean f8271i;

    /* renamed from: j */
    String f8272j;

    /* renamed from: k */
    Map<String, String> f8273k;

    /* renamed from: p */
    boolean f8274p;

    /* renamed from: q */
    private String f8275q;

    public LocationRequest(Context context, SDKInfo sDKInfo) {
        super(context, sDKInfo);
        this.f8266d = null;
        this.f8275q = "";
        this.f8267e = "";
        this.f8268f = "";
        this.f8269g = null;
        this.f8270h = null;
        this.f8271i = false;
        this.f8272j = null;
        this.f8273k = null;
        this.f8274p = false;
    }

    /* renamed from: a */
    public final void m51379a(Map<String, String> map) {
        this.f8273k = map;
    }

    /* renamed from: b */
    public final void m51374b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(BinaryRequest.m54105a(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.f8270h = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: c */
    public final void m51371c(byte[] bArr) {
        this.f8269g = bArr;
    }

    @Override // com.amap.api.col.p0463l.BinaryRequest
    /* renamed from: d */
    public final byte[] mo51370d() {
        return this.f8270h;
    }

    @Override // com.amap.api.col.p0463l.BinaryRequest
    /* renamed from: f */
    public final boolean mo51368f() {
        return this.f8271i;
    }

    @Override // com.amap.api.col.p0463l.BinaryRequest
    /* renamed from: g */
    public final String mo51367g() {
        return this.f8272j;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPDNSName() {
        return this.f8275q;
    }

    @Override // com.amap.api.col.p0463l.IPV6Request, com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPV6URL() {
        return this.f8268f;
    }

    @Override // com.amap.api.col.p0463l.BinaryRequest, com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        return this.f8273k;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getRequestHead() {
        return this.f8266d;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        return this.f8267e;
    }

    @Override // com.amap.api.col.p0463l.BinaryRequest
    /* renamed from: h */
    protected final boolean mo51366h() {
        return this.f8274p;
    }

    /* renamed from: a */
    public final void m51380a(String str) {
        this.f8272j = str;
    }

    /* renamed from: c */
    public final void m51372c(String str) {
        this.f8268f = str;
    }

    /* renamed from: d */
    public final void m51369d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8275q = str;
        } else {
            this.f8275q = "";
        }
    }

    /* renamed from: a */
    public final void m51378a(boolean z) {
        this.f8271i = z;
    }

    @Override // com.amap.api.col.p0463l.BinaryRequest
    /* renamed from: c */
    public final byte[] mo51373c() {
        return this.f8269g;
    }

    /* renamed from: b */
    public final void m51377b(String str) {
        this.f8267e = str;
    }

    /* renamed from: b */
    public final void m51376b(Map<String, String> map) {
        this.f8266d = map;
    }

    /* renamed from: b */
    public final void m51375b(boolean z) {
        this.f8274p = z;
    }
}
