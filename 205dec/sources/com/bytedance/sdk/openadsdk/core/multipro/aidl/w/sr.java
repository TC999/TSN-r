package com.bytedance.sdk.openadsdk.core.multipro.aidl.w;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.s;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends s.c {

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.gb.c.w.c.w f33939c;

    public sr(com.bytedance.sdk.openadsdk.gb.c.w.c.w wVar) {
        this.f33939c = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public Bundle c(int i4) {
        com.bytedance.sdk.openadsdk.gb.c.w.c.w wVar = this.f33939c;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (wVar != null) {
            wVar.c(i4, new com.bytedance.sdk.openadsdk.fp.c.c.w.c.c() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.w.sr.1
                @Override // com.bytedance.sdk.openadsdk.fp.c.c.w.c.c
                public void c(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        return bundle;
    }
}
