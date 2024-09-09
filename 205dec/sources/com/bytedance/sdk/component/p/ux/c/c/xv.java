package com.bytedance.sdk.component.p.ux.c.c;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.sdk.component.p.ux.c.c {
    @Override // com.bytedance.sdk.component.p.ux.c.c
    public Object c(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
