package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static r f38408c;

    /* renamed from: d  reason: collision with root package name */
    private static Application f38409d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38413a;

    /* renamed from: e  reason: collision with root package name */
    private String f38414e;

    /* renamed from: f  reason: collision with root package name */
    private static Random f38410f = new Random();

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, s> f38411g = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    private static Map<String, s> f38412h = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f38407b = new ArrayList();

    private r() {
    }

    public static r a(Context context, boolean z3) {
        try {
            if (f38408c == null) {
                f38409d = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
                f38408c = new r();
            }
        } catch (Throwable unused) {
        }
        return f38408c;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(String str) {
        s sVar = f38412h.get(str);
        if (sVar != null) {
            f38411g.remove(sVar.f38419e);
            f38412h.remove(str);
            dn.c(sVar.f38427m);
            Application application = f38409d;
            if (application != null) {
                dn.c(application.getFileStreamPath(sVar.f38417c).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    public s c(String str) {
        try {
            return f38411g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return f38412h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static r a() {
        return f38408c;
    }

    public boolean a(s sVar, boolean z3) {
        this.f38413a = z3;
        this.f38414e = sVar.f38418d;
        return a(sVar);
    }

    public Map<String, s> b() {
        return f38412h;
    }

    private synchronized boolean a(s sVar) {
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.f38419e)) {
                s sVar2 = f38411g.get(sVar.f38419e);
                if (sVar2 != null) {
                    if (sVar2.f38418d.equals(sVar.f38418d)) {
                        return true;
                    }
                    a(sVar2.f38419e);
                }
                try {
                    try {
                        sVar.f38420f = f38409d;
                        if (sVar.f38430p == 1) {
                            if (!TextUtils.isEmpty(sVar.f38417c) && !TextUtils.isEmpty(sVar.f38419e)) {
                                sVar.f38427m = f38409d.getFilesDir().getCanonicalPath() + "/." + sVar.f38415a;
                                String str = sVar.f38427m + "/dex";
                                dn.c(sVar.f38427m + "/lib");
                                String str2 = (sVar.f38427m + "/lib/" + this.f38414e) + TTPathConst.sSeparator + f38410f.nextInt();
                                e(str);
                                dn.a(str, Boolean.FALSE);
                                e(str2);
                                a(sVar, str2, str, false);
                                f38412h.put(sVar.f38417c, sVar);
                                f38411g.put(sVar.f38419e, sVar);
                            } else {
                                throw new RuntimeException("apkPackageName or apkPkgPath is null");
                            }
                        }
                        if (sVar.f38430p != 1 || 0 != 0) {
                            PackageInfo packageInfo = sVar.f38432r;
                            if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                packageInfo = f38409d.getPackageManager().getPackageArchiveInfo(sVar.f38419e, 1);
                            }
                            if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                                if (sVar.f38430p != 1 && sVar.f38416b != 1 && !((Boolean) a(sVar.f38424j, sVar.f38419e).first).booleanValue()) {
                                    return false;
                                }
                                sVar.f38417c = packageInfo.packageName;
                                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                                sVar.f38429o = applicationInfo.className;
                                sVar.f38418d = packageInfo.versionName;
                                sVar.f38426l = packageInfo.activities;
                                sVar.f38431q = applicationInfo.theme;
                                sVar.f38427m = f38409d.getFilesDir().getCanonicalPath() + "/." + sVar.f38415a;
                                String str3 = sVar.f38427m + "/dex";
                                dn.c(sVar.f38427m + "/lib");
                                String str4 = (sVar.f38427m + "/lib/" + this.f38414e) + TTPathConst.sSeparator + f38410f.nextInt();
                                e(str3);
                                dn.a(str3, Boolean.FALSE);
                                e(str4);
                                a(sVar, str4, str3, true);
                                f38412h.put(sVar.f38417c, sVar);
                                f38411g.put(sVar.f38419e, sVar);
                                f38407b.add(Integer.valueOf(sVar.f38415a));
                            } else {
                                throw new Exception("weapon package name check failed");
                            }
                        }
                        return true;
                    } catch (Throwable unused) {
                        return false;
                    }
                } catch (Throwable unused2) {
                    a(sVar.f38419e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (!dn.a(file)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            String a4 = f.a(file);
            if (TextUtils.isEmpty(a4)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            if (!a4.equalsIgnoreCase(str)) {
                return new Pair<>(Boolean.FALSE, a4);
            }
            return new Pair<>(Boolean.TRUE, "");
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public boolean a(String str) {
        s sVar = f38411g.get(str);
        if (sVar != null) {
            f38411g.remove(str);
            f38412h.remove(sVar.f38417c);
            dn.c(sVar.f38427m);
            Application application = f38409d;
            if (application != null) {
                dn.c(application.getFileStreamPath(sVar.f38417c).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:27|(1:198)(9:31|32|33|34|(1:194)(5:36|(2:38|(1:40)(1:192))(1:193)|41|(1:191)(3:43|44|(2:46|(1:51))(1:190))|86)|52|(3:53|54|(1:56)(1:57))|58|59)|60|61|(1:96)(8:66|67|68|69|70|(3:71|72|(3:74|75|76)(1:87))|88|89)|84|85|86|24|25) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:(4:(2:5|(25:9|10|(1:12)|13|(1:15)|16|17|18|19|21|22|23|(10:27|(1:198)(9:31|32|33|34|(1:194)(5:36|(2:38|(1:40)(1:192))(1:193)|41|(1:191)(3:43|44|(2:46|(1:51))(1:190))|86)|52|(3:53|54|(1:56)(1:57))|58|59)|60|61|(1:96)(8:66|67|68|69|70|(3:71|72|(3:74|75|76)(1:87))|88|89)|84|85|86|24|25)|200|201|(1:203)|(1:205)|110|(6:112|113|114|(3:116|117|(1:119)(1:150))|152|(0)(0))(4:154|155|156|(1:158))|120|(1:126)|131|132|133|(2:135|(3:141|38d|145)(1:139))(1:147)))|132|133|(0)(0))|18|19|21|22|23|(2:24|25)|200|201|(0)|(0)|110|(0)(0)|120|(3:122|124|126)|131) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e4, code lost:
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0220, code lost:
        if (r14 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x023b, code lost:
        if (r14 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0256, code lost:
        if (r14 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0258, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a7, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01da, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01db, code lost:
        r13 = r2;
        r5 = null;
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e0, code lost:
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e2, code lost:
        r10 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0375 A[Catch: all -> 0x03f8, TryCatch #13 {all -> 0x03f8, blocks: (B:165:0x0354, B:167:0x0375, B:169:0x037f, B:171:0x0389, B:172:0x038d, B:174:0x03d1, B:173:0x038e), top: B:200:0x0354 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03f8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062 A[Catch: all -> 0x01c9, IOException -> 0x01cd, EOFException -> 0x01d1, FileNotFoundException | ZipException -> 0x01d5, TryCatch #17 {EOFException -> 0x01d1, FileNotFoundException | ZipException -> 0x01d5, IOException -> 0x01cd, all -> 0x01c9, blocks: (B:23:0x005c, B:25:0x0062, B:27:0x0074, B:29:0x007a, B:33:0x0081, B:35:0x0087, B:37:0x008d, B:41:0x0098, B:43:0x00a0, B:45:0x00a8, B:47:0x00ae, B:49:0x00b6, B:82:0x01ab, B:84:0x01b1), top: B:225:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c4  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r20, java.lang.String r21, java.lang.String r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1039
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z3) {
        File file;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.f38419e));
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (name.contains(str4) || ((!TextUtils.isEmpty(str3) && name.contains(str3)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)))))) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            String substring = name.substring(3);
                            sb2.append(substring.replace(".so", str2 + ".so"));
                            String sb3 = sb2.toString();
                            String substring2 = sb3.substring(0, sb3.lastIndexOf(47));
                            hashSet.add(substring2.substring(substring2.lastIndexOf(47) + 1));
                            e(substring2);
                            File file2 = new File(sb3);
                            file2.delete();
                            file2.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(sb3);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    zipInputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream2.close();
                            dn.a(sb3, Boolean.TRUE);
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    try {
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && z3) {
                            String str5 = sVar.f38427m;
                            e(str5);
                            file = new File(str5, sVar.f38415a + "-" + sVar.f38418d + ".dex");
                            try {
                                file.delete();
                                file.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int read2 = zipInputStream.read(bArr);
                                        if (read2 <= 0) {
                                            break;
                                        }
                                        fileOutputStream3.write(bArr, 0, read2);
                                    } catch (Throwable unused2) {
                                        fileOutputStream = fileOutputStream3;
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                        zipInputStream.closeEntry();
                                    }
                                }
                                fileOutputStream3.close();
                                if (sb.length() > 0) {
                                    sb.setLength(0);
                                }
                                sb.append(file.getAbsolutePath());
                                dn.a(sb.toString(), Boolean.TRUE);
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        file = null;
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}