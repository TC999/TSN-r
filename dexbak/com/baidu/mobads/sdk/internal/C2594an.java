package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.clj.fastble.BleManager;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: com.baidu.mobads.sdk.internal.an */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2594an {

    /* renamed from: a */
    public static final String f8580a = "OAdURLConnection";

    /* renamed from: b */
    public static final String f8581b = "POST";

    /* renamed from: c */
    public static final String f8582c = "GET";

    /* renamed from: d */
    public static final String f8583d = "application/json";

    /* renamed from: e */
    public static final String f8584e = "text/plain";

    /* renamed from: f */
    private HttpURLConnection f8585f;

    /* renamed from: g */
    private C2634bs f8586g;

    /* renamed from: h */
    private InterfaceC2596b f8587h;

    /* renamed from: i */
    private InterfaceC2597c f8588i;

    /* renamed from: j */
    private String f8589j;

    /* renamed from: k */
    private String f8590k;

    /* renamed from: l */
    private String f8591l;

    /* renamed from: m */
    private String f8592m;

    /* renamed from: n */
    private int f8593n;

    /* renamed from: o */
    private int f8594o;

    /* renamed from: p */
    private boolean f8595p;

    /* renamed from: q */
    private Uri.Builder f8596q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mobads.sdk.internal.an$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2595a extends AbstractRunnableC2710i {
        C2595a() {
        }

        @Override // com.baidu.mobads.sdk.internal.AbstractRunnableC2710i
        /* renamed from: i */
        public Object mo50376i() {
            C2594an.this.m51000e();
            C2594an.this.m50999f();
            return null;
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.an$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2596b {
        /* renamed from: a */
        void mo50653a(String str, int i);

        /* renamed from: a */
        void mo50652a(String str, String str2);
    }

    /* renamed from: com.baidu.mobads.sdk.internal.an$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2597c {
        /* renamed from: a */
        void m50998a(InputStream inputStream, String str);

        /* renamed from: a */
        void m50997a(String str, int i);
    }

    public C2594an(String str) {
        this(str, "GET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m51000e() {
        if (TextUtils.isEmpty(this.f8589j) || !C2670cp.m50608a().m50595f(this.f8589j)) {
            return;
        }
        try {
            HttpURLConnection m50603a = C2670cp.m50608a().m50603a(new URL(this.f8589j));
            this.f8585f = m50603a;
            m50603a.setConnectTimeout(this.f8593n);
            if (Integer.parseInt(C2624bk.m50799a((Context) null).m50794b()) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f8585f.setRequestMethod(this.f8590k);
            this.f8585f.setUseCaches(this.f8595p);
            if (!TextUtils.isEmpty(this.f8591l)) {
                this.f8585f.setRequestProperty("User-Agent", this.f8591l);
            }
            this.f8585f.setRequestProperty("Content-type", this.f8592m);
            this.f8585f.setRequestProperty("Connection", "keep-alive");
            this.f8585f.setRequestProperty("Cache-Control", "no-cache");
            if (this.f8590k.equals("POST")) {
                this.f8585f.setDoInput(true);
                this.f8585f.setDoOutput(true);
                Uri.Builder builder = this.f8596q;
                if (builder != null) {
                    m51008a(builder.build().getEncodedQuery(), this.f8585f);
                }
            }
        } catch (Exception e) {
            InterfaceC2596b interfaceC2596b = this.f8587h;
            if (interfaceC2596b != null) {
                interfaceC2596b.mo50653a("Net Create RuntimeError: " + e.toString(), 0);
            }
            InterfaceC2597c interfaceC2597c = this.f8588i;
            if (interfaceC2597c != null) {
                interfaceC2597c.m50997a("Net Create RuntimeError: " + e.toString(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m50999f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f8585f.connect();
                C2634bs c2634bs = this.f8586g;
                c2634bs.m50740a(f8580a, this.f8585f.getRequestMethod() + " connect code :" + this.f8585f.getResponseCode());
                int responseCode = this.f8585f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f8585f.setInstanceFollowRedirects(false);
                    HttpURLConnection m51007a = m51007a(this.f8585f);
                    this.f8585f = m51007a;
                    responseCode = m51007a.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    InterfaceC2596b interfaceC2596b = this.f8587h;
                    if (interfaceC2596b != null) {
                        interfaceC2596b.mo50653a(this.f8585f.getResponseMessage(), responseCode);
                    }
                    InterfaceC2597c interfaceC2597c = this.f8588i;
                    if (interfaceC2597c != null) {
                        interfaceC2597c.m50997a(this.f8585f.getResponseMessage(), responseCode);
                    }
                } else {
                    String m50594g = C2670cp.m50608a().m50594g(this.f8589j);
                    InterfaceC2596b interfaceC2596b2 = this.f8587h;
                    if (interfaceC2596b2 != null) {
                        interfaceC2596b2.mo50652a(m51002c(), m50594g);
                    }
                    InterfaceC2597c interfaceC2597c2 = this.f8588i;
                    if (interfaceC2597c2 != null) {
                        interfaceC2597c2.m50998a(this.f8585f.getInputStream(), m50594g);
                    }
                }
                httpURLConnection = this.f8585f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e) {
                InterfaceC2596b interfaceC2596b3 = this.f8587h;
                if (interfaceC2596b3 != null) {
                    interfaceC2596b3.mo50653a("Net Connect RuntimeError: " + e.toString(), 0);
                }
                InterfaceC2597c interfaceC2597c3 = this.f8588i;
                if (interfaceC2597c3 != null) {
                    interfaceC2597c3.m50997a("Net Connect RuntimeError: " + e.toString(), 0);
                }
                httpURLConnection = this.f8585f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f8585f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: c */
    public String m51002c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f8585f.getInputStream();
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

    /* renamed from: d */
    public void m51001d() {
        HttpURLConnection httpURLConnection = this.f8585f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                C2607aw.m50898h(f8580a).mo50860f(e.toString());
            }
        }
    }

    public C2594an(String str, String str2) {
        this.f8586g = C2634bs.m50744a();
        this.f8587h = null;
        this.f8588i = null;
        this.f8592m = "text/plain";
        this.f8593n = BleManager.f22896l;
        this.f8594o = BleManager.f22896l;
        this.f8595p = false;
        this.f8596q = null;
        this.f8589j = str;
        this.f8590k = str2;
    }

    /* renamed from: a */
    public String m51015a() {
        m51000e();
        HttpURLConnection httpURLConnection = this.f8585f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f8585f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String m51002c = m51002c();
                HttpURLConnection httpURLConnection3 = this.f8585f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return m51002c;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f8585f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public void m51005b() {
        try {
            C2614bb.m50841a().m50840a((AbstractRunnableC2710i) new C2595a());
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void m51004b(int i) {
        this.f8594o = i;
    }

    /* renamed from: a */
    private void m51008a(String str, HttpURLConnection httpURLConnection) {
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

    /* renamed from: a */
    public void m51006a(Map<String, String> map) {
        if (this.f8585f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f8585f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    private HttpURLConnection m51007a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField(HttpHeaders.Names.LOCATION)).openConnection();
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

    /* renamed from: a */
    public void m51012a(InterfaceC2596b interfaceC2596b) {
        this.f8587h = interfaceC2596b;
    }

    /* renamed from: a */
    public void m51011a(InterfaceC2597c interfaceC2597c) {
        this.f8588i = interfaceC2597c;
    }

    /* renamed from: a */
    public void m51014a(int i) {
        this.f8593n = i;
    }

    /* renamed from: a */
    public void m51013a(Uri.Builder builder) {
        this.f8596q = builder;
    }

    /* renamed from: a */
    public void m51009a(String str) {
        this.f8592m = str;
    }
}
