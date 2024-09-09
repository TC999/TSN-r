package com.ss.android.socialbase.downloader.q;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.ss.android.socialbase.downloader.depend.fd;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {

    /* renamed from: k  reason: collision with root package name */
    private static Boolean f50157k = null;
    private static final String ok = "kf";

    /* renamed from: q  reason: collision with root package name */
    private static ConnectivityManager f50160q;

    /* renamed from: r  reason: collision with root package name */
    private static Boolean f50161r;

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f50155a = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String bl = null;

    /* renamed from: s  reason: collision with root package name */
    private static volatile SparseArray<Boolean> f50162s = new SparseArray<>();

    /* renamed from: n  reason: collision with root package name */
    private static volatile SparseArray<List<fd>> f50158n = new SparseArray<>();
    private static final char[] kf = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: h  reason: collision with root package name */
    private static Pattern f50156h = null;

    /* renamed from: p  reason: collision with root package name */
    private static Pattern f50159p = null;

    public static long a(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar == null) {
            return -1L;
        }
        String a4 = a(hVar, "Content-Range");
        if (TextUtils.isEmpty(a4)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(a4);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e4) {
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.s(str, "parse content-length from content-range failed " + e4);
        }
        return -1L;
    }

    public static boolean a(long j4) {
        return j4 == -1;
    }

    public static String bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static boolean bl(int i4) {
        return i4 == 200 || i4 == 201 || i4 == 0;
    }

    public static String h(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= '\u007f') {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private static String k(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (f50156h == null) {
                f50156h = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = f50156h.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (f50159p == null) {
            f50159p = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = f50159p.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static boolean kf(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String s3 = s(com.ss.android.socialbase.downloader.downloader.bl.l());
        return s3 != null && s3.equals(str);
    }

    public static String n(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return ok(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String ok(byte[] bArr) {
        if (bArr != null) {
            return ok(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean ok(int i4) {
        return i4 == 0 || i4 == 2;
    }

    public static boolean p(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                String message = baseException.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
            return false;
        } else if (th instanceof IOException) {
            String k4 = k(th);
            return !TextUtils.isEmpty(k4) && k4.contains("ENOSPC");
        } else {
            return false;
        }
    }

    private static String q() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                    com.ss.android.socialbase.downloader.bl.ok.a("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                ok(bufferedReader);
                return sb2;
            } catch (Throwable unused) {
                ok(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    private static boolean r(String str) {
        String str2 = ok;
        Log.w(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                Log.w(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static boolean s(int i4) {
        return i4 == 206 || i4 == 200;
    }

    public static boolean s(DownloadInfo downloadInfo) {
        boolean z3 = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "dcache::last modify is emtpy, so just return cache");
        } else {
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z3 = true;
            }
        }
        String str2 = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str2, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z3);
        return z3;
    }

    public static void bl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = ok;
            Log.e(str3, "deleteFile: " + str + TTPathConst.sSeparator + str2);
            file.delete();
        }
    }

    public static String ok(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            if (i4 >= 0 && i4 + i5 <= bArr.length) {
                int i6 = i5 * 2;
                char[] cArr = new char[i6];
                int i7 = 0;
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = bArr[i8 + i4] & 255;
                    int i10 = i7 + 1;
                    char[] cArr2 = kf;
                    cArr[i7] = cArr2[i9 >> 4];
                    i7 = i10 + 1;
                    cArr[i10] = cArr2[i9 & 15];
                }
                return new String(cArr, 0, i6);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean kf(Throwable th) {
        if (th == null) {
            return false;
        }
        String k4 = k(th);
        return !TextUtils.isEmpty(k4) && k4.contains("Requested Range Not Satisfiable");
    }

    public static long kf(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.a> bl2 = com.ss.android.socialbase.downloader.downloader.bl.m().bl(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z3 = chunkCount > 1;
        if (downloadInfo.isBreakpointAvailable()) {
            if (z3) {
                if (bl2 == null || chunkCount != bl2.size()) {
                    return 0L;
                }
                return a(bl2);
            }
            return downloadInfo.getCurBytes();
        }
        return 0L;
    }

    private static String n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                            com.ss.android.socialbase.downloader.bl.ok.a("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static long s(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e4) {
            throw new BaseException(1050, e4);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static boolean h(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.bl.ah().ok(th);
    }

    private static String r() {
        String str;
        Throwable th;
        Object invoke;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            invoke = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            str = null;
            th = th2;
        }
        if (invoke instanceof String) {
            str = (String) invoke;
            try {
                if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.bl.ok.ok()) {
                    com.ss.android.socialbase.downloader.bl.ok.a("Process", "processName = " + str);
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                return str;
            }
            return str;
        }
        return null;
    }

    public static boolean bl(DownloadInfo downloadInfo) {
        return ok(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static File h() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static long a(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split(TTPathConst.sSeparator);
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                String str2 = ok;
                com.ss.android.socialbase.downloader.bl.ok.s(str2, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean bl(String str, String str2, String str3) {
        return ok(a(str, str2, str3));
    }

    public static boolean p(String str) {
        Context l4;
        if (com.ss.android.socialbase.downloader.h.ok.bl().a("save_path_security") > 0 && (l4 = com.ss.android.socialbase.downloader.downloader.bl.l()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + l4.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(Throwable th) {
        if (th instanceof BaseException) {
            int errorCode = ((BaseException) th).getErrorCode();
            return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
        }
        return false;
    }

    public static boolean bl(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar == null) {
            return false;
        }
        return ok.ok(8) ? "chunked".equals(hVar.ok("Transfer-Encoding")) || ok(hVar) == -1 : ok(hVar) == -1;
    }

    private static String k() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.bl.ok.ok()) {
                    com.ss.android.socialbase.downloader.bl.ok.a("Process", "processName = " + processName);
                }
                return processName;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            try {
                bArr[i4] = (byte) (Integer.parseInt(str.substring(i5, i5 + 2), 16) & 255);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e5) {
            e5.printStackTrace();
            return str;
        }
    }

    public static String kf() {
        return ok(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getGlobalSaveTempDir(), false);
    }

    public static boolean s(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static long q(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (matcher.find()) {
            try {
                return Long.parseLong(matcher.group(1));
            } catch (Throwable th) {
                th.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static boolean bl(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager ok2 = ok(context);
            if (ok2 == null || (activeNetworkInfo = ok2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean n(Throwable th) {
        if (th == null) {
            return false;
        }
        String k4 = k(th);
        return !TextUtils.isEmpty(k4) && k4.contains("Precondition Failed");
    }

    public static boolean p() {
        Context l4 = com.ss.android.socialbase.downloader.downloader.bl.l();
        return (l4 == null || a(l4) || !bl(l4)) ? false : true;
    }

    public static long a(List<com.ss.android.socialbase.downloader.model.a> list) {
        long j4 = 0;
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            j4 += aVar.t();
        }
        return j4;
    }

    public static String s(Context context) {
        String str = bl;
        if (TextUtils.isEmpty(str)) {
            String k4 = k();
            bl = k4;
            if (!TextUtils.isEmpty(k4)) {
                return bl;
            }
            String r3 = r();
            bl = r3;
            if (!TextUtils.isEmpty(r3)) {
                return bl;
            }
            String n4 = n(context);
            bl = n4;
            if (!TextUtils.isEmpty(n4)) {
                return bl;
            }
            String q3 = q();
            bl = q3;
            return q3;
        }
        return str;
    }

    public static String k(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.constants.kf n(int i4) {
        com.ss.android.socialbase.downloader.constants.kf kfVar = com.ss.android.socialbase.downloader.constants.kf.MAIN;
        com.ss.android.socialbase.downloader.constants.kf kfVar2 = com.ss.android.socialbase.downloader.constants.kf.SUB;
        if (i4 != kfVar2.ordinal()) {
            kfVar2 = com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION;
            if (i4 != kfVar2.ordinal()) {
                return kfVar;
            }
        }
        return kfVar2;
    }

    public static void a(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.h.ok ok2;
        JSONObject s3;
        if (downloadInfo == null || (s3 = (ok2 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId())).s("download_dir")) == null) {
            return;
        }
        String optString = s3.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            bl(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String ok3 = ok(title, ok2);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(ok3) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(ok3);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            r(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static boolean bl() {
        Boolean bool = f50161r;
        if (bool != null) {
            return bool.booleanValue();
        }
        String s3 = s(com.ss.android.socialbase.downloader.downloader.bl.l());
        if (s3 != null) {
            if (s3.equals(com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName() + ":downloader")) {
                f50161r = Boolean.TRUE;
                return f50161r.booleanValue();
            }
        }
        f50161r = Boolean.FALSE;
        return f50161r.booleanValue();
    }

    public static long ok(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar == null) {
            return -1L;
        }
        String a4 = a(hVar, "Content-Length");
        if (TextUtils.isEmpty(a4) && ok.ok(1)) {
            return a(hVar);
        }
        try {
            return Long.parseLong(a4);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.a> bl2 = com.ss.android.socialbase.downloader.downloader.bl.m().bl(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (bl2 == null || bl2.size() <= 1) {
            return 0L;
        }
        long s3 = s(bl2);
        if (s3 >= 0) {
            return s3;
        }
        return 0L;
    }

    public static String ok(com.ss.android.socialbase.downloader.network.h hVar, String str) {
        String k4 = k(hVar.ok(Headers.KEY_CONTENT_DISPOSITION));
        return TextUtils.isEmpty(k4) ? n(str) : k4;
    }

    public static boolean bl(Throwable th) {
        if (th == null) {
            return false;
        }
        String k4 = k(th);
        return !TextUtils.isEmpty(k4) && k4.contains("network not available");
    }

    public static String n() {
        return ok(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getGlobalSaveDir(), true);
    }

    public static boolean bl(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static com.ss.android.socialbase.downloader.model.n ok(DownloadInfo downloadInfo, String str, String str2, int i4) throws BaseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean z3 = false;
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo).ok("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                                int i5 = 0;
                                while (!z3) {
                                    int i6 = i5 + 1;
                                    if (i5 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        z3 = file2.mkdirs();
                                        i5 = i6;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!z3) {
                                    if (s(downloadInfo.getSavePath()) < 16384) {
                                        throw new BaseException(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new BaseException(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e4) {
                    throw new BaseException(1036, e4);
                }
            }
            return new com.ss.android.socialbase.downloader.model.n(file, i4);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String n4 = n(str2);
        return (TextUtils.isEmpty(n4) || str.contains(n4)) ? str : new File(str, n4).getAbsolutePath();
    }

    public static boolean s() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private static void bl(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.h {
        com.ss.android.socialbase.downloader.exception.h ok2 = com.ss.android.socialbase.downloader.downloader.bl.ah().ok(th, null);
        if (ok2 == null) {
            ok2 = com.ss.android.socialbase.downloader.downloader.bl.ah().ok(th.getCause(), null);
        }
        if (ok2 == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.h(ok2.getErrorCode(), a(ok2, str)).ok(ok2.ok());
    }

    public static boolean s(Throwable th) {
        if (th == null) {
            return false;
        }
        String k4 = k(th);
        return !TextUtils.isEmpty(k4) && k4.contains("Exception in connect");
    }

    private static long s(List<com.ss.android.socialbase.downloader.model.a> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j4 = -1;
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null && (aVar.rh() <= aVar.i() || aVar.i() == 0)) {
                if (j4 == -1 || j4 > aVar.rh()) {
                    j4 = aVar.rh();
                }
            }
        }
        return j4;
    }

    public static long bl(long j4) {
        return System.currentTimeMillis() - j4;
    }

    public static boolean bl(List<com.ss.android.socialbase.downloader.model.bl> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
            if (blVar != null && !TextUtils.isEmpty(blVar.ok()) && !TextUtils.isEmpty(blVar.a()) && "download-tc21-1-15".equals(blVar.ok()) && "download-tc21-1-15".equals(blVar.a())) {
                return true;
            }
        }
        return false;
    }

    public static int a(String str, String str2, String str3) {
        return com.ss.android.ok.bl.ok(str3, new File(str, str2));
    }

    public static String a(int i4) {
        String str = "ttmd5 check code = " + i4 + ", ";
        if (i4 != 99) {
            switch (i4) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    @TargetApi(19)
    private static void a(File file, File file2, boolean z3) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                FileChannel channel2 = fileOutputStream.getChannel();
                long size = channel.size();
                long j4 = 0;
                while (j4 < size) {
                    long j5 = size - j4;
                    long transferFrom = channel2.transferFrom(channel, j4, j5 > 31457280 ? 31457280L : j5);
                    if (transferFrom == 0) {
                        break;
                    }
                    j4 += transferFrom;
                }
                if (channel2 != null) {
                    channel2.close();
                }
                fileOutputStream.close();
                channel.close();
                fileInputStream.close();
                long length = file.length();
                long length2 = file2.length();
                if (length == length2) {
                    if (z3) {
                        file2.setLastModified(file.lastModified());
                        return;
                    }
                    return;
                }
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused2) {
                }
                throw th4;
            }
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.a> ok(List<com.ss.android.socialbase.downloader.model.a> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null) {
                if (aVar.s()) {
                    sparseArray.put(aVar.zz(), aVar);
                    List<com.ss.android.socialbase.downloader.model.a> list2 = (List) sparseArray2.get(aVar.zz());
                    if (list2 != null) {
                        for (com.ss.android.socialbase.downloader.model.a aVar2 : list2) {
                            aVar2.ok(aVar);
                        }
                        aVar.ok(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.a aVar3 = (com.ss.android.socialbase.downloader.model.a) sparseArray.get(aVar.a());
                    if (aVar3 != null) {
                        List<com.ss.android.socialbase.downloader.model.a> h4 = aVar3.h();
                        if (h4 == null) {
                            h4 = new ArrayList<>();
                            aVar3.ok(h4);
                        }
                        aVar.ok(aVar3);
                        h4.add(aVar);
                    } else {
                        List list3 = (List) sparseArray2.get(aVar.a());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(aVar.a(), list3);
                        }
                        list3.add(aVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i4)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static boolean a(File file, File file2) throws BaseException {
        String str = ok;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = ok(file, file2);
            try {
                Log.e(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager ok2 = ok(context);
            if (ok2 != null && (activeNetworkInfo = ok2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String ok(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String ok(String str, String str2, String str3) {
        String ok2;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            ok2 = ok(str2, str3);
        } else {
            ok2 = ok(str, str3);
        }
        if (TextUtils.isEmpty(ok2)) {
            return null;
        }
        return String.format("%s.tp", ok2);
    }

    public static boolean a() {
        return !bl() && com.ss.android.socialbase.downloader.downloader.bl.bl() && j.ok(true).h();
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String k4 = k(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.a) || (((com.ss.android.socialbase.downloader.exception.a) th).ok() != 403 && (TextUtils.isEmpty(k4) || !k4.contains("403")))) {
            return !TextUtils.isEmpty(k4) && k4.contains("Forbidden");
        }
        return true;
    }

    public static void ok(DownloadInfo downloadInfo) {
        ok(downloadInfo, true);
    }

    public static boolean a(BaseException baseException) {
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.a) {
            com.ss.android.socialbase.downloader.exception.a aVar = (com.ss.android.socialbase.downloader.exception.a) baseException;
            if (aVar.ok() == 412 || aVar.ok() == 416) {
                return true;
            }
        }
        return false;
    }

    public static void ok(DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return;
        }
        if (z3) {
            try {
                bl(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        bl(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            a(downloadInfo);
        }
        if (z3) {
            String n4 = n(downloadInfo.getUrl());
            if (TextUtils.isEmpty(n4) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(n4)) {
                return;
            }
            r(downloadInfo.getSavePath());
        }
    }

    public static String a(Throwable th, String str) {
        if (str == null) {
            return k(th);
        }
        return str + "-" + k(th);
    }

    public static void a(List<com.ss.android.socialbase.downloader.model.bl> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.bl("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String a(com.ss.android.socialbase.downloader.network.h hVar, String str) {
        if (hVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String ok2 = hVar.ok(str);
        if (com.ss.android.socialbase.downloader.h.ok.bl().a("fix_get_http_resp_head_ignore_case", true)) {
            if (TextUtils.isEmpty(ok2)) {
                ok2 = hVar.ok(str.toLowerCase());
            }
            return TextUtils.isEmpty(ok2) ? hVar.ok(str.toUpperCase()) : ok2;
        }
        return ok2;
    }

    public static boolean ok(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean ok(DownloadInfo downloadInfo, boolean z3, String str) {
        if (!z3 && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (bl(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && bl(com.ss.android.socialbase.downloader.downloader.bl.l());
    }

    public static int ok(File file, String str) {
        return com.ss.android.ok.bl.ok(str, file);
    }

    public static double ok(long j4) {
        double d4 = j4;
        Double.isNaN(d4);
        return d4 / 1048576.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void ok(com.ss.android.socialbase.downloader.model.DownloadInfo r18, com.ss.android.socialbase.downloader.depend.y r19, com.ss.android.socialbase.downloader.depend.fd r20) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.q.kf.ok(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.downloader.depend.y, com.ss.android.socialbase.downloader.depend.fd):void");
    }

    private static void ok(int i4, boolean z3, BaseException baseException) {
        synchronized (f50162s) {
            List<fd> list = f50158n.get(i4);
            if (list != null) {
                for (fd fdVar : list) {
                    if (fdVar != null) {
                        if (z3) {
                            fdVar.ok();
                        } else {
                            fdVar.ok(baseException);
                        }
                    }
                }
            }
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "handleTempSaveCallback id:" + i4);
            f50162s.remove(i4);
        }
    }

    public static void ok(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str2 = ok;
        Log.e(str2, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!ok(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean ok(File file, File file2) throws BaseException {
        return ok(file, file2, true);
    }

    public static boolean ok(File file, File file2, boolean z3) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    String str = ok;
                    Log.e(str, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    a(file, file2, z3);
                    return true;
                }
            } catch (BaseException e4) {
                throw e4;
            } catch (Throwable th) {
                ok(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean ok(int i4, String str) {
        if (ok.ok(16777216)) {
            return i4 == 206 || i4 == 1;
        } else if (i4 >= 400) {
            return false;
        } else {
            return i4 == 206 || i4 == 1 || "bytes".equals(str);
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.bl> ok(List<com.ss.android.socialbase.downloader.model.bl> list, String str, com.ss.android.socialbase.downloader.model.a aVar) {
        return ok(list, str, aVar.z(), aVar.i());
    }

    public static List<com.ss.android.socialbase.downloader.model.bl> ok(List<com.ss.android.socialbase.downloader.model.bl> list, String str, long j4, long j5) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                if (blVar != null) {
                    arrayList.add(blVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.bl("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.bl("Accept-Encoding", "identity"));
        String format = j5 <= 0 ? String.format("bytes=%s-", String.valueOf(j4)) : String.format("bytes=%s-%s", String.valueOf(j4), String.valueOf(j5));
        arrayList.add(new com.ss.android.socialbase.downloader.model.bl("Range", format));
        String str2 = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str2, " range CurrentOffset:" + j4 + " EndOffset:" + j5 + ", range = " + format);
        return arrayList;
    }

    public static boolean ok(int i4, String str, String str2) {
        return i4 == -3 && !s(str, str2);
    }

    public static ConnectivityManager ok(Context context) {
        ConnectivityManager connectivityManager = f50160q;
        if (connectivityManager == null) {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            f50160q = connectivityManager2;
            return connectivityManager2;
        }
        return connectivityManager;
    }

    public static boolean ok() {
        Boolean bool = f50157k;
        if (bool != null) {
            return bool.booleanValue();
        }
        String s3 = s(com.ss.android.socialbase.downloader.downloader.bl.l());
        if (s3 == null || !s3.contains(":")) {
            f50157k = Boolean.valueOf(s3 != null && s3.equals(com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName()));
        } else {
            f50157k = Boolean.FALSE;
        }
        return f50157k.booleanValue();
    }

    public static boolean ok(Throwable th) {
        if (th == null) {
            return false;
        }
        String k4 = k(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(k4)) {
                return false;
            }
            if (!k4.contains("time out") && !k4.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean ok(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void ok(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!ok(th)) {
                    if (!n(th)) {
                        if (!kf(th)) {
                            if (!a(th)) {
                                if (!bl(th)) {
                                    if (!s(th)) {
                                        if (th instanceof IOException) {
                                            bl(th, str);
                                            ok((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, a(th, str2));
                                    }
                                    throw new BaseException(1041, a(th, str2));
                                }
                                throw new BaseException(1049, a(th, str2));
                            }
                            throw new BaseException(1047, a(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.a(1004, 416, a(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.a(1004, 412, a(th, str2));
                }
                throw new BaseException(1048, a(th, str2));
            }
            throw new BaseException(1011, a(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
        throw baseException;
    }

    public static void ok(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String a4 = a(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof StreamResetException)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (p(iOException)) {
                                                                            throw new BaseException(1006, a4);
                                                                        }
                                                                        throw new BaseException(1023, a4);
                                                                    }
                                                                    throw new BaseException(1011, a4);
                                                                }
                                                                throw new BaseException(1067, a4);
                                                            }
                                                            throw new BaseException(1066, a4);
                                                        }
                                                        throw new BaseException(1065, a4);
                                                    }
                                                    throw new BaseException(1064, a4);
                                                }
                                                throw new BaseException(1063, a4);
                                            }
                                            throw new BaseException(1062, a4);
                                        }
                                        throw new BaseException(1061, a4);
                                    }
                                    throw new BaseException(1060, a4);
                                }
                                throw new BaseException(1059, a4);
                            }
                            throw new BaseException(1048, a4);
                        }
                        throw new BaseException(1058, a4);
                    }
                    throw new BaseException(1057, a4);
                }
                throw new BaseException(1056, a4);
            }
            throw new BaseException(1055, a4);
        }
        throw new BaseException(1041, a4);
    }

    public static boolean ok(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> ok(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            int keyAt = sparseArray.keyAt(i4);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i4));
        }
        return hashMap;
    }

    public static <K> void ok(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean ok(List<com.ss.android.socialbase.downloader.model.bl> list, List<com.ss.android.socialbase.downloader.model.bl> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void ok(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void ok(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static String ok(String str, int i4) {
        return i4 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i4) ? str : str.substring(0, i4);
    }

    public static String ok(String str, com.ss.android.socialbase.downloader.h.ok okVar) {
        JSONObject s3;
        String format;
        if (okVar == null || (s3 = okVar.s("download_dir")) == null) {
            return "";
        }
        String optString = s3.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith(TTPathConst.sSeparator)) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    private static String ok(File file, boolean z3) {
        Context l4 = com.ss.android.socialbase.downloader.downloader.bl.l();
        if (ok(file)) {
            return file.getAbsolutePath();
        }
        int i4 = l4.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i4 == 29 && !Environment.isExternalStorageLegacy()) || i4 > 29)) {
            File externalFilesDir = l4.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (ok(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            if (z3) {
                File h4 = h();
                if (ok(h4)) {
                    return h4.getAbsolutePath();
                }
            }
            File externalFilesDir2 = l4.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (ok(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return l4.getFilesDir().getAbsolutePath();
    }

    public static boolean ok(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void ok(List<com.ss.android.socialbase.downloader.model.bl> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.bl("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int ok(Object obj, int i4) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i4;
        }
    }

    public static String ok(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean ok(Object obj, boolean z3) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z3;
        }
    }
}
