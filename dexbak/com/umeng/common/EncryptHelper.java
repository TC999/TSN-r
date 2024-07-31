package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* renamed from: com.umeng.common.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EncryptHelper {

    /* renamed from: a */
    private static String f38591a = null;

    /* renamed from: b */
    private static final String f38592b = "umeng+";

    /* renamed from: c */
    private static final String f38593c = "ek__id";

    /* renamed from: d */
    private static final String f38594d = "ek_key";

    /* renamed from: e */
    private static String f38595e = "";

    /* renamed from: f */
    private static final String f38596f = PathCenter.m14695b().m14694b(PathCenter.f37695n);

    /* renamed from: g */
    private static String f38597g = "";

    /* renamed from: h */
    private static EncryptHelper f38598h;

    private EncryptHelper() {
    }

    /* renamed from: a */
    public static EncryptHelper m14066a() {
        if (f38598h == null) {
            synchronized (EncryptHelper.class) {
                if (f38598h == null) {
                    f38598h = new EncryptHelper();
                }
            }
        }
        return f38598h;
    }

    /* renamed from: c */
    private String m14062c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < substring.length(); i++) {
                char charAt = substring.charAt(i);
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

    /* renamed from: b */
    public String m14063b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(f38591a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f38591a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f38595e)) {
                return null;
            }
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f38595e.getBytes()));
                try {
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f38597g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    /* renamed from: a */
    public void m14065a(Context context) {
        try {
            if (TextUtils.isEmpty(f38591a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f38593c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f38595e = m14062c(multiProcessSP);
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f38595e);
                }
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f38596f, 0);
                if (sharedPreferences != null) {
                    f38597g = sharedPreferences.getString(f38593c, null);
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f38597g);
                }
                f38591a = m14062c(UMUtils.genId());
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f38591a);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public String m14064a(String str) {
        try {
            return TextUtils.isEmpty(f38591a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f38591a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
