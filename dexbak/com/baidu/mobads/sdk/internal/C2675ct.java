package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.ct */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2675ct implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ C2674cs f8909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2675ct(C2674cs c2674cs) {
        this.f8909a = c2674cs;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f8909a.m50581c(iOAdEvent.getData());
        }
    }
}
