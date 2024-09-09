package com.kwad.sdk.core.webview.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.q;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.h.a.b bVar) {
        synchronized (b.class) {
            String str = bVar.aHZ;
            File file = new File(str);
            if (q.L(file)) {
                if (!TextUtils.isEmpty(bVar.ajL)) {
                    String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                    if (fileMD5 != null && fileMD5.length() > 10) {
                        fileMD5 = fileMD5.substring(0, 10);
                    }
                    if (!bg.isEquals(fileMD5, bVar.ajL)) {
                        q.aa(file);
                        return false;
                    }
                }
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 2);
                try {
                    com.kwad.sdk.core.webview.b.c.a.f(context, str, com.kwad.sdk.core.webview.b.c.a.F(context, bVar.aHY));
                    q.aa(file);
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 2, e4.getMessage());
                    return false;
                }
            }
            return false;
        }
    }
}
