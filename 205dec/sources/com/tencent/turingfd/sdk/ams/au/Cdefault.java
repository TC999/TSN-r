package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.default  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cdefault {

    /* renamed from: a  reason: collision with root package name */
    public static final String f52238a = Cextends.a(Cextends.f52251b);

    /* renamed from: b  reason: collision with root package name */
    public static final String f52239b = Cextends.a(Cextends.f52254c);

    /* renamed from: c  reason: collision with root package name */
    public static final String f52240c = Cextends.a(Cextends.f52257d);

    /* renamed from: d  reason: collision with root package name */
    public static final String f52241d = Cextends.a(Cextends.f52260e);

    /* renamed from: e  reason: collision with root package name */
    public static final String f52242e = Cextends.a(Cextends.f52263f);

    /* renamed from: f  reason: collision with root package name */
    public static long f52243f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f52244g = {"^/data/user/\\d+$", "^/data/data$"};

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.default$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f52245a;

        /* renamed from: b  reason: collision with root package name */
        public final String f52246b;

        public Cdo(boolean z3, String str) {
            this.f52245a = z3;
            this.f52246b = str;
        }
    }

    public static String a(Context context, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        try {
            str2 = context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        try {
            sb.append((String) ((ArrayList) Sculptor.a(new File(str2))).get(0));
        } catch (Throwable unused2) {
            sb.append("");
        }
        sb.append("_");
        long j4 = -1;
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                j4 = file.length();
            }
        }
        sb.append(j4);
        sb.append("_");
        sb.append(Process.myUid());
        return sb.toString();
    }

    public static String b(Context context) {
        Method method;
        try {
            Class<?> cls = Class.forName("android.os.UserManager");
            Field field = context.getClass().getField("USER_SERVICE");
            field.setAccessible(true);
            Object systemService = context.getSystemService((String) field.get(context));
            if (systemService == null || (method = cls.getMethod("getUserName", new Class[0])) == null) {
                return "";
            }
            method.setAccessible(true);
            return (String) method.invoke(systemService, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        try {
            return 999 == Process.myUid() / 100000;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0199, code lost:
        r13 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03fa A[LOOP:0: B:184:0x03f4->B:186:0x03fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01be  */
    /* JADX WARN: Type inference failed for: r0v52, types: [com.tencent.turingfd.sdk.ams.au.default$do] */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.tencent.turingfd.sdk.ams.au.default$do] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:163:0x032f -> B:164:0x0330). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 1061
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cdefault.a(android.content.Context):java.lang.String");
    }
}
