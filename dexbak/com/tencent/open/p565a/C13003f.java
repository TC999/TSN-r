package com.tencent.open.p565a;

import android.os.Build;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13058f;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13063i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13003f {

    /* renamed from: a */
    private static C13003f f37277a;

    /* renamed from: b */
    private C13063i f37278b;

    /* renamed from: c */
    private InterfaceC12997a f37279c;

    protected C13003f() {
        m15210b();
    }

    /* renamed from: a */
    public static C13003f m15216a() {
        if (f37277a == null) {
            synchronized (C13003f.class) {
                if (f37277a == null) {
                    f37277a = new C13003f();
                }
            }
        }
        f37277a.m15208c();
        return f37277a;
    }

    /* renamed from: b */
    private void m15210b() {
        String str = "AndroidSDK_" + Build.VERSION.SDK + "_" + C13058f.m15034a().m15030b(C13061g.m15027a()) + "_" + Build.VERSION.RELEASE;
        try {
            this.f37279c = new C13001e(str);
        } catch (NoClassDefFoundError e) {
            SLog.m15128e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e);
        } catch (Throwable th) {
            SLog.m15128e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th);
        }
        if (this.f37279c == null) {
            this.f37279c = new C12998b(str);
        }
    }

    /* renamed from: c */
    private void m15208c() {
        C13063i c13063i = this.f37278b;
        if (c13063i == null) {
            return;
        }
        int m15012a = c13063i.m15012a("Common_HttpConnectionTimeout");
        if (m15012a == 0) {
            m15012a = 15000;
        }
        int m15012a2 = this.f37278b.m15012a("Common_SocketConnectionTimeout");
        if (m15012a2 == 0) {
            m15012a2 = 30000;
        }
        m15215a(m15012a, m15012a2);
    }

    /* renamed from: a */
    public void m15214a(C13063i c13063i) {
        this.f37278b = c13063i;
        m15208c();
    }

    /* renamed from: b */
    public InterfaceC13004g m15209b(String str, Map<String, String> map) throws IOException {
        SLog.m15127i("openSDK_LOG.OpenHttpService", "post data");
        return this.f37279c.mo15219a(str, map);
    }

    /* renamed from: a */
    public void m15215a(long j, long j2) {
        InterfaceC12997a interfaceC12997a = this.f37279c;
        if (interfaceC12997a != null) {
            interfaceC12997a.mo15222a(j, j2);
        }
    }

    /* renamed from: a */
    public InterfaceC13004g m15212a(String str, Map<String, String> map) throws IOException {
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
            return m15213a(str, sb.toString());
        }
        return m15213a(str, "");
    }

    /* renamed from: a */
    public InterfaceC13004g m15213a(String str, String str2) throws IOException {
        SLog.m15127i("openSDK_LOG.OpenHttpService", "get.");
        return this.f37279c.mo15220a(str, str2);
    }

    /* renamed from: a */
    public InterfaceC13004g m15211a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            return this.f37279c.mo15218a(str, map, map2);
        }
        return m15209b(str, map);
    }
}
