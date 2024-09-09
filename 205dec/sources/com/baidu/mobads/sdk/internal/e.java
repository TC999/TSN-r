package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f12850a;

    private e() {
    }

    public static e a() {
        if (f12850a == null) {
            synchronized (e.class) {
                if (f12850a == null) {
                    f12850a = new e();
                }
            }
        }
        return f12850a;
    }

    public void a(double d4, an.b bVar) {
        cs a4 = cs.a();
        String c4 = a4.c(x.f13020a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("v", "" + d4);
        hashMap.put("os", "android");
        hashMap.put("tp", a(bn.a((Context) null).d()));
        hashMap.put("bdr", a(bn.a((Context) null).b()));
        an anVar = new an(a4.a(c4, hashMap));
        anVar.a(bVar);
        anVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setReadOnly();
                return new DexClassLoader(str, str2, str3, classLoader);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
