package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13065j {

    /* renamed from: a */
    private static C13065j f37439a;

    /* renamed from: b */
    private volatile WeakReference<SharedPreferences> f37440b = null;

    /* renamed from: a */
    public static synchronized C13065j m15004a() {
        C13065j c13065j;
        synchronized (C13065j.class) {
            if (f37439a == null) {
                f37439a = new C13065j();
            }
            c13065j = f37439a;
        }
        return c13065j;
    }

    /* renamed from: a */
    public String m15003a(Context context, String str) {
        if (this.f37440b == null || this.f37440b.get() == null) {
            this.f37440b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.m15129e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f37440b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                SLog.m15123v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            SLog.m15123v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e) {
            SLog.m15129e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }
}
