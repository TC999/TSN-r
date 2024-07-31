package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;

/* renamed from: com.kwad.sdk.core.config.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10248a {
    private static final String[] aqs = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    /* renamed from: bW */
    public static boolean m26605bW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (m26604dh(host)) {
                return true;
            }
            return m26603di(host);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: dh */
    private static boolean m26604dh(String str) {
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

    /* renamed from: di */
    private static boolean m26603di(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : C10251d.m26588BF()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
