package com.bytedance.sdk.component.ux;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;

@ATSApi
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface k<T> {
    @ATSMethod(1)
    String c();

    @ATSMethod(9)
    boolean ev();

    @ATSMethod(7)
    int f();

    @ATSMethod(10)
    boolean gd();

    @ATSMethod(12)
    int k();

    @ATSMethod(11)
    r p();

    @ATSMethod(8)
    Map<String, String> r();

    @ATSMethod(5)
    void setResult(T t3);

    @ATSMethod(4)
    T sr();

    @ATSMethod(6)
    int ux();

    @ATSMethod(2)
    String w();

    @ATSMethod(3)
    T xv();
}
