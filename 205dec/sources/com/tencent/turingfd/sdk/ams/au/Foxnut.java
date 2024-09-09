package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.tencent.turingfd.sdk.ams.au.Cinterface;
import com.tencent.turingfd.sdk.ams.au.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Foxnut {

    /* renamed from: i  reason: collision with root package name */
    public static final String f52049i = Cextends.a(Cextends.f52253b1);

    /* renamed from: j  reason: collision with root package name */
    public static final String f52050j = Cextends.a(Cextends.f52256c1);

    /* renamed from: k  reason: collision with root package name */
    public static final String f52051k = Cextends.a(Cextends.f52259d1);

    /* renamed from: l  reason: collision with root package name */
    public static final Foxnut f52052l = new Foxnut();

    /* renamed from: m  reason: collision with root package name */
    public static final long f52053m = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f52054n = {0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200};

    /* renamed from: a  reason: collision with root package name */
    public Cumquat f52055a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f52056b;

    /* renamed from: d  reason: collision with root package name */
    public Ginkgo f52058d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52057c = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f52059e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<Date> f52060f = new AtomicReference<>(null);

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Boolean> f52061g = new AtomicReference<>(Boolean.FALSE);

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<FutureTask<Cinterface.Cdo>> f52062h = new AtomicReference<>(null);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Foxnut$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Context f52063a;

        public Cdo(Looper looper, Context context) {
            super(looper);
            this.f52063a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            System.currentTimeMillis();
            int i4 = message.what;
            if (i4 == 1) {
                Foxnut.this.a(this.f52063a, true, 3);
            } else if (i4 != 2) {
            } else {
                Foxnut.this.a(Foxnut.this.a(this.f52063a, true, false, ((Integer) message.obj).intValue()), false);
                synchronized (Foxnut.this.f52061g) {
                    Foxnut.this.f52061g.set(Boolean.FALSE);
                    Foxnut.this.f52061g.notifyAll();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.tencent.turingfd.sdk.ams.au.Foxnut r14) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Foxnut.a(com.tencent.turingfd.sdk.ams.au.Foxnut):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:365:0x09ee, code lost:
        if (android.net.Proxy.getHost(r37) != null) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0a05, code lost:
        if (((r0 == null || !r0.contains("ACCESS_NETWORK_STATE")) ? 0 : 0) != 0) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x029b, code lost:
        if (r37.getPackageManager().getApplicationInfo(r37.getPackageName(), 128).metaData.containsKey(com.tencent.turingfd.sdk.ams.au.Foxnut.f52050j) != false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0646  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0775  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x07f0  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0912 A[LOOP:1: B:332:0x090c->B:334:0x0912, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0979  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x099d  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x09a2  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0a62  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0a6e  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x05d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingfd.sdk.ams.au.Date b(android.content.Context r37, boolean r38, int r39) {
        /*
            Method dump skipped, instructions count: 2684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Foxnut.b(android.content.Context, boolean, int):com.tencent.turingfd.sdk.ams.au.Date");
    }

    public Date a(Context context) {
        Date date;
        Date a4;
        synchronized (this.f52060f) {
            date = this.f52060f.get();
            if (date == null) {
                Ginkgo ginkgo = this.f52058d;
                if (ginkgo != null) {
                    a4 = ginkgo.a(context);
                } else {
                    a4 = Date.a(1);
                }
                date = a4;
                this.f52060f.set(date);
            }
        }
        return date;
    }

    public final void a(Date date, boolean z3) {
        synchronized (this.f52060f) {
            try {
                if (date == null) {
                    return;
                }
                if (z3 || date.f52019c == 0) {
                    this.f52060f.set(date);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this.f52061g) {
            if (this.f52061g.get().booleanValue()) {
                return;
            }
            this.f52061g.set(Boolean.TRUE);
            this.f52056b.sendMessageDelayed(Message.obtain(this.f52056b, 2, 3), 0L);
        }
    }

    public final Date a(Context context, boolean z3, int i4) {
        Date a4;
        Date a5 = a(context);
        if (this.f52055a == null) {
            return Date.a(-10002);
        }
        int a6 = a(a5);
        if (a6 == 1) {
            return a5;
        }
        if (a6 != 2) {
            if (a6 == 3) {
                a();
            }
            return a5;
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
            return Date.a(-10008);
        } else {
            synchronized (this.f52059e) {
                a4 = a(context);
                if (a4 == a5 || a(a4) != 1) {
                    synchronized (this.f52061g) {
                        if (!this.f52061g.get().booleanValue()) {
                            this.f52061g.set(Boolean.TRUE);
                            this.f52056b.post(new Fig(this, context, true, i4));
                        }
                        try {
                            this.f52061g.wait(z3 ? this.f52055a.f52003w : ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                        } catch (InterruptedException unused) {
                        }
                    }
                    a4 = a(context);
                    if (a4 == a5) {
                        a4 = Date.a(-10004);
                    }
                }
            }
            return a4;
        }
    }

    public final int a(Date date) {
        Context context;
        long j4;
        Context context2;
        if (this.f52055a.f51999s || date.f52019c != 0 || TextUtils.isEmpty(date.f52017a)) {
            return 2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= date.f52018b) {
            this.f52055a.getClass();
            return 3;
        }
        Ginkgo ginkgo = this.f52058d;
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        ginkgo.getClass();
        try {
            j4 = Long.valueOf(Ginkgo.b(context, "107")).longValue();
        } catch (Throwable unused) {
            j4 = 0;
        }
        Ginkgo ginkgo2 = this.f52058d;
        synchronized (Ctry.class) {
            context2 = Ctry.f52366a;
        }
        if (Math.abs(currentTimeMillis - ginkgo2.a(context2, "108")) >= j4) {
            this.f52055a.getClass();
            return 3;
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
        if (r20 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f0, code lost:
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r9.longValue()) >= com.tencent.turingfd.sdk.ams.au.Foxnut.f52053m) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f4, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingfd.sdk.ams.au.Date a(android.content.Context r18, boolean r19, boolean r20, int r21) {
        /*
            Method dump skipped, instructions count: 729
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Foxnut.a(android.content.Context, boolean, boolean, int):com.tencent.turingfd.sdk.ams.au.Date");
    }

    public final Date a(Context context, byte[] bArr, int i4) {
        try {
            HashMap hashMap = new HashMap();
            if (Gooseberry.f52078f.a("e_w_t", false)) {
                hashMap.put("2007", "1");
            }
            SparseArray<Object> b89_DEE08458D4E8C7EA = TNative$aa.b89_DEE08458D4E8C7EA(new SparseArray(), bArr, hashMap, i4);
            int b4 = Norma.b(b89_DEE08458D4E8C7EA);
            if (b4 != 0) {
                return Date.a(b4);
            }
            Integer num = (Integer) Norma.a(b89_DEE08458D4E8C7EA, 102, Integer.class);
            if (num == null) {
                return Date.a(-30000);
            }
            if (num.intValue() < 0) {
                return Date.a(num.intValue() - 30000);
            }
            String str = (String) Norma.a(b89_DEE08458D4E8C7EA, 101, String.class);
            int i5 = Cherry.f51967a;
            if (str == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return Date.a(num.intValue() - 10010);
            }
            String str2 = (String) Norma.a(b89_DEE08458D4E8C7EA, 104, String.class);
            if (str2 == null) {
                str2 = "";
            }
            String str3 = (String) Norma.a(b89_DEE08458D4E8C7EA, 105, String.class);
            if (str3 == null) {
                str3 = "";
            }
            String str4 = (String) Norma.a(b89_DEE08458D4E8C7EA, 106, String.class);
            if (str4 == null) {
                str4 = "";
            }
            Integer num2 = (Integer) Norma.a(b89_DEE08458D4E8C7EA, 107, Integer.class);
            String str5 = (String) Norma.a(b89_DEE08458D4E8C7EA, 108, String.class);
            if (str5 == null) {
                str5 = "";
            }
            num2 = (num2 == null || num2.intValue() < 3600) ? 3600 : 3600;
            long currentTimeMillis = (System.currentTimeMillis() / 1000) + num2.intValue();
            Date.Cdo cdo = new Date.Cdo(0);
            cdo.f52027b = currentTimeMillis;
            cdo.f52026a = str;
            cdo.f52029d = str2;
            cdo.f52030e = str3;
            cdo.f52031f = str4;
            cdo.f52032g = str5;
            Date date = new Date(cdo);
            Ginkgo ginkgo = this.f52058d;
            ginkgo.getClass();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("101", date.f52017a);
            hashMap2.put("102", "" + date.f52018b);
            if (!TextUtils.isEmpty(date.f52020d)) {
                hashMap2.put("104", date.f52020d);
            }
            if (!TextUtils.isEmpty(date.f52021e)) {
                hashMap2.put("105", date.f52021e);
            }
            if (!TextUtils.isEmpty(date.f52022f)) {
                hashMap2.put("106", date.f52022f);
            }
            if (!TextUtils.isEmpty(date.f52023g)) {
                hashMap2.put("110", date.f52023g);
            }
            ginkgo.a(context, (Map<String, String>) hashMap2, true);
            Ginkgo ginkgo2 = this.f52058d;
            long intValue = num2.intValue();
            ginkgo2.getClass();
            ginkgo2.a(context, "107", "" + intValue, true);
            ginkgo2.a(context, "108", "" + (System.currentTimeMillis() / 1000), true);
            return date;
        } catch (Throwable unused) {
            return Date.a(-10007);
        }
    }

    public static String a(long j4, long j5) {
        MediaDrm mediaDrm;
        byte[] propertyByteArray;
        try {
            UUID uuid = new UUID(j4, j5);
            mediaDrm = new MediaDrm(uuid);
            try {
                if (mediaDrm.getPropertyByteArray("deviceUniqueId").length == 0) {
                    try {
                        if (Build.VERSION.SDK_INT >= 28) {
                            mediaDrm.close();
                        } else {
                            mediaDrm.release();
                        }
                    } catch (Throwable unused) {
                    }
                    return null;
                }
                String str = uuid + ":" + Cherry.a(propertyByteArray);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        mediaDrm.close();
                    } else {
                        mediaDrm.release();
                    }
                } catch (Throwable unused2) {
                }
                return str;
            } catch (Throwable unused3) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (mediaDrm != null) {
                            mediaDrm.close();
                        }
                    } else if (mediaDrm != null) {
                        mediaDrm.release();
                    }
                } catch (Throwable unused4) {
                }
                return null;
            }
        } catch (Throwable unused5) {
            mediaDrm = null;
        }
    }
}
