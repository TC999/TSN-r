package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    protected static h f51707a;

    /* renamed from: e  reason: collision with root package name */
    protected HandlerThread f51711e;

    /* renamed from: f  reason: collision with root package name */
    protected Handler f51712f;

    /* renamed from: b  reason: collision with root package name */
    protected Random f51708b = new SecureRandom();

    /* renamed from: d  reason: collision with root package name */
    protected List<Serializable> f51710d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    protected List<Serializable> f51709c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g  reason: collision with root package name */
    protected Executor f51713g = l.b();

    /* renamed from: h  reason: collision with root package name */
    protected Executor f51714h = l.b();

    private h() {
        this.f51711e = null;
        if (this.f51711e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f51711e = handlerThread;
            handlerThread.start();
        }
        if (!this.f51711e.isAlive() || this.f51711e.getLooper() == null) {
            return;
        }
        this.f51712f = new Handler(this.f51711e.getLooper()) { // from class: com.tencent.open.b.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i4 = message.what;
                if (i4 == 1000) {
                    h.this.b();
                } else if (i4 == 1001) {
                    h.this.d();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f51707a == null) {
                f51707a = new h();
            }
            hVar = f51707a;
        }
        return hVar;
    }

    protected void b() {
    }

    protected Map<String, String> c() {
        List<Serializable> b4 = g.b("report_via");
        if (b4 != null) {
            this.f51710d.addAll(b4);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f51710d.size());
        if (this.f51710d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Serializable> it = this.f51710d.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) it.next();
            for (String str : cVar.f51703a.keySet()) {
                try {
                    String str2 = cVar.f51703a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e4) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e4);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject2.toString());
            return hashMap;
        } catch (JSONException e5) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e5);
            return null;
        }
    }

    protected void d() {
        if (m.b(com.tencent.open.utils.g.a())) {
            this.f51713g.execute(new Runnable() { // from class: com.tencent.open.b.h.3
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
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.AnonymousClass3.run():void");
                }
            });
        }
    }

    public void a(final Bundle bundle, String str, final boolean z3) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z3) {
            this.f51713g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", "1000");
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("language", d.a());
                        bundle2.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.g.a()));
                        bundle2.putString("model_name", com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
                        bundle2.putString("timezone", TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", "3.5.13.lite");
                        bundle2.putString("qz_ver", m.d(com.tencent.open.utils.g.a(), "com.qzone"));
                        bundle2.putString("qq_ver", m.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", m.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.g.b());
                        bundle2.putString("app_ver", m.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        h.this.f51710d.add(new c(bundle2));
                        int size = h.this.f51710d.size();
                        int a4 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a4 == 0) {
                            a4 = 10000;
                        }
                        if (!h.this.a("report_via", size) && !z3) {
                            if (h.this.f51712f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            h.this.f51712f.sendMessageDelayed(obtain, a4);
                            return;
                        }
                        h.this.d();
                        h.this.f51712f.removeMessages(1001);
                    } catch (Exception e4) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e4);
                    }
                }
            });
        }
    }

    public void a(String str, long j4, long j5, long j6, int i4) {
        a(str, j4, j5, j6, i4, "", false);
    }

    public void a(String str, long j4, long j5, long j6, int i4, String str2, boolean z3) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j4 + " | reqSize:" + j5 + " | rspSize: " + j6 + " | responseCode: " + i4 + " | detail: " + str2);
    }

    protected boolean a(String str, String str2) {
        int a4;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z3 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i4 = 100;
        if (str.equals("report_cgi")) {
            try {
                a4 = a(Integer.parseInt(str2));
                if (this.f51708b.nextInt(100) < a4) {
                    z3 = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                a4 = f.a(str2);
                if (this.f51708b.nextInt(100) < a4) {
                    i4 = a4;
                    z3 = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z3 + " | frequency: " + i4);
            return z3;
        }
        i4 = a4;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z3 + " | frequency: " + i4);
        return z3;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L1c:
            r1 = r0
            goto L38
        L1e:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L37
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.a(r2)
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
            com.tencent.open.log.SLog.d(r0, r5)
            if (r6 < r1) goto L62
            r5 = 1
            return r5
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.a(java.lang.String, int):boolean");
    }

    protected int a(int i4) {
        if (i4 == 0) {
            int a4 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a4 == 0) {
                return 10;
            }
            return a4;
        }
        int a5 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a5 == 0) {
            return 100;
        }
        return a5;
    }

    public void a(final String str, final Map<String, String> map) {
        if (m.b(com.tencent.open.utils.g.a())) {
            l.b(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    int i4 = 0;
                    try {
                        int a4 = f.a();
                        if (a4 == 0) {
                            a4 = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + a4);
                        do {
                            i4++;
                            try {
                                int d4 = com.tencent.open.a.f.a().a(str, map).d();
                                SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + d4);
                            } catch (SocketTimeoutException e4) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e4);
                            } catch (Exception e5) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e5);
                            }
                        } while (i4 >= a4);
                    } catch (Exception e6) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e6);
                    }
                }
            });
        }
    }
}
