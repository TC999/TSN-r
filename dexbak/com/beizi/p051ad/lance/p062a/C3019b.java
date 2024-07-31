package com.beizi.p051ad.lance.p062a;

import android.util.Base64;

/* compiled from: Base64Util.java */
/* renamed from: com.beizi.ad.lance.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3019b {
    /* renamed from: a */
    public static String m49089a(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
