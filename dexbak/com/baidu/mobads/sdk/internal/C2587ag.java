package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.ag */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2587ag implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ C2585ae f8552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2587ag(C2585ae c2585ae) {
        this.f8552a = c2585ae;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f8552a.m51027x();
        }
    }
}
