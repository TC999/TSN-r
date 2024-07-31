package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.cu */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2676cu implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ C2674cs f8910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2676cu(C2674cs c2674cs) {
        this.f8910a = c2674cs;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f8910a.m50577h();
        }
    }
}
