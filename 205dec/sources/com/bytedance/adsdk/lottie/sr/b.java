package com.bytedance.adsdk.lottie.sr;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.lottie.n;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final d f25743a;

    /* renamed from: b  reason: collision with root package name */
    private final c f25744b;

    public b(d dVar, c cVar) {
        this.f25743a = dVar;
        this.f25744b = cVar;
    }

    private com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> a(Context context, String str, InputStream inputStream, String str2) throws IOException {
        d dVar;
        if (str2 != null && (dVar = this.f25743a) != null) {
            return n.a(context, new ZipInputStream(new FileInputStream(dVar.c(str, inputStream, xv.ZIP))), str);
        }
        return n.a(context, new ZipInputStream(inputStream), null);
    }

    private com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> b(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> a4;
        xv xvVar;
        d dVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            com.bytedance.adsdk.lottie.f.e.a("Received json response.");
            xvVar = xv.JSON;
            a4 = d(str, inputStream, str3);
        } else {
            com.bytedance.adsdk.lottie.f.e.a("Handling zip response.");
            xv xvVar2 = xv.ZIP;
            a4 = a(context, str, inputStream, str3);
            xvVar = xvVar2;
        }
        if (str3 != null && a4.a() != null && (dVar = this.f25743a) != null) {
            dVar.e(str, xvVar);
        }
        return a4;
    }

    private com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> d(String str, InputStream inputStream, String str2) throws IOException {
        d dVar;
        if (str2 != null && (dVar = this.f25743a) != null) {
            return n.s(new FileInputStream(dVar.c(str, inputStream, xv.JSON).getAbsolutePath()), str);
        }
        return n.s(inputStream, null);
    }

    @WorkerThread
    private com.bytedance.adsdk.lottie.e e(Context context, String str, String str2) {
        d dVar;
        Pair<xv, InputStream> a4;
        com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> s3;
        if (str2 == null || (dVar = this.f25743a) == null || (a4 = dVar.a(str)) == null) {
            return null;
        }
        xv xvVar = (xv) a4.first;
        InputStream inputStream = (InputStream) a4.second;
        if (xvVar == xv.ZIP) {
            s3 = n.a(context, new ZipInputStream(inputStream), str2);
        } else {
            s3 = n.s(inputStream, str2);
        }
        if (s3.a() != null) {
            return s3.a();
        }
        return null;
    }

    @WorkerThread
    private com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> f(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.f.e.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                e c4 = this.f25744b.c(str);
                if (c4.c()) {
                    com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> b4 = b(context, str, c4.w(), c4.xv(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(b4.a() != null);
                    com.bytedance.adsdk.lottie.f.e.a(sb.toString());
                    try {
                        c4.close();
                    } catch (IOException e4) {
                        com.bytedance.adsdk.lottie.f.e.b("LottieFetchResult close failed ", e4);
                    }
                    return b4;
                }
                com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> bVar = new com.bytedance.adsdk.lottie.b<>(new IllegalArgumentException(c4.sr()));
                try {
                    c4.close();
                } catch (IOException e5) {
                    com.bytedance.adsdk.lottie.f.e.b("LottieFetchResult close failed ", e5);
                }
                return bVar;
            } catch (Exception e6) {
                com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> bVar2 = new com.bytedance.adsdk.lottie.b<>(e6);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e7) {
                        com.bytedance.adsdk.lottie.f.e.b("LottieFetchResult close failed ", e7);
                    }
                }
                return bVar2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e8) {
                    com.bytedance.adsdk.lottie.f.e.b("LottieFetchResult close failed ", e8);
                }
            }
            throw th;
        }
    }

    @WorkerThread
    public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> c(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.e e4 = e(context, str, str2);
        if (e4 != null) {
            return new com.bytedance.adsdk.lottie.b<>(e4);
        }
        com.bytedance.adsdk.lottie.f.e.a("Animation for " + str + " not found in cache. Fetching from network.");
        return f(context, str, str2);
    }
}
