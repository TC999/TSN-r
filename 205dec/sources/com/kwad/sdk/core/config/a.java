package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static final String[] aqs = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean bW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (dh(host)) {
                return true;
            }
            return di(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean dh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : aqs) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean di(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : d.BF()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
