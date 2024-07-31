package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.tencent.bugly.BUGLY;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12904p {

    /* renamed from: a */
    public static boolean f36890a = true;

    /* renamed from: b */
    public static List<AbstractC12903o> f36891b = new ArrayList();

    /* renamed from: c */
    public static boolean f36892c;

    /* renamed from: d */
    private static C12920w f36893d;

    /* renamed from: e */
    private static boolean f36894e;

    /* renamed from: a */
    private static boolean m15568a(C12786aa c12786aa) {
        List<String> list = c12786aa.f36469v;
        return list != null && list.contains("bugly");
    }

    /* renamed from: a */
    public static synchronized void m15571a(Context context) {
        synchronized (C12904p.class) {
            m15570a(context, null);
        }
    }

    /* renamed from: a */
    public static synchronized void m15570a(Context context, BUGLY bugly) {
        synchronized (C12904p.class) {
            if (f36894e) {
                C12820al.m15873d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C12820al.f36546b, "[init] context of init() is null, check it.");
            } else {
                C12786aa m16009a = C12786aa.m16009a(context);
                if (m15568a(m16009a)) {
                    f36890a = false;
                    return;
                }
                String m15998e = m16009a.m15998e();
                if (m15998e == null) {
                    Log.e(C12820al.f36546b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                } else {
                    m15569a(context, m15998e, m16009a.f36402D, bugly);
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m15569a(Context context, String str, boolean z, BUGLY bugly) {
        byte[] bArr;
        synchronized (C12904p.class) {
            if (f36894e) {
                C12820al.m15873d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C12820al.f36546b, "[init] context is null, check it.");
            } else if (str == null) {
                Log.e(C12820al.f36546b, "init arg 'crashReportAppID' should not be null!");
            } else {
                f36894e = true;
                if (z) {
                    f36892c = true;
                    C12820al.f36547c = true;
                    C12820al.m15873d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    C12820al.m15872e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C12820al.m15873d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    C12820al.m15873d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    C12820al.m15873d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    C12820al.m15873d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    C12820al.m15872e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C12820al.m15876b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                C12820al.m15878a(" crash report start initializing...", new Object[0]);
                C12820al.m15876b("[init] Bugly start initializing...", new Object[0]);
                C12820al.m15878a("[init] Bugly complete version: v%s", "4.1.9.3");
                Context m15844a = C12828ap.m15844a(context);
                C12786aa m16009a = C12786aa.m16009a(m15844a);
                m16009a.m15985o();
                C12824ao.m15862a(m15844a);
                f36893d = C12920w.m15503a(m15844a, f36891b);
                C12814ai.m15905a(m15844a);
                C12803ac.m15949a(m15844a, f36891b);
                C12916u m15521a = C12916u.m15521a(m15844a);
                if (m15568a(m16009a)) {
                    f36890a = false;
                    return;
                }
                m16009a.f36465r = str;
                m16009a.m16003b("APP_ID", str);
                C12820al.m15878a("[param] Set APP ID:%s", str);
                if (bugly != null) {
                    String appVersion = bugly.getAppVersion();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            String substring = appVersion.substring(0, 100);
                            C12820al.m15873d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                            appVersion = substring;
                        }
                        m16009a.f36462o = appVersion;
                        C12820al.m15878a("[param] Set App version: %s", bugly.getAppVersion());
                    }
                    try {
                        if (bugly.isReplaceOldChannel()) {
                            String appChannel = bugly.getAppChannel();
                            if (!TextUtils.isEmpty(appChannel)) {
                                if (appChannel.length() > 100) {
                                    String substring2 = appChannel.substring(0, 100);
                                    C12820al.m15873d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                    appChannel = substring2;
                                }
                                f36893d.m15504a(556, "app_channel", appChannel.getBytes(), false);
                                m16009a.f36466s = appChannel;
                            }
                        } else {
                            Map<String, byte[]> m15507a = f36893d.m15507a(556, (InterfaceC12919v) null);
                            if (m15507a != null && (bArr = m15507a.get("app_channel")) != null) {
                                m16009a.f36466s = new String(bArr);
                            }
                        }
                        C12820al.m15878a("[param] Set App channel: %s", m16009a.f36466s);
                    } catch (Exception e) {
                        if (f36892c) {
                            e.printStackTrace();
                        }
                    }
                    String appPackageName = bugly.getAppPackageName();
                    if (!TextUtils.isEmpty(appPackageName)) {
                        if (appPackageName.length() > 100) {
                            String substring3 = appPackageName.substring(0, 100);
                            C12820al.m15873d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                            appPackageName = substring3;
                        }
                        m16009a.f36450c = appPackageName;
                        C12820al.m15878a("[param] Set App package: %s", bugly.getAppPackageName());
                    }
                    String deviceID = bugly.getDeviceID();
                    if (deviceID != null) {
                        if (deviceID.length() > 100) {
                            String substring4 = deviceID.substring(0, 100);
                            C12820al.m15873d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                            deviceID = substring4;
                        }
                        m16009a.m16008a(deviceID);
                        C12820al.m15878a("[param] Set device ID: %s", deviceID);
                    }
                    String deviceModel = bugly.getDeviceModel();
                    if (deviceModel != null) {
                        m16009a.m16004b(deviceModel);
                        C12820al.m15878a("[param] Set device model: %s", deviceModel);
                    }
                    m16009a.f36453f = bugly.isUploadProcess();
                    C12824ao.f36552b = bugly.isBuglyLogUpload();
                }
                for (int i = 0; i < f36891b.size(); i++) {
                    if (m15521a.m15516b(f36891b.get(i).f36889id)) {
                        f36891b.get(i).init(m15844a, z, bugly);
                    }
                }
                C12912s.m15542a(m15844a, bugly);
                long appReportDelay = bugly != null ? bugly.getAppReportDelay() : 0L;
                final C12803ac m15950a = C12803ac.m15950a();
                m15950a.f36481c.m15885a(new Thread() { // from class: com.tencent.bugly.proguard.ac.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            Map<String, byte[]> m15507a2 = C12920w.m15509a().m15507a(C12803ac.f36477a, (InterfaceC12919v) null);
                            if (m15507a2 != null) {
                                byte[] bArr2 = m15507a2.get(ConstantHelper.LOG_DE);
                                byte[] bArr3 = m15507a2.get("gateway");
                                if (bArr2 != null) {
                                    C12786aa.m16009a(C12803ac.this.f36485h).m15999d(new String(bArr2));
                                }
                                if (bArr3 != null) {
                                    C12786aa.m16009a(C12803ac.this.f36485h).m16001c(new String(bArr3));
                                }
                            }
                            C12803ac.this.f36484g = C12803ac.m15940d();
                            if (C12803ac.this.f36484g != null) {
                                if (C12828ap.m15817b(C12803ac.f36480i) || !C12828ap.m15809d(C12803ac.f36480i)) {
                                    C12803ac.this.f36484g.f36307q = StrategyBean.f36291a;
                                    C12803ac.this.f36484g.f36308r = StrategyBean.f36292b;
                                } else {
                                    C12803ac.this.f36484g.f36307q = C12803ac.f36480i;
                                    C12803ac.this.f36484g.f36308r = C12803ac.f36480i;
                                }
                            }
                        } catch (Throwable th) {
                            if (!C12820al.m15877a(th)) {
                                th.printStackTrace();
                            }
                        }
                        C12803ac c12803ac = C12803ac.this;
                        c12803ac.m15948a(c12803ac.f36484g, false);
                    }
                }, appReportDelay);
                C12820al.m15876b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m15567a(AbstractC12903o abstractC12903o) {
        synchronized (C12904p.class) {
            if (!f36891b.contains(abstractC12903o)) {
                f36891b.add(abstractC12903o);
            }
        }
    }
}
