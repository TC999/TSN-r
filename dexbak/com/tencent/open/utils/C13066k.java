package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13010b;
import com.tencent.p558a.p559a.ProGuard;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13066k {

    /* renamed from: a */
    private static ConcurrentHashMap<String, ProGuard> f37441a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static String m15001a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        if (i != 10114) {
            return null;
        }
        return "action_common_channel";
    }

    /* renamed from: a */
    public static void m15002a() {
        f37441a.clear();
    }

    /* renamed from: b */
    public static String m14987b(Context context, String str) {
        String str2 = "";
        SLog.m15123v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String m14947a = C13071m.m14947a(messageDigest.digest());
            messageDigest.reset();
            SLog.m15123v("openSDK_LOG.SystemUtils", "-->sign: " + m14947a);
            messageDigest.update(C13071m.m14919j(packageName + "_" + m14947a + "_" + str + ""));
            str2 = C13071m.m14947a(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            SLog.m15123v("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    /* renamed from: c */
    public static int m14983c(Context context, String str) {
        return m14992a(m14996a(context, "com.tencent.mobileqq"), str);
    }

    /* renamed from: d */
    public static int m14981d(Context context, String str) {
        return m14992a(m14996a(context, Constants.PACKAGE_TIM), str);
    }

    /* renamed from: e */
    private static PackageInfo m14980e(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        synchronized (C13066k.class) {
            if (f37441a.containsKey(str)) {
                ProGuard proGuard = f37441a.get(str);
                if (proGuard == null) {
                    SLog.m15129e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");
                    return null;
                }
                PackageInfo packageInfo = proGuard.f36238b;
                if (packageInfo == null) {
                    SLog.m15129e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");
                }
                return packageInfo;
            }
            PackageInfo m14979f = m14979f(context, str);
            f37441a.put(str, new ProGuard(str, m14979f));
            return m14979f;
        }
    }

    /* renamed from: f */
    private static PackageInfo m14979f(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                SLog.m15129e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + str);
            }
            return packageInfo;
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e);
            return null;
        }
    }

    /* renamed from: g */
    private static boolean m14978g(Context context, String str) {
        return (C13062h.m15020a(context, m14985c(), str) == null && m14980e(context, str) == null) ? false : true;
    }

    /* renamed from: a */
    public static void m14993a(String str) {
        if (str == null) {
            return;
        }
        f37441a.remove(str);
    }

    /* renamed from: a */
    public static String m14996a(Context context, String str) {
        String m15020a = C13062h.m15020a(context, m14985c(), str);
        if (m15020a == null || Constants.APP_VERSION_UNKNOWN.equals(m15020a)) {
            PackageInfo m14980e = m14980e(context, str);
            if (m14980e == null) {
                SLog.m15129e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + str);
                return null;
            }
            return m14980e.versionName;
        }
        return m15020a;
    }

    /* renamed from: c */
    public static boolean m14984c(Context context) {
        if (m14978g(context, "com.tencent.mobileqq")) {
            SLog.m15127i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
            return true;
        } else if (m14978g(context, Constants.PACKAGE_TIM)) {
            SLog.m15127i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
            return true;
        } else if (m14978g(context, Constants.PACKAGE_QQ_PAD)) {
            SLog.m15127i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
            return true;
        } else {
            SLog.m15127i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m14982d(Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !m14990b();
    }

    /* renamed from: a */
    public static int m14992a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null || str2 != null) {
            if (str != null || str2 == null) {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int i = 0;
                while (i < split.length && i < split2.length) {
                    try {
                        int parseInt = Integer.parseInt(split[i]);
                        int parseInt2 = Integer.parseInt(split2[i]);
                        if (parseInt < parseInt2) {
                            return -1;
                        }
                        if (parseInt > parseInt2) {
                            return 1;
                        }
                        i++;
                    } catch (NumberFormatException unused) {
                        return str.compareTo(str2);
                    }
                }
                if (split.length > i) {
                    return 1;
                }
                return split2.length > i ? -1 : 0;
            }
            return -1;
        }
        return 1;
    }

    /* renamed from: c */
    private static String m14985c() {
        String m15184b = C13010b.m15184b();
        if (m15184b == null || m15184b.isEmpty()) {
            SLog.m15129e("openSDK_LOG.SystemUtils", "getAppId error: " + m15184b);
        }
        return m15184b;
    }

    /* renamed from: a */
    public static boolean m14995a(Context context, String str, String str2) {
        SLog.m15123v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (C13071m.m14924g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m14988b(Context context, Intent intent) {
        boolean z = false;
        if (context != null && intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                SLog.m15127i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
                return false;
            }
            String packageName = component.getPackageName();
            String m14996a = m14996a(context, packageName);
            if (m14996a != null && !m14996a.isEmpty()) {
                z = true;
            }
            SLog.m15127i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + packageName + ", appVersionName= " + m14996a);
        }
        return z;
    }

    /* renamed from: a */
    public static String m14999a(Activity activity, String str) {
        if (activity == null) {
            SLog.m15129e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] m15037a = C13057e.m15037a(str);
            if (m15037a == null) {
                SLog.m15129e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(m15037a, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(m15037a, 8, bArr2, 0, 16);
            return C13057e.m15036a(activity.getPackageName(), C13057e.m15035a(bArr2), bArr);
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    /* renamed from: b */
    public static int m14986b(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        return "action_request".equals(str) ? 10100 : -1;
    }

    /* renamed from: a */
    public static boolean m14997a(Context context, Intent intent) {
        if (context != null && intent != null) {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            r1 = (queryIntentActivities == null || queryIntentActivities.size() <= 0) ? false : false;
            if (!r1) {
                StringBuilder sb = new StringBuilder();
                sb.append("isActivityExist false. result=");
                sb.append(queryIntentActivities == null ? "null" : Integer.valueOf(queryIntentActivities.size()));
                sb.append(" Intent= ");
                sb.append(intent);
                SLog.m15129e("openSDK_LOG.SystemUtils", sb.toString());
            }
            return r1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isActivityExist params error! [");
        sb2.append(context == null);
        sb2.append(",");
        sb2.append(intent == null);
        sb2.append("]");
        SLog.m15129e("openSDK_LOG.SystemUtils", sb2.toString());
        return false;
    }

    /* renamed from: b */
    public static boolean m14989b(Context context) {
        boolean m14978g = m14978g(context, "com.tencent.mobileqq");
        SLog.m15127i("openSDK_LOG.SystemUtils", "isQQInstalled " + m14978g);
        return m14978g;
    }

    /* renamed from: b */
    private static boolean m14990b() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static String m14998a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            SLog.m15128e("openSDK_LOG.SystemUtils", "getAppName exception", th);
            try {
                int i = applicationInfo.labelRes;
                return i <= 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
            } catch (Throwable th2) {
                SLog.m15128e("openSDK_LOG.SystemUtils", "getAppName getLabel exception", th2);
                return "";
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m14991a(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->extractSecureLib, libName: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.SystemUtils"
            com.tencent.open.log.SLog.m15127i(r1, r0)
            android.content.Context r0 = com.tencent.open.utils.C13061g.m15027a()
            r2 = 0
            if (r0 != 0) goto L23
            java.lang.String r10 = "-->extractSecureLib, global context is null. "
            com.tencent.open.log.SLog.m15127i(r1, r10)
            return r2
        L23:
            java.lang.String r3 = "secure_lib"
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r2)
            java.io.File r4 = new java.io.File
            java.io.File r5 = r0.getFilesDir()
            r4.<init>(r5, r11)
            boolean r5 = r4.exists()
            r6 = 1
            java.lang.String r7 = "version"
            if (r5 != 0) goto L50
            java.io.File r5 = r4.getParentFile()
            if (r5 == 0) goto L73
            boolean r5 = r5.mkdirs()
            if (r5 == 0) goto L73
            r4.createNewFile()     // Catch: java.io.IOException -> L4b
            goto L73
        L4b:
            r4 = move-exception
            r4.printStackTrace()
            goto L73
        L50:
            int r4 = r3.getInt(r7, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "-->extractSecureLib, libVersion: "
            r5.append(r8)
            r5.append(r12)
            java.lang.String r8 = " | oldVersion: "
            r5.append(r8)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.tencent.open.log.SLog.m15127i(r1, r5)
            if (r12 != r4) goto L73
            return r6
        L73:
            r4 = 0
            android.content.res.AssetManager r5 = r0.getAssets()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La7
            java.io.InputStream r10 = r5.open(r10)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La7
            java.io.FileOutputStream r4 = r0.openFileOutput(r11, r2)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            m14994a(r10, r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            android.content.SharedPreferences$Editor r11 = r3.edit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            r11.putInt(r7, r12)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            r11.commit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            if (r10 == 0) goto L94
            r10.close()     // Catch: java.io.IOException -> L93
            goto L94
        L93:
        L94:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L99
        L99:
            return r6
        L9a:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto Lbc
        L9f:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto La9
        La4:
            r11 = move-exception
            r10 = r4
            goto Lbc
        La7:
            r11 = move-exception
            r10 = r4
        La9:
            java.lang.String r12 = "-->extractSecureLib, when copy lib execption."
            com.tencent.open.log.SLog.m15128e(r1, r12, r11)     // Catch: java.lang.Throwable -> Lbb
            if (r4 == 0) goto Lb5
            r4.close()     // Catch: java.io.IOException -> Lb4
            goto Lb5
        Lb4:
        Lb5:
            if (r10 == 0) goto Lba
            r10.close()     // Catch: java.io.IOException -> Lba
        Lba:
            return r2
        Lbb:
            r11 = move-exception
        Lbc:
            if (r4 == 0) goto Lc3
            r4.close()     // Catch: java.io.IOException -> Lc2
            goto Lc3
        Lc2:
        Lc3:
            if (r10 == 0) goto Lc8
            r10.close()     // Catch: java.io.IOException -> Lc8
        Lc8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.C13066k.m14991a(java.lang.String, java.lang.String, int):boolean");
    }

    /* renamed from: a */
    private static long m14994a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                SLog.m15127i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }

    /* renamed from: a */
    public static String m15000a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(StubApp.getOrigApplicationContext(activity.getApplicationContext()).getPackageName(), 128);
            SLog.m15127i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            SLog.m15128e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
            return null;
        } catch (Exception e2) {
            SLog.m15128e("openSDK_LOG.SystemUtils", "Exception", e2);
            return null;
        }
    }
}
