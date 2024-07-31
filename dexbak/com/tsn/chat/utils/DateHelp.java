package com.tsn.chat.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tsn.chat.utils.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DateHelp {
    /* renamed from: a */
    public static String m14865a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /* renamed from: b */
    public static String m14864b() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /* renamed from: c */
    public static String m14863c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /* renamed from: d */
    public static String m14862d() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    /* renamed from: e */
    public static String m14861e() {
        return new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date());
    }

    /* renamed from: f */
    public static String m14860f() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
    }

    /* renamed from: g */
    public static void m14859g(String[] strArr) {
        System.out.println(m14863c());
    }
}
