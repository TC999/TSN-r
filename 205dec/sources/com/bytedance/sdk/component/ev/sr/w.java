package com.bytedance.sdk.component.ev.sr;

import android.util.Log;
import com.bytedance.sdk.component.ev.sr.xv;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements xv.w {
    @Override // com.bytedance.sdk.component.ev.sr.xv.w
    public void c(String str, String str2) {
        Log.e(a.sr(str), str2);
    }

    @Override // com.bytedance.sdk.component.ev.sr.xv.w
    public void w(String str, String str2) {
        Log.d(a.sr(str), str2);
    }

    @Override // com.bytedance.sdk.component.ev.sr.xv.w
    public void xv(String str, String str2) {
        Log.i(a.sr(str), str2);
    }
}
