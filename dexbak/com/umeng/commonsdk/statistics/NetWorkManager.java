package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.TBinaryProtocol;
import com.umeng.analytics.pro.TDeserializer;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalData;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.UMSLUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.IdTracker;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.HeaderHelper;
import com.umeng.commonsdk.statistics.internal.NetworkHelper;
import com.umeng.commonsdk.statistics.internal.OnImprintChangedListener;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import com.umeng.commonsdk.utils.SLModeUtil;
import java.io.File;

/* renamed from: com.umeng.commonsdk.statistics.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NetWorkManager {

    /* renamed from: b */
    private static final int f38929b = 1;

    /* renamed from: c */
    private static final int f38930c = 2;

    /* renamed from: d */
    private static final int f38931d = 3;

    /* renamed from: o */
    private static final String f38932o = "thtstart";

    /* renamed from: p */
    private static final String f38933p = "gkvc";

    /* renamed from: q */
    private static final String f38934q = "ekvc";

    /* renamed from: a */
    String f38935a;

    /* renamed from: f */
    private NetworkHelper f38937f;

    /* renamed from: g */
    private ImprintHandler f38938g;

    /* renamed from: h */
    private IdTracker f38939h;

    /* renamed from: i */
    private ImprintHandler.C13252a f38940i;

    /* renamed from: k */
    private Defcon f38942k;

    /* renamed from: l */
    private long f38943l;

    /* renamed from: m */
    private int f38944m;

    /* renamed from: n */
    private int f38945n;

    /* renamed from: r */
    private Context f38946r;

    /* renamed from: e */
    private final int f38936e = 1;

    /* renamed from: j */
    private ABTest f38941j = null;

    public NetWorkManager(Context context) {
        this.f38939h = null;
        this.f38940i = null;
        this.f38942k = null;
        this.f38943l = 0L;
        this.f38944m = 0;
        this.f38945n = 0;
        this.f38935a = null;
        this.f38946r = context;
        this.f38940i = ImprintHandler.getImprintService(context).m13729c();
        this.f38942k = Defcon.getService(this.f38946r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f38946r);
        this.f38943l = sharedPreferences.getLong(f38932o, 0L);
        this.f38944m = sharedPreferences.getInt(f38933p, 0);
        this.f38945n = sharedPreferences.getInt(f38934q, 0);
        this.f38935a = UMEnvelopeBuild.imprintProperty(this.f38946r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f38946r);
        this.f38938g = imprintService;
        imprintService.m13740a(new OnImprintChangedListener() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.OnImprintChangedListener
            public void onImprintChanged(ImprintHandler.C13252a c13252a) {
                NetWorkManager.this.f38942k.onImprintChanged(c13252a);
                NetWorkManager netWorkManager = NetWorkManager.this;
                netWorkManager.f38935a = UMEnvelopeBuild.imprintProperty(netWorkManager.f38946r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f38946r)) {
            this.f38939h = IdTracker.m13707a(this.f38946r);
        }
        NetworkHelper networkHelper = new NetworkHelper(this.f38946r);
        this.f38937f = networkHelper;
        networkHelper.m13675a(StatTracer.getInstance(this.f38946r));
    }

    /* renamed from: a */
    public boolean m13829a(File file) {
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
            HeaderHelper m13686a = HeaderHelper.m13686a(this.f38946r);
            m13686a.m13680e(name);
            boolean m13685a = m13686a.m13685a(name);
            boolean m13683b = m13686a.m13683b(name);
            boolean m13682c = m13686a.m13682c(name);
            boolean m13681d = m13686a.m13681d(name);
            String m13850d = UMSLUtils.m13850d(name);
            if (!TextUtils.isEmpty(m13850d)) {
                str = UMSLUtils.m13851c(m13850d);
            } else if (m13681d) {
                str = UMServerURL.SILENT_HEART_BEAT;
            } else if (m13682c) {
                str = UMServerURL.ZCFG_PATH;
            } else {
                str = UMServerURL.PATH_ANALYTICS;
            }
            byte[] m13672a = this.f38937f.m13672a(byteArray, m13685a, m13682c, str);
            int m13828a = m13672a == null ? 1 : m13828a(m13672a);
            if (UMConfigure.isDebugLog()) {
                if (m13681d && m13828a == 2) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (m13682c && m13828a == 2) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (m13683b && m13828a == 2) {
                    MLog.m13826d("本次启动数据: 发送成功!");
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (m13685a && m13828a == 2) {
                    MLog.m13826d("普通统计数据: 发送成功!");
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (m13828a == 2) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (m13828a == 2) {
                IdTracker idTracker = this.f38939h;
                if (idTracker != null) {
                    idTracker.m13700e();
                }
                StatTracer.getInstance(this.f38946r).saveSate();
                if (m13681d) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f38946r, "iss", "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            SLModeUtil.m13459a(this.f38946r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            SLModeUtil.m13459a(this.f38946r, 0L);
                            SLModeUtil.m13456d(this.f38946r);
                        }
                    }
                }
            } else if (m13828a == 3) {
                StatTracer.getInstance(this.f38946r).saveSate();
                if (m13682c) {
                    FieldManager.m14036a().m14035a(this.f38946r);
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.f38946r;
                    UMWorkDispatch.sendEvent(context, UMInternalConfig.f38807s, UMInternalData.m13974a(context).m13975a(), null);
                    return true;
                }
            }
            return m13828a == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f38946r, th);
            return false;
        }
    }

    /* renamed from: a */
    private int m13828a(byte[] bArr) {
        Response response = new Response();
        try {
            new TDeserializer(new TBinaryProtocol.C13139a()).m14518a(response, bArr);
            if (response.resp_code == 1) {
                this.f38938g.m13731b(response.getImprint());
                this.f38938g.m13727d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f38946r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
