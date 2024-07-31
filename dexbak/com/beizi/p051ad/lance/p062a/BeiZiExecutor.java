package com.beizi.p051ad.lance.p062a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.beizi.ad.lance.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiExecutor {

    /* renamed from: a */
    private static final AtomicBoolean f10791a = new AtomicBoolean();

    /* renamed from: b */
    private static volatile BeiZiExecutor f10792b;

    /* renamed from: c */
    private static volatile ThreadPoolExecutor f10793c;

    /* renamed from: d */
    private static volatile ThreadPoolExecutor f10794d;

    /* renamed from: e */
    private static volatile ThreadPoolExecutor f10795e;

    private BeiZiExecutor() {
        if (f10791a.get()) {
            return;
        }
        m49088a();
    }

    /* renamed from: a */
    public static void m49088a() {
        AtomicBoolean atomicBoolean = f10791a;
        if (atomicBoolean.get()) {
            return;
        }
        f10793c = BeiZiThreadPool.m49084a();
        f10794d = BeiZiThreadPool.m49083b();
        f10795e = BeiZiThreadPool.m49082c();
        atomicBoolean.set(true);
    }

    /* renamed from: b */
    public static BeiZiExecutor m49087b() {
        if (f10792b == null) {
            synchronized (BeiZiExecutor.class) {
                if (f10792b == null) {
                    f10792b = new BeiZiExecutor();
                }
            }
        }
        return f10792b;
    }

    /* renamed from: c */
    public ExecutorService m49086c() {
        if (f10793c == null) {
            f10793c = BeiZiThreadPool.m49084a();
        }
        return f10793c;
    }

    /* renamed from: d */
    public ExecutorService m49085d() {
        if (f10795e == null) {
            f10795e = BeiZiThreadPool.m49082c();
        }
        return f10795e;
    }
}
