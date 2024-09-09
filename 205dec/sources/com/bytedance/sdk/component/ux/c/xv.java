package com.bytedance.sdk.component.ux.c;

import com.bytedance.sdk.component.gd.sr.sr;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeUnit f30235c = TimeUnit.SECONDS;

    public static ExecutorService c() {
        sr srVar = new sr(1, 2, 30L, f30235c, new LinkedBlockingQueue(), new c("default"));
        srVar.allowCoreThreadTimeOut(true);
        return srVar;
    }
}
