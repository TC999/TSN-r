package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class q {
    private static volatile q aws;
    private final Map<String, String> ava = new ConcurrentHashMap();

    private q() {
    }

    public static q DQ() {
        if (aws == null) {
            synchronized (q.class) {
                if (aws == null) {
                    aws = new q();
                }
            }
        }
        return aws;
    }

    public final void U(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.ava.put(str, str2);
    }

    public final String dP(String str) {
        return this.ava.get(str);
    }
}
