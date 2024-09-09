package com.bytedance.sdk.component.w.c.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.gd;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.w.c.ys;
import com.bytedance.sdk.component.xv.w.z;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.w.c.w {

    /* renamed from: c  reason: collision with root package name */
    t f30389c;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f30390f;

    /* renamed from: w  reason: collision with root package name */
    sr f30391w;
    private AtomicBoolean ux = new AtomicBoolean(false);
    final String xv = com.bytedance.sdk.component.w.c.w.sr.c(UUID.randomUUID().toString()).c();
    z sr = new z();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.component.w.c.c.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class C0456c extends com.bytedance.sdk.component.w.c.w.ux {
        private final c sr;
        private final com.bytedance.sdk.component.w.c.xv xv;

        C0456c(com.bytedance.sdk.component.w.c.xv xvVar, c cVar) {
            super("net-async-call", new Object[0]);
            this.xv = xvVar;
            this.sr = cVar;
        }

        public void c() {
            z zVar;
            c cVar = this.sr;
            if (cVar == null || (zVar = cVar.sr) == null) {
                return;
            }
            zVar.k();
        }

        @Override // com.bytedance.sdk.component.w.c.w.ux
        protected void w() {
            z zVar;
            try {
                c cVar = this.sr;
                if (cVar != null && (zVar = cVar.sr) != null) {
                    zVar.c();
                }
                fp sr = c.this.sr();
                if (sr == null) {
                    this.xv.onFailure(c.this, new IOException("response is null"));
                } else {
                    this.xv.onResponse(c.this, sr);
                }
                this.sr.f30391w.w(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(t tVar, sr srVar) {
        this.f30389c = tVar;
        this.f30391w = srVar;
    }

    private boolean f() {
        if (this.f30389c.sr() == null) {
            return false;
        }
        return this.f30389c.sr().containsKey("Content-Type");
    }

    private boolean w(ys ysVar) {
        t tVar;
        byte[] bArr;
        return ysVar != null && (tVar = this.f30389c) != null && "POST".equalsIgnoreCase(tVar.xv()) && ysVar.f30451f == ys.c.BYTE_ARRAY_TYPE && (bArr = ysVar.ux) != null && bArr.length > 0;
    }

    private boolean xv(ys ysVar) {
        t tVar;
        return (ysVar == null || (tVar = this.f30389c) == null || !"POST".equalsIgnoreCase(tVar.xv()) || ysVar.f30451f != ys.c.STRING_TYPE || TextUtils.isEmpty(ysVar.sr)) ? false : true;
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public void c(com.bytedance.sdk.component.w.c.xv xvVar) {
        try {
            synchronized (this) {
                if (!this.f30390f) {
                    this.f30390f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            this.f30391w.c(new C0456c(xvVar, this));
        } catch (Throwable th) {
            if (xvVar != null) {
                xvVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    public fp sr() {
        List<gd> list;
        if (this.ux.get()) {
            return null;
        }
        try {
            a aVar = this.f30389c.f30426c;
            if (aVar != null && (list = aVar.f30359c) != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList(this.f30389c.f30426c.f30359c);
                arrayList.add(new gd() { // from class: com.bytedance.sdk.component.w.c.c.w.c.1
                    @Override // com.bytedance.sdk.component.w.c.gd
                    public fp c(gd.c cVar) throws IOException {
                        return c.this.c(cVar.c());
                    }
                });
                return ((gd) arrayList.get(0)).c(new w(arrayList, this.f30389c));
            }
            return c(this.f30389c);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: ux */
    public com.bytedance.sdk.component.w.c.w clone() {
        return new c(this.f30389c, this.f30391w);
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public void w() {
        this.ux.set(true);
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public boolean xv() {
        return this.ux.get();
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public fp c() throws IOException {
        synchronized (this) {
            if (!this.f30390f) {
                this.f30390f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.f30391w.c(this);
            return sr();
        } finally {
            this.f30391w.w(this);
        }
    }

    public fp c(t tVar) throws IOException {
        try {
            z zVar = this.sr;
            if (zVar != null) {
                zVar.w();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(tVar.w().c().toString()).openConnection();
            if (tVar.sr() != null && tVar.sr().size() > 0) {
                for (Map.Entry<String, List<String>> entry : tVar.sr().entrySet()) {
                    for (String str : entry.getValue()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), str);
                    }
                }
            }
            a aVar = tVar.f30426c;
            if (aVar != null) {
                TimeUnit timeUnit = aVar.xv;
                if (timeUnit != null) {
                    httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(aVar.f30364w));
                }
                a aVar2 = tVar.f30426c;
                TimeUnit timeUnit2 = aVar2.ux;
                if (timeUnit2 != null) {
                    httpURLConnection.setReadTimeout((int) timeUnit2.toMillis(aVar2.sr));
                }
            }
            if (tVar.f() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!f() && tVar.f().xv != null) {
                    httpURLConnection.addRequestProperty("Content-Type", tVar.f().xv.toString());
                }
                httpURLConnection.setRequestMethod(tVar.xv());
                if (c(tVar.f())) {
                    c(httpURLConnection);
                }
                if ("POST".equalsIgnoreCase(tVar.xv())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (xv(tVar.f())) {
                        outputStream.write(tVar.f().sr.getBytes());
                    } else if (c(tVar.f())) {
                        c(tVar.f().ux, outputStream, tVar.f().w(), tVar.f().c());
                    } else if (w(tVar.f())) {
                        outputStream.write(tVar.f().ux);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long currentTimeMillis = System.currentTimeMillis();
            z zVar2 = this.sr;
            if (zVar2 != null) {
                zVar2.xv();
                this.sr.c(currentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.ux.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            f fVar = new f(httpURLConnection, tVar);
            fVar.sr = currentTimeMillis;
            fVar.xv = currentTimeMillis2;
            z zVar3 = this.sr;
            if (zVar3 != null) {
                zVar3.w(currentTimeMillis2);
            }
            fVar.ux = this.sr;
            return fVar;
        } catch (Exception unused) {
            throw new IOException();
        }
    }

    private void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.xv);
    }

    private void c(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.xv)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) "\r\n");
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Length: ");
        sb.append(bArr.length);
        printWriter.append((CharSequence) sb.toString()).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "\r\n");
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("--" + this.xv + "--")).append((CharSequence) "\r\n");
        printWriter.flush();
        printWriter.close();
    }

    private boolean c(ys ysVar) {
        t tVar;
        byte[] bArr;
        return ysVar != null && (tVar = this.f30389c) != null && "POST".equalsIgnoreCase(tVar.xv()) && ysVar.f30451f == ys.c.FILE_TYPE && (bArr = ysVar.ux) != null && bArr.length > 0;
    }
}
