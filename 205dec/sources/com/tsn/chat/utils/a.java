package com.tsn.chat.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DateHelp.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String b() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String d() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static String e() {
        return new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date());
    }

    public static String f() {
        return new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(new Date());
    }

    public static void g(String[] strArr) {
        System.out.println(c());
    }
}
