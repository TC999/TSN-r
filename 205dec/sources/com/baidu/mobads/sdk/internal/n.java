package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class n implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f12886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f12886a = mVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bj.a(new o(this, iOAdEvent));
    }
}
