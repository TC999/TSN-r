package com.bytedance.sdk.component.adexpress.sr;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");
        
        private String ux;

        c(String str) {
            this.ux = str;
        }

        public String getType() {
            return this.ux;
        }
    }

    public static c c(String str) {
        c cVar;
        c cVar2 = c.IMAGE;
        if (TextUtils.isEmpty(str)) {
            return cVar2;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path != null) {
                if (path.endsWith(".css")) {
                    cVar = c.CSS;
                } else if (path.endsWith(".js")) {
                    cVar = c.JS;
                } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico") || !path.endsWith(".html")) {
                    return cVar2;
                } else {
                    cVar = c.HTML;
                }
                return cVar;
            }
            return cVar2;
        } catch (Throwable unused) {
            return cVar2;
        }
    }

    public static boolean w(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        String path = parse.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }
}
