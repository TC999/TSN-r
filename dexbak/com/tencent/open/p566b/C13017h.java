package com.tencent.open.p566b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.clj.fastble.BleManager;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p565a.C13003f;
import com.tencent.open.utils.C13058f;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13063i;
import com.tencent.open.utils.C13067l;
import com.tencent.open.utils.C13071m;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13017h {

    /* renamed from: a */
    protected static C13017h f37307a;

    /* renamed from: e */
    protected HandlerThread f37311e;

    /* renamed from: f */
    protected Handler f37312f;

    /* renamed from: b */
    protected Random f37308b = new SecureRandom();

    /* renamed from: d */
    protected List<Serializable> f37310d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c */
    protected List<Serializable> f37309c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g */
    protected Executor f37313g = C13067l.m14975b();

    /* renamed from: h */
    protected Executor f37314h = C13067l.m14975b();

    private C13017h() {
        this.f37311e = null;
        if (this.f37311e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f37311e = handlerThread;
            handlerThread.start();
        }
        if (!this.f37311e.isAlive() || this.f37311e.getLooper() == null) {
            return;
        }
        this.f37312f = new Handler(this.f37311e.getLooper()) { // from class: com.tencent.open.b.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    C13017h.this.m15157b();
                } else if (i == 1001) {
                    C13017h.this.m15155d();
                }
                super.handleMessage(message);
            }
        };
    }

    /* renamed from: a */
    public static synchronized C13017h m15165a() {
        C13017h c13017h;
        synchronized (C13017h.class) {
            if (f37307a == null) {
                f37307a = new C13017h();
            }
            c13017h = f37307a;
        }
        return c13017h;
    }

    /* renamed from: b */
    protected void m15157b() {
    }

    /* renamed from: c */
    protected Map<String, String> m15156c() {
        List<Serializable> m15166b = C13016g.m15166b("report_via");
        if (m15166b != null) {
            this.f37310d.addAll(m15166b);
        }
        SLog.m15131d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f37310d.size());
        if (this.f37310d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Serializable> it = this.f37310d.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject();
            C13012c c13012c = (C13012c) it.next();
            for (String str : c13012c.f37303a.keySet()) {
                try {
                    String str2 = c13012c.f37303a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    SLog.m15128e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.m15123v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject2.toString());
            return hashMap;
        } catch (JSONException e2) {
            SLog.m15128e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    /* renamed from: d */
    protected void m15155d() {
        if (C13071m.m14945b(C13061g.m15027a())) {
            this.f37313g.execute(new Runnable() { // from class: com.tencent.open.b.h.3
                /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
                    r18 = r5;
                    r22 = r9;
                    r20 = r14;
                    r7 = true;
                 */
                /* JADX WARN: Removed duplicated region for block: B:64:0x00bf A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 271
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.p566b.C13017h.RunnableC130203.run():void");
                }
            });
        }
    }

    /* renamed from: a */
    public void m15163a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.m15123v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (m15159a("report_via", str) || z) {
            this.f37313g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString(Constants.PARAM_PLATFORM, "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", C13009a.m15198a(C13061g.m15027a()));
                        bundle2.putString("language", C13013d.m15178a());
                        bundle2.putString(UMCommonContent.f37867z, C13013d.m15177a(C13061g.m15027a()));
                        bundle2.putString("apn", C13009a.m15197b(C13061g.m15027a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, C13058f.m15034a().m15029c(C13061g.m15027a()));
                        bundle2.putString(UMCommonContent.f37756M, TimeZone.getDefault().getID());
                        bundle2.putString(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", C13071m.m14934d(C13061g.m15027a(), Constants.PACKAGE_QZONE));
                        bundle2.putString(Constants.PARAM_QQ_VER, C13071m.m14937c(C13061g.m15027a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", C13071m.m14931e(C13061g.m15027a(), C13061g.m15024b()));
                        bundle2.putString("packagename", C13061g.m15024b());
                        bundle2.putString(Constants.PARAM_APP_VER, C13071m.m14934d(C13061g.m15027a(), C13061g.m15024b()));
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        C13017h.this.f37310d.add(new C13012c(bundle2));
                        int size = C13017h.this.f37310d.size();
                        int m15012a = C13063i.m15015a(C13061g.m15027a(), (String) null).m15012a("Agent_ReportTimeInterval");
                        if (m15012a == 0) {
                            m15012a = BleManager.f22896l;
                        }
                        if (!C13017h.this.m15162a("report_via", size) && !z) {
                            if (C13017h.this.f37312f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            C13017h.this.f37312f.sendMessageDelayed(obtain, m15012a);
                            return;
                        }
                        C13017h.this.m15155d();
                        C13017h.this.f37312f.removeMessages(1001);
                    } catch (Exception e) {
                        SLog.m15128e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m15161a(String str, long j, long j2, long j3, int i) {
        m15160a(str, j, j2, j3, i, "", false);
    }

    /* renamed from: a */
    public void m15160a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        SLog.m15123v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
    }

    /* renamed from: a */
    protected boolean m15159a(String str, String str2) {
        int m15164a;
        SLog.m15131d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 100;
        if (str.equals("report_cgi")) {
            try {
                m15164a = m15164a(Integer.parseInt(str2));
                if (this.f37308b.nextInt(100) < m15164a) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                m15164a = C13015f.m15170a(str2);
                if (this.f37308b.nextInt(100) < m15164a) {
                    i = m15164a;
                    z = true;
                }
            }
            SLog.m15131d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
            return z;
        }
        i = m15164a;
        SLog.m15131d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r0 == 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r0 == 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        r1 = r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean m15162a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.tencent.open.utils.C13061g.m15027a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.C13063i.m15015a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.m15012a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L1c:
            r1 = r0
            goto L38
        L1e:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L37
            android.content.Context r0 = com.tencent.open.utils.C13061g.m15027a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.C13063i.m15015a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.m15012a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L37:
            r1 = 0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " | dataSize: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = " | maxcount: "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.m15131d(r0, r5)
            if (r6 < r1) goto L62
            r5 = 1
            return r5
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.p566b.C13017h.m15162a(java.lang.String, int):boolean");
    }

    /* renamed from: a */
    protected int m15164a(int i) {
        if (i == 0) {
            int m15012a = C13063i.m15015a(C13061g.m15027a(), (String) null).m15012a("Common_CGIReportFrequencySuccess");
            if (m15012a == 0) {
                return 10;
            }
            return m15012a;
        }
        int m15012a2 = C13063i.m15015a(C13061g.m15027a(), (String) null).m15012a("Common_CGIReportFrequencyFailed");
        if (m15012a2 == 0) {
            return 100;
        }
        return m15012a2;
    }

    /* renamed from: a */
    public void m15158a(final String str, final Map<String, String> map) {
        if (C13071m.m14945b(C13061g.m15027a())) {
            C13067l.m14974b(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    try {
                        int m15171a = C13015f.m15171a();
                        if (m15171a == 0) {
                            m15171a = 3;
                        }
                        SLog.m15131d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + m15171a);
                        do {
                            i++;
                            try {
                                int mo15204d = C13003f.m15216a().m15212a(str, map).mo15204d();
                                SLog.m15127i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + mo15204d);
                            } catch (SocketTimeoutException e) {
                                SLog.m15128e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                            } catch (Exception e2) {
                                SLog.m15128e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e2);
                            }
                        } while (i >= m15171a);
                    } catch (Exception e3) {
                        SLog.m15128e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e3);
                    }
                }
            });
        }
    }
}
