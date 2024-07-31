package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C13131bm;
import com.umeng.analytics.pro.CacheDBHelper;
import com.umeng.analytics.pro.CacheData;
import com.umeng.analytics.pro.CoreProtocolImpl;
import com.umeng.analytics.pro.OpenDeviceId;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.EnvelopeManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.OaidTracking;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.internal.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMInternalDataProtocol implements UMLogDataProtocol {

    /* renamed from: b */
    public static final String f38819b = "preInitInvokedFlag";

    /* renamed from: c */
    public static final String f38820c = "policyGrantInvokedFlag";

    /* renamed from: d */
    public static final String f38821d = "policyGrantResult";

    /* renamed from: f */
    private static int f38822f = 1;

    /* renamed from: e */
    private Context f38830e;

    /* renamed from: a */
    public static final String f38818a = PathCenter.m14695b().m14694b(PathCenter.f37698q);

    /* renamed from: g */
    private static Class<?> f38823g = null;

    /* renamed from: h */
    private static Method f38824h = null;

    /* renamed from: i */
    private static Method f38825i = null;

    /* renamed from: j */
    private static Method f38826j = null;

    /* renamed from: k */
    private static volatile String f38827k = "";

    /* renamed from: l */
    private static volatile String f38828l = "";

    /* renamed from: m */
    private static boolean f38829m = false;

    static {
        m13965c();
    }

    public UMInternalDataProtocol(Context context) {
        if (context != null) {
            this.f38830e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    /* renamed from: b */
    public static String m13967b() {
        Method method;
        if (!TextUtils.isEmpty(f38828l)) {
            return f38828l;
        }
        Class<?> cls = f38823g;
        if (cls == null || (method = f38824h) == null || f38826j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke != null) {
                String str = (String) f38826j.invoke(invoke, new Object[0]);
                try {
                    f38828l = str;
                } catch (Throwable unused) {
                }
                return str;
            }
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: c */
    private static void m13965c() {
        try {
            f38823g = ZIDManager.class;
            Method declaredMethod = ZIDManager.class.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null) {
                f38824h = declaredMethod;
            }
            Method declaredMethod2 = f38823g.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                f38825i = declaredMethod2;
            }
            Method declaredMethod3 = f38823g.getDeclaredMethod("getSDKVersion", new Class[0]);
            if (declaredMethod3 != null) {
                f38826j = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private void m13963d() {
        CacheDBHelper m14580a = CacheDBHelper.m14580a(this.f38830e);
        CacheData m14578a = m14580a.m14578a(C13131bm.f37926c);
        if (m14578a != null) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = m14578a.f37918a;
                String str2 = m14578a.f37919b;
                JSONObject m13838a = new EnvelopeManager().m13838a(StubApp.getOrigApplicationContext(this.f38830e.getApplicationContext()), new JSONObject(m14578a.f37920c), new JSONObject(m14578a.f37921d), m14578a.f37922e, str2, m14578a.f37923f);
                if (m13838a != null && m13838a.has("exception")) {
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                } else {
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                }
                m14580a.m14576a(C13131bm.f37926c, str);
                m14580a.m14573b();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: e */
    private void m13961e() {
        if (!f38829m) {
            if (FieldManager.allow(UMConstant.f39161G)) {
                f38829m = true;
                m13971a(this.f38830e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                    @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                    public void onGetOaid(String str) {
                        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                SharedPreferences sharedPreferences = UMInternalDataProtocol.this.f38830e.getSharedPreferences(OaidTracking.f39002a, 0);
                                if (sharedPreferences != null) {
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.putString(OaidTracking.f39003b, str);
                                    edit.commit();
                                }
                            } catch (Throwable unused) {
                            }
                            UMWorkDispatch.sendEvent(UMInternalDataProtocol.this.f38830e, UMInternalConfig.f38811w, UMInternalData.m13974a(UMInternalDataProtocol.this.f38830e).m13975a(), null);
                            return;
                        }
                        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                    }
                });
            }
        } else if (FieldManager.allow(UMConstant.f39161G)) {
        } else {
            f38829m = false;
        }
    }

    /* renamed from: f */
    private void m13959f() {
        if (FieldManager.allow(UMConstant.f39161G)) {
            f38829m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f38830e);
            f38822f++;
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (UMInternalDataProtocol.this.f38830e != null) {
                        UMWorkDispatch.sendEvent(UMInternalDataProtocol.this.f38830e, UMInternalConfig.f38812x, UMInternalData.m13974a(UMInternalDataProtocol.this.f38830e).m13975a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            m13970a(this.f38830e, true);
        }
    }

    /* renamed from: g */
    private void m13957g() {
        if (f38822f <= 0) {
            m13956h();
            m13960e(this.f38830e);
        }
    }

    /* renamed from: h */
    private void m13956h() {
        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f38830e)) {
            m13958f(this.f38830e);
            UMInnerManager.sendInnerPackage(this.f38830e);
            if (!FieldManager.allow(UMConstant.f39199ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f38830e)) {
                Context context = this.f38830e;
                UMWorkDispatch.sendEvent(context, UMInternalConfig.f38783G, UMInternalData.m13974a(context).m13975a(), null, 5000L);
            }
            Context context2 = this.f38830e;
            UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38424z, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f38830e;
            UMWorkDispatch.sendEvent(context3, UMInternalConfig.f38808t, UMInternalData.m13974a(context3).m13975a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.UMInternalDataProtocol.workEvent(java.lang.Object, int):void");
    }

    /* renamed from: a */
    public String m13973a() {
        Method method;
        if (!TextUtils.isEmpty(f38827k)) {
            return f38827k;
        }
        Class<?> cls = f38823g;
        if (cls == null || (method = f38824h) == null || f38825i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke != null) {
                String str = (String) f38825i.invoke(invoke, this.f38830e);
                try {
                    f38827k = str;
                } catch (Throwable unused) {
                }
                return str;
            }
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: b */
    private void m13966b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EnvelopeManager.m13836a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(EnvelopeManager.m13836a("umid"), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader != null && buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            } else {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m13972a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EnvelopeManager.m13836a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(EnvelopeManager.m13836a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(EnvelopeManager.m13836a("os"), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m13960e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> m13968a = m13968a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = m13968a.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(m13968a, new Object[0])) == null || (declaredMethod = m13968a.getDeclaredMethod("init", Context.class, String.class, m13968a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, origApplicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private static void m13964c(final Context context) {
        if (FieldManager.allow(UMConstant.f39161G)) {
            m13971a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(OaidTracking.f39002a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(OaidTracking.f39003b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(OaidTracking.f39003b, str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private static void m13958f(Context context) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir.getAbsolutePath() + File.separator + C13131bm.f37935l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m13970a(final Context context, final boolean z) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(OaidTracking.f39002a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String m14692a = OpenDeviceId.m14692a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(m14692a) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(OaidTracking.f39004c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(OaidTracking.f39003b, m14692a);
                        edit2.commit();
                    }
                    if (z) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m13962d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = com.umeng.common.SPHelper.m14057a(r11, r0, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L90
            java.lang.String r3 = "startTime"
            java.lang.String r3 = com.umeng.common.SPHelper.m14057a(r11, r0, r3)
            java.lang.String r4 = "period"
            java.lang.String r0 = com.umeng.common.SPHelper.m14057a(r11, r0, r4)
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
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.m14008i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.SPHelper.m14058a(r11, r0)
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
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.m14008i(r0, r1)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L90
        L86:
            java.lang.String r1 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.m14008i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.SPHelper.m14058a(r11, r0)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.UMInternalDataProtocol.m13962d(android.content.Context):void");
    }

    /* renamed from: a */
    private static void m13971a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String m14692a = OpenDeviceId.m14692a(origApplicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(m14692a);
                }
            }
        }).start();
    }

    /* renamed from: a */
    private static Class<?> m13968a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
