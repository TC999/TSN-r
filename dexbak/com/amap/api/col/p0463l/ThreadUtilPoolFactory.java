package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.BasicThreadFactory;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.amap.api.col.3l.z2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ThreadUtilPoolFactory {
    /* renamed from: a */
    public static ThreadPool m53337a(int i, BlockingQueue<Runnable> blockingQueue, String str) {
        return ThreadPool.m53397i(new BasicThreadFactory.C1988b().m53512a().m53511b(i).m53508e(blockingQueue).m53510c(str).m53505h());
    }

    /* renamed from: b */
    public static ThreadPool m53336b(String str) {
        return ThreadPool.m53397i(new BasicThreadFactory.C1988b().m53510c(str).m53505h());
    }
}
