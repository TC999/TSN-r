package com.tencent.connect.p561a;

import android.content.Context;
import android.text.TextUtils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13014e;
import com.tencent.open.utils.C13063i;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12926a {

    /* renamed from: a */
    private static Class<?> f36977a;

    /* renamed from: b */
    private static Class<?> f36978b;

    /* renamed from: c */
    private static Method f36979c;

    /* renamed from: d */
    private static Method f36980d;

    /* renamed from: e */
    private static Method f36981e;

    /* renamed from: f */
    private static Method f36982f;

    /* renamed from: g */
    private static boolean f36983g;

    /* renamed from: a */
    public static boolean m15469a(Context context, QQToken qQToken) {
        return C13063i.m15015a(context, qQToken.getAppId()).m15008b("Common_ta_enable");
    }

    /* renamed from: b */
    public static void m15467b(Context context, QQToken qQToken) {
        try {
            if (m15469a(context, qQToken)) {
                f36982f.invoke(f36977a, Boolean.TRUE);
            } else {
                f36982f.invoke(f36977a, Boolean.FALSE);
            }
        } catch (Exception e) {
            SLog.m15129e("OpenConfig", "checkStatStatus exception: " + e.toString());
        }
    }

    /* renamed from: c */
    public static void m15466c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f36977a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f36978b = cls;
            f36979c = cls.getMethod("reportQQ", Context.class, String.class);
            f36980d = f36978b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f36978b;
            Class<?> cls3 = Integer.TYPE;
            f36981e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f36977a;
            Class<?> cls5 = Boolean.TYPE;
            f36982f = cls4.getMethod("setEnableStatService", cls5);
            m15467b(context, qQToken);
            f36977a.getMethod("setAutoExceptionCaught", cls5).invoke(f36977a, Boolean.FALSE);
            f36977a.getMethod("setEnableSmartReporting", cls5).invoke(f36977a, Boolean.TRUE);
            f36977a.getMethod("setSendPeriodMinutes", cls3).invoke(f36977a, Integer.valueOf((int) PredefinedCaptureConfigurations.f24414x));
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f36977a.getMethod("setStatSendStrategy", cls6).invoke(f36977a, cls6.getField("PERIOD").get(null));
            f36978b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f36978b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f36983g = true;
        } catch (Exception e) {
            SLog.m15129e("OpenConfig", "start4QQConnect exception: " + e.toString());
        }
    }

    /* renamed from: d */
    public static void m15465d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            C13014e.m15176a().m15173a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "0", "0", "0");
        }
        if (f36983g) {
            m15467b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f36979c.invoke(f36978b, context, qQToken.getOpenId());
                } catch (Exception e) {
                    SLog.m15129e("OpenConfig", "reportQQ exception: " + e.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m15468a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f36983g) {
            m15467b(context, qQToken);
            try {
                f36980d.invoke(f36978b, context, str, strArr);
            } catch (Exception e) {
                SLog.m15129e("OpenConfig", "trackCustomEvent exception: " + e.toString());
            }
        }
    }
}
