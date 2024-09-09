package com.qihoo.jiagu;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class d {
    public static void a(String str) {
        try {
            if (Runtime.getRuntime().exec(str).waitFor() != 0) {
                new StringBuilder("Failed to execute cmd:").append(str);
            }
        } catch (Exception e4) {
        }
    }
}
