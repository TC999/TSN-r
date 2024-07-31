package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.C2594an;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.sdk.internal.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2704e {

    /* renamed from: a */
    private static volatile C2704e f9064a;

    private C2704e() {
    }

    /* renamed from: a */
    public static C2704e m50418a() {
        if (f9064a == null) {
            synchronized (C2704e.class) {
                if (f9064a == null) {
                    f9064a = new C2704e();
                }
            }
        }
        return f9064a;
    }

    /* renamed from: a */
    public void m50417a(double d, C2594an.InterfaceC2596b interfaceC2596b) {
        C2670cp m50608a = C2670cp.m50608a();
        String m50598c = m50608a.m50598c(C2736x.f9261a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("v", "" + d);
        hashMap.put("os", FaceEnvironment.f8430OS);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_REQUEST_TYPE, m50416a(C2624bk.m50799a((Context) null).m50789d()));
        hashMap.put("bdr", m50416a(C2624bk.m50799a((Context) null).m50794b()));
        C2594an c2594an = new C2594an(m50608a.m50605a(m50598c, hashMap));
        c2594an.m51012a(interfaceC2596b);
        c2594an.m51005b();
    }

    /* renamed from: a */
    public String m50416a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public DexClassLoader m50415a(String str, String str2, String str3, ClassLoader classLoader) {
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
