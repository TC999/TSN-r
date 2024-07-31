package com.beizi.fusion.p072g;

import android.util.Base64;

/* compiled from: Base64Util.java */
/* renamed from: com.beizi.fusion.g.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3144f {
    /* renamed from: a */
    public static String m48267a(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
