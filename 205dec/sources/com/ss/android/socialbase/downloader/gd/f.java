package com.ss.android.socialbase.downloader.gd;

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
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.a;
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

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49650c = "f";
    private static ConnectivityManager gd;

    /* renamed from: k  reason: collision with root package name */
    private static Boolean f49652k;

    /* renamed from: p  reason: collision with root package name */
    private static Boolean f49653p;

    /* renamed from: w  reason: collision with root package name */
    private static final Pattern f49655w = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String xv = null;
    private static volatile SparseArray<Boolean> sr = new SparseArray<>();
    private static volatile SparseArray<List<yu>> ux = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private static final char[] f49651f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: r  reason: collision with root package name */
    private static Pattern f49654r = null;
    private static Pattern ev = null;

    public static String c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean c(int i4) {
        return i4 == 0 || i4 == 2;
    }

    public static boolean ev(Throwable th) {
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
            String p3 = p(th);
            return !TextUtils.isEmpty(p3) && p3.contains("ENOSPC");
        } else {
            return false;
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String sr2 = sr(com.ss.android.socialbase.downloader.downloader.xv.gw());
        return sr2 != null && sr2.equals(str);
    }

    private static String gd() {
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
                if (com.ss.android.socialbase.downloader.xv.c.c()) {
                    com.ss.android.socialbase.downloader.xv.c.w("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                c(bufferedReader);
                return sb2;
            } catch (Throwable unused) {
                c(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    private static boolean k(String str) {
        String str2 = f49650c;
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

    private static String p(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (f49654r == null) {
                f49654r = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = f49654r.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (ev == null) {
            ev = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = ev.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static String r(String str) {
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

    public static boolean sr(int i4) {
        return i4 == 206 || i4 == 200;
    }

    public static boolean sr(DownloadInfo downloadInfo) {
        boolean z3 = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.xv.c.w(f49650c, "dcache::last modify is emtpy, so just return cache");
        } else {
            String str = f49650c;
            com.ss.android.socialbase.downloader.xv.c.w(str, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z3 = true;
            }
        }
        String str2 = f49650c;
        com.ss.android.socialbase.downloader.xv.c.w(str2, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z3);
        return z3;
    }

    public static String ux(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return c(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static long w(com.ss.android.socialbase.downloader.network.r rVar) {
        if (rVar == null) {
            return -1L;
        }
        String w3 = w(rVar, "Content-Range");
        if (TextUtils.isEmpty(w3)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(w3);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e4) {
            String str = f49650c;
            com.ss.android.socialbase.downloader.xv.c.sr(str, "parse content-length from content-range failed " + e4);
        }
        return -1L;
    }

    public static boolean w(long j4) {
        return j4 == -1;
    }

    public static String xv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static boolean xv(int i4) {
        return i4 == 200 || i4 == 201 || i4 == 0;
    }

    public static String c(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            if (i4 >= 0 && i4 + i5 <= bArr.length) {
                int i6 = i5 * 2;
                char[] cArr = new char[i6];
                int i7 = 0;
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = bArr[i8 + i4] & 255;
                    int i10 = i7 + 1;
                    char[] cArr2 = f49651f;
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

    public static void xv(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = f49650c;
            Log.e(str3, "deleteFile: " + str + TTPathConst.sSeparator + str2);
            file.delete();
        }
    }

    public static boolean f(Throwable th) {
        if (th == null) {
            return false;
        }
        String p3 = p(th);
        return !TextUtils.isEmpty(p3) && p3.contains("Requested Range Not Satisfiable");
    }

    public static long f(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List xv2 = com.ss.android.socialbase.downloader.downloader.xv.gb().xv(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z3 = chunkCount > 1;
        if (downloadInfo.isBreakpointAvailable()) {
            if (z3) {
                if (xv2 == null || chunkCount != xv2.size()) {
                    return 0L;
                }
                return w(xv2);
            }
            return downloadInfo.getCurBytes();
        }
        return 0L;
    }

    public static long sr(String str) throws BaseException {
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

    private static String ux(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (com.ss.android.socialbase.downloader.xv.c.c()) {
                            com.ss.android.socialbase.downloader.xv.c.w("Process", "processName = " + runningAppProcessInfo.processName);
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

    private static String k() {
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
                if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.xv.c.c()) {
                    com.ss.android.socialbase.downloader.xv.c.w("Process", "processName = " + str);
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

    public static boolean r(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.xv.m().c(th);
    }

    public static File r() {
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

    public static boolean xv(DownloadInfo downloadInfo) {
        return c(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean ev(String str) {
        Context gw;
        if (com.ss.android.socialbase.downloader.r.c.xv().w("save_path_security") > 0 && (gw = com.ss.android.socialbase.downloader.downloader.xv.gw()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + gw.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static long w(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split(TTPathConst.sSeparator);
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                String str2 = f49650c;
                com.ss.android.socialbase.downloader.xv.c.sr(str2, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean xv(String str, String str2, String str3) {
        return c(w(str, str2, str3));
    }

    public static boolean gd(Throwable th) {
        if (th instanceof BaseException) {
            int errorCode = ((BaseException) th).getErrorCode();
            return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
        }
        return false;
    }

    public static String c(String str) {
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

    private static String p() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.xv.c.c()) {
                    com.ss.android.socialbase.downloader.xv.c.w("Process", "processName = " + processName);
                }
                return processName;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static boolean xv(com.ss.android.socialbase.downloader.network.r rVar) {
        if (rVar == null) {
            return false;
        }
        return c.c(8) ? "chunked".equals(rVar.c("Transfer-Encoding")) || c(rVar) == -1 : c(rVar) == -1;
    }

    public static String f() {
        return c(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).getGlobalSaveTempDir(), false);
    }

    public static boolean sr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static long gd(String str) {
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

    public static String w(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static boolean ev() {
        Context gw = com.ss.android.socialbase.downloader.downloader.xv.gw();
        return (gw == null || w(gw) || !xv(gw)) ? false : true;
    }

    public static boolean ux(Throwable th) {
        if (th == null) {
            return false;
        }
        String p3 = p(th);
        return !TextUtils.isEmpty(p3) && p3.contains("Precondition Failed");
    }

    public static boolean xv(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager c4 = c(context);
            if (c4 == null || (activeNetworkInfo = c4.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String sr(Context context) {
        String str = xv;
        if (TextUtils.isEmpty(str)) {
            String p3 = p();
            xv = p3;
            if (!TextUtils.isEmpty(p3)) {
                return xv;
            }
            String k4 = k();
            xv = k4;
            if (!TextUtils.isEmpty(k4)) {
                return xv;
            }
            String ux2 = ux(context);
            xv = ux2;
            if (!TextUtils.isEmpty(ux2)) {
                return xv;
            }
            String gd2 = gd();
            xv = gd2;
            return gd2;
        }
        return str;
    }

    public static long w(List<com.ss.android.socialbase.downloader.model.w> list) {
        long j4 = 0;
        for (com.ss.android.socialbase.downloader.model.w wVar : list) {
            j4 += wVar.ys();
        }
        return j4;
    }

    public static String p(Throwable th) {
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

    public static com.ss.android.socialbase.downloader.constants.f ux(int i4) {
        com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.MAIN;
        com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.SUB;
        if (i4 != fVar2.ordinal()) {
            fVar2 = com.ss.android.socialbase.downloader.constants.f.NOTIFICATION;
            if (i4 != fVar2.ordinal()) {
                return fVar;
            }
        }
        return fVar2;
    }

    public static void w(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.r.c c4;
        JSONObject sr2;
        if (downloadInfo == null || (sr2 = (c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId())).sr("download_dir")) == null) {
            return;
        }
        String optString = sr2.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            xv(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String c5 = c(title, c4);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(c5) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(c5);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            k(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static boolean xv() {
        Boolean bool = f49652k;
        if (bool != null) {
            return bool.booleanValue();
        }
        String sr2 = sr(com.ss.android.socialbase.downloader.downloader.xv.gw());
        if (sr2 != null) {
            if (sr2.equals(com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageName() + ":downloader")) {
                f49652k = Boolean.TRUE;
                return f49652k.booleanValue();
            }
        }
        f49652k = Boolean.FALSE;
        return f49652k.booleanValue();
    }

    public static long c(com.ss.android.socialbase.downloader.network.r rVar) {
        if (rVar == null) {
            return -1L;
        }
        String w3 = w(rVar, "Content-Length");
        if (TextUtils.isEmpty(w3) && c.c(1)) {
            return w(rVar);
        }
        try {
            return Long.parseLong(w3);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long ux(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List xv2 = com.ss.android.socialbase.downloader.downloader.xv.gb().xv(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (xv2 == null || xv2.size() <= 1) {
            return 0L;
        }
        long sr2 = sr(xv2);
        if (sr2 >= 0) {
            return sr2;
        }
        return 0L;
    }

    public static String c(com.ss.android.socialbase.downloader.network.r rVar, String str) {
        String p3 = p(rVar.c(Headers.KEY_CONTENT_DISPOSITION));
        return TextUtils.isEmpty(p3) ? ux(str) : p3;
    }

    public static String ux() {
        return c(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).getGlobalSaveDir(), true);
    }

    public static boolean xv(Throwable th) {
        if (th == null) {
            return false;
        }
        String p3 = p(th);
        return !TextUtils.isEmpty(p3) && p3.contains("network not available");
    }

    public static com.ss.android.socialbase.downloader.model.ux c(DownloadInfo downloadInfo, String str, String str2, int i4) throws BaseException {
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
                                if (com.ss.android.socialbase.downloader.r.c.c(downloadInfo).c("opt_mkdir_failed", 0) != 1) {
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
                                    if (sr(downloadInfo.getSavePath()) < 16384) {
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
            return new com.ss.android.socialbase.downloader.model.ux(file, i4);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static boolean xv(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static boolean sr() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String ux(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String ux2 = ux(str2);
        return (TextUtils.isEmpty(ux2) || str.contains(ux2)) ? str : new File(str, ux2).getAbsolutePath();
    }

    public static boolean sr(Throwable th) {
        if (th == null) {
            return false;
        }
        String p3 = p(th);
        return !TextUtils.isEmpty(p3) && p3.contains("Exception in connect");
    }

    private static void xv(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.r {
        com.ss.android.socialbase.downloader.exception.r c4 = com.ss.android.socialbase.downloader.downloader.xv.m().c(th, null);
        if (c4 == null) {
            c4 = com.ss.android.socialbase.downloader.downloader.xv.m().c(th.getCause(), null);
        }
        if (c4 == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.r(c4.getErrorCode(), w(c4, str)).c(c4.c());
    }

    private static long sr(List<com.ss.android.socialbase.downloader.model.w> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j4 = -1;
        for (com.ss.android.socialbase.downloader.model.w wVar : list) {
            if (wVar != null && (wVar.t() <= wVar.fp() || wVar.fp() == 0)) {
                if (j4 == -1 || j4 > wVar.t()) {
                    j4 = wVar.t();
                }
            }
        }
        return j4;
    }

    public static long xv(long j4) {
        return System.currentTimeMillis() - j4;
    }

    public static boolean xv(List<com.ss.android.socialbase.downloader.model.xv> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.xv xvVar : list) {
            if (xvVar != null && !TextUtils.isEmpty(xvVar.c()) && !TextUtils.isEmpty(xvVar.w()) && "download-tc21-1-15".equals(xvVar.c()) && "download-tc21-1-15".equals(xvVar.w())) {
                return true;
            }
        }
        return false;
    }

    public static int w(String str, String str2, String str3) {
        return com.ss.android.c.xv.c(str3, new File(str, str2));
    }

    public static String w(int i4) {
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
    private static void w(File file, File file2, boolean z3) throws IOException {
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

    public static List<com.ss.android.socialbase.downloader.model.w> c(List<com.ss.android.socialbase.downloader.model.w> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.w wVar : list) {
            if (wVar != null) {
                if (wVar.sr()) {
                    sparseArray.put(wVar.fz(), wVar);
                    List<com.ss.android.socialbase.downloader.model.w> list2 = (List) sparseArray2.get(wVar.fz());
                    if (list2 != null) {
                        for (com.ss.android.socialbase.downloader.model.w wVar2 : list2) {
                            wVar2.c(wVar);
                        }
                        wVar.c(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.w wVar3 = (com.ss.android.socialbase.downloader.model.w) sparseArray.get(wVar.w());
                    if (wVar3 != null) {
                        List<com.ss.android.socialbase.downloader.model.w> r3 = wVar3.r();
                        if (r3 == null) {
                            r3 = new ArrayList<>();
                            wVar3.c(r3);
                        }
                        wVar.c(wVar3);
                        r3.add(wVar);
                    } else {
                        List list3 = (List) sparseArray2.get(wVar.w());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(wVar.w(), list3);
                        }
                        list3.add(wVar);
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

    public static boolean w(File file, File file2) throws BaseException {
        String str = f49650c;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = c(file, file2);
            try {
                Log.e(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean w(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager c4 = c(context);
            if (c4 != null && (activeNetworkInfo = c4.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String c(String str, String str2, String str3) {
        String c4;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            c4 = c(str2, str3);
        } else {
            c4 = c(str, str3);
        }
        if (TextUtils.isEmpty(c4)) {
            return null;
        }
        return String.format("%s.tp", c4);
    }

    public static boolean w() {
        return !xv() && com.ss.android.socialbase.downloader.downloader.xv.xv() && a.c(true).r();
    }

    public static boolean w(Throwable th) {
        if (th == null) {
            return false;
        }
        String p3 = p(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.w) || (((com.ss.android.socialbase.downloader.exception.w) th).c() != 403 && (TextUtils.isEmpty(p3) || !p3.contains("403")))) {
            return !TextUtils.isEmpty(p3) && p3.contains("Forbidden");
        }
        return true;
    }

    public static void c(DownloadInfo downloadInfo) {
        c(downloadInfo, true);
    }

    public static void c(DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return;
        }
        if (z3) {
            try {
                xv(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        xv(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            w(downloadInfo);
        }
        if (z3) {
            String ux2 = ux(downloadInfo.getUrl());
            if (TextUtils.isEmpty(ux2) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(ux2)) {
                return;
            }
            k(downloadInfo.getSavePath());
        }
    }

    public static boolean w(BaseException baseException) {
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.w) {
            com.ss.android.socialbase.downloader.exception.w wVar = (com.ss.android.socialbase.downloader.exception.w) baseException;
            if (wVar.c() == 412 || wVar.c() == 416) {
                return true;
            }
        }
        return false;
    }

    public static String w(Throwable th, String str) {
        if (str == null) {
            return p(th);
        }
        return str + "-" + p(th);
    }

    public static void w(List<com.ss.android.socialbase.downloader.model.xv> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.xv("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String w(com.ss.android.socialbase.downloader.network.r rVar, String str) {
        if (rVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String c4 = rVar.c(str);
        if (com.ss.android.socialbase.downloader.r.c.xv().w("fix_get_http_resp_head_ignore_case", true)) {
            if (TextUtils.isEmpty(c4)) {
                c4 = rVar.c(str.toLowerCase());
            }
            return TextUtils.isEmpty(c4) ? rVar.c(str.toUpperCase()) : c4;
        }
        return c4;
    }

    public static boolean c(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean c(DownloadInfo downloadInfo, boolean z3, String str) {
        if (!z3 && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (xv(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public static boolean w(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && xv(com.ss.android.socialbase.downloader.downloader.xv.gw());
    }

    public static int c(File file, String str) {
        return com.ss.android.c.xv.c(str, file);
    }

    public static double c(long j4) {
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
    public static void c(com.ss.android.socialbase.downloader.model.DownloadInfo r18, com.ss.android.socialbase.downloader.depend.ls r19, com.ss.android.socialbase.downloader.depend.yu r20) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.gd.f.c(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.downloader.depend.ls, com.ss.android.socialbase.downloader.depend.yu):void");
    }

    private static void c(int i4, boolean z3, BaseException baseException) {
        synchronized (sr) {
            List<yu> list = ux.get(i4);
            if (list != null) {
                for (yu yuVar : list) {
                    if (yuVar != null) {
                        if (z3) {
                            yuVar.c();
                        } else {
                            yuVar.c(baseException);
                        }
                    }
                }
            }
            String str = f49650c;
            com.ss.android.socialbase.downloader.xv.c.w(str, "handleTempSaveCallback id:" + i4);
            sr.remove(i4);
        }
    }

    public static void c(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str2 = f49650c;
        Log.e(str2, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!c(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean c(File file, File file2) throws BaseException {
        return c(file, file2, true);
    }

    public static boolean c(File file, File file2, boolean z3) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    String str = f49650c;
                    Log.e(str, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    w(file, file2, z3);
                    return true;
                }
            } catch (BaseException e4) {
                throw e4;
            } catch (Throwable th) {
                c(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean c(int i4, String str) {
        if (c.c(16777216)) {
            return i4 == 206 || i4 == 1;
        } else if (i4 >= 400) {
            return false;
        } else {
            return i4 == 206 || i4 == 1 || "bytes".equals(str);
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.xv> c(List<com.ss.android.socialbase.downloader.model.xv> list, String str, com.ss.android.socialbase.downloader.model.w wVar) {
        return c(list, str, wVar.bk(), wVar.fp());
    }

    public static List<com.ss.android.socialbase.downloader.model.xv> c(List<com.ss.android.socialbase.downloader.model.xv> list, String str, long j4, long j5) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.xv xvVar : list) {
                if (xvVar != null) {
                    arrayList.add(xvVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.xv("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.xv("Accept-Encoding", "identity"));
        String format = j5 <= 0 ? String.format("bytes=%s-", String.valueOf(j4)) : String.format("bytes=%s-%s", String.valueOf(j4), String.valueOf(j5));
        arrayList.add(new com.ss.android.socialbase.downloader.model.xv("Range", format));
        String str2 = f49650c;
        com.ss.android.socialbase.downloader.xv.c.w(str2, " range CurrentOffset:" + j4 + " EndOffset:" + j5 + ", range = " + format);
        return arrayList;
    }

    public static boolean c(int i4, String str, String str2) {
        return i4 == -3 && !sr(str, str2);
    }

    public static ConnectivityManager c(Context context) {
        ConnectivityManager connectivityManager = gd;
        if (connectivityManager == null) {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            gd = connectivityManager2;
            return connectivityManager2;
        }
        return connectivityManager;
    }

    public static boolean c() {
        Boolean bool = f49653p;
        if (bool != null) {
            return bool.booleanValue();
        }
        String sr2 = sr(com.ss.android.socialbase.downloader.downloader.xv.gw());
        if (sr2 == null || !sr2.contains(":")) {
            f49653p = Boolean.valueOf(sr2 != null && sr2.equals(com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageName()));
        } else {
            f49653p = Boolean.FALSE;
        }
        return f49653p.booleanValue();
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String p3 = p(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(p3)) {
                return false;
            }
            if (!p3.contains("time out") && !p3.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void c(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!c(th)) {
                    if (!ux(th)) {
                        if (!f(th)) {
                            if (!w(th)) {
                                if (!xv(th)) {
                                    if (!sr(th)) {
                                        if (th instanceof IOException) {
                                            xv(th, str);
                                            c((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, w(th, str2));
                                    }
                                    throw new BaseException(1041, w(th, str2));
                                }
                                throw new BaseException(1049, w(th, str2));
                            }
                            throw new BaseException(1047, w(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.w(1004, 416, w(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.w(1004, 412, w(th, str2));
                }
                throw new BaseException(1048, w(th, str2));
            }
            throw new BaseException(1011, w(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
        throw baseException;
    }

    public static void c(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String w3 = w(iOException, str);
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
                                                                        if (ev(iOException)) {
                                                                            throw new BaseException(1006, w3);
                                                                        }
                                                                        throw new BaseException(1023, w3);
                                                                    }
                                                                    throw new BaseException(1011, w3);
                                                                }
                                                                throw new BaseException(1067, w3);
                                                            }
                                                            throw new BaseException(1066, w3);
                                                        }
                                                        throw new BaseException(1065, w3);
                                                    }
                                                    throw new BaseException(1064, w3);
                                                }
                                                throw new BaseException(1063, w3);
                                            }
                                            throw new BaseException(1062, w3);
                                        }
                                        throw new BaseException(1061, w3);
                                    }
                                    throw new BaseException(1060, w3);
                                }
                                throw new BaseException(1059, w3);
                            }
                            throw new BaseException(1048, w3);
                        }
                        throw new BaseException(1058, w3);
                    }
                    throw new BaseException(1057, w3);
                }
                throw new BaseException(1056, w3);
            }
            throw new BaseException(1055, w3);
        }
        throw new BaseException(1041, w3);
    }

    public static boolean c(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> c(SparseArray<K> sparseArray) {
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

    public static <K> void c(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean c(List<com.ss.android.socialbase.downloader.model.xv> list, List<com.ss.android.socialbase.downloader.model.xv> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void c(Closeable... closeableArr) {
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

    public static void c(Cursor... cursorArr) {
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

    public static String c(String str, int i4) {
        return i4 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i4) ? str : str.substring(0, i4);
    }

    public static String c(String str, com.ss.android.socialbase.downloader.r.c cVar) {
        JSONObject sr2;
        String format;
        if (cVar == null || (sr2 = cVar.sr("download_dir")) == null) {
            return "";
        }
        String optString = sr2.optString("dir_name");
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

    private static String c(File file, boolean z3) {
        Context gw = com.ss.android.socialbase.downloader.downloader.xv.gw();
        if (c(file)) {
            return file.getAbsolutePath();
        }
        int i4 = gw.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i4 == 29 && !Environment.isExternalStorageLegacy()) || i4 > 29)) {
            File c4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(gw, Environment.DIRECTORY_DOWNLOADS);
            if (c(c4)) {
                return c4.getAbsolutePath();
            }
        } else {
            if (z3) {
                File r3 = r();
                if (c(r3)) {
                    return r3.getAbsolutePath();
                }
            }
            File c5 = com.bytedance.sdk.openadsdk.api.plugin.w.c(gw, Environment.DIRECTORY_DOWNLOADS);
            if (c(c5)) {
                return c5.getAbsolutePath();
            }
        }
        return com.bytedance.sdk.openadsdk.api.plugin.w.c(gw).getAbsolutePath();
    }

    public static boolean c(File file) {
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

    public static void c(List<com.ss.android.socialbase.downloader.model.xv> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.xv("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int c(Object obj, int i4) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i4;
        }
    }

    public static String c(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean c(Object obj, boolean z3) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z3;
        }
    }
}
