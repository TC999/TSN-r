package com.qq.e.comm.plugin.i0.n;

import com.qq.e.comm.plugin.util.g2;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface f {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public enum a {
        GET,
        POST
    }

    g a(HttpURLConnection httpURLConnection) throws IOException;

    void a(int i4);

    void a(g2.h hVar);

    void a(String str, String str2);

    void a(boolean z3);

    boolean a();

    void addHeader(String str, String str2);

    int b();

    void b(boolean z3);

    int c();

    void c(boolean z3);

    g2.h d();

    void d(boolean z3);

    void e(boolean z3);

    boolean e();

    Map<String, String> f();

    boolean g();

    a getMethod();

    String getUrl();

    int h();

    String i();

    boolean j();

    byte[] k() throws Exception;

    Map<String, String> l();

    boolean m();

    void n();
}
