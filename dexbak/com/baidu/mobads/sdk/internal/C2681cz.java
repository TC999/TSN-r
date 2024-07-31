package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.cz */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2681cz implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ C2680cy f8923a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2681cz(C2680cy c2680cy) {
        this.f8923a = c2680cy;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        AbstractC2619bg.m50825a(new RunnableC2683da(this, iOAdEvent));
    }
}
