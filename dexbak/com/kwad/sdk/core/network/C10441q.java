package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.kwad.sdk.core.network.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10441q {
    private static volatile C10441q aws;
    private final Map<String, String> ava = new ConcurrentHashMap();

    private C10441q() {
    }

    /* renamed from: DQ */
    public static C10441q m26065DQ() {
        if (aws == null) {
            synchronized (C10441q.class) {
                if (aws == null) {
                    aws = new C10441q();
                }
            }
        }
        return aws;
    }

    /* renamed from: U */
    public final void m26064U(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.ava.put(str, str2);
    }

    /* renamed from: dP */
    public final String m26063dP(String str) {
        return this.ava.get(str);
    }
}
