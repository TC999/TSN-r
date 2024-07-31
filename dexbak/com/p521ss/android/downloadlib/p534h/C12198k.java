package com.p521ss.android.downloadlib.p534h;

import android.text.TextUtils;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.C12128r;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ss.android.downloadlib.h.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12198k {

    /* renamed from: ok */
    private static Map<String, InterfaceC12199ok> f34476ok = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.ss.android.downloadlib.h.k$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12199ok {
        /* renamed from: ok */
        void mo18763ok();

        /* renamed from: ok */
        void mo18762ok(String str);
    }

    /* renamed from: a */
    public static boolean m18769a(String str) {
        return C12128r.m18961n().mo19530ok(C12128r.getContext(), str);
    }

    /* renamed from: bl */
    private static InterfaceC12199ok m18768bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f34476ok.remove(str);
    }

    /* renamed from: ok */
    public static void m18764ok(String[] strArr, InterfaceC12199ok interfaceC12199ok) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        m18766ok(valueOf, interfaceC12199ok);
        TTDelegateActivity.m19345ok(valueOf, strArr);
    }

    /* renamed from: ok */
    public static void m18767ok(String str) {
        InterfaceC12199ok m18768bl;
        if (TextUtils.isEmpty(str) || (m18768bl = m18768bl(str)) == null) {
            return;
        }
        m18768bl.mo18763ok();
    }

    /* renamed from: ok */
    public static void m18765ok(String str, String str2) {
        InterfaceC12199ok m18768bl;
        if (TextUtils.isEmpty(str) || (m18768bl = m18768bl(str)) == null) {
            return;
        }
        m18768bl.mo18762ok(str2);
    }

    /* renamed from: ok */
    private static void m18766ok(String str, InterfaceC12199ok interfaceC12199ok) {
        if (TextUtils.isEmpty(str) || interfaceC12199ok == null) {
            return;
        }
        f34476ok.put(str, interfaceC12199ok);
    }
}
