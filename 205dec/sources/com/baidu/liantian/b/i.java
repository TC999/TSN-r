package com.baidu.liantian.b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.liantian.core.ApkInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ExceptionUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f12126a = {"java.lang.UnsatisfiedLinkError"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f12127b = {"space left"};

    public static String a(Context context, String str, String str2) {
        char c4;
        ApkInfo d4;
        String[] split;
        try {
            if (str.contains(f12126a[0])) {
                c4 = 1;
            } else {
                c4 = str.contains(f12127b[0]) ? (char) 2 : (char) 0;
            }
            if (c4 != 1) {
                return c4 != 2 ? str : a(context, str);
            }
            String str3 = str + "\r\n{libpath=" + d4.libPath + "}";
            for (String str4 : com.baidu.liantian.core.g.a().d(str2).libPath.split(":")) {
                if (str4.startsWith("/data/data/")) {
                    File file = new File(str4);
                    if (!file.exists()) {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                    } else if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + o.a(file2) + "}\r\n";
                        }
                    } else {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                    }
                }
            }
            return str3;
        } catch (Throwable unused) {
            e.a();
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    private static String a(Context context, String str) {
        File[] listFiles;
        try {
            File filesDir = context.getFilesDir();
            long freeSpace = filesDir.getFreeSpace();
            String str2 = ((str + "\r\nFreeSpace=" + freeSpace) + "  TotalSpace=" + filesDir.getTotalSpace()) + "  UsableSpace=" + filesDir.getUsableSpace();
            JSONArray jSONArray = new JSONArray();
            long j4 = 0;
            for (File file : filesDir.listFiles()) {
                if (file.isDirectory() && file.getName().startsWith(".")) {
                    j4 += a(file, jSONArray);
                }
            }
            return ((str2 + "\r\n") + jSONArray.toString()) + "\r\nAllFileSize=" + j4;
        } catch (Throwable unused) {
            return str;
        }
    }

    private static long a(File file, JSONArray jSONArray) {
        File[] listFiles;
        long length;
        long j4 = 0;
        if (file != null && jSONArray != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2, jSONArray);
                } else if (file2.exists()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("path", file2.getAbsolutePath());
                    jSONObject.put("size", file2.length());
                    jSONArray.put(jSONObject);
                    length = file2.length();
                }
                j4 += length;
            }
        }
        return j4;
    }
}
