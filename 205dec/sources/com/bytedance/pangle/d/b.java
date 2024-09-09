package com.bytedance.pangle.d;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f28676a;

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Integer> f28677b;

    static {
        HashMap hashMap = new HashMap();
        f28677b = hashMap;
        hashMap.put("arm64-v8a", 64);
        f28677b.put("armeabi-v7a", 32);
        f28677b.put("armeabi", 32);
        f28677b.put("x86_64", 64);
        f28677b.put("x86", 32);
        f28677b.put("mips64", 64);
        f28677b.put("mips", 32);
        f28676a = c();
    }

    private static Map<String, List<ZipEntry>> a(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && nextElement.getName().startsWith("lib/") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (f28677b.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        ZeusLogger.i("Zeus/so_pangle", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    public static int b() {
        return f28677b.get(a()).intValue();
    }

    private static String c() {
        JSONObject d4 = d();
        String a4 = a(d4);
        return a4 == null ? b(d4) : a4;
    }

    private static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    private static String b(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(a(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = i.a() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            ZeusLogger.errReport("Zeus/so_pangle", "NativeLibHelper inferHostAbiManual failed!", th);
            a(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            a(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                a(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (i.a()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            a(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        a(jSONObject, "defaultABI", str2);
        return str2;
    }

    private static void a(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String substring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(substring)) {
                list.add(zipEntry);
                set.add(substring);
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i4 = 0;
        boolean z3 = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i("Zeus/install_pangle", "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                g.a(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z3 = true;
                continue;
            } catch (IOException e4) {
                if (i4 >= 3) {
                    throw e4;
                }
                i4++;
                continue;
            }
        } while (!z3);
    }

    public static boolean b(File file) {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches()) {
                            try {
                                zipFile2.close();
                                return true;
                            } catch (IOException unused) {
                                ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                        ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                    return false;
                } catch (IOException e4) {
                    e = e4;
                    zipFile = zipFile2;
                    ZeusLogger.errReport("Zeus/so_pangle", "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused4) {
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a() {
        String str = f28676a;
        if (str != null) {
            return str;
        }
        String c4 = c();
        f28676a = c4;
        return c4;
    }

    private static String a(JSONObject jSONObject) {
        if (i.a()) {
            try {
                String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
                ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
                a(jSONObject, "primaryCpuAbi", str);
                if (str != null) {
                    int i4 = 0;
                    if (Build.VERSION.SDK_INT >= 23) {
                        try {
                            i4 = Process.is64Bit() ? 64 : 32;
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i4)));
                        } catch (Exception unused) {
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i4)));
                        }
                    } else {
                        ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiAuto, processMode default=0");
                    }
                    a(jSONObject, "processMode", String.valueOf(i4));
                    if (i4 != 0) {
                        if (f28677b.get(str).intValue() == i4) {
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
                            return str;
                        }
                        return null;
                    }
                    ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
                    return str;
                }
                return null;
            } catch (Exception e4) {
                ZeusLogger.errReport("Zeus/so_pangle", "NativeLibHelper inferHostAbiAuto failed!", e4);
                a(jSONObject, "autoError", "1");
                return null;
            }
        }
        return null;
    }

    public static com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> a(File file) {
        boolean a4;
        HashMap hashMap = new HashMap();
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    hashMap.putAll(a(zipFile2));
                    if (hashMap.isEmpty()) {
                        a4 = true;
                        ZeusLogger.i("Zeus/so_pangle", "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                    } else {
                        a4 = a(hashMap, f28676a);
                        if (a4) {
                            ZeusLogger.i("Zeus/so_pangle", "NativeLibHelper isPluginApkMatchHostAbi [" + a4 + "], " + file);
                        } else {
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper isPluginApkMatchHostAbi [" + a4 + "], " + file);
                        }
                    }
                    com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> eVar = new com.bytedance.pangle.util.e<>(Boolean.valueOf(a4), hashMap);
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                    return eVar;
                } catch (IOException e4) {
                    e = e4;
                    zipFile = zipFile2;
                    ZeusLogger.errReport("Zeus/so_pangle", "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> eVar2 = new com.bytedance.pangle.util.e<>(Boolean.FALSE, hashMap);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    return eVar2;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w("Zeus/so_pangle", "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean a(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0147, code lost:
        if (r1.isEmpty() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014e, code lost:
        if (r17.exists() != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0150, code lost:
        r17.mkdirs();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0153, code lost:
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015b, code lost:
        if (r1.hasNext() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x015d, code lost:
        a(r2, (java.util.zip.ZipEntry) r1.next(), r17);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.File r16, java.io.File r17, java.lang.String r18, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> r19) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.d.b.a(java.io.File, java.io.File, java.lang.String, java.util.Map):void");
    }
}
