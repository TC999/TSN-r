package com.tencent.open.a;

import android.os.Build;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f51677a;

    /* renamed from: b  reason: collision with root package name */
    private i f51678b;

    /* renamed from: c  reason: collision with root package name */
    private a f51679c;

    protected f() {
        b();
    }

    public static f a() {
        if (f51677a == null) {
            synchronized (f.class) {
                if (f51677a == null) {
                    f51677a = new f();
                }
            }
        }
        f51677a.c();
        return f51677a;
    }

    private void b() {
        String str = "AndroidSDK_" + Build.VERSION.SDK + "_" + com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()) + "_" + Build.VERSION.RELEASE;
        try {
            this.f51679c = new e(str);
        } catch (NoClassDefFoundError e4) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e4);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th);
        }
        if (this.f51679c == null) {
            this.f51679c = new b(str);
        }
    }

    private void c() {
        i iVar = this.f51678b;
        if (iVar == null) {
            return;
        }
        int a4 = iVar.a("Common_HttpConnectionTimeout");
        if (a4 == 0) {
            a4 = 15000;
        }
        int a5 = this.f51678b.a("Common_SocketConnectionTimeout");
        if (a5 == 0) {
            a5 = 30000;
        }
        a(a4, a5);
    }

    public void a(i iVar) {
        this.f51678b = iVar;
        c();
    }

    public g b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        return this.f51679c.a(str, map);
    }

    public void a(long j4, long j5) {
        a aVar = this.f51679c;
        if (aVar != null) {
            aVar.a(j4, j5);
        }
    }

    public g a(String str, Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder("");
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append("&");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return a(str, sb.toString());
        }
        return a(str, "");
    }

    public g a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        return this.f51679c.a(str, str2);
    }

    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            return this.f51679c.a(str, map, map2);
        }
        return b(str, map);
    }
}
