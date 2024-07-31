package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.af */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2586af implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ C2585ae f8551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2586af(C2585ae c2585ae) {
        this.f8551a = c2585ae;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f8551a.m51032c(iOAdEvent.getData());
        }
    }
}
