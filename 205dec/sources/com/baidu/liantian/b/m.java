package com.baidu.liantian.b;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.f4;
import com.stub.StubApp;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.X509TrustManager;

/* compiled from: HttpUtil.java */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    Context f12138a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f12139b;

    /* renamed from: c  reason: collision with root package name */
    private String f12140c;

    /* renamed from: d  reason: collision with root package name */
    private String f12141d;

    /* renamed from: e  reason: collision with root package name */
    private int f12142e;

    /* renamed from: f  reason: collision with root package name */
    private int f12143f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12144g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements X509TrustManager {

        /* renamed from: b  reason: collision with root package name */
        private X509TrustManager f12146b;

        a(X509TrustManager x509TrustManager) {
            this.f12146b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            com.baidu.liantian.b.a();
            this.f12146b.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            com.baidu.liantian.b.a();
            try {
                this.f12146b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.liantian.b.a();
            } catch (Throwable th) {
                e.a();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        e.a(StubApp.getOrigApplicationContext(m.this.f12138a.getApplicationContext()), "1003121", hashMap);
                        return;
                    }
                }
                if (th instanceof CertificateException) {
                    throw th;
                }
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            com.baidu.liantian.b.a();
            return this.f12146b.getAcceptedIssuers();
        }
    }

    public m(Context context) {
        this.f12139b = new byte[8192];
        this.f12142e = 120000;
        this.f12143f = 120000;
        this.f12144g = false;
        this.f12138a = context;
    }

    private void a(String str, String str2) {
        this.f12140c = str;
        this.f12141d = str2;
    }

    private static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #7 {all -> 0x0110, blocks: (B:48:0x00d4, B:51:0x00ec, B:39:0x00bb, B:44:0x00c8), top: B:68:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.HttpURLConnection a() {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.m.a():java.net.HttpURLConnection");
    }

    public m(Context context, byte b4) {
        this.f12139b = new byte[8192];
        this.f12142e = 120000;
        this.f12143f = 120000;
        this.f12144g = false;
        this.f12138a = context;
    }

    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) {
        BufferedOutputStream bufferedOutputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            try {
                if (bArr == null) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && "gzip".equalsIgnoreCase(contentEncoding)) {
                            this.f12144g = true;
                        } else {
                            this.f12144g = false;
                        }
                        return httpURLConnection.getInputStream();
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode));
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    int responseCode2 = httpURLConnection.getResponseCode();
                    if (responseCode2 == 200) {
                        if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                            this.f12144g = true;
                        } else {
                            this.f12144g = false;
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused) {
                        }
                        return inputStream;
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode2));
                } catch (NetworkErrorException e4) {
                    throw e4;
                } catch (IOException e5) {
                    throw e5;
                } catch (Throwable unused2) {
                    e.a();
                    throw new IOException();
                }
            } catch (NetworkErrorException e6) {
                throw e6;
            } catch (IOException e7) {
                throw e7;
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (e.f(this.f12138a) && httpURLConnection != null) {
            try {
                if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    this.f12144g = true;
                } else {
                    this.f12144g = false;
                }
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
                e.a();
                return null;
            }
        }
        return null;
    }

    private String a(InputStream inputStream) {
        if (inputStream != null) {
            byte[] b4 = b(inputStream);
            if (b4 != null) {
                if (this.f12144g) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b4);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    j.b(byteArrayInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                    b4 = byteArray;
                }
                if (b4 != null) {
                    return new String(b4);
                }
                throw new IOException();
            }
            throw new NullPointerException("responseBytes");
        }
        throw new NullPointerException("InputStream");
    }

    public final String a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        s.a();
        try {
            a("POST", str);
            InputStream inputStream = null;
            try {
                httpURLConnection = a();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                inputStream = a(bArr, httpURLConnection);
                String a4 = a(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a4;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } finally {
            s.b();
        }
    }

    public final String a(String str) {
        HttpURLConnection httpURLConnection;
        s.a();
        try {
            com.baidu.liantian.b.a();
            InputStream inputStream = null;
            try {
                a("GET", str);
                httpURLConnection = a();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                inputStream = a((byte[]) null, httpURLConnection);
                String a4 = a(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a4;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } finally {
            s.b();
        }
    }

    public final boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        s.a();
        try {
            com.baidu.liantian.b.a();
            if (e.f(this.f12138a)) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                f4.a(file);
                com.baidu.liantian.b.a();
                InputStream inputStream = null;
                try {
                    a("GET", str);
                    httpURLConnection = a();
                } catch (Throwable unused) {
                    httpURLConnection = null;
                }
                try {
                    inputStream = a(httpURLConnection);
                    boolean a4 = a(inputStream, file);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return a4;
                } catch (Throwable unused2) {
                    e.a();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                }
            }
            return false;
        } finally {
            s.b();
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f12144g) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
                e.a();
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                        bufferedOutputStream.flush();
                    } else {
                        try {
                            bufferedOutputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            e.a();
                            return true;
                        }
                    }
                }
            } catch (Throwable unused3) {
                try {
                    e.a();
                    return false;
                } finally {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused4) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable unused5) {
            bufferedOutputStream = null;
        }
    }
}
