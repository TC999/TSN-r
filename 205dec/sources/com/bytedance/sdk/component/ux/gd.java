package com.bytedance.sdk.component.ux;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

@ATSApi
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface gd {
    @ATSMethod(1)
    boolean c();

    @ATSMethod(8)
    Bitmap.Config ev();

    @ATSMethod(6)
    String f();

    @ATSMethod(7)
    String r();

    @ATSMethod(4)
    int sr();

    @ATSMethod(5)
    ImageView.ScaleType ux();

    @ATSMethod(2)
    String w();

    @ATSMethod(3)
    int xv();
}
