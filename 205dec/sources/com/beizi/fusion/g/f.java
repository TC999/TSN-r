package com.beizi.fusion.g;

import android.util.Base64;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Base64Util.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {
    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
