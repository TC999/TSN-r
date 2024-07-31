package com.kwad.framework.filedownloader.p353f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.download.C9470b;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p352e.InterfaceC9480a;
import com.kwad.sdk.utils.C11024aq;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

/* renamed from: com.kwad.framework.filedownloader.f.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9501f {
    private static int aiu = 65536;
    private static long aiv = 2000;
    private static String aiw;
    private static Boolean aix;
    private static Boolean aiy;
    private static final Pattern aiz = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: A */
    public static int m28528A(String str, String str2) {
        return C9470b.m28631vo().m28630vp().mo28405g(str, str2, false);
    }

    /* renamed from: B */
    public static void m28527B(String str, String str2) {
        m28513bB(str2);
        m28512bC(str);
    }

    /* renamed from: V */
    public static void m28526V(long j) {
        if (m28520an(C9492c.m28544wL())) {
            aiv = j;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    /* renamed from: a */
    public static String m28521a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (z) {
            if (str2 == null) {
                return null;
            }
            return m28494z(str, str2);
        }
        return str;
    }

    /* renamed from: an */
    public static boolean m28520an(Context context) {
        boolean endsWith;
        Boolean bool = aix;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (C9499e.m28530wN().aip) {
            endsWith = true;
        } else if (((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
            C9498d.m28534d(C9501f.class, "fail to get the activity manager!", new Object[0]);
            return false;
        } else {
            endsWith = C11024aq.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean valueOf = Boolean.valueOf(endsWith);
        aix = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: ao */
    public static void m28519ao(Context context) {
        File m28518ap = m28518ap(context);
        try {
            m28518ap.getParentFile().mkdirs();
            m28518ap.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ap */
    private static File m28518ap(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    /* renamed from: b */
    public static String m28515b(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: bA */
    public static InterfaceC9480a m28514bA(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(m28515b("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException(m28515b("create new file error  %s", file.getAbsolutePath()));
            }
            return C9470b.m28631vo().m28633b(file);
        }
        throw new RuntimeException("found invalid internal destination path, empty");
    }

    /* renamed from: bB */
    private static void m28513bB(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* renamed from: bC */
    public static void m28512bC(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* renamed from: bM */
    public static void m28511bM(int i) {
        if (m28520an(C9492c.m28544wL())) {
            aiu = i;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    /* renamed from: br */
    public static String m28510br(String str) {
        return m28494z(m28497wR(), m28509bs(str));
    }

    /* renamed from: bs */
    private static String m28509bs(String str) {
        return m28507bu(str);
    }

    /* renamed from: bt */
    public static String m28508bt(String str) {
        return m28515b("%s.temp", str);
    }

    /* renamed from: bu */
    public static String m28507bu(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & UByte.f41242c;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    /* renamed from: bv */
    public static String m28506bv(String str) {
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

    /* renamed from: bw */
    public static String m28505bw(String str) {
        int length = str.length();
        int i = 2;
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i2 <= 0) {
            i = lastIndexOf;
        }
        if (i != -1) {
            char charAt = str.charAt(length - 1);
            char c = File.separatorChar;
            if (charAt == c) {
                return null;
            }
            if (str.indexOf(c) == i && str.charAt(i2) == File.separatorChar) {
                return str.substring(0, i + 1);
            }
            return str.substring(0, i);
        }
        return null;
    }

    /* renamed from: bx */
    public static String m28504bx(String str) {
        return "FileDownloader-" + str;
    }

    /* renamed from: by */
    public static boolean m28503by(String str) {
        return C9492c.m28544wL().checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: bz */
    private static long m28502bz(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: g */
    public static int m28501g(String str, String str2, boolean z) {
        return C9470b.m28631vo().m28630vp().mo28405g(str, str2, z);
    }

    /* renamed from: i */
    public static boolean m28500i(long j, long j2) {
        return j > ((long) m28499wP()) && j2 > m28498wQ();
    }

    /* renamed from: wP */
    private static int m28499wP() {
        return aiu;
    }

    /* renamed from: wQ */
    private static long m28498wQ() {
        return aiv;
    }

    /* renamed from: wR */
    private static String m28497wR() {
        if (!TextUtils.isEmpty(aiw)) {
            return aiw;
        }
        if (C9492c.m28544wL().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return C9492c.m28544wL().getExternalCacheDir().getAbsolutePath();
    }

    /* renamed from: wS */
    public static boolean m28496wS() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C9492c.m28544wL().getSystemService("connectivity");
        if (connectivityManager == null) {
            C9498d.m28534d(C9501f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    /* renamed from: wT */
    public static String m28495wT() {
        return m28515b("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }

    /* renamed from: z */
    private static String m28494z(String str, String str2) {
        if (str2 != null) {
            if (str != null) {
                return m28515b("%s%s%s", str, File.separator, str2);
            }
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        throw new IllegalStateException("can't generate real path, the file name is null");
    }

    /* renamed from: a */
    public static String m28525a(int i, InterfaceC9432b interfaceC9432b) {
        if (interfaceC9432b != null) {
            String mo24750bd = interfaceC9432b.mo24750bd("Etag");
            if (C9498d.ail) {
                C9498d.m28535c(C9501f.class, "etag find %s for task(%d)", mo24750bd, Integer.valueOf(i));
            }
            return mo24750bd;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    /* renamed from: b */
    public static long m28517b(int i, InterfaceC9432b interfaceC9432b) {
        long m28502bz = m28502bz(interfaceC9432b.mo24750bd("Content-Length"));
        String mo24750bd = interfaceC9432b.mo24750bd(HttpHeaders.Names.TRANSFER_ENCODING);
        if (m28502bz < 0) {
            if (!(mo24750bd != null && mo24750bd.equals(HttpHeaders.Values.CHUNKED))) {
                if (C9499e.m28530wN().aio) {
                    if (C9498d.ail) {
                        C9498d.m28535c(C9501f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                    }
                } else {
                    throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                }
            }
            return -1L;
        }
        return m28502bz;
    }

    /* renamed from: a */
    public static String m28522a(InterfaceC9432b interfaceC9432b, String str) {
        String m28506bv = m28506bv(interfaceC9432b.mo24750bd("Content-Disposition"));
        if (TextUtils.isEmpty(m28506bv)) {
            m28506bv = m28509bs(str);
        }
        return m28506bv.replaceAll("\\/", "_");
    }

    /* renamed from: a */
    private static boolean m28524a(int i, C9464c c9464c, Boolean bool) {
        if (c9464c == null) {
            if (C9498d.ail) {
                C9498d.m28535c(C9501f.class, "can't continue %d model == null", Integer.valueOf(i));
            }
            return false;
        } else if (c9464c.m28685vD() == null) {
            if (C9498d.ail) {
                C9498d.m28535c(C9501f.class, "can't continue %d temp path == null", Integer.valueOf(i));
            }
            return false;
        } else {
            return m28523a(i, c9464c, c9464c.m28685vD(), null);
        }
    }

    /* renamed from: b */
    public static boolean m28516b(int i, C9464c c9464c) {
        return m28524a(i, c9464c, (Boolean) null);
    }

    /* renamed from: a */
    public static boolean m28523a(int i, C9464c c9464c, String str, Boolean bool) {
        if (str == null) {
            if (C9498d.ail) {
                C9498d.m28535c(C9501f.class, "can't continue %d path = null", Integer.valueOf(i));
                return false;
            }
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long m28683wl = c9464c.m28683wl();
            if (c9464c.m28680wo() <= 1 && m28683wl == 0) {
                if (C9498d.ail) {
                    C9498d.m28535c(C9501f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                    return false;
                }
                return false;
            }
            long total = c9464c.getTotal();
            if (length >= m28683wl && (total == -1 || (length <= total && m28683wl < total))) {
                if (bool == null || bool.booleanValue() || total != length) {
                    return true;
                }
                if (C9498d.ail) {
                    C9498d.m28535c(C9501f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                    return false;
                }
                return false;
            } else if (C9498d.ail) {
                C9498d.m28535c(C9501f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(m28683wl), Long.valueOf(total));
                return false;
            } else {
                return false;
            }
        } else if (C9498d.ail) {
            C9498d.m28535c(C9501f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
            return false;
        } else {
            return false;
        }
    }
}
