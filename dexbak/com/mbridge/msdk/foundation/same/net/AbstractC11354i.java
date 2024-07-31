package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.C11348b;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.HttpUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/* compiled from: Request.java */
/* renamed from: com.mbridge.msdk.foundation.same.net.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC11354i<T> implements Comparable<AbstractC11354i<T>> {

    /* renamed from: c */
    private static final String f30837c = AbstractC11354i.class.getSimpleName();

    /* renamed from: a */
    protected ConcurrentHashMap<String, String> f30838a;

    /* renamed from: b */
    protected IListener<T> f30839b;

    /* renamed from: d */
    private final int f30840d;

    /* renamed from: e */
    private final String f30841e;

    /* renamed from: f */
    private Integer f30842f;

    /* renamed from: g */
    private RequestQueue f30843g;

    /* renamed from: h */
    private boolean f30844h;

    /* renamed from: i */
    private RetryPolicy f30845i;

    /* renamed from: j */
    private int f30846j;

    public AbstractC11354i(int i, String str, IListener<T> iListener) {
        this.f30838a = new ConcurrentHashMap<>();
        this.f30844h = false;
        this.f30846j = 2;
        this.f30841e = str;
        this.f30840d = i;
        this.f30839b = iListener;
        this.f30845i = new DefaultRetryPolicy();
    }

    /* renamed from: a */
    public final int m22211a() {
        return this.f30840d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C11356k<T> mo22205a(NetworkResponse networkResponse);

    /* renamed from: b */
    public final String m22198b() {
        return this.f30841e;
    }

    /* renamed from: c */
    public final boolean m22196c() {
        return this.f30844h;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        AbstractC11354i abstractC11354i = (AbstractC11354i) obj;
        int mo22192g = mo22192g();
        int mo22192g2 = abstractC11354i.mo22192g();
        return mo22192g == mo22192g2 ? this.f30842f.intValue() - abstractC11354i.f30842f.intValue() : mo22192g2 - mo22192g;
    }

    /* renamed from: d */
    public final Map<String, String> m22195d() {
        return this.f30838a;
    }

    /* renamed from: e */
    public byte[] mo22194e() {
        return null;
    }

    /* renamed from: f */
    public final void m22193f() {
        m22199a("Charset", "UTF-8");
        m22199a("Connection", "close");
    }

    /* renamed from: g */
    public int mo22192g() {
        return this.f30846j;
    }

    /* renamed from: h */
    public final int m22191h() {
        try {
            return this.f30845i.mo22172b();
        } catch (Exception unused) {
            return 10;
        }
    }

    /* renamed from: i */
    public final int m22190i() {
        try {
            return this.f30845i.mo22170d();
        } catch (Exception unused) {
            return 10;
        }
    }

    /* renamed from: j */
    public final int m22189j() {
        try {
            return this.f30845i.mo22169e();
        } catch (Exception unused) {
            return 10;
        }
    }

    /* renamed from: k */
    public final int m22188k() {
        try {
            return this.f30845i.mo22168f();
        } catch (Exception unused) {
            return 10;
        }
    }

    /* renamed from: l */
    public final int m22187l() {
        try {
            return this.f30845i.mo22167g();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: m */
    public final RetryPolicy m22186m() {
        return this.f30845i;
    }

    /* renamed from: n */
    public final void m22185n() {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo22262c();
        }
    }

    /* renamed from: o */
    public final void m22184o() {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo21053a();
        }
    }

    /* renamed from: p */
    public final void m22183p() {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo22264b();
        }
    }

    /* renamed from: q */
    public final void m22182q() {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo22260e();
        }
    }

    /* renamed from: r */
    public final void m22181r() {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo22261d();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f30844h ? "[X] " : "[ ] ");
        sb.append(this.f30841e);
        sb.append(" ");
        sb.append(mo22192g());
        sb.append(" ");
        sb.append(this.f30842f);
        return sb.toString();
    }

    /* renamed from: a */
    public final void m22204a(IListener<T> iListener) {
        this.f30839b = iListener;
    }

    /* renamed from: b */
    public final void m22197b(int i) {
        if (i < 1 || i > 4) {
            return;
        }
        this.f30846j = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final AbstractC11354i<?> m22201a(RetryPolicy retryPolicy) {
        this.f30845i = retryPolicy;
        return this;
    }

    /* renamed from: a */
    public final void m22200a(String str) {
        RequestQueue requestQueue = this.f30843g;
        if (requestQueue != null) {
            requestQueue.m22178b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final AbstractC11354i<?> m22203a(RequestQueue requestQueue) {
        this.f30843g = requestQueue;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final AbstractC11354i<?> m22210a(int i) {
        this.f30842f = Integer.valueOf(i);
        return this;
    }

    /* renamed from: a */
    public byte[] mo22206a(C11348b c11348b, Delivery delivery) throws IOException, CommonError {
        return c11348b.m22269c() != null ? m22207a(c11348b) : new byte[0];
    }

    public AbstractC11354i(int i, String str) {
        this.f30838a = new ConcurrentHashMap<>();
        this.f30839b = null;
        this.f30844h = false;
        this.f30846j = 2;
        this.f30841e = str;
        this.f30840d = i;
        this.f30845i = new DefaultRetryPolicy();
    }

    /* renamed from: a */
    private byte[] m22207a(C11348b c11348b) throws IOException, CommonError {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            InputStream m22269c = c11348b.m22269c();
            try {
                if (HttpUtils.m22255b(c11348b.m22270b()) && !(m22269c instanceof GZIPInputStream)) {
                    m22269c = new GZIPInputStream(m22269c);
                }
                if (m22269c != null) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = m22269c.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        try {
                            m22269c.close();
                            byteArrayOutputStream2.close();
                        } catch (IOException e) {
                            SameLogTool.m21733d(f30837c, e.getMessage());
                        }
                        return byteArray;
                    } catch (Throwable th) {
                        inputStream = m22269c;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        th = th;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e2) {
                                SameLogTool.m21733d(f30837c, e2.getMessage());
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                }
                throw new CommonError(7, null);
            } catch (Throwable th2) {
                th = th2;
                inputStream = m22269c;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    /* renamed from: a */
    public final void m22202a(C11356k<T> c11356k) {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo21051a(c11356k);
        }
    }

    /* renamed from: a */
    public final void m22208a(CommonError commonError) {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo21052a(commonError);
        }
    }

    /* renamed from: a */
    public final void m22209a(long j, long j2) {
        IListener<T> iListener = this.f30839b;
        if (iListener != null) {
            iListener.mo22265a(j, j2);
        }
    }

    /* renamed from: a */
    public final void m22199a(String str, String str2) {
        this.f30838a.remove(str);
        this.f30838a.put(str, str2);
    }
}
