package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f51256a = true;

    /* renamed from: b  reason: collision with root package name */
    public static List<o> f51257b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f51258c;

    /* renamed from: d  reason: collision with root package name */
    private static w f51259d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f51260e;

    private static boolean a(aa aaVar) {
        List<String> list = aaVar.f50843v;
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (p.class) {
            if (f51260e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(al.f50920b, "[init] context of init() is null, check it.");
            } else {
                aa a4 = aa.a(context);
                if (a(a4)) {
                    f51256a = false;
                    return;
                }
                String e4 = a4.e();
                if (e4 == null) {
                    Log.e(al.f50920b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                } else {
                    a(context, e4, a4.D, buglyStrategy);
                }
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z3, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (p.class) {
            if (f51260e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(al.f50920b, "[init] context is null, check it.");
            } else if (str == null) {
                Log.e(al.f50920b, "init arg 'crashReportAppID' should not be null!");
            } else {
                f51260e = true;
                if (z3) {
                    f51258c = true;
                    al.f50921c = true;
                    al.d("Bugly debug\u6a21\u5f0f\u5f00\u542f\uff0c\u8bf7\u5728\u53d1\u5e03\u65f6\u628aisDebug\u5173\u95ed\u3002 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    al.d("Bugly debug\u6a21\u5f0f\u5c06\u6709\u4ee5\u4e0b\u884c\u4e3a\u7279\u6027 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    al.d("[1] \u8f93\u51fa\u8be6\u7ec6\u7684Bugly SDK\u7684Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    al.d("[2] \u6bcf\u4e00\u6761Crash\u90fd\u4f1a\u88ab\u7acb\u5373\u4e0a\u62a5 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    al.d("[3] \u81ea\u5b9a\u4e49\u65e5\u5fd7\u5c06\u4f1a\u5728Logcat\u4e2d\u8f93\u51fa -- Custom log will be output to logcat.", new Object[0]);
                    al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    al.b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                al.a(" crash report start initializing...", new Object[0]);
                al.b("[init] Bugly start initializing...", new Object[0]);
                al.a("[init] Bugly complete version: v%s", "4.1.9.3");
                Context a4 = ap.a(context);
                aa a5 = aa.a(a4);
                a5.o();
                ao.a(a4);
                f51259d = w.a(a4, f51257b);
                ai.a(a4);
                ac.a(a4, f51257b);
                u a6 = u.a(a4);
                if (a(a5)) {
                    f51256a = false;
                    return;
                }
                a5.f50839r = str;
                a5.b("APP_ID", str);
                al.a("[param] Set APP ID:%s", str);
                if (buglyStrategy != null) {
                    String appVersion = buglyStrategy.getAppVersion();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            String substring = appVersion.substring(0, 100);
                            al.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                            appVersion = substring;
                        }
                        a5.f50836o = appVersion;
                        al.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                    }
                    try {
                        if (buglyStrategy.isReplaceOldChannel()) {
                            String appChannel = buglyStrategy.getAppChannel();
                            if (!TextUtils.isEmpty(appChannel)) {
                                if (appChannel.length() > 100) {
                                    String substring2 = appChannel.substring(0, 100);
                                    al.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                    appChannel = substring2;
                                }
                                f51259d.a(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, "app_channel", appChannel.getBytes(), false);
                                a5.f50840s = appChannel;
                            }
                        } else {
                            Map<String, byte[]> a7 = f51259d.a(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, (v) null);
                            if (a7 != null && (bArr = a7.get("app_channel")) != null) {
                                a5.f50840s = new String(bArr);
                            }
                        }
                        al.a("[param] Set App channel: %s", a5.f50840s);
                    } catch (Exception e4) {
                        if (f51258c) {
                            e4.printStackTrace();
                        }
                    }
                    String appPackageName = buglyStrategy.getAppPackageName();
                    if (!TextUtils.isEmpty(appPackageName)) {
                        if (appPackageName.length() > 100) {
                            String substring3 = appPackageName.substring(0, 100);
                            al.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                            appPackageName = substring3;
                        }
                        a5.f50824c = appPackageName;
                        al.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                    }
                    String deviceID = buglyStrategy.getDeviceID();
                    if (deviceID != null) {
                        if (deviceID.length() > 100) {
                            String substring4 = deviceID.substring(0, 100);
                            al.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                            deviceID = substring4;
                        }
                        a5.a(deviceID);
                        al.a("[param] Set device ID: %s", deviceID);
                    }
                    String deviceModel = buglyStrategy.getDeviceModel();
                    if (deviceModel != null) {
                        a5.b(deviceModel);
                        al.a("[param] Set device model: %s", deviceModel);
                    }
                    a5.f50827f = buglyStrategy.isUploadProcess();
                    ao.f50926b = buglyStrategy.isBuglyLogUpload();
                }
                for (int i4 = 0; i4 < f51257b.size(); i4++) {
                    if (a6.b(f51257b.get(i4).id)) {
                        f51257b.get(i4).init(a4, z3, buglyStrategy);
                    }
                }
                s.a(a4, buglyStrategy);
                long appReportDelay = buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L;
                final ac a8 = ac.a();
                a8.f50855c.a(new Thread() { // from class: com.tencent.bugly.proguard.ac.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            Map<String, byte[]> a9 = w.a().a(ac.f50851a, (v) null);
                            if (a9 != null) {
                                byte[] bArr2 = a9.get("device");
                                byte[] bArr3 = a9.get("gateway");
                                if (bArr2 != null) {
                                    aa.a(ac.this.f50859h).d(new String(bArr2));
                                }
                                if (bArr3 != null) {
                                    aa.a(ac.this.f50859h).c(new String(bArr3));
                                }
                            }
                            ac.this.f50858g = ac.d();
                            if (ac.this.f50858g != null) {
                                if (ap.b(ac.f50854i) || !ap.d(ac.f50854i)) {
                                    ac.this.f50858g.f50757q = StrategyBean.f50741a;
                                    ac.this.f50858g.f50758r = StrategyBean.f50742b;
                                } else {
                                    ac.this.f50858g.f50757q = ac.f50854i;
                                    ac.this.f50858g.f50758r = ac.f50854i;
                                }
                            }
                        } catch (Throwable th) {
                            if (!al.a(th)) {
                                th.printStackTrace();
                            }
                        }
                        ac acVar = ac.this;
                        acVar.a(acVar.f50858g, false);
                    }
                }, appReportDelay);
                al.b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    public static synchronized void a(o oVar) {
        synchronized (p.class) {
            if (!f51257b.contains(oVar)) {
                f51257b.add(oVar);
            }
        }
    }
}
