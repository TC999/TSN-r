package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.C13131bm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.UByte;

/* compiled from: AppInfo.java */
/* renamed from: com.amap.api.col.3l.e4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1780e4 {

    /* renamed from: a */
    private static String f3909a = "";

    /* renamed from: b */
    private static String f3910b = "";

    /* renamed from: c */
    private static String f3911c = "";

    /* renamed from: d */
    private static String f3912d = "";

    /* renamed from: e */
    static String f3913e;

    /* renamed from: f */
    static boolean f3914f;

    /* compiled from: AppInfo.java */
    /* renamed from: com.amap.api.col.3l.e4$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1781a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f3915a;

        /* renamed from: b */
        final /* synthetic */ String f3916b;

        C1781a(Context context, String str) {
            this.f3915a = context;
            this.f3916b = str;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(Log.m54106i(this.f3915a, "k.store"));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(C1925p4.m54189o(this.f3916b));
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                try {
                    BasicLogHandler.m54177e(th, "AI", C13131bm.f37926c);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                } catch (Throwable th5) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th5;
                }
            }
        }
    }

    /* renamed from: a */
    public static String m55249a(Context context) {
        try {
            return m55238l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f3912d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m55248b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f3912d = str;
        if (context != null) {
            ThreadPool.m53398h().m55654b(new C1781a(context, str));
        }
    }

    /* renamed from: c */
    public static void m55247c(String str) {
        f3910b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static boolean m55246d() {
        if (f3914f) {
            return true;
        }
        if (m55244f(f3913e)) {
            f3914f = true;
            return true;
        } else if (!TextUtils.isEmpty(f3913e)) {
            f3914f = false;
            f3913e = null;
            return false;
        } else if (m55244f(f3910b)) {
            f3914f = true;
            return true;
        } else {
            if (!TextUtils.isEmpty(f3910b)) {
                f3914f = false;
                f3910b = null;
                return false;
            }
            return true;
        }
    }

    /* renamed from: e */
    public static String m55245e(Context context) {
        try {
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "AI", "gAN");
        }
        if (!"".equals(f3909a)) {
            return f3909a;
        }
        PackageManager packageManager = context.getPackageManager();
        f3909a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f3909a;
    }

    /* renamed from: f */
    private static boolean m55244f(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c : str.toCharArray()) {
            if (('A' > c || c > 'z') && (('0' > c || c > ':') && c != '.')) {
                try {
                    SDKLogHandler.m53864o(C1925p4.m54203a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static String m55243g(Context context) {
        String str;
        try {
            str = f3910b;
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f3910b;
        }
        String packageName = context.getPackageName();
        f3910b = packageName;
        if (!m55244f(packageName)) {
            f3910b = context.getPackageName();
        }
        return f3910b;
    }

    /* renamed from: h */
    public static String m55242h(Context context) {
        try {
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "AI", "gAV");
        }
        if (!"".equals(f3911c)) {
            return f3911c;
        }
        f3911c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f3911c;
        return str == null ? "" : str;
    }

    /* renamed from: i */
    public static String m55241i(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(C1925p4.m54183u("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & UByte.f41242c).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (m55244f(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f3910b)) {
                str = m55243g(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f3913e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "AI", "gsp");
            return f3913e;
        }
    }

    /* renamed from: j */
    public static String m55240j(Context context) {
        try {
            AuthConfigManager.m55057g(context);
        } catch (Throwable unused) {
        }
        try {
            return m55238l(context);
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "AI", "gKy");
            return f3912d;
        }
    }

    /* renamed from: k */
    private static String m55239k(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(Log.m54106i(context, "k.store"));
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String m54197g = C1925p4.m54197g(bArr);
                String str = m54197g.length() == 32 ? m54197g : "";
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return str;
            } catch (Throwable th4) {
                th = th4;
                try {
                    BasicLogHandler.m54177e(th, "AI", "gKe");
                    if (file.exists()) {
                        file.delete();
                    }
                    return "";
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        }
        return "";
    }

    /* renamed from: l */
    private static String m55238l(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f3912d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                String string = bundle.getString("com.amap.api.v2.apikey");
                f3912d = string;
                if (string == null) {
                    f3912d = m55239k(context);
                }
            } else {
                return f3912d;
            }
        }
        return f3912d;
    }
}
