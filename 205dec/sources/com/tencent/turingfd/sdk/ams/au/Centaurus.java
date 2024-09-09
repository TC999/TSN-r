package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Centaurus {
    public static String a(String str) {
        int indexOf;
        String[] split = str.split(" ", 3);
        if (split.length > 2 && "rwxp".equals(split[1]) && (indexOf = split[2].indexOf(47)) != -1) {
            String trim = split[2].substring(indexOf).trim();
            if (trim.startsWith("/data/")) {
                return null;
            }
            return split[1] + ";" + trim;
        }
        return null;
    }
}
