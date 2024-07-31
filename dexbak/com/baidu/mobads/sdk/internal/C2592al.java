package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.C2705f;

/* renamed from: com.baidu.mobads.sdk.internal.al */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2592al implements C2705f.InterfaceC2707b {
    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2707b
    /* renamed from: a */
    public void mo50396a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADStatusChanged();
        }
    }
}
