package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.cj;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: NetWorkManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final int f53564b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f53565c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f53566d = 3;

    /* renamed from: o  reason: collision with root package name */
    private static final String f53567o = "thtstart";

    /* renamed from: p  reason: collision with root package name */
    private static final String f53568p = "gkvc";

    /* renamed from: q  reason: collision with root package name */
    private static final String f53569q = "ekvc";

    /* renamed from: a  reason: collision with root package name */
    String f53570a;

    /* renamed from: f  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f53572f;

    /* renamed from: g  reason: collision with root package name */
    private ImprintHandler f53573g;

    /* renamed from: h  reason: collision with root package name */
    private e f53574h;

    /* renamed from: i  reason: collision with root package name */
    private ImprintHandler.a f53575i;

    /* renamed from: k  reason: collision with root package name */
    private Defcon f53577k;

    /* renamed from: l  reason: collision with root package name */
    private long f53578l;

    /* renamed from: m  reason: collision with root package name */
    private int f53579m;

    /* renamed from: n  reason: collision with root package name */
    private int f53580n;

    /* renamed from: r  reason: collision with root package name */
    private Context f53581r;

    /* renamed from: e  reason: collision with root package name */
    private final int f53571e = 1;

    /* renamed from: j  reason: collision with root package name */
    private ABTest f53576j = null;

    public c(Context context) {
        this.f53574h = null;
        this.f53575i = null;
        this.f53577k = null;
        this.f53578l = 0L;
        this.f53579m = 0;
        this.f53580n = 0;
        this.f53570a = null;
        this.f53581r = context;
        this.f53575i = ImprintHandler.getImprintService(context).c();
        this.f53577k = Defcon.getService(this.f53581r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f53581r);
        this.f53578l = sharedPreferences.getLong("thtstart", 0L);
        this.f53579m = sharedPreferences.getInt("gkvc", 0);
        this.f53580n = sharedPreferences.getInt("ekvc", 0);
        this.f53570a = UMEnvelopeBuild.imprintProperty(this.f53581r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f53581r);
        this.f53573g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f53577k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f53570a = UMEnvelopeBuild.imprintProperty(cVar.f53581r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f53581r)) {
            this.f53574h = e.a(this.f53581r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.f53581r);
        this.f53572f = cVar;
        cVar.a(StatTracer.getInstance(this.f53581r));
    }

    public boolean a(File file) {
        String str;
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a a4 = com.umeng.commonsdk.statistics.internal.a.a(this.f53581r);
            a4.e(name);
            boolean a5 = a4.a(name);
            boolean b4 = a4.b(name);
            boolean c4 = a4.c(name);
            boolean d4 = a4.d(name);
            String d5 = com.umeng.commonsdk.stateless.d.d(name);
            if (!TextUtils.isEmpty(d5)) {
                str = com.umeng.commonsdk.stateless.d.c(d5);
            } else if (d4) {
                str = UMServerURL.SILENT_HEART_BEAT;
            } else if (c4) {
                str = UMServerURL.ZCFG_PATH;
            } else {
                str = UMServerURL.PATH_ANALYTICS;
            }
            byte[] a6 = this.f53572f.a(byteArray, a5, c4, str);
            int a7 = a6 == null ? 1 : a(a6);
            if (UMConfigure.isDebugLog()) {
                if (d4 && a7 == 2) {
                    UMRTLog.i("MobclickRT", "heart beat req: succeed.");
                } else if (c4 && a7 == 2) {
                    UMRTLog.i("MobclickRT", "Zero req: succeed.");
                } else if (b4 && a7 == 2) {
                    MLog.d("\u672c\u6b21\u542f\u52a8\u6570\u636e: \u53d1\u9001\u6210\u529f!");
                    UMRTLog.i("MobclickRT", "Send instant data: succeed.");
                } else if (a5 && a7 == 2) {
                    MLog.d("\u666e\u901a\u7edf\u8ba1\u6570\u636e: \u53d1\u9001\u6210\u529f!");
                    UMRTLog.i("MobclickRT", "Send analytics data: succeed.");
                } else if (a7 == 2) {
                    UMRTLog.i("MobclickRT", "Inner req: succeed.");
                }
            }
            if (a7 == 2) {
                e eVar = this.f53574h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.f53581r).saveSate();
                if (d4) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f53581r, "iss", "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e("MobclickRT", "--->>> \u66f4\u65b0\u9759\u9ed8\u5fc3\u8df3\u6700\u540e\u4e00\u6b21\u6210\u529f\u8bf7\u6c42\u65f6\u95f4.");
                            com.umeng.commonsdk.utils.c.a(this.f53581r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e("MobclickRT", "--->>> \u9759\u9ed8\u6a21\u5f0f -> \u6b63\u5e38\u6a21\u5f0f\u3002\u91cd\u7f6e last req time");
                            com.umeng.commonsdk.utils.c.a(this.f53581r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.f53581r);
                        }
                    }
                }
            } else if (a7 == 3) {
                StatTracer.getInstance(this.f53581r).saveSate();
                if (c4) {
                    FieldManager.a().a(this.f53581r);
                    UMRTLog.e("MobclickRT", "--->>> \u96f6\u53f7\u62a5\u6587\u5e94\u7b54\u5185\u5bb9\u62a5\u9519!!! \uff0c\u7279\u6b8a\u5904\u7406!\uff0c\u7ee7\u7eed\u6b63\u5e38\u6d41\u7a0b\u3002");
                    Context context = this.f53581r;
                    UMWorkDispatch.sendEvent(context, 32784, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a7 == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f53581r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new bu(new cj.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f53573g.b(response.getImprint());
                this.f53573g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f53581r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
