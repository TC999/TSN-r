package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.tools.x;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MBBatchReportManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39673a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f39674b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f39675c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f39676d;

    /* renamed from: e  reason: collision with root package name */
    private int f39677e;

    /* renamed from: f  reason: collision with root package name */
    private long f39678f;

    /* renamed from: h  reason: collision with root package name */
    private BatchReportDao f39680h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicInteger f39681i;

    /* renamed from: j  reason: collision with root package name */
    private Stack<Long> f39682j;

    /* renamed from: g  reason: collision with root package name */
    private String f39679g = com.mbridge.msdk.foundation.same.net.f.d.a().f39564a;

    /* renamed from: k  reason: collision with root package name */
    private Executor f39683k = Executors.newSingleThreadExecutor();

    private b() {
        this.f39676d = false;
        this.f39677e = 30;
        this.f39678f = 5000L;
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null) {
            this.f39677e = b4.aB();
            this.f39678f = b4.aC() * 1000;
            this.f39676d = b4.aD() == 1;
        }
        String str = f39673a;
        x.a(str, "\u521d\u59cb\u5316\u6279\u91cf\u4e0a\u62a5\uff1a " + this.f39679g + " " + this.f39677e + " " + this.f39678f + " " + this.f39676d);
        if (this.f39676d) {
            this.f39681i = new AtomicInteger(0);
            this.f39682j = new Stack<>();
            this.f39680h = BatchReportDao.getInstance(com.mbridge.msdk.foundation.controller.a.f().j());
            HandlerThread handlerThread = new HandlerThread("mb_batch_report_thread");
            handlerThread.start();
            this.f39675c = new Handler(handlerThread.getLooper()) { // from class: com.mbridge.msdk.foundation.same.report.b.1
                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    Bundle data;
                    int i4 = message.what;
                    if (i4 == 1) {
                        Bundle data2 = message.getData();
                        if (b.this.f39675c == null || b.this.f39680h == null || data2 == null) {
                            return;
                        }
                        b.this.f39675c.removeMessages(2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<BatchReportMessage> batchReportMessages = b.this.f39680h.getBatchReportMessages(currentTimeMillis);
                        b.a(b.this, batchReportMessages, currentTimeMillis);
                        b.this.f39681i.set(0);
                        String str2 = b.f39673a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("\u8d85\u65f6\u4e0a\u62a5\u89e6\u53d1\u4e86\uff0c\u9700\u8981\u4e0a\u62a5\u7684\u6570\u636e\uff1a ");
                        sb.append(batchReportMessages != null ? batchReportMessages.size() : 0);
                        x.a(str2, sb.toString());
                    } else if (i4 != 2) {
                        if (i4 == 3 && (data = message.getData()) != null) {
                            b.b(b.this, data.getParcelableArrayList("report_message"), data.getLong("last_report_time"));
                        }
                    } else {
                        Bundle data3 = message.getData();
                        if (b.this.f39675c == null || b.this.f39680h == null || data3 == null) {
                            return;
                        }
                        b.this.f39675c.removeMessages(1);
                        long j4 = data3.getLong("last_report_time");
                        ArrayList<BatchReportMessage> batchReportMessages2 = b.this.f39680h.getBatchReportMessages(j4);
                        b.a(b.this, batchReportMessages2, j4);
                        String str3 = b.f39673a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("\u961f\u5217\u4e0a\u62a5\u89e6\u53d1\u4e86\uff0c\u9700\u8981\u4e0a\u62a5\u7684\u6570\u636e\uff1a ");
                        sb2.append(batchReportMessages2 != null ? batchReportMessages2.size() : 0);
                        x.a(str3, sb2.toString());
                    }
                }
            };
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f39674b == null) {
                f39674b = new b();
            }
            bVar = f39674b;
        }
        return bVar;
    }

    public final void b() {
        Handler handler;
        if (!this.f39676d || (handler = this.f39675c) == null || handler.hasMessages(1)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f39675c.sendMessageDelayed(obtain, 5000L);
    }

    public final synchronized boolean c() {
        return this.f39676d;
    }

    public final synchronized void a(final String str) {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.b.3
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.f39680h == null || !b.this.f39676d) {
                    return;
                }
                String str2 = b.f39673a;
                x.a(str2, "\u63a5\u6536\u5230\u4e0a\u62a5\u6570\u636e\uff1a " + str);
                b.this.f39680h.addReportMessage(str);
                if (b.this.f39675c != null && b.this.f39678f > 0 && !b.this.f39675c.hasMessages(1)) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    b.this.f39675c.sendMessageDelayed(obtain, b.this.f39678f);
                }
                if (b.this.f39681i.incrementAndGet() < b.this.f39677e || b.this.f39675c == null) {
                    return;
                }
                Message obtain2 = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putLong("last_report_time", System.currentTimeMillis());
                obtain2.setData(bundle);
                obtain2.what = 2;
                b.this.f39675c.sendMessage(obtain2);
                b.this.f39681i.set(0);
            }
        };
        if (com.mbridge.msdk.foundation.controller.b.a().d()) {
            Executor executor = this.f39683k;
            if (executor != null) {
                executor.execute(runnable);
            } else {
                runnable.run();
            }
        } else {
            runnable.run();
        }
    }

    static /* synthetic */ void b(b bVar, final ArrayList arrayList, final long j4) {
        BatchReportMessage batchReportMessage;
        if (arrayList != null && arrayList.size() > 0) {
            x.a(f39673a, "\u9700\u8981\u4e0a\u62a5\u7684\u6570\u636e\u6761\u6570\uff1a " + arrayList.size());
            Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j5 == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.net.g.d a4 = e.a(j5);
            a4.a("app_id", com.mbridge.msdk.foundation.controller.a.f().k());
            a4.a("m_sdk", "msdk");
            a4.a("lqswt", String.valueOf(1));
            StringBuilder sb = new StringBuilder();
            com.mbridge.msdk.c.a g4 = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (((BatchReportMessage) arrayList.get(i4)) != null) {
                    String str = batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp();
                    if (a.a(g4, str)) {
                        sb.append(str);
                        if (i4 >= 0 && i4 < arrayList.size() - 1) {
                            sb.append("\n");
                        }
                    }
                }
            }
            try {
                String encode = URLEncoder.encode(sb.toString(), "utf-8");
                a4.a("data", encode);
                x.a(f39673a, "\u9700\u8981\u6279\u91cf\u4e0a\u62a5\u7684\u6570\u636e\uff1a " + encode);
                new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j()).c(0, bVar.f39679g, a4, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.b.2
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void a(String str2) {
                        x.a(b.f39673a, "\u6279\u91cf\u4e0a\u62a5\u6210\u529f");
                        try {
                            if (b.this.f39680h != null) {
                                b.this.f39680h.deleteBatchReportMessagesByTimestamp(j4);
                            }
                        } catch (Exception e4) {
                            x.d(b.f39673a, e4.getMessage());
                        }
                        synchronized (b.this.f39682j) {
                            b.this.f39682j.clear();
                        }
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void b(String str2) {
                        Stack stack;
                        String str3 = b.f39673a;
                        x.a(str3, "\u6279\u91cf\u4e0a\u62a5\u5931\u8d25\uff1a " + str2);
                        synchronized (b.this.f39682j) {
                            b.this.f39682j.add(Long.valueOf(j4));
                            if (b.this.f39680h != null) {
                                b.this.f39680h.updateMessagesReportState(arrayList);
                            }
                            if (b.this.f39682j.size() >= 5) {
                                x.a(b.f39673a, "\u6279\u91cf\u4e0a\u62a5\u5931\u8d25\uff0c\u4e0a\u62a5\u5931\u8d25\u7684\u6570\u636e\u8d85\u8fc7\u9608\u503c");
                                try {
                                    b.this.f39682j.pop();
                                    long longValue = ((Long) b.this.f39682j.pop()).longValue();
                                    b.this.f39682j.clear();
                                    if (b.this.f39680h != null) {
                                        b.this.f39680h.deleteBatchReportMessagesByTimestamp(longValue);
                                    }
                                    stack = b.this.f39682j;
                                } catch (Exception e4) {
                                    x.d(b.f39673a, e4.getMessage());
                                    stack = b.this.f39682j;
                                }
                                stack.clear();
                            }
                        }
                    }
                });
                return;
            } catch (Exception e4) {
                x.d(f39673a, e4.getMessage());
                return;
            }
        }
        x.a(f39673a, "\u9700\u8981\u4e0a\u62a5\u7684\u6570\u636e\u6761\u6570\uff1a 0");
    }

    static /* synthetic */ void a(b bVar, ArrayList arrayList, long j4) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("report_message", arrayList);
        bundle.putLong("last_report_time", j4);
        obtain.setData(bundle);
        obtain.what = 3;
        bVar.f39675c.sendMessage(obtain);
    }
}
