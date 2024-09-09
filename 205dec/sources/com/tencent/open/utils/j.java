package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f51839a;

    /* renamed from: b  reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f51840b = null;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f51839a == null) {
                f51839a = new j();
            }
            jVar = f51839a;
        }
        return jVar;
    }

    public String a(Context context, String str) {
        if (this.f51840b == null || this.f51840b.get() == null) {
            this.f51840b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f51840b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e4.getMessage());
            return str;
        }
    }
}
