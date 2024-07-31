package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.dc */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2685dc implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ C2684db f8946a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2685dc(C2684db c2684db) {
        this.f8946a = c2684db;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f8946a.m50561c(iOAdEvent.getData());
        }
    }
}
