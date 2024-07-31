package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.p472db.BatchReportDao;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.mbridge.msdk.foundation.same.report.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MBBatchReportManager {

    /* renamed from: a */
    private static final String f30900a = "b";

    /* renamed from: b */
    private static volatile MBBatchReportManager f30901b;

    /* renamed from: c */
    private Handler f30902c;

    /* renamed from: d */
    private boolean f30903d;

    /* renamed from: e */
    private int f30904e;

    /* renamed from: f */
    private long f30905f;

    /* renamed from: h */
    private BatchReportDao f30907h;

    /* renamed from: i */
    private AtomicInteger f30908i;

    /* renamed from: j */
    private Stack<Long> f30909j;

    /* renamed from: g */
    private String f30906g = RequestUrlUtil.m22248a().f30791a;

    /* renamed from: k */
    private Executor f30910k = Executors.newSingleThreadExecutor();

    private MBBatchReportManager() {
        this.f30903d = false;
        this.f30904e = 30;
        this.f30905f = 5000L;
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b != null) {
            this.f30904e = m23252b.m23396aB();
            this.f30905f = m23252b.m23395aC() * 1000;
            this.f30903d = m23252b.m23394aD() == 1;
        }
        String str = f30900a;
        SameLogTool.m21738a(str, "初始化批量上报： " + this.f30906g + " " + this.f30904e + " " + this.f30905f + " " + this.f30903d);
        if (this.f30903d) {
            this.f30908i = new AtomicInteger(0);
            this.f30909j = new Stack<>();
            this.f30907h = BatchReportDao.getInstance(MBSDKContext.m22865f().m22861j());
            HandlerThread handlerThread = new HandlerThread("mb_batch_report_thread");
            handlerThread.start();
            this.f30902c = new Handler(handlerThread.getLooper()) { // from class: com.mbridge.msdk.foundation.same.report.b.1
                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    Bundle data;
                    int i = message.what;
                    if (i == 1) {
                        Bundle data2 = message.getData();
                        if (MBBatchReportManager.this.f30902c == null || MBBatchReportManager.this.f30907h == null || data2 == null) {
                            return;
                        }
                        MBBatchReportManager.this.f30902c.removeMessages(2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<BatchReportMessage> batchReportMessages = MBBatchReportManager.this.f30907h.getBatchReportMessages(currentTimeMillis);
                        MBBatchReportManager.m22140a(MBBatchReportManager.this, batchReportMessages, currentTimeMillis);
                        MBBatchReportManager.this.f30908i.set(0);
                        String str2 = MBBatchReportManager.f30900a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("超时上报触发了，需要上报的数据： ");
                        sb.append(batchReportMessages != null ? batchReportMessages.size() : 0);
                        SameLogTool.m21738a(str2, sb.toString());
                    } else if (i != 2) {
                        if (i == 3 && (data = message.getData()) != null) {
                            MBBatchReportManager.m22136b(MBBatchReportManager.this, data.getParcelableArrayList("report_message"), data.getLong("last_report_time"));
                        }
                    } else {
                        Bundle data3 = message.getData();
                        if (MBBatchReportManager.this.f30902c == null || MBBatchReportManager.this.f30907h == null || data3 == null) {
                            return;
                        }
                        MBBatchReportManager.this.f30902c.removeMessages(1);
                        long j = data3.getLong("last_report_time");
                        ArrayList<BatchReportMessage> batchReportMessages2 = MBBatchReportManager.this.f30907h.getBatchReportMessages(j);
                        MBBatchReportManager.m22140a(MBBatchReportManager.this, batchReportMessages2, j);
                        String str3 = MBBatchReportManager.f30900a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("队列上报触发了，需要上报的数据： ");
                        sb2.append(batchReportMessages2 != null ? batchReportMessages2.size() : 0);
                        SameLogTool.m21738a(str3, sb2.toString());
                    }
                }
            };
        }
    }

    /* renamed from: a */
    public static synchronized MBBatchReportManager m22142a() {
        MBBatchReportManager mBBatchReportManager;
        synchronized (MBBatchReportManager.class) {
            if (f30901b == null) {
                f30901b = new MBBatchReportManager();
            }
            mBBatchReportManager = f30901b;
        }
        return mBBatchReportManager;
    }

    /* renamed from: b */
    public final void m22138b() {
        Handler handler;
        if (!this.f30903d || (handler = this.f30902c) == null || handler.hasMessages(1)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f30902c.sendMessageDelayed(obtain, 5000L);
    }

    /* renamed from: c */
    public final synchronized boolean m22135c() {
        return this.f30903d;
    }

    /* renamed from: a */
    public final synchronized void m22139a(final String str) {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.b.3
            @Override // java.lang.Runnable
            public final void run() {
                if (MBBatchReportManager.this.f30907h == null || !MBBatchReportManager.this.f30903d) {
                    return;
                }
                String str2 = MBBatchReportManager.f30900a;
                SameLogTool.m21738a(str2, "接收到上报数据： " + str);
                MBBatchReportManager.this.f30907h.addReportMessage(str);
                if (MBBatchReportManager.this.f30902c != null && MBBatchReportManager.this.f30905f > 0 && !MBBatchReportManager.this.f30902c.hasMessages(1)) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    MBBatchReportManager.this.f30902c.sendMessageDelayed(obtain, MBBatchReportManager.this.f30905f);
                }
                if (MBBatchReportManager.this.f30908i.incrementAndGet() < MBBatchReportManager.this.f30904e || MBBatchReportManager.this.f30902c == null) {
                    return;
                }
                Message obtain2 = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putLong("last_report_time", System.currentTimeMillis());
                obtain2.setData(bundle);
                obtain2.what = 2;
                MBBatchReportManager.this.f30902c.sendMessage(obtain2);
                MBBatchReportManager.this.f30908i.set(0);
            }
        };
        if (SDKController.m22827a().m22818d()) {
            Executor executor = this.f30910k;
            if (executor != null) {
                executor.execute(runnable);
            } else {
                runnable.run();
            }
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m22136b(MBBatchReportManager mBBatchReportManager, final ArrayList arrayList, final long j) {
        BatchReportMessage batchReportMessage;
        if (arrayList != null && arrayList.size() > 0) {
            SameLogTool.m21738a(f30900a, "需要上报的数据条数： " + arrayList.size());
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                return;
            }
            CommonRequestParams m22085a = C11385e.m22085a(m22861j);
            m22085a.m22222a("app_id", MBSDKContext.m22865f().m22860k());
            m22085a.m22222a("m_sdk", "msdk");
            m22085a.m22222a("lqswt", String.valueOf(1));
            StringBuilder sb = new StringBuilder();
            Setting m23241g = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
            for (int i = 0; i < arrayList.size(); i++) {
                if (((BatchReportMessage) arrayList.get(i)) != null) {
                    String str = batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp();
                    if (DomainReport.m22149a(m23241g, str)) {
                        sb.append(str);
                        if (i >= 0 && i < arrayList.size() - 1) {
                            sb.append(ShellAdbUtils.f33810d);
                        }
                    }
                }
            }
            try {
                String encode = URLEncoder.encode(sb.toString(), "utf-8");
                m22085a.m22222a("data", encode);
                SameLogTool.m21738a(f30900a, "需要批量上报的数据： " + encode);
                new ReportRequest(MBSDKContext.m22865f().m22861j()).m22227c(0, mBBatchReportManager.f30906g, m22085a, new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.b.2
                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: a */
                    public final void mo20683a(String str2) {
                        SameLogTool.m21738a(MBBatchReportManager.f30900a, "批量上报成功");
                        try {
                            if (MBBatchReportManager.this.f30907h != null) {
                                MBBatchReportManager.this.f30907h.deleteBatchReportMessagesByTimestamp(j);
                            }
                        } catch (Exception e) {
                            SameLogTool.m21733d(MBBatchReportManager.f30900a, e.getMessage());
                        }
                        synchronized (MBBatchReportManager.this.f30909j) {
                            MBBatchReportManager.this.f30909j.clear();
                        }
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: b */
                    public final void mo20682b(String str2) {
                        Stack stack;
                        String str3 = MBBatchReportManager.f30900a;
                        SameLogTool.m21738a(str3, "批量上报失败： " + str2);
                        synchronized (MBBatchReportManager.this.f30909j) {
                            MBBatchReportManager.this.f30909j.add(Long.valueOf(j));
                            if (MBBatchReportManager.this.f30907h != null) {
                                MBBatchReportManager.this.f30907h.updateMessagesReportState(arrayList);
                            }
                            if (MBBatchReportManager.this.f30909j.size() >= 5) {
                                SameLogTool.m21738a(MBBatchReportManager.f30900a, "批量上报失败，上报失败的数据超过阈值");
                                try {
                                    MBBatchReportManager.this.f30909j.pop();
                                    long longValue = ((Long) MBBatchReportManager.this.f30909j.pop()).longValue();
                                    MBBatchReportManager.this.f30909j.clear();
                                    if (MBBatchReportManager.this.f30907h != null) {
                                        MBBatchReportManager.this.f30907h.deleteBatchReportMessagesByTimestamp(longValue);
                                    }
                                    stack = MBBatchReportManager.this.f30909j;
                                } catch (Exception e) {
                                    SameLogTool.m21733d(MBBatchReportManager.f30900a, e.getMessage());
                                    stack = MBBatchReportManager.this.f30909j;
                                }
                                stack.clear();
                            }
                        }
                    }
                });
                return;
            } catch (Exception e) {
                SameLogTool.m21733d(f30900a, e.getMessage());
                return;
            }
        }
        SameLogTool.m21738a(f30900a, "需要上报的数据条数： 0");
    }

    /* renamed from: a */
    static /* synthetic */ void m22140a(MBBatchReportManager mBBatchReportManager, ArrayList arrayList, long j) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("report_message", arrayList);
        bundle.putLong("last_report_time", j);
        obtain.setData(bundle);
        obtain.what = 3;
        mBBatchReportManager.f30902c.sendMessage(obtain);
    }
}
