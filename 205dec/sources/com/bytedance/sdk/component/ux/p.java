package com.bytedance.sdk.component.ux;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.concurrent.ExecutorService;

@ATSApi
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface p {
    @ATSMethod(3)
    gd c(ImageView imageView);

    @ATSMethod(2)
    gd c(fp fpVar);

    @ATSMethod(1)
    gd c(fp fpVar, int i4);

    @ATSMethod(10)
    p c(int i4);

    @ATSMethod(9)
    p c(Bitmap.Config config);

    @ATSMethod(8)
    p c(ImageView.ScaleType scaleType);

    @ATSMethod(17)
    p c(ev evVar);

    @ATSMethod(21)
    p c(t tVar);

    @ATSMethod(13)
    p c(u uVar);

    @ATSMethod(6)
    p c(w wVar);

    @ATSMethod(4)
    p c(String str);

    @ATSMethod(16)
    p c(ExecutorService executorService);

    @ATSMethod(14)
    p c(boolean z3);

    @ATSMethod(18)
    p sr(int i4);

    @ATSMethod(19)
    p ux(int i4);

    @ATSMethod(11)
    p w(int i4);

    @ATSMethod(5)
    p w(String str);

    @ATSMethod(15)
    p w(boolean z3);

    @ATSMethod(12)
    p xv(int i4);

    @ATSMethod(7)
    p xv(String str);

    @ATSMethod(20)
    p xv(boolean z3);
}
