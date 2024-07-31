package com.kwad.sdk.core.webview.p418b.p420b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.webview.p418b.p421c.C10620a;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import com.kwad.sdk.p435h.p436a.C10772b;
import com.kwad.sdk.utils.C10977a;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11122q;
import java.io.File;

/* renamed from: com.kwad.sdk.core.webview.b.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10619b {
    /* renamed from: a */
    public static synchronized boolean m25278a(Context context, C10772b c10772b) {
        synchronized (C10619b.class) {
            String str = c10772b.aHZ;
            File file = new File(str);
            if (C11122q.m23750L(file)) {
                if (!TextUtils.isEmpty(c10772b.ajL)) {
                    String fileMD5 = C10977a.getFileMD5(file);
                    if (fileMD5 != null && fileMD5.length() > 10) {
                        fileMD5 = fileMD5.substring(0, 10);
                    }
                    if (!C11053bg.isEquals(fileMD5, c10772b.ajL)) {
                        C11122q.m23727aa(file);
                        return false;
                    }
                }
                C10621b.m25266a(c10772b, 2);
                try {
                    C10620a.m25267f(context, str, C10620a.m25277F(context, c10772b.aHY));
                    C11122q.m23727aa(file);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    C10621b.m25265a(c10772b, 0, 2, e.getMessage());
                    return false;
                }
            }
            return false;
        }
    }
}
