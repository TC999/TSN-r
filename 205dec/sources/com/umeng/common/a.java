package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: EncryptHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f53262a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f53263b = "umeng+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f53264c = "ek__id";

    /* renamed from: d  reason: collision with root package name */
    private static final String f53265d = "ek_key";

    /* renamed from: e  reason: collision with root package name */
    private static String f53266e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final String f53267f = au.b().b("uspi");

    /* renamed from: g  reason: collision with root package name */
    private static String f53268g = "";

    /* renamed from: h  reason: collision with root package name */
    private static a f53269h;

    private a() {
    }

    public static a a() {
        if (f53269h == null) {
            synchronized (a.class) {
                if (f53269h == null) {
                    f53269h = new a();
                }
            }
        }
        return f53269h;
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < substring.length(); i4++) {
                char charAt = substring.charAt(i4);
                if (Character.isDigit(charAt)) {
                    if (Integer.parseInt(Character.toString(charAt)) == 0) {
                        sb.append(0);
                    } else {
                        sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                    }
                } else {
                    sb.append(charAt);
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(f53262a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f53262a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.e("MobclickRT", "--->>> \u5b50\u8fdb\u7a0b\u4e8b\u4ef6\u6570\u636e\u89e3\u5bc6\u5931\u8d25!");
            if (TextUtils.isEmpty(f53266e)) {
                return null;
            }
            UMRTLog.e("MobclickRT", "--->>> \u5b50\u8fdb\u7a0b\u4e8b\u4ef6\u6570\u636e\u89e3\u5bc6\u5931\u8d25\uff0c\u6362\u8001\u79d8\u94a5\u91cd\u8bd5");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f53266e.getBytes()));
                try {
                    UMRTLog.e("MobclickRT", "--->>> \u5b50\u8fdb\u7a0b\u4e8b\u4ef6\u6570\u636e\u89e3\u5bc6\u5931\u8d25\uff0c\u6362\u8001\u79d8\u94a5\u91cd\u8bd5\u6210\u529f\u3002");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e("MobclickRT", "--->>> \u5b50\u8fdb\u7a0b\u4e8b\u4ef6\u6570\u636e\u89e3\u5bc6\u5931\u8d25\uff0c\u6362\u8001\u79d8\u94a5\u91cd\u8bd5\u5931\u8d25\u3002\u6362\u5b50\u8fdb\u7a0b\u5907\u4efdkey\u91cd\u8bd5\u3002");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f53268g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.e("MobclickRT", "--->>> \u5b50\u8fdb\u7a0b\u4e8b\u4ef6\u6570\u636e\u89e3\u5bc6\u5931\u8d25\uff0c\u5b50\u8fdb\u7a0b\u5907\u4efdkey\u91cd\u8bd5\u6210\u529f\u3002");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.e("MobclickRT", "--->>> \u5b50\u8fdb\u7a0b\u4e8b\u4ef6\u6570\u636e\u89e3\u5bc6\u5931\u8d25\uff0c\u5b50\u8fdb\u7a0b\u5907\u4efdkey\u91cd\u8bd5\u5931\u8d25\u3002");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f53262a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, "ek__id");
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f53266e = c(multiProcessSP);
                    UMRTLog.e("MobclickRT", "--->>>> primaryKey: " + f53266e);
                }
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53267f, 0);
                if (sharedPreferences != null) {
                    f53268g = sharedPreferences.getString("ek__id", null);
                    UMRTLog.e("MobclickRT", "--->>> \u5b50\u8fdb\u7a0b\u5907\u4efd\u79d8\u94a5\uff1a\u4e3b\u8fdb\u7a0bkey: " + f53268g);
                }
                f53262a = c(UMUtils.genId());
                UMRTLog.e("MobclickRT", "--->>>> \u6b63\u5f0f\u79d8\u94a5\uff1akey: " + f53262a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f53262a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f53262a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
