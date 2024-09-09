package com.bytedance.sdk.openadsdk.core.gb.w;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ls;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static String f33710c;

    /* renamed from: w  reason: collision with root package name */
    private static String f33711w;
    private static Map<String, Integer> xv = new HashMap();

    static {
        if (xv.c()) {
            f33711w = Build.SUPPORTED_ABIS[0];
        } else {
            f33711w = Build.CPU_ABI;
        }
        xv.put("arm64-v8a", 64);
        xv.put("armeabi-v7a", 32);
        xv.put("armeabi", 32);
        xv.put("x86_64", 64);
        xv.put("x86", 32);
        xv.put("mips64", 64);
        xv.put("mips", 32);
        f33710c = w();
    }

    private static Map<String, List<ZipEntry>> c(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (xv.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        a.xv("NativeLibHelper", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    private static String w() {
        JSONObject xv2 = xv();
        String c4 = c(xv2);
        return c4 == null ? w(xv2) : c4;
    }

    private static JSONObject xv() {
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

    private static String w(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            Context context = ls.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(c(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = xv.c() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            a.xv("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            c(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            c(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiManual, match cpuAbi=" + str);
                c(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (xv.c()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            c(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        c(jSONObject, "defaultABI", str2);
        return str2;
    }

    public static String c() {
        String str = f33710c;
        if (str != null) {
            return str;
        }
        String w3 = w();
        f33710c = w3;
        return w3;
    }

    private static String c(JSONObject jSONObject) {
        if (xv.c()) {
            try {
                String str = (String) c.c(ls.getContext().getApplicationInfo(), "primaryCpuAbi");
                a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=" + str);
                c(jSONObject, "primaryCpuAbi", str);
                if (str != null) {
                    int i4 = 0;
                    if (xv.w()) {
                        try {
                            i4 = Process.is64Bit() ? 64 : 32;
                            a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode=" + i4);
                        } catch (Exception unused) {
                            a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode exception default=" + i4);
                        }
                    } else {
                        a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode default=0");
                    }
                    c(jSONObject, "processMode", "" + i4);
                    if (i4 != 0) {
                        if (xv.get(str).intValue() == i4) {
                            a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto2, sHostAbi=" + str);
                            return str;
                        }
                        return null;
                    }
                    a.sr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto1, sHostAbi=" + str);
                    return str;
                }
                return null;
            } catch (Exception e4) {
                a.xv("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e4);
                c(jSONObject, "autoError", "1");
                return null;
            }
        }
        return null;
    }

    private static void c(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
