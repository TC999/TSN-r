package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.r6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LocationRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d extends r6 {

    /* renamed from: d  reason: collision with root package name */
    Map<String, String> f11938d;

    /* renamed from: e  reason: collision with root package name */
    String f11939e;

    /* renamed from: f  reason: collision with root package name */
    String f11940f;

    /* renamed from: g  reason: collision with root package name */
    byte[] f11941g;

    /* renamed from: h  reason: collision with root package name */
    byte[] f11942h;

    /* renamed from: i  reason: collision with root package name */
    boolean f11943i;

    /* renamed from: j  reason: collision with root package name */
    String f11944j;

    /* renamed from: k  reason: collision with root package name */
    Map<String, String> f11945k;

    /* renamed from: p  reason: collision with root package name */
    boolean f11946p;

    /* renamed from: q  reason: collision with root package name */
    private String f11947q;

    public d(Context context, p4 p4Var) {
        super(context, p4Var);
        this.f11938d = null;
        this.f11947q = "";
        this.f11939e = "";
        this.f11940f = "";
        this.f11941g = null;
        this.f11942h = null;
        this.f11943i = false;
        this.f11944j = null;
        this.f11945k = null;
        this.f11946p = false;
    }

    public final void a(Map<String, String> map) {
        this.f11945k = map;
    }

    public final void b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(r6.a(bArr));
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
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.f11942h = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void c(byte[] bArr) {
        this.f11941g = bArr;
    }

    @Override // com.amap.api.col.p0003l.r6
    public final byte[] d() {
        return this.f11942h;
    }

    @Override // com.amap.api.col.p0003l.r6
    public final boolean f() {
        return this.f11943i;
    }

    @Override // com.amap.api.col.p0003l.r6
    public final String g() {
        return this.f11944j;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPDNSName() {
        return this.f11947q;
    }

    @Override // com.amap.api.col.p0003l.l4, com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return this.f11940f;
    }

    @Override // com.amap.api.col.p0003l.r6, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return this.f11945k;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        return this.f11938d;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f11939e;
    }

    @Override // com.amap.api.col.p0003l.r6
    protected final boolean h() {
        return this.f11946p;
    }

    public final void a(String str) {
        this.f11944j = str;
    }

    public final void c(String str) {
        this.f11940f = str;
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f11947q = str;
        } else {
            this.f11947q = "";
        }
    }

    public final void a(boolean z3) {
        this.f11943i = z3;
    }

    @Override // com.amap.api.col.p0003l.r6
    public final byte[] c() {
        return this.f11941g;
    }

    public final void b(String str) {
        this.f11939e = str;
    }

    public final void b(Map<String, String> map) {
        this.f11938d = map;
    }

    public final void b(boolean z3) {
        this.f11946p = z3;
    }
}
