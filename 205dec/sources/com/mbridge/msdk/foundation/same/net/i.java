package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.tools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/* compiled from: Request.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class i<T> implements Comparable<i<T>> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f39610c = i.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected ConcurrentHashMap<String, String> f39611a;

    /* renamed from: b  reason: collision with root package name */
    protected e<T> f39612b;

    /* renamed from: d  reason: collision with root package name */
    private final int f39613d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39614e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f39615f;

    /* renamed from: g  reason: collision with root package name */
    private j f39616g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f39617h;

    /* renamed from: i  reason: collision with root package name */
    private l f39618i;

    /* renamed from: j  reason: collision with root package name */
    private int f39619j;

    public i(int i4, String str, e<T> eVar) {
        this.f39611a = new ConcurrentHashMap<>();
        this.f39617h = false;
        this.f39619j = 2;
        this.f39614e = str;
        this.f39613d = i4;
        this.f39612b = eVar;
        this.f39618i = new b();
    }

    public final int a() {
        return this.f39613d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract k<T> a(com.mbridge.msdk.foundation.same.net.e.c cVar);

    public final String b() {
        return this.f39614e;
    }

    public final boolean c() {
        return this.f39617h;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int g4 = g();
        int g5 = iVar.g();
        return g4 == g5 ? this.f39615f.intValue() - iVar.f39615f.intValue() : g5 - g4;
    }

    public final Map<String, String> d() {
        return this.f39611a;
    }

    public byte[] e() {
        return null;
    }

    public final void f() {
        a("Charset", "UTF-8");
        a("Connection", "close");
    }

    public int g() {
        return this.f39619j;
    }

    public final int h() {
        try {
            return this.f39618i.b();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int i() {
        try {
            return this.f39618i.d();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int j() {
        try {
            return this.f39618i.e();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int k() {
        try {
            return this.f39618i.f();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int l() {
        try {
            return this.f39618i.g();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final l m() {
        return this.f39618i;
    }

    public final void n() {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final void o() {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public final void p() {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void q() {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public final void r() {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.d();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39617h ? "[X] " : "[ ] ");
        sb.append(this.f39614e);
        sb.append(" ");
        sb.append(g());
        sb.append(" ");
        sb.append(this.f39615f);
        return sb.toString();
    }

    public final void a(e<T> eVar) {
        this.f39612b = eVar;
    }

    public final void b(int i4) {
        if (i4 < 1 || i4 > 4) {
            return;
        }
        this.f39619j = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(l lVar) {
        this.f39618i = lVar;
        return this;
    }

    public final void a(String str) {
        j jVar = this.f39616g;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(j jVar) {
        this.f39616g = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(int i4) {
        this.f39615f = Integer.valueOf(i4);
        return this;
    }

    public byte[] a(com.mbridge.msdk.foundation.same.net.e.b bVar, c cVar) throws IOException, com.mbridge.msdk.foundation.same.net.a.a {
        return bVar.c() != null ? a(bVar) : new byte[0];
    }

    public i(int i4, String str) {
        this.f39611a = new ConcurrentHashMap<>();
        this.f39612b = null;
        this.f39617h = false;
        this.f39619j = 2;
        this.f39614e = str;
        this.f39613d = i4;
        this.f39618i = new b();
    }

    private byte[] a(com.mbridge.msdk.foundation.same.net.e.b bVar) throws IOException, com.mbridge.msdk.foundation.same.net.a.a {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            InputStream c4 = bVar.c();
            try {
                if (com.mbridge.msdk.foundation.same.net.f.b.b(bVar.b()) && !(c4 instanceof GZIPInputStream)) {
                    c4 = new GZIPInputStream(c4);
                }
                if (c4 != null) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = c4.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        try {
                            c4.close();
                            byteArrayOutputStream2.close();
                        } catch (IOException e4) {
                            x.d(f39610c, e4.getMessage());
                        }
                        return byteArray;
                    } catch (Throwable th) {
                        inputStream = c4;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        th = th;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e5) {
                                x.d(f39610c, e5.getMessage());
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                }
                throw new com.mbridge.msdk.foundation.same.net.a.a(7, null);
            } catch (Throwable th2) {
                th = th2;
                inputStream = c4;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public final void a(k<T> kVar) {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.a(kVar);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public final void a(long j4, long j5) {
        e<T> eVar = this.f39612b;
        if (eVar != null) {
            eVar.a(j4, j5);
        }
    }

    public final void a(String str, String str2) {
        this.f39611a.remove(str);
        this.f39611a.put(str, str2);
    }
}
