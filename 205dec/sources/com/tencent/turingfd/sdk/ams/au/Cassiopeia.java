package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cassiopeia {
    public static String a(Context context) {
        BufferedReader bufferedReader;
        int i4;
        System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        try {
            String packageName = context.getPackageName();
            Pattern compile = Pattern.compile("^/data/user/\\d+/" + packageName);
            String str = context.getApplicationInfo().nativeLibraryDir;
            bufferedReader = new BufferedReader(new FileReader(Cextends.a(Cextends.f52286n)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String a4 = a(readLine, packageName, compile, str);
                    if (a4 != null) {
                        hashSet.add(a4);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        Ara.a(bufferedReader);
        Pattern[] a5 = UrsaMinor.a();
        Iterator it = hashSet.iterator();
        while (true) {
            i4 = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length = a5.length;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (a5[i4].matcher(str2).find()) {
                    it.remove();
                    break;
                } else {
                    i4++;
                }
            }
        }
        if (hashSet.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                i4++;
                sb.append((String) it2.next());
                if (i4 >= 8) {
                    break;
                } else if (it2.hasNext()) {
                    sb.append("_");
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String a() {
        File[] listFiles;
        try {
            File file = new File("/system/lib");
            if (file.canRead()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getName().contains("rockchip")) {
                        return file2.getAbsolutePath();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(String str, String str2, Pattern pattern, String str3) {
        int indexOf;
        String str4;
        boolean endsWith = str.endsWith(".so");
        boolean z3 = !endsWith && str.endsWith(".jar");
        if ((endsWith || z3) && (indexOf = str.indexOf(47)) != -1) {
            String trim = str.substring(indexOf).trim();
            if (trim.startsWith("/data/")) {
                if (endsWith && str3 != null && trim.startsWith(str3)) {
                    return null;
                }
                String str5 = "/data/data/" + str2 + TTPathConst.sSeparator;
                if (trim.startsWith(str5)) {
                    return null;
                }
                if (trim.startsWith("/data/app/" + str2) || pattern.matcher(trim).find()) {
                    return null;
                }
                if (endsWith) {
                    try {
                        str4 = new File(str5 + "lib").getCanonicalPath();
                    } catch (IOException unused) {
                        str4 = null;
                    }
                    if (str4 == null || trim.startsWith(str4)) {
                        return null;
                    }
                }
                return trim;
            }
            return null;
        }
        return null;
    }
}
