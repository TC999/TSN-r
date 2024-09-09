package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.bm;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMInternalDataProtocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c implements UMLogDataProtocol {

    /* renamed from: b  reason: collision with root package name */
    public static final String f53455b = "preInitInvokedFlag";

    /* renamed from: c  reason: collision with root package name */
    public static final String f53456c = "policyGrantInvokedFlag";

    /* renamed from: d  reason: collision with root package name */
    public static final String f53457d = "policyGrantResult";

    /* renamed from: f  reason: collision with root package name */
    private static int f53458f = 1;

    /* renamed from: e  reason: collision with root package name */
    private Context f53466e;

    /* renamed from: a  reason: collision with root package name */
    public static final String f53454a = au.b().b("upg");

    /* renamed from: g  reason: collision with root package name */
    private static Class<?> f53459g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Method f53460h = null;

    /* renamed from: i  reason: collision with root package name */
    private static Method f53461i = null;

    /* renamed from: j  reason: collision with root package name */
    private static Method f53462j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile String f53463k = "";

    /* renamed from: l  reason: collision with root package name */
    private static volatile String f53464l = "";

    /* renamed from: m  reason: collision with root package name */
    private static boolean f53465m = false;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f53466e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(f53464l)) {
            return f53464l;
        }
        Class<?> cls = f53459g;
        if (cls == null || (method = f53460h) == null || f53462j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke != null) {
                String str = (String) f53462j.invoke(invoke, new Object[0]);
                try {
                    f53464l = str;
                } catch (Throwable unused) {
                }
                return str;
            }
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static void c() {
        try {
            f53459g = ZIDManager.class;
            Method declaredMethod = ZIDManager.class.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null) {
                f53460h = declaredMethod;
            }
            Method declaredMethod2 = f53459g.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                f53461i = declaredMethod2;
            }
            Method declaredMethod3 = f53459g.getDeclaredMethod("getSDKVersion", new Class[0]);
            if (declaredMethod3 != null) {
                f53462j = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bk a4 = bk.a(this.f53466e);
        bl a5 = a4.a("stf");
        if (a5 != null) {
            UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u6784\u5efa\u6210\u771f\u6b63\u4fe1\u5c01\u3002");
            try {
                String str = a5.f52704a;
                String str2 = a5.f52705b;
                JSONObject a6 = new com.umeng.commonsdk.statistics.b().a(StubApp.getOrigApplicationContext(this.f53466e.getApplicationContext()), new JSONObject(a5.f52706c), new JSONObject(a5.f52707d), a5.f52708e, str2, a5.f52709f);
                if (a6 != null && a6.has("exception")) {
                    UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u6784\u5efa\u771f\u6b63\u4fe1\u5c01 \u5931\u8d25\u3002\u5220\u9664\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55");
                } else {
                    UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u6784\u5efa\u771f\u6b63\u4fe1\u5c01 \u6210\u529f! \u5220\u9664\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u3002");
                }
                a4.a("stf", str);
                a4.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (!f53465m) {
            if (FieldManager.allow("header_device_oaid")) {
                f53465m = true;
                a(this.f53466e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                    @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                    public void onGetOaid(String str) {
                        UMRTLog.e("MobclickRT", "--->>> OAID\u4e91\u63a7\u53c2\u6570\u66f4\u65b0(\u4e0d\u91c7\u96c6->\u91c7\u96c6)\uff1a\u91c7\u96c6\u5b8c\u6210");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                SharedPreferences sharedPreferences = c.this.f53466e.getSharedPreferences(h.f53637a, 0);
                                if (sharedPreferences != null) {
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.putString("key_umeng_sp_oaid", str);
                                    edit.commit();
                                }
                            } catch (Throwable unused) {
                            }
                            UMWorkDispatch.sendEvent(c.this.f53466e, 32788, b.a(c.this.f53466e).a(), null);
                            return;
                        }
                        UMRTLog.e("MobclickRT", "--->>> oaid\u8fd4\u56denull\u6216\u8005\u7a7a\u4e32\uff0c\u4e0d\u9700\u8981 \u4f2a\u51b7\u542f\u52a8\u3002");
                    }
                });
            }
        } else if (FieldManager.allow("header_device_oaid")) {
        } else {
            f53465m = false;
        }
    }

    private void f() {
        if (FieldManager.allow("header_device_oaid")) {
            f53465m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f53466e);
            f53458f++;
            UMRTLog.e("MobclickRT", "--->>> \u8981\u8bfb\u53d6 oaid\uff0c\u9700\u7b49\u5f85\u8bfb\u53d6\u7ed3\u679c.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f53466e != null) {
                        UMWorkDispatch.sendEvent(c.this.f53466e, 32790, b.a(c.this.f53466e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.f53466e, true);
        }
    }

    private void g() {
        if (f53458f <= 0) {
            h();
            e(this.f53466e);
        }
    }

    private void h() {
        UMRTLog.e("MobclickRT", "--->>> \u771f\u5b9e\u6784\u5efa\u6761\u4ef6\u6ee1\u8db3\uff0c\u5f00\u59cb\u6784\u5efa\u4e1a\u52a1\u4fe1\u5c01\u3002");
        if (UMUtils.isMainProgress(this.f53466e)) {
            f(this.f53466e);
            UMInnerManager.sendInnerPackage(this.f53466e);
            if (!FieldManager.allow("ccg_switch") && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f53466e)) {
                Context context = this.f53466e;
                UMWorkDispatch.sendEvent(context, 32805, b.a(context).a(), null, 5000L);
            }
            Context context2 = this.f53466e;
            UMWorkDispatch.sendEvent(context2, 8208, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f53466e;
            UMWorkDispatch.sendEvent(context3, 32785, b.a(context3).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j4) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02c4 A[Catch: all -> 0x043e, TryCatch #2 {all -> 0x043e, blocks: (B:20:0x008b, B:22:0x0093, B:24:0x00a2, B:25:0x00a5, B:26:0x00b0, B:41:0x0112, B:45:0x0144, B:51:0x015c, B:53:0x017c, B:55:0x0182, B:56:0x0192, B:58:0x01bd, B:61:0x01c7, B:63:0x01cb, B:65:0x01e3, B:84:0x0280, B:86:0x0297, B:88:0x02a2, B:91:0x02a9, B:93:0x02af, B:95:0x02ba, B:100:0x02c4, B:102:0x02ca, B:103:0x02d6, B:104:0x02dd), top: B:141:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02dd A[Catch: all -> 0x043e, TRY_LEAVE, TryCatch #2 {all -> 0x043e, blocks: (B:20:0x008b, B:22:0x0093, B:24:0x00a2, B:25:0x00a5, B:26:0x00b0, B:41:0x0112, B:45:0x0144, B:51:0x015c, B:53:0x017c, B:55:0x0182, B:56:0x0192, B:58:0x01bd, B:61:0x01c7, B:63:0x01cb, B:65:0x01e3, B:84:0x0280, B:86:0x0297, B:88:0x02a2, B:91:0x02a9, B:93:0x02af, B:95:0x02ba, B:100:0x02c4, B:102:0x02ca, B:103:0x02d6, B:104:0x02dd), top: B:141:0x0079 }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void workEvent(java.lang.Object r10, int r11) {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(f53463k)) {
            return f53463k;
        }
        Class<?> cls = f53459g;
        if (cls == null || (method = f53460h) == null || f53461i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke != null) {
                String str = (String) f53461i.invoke(invoke, this.f53466e);
                try {
                    f53463k = str;
                } catch (Throwable unused) {
                }
                return str;
            }
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("umid"), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader != null && buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e("MobclickRT", "--->>> \u6784\u5efa\u5fc3\u8df3\u62a5\u6587\u5931\u8d25.");
            } else {
                UMRTLog.e("MobclickRT", "--->>> \u6784\u5efa\u5fc3\u8df3\u62a5\u6587 \u6210\u529f!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("os"), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e("MobclickRT", "--->>> \u6784\u5efa\u96f6\u53f7\u62a5\u6587\u5931\u8d25.");
            } else {
                UMRTLog.e("MobclickRT", "--->>> \u6784\u5efa\u96f6\u53f7\u62a5\u6587 \u6210\u529f!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a4 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a4.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a4, new Object[0])) == null || (declaredMethod = a4.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, origApplicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow("header_device_oaid")) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.f53637a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString("key_umeng_sp_oaid", "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e("MobclickRT", "--->>> \u66f4\u65b0\u672c\u5730\u7f13\u5b58OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("key_umeng_sp_oaid", str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static void f(Context context) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir.getAbsolutePath() + File.separator + bm.f52721l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, final boolean z3) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.f53637a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a4 = aw.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a4) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("key_umeng_sp_oaid_required_time", (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString("key_umeng_sp_oaid", a4);
                        edit2.commit();
                    }
                    if (z3) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = com.umeng.common.b.a(r11, r0, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L90
            java.lang.String r3 = "startTime"
            java.lang.String r3 = com.umeng.common.b.a(r11, r0, r3)
            java.lang.String r4 = "period"
            java.lang.String r0 = com.umeng.common.b.a(r11, r0, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L2e
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L2e
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L2e
            goto L2f
        L2e:
            r3 = r5
        L2f:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L3e
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L3e
            long r7 = r0.longValue()     // Catch: java.lang.Throwable -> L3e
            goto L3f
        L3e:
            r7 = r5
        L3f:
            java.lang.String r0 = "MobclickRT"
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L86
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L4a
            goto L86
        L4a:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r3
            r3 = 60
            long r7 = r7 * r3
            r3 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L6f
            java.lang.String r1 = "--->>> [RTD]\u672c\u5730\u7f13\u5b58dk\u503c\u5df2\u7ecf\u8d85\u65f6\uff0c\u6e05\u9664\u7f13\u5b58\u6570\u636e\u3002"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
            boolean r11 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r11 == 0) goto L90
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L90
        L6f:
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r11.put(r1, r2)
            boolean r1 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r1 != 0) goto L90
            java.lang.String r1 = "--->>> [RTD]\u672c\u5730\u7f13\u5b58dk\u503c\u5728\u6709\u6548\u671f\u5185\uff0c\u5207\u6362\u5230\u57cb\u70b9\u9a8c\u8bc1\u6a21\u5f0f\u3002"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L90
        L86:
            java.lang.String r1 = "--->>> [RTD]\u672c\u5730\u7f13\u5b58startTime\u6216\u8005duration\u503c\u65e0\u6548\uff0c\u6e05\u9664\u7f13\u5b58\u6570\u636e"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a4 = aw.a(origApplicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a4);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
