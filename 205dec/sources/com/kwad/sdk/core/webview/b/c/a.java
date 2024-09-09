package com.kwad.sdk.core.webview.b.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static String F(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        return br + File.separator + str;
    }

    public static String G(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        return br + File.separator + str + ".zip";
    }

    public static String H(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        return br + File.separator + str;
    }

    public static String I(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(br);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append("_manifest_.json");
        return sb.toString();
    }

    private static File bq(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return new File("/data/data/" + context.getPackageName() + "/file/");
        }
        return filesDir;
    }

    private static String br(Context context) {
        String str = bq(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File bs(Context context) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        eT(br);
        File file = new File(br, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static String eR(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            com.kwad.sdk.core.e.c.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static String eS(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = null;
            if (pathSegments != null && pathSegments.size() > 0) {
                str2 = pathSegments.get(pathSegments.size() - 1);
            }
            return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable unused) {
            com.kwad.sdk.core.e.c.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    private static boolean eT(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void f(Context context, String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String br = br(context);
            if (!new File(br, name).getAbsolutePath().startsWith(br)) {
                break;
            } else if (nextEntry.isDirectory()) {
                if (!name.contains("../")) {
                    String substring = name.substring(0, name.length() - 1);
                    new File(str2 + File.separator + substring).mkdirs();
                }
            } else {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }
}
