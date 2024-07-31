package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.C2607aw;
import java.lang.Thread;

/* renamed from: com.baidu.mobads.sdk.internal.be */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class C2617be implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ ThreadFactoryC2616bd f8655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2617be(ThreadFactoryC2616bd threadFactoryC2616bd) {
        this.f8655a = threadFactoryC2616bd;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        C2607aw.AbstractC2608a m50898h = C2607aw.m50898h("ThreadPoolFactory");
        m50898h.mo50869c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
