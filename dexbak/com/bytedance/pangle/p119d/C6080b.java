package com.bytedance.pangle.p119d;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.C6249e;
import com.bytedance.pangle.util.C6251g;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.FieldUtils;
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
import tv.cjump.jni.DeviceUtils;

/* renamed from: com.bytedance.pangle.d.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6080b {

    /* renamed from: a */
    private static String f21915a;

    /* renamed from: b */
    private static Map<String, Integer> f21916b;

    static {
        HashMap hashMap = new HashMap();
        f21916b = hashMap;
        hashMap.put("arm64-v8a", 64);
        f21916b.put("armeabi-v7a", 32);
        f21916b.put("armeabi", 32);
        f21916b.put("x86_64", 64);
        f21916b.put(DeviceUtils.f47125a, 32);
        f21916b.put("mips64", 64);
        f21916b.put(DeviceUtils.f47126b, 32);
        f21915a = m37236c();
    }

    /* renamed from: a */
    private static Map<String, List<ZipEntry>> m37243a(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && nextElement.getName().startsWith("lib/") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (f21916b.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        ZeusLogger.m37081i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    /* renamed from: b */
    public static int m37239b() {
        return f21916b.get(m37248a()).intValue();
    }

    /* renamed from: c */
    private static String m37236c() {
        JSONObject m37235d = m37235d();
        String m37241a = m37241a(m37235d);
        return m37241a == null ? m37237b(m37235d) : m37241a;
    }

    /* renamed from: d */
    private static JSONObject m37235d() {
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static String m37237b(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(m37243a(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = C6253i.m36887a() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            m37240a(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            m37240a(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                m37240a(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (C6253i.m36887a()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            m37240a(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        m37240a(jSONObject, "defaultABI", str2);
        return str2;
    }

    /* renamed from: a */
    private static void m37244a(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
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

    /* renamed from: a */
    private static void m37242a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i = 0;
        boolean z = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                C6251g.m36898a(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z = true;
                continue;
            } catch (IOException e) {
                if (i >= 3) {
                    throw e;
                }
                i++;
                continue;
            }
        } while (!z);
    }

    /* renamed from: b */
    public static boolean m37238b(File file) {
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
                                ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                        ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                    return false;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
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
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static String m37248a() {
        String str = f21915a;
        if (str != null) {
            return str;
        }
        String m37236c = m37236c();
        f21915a = m37236c;
        return m37236c;
    }

    /* renamed from: a */
    private static String m37241a(JSONObject jSONObject) {
        if (C6253i.m36887a()) {
            try {
                String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
                ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
                m37240a(jSONObject, "primaryCpuAbi", str);
                if (str != null) {
                    int i = 0;
                    if (Build.VERSION.SDK_INT >= 23) {
                        try {
                            i = Process.is64Bit() ? 64 : 32;
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                        } catch (Exception unused) {
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                        }
                    } else {
                        ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
                    }
                    m37240a(jSONObject, "processMode", String.valueOf(i));
                    if (i != 0) {
                        if (f21916b.get(str).intValue() == i) {
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
                            return str;
                        }
                        return null;
                    }
                    ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
                    return str;
                }
                return null;
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e);
                m37240a(jSONObject, "autoError", "1");
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C6249e<Boolean, Map<String, List<ZipEntry>>> m37247a(File file) {
        boolean m37245a;
        HashMap hashMap = new HashMap();
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    hashMap.putAll(m37243a(zipFile2));
                    if (hashMap.isEmpty()) {
                        m37245a = true;
                        ZeusLogger.m37081i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                    } else {
                        m37245a = m37245a(hashMap, f21915a);
                        if (m37245a) {
                            ZeusLogger.m37081i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + m37245a + "], " + file);
                        } else {
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + m37245a + "], " + file);
                        }
                    }
                    C6249e<Boolean, Map<String, List<ZipEntry>>> c6249e = new C6249e<>(Boolean.valueOf(m37245a), hashMap);
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                    return c6249e;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    C6249e<Boolean, Map<String, List<ZipEntry>>> c6249e2 = new C6249e<>(Boolean.FALSE, hashMap);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    return c6249e2;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.m37077w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private static boolean m37245a(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    /* renamed from: a */
    private static void m37240a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
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
        m37242a(r2, (java.util.zip.ZipEntry) r1.next(), r17);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m37246a(java.io.File r16, java.io.File r17, java.lang.String r18, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> r19) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.p119d.C6080b.m37246a(java.io.File, java.io.File, java.lang.String, java.util.Map):void");
    }
}
