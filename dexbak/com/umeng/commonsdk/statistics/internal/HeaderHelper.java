package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* renamed from: com.umeng.commonsdk.statistics.internal.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HeaderHelper {

    /* renamed from: a */
    private static Context f39011a;

    /* renamed from: b */
    private String f39012b;

    /* renamed from: c */
    private String f39013c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeaderHelper.java */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13257a {

        /* renamed from: a */
        private static final HeaderHelper f39014a = new HeaderHelper();

        private C13257a() {
        }
    }

    /* renamed from: a */
    public static HeaderHelper m13686a(Context context) {
        if (f39011a == null && context != null) {
            f39011a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C13257a.f39014a;
    }

    /* renamed from: f */
    private void m13679f(String str) {
        try {
            String replaceAll = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/");
            this.f39012b = replaceAll + "/Android " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f39011a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f39011a, th);
        }
    }

    /* renamed from: g */
    private void m13678g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(UMCommonContent.f37790aT);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb.append(substring);
                }
            }
            this.f39013c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f39011a, th);
        }
    }

    /* renamed from: b */
    public boolean m13683b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(UMCommonContent.f37782aL);
    }

    /* renamed from: c */
    public boolean m13682c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(UMCommonContent.f37777aG);
    }

    /* renamed from: d */
    public boolean m13681d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    /* renamed from: e */
    public void m13680e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        m13678g(substring);
        m13679f(substring);
    }

    private HeaderHelper() {
        this.f39012b = null;
        this.f39013c = null;
    }

    /* renamed from: b */
    public String m13684b() {
        return this.f39012b;
    }

    /* renamed from: a */
    public boolean m13685a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    /* renamed from: a */
    public String m13687a() {
        return this.f39013c;
    }
}
