package com.bytedance.sdk.component.ux;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.InputStream;

@ATSApi("img_service")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ys {
    @ATSMethod(1)
    p c(String str);

    @ATSMethod(6)
    InputStream c(String str, String str2);

    @ATSMethod(7)
    InputStream c(String str, String str2, String str3);

    @ATSMethod(5)
    void c();

    @ATSMethod(2)
    void c(double d4);

    @ATSMethod(3)
    void w(double d4);

    @ATSMethod(8)
    boolean w(String str, String str2, String str3);

    @ATSMethod(4)
    void xv(double d4);
}
