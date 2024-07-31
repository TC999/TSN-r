package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.sdk.internal.cj */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2657cj {

    /* renamed from: b */
    public static final String f8821b = "404";

    /* renamed from: c */
    protected final C2634bs f8829c = C2634bs.m50744a();

    /* renamed from: g */
    private Context f8830g;

    /* renamed from: a */
    public static final String f8820a = C2736x.f9304b;

    /* renamed from: f */
    private static C2657cj f8824f = new C2657cj();

    /* renamed from: d */
    public static volatile String f8822d = "";

    /* renamed from: e */
    public static volatile String f8823e = "";

    /* renamed from: h */
    private static AtomicBoolean f8825h = new AtomicBoolean(false);

    /* renamed from: i */
    private static String f8826i = "";

    /* renamed from: j */
    private static AtomicBoolean f8827j = new AtomicBoolean(false);

    /* renamed from: k */
    private static String f8828k = "";

    private C2657cj() {
    }

    /* renamed from: a */
    public static C2657cj m50646a() {
        return f8824f;
    }

    /* renamed from: d */
    private String m50637d() {
        String str = C2658ck.f8835e;
        if (C2658ck.f8834d.equals(str)) {
            try {
                double m50683b = C2640by.m50683b(C2640by.m50705a(this.f8830g));
                return m50683b > Utils.DOUBLE_EPSILON ? String.valueOf(m50683b) : str;
            } catch (Throwable th) {
                this.f8829c.m50738a(th);
                return str;
            }
        }
        return str;
    }

    /* renamed from: b */
    public String m50639b() {
        try {
            if (f8825h.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    f8826i = str;
                }
            }
            return f8826i;
        } catch (Throwable th) {
            this.f8829c.m50738a(th);
            return f8826i;
        }
    }

    /* renamed from: c */
    public String m50638c() {
        try {
            if (f8827j.get()) {
                return f8828k;
            }
            if (!f8825h.get()) {
                m50639b();
            }
            if (f8826i.equalsIgnoreCase("")) {
                f8827j.set(true);
                return "";
            }
            if (f8827j.compareAndSet(false, true)) {
                String m50643a = m50643a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(m50643a)) {
                    f8828k = m50643a;
                }
            }
            return f8828k;
        } catch (Throwable th) {
            this.f8829c.m50738a(th);
            return f8828k;
        }
    }

    /* renamed from: a */
    public void m50645a(Context context) {
        if (this.f8830g == null) {
            this.f8830g = context;
        }
    }

    /* renamed from: a */
    public void m50642a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(UMCommonContent.f37822az, str3);
            hashMap.put("stacktrace", str2);
            m50641a(str, f8821b, hashMap);
        } catch (Exception e) {
            this.f8829c.m50738a(e);
        }
    }

    /* renamed from: a */
    private void m50641a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter(UMCommonContent.f37830bg, "9.332").appendQueryParameter("appsid", m50640a("appsid", new Object[0]));
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("v", "android_" + m50637d() + "_" + C2658ck.f8836f);
            Context context = this.f8830g;
            Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", m50640a("encodedSn", this.f8830g)).appendQueryParameter("cuid", m50640a("encodedCUID", this.f8830g)).appendQueryParameter("os", FaceEnvironment.f8430OS).appendQueryParameter("osv", C2624bk.m50799a(this.f8830g).m50791c()).appendQueryParameter("romn", m50639b()).appendQueryParameter("romv", m50638c());
            Uri.Builder appendQueryParameter4 = appendQueryParameter3.appendQueryParameter("bdr", "" + C2624bk.m50799a(this.f8830g).m50800a());
            appendQueryParameter4.appendQueryParameter("brd", "" + m50644a(C2624bk.m50799a(this.f8830g).m50788e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter(MediationConstant.KEY_REASON, str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f8829c.m50738a(th);
        }
        C2594an c2594an = new C2594an(f8820a, "POST");
        c2594an.m51013a(builder);
        c2594an.m51005b();
    }

    /* renamed from: a */
    private String m50640a(String str, Object... objArr) {
        IXAdContainerFactory m51049c;
        C2580aa m51057a = C2580aa.m51057a();
        if (m51057a == null || (m51049c = m51057a.m51049c()) == null) {
            return "";
        }
        Object remoteParam = m51049c.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    /* renamed from: a */
    private String m50644a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    private String m50643a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f8829c.m50738a(th);
            return str2;
        }
    }
}
