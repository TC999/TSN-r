package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SessionIdManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class y {

    /* renamed from: c  reason: collision with root package name */
    private static volatile y f53145c;

    /* renamed from: a  reason: collision with root package name */
    private w f53146a = new x();

    /* renamed from: b  reason: collision with root package name */
    private String f53147b;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f53148d;

    /* renamed from: e  reason: collision with root package name */
    private String f53149e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: SessionIdManager.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a(String str, long j4, long j5, long j6);

        void a(String str, String str2, long j4, long j5, long j6);
    }

    private y() {
    }

    public static y a() {
        if (f53145c == null) {
            synchronized (y.class) {
                if (f53145c == null) {
                    f53145c = new y();
                }
            }
        }
        return f53145c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("pre_session_id", d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h4 = h(context);
        long i4 = i(context);
        String str = this.f53147b;
        long a4 = u.a(context);
        long j4 = a4 * 5000;
        UMRTLog.e("MobclickRT", "--->>>*** \u8bfb\u53d6 foreground count \u503c\u5b8c\u6210\uff0ccount\u6b21\u6570\uff1a" + a4);
        if (FieldManager.allow("header_foreground_count")) {
            if (UMWorkDispatch.eventHasExist()) {
                UMRTLog.e("MobclickRT", "--->>>*** \u8bfb\u53d6 foreground count druation\u503c\u5b8c\u6210\uff0c\u7ec8\u6b62checker timer.");
                UMWorkDispatch.removeEvent();
            } else {
                UMRTLog.e("MobclickRT", "--->>>*** \u8bfb\u53d6 foreground count druation\u503c\u5b8c\u6210\uff0c\u65e0\u672a\u5904\u7406check timer\u4e8b\u4ef6\u3002");
            }
        } else {
            UMRTLog.e("MobclickRT", "--->>>*** foreground count druation\u4e91\u63a7\u53c2\u6570\u5173\u95ed\u3002");
        }
        a(i4, h4, j4, str, false);
        this.f53147b = this.f53146a.a(context);
        a(i4, h4, j4, str, true);
        this.f53146a.a(context, this.f53147b);
        return this.f53147b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f53147b) && i.a(context).a(this.f53147b) > 0;
    }

    private long h(Context context) {
        return a(context, "a_end_time");
    }

    private long i(Context context) {
        return a(context, "session_start_time");
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j4 = sharedPreferences.getLong("a_start_time", 0L);
            long j5 = sharedPreferences.getLong("a_end_time", 0L);
            if (FieldManager.allow("header_foreground_count") && j4 > 0 && j5 == 0) {
                long a4 = u.a(appContext);
                if (a4 > 0) {
                    UMRTLog.e("MobclickRT", "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j5 = j4 + (a4 * 5000);
                }
            }
            UMRTLog.i("MobclickRT", "--->>> interval of last session is: " + (j5 - j4));
            return this.f53146a.a(j4, j5);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f53146a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f53147b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f53147b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f53147b)) {
            try {
                this.f53147b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f53147b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f53147b)) {
            this.f53147b = d(context);
        }
        return TextUtils.isEmpty(this.f53147b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f53147b = d(appContext);
        if (e(appContext)) {
            try {
                this.f53147b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f53147b;
    }

    public void a(long j4) {
        this.f53146a.a(j4);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (y.class) {
                str = PreferenceWrapper.getDefault(appContext).getString("pre_session_id", "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f53148d) == null || list.size() == 0) {
            return;
        }
        this.f53148d.remove(aVar);
    }

    public String a(Context context, long j4) {
        if (TextUtils.isEmpty(this.f53149e)) {
            String str = "SUB" + j4;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f53149e = sb.toString();
        }
        return this.f53149e;
    }

    private long a(Context context, String str) {
        long j4;
        try {
            j4 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j4 = 0;
        }
        return j4 <= 0 ? System.currentTimeMillis() : j4;
    }

    private void a(long j4, long j5, long j6, String str, boolean z3) {
        List<a> list = this.f53148d;
        if (list != null) {
            for (a aVar : list) {
                if (z3) {
                    try {
                        aVar.a(str, this.f53147b, j4, j5, j6);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f53147b, j4, j5, j6);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f53148d == null) {
            this.f53148d = new ArrayList();
        }
        if (this.f53148d.contains(aVar)) {
            return;
        }
        this.f53148d.add(aVar);
    }
}
