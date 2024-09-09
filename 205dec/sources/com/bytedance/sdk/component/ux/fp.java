package com.bytedance.sdk.component.ux;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

@ATSApi
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface fp<T> {
    @ATSMethod(2)
    void c(int i4, String str, Throwable th);

    @ATSMethod(1)
    void c(k<T> kVar);
}
