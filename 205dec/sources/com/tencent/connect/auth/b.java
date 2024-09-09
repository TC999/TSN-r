package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f51425a = null;

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f51426d = true;

    /* renamed from: e  reason: collision with root package name */
    private static int f51427e;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, a> f51428b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f51429c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f51430a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.connect.auth.a f51431b;

        /* renamed from: c  reason: collision with root package name */
        public String f51432c;
    }

    public static b a() {
        if (f51425a == null) {
            f51425a = new b();
        }
        return f51425a;
    }

    public static int b() {
        int i4 = f51427e + 1;
        f51427e = i4;
        return i4;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < ceil; i4++) {
            double random = Math.random();
            double d4 = length;
            Double.isNaN(d4);
            stringBuffer.append(charArray[(int) (random * d4)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b4 = b();
        try {
            HashMap<String, a> hashMap = this.f51428b;
            hashMap.put("" + b4, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b4;
    }
}
