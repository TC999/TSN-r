package com.kwad.sdk.core.webview.p418b.p421c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.kwad.sdk.core.webview.b.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10620a {
    /* renamed from: F */
    public static String m25277F(Context context, String str) {
        String m25272br = m25272br(context);
        if (TextUtils.isEmpty(m25272br)) {
            return null;
        }
        return m25272br + File.separator + str;
    }

    /* renamed from: G */
    public static String m25276G(Context context, String str) {
        String m25272br = m25272br(context);
        if (TextUtils.isEmpty(m25272br)) {
            return null;
        }
        return m25272br + File.separator + str + ".zip";
    }

    /* renamed from: H */
    public static String m25275H(Context context, String str) {
        String m25272br = m25272br(context);
        if (TextUtils.isEmpty(m25272br)) {
            return null;
        }
        return m25272br + File.separator + str;
    }

    /* renamed from: I */
    public static String m25274I(Context context, String str) {
        String m25272br = m25272br(context);
        if (TextUtils.isEmpty(m25272br)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m25272br);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append("_manifest_.json");
        return sb.toString();
    }

    /* renamed from: bq */
    private static File m25273bq(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return new File("/data/data/" + context.getPackageName() + "/file/");
        }
        return filesDir;
    }

    /* renamed from: br */
    private static String m25272br(Context context) {
        String str = m25273bq(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* renamed from: bs */
    public static File m25271bs(Context context) {
        String m25272br = m25272br(context);
        if (TextUtils.isEmpty(m25272br)) {
            return null;
        }
        m25268eT(m25272br);
        File file = new File(m25272br, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /* renamed from: eR */
    public static String m25270eR(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            C10331c.m26250e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    /* renamed from: eS */
    public static String m25269eS(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = null;
            if (pathSegments != null && pathSegments.size() > 0) {
                str2 = pathSegments.get(pathSegments.size() - 1);
            }
            return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable unused) {
            C10331c.m26250e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    /* renamed from: eT */
    private static boolean m25268eT(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    /* renamed from: f */
    public static void m25267f(Context context, String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String m25272br = m25272br(context);
            if (!new File(m25272br, name).getAbsolutePath().startsWith(m25272br)) {
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
                C10738b.closeQuietly(fileOutputStream);
            }
        }
        C10738b.closeQuietly(zipInputStream);
    }
}
