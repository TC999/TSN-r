package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12373a = "OAdURLConnection";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12374b = "POST";

    /* renamed from: c  reason: collision with root package name */
    public static final String f12375c = "GET";

    /* renamed from: d  reason: collision with root package name */
    public static final String f12376d = "application/json";

    /* renamed from: e  reason: collision with root package name */
    public static final String f12377e = "text/plain";

    /* renamed from: f  reason: collision with root package name */
    private HttpURLConnection f12378f;

    /* renamed from: g  reason: collision with root package name */
    private bv f12379g;

    /* renamed from: h  reason: collision with root package name */
    private b f12380h;

    /* renamed from: i  reason: collision with root package name */
    private c f12381i;

    /* renamed from: j  reason: collision with root package name */
    private String f12382j;

    /* renamed from: k  reason: collision with root package name */
    private String f12383k;

    /* renamed from: l  reason: collision with root package name */
    private String f12384l;

    /* renamed from: m  reason: collision with root package name */
    private String f12385m;

    /* renamed from: n  reason: collision with root package name */
    private int f12386n;

    /* renamed from: o  reason: collision with root package name */
    private int f12387o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12388p;

    /* renamed from: q  reason: collision with root package name */
    private Uri.Builder f12389q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends i {
        a() {
        }

        @Override // com.baidu.mobads.sdk.internal.i
        public Object i() {
            an.this.e();
            an.this.f();
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface b {
        void a(String str, int i4);

        void a(String str, String str2);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i4);
    }

    public an(String str) {
        this(str, "GET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (TextUtils.isEmpty(this.f12382j) || !cs.a().f(this.f12382j)) {
            return;
        }
        try {
            HttpURLConnection a4 = cs.a().a(new URL(this.f12382j));
            this.f12378f = a4;
            a4.setConnectTimeout(this.f12386n);
            if (Integer.parseInt(bn.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f12378f.setRequestMethod(this.f12383k);
            this.f12378f.setUseCaches(this.f12388p);
            if (!TextUtils.isEmpty(this.f12384l)) {
                this.f12378f.setRequestProperty("User-Agent", this.f12384l);
            }
            this.f12378f.setRequestProperty("Content-type", this.f12385m);
            this.f12378f.setRequestProperty("Connection", "keep-alive");
            this.f12378f.setRequestProperty("Cache-Control", "no-cache");
            if (this.f12383k.equals("POST")) {
                this.f12378f.setDoInput(true);
                this.f12378f.setDoOutput(true);
                Uri.Builder builder = this.f12389q;
                if (builder != null) {
                    a(builder.build().getEncodedQuery(), this.f12378f);
                }
            }
        } catch (Exception e4) {
            b bVar = this.f12380h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e4.toString(), 0);
            }
            c cVar = this.f12381i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e4.toString(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f12378f.connect();
                bv bvVar = this.f12379g;
                bvVar.a("OAdURLConnection", this.f12378f.getRequestMethod() + " connect code :" + this.f12378f.getResponseCode());
                int responseCode = this.f12378f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f12378f.setInstanceFollowRedirects(false);
                    HttpURLConnection a4 = a(this.f12378f);
                    this.f12378f = a4;
                    responseCode = a4.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b bVar = this.f12380h;
                    if (bVar != null) {
                        bVar.a(this.f12378f.getResponseMessage(), responseCode);
                    }
                    c cVar = this.f12381i;
                    if (cVar != null) {
                        cVar.a(this.f12378f.getResponseMessage(), responseCode);
                    }
                } else {
                    String g4 = cs.a().g(this.f12382j);
                    b bVar2 = this.f12380h;
                    if (bVar2 != null) {
                        bVar2.a(c(), g4);
                    }
                    c cVar2 = this.f12381i;
                    if (cVar2 != null) {
                        cVar2.a(this.f12378f.getInputStream(), g4);
                    }
                }
                httpURLConnection = this.f12378f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e4) {
                b bVar3 = this.f12380h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e4.toString(), 0);
                }
                c cVar3 = this.f12381i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e4.toString(), 0);
                }
                httpURLConnection = this.f12378f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f12378f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f12378f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    inputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f12378f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e4) {
                az.h("OAdURLConnection").f(e4.toString());
            }
        }
    }

    public an(String str, String str2) {
        this.f12379g = bv.a();
        this.f12380h = null;
        this.f12381i = null;
        this.f12385m = "text/plain";
        this.f12386n = 10000;
        this.f12387o = 10000;
        this.f12388p = false;
        this.f12389q = null;
        this.f12382j = str;
        this.f12383k = str2;
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f12378f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f12378f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String c4 = c();
                HttpURLConnection httpURLConnection3 = this.f12378f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c4;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f12378f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            be.a().a((i) new a());
        } catch (Exception unused) {
        }
    }

    public void b(int i4) {
        this.f12387o = i4;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f12378f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f12378f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public void a(b bVar) {
        this.f12380h = bVar;
    }

    public void a(c cVar) {
        this.f12381i = cVar;
    }

    public void a(int i4) {
        this.f12386n = i4;
    }

    public void a(Uri.Builder builder) {
        this.f12389q = builder;
    }

    public void a(String str) {
        this.f12385m = str;
    }
}
