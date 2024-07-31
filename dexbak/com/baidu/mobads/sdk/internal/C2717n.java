package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2717n implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ C2716m f9100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2717n(C2716m c2716m) {
        this.f9100a = c2716m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        AbstractC2619bg.m50825a(new RunnableC2718o(this, iOAdEvent));
    }
}
