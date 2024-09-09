package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.acse.ottn.f3;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cm {

    /* renamed from: b  reason: collision with root package name */
    public static final String f12640b = "404";

    /* renamed from: c  reason: collision with root package name */
    public static final int f12641c = 843;

    /* renamed from: d  reason: collision with root package name */
    protected final bv f12649d = bv.a();

    /* renamed from: h  reason: collision with root package name */
    private Context f12650h;

    /* renamed from: a  reason: collision with root package name */
    public static final String f12639a = x.f13021b;

    /* renamed from: g  reason: collision with root package name */
    private static cm f12644g = new cm();

    /* renamed from: e  reason: collision with root package name */
    public static volatile String f12642e = "";

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f12643f = "";

    /* renamed from: i  reason: collision with root package name */
    private static AtomicBoolean f12645i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private static String f12646j = "";

    /* renamed from: k  reason: collision with root package name */
    private static AtomicBoolean f12647k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    private static String f12648l = "";

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    interface a {
        void a(String str);
    }

    private cm() {
    }

    public static cm a() {
        return f12644g;
    }

    private String d() {
        String str = cn.f12655e;
        if ("0.0".equals(str)) {
            try {
                double b4 = cb.b(cb.a(this.f12650h));
                return b4 > 0.0d ? String.valueOf(b4) : str;
            } catch (Throwable th) {
                this.f12649d.a(th);
                return str;
            }
        }
        return str;
    }

    public String b() {
        try {
            if (f12645i.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    f12646j = str;
                }
            }
            return f12646j;
        } catch (Throwable th) {
            this.f12649d.a(th);
            return f12646j;
        }
    }

    public String c() {
        try {
            if (f12647k.get()) {
                return f12648l;
            }
            if (!f12645i.get()) {
                b();
            }
            if (f12646j.equalsIgnoreCase("")) {
                f12647k.set(true);
                return "";
            }
            if (f12647k.compareAndSet(false, true)) {
                String a4 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a4)) {
                    f12648l = a4;
                }
            }
            return f12648l;
        } catch (Throwable th) {
            this.f12649d.a(th);
            return f12648l;
        }
    }

    public void a(Context context) {
        if (this.f12650h == null) {
            this.f12650h = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ad", str3);
            hashMap.put("stacktrace", str2);
            a(str, "404", hashMap);
        } catch (Exception e4) {
            this.f12649d.a(e4);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter("subtype", String.valueOf((int) f12641c)).appendQueryParameter("p_ver", "9.35").appendQueryParameter("appsid", a("appsid", new Object[0]));
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("v", "android_" + d() + "_4.1.30");
            Context context = this.f12650h;
            Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.f12650h)).appendQueryParameter("cuid", a("encodedCUID", this.f12650h)).appendQueryParameter("os", "android").appendQueryParameter("osv", bn.a(this.f12650h).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c());
            Uri.Builder appendQueryParameter4 = appendQueryParameter3.appendQueryParameter("bdr", "" + bn.a(this.f12650h).a());
            appendQueryParameter4.appendQueryParameter("brd", "" + a(bn.a(this.f12650h).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f12649d.a(th);
        }
        an anVar = new an(f12639a, "POST");
        anVar.a(builder);
        anVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c4;
        aa a4 = aa.a();
        if (a4 == null || (c4 = a4.c()) == null) {
            return "";
        }
        Object remoteParam = c4.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f12649d.a(th);
            return str2;
        }
    }
}
