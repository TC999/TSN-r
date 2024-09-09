package com.qq.e.comm.plugin.i0.m;

import android.util.Pair;
import com.qq.e.comm.plugin.i0.e;
import com.qq.e.comm.plugin.i0.k;
import com.qq.e.comm.plugin.i0.m.a;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.g;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.v0;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements com.qq.e.comm.plugin.i0.m.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44382a;

        static {
            int[] iArr = new int[f.a.values().length];
            f44382a = iArr;
            try {
                iArr[f.a.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44382a[f.a.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.qq.e.comm.plugin.i0.m.a
    public g a(a.InterfaceC0847a interfaceC0847a) throws Exception {
        boolean z3;
        Pair<HttpURLConnection, Boolean> b4;
        f a4 = interfaceC0847a.a();
        URL url = new URL(e.a(a4.i(), 1));
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (!a4.m() || (b4 = v0.b(httpURLConnection, url)) == null) {
            z3 = false;
        } else {
            httpURLConnection = (HttpURLConnection) b4.first;
            z3 = ((Boolean) b4.second).booleanValue();
            if (httpURLConnection == null) {
                return null;
            }
        }
        HttpURLConnection a5 = a(a4, url, a(a4, httpURLConnection));
        g a6 = a4.a(a5);
        if (!z3) {
            v0.a(a5, url);
        }
        return a6;
    }

    private HttpURLConnection a(f fVar, URL url, HttpURLConnection httpURLConnection) throws Exception {
        int i4 = a.f44382a[fVar.getMethod().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return httpURLConnection;
            }
            d1.a(url.toString(), new Object[0]);
            boolean j4 = fVar.j();
            httpURLConnection.setInstanceFollowRedirects(j4);
            return j4 ? v0.a(httpURLConnection) : httpURLConnection;
        }
        httpURLConnection.setDoOutput(true);
        if (fVar.g()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        byte[] k4 = fVar.k();
        if (k4 == null || k4.length <= 0) {
            return httpURLConnection;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(k4);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return httpURLConnection;
    }

    private HttpURLConnection a(f fVar, HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, String> entry : fVar.f().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.setRequestProperty(k.b(), k.a());
        if (fVar.h() > 0) {
            httpURLConnection.setConnectTimeout(fVar.h());
        } else {
            httpURLConnection.setConnectTimeout(30000);
        }
        if (fVar.b() > 0) {
            httpURLConnection.setReadTimeout(fVar.b());
        } else {
            httpURLConnection.setReadTimeout(30000);
        }
        return httpURLConnection;
    }
}
