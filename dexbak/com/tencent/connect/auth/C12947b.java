package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.auth.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12947b {

    /* renamed from: a */
    public static C12947b f37059a = null;

    /* renamed from: d */
    static final /* synthetic */ boolean f37060d = true;

    /* renamed from: e */
    private static int f37061e;

    /* renamed from: b */
    public HashMap<String, C12948a> f37062b = new HashMap<>();

    /* renamed from: c */
    public final String f37063c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12948a {

        /* renamed from: a */
        public IUiListener f37064a;

        /* renamed from: b */
        public DialogC12937a f37065b;

        /* renamed from: c */
        public String f37066c;
    }

    /* renamed from: a */
    public static C12947b m15397a() {
        if (f37059a == null) {
            f37059a = new C12947b();
        }
        return f37059a;
    }

    /* renamed from: b */
    public static int m15395b() {
        int i = f37061e + 1;
        f37061e = i;
        return i;
    }

    /* renamed from: c */
    public String m15394c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            double random = Math.random();
            double d = length;
            Double.isNaN(d);
            stringBuffer.append(charArray[(int) (random * d)]);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String m15396a(C12948a c12948a) {
        int m15395b = m15395b();
        try {
            HashMap<String, C12948a> hashMap = this.f37062b;
            hashMap.put("" + m15395b, c12948a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + m15395b;
    }
}
