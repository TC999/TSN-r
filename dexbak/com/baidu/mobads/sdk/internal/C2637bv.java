package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.C2654ch;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.bv */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2637bv implements C2654ch.InterfaceC2655a {

    /* renamed from: a */
    final /* synthetic */ C2636bu f8753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2637bv(C2636bu c2636bu) {
        this.f8753a = c2636bu;
    }

    @Override // com.baidu.mobads.sdk.internal.C2654ch.InterfaceC2655a
    /* renamed from: a */
    public void mo50648a(C2638bw c2638bw) {
        this.f8753a.m50716a(C2640by.f8773k, c2638bw, "download apk successfully, downloader exit");
        C2636bu unused = C2636bu.f8743h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.C2654ch.InterfaceC2655a
    /* renamed from: b */
    public void mo50647b(C2638bw c2638bw) {
        this.f8753a.m50716a(C2640by.f8774l, c2638bw, "downloadApk failed");
    }
}
