package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.az;
import java.lang.Thread;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class bh implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f12473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.f12473a = bgVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        az.a h4 = az.h("ThreadPoolFactory");
        h4.c("\u7ebf\u7a0b\u540d\u5b57=" + thread.getName() + "\u7ebf\u7a0bcrash\u4fe1\u606f", th);
    }
}
