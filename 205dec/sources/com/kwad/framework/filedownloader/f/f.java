package com.kwad.framework.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.sdk.utils.aq;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import xyz.adscope.common.network.Headers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f {
    private static int aiu = 65536;
    private static long aiv = 2000;
    private static String aiw;
    private static Boolean aix;
    private static Boolean aiy;
    private static final Pattern aiz = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static int A(String str, String str2) {
        return com.kwad.framework.filedownloader.download.b.vo().vp().g(str, str2, false);
    }

    public static void B(String str, String str2) {
        bB(str2);
        bC(str);
    }

    public static void V(long j4) {
        if (an(c.wL())) {
            aiv = j4;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static String a(String str, boolean z3, String str2) {
        if (str == null) {
            return null;
        }
        if (z3) {
            if (str2 == null) {
                return null;
            }
            return z(str, str2);
        }
        return str;
    }

    public static boolean an(Context context) {
        boolean endsWith;
        Boolean bool = aix;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.wN().aip) {
            endsWith = true;
        } else if (((ActivityManager) context.getSystemService("activity")) == null) {
            d.d(f.class, "fail to get the activity manager!", new Object[0]);
            return false;
        } else {
            endsWith = aq.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean valueOf = Boolean.valueOf(endsWith);
        aix = valueOf;
        return valueOf.booleanValue();
    }

    public static void ao(Context context) {
        File ap = ap(context);
        try {
            ap.getParentFile().mkdirs();
            ap.createNewFile();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private static File ap(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String b(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static com.kwad.framework.filedownloader.e.a bA(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(b("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException(b("create new file error  %s", file.getAbsolutePath()));
            }
            return com.kwad.framework.filedownloader.download.b.vo().b(file);
        }
        throw new RuntimeException("found invalid internal destination path, empty");
    }

    private static void bB(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bC(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bM(int i4) {
        if (an(c.wL())) {
            aiu = i4;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static String br(String str) {
        return z(wR(), bs(str));
    }

    private static String bs(String str) {
        return bu(str);
    }

    public static String bt(String str) {
        return b("%s.temp", str);
    }

    public static String bu(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i4 = b4 & 255;
                if (i4 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i4));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException("Huh, MD5 should be supported?", e5);
        }
    }

    public static String bv(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = aiz.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String bw(String str) {
        int length = str.length();
        int i4 = 2;
        int i5 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i5 <= 0) {
            i4 = lastIndexOf;
        }
        if (i4 != -1) {
            char charAt = str.charAt(length - 1);
            char c4 = File.separatorChar;
            if (charAt == c4) {
                return null;
            }
            if (str.indexOf(c4) == i4 && str.charAt(i5) == File.separatorChar) {
                return str.substring(0, i4 + 1);
            }
            return str.substring(0, i4);
        }
        return null;
    }

    public static String bx(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean by(String str) {
        return c.wL().checkCallingOrSelfPermission(str) == 0;
    }

    private static long bz(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static int g(String str, String str2, boolean z3) {
        return com.kwad.framework.filedownloader.download.b.vo().vp().g(str, str2, z3);
    }

    public static boolean i(long j4, long j5) {
        return j4 > ((long) wP()) && j5 > wQ();
    }

    private static int wP() {
        return aiu;
    }

    private static long wQ() {
        return aiv;
    }

    private static String wR() {
        if (!TextUtils.isEmpty(aiw)) {
            return aiw;
        }
        if (c.wL().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return c.wL().getExternalCacheDir().getAbsolutePath();
    }

    public static boolean wS() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.wL().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static String wT() {
        return b("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }

    private static String z(String str, String str2) {
        if (str2 != null) {
            if (str != null) {
                return b("%s%s%s", str, File.separator, str2);
            }
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        throw new IllegalStateException("can't generate real path, the file name is null");
    }

    public static String a(int i4, com.kwad.framework.filedownloader.a.b bVar) {
        if (bVar != null) {
            String bd = bVar.bd("Etag");
            if (d.ail) {
                d.c(f.class, "etag find %s for task(%d)", bd, Integer.valueOf(i4));
            }
            return bd;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static long b(int i4, com.kwad.framework.filedownloader.a.b bVar) {
        long bz = bz(bVar.bd("Content-Length"));
        String bd = bVar.bd("Transfer-Encoding");
        if (bz < 0) {
            if (!(bd != null && bd.equals("chunked"))) {
                if (e.wN().aio) {
                    if (d.ail) {
                        d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i4));
                    }
                } else {
                    throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                }
            }
            return -1L;
        }
        return bz;
    }

    public static String a(com.kwad.framework.filedownloader.a.b bVar, String str) {
        String bv = bv(bVar.bd(Headers.KEY_CONTENT_DISPOSITION));
        if (TextUtils.isEmpty(bv)) {
            bv = bs(str);
        }
        return bv.replaceAll("\\/", "_");
    }

    private static boolean a(int i4, com.kwad.framework.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.ail) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i4));
            }
            return false;
        } else if (cVar.vD() == null) {
            if (d.ail) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i4));
            }
            return false;
        } else {
            return a(i4, cVar, cVar.vD(), null);
        }
    }

    public static boolean b(int i4, com.kwad.framework.filedownloader.d.c cVar) {
        return a(i4, cVar, (Boolean) null);
    }

    public static boolean a(int i4, com.kwad.framework.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (d.ail) {
                d.c(f.class, "can't continue %d path = null", Integer.valueOf(i4));
                return false;
            }
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long wl = cVar.wl();
            if (cVar.wo() <= 1 && wl == 0) {
                if (d.ail) {
                    d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i4));
                    return false;
                }
                return false;
            }
            long total = cVar.getTotal();
            if (length >= wl && (total == -1 || (length <= total && wl < total))) {
                if (bool == null || bool.booleanValue() || total != length) {
                    return true;
                }
                if (d.ail) {
                    d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i4));
                    return false;
                }
                return false;
            } else if (d.ail) {
                d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i4), Long.valueOf(length), Long.valueOf(wl), Long.valueOf(total));
                return false;
            } else {
                return false;
            }
        } else if (d.ail) {
            d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i4), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
            return false;
        } else {
            return false;
        }
    }
}
