package com.mbridge.msdk.click.p460a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.ReportData;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.ReportErrorDao;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.UriUtil;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.mbridge.msdk.click.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RetryReportControl {

    /* renamed from: a */
    public static String f29974a = "mtg_retry_report=1";

    /* renamed from: b */
    public static int f29975b = 10000;

    /* renamed from: c */
    public static int f29976c = 3;

    /* renamed from: d */
    public static int f29977d = 50;

    /* renamed from: e */
    public static int f29978e = 600000;

    /* renamed from: f */
    public static int f29979f = 0;

    /* renamed from: g */
    public static int f29980g = 1;

    /* renamed from: h */
    public static int f29981h = 2;

    /* renamed from: i */
    public static int f29982i = 3;

    /* renamed from: j */
    public static int f29983j = 4;

    /* renamed from: k */
    public static int f29984k = 5;

    /* renamed from: l */
    private static String f29985l = "RetryReportControl";

    /* renamed from: o */
    private static int f29986o;

    /* renamed from: p */
    private static int f29987p;

    /* renamed from: m */
    private ConcurrentHashMap<String, RetryUrlRecordData> f29988m;

    /* renamed from: n */
    private WaitRetryLruMemoryCache f29989n;

    /* renamed from: q */
    private BroadcastReceiver f29990q;

    /* renamed from: r */
    private final Handler f29991r;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RetryReportControl.java */
    /* renamed from: com.mbridge.msdk.click.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11210a {

        /* renamed from: a */
        private static RetryReportControl f29995a = new RetryReportControl();
    }

    /* compiled from: RetryReportControl.java */
    /* renamed from: com.mbridge.msdk.click.a.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class HandlerC11211b extends Handler {
        public HandlerC11211b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                RetryReportControl.m23164a(RetryReportControl.m23168a());
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                RetryReportControl.m23168a().m23160a((String) obj, RetryUrlRecordData.f29996a);
            }
        }
    }

    private RetryReportControl() {
        this.f29988m = new ConcurrentHashMap<>();
        this.f29989n = new WaitRetryLruMemoryCache(f29977d);
        this.f29991r = new HandlerC11211b(Looper.getMainLooper());
        Setting m23241g = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
        f29976c = m23241g.m23317g();
        f29975b = m23241g.m23308i() * 1000;
        f29978e = m23241g.m23312h() * 1000;
        f29986o = m23241g.m23322f();
        f29987p = m23241g.m23327e();
        try {
            if (this.f29990q == null) {
                this.f29990q = new BroadcastReceiver() { // from class: com.mbridge.msdk.click.a.a.2
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            RetryReportControl.this.f29991r.sendEmptyMessage(2);
                        }
                    }
                };
                Context m22861j = MBSDKContext.m22865f().m22861j();
                if (m22861j != null) {
                    m22861j.registerReceiver(this.f29990q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static RetryReportControl m23168a() {
        return C11210a.f29995a;
    }

    /* renamed from: a */
    private void m23162a(RetryUrlRecordData retryUrlRecordData) {
        String str;
        String str2;
        try {
            CampaignEx m23142f = retryUrlRecordData.m23142f();
            if (m23142f != null) {
                String requestId = m23142f.getRequestId();
                str2 = m23142f.getRequestIdNotice();
                str = requestId;
            } else {
                str = "";
                str2 = str;
            }
            m23165a(MBSDKContext.m22865f().m22861j(), retryUrlRecordData.m23139i().toString(), retryUrlRecordData.m23141g(), str, str2, retryUrlRecordData.m23144d());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private boolean m23157b(int i) {
        return i == f29980g || i == f29981h;
    }

    /* renamed from: a */
    private static void m23165a(Context context, String str, String str2, String str3, String str4, int i) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000105&");
                stringBuffer.append("url=" + URLEncoder.encode(str2, "utf-8") + "&");
                stringBuffer.append("type=" + i + "&");
                if (!TextUtils.isEmpty(CommonConst.f30596s)) {
                    stringBuffer.append("b=" + CommonConst.f30596s + "&");
                }
                if (!TextUtils.isEmpty(CommonConst.f30597t)) {
                    stringBuffer.append("c=" + CommonConst.f30597t + "&");
                }
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid=");
                    stringBuffer.append(str3);
                    stringBuffer.append("&");
                }
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid_n=");
                    stringBuffer.append(str4);
                    stringBuffer.append("&");
                }
                stringBuffer.append("reason=" + URLEncoder.encode(str, "utf-8"));
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m23166a(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m23166a(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new ReportRequest(context).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22063a(str, context), new ReportResponseHandler() { // from class: com.mbridge.msdk.click.a.a.1
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str2) {
                    SameLogTool.m21733d(RetryReportControl.f29985l, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str2) {
                    ReportData reportData = new ReportData();
                    reportData.m22464d(str);
                    reportData.m22471a(System.currentTimeMillis());
                    reportData.m22472a(0);
                    reportData.m22466c("POST");
                    reportData.m22468b(RequestUrlUtil.m22248a().f30791a);
                    ReportErrorDao.m22686a(CommonSDKDBHelper.m22721a(context)).m22685a(reportData);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f29985l, e.getMessage());
        }
    }

    /* renamed from: a */
    private void m23161a(String str) {
        Message obtainMessage = this.f29991r.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.f29991r.sendMessageDelayed(obtainMessage, f29975b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m23160a(String str, int i) {
        String str2;
        WaitRetryLruMemoryCache waitRetryLruMemoryCache = this.f29989n;
        if (waitRetryLruMemoryCache != null) {
            RetryUrlRecordData mo22377b = waitRetryLruMemoryCache.mo22377b(str);
            this.f29989n.mo22380a(str);
            if (mo22377b != null) {
                if (System.currentTimeMillis() <= mo22377b.m23138j() + f29978e) {
                    mo22377b.m23153a(i);
                    this.f29988m.put(str, mo22377b);
                    if (UriUtil.m21948b(str) == 0) {
                        str2 = str + "?" + f29974a;
                    } else {
                        str2 = str + "&" + f29974a;
                    }
                    CommonClickControl.m23127a(MBSDKContext.m22865f().m22861j(), mo22377b.m23142f(), mo22377b.m23143e(), str2, mo22377b.m23154a(), mo22377b.m23149b(), mo22377b.m23144d());
                    return;
                } else if (i != RetryUrlRecordData.f29997b) {
                    m23162a(mo22377b);
                    return;
                } else {
                    return;
                }
            }
            RetryUrlRecordData retryUrlRecordData = this.f29988m.get(str);
            if (retryUrlRecordData == null || System.currentTimeMillis() > retryUrlRecordData.m23138j() + f29978e || retryUrlRecordData.m23140h() >= f29976c || i == RetryUrlRecordData.f29997b) {
                return;
            }
            m23161a(str);
        }
    }

    /* renamed from: a */
    private boolean m23167a(int i) {
        return i == f29983j || i == f29982i;
    }

    /* renamed from: a */
    public final void m23159a(String str, String str2, CampaignEx campaignEx, String str3, boolean z, boolean z2, int i) {
        if (!(m23167a(i) || m23157b(i) || i == f29984k) || TextUtils.isEmpty(str)) {
            return;
        }
        String replace = str.replace("?" + f29974a, "");
        String replace2 = replace.replace("&" + f29974a, "");
        if (this.f29988m == null) {
            this.f29988m = new ConcurrentHashMap<>();
        }
        RetryUrlRecordData remove = this.f29988m.remove(replace2);
        if (remove == null) {
            remove = new RetryUrlRecordData(str, str2);
            remove.m23148b(i);
            remove.m23150a(z);
            remove.m23146b(z2);
            remove.m23152a(campaignEx);
            remove.m23151a(str3);
        } else if (remove.m23145c() != RetryUrlRecordData.f29997b) {
            remove.m23147b(str2);
        }
        if ((m23167a(i) && f29986o != 0) || (m23157b(i) && f29987p != 0) || i == f29984k) {
            if (System.currentTimeMillis() < remove.m23138j() + f29978e) {
                if (this.f29989n == null) {
                    this.f29989n = new WaitRetryLruMemoryCache(f29977d);
                }
                this.f29989n.mo22379a(replace2, remove);
                if (remove.m23145c() == RetryUrlRecordData.f29996a) {
                    if (remove.m23140h() <= f29976c) {
                        m23161a(replace2);
                        return;
                    } else {
                        m23162a(remove);
                        return;
                    }
                }
                return;
            } else if (remove.m23145c() == RetryUrlRecordData.f29996a) {
                m23162a(remove);
                return;
            } else {
                return;
            }
        }
        m23162a(remove);
    }

    /* renamed from: a */
    static /* synthetic */ void m23164a(RetryReportControl retryReportControl) {
        WaitRetryLruMemoryCache waitRetryLruMemoryCache = retryReportControl.f29989n;
        if (waitRetryLruMemoryCache != null) {
            for (String str : waitRetryLruMemoryCache.mo22381a()) {
                retryReportControl.m23160a(str, RetryUrlRecordData.f29997b);
            }
        }
    }
}
