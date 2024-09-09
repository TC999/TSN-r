package com.bytedance.sdk.component.f.c;

import android.util.Base64;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements xv {
    @Override // com.bytedance.sdk.component.f.c.xv
    public <T> String c(T t3) {
        return Base64.encodeToString(t3.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.bytedance.sdk.component.f.c.xv
    public <T> T w(T t3) {
        return (T) new String(Base64.decode(t3.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }
}
