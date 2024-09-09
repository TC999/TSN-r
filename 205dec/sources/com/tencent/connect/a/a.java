package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.lang.reflect.Method;
import xyz.adscope.common.network.cookie.db.Field;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f51343a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f51344b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f51345c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f51346d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f51347e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f51348f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f51349g;

    public static boolean a(Context context, QQToken qQToken) {
        return i.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f51348f.invoke(f51343a, Boolean.TRUE);
            } else {
                f51348f.invoke(f51343a, Boolean.FALSE);
            }
        } catch (Exception e4) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e4.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f51343a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f51344b = cls;
            f51345c = cls.getMethod("reportQQ", Context.class, String.class);
            f51346d = f51344b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f51344b;
            Class<?> cls3 = Integer.TYPE;
            f51347e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f51343a;
            Class<?> cls5 = Boolean.TYPE;
            f51348f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            f51343a.getMethod("setAutoExceptionCaught", cls5).invoke(f51343a, Boolean.FALSE);
            f51343a.getMethod("setEnableSmartReporting", cls5).invoke(f51343a, Boolean.TRUE);
            f51343a.getMethod("setSendPeriodMinutes", cls3).invoke(f51343a, 1440);
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f51343a.getMethod("setStatSendStrategy", cls6).invoke(f51343a, cls6.getField("PERIOD").get(null));
            f51344b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f51344b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField(Field.VERSION).get(null));
            f51349g = true;
        } catch (Exception e4) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e4.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (f51349g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f51345c.invoke(f51344b, context, qQToken.getOpenId());
                } catch (Exception e4) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e4.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f51349g) {
            b(context, qQToken);
            try {
                f51346d.invoke(f51344b, context, str, strArr);
            } catch (Exception e4) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e4.toString());
            }
        }
    }
}
