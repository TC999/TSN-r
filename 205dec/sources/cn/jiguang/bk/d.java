package cn.jiguang.bk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.JCommonService;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2714a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f2715b;

    /* renamed from: c  reason: collision with root package name */
    private static String f2716c;

    /* renamed from: d  reason: collision with root package name */
    private static String f2717d;

    public static d a() {
        if (f2715b == null) {
            synchronized (f2714a) {
                if (f2715b == null) {
                    f2715b = new d();
                }
            }
        }
        return f2715b;
    }

    public static String a(Context context) {
        StringBuilder sb;
        String str;
        String str2 = f2717d;
        if (str2 != null) {
            return str2;
        }
        String c4 = c(context);
        if (TextUtils.isEmpty(c4)) {
            f2717d = context.getPackageName();
            sb = new StringBuilder();
            str = "user serviceProcess is curProcessName:";
        } else {
            f2717d = cn.jiguang.f.a.a(context, c4);
            sb = new StringBuilder();
            str = "user serviceProcess is:";
        }
        sb.append(str);
        sb.append(f2717d);
        cn.jiguang.bq.d.c("JCommonServiceHelper", sb.toString());
        return f2717d;
    }

    public static boolean b(Context context) {
        return cn.jiguang.f.a.a(context).equals(a(context));
    }

    public static String c(Context context) {
        ComponentInfo a4;
        String str;
        try {
            str = f2716c;
        } catch (Throwable th) {
            cn.jiguang.bq.d.c("JCommonServiceHelper", "getUserServiceClass failed:" + th);
        }
        if (str != null) {
            return str;
        }
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        String a5 = cn.jiguang.f.a.a(context, intent, "");
        if (!TextUtils.isEmpty(a5) && JCommonService.class.isAssignableFrom(Class.forName(a5))) {
            f2716c = a5;
            cn.jiguang.bq.d.h("JCommonServiceHelper", "found userServiceClass :" + f2716c + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(f2716c) && (a4 = cn.jiguang.f.a.a(context, context.getPackageName(), JCommonService.class)) != null) {
            f2716c = a4.name;
            cn.jiguang.bq.d.h("JCommonServiceHelper", "found userServiceClass :" + f2716c + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f2716c)) {
            f2716c = "";
        }
        return f2716c;
    }

    public void a(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.bq.d.c("JCommonServiceHelper", sb.toString());
            String c4 = c(context);
            if (TextUtils.isEmpty(c4)) {
                cn.jiguang.a.a.b(context, str, bundle);
            } else {
                e.a().a(context, c4, str, bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.f("JCommonServiceHelper", "onAction failed", th);
        }
    }

    public void b(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("callAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.bq.d.f("JCommonServiceHelper", sb.toString());
            cn.jiguang.bt.a.a(JConstants.getAppContext(context), str, bundle);
        } catch (Throwable th) {
            cn.jiguang.bq.d.f("JCommonServiceHelper", "callAction failed", th);
        }
    }
}
