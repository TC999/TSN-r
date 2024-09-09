package cn.jiguang.bk;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f2718a;

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, String> f2719b = new HashMap();

    private e() {
    }

    private Bundle a(String str, String str2, Bundle bundle, String str3) {
        String str4 = str + "." + str2;
        try {
            IDataShare dataShare = DataShare.getInstance(str3);
            if (dataShare == null) {
                cn.jiguang.bq.d.c("JMessenger", str3 + "'s aidl not found, " + str4);
                return null;
            }
            cn.jiguang.bq.d.c("JMessenger", "sendByAidl, " + str4);
            if ("INTERNAL_API".equals(str)) {
                return dataShare.execute(str, str2, bundle);
            }
            dataShare.onAction(str, str2, bundle);
            return new Bundle();
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JMessenger", "sendByAidl, " + str4 + ", e=" + th);
            return null;
        }
    }

    public static e a() {
        if (f2718a == null) {
            synchronized (e.class) {
                if (f2718a == null) {
                    f2718a = new e();
                }
            }
        }
        return f2718a;
    }

    private static String a(Context context, String str) {
        StringBuilder sb;
        String str2 = f2719b.get(str);
        if (TextUtils.isEmpty(str2)) {
            String str3 = context.getPackageName() + JConstants.DATA_PROVIDER_SUFFIX;
            ProviderInfo a4 = cn.jiguang.f.a.a(context, context.getPackageName(), str3);
            if (str.equals(a4 != null ? a4.processName : null)) {
                sb = new StringBuilder();
            } else {
                str3 = context.getPackageName() + ".DownloadProvider";
                ProviderInfo a5 = cn.jiguang.f.a.a(context, context.getPackageName(), str3);
                if (!str.equals(a5 != null ? a5.processName : null)) {
                    return "";
                }
                sb = new StringBuilder();
            }
            sb.append("content://");
            sb.append(str3);
            sb.append(TTPathConst.sSeparator);
            String sb2 = sb.toString();
            f2719b.put(str, sb2);
            return sb2;
        }
        return str2;
    }

    private boolean a(Context context, Class cls, String str, Bundle bundle) {
        Intent intent;
        if (cls == null) {
            return false;
        }
        String str2 = cls.getName() + "." + str;
        try {
            intent = new Intent();
            intent.setClass(context, cls);
            intent.setAction(str);
            intent.setPackage(context.getPackageName());
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JMessenger", "sendByComponent, " + str2 + " e=" + th);
        }
        if (BroadcastReceiver.class.isAssignableFrom(cls)) {
            context.sendBroadcast(intent);
            cn.jiguang.bq.d.c("JMessenger", "sendByReceiver, " + str2);
            return true;
        }
        if (Service.class.isAssignableFrom(cls)) {
            if (context.startService(intent) != null) {
                cn.jiguang.bq.d.c("JMessenger", "sendByService, " + str2);
                return true;
            }
            cn.jiguang.bq.d.i("JMessenger", "startService, " + str2 + ", can't find component");
        }
        return false;
    }

    private Bundle b(Context context, String str, String str2, Bundle bundle, String str3) {
        String str4 = str + "." + str2;
        try {
            String a4 = a(context, str3);
            if (TextUtils.isEmpty(a4)) {
                cn.jiguang.bq.d.c("JMessenger", "uri is null, check provider config");
                return null;
            }
            Uri parse = Uri.parse(a4);
            cn.jiguang.bq.d.c("JMessenger", "sendByProvider, uri=" + a4 + ", " + str4);
            return context.getContentResolver().call(parse, str, str2, bundle);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JMessenger", "provider call:" + th);
            return null;
        }
    }

    public Bundle a(Context context, String str, String str2, Bundle bundle, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String a4 = cn.jiguang.f.a.a(context);
        if (TextUtils.isEmpty(a4)) {
            return null;
        }
        if (a4.equals(str3)) {
            return b(context, str, str2, bundle);
        }
        Bundle a5 = a(str, str2, bundle, str3);
        if (a5 != null) {
            return a5;
        }
        Bundle b4 = b(context, str, str2, bundle, str3);
        if (b4 != null) {
            return b4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:17:0x0057, B:20:0x005f), top: B:27:0x0057 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.Context r11, java.lang.String r12, java.lang.String r13, android.os.Bundle r14) {
        /*
            r10 = this;
            java.lang.String r7 = " meet e:"
            java.lang.String r8 = "JMessenger"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r1 = "."
            r0.append(r1)
            r0.append(r13)
            java.lang.String r9 = r0.toString()
            r1 = 0
            java.lang.Class r2 = java.lang.Class.forName(r12)     // Catch: java.lang.Throwable -> L39
            java.lang.Class<android.app.Service> r0 = android.app.Service.class
            boolean r0 = r0.isAssignableFrom(r2)     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L2a
            java.lang.String r1 = cn.jiguang.f.a.a(r11, r12)     // Catch: java.lang.Throwable -> L37
            goto L50
        L2a:
            java.lang.Class<android.content.BroadcastReceiver> r0 = android.content.BroadcastReceiver.class
            boolean r0 = r0.isAssignableFrom(r2)     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L50
            java.lang.String r1 = cn.jiguang.f.a.b(r11, r12)     // Catch: java.lang.Throwable -> L37
            goto L50
        L37:
            r0 = move-exception
            goto L3b
        L39:
            r0 = move-exception
            r2 = r1
        L3b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            r4.append(r7)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            cn.jiguang.bq.d.c(r8, r0)
        L50:
            r6 = r1
            r0 = r2
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            android.os.Bundle r1 = r1.a(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L66
            r2 = 1
            if (r1 == 0) goto L5f
            return r2
        L5f:
            boolean r0 = r10.a(r11, r0, r13, r14)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L81
            return r2
        L66:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "send, "
            r2.append(r3)
            r2.append(r9)
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            cn.jiguang.bq.d.i(r8, r0)
        L81:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "send all failed, "
            r0.append(r2)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            cn.jiguang.bq.d.l(r8, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bk.e.a(android.content.Context, java.lang.String, java.lang.String, android.os.Bundle):boolean");
    }

    public Bundle b(Context context, String str, String str2, Bundle bundle) {
        try {
            cn.jiguang.bq.d.c("JMessenger", "directHandle, " + str + "." + str2);
            if ("INTERNAL_API".equals(str)) {
                if (str2.equals("isTcpLoggedIn")) {
                    boolean d4 = cn.jiguang.bx.h.a().d();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("state", d4);
                    return bundle2;
                } else if (!"cmd_event_bundle".equals(str2)) {
                    cn.jiguang.bq.d.l("JMessenger", "directHandle, not support " + str + "." + str2);
                    return null;
                } else {
                    int i4 = bundle.getInt("cmd_event_bundle_cmd");
                    String string = bundle.getString("cmd_event_bundle_action");
                    String string2 = bundle.getString("cmd_event_bundle_sdk_type");
                    Bundle bundle3 = bundle.getBundle("cmd_event_bundle_bundle");
                    cn.jiguang.bq.d.c("JMessenger", "cmd:" + i4 + ",act:" + string + ",sdkType:" + string2 + ",bundleBundle:" + bundle3);
                    Object onEvent = JCoreManager.onEvent(context, string2, i4, string, bundle3, new Object[0]);
                    if (onEvent instanceof Bundle) {
                        return (Bundle) onEvent;
                    }
                    return null;
                }
            }
            Class<?> cls = Class.forName(str);
            if (!BroadcastReceiver.class.isAssignableFrom(cls) && !Service.class.isAssignableFrom(cls)) {
                cn.jiguang.bq.d.l("JMessenger", "directHandle, not support " + str + "." + str2);
                return null;
            } else if (JCommonService.class.isAssignableFrom(cls)) {
                cn.jiguang.bq.d.c("JMessenger", "JCommonService handle succeed," + str + "." + str2);
                JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 2, true, str2, bundle, new Object[0]);
                return new Bundle();
            } else {
                Intent intent = new Intent(str2);
                intent.setClass(context, cls);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                intent.setPackage(context.getPackageName());
                intent.addCategory(context.getPackageName());
                if (PushReceiver.class.isAssignableFrom(cls)) {
                    cn.jiguang.bq.d.c("JMessenger", "PushReceiver handle succeed," + str + "." + str2);
                    ActionManager.getInstance().handleMessage(context, bundle != null ? bundle.getString("sdktype") : null, intent);
                } else if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                    cn.jiguang.bq.d.c("JMessenger", "Receiver onReceive," + str + "." + str2);
                    ((BroadcastReceiver) cls.newInstance()).onReceive(context, intent);
                } else {
                    cn.jiguang.bq.d.c("JMessenger", "Service onStartCommand," + str + "." + str2);
                    ((Service) cls.newInstance()).onStartCommand(intent, 0, 0);
                }
                return new Bundle();
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.l("JMessenger", "directHandle e:" + th);
            return null;
        }
    }
}
