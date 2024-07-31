package com.p521ss.android.socialbase.downloader.p556q;

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
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p521ss.android.p540ok.C12274bl;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12430fd;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.exception.C12525a;
import com.p521ss.android.socialbase.downloader.exception.C12527h;
import com.p521ss.android.socialbase.downloader.impls.C12542j;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.C12603n;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12620h;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import io.netty.handler.codec.http.HttpHeaders;
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
import kotlin.UByte;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.q.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12713kf {

    /* renamed from: k */
    private static Boolean f35795k = null;

    /* renamed from: ok */
    private static final String f35798ok = "kf";

    /* renamed from: q */
    private static ConnectivityManager f35800q;

    /* renamed from: r */
    private static Boolean f35801r;

    /* renamed from: a */
    private static final Pattern f35792a = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    /* renamed from: bl */
    private static String f35793bl = null;

    /* renamed from: s */
    private static volatile SparseArray<Boolean> f35802s = new SparseArray<>();

    /* renamed from: n */
    private static volatile SparseArray<List<InterfaceC12430fd>> f35797n = new SparseArray<>();

    /* renamed from: kf */
    private static final char[] f35796kf = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: h */
    private static Pattern f35794h = null;

    /* renamed from: p */
    private static Pattern f35799p = null;

    /* renamed from: a */
    public static long m16616a(InterfaceC12620h interfaceC12620h) {
        if (interfaceC12620h == null) {
            return -1L;
        }
        String m16615a = m16615a(interfaceC12620h, HttpHeaders.Names.CONTENT_RANGE);
        if (TextUtils.isEmpty(m16615a)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(m16615a);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            String str = f35798ok;
            C12409ok.m17894s(str, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    /* renamed from: a */
    public static boolean m16621a(long j) {
        return j == -1;
    }

    /* renamed from: bl */
    public static String m16598bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    /* renamed from: bl */
    public static boolean m16604bl(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    /* renamed from: h */
    public static String m16591h(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: k */
    private static String m16588k(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (f35794h == null) {
                f35794h = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = f35794h.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (f35799p == null) {
            f35799p = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = f35799p.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    /* renamed from: kf */
    public static boolean m16584kf(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String m16520s = m16520s(C12490bl.m17807l());
        return m16520s != null && m16520s.equals(str);
    }

    /* renamed from: n */
    public static String m16578n(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return m16534ok(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: ok */
    public static String m16534ok(byte[] bArr) {
        if (bArr != null) {
            return m16533ok(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: ok */
    public static boolean m16574ok(int i) {
        return i == 0 || i == 2;
    }

    /* renamed from: p */
    public static boolean m16528p(Throwable th) {
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
            String m16587k = m16587k(th);
            return !TextUtils.isEmpty(m16587k) && m16587k.contains("ENOSPC");
        } else {
            return false;
        }
    }

    /* renamed from: q */
    private static String m16527q() {
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
                if (C12409ok.m17899ok()) {
                    C12409ok.m17904a("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                m16531ok(bufferedReader);
                return sb2;
            } catch (Throwable unused) {
                m16531ok(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    /* renamed from: r */
    private static boolean m16523r(String str) {
        String str2 = f35798ok;
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

    /* renamed from: s */
    public static boolean m16521s(int i) {
        return i == 206 || i == 200;
    }

    /* renamed from: s */
    public static boolean m16519s(DownloadInfo downloadInfo) {
        boolean z = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            C12409ok.m17904a(f35798ok, "dcache::last modify is emtpy, so just return cache");
        } else {
            String str = f35798ok;
            C12409ok.m17904a(str, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        }
        String str2 = f35798ok;
        C12409ok.m17904a(str2, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    /* renamed from: bl */
    public static void m16597bl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = f35798ok;
            Log.e(str3, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    /* renamed from: ok */
    public static String m16533ok(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i + i2 <= bArr.length) {
                int i3 = i2 * 2;
                char[] cArr = new char[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = bArr[i5 + i] & UByte.f41242c;
                    int i7 = i4 + 1;
                    char[] cArr2 = f35796kf;
                    cArr[i4] = cArr2[i6 >> 4];
                    i4 = i7 + 1;
                    cArr[i7] = cArr2[i6 & 15];
                }
                return new String(cArr, 0, i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: kf */
    public static boolean m16583kf(Throwable th) {
        if (th == null) {
            return false;
        }
        String m16587k = m16587k(th);
        return !TextUtils.isEmpty(m16587k) && m16587k.contains("Requested Range Not Satisfiable");
    }

    /* renamed from: kf */
    public static long m16585kf(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<C12598a> mo17512bl = C12490bl.m17806m().mo17512bl(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (downloadInfo.isBreakpointAvailable()) {
            if (z) {
                if (mo17512bl == null || chunkCount != mo17512bl.size()) {
                    return 0L;
                }
                return m16607a(mo17512bl);
            }
            return downloadInfo.getCurBytes();
        }
        return 0L;
    }

    /* renamed from: n */
    private static String m16580n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (C12409ok.m17899ok()) {
                            C12409ok.m17904a("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: s */
    public static long m16518s(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e) {
            throw new BaseException(1050, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    /* renamed from: h */
    public static boolean m16590h(Throwable th) {
        return C12490bl.m17831ah().mo17739ok(th);
    }

    /* renamed from: r */
    private static String m16524r() {
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
                if (!TextUtils.isEmpty(str) && C12409ok.m17899ok()) {
                    C12409ok.m17904a("Process", "processName = " + str);
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

    /* renamed from: bl */
    public static boolean m16600bl(DownloadInfo downloadInfo) {
        return m16558ok(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    /* renamed from: h */
    public static File m16592h() {
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

    /* renamed from: a */
    public static long m16612a(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                String str2 = f35798ok;
                C12409ok.m17894s(str2, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    /* renamed from: bl */
    public static boolean m16596bl(String str, String str2, String str3) {
        return m16574ok(m16610a(str, str2, str3));
    }

    /* renamed from: p */
    public static boolean m16529p(String str) {
        Context m17807l;
        if (C12534ok.m17605bl().m17607a("save_path_security") > 0 && (m17807l = C12490bl.m17807l()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + m17807l.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: q */
    public static boolean m16525q(Throwable th) {
        if (th instanceof BaseException) {
            int errorCode = ((BaseException) th).getErrorCode();
            return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
        }
        return false;
    }

    /* renamed from: bl */
    public static boolean m16599bl(InterfaceC12620h interfaceC12620h) {
        if (interfaceC12620h == null) {
            return false;
        }
        return C12717ok.m16510ok(8) ? HttpHeaders.Values.CHUNKED.equals(interfaceC12620h.mo16912ok(HttpHeaders.Names.TRANSFER_ENCODING)) || m16557ok(interfaceC12620h) == -1 : m16557ok(interfaceC12620h) == -1;
    }

    /* renamed from: k */
    private static String m16589k() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName) && C12409ok.m17899ok()) {
                    C12409ok.m17904a("Process", "processName = " + processName);
                }
                return processName;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: ok */
    public static String m16546ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* renamed from: kf */
    public static String m16586kf() {
        return m16551ok(Downloader.getInstance(C12490bl.m17807l()).getGlobalSaveTempDir(), false);
    }

    /* renamed from: s */
    public static boolean m16517s(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    /* renamed from: a */
    public static String m16611a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    /* renamed from: q */
    public static long m16526q(String str) {
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

    /* renamed from: bl */
    public static boolean m16602bl(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager m16569ok = m16569ok(context);
            if (m16569ok == null || (activeNetworkInfo = m16569ok.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m16576n(Throwable th) {
        if (th == null) {
            return false;
        }
        String m16587k = m16587k(th);
        return !TextUtils.isEmpty(m16587k) && m16587k.contains("Precondition Failed");
    }

    /* renamed from: p */
    public static boolean m16530p() {
        Context m17807l = C12490bl.m17807l();
        return (m17807l == null || m16620a(m17807l) || !m16602bl(m17807l)) ? false : true;
    }

    /* renamed from: a */
    public static long m16607a(List<C12598a> list) {
        long j = 0;
        for (C12598a c12598a : list) {
            j += c12598a.m17023t();
        }
        return j;
    }

    /* renamed from: s */
    public static String m16520s(Context context) {
        String str = f35793bl;
        if (TextUtils.isEmpty(str)) {
            String m16589k = m16589k();
            f35793bl = m16589k;
            if (!TextUtils.isEmpty(m16589k)) {
                return f35793bl;
            }
            String m16524r = m16524r();
            f35793bl = m16524r;
            if (!TextUtils.isEmpty(m16524r)) {
                return f35793bl;
            }
            String m16580n = m16580n(context);
            f35793bl = m16580n;
            if (!TextUtils.isEmpty(m16580n)) {
                return f35793bl;
            }
            String m16527q = m16527q();
            f35793bl = m16527q;
            return m16527q;
        }
        return str;
    }

    /* renamed from: k */
    public static String m16587k(Throwable th) {
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

    /* renamed from: n */
    public static EnumC12414kf m16581n(int i) {
        EnumC12414kf enumC12414kf = EnumC12414kf.MAIN;
        EnumC12414kf enumC12414kf2 = EnumC12414kf.SUB;
        if (i != enumC12414kf2.ordinal()) {
            enumC12414kf2 = EnumC12414kf.NOTIFICATION;
            if (i != enumC12414kf2.ordinal()) {
                return enumC12414kf;
            }
        }
        return enumC12414kf2;
    }

    /* renamed from: a */
    public static void m16617a(DownloadInfo downloadInfo) {
        C12534ok m17599ok;
        JSONObject m17588s;
        if (downloadInfo == null || (m17588s = (m17599ok = C12534ok.m17599ok(downloadInfo.getId())).m17588s("download_dir")) == null) {
            return;
        }
        String optString = m17588s.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            m16597bl(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String m16544ok = m16544ok(title, m17599ok);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(m16544ok) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(m16544ok);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            m16523r(file2.getPath());
            file = file.getParentFile();
        }
    }

    /* renamed from: bl */
    public static boolean m16605bl() {
        Boolean bool = f35801r;
        if (bool != null) {
            return bool.booleanValue();
        }
        String m16520s = m16520s(C12490bl.m17807l());
        if (m16520s != null) {
            if (m16520s.equals(C12490bl.m17807l().getPackageName() + ":downloader")) {
                f35801r = Boolean.TRUE;
                return f35801r.booleanValue();
            }
        }
        f35801r = Boolean.FALSE;
        return f35801r.booleanValue();
    }

    /* renamed from: ok */
    public static long m16557ok(InterfaceC12620h interfaceC12620h) {
        if (interfaceC12620h == null) {
            return -1L;
        }
        String m16615a = m16615a(interfaceC12620h, "Content-Length");
        if (TextUtils.isEmpty(m16615a) && C12717ok.m16510ok(1)) {
            return m16616a(interfaceC12620h);
        }
        try {
            return Long.parseLong(m16615a);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: n */
    public static long m16579n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<C12598a> mo17512bl = C12490bl.m17806m().mo17512bl(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (mo17512bl == null || mo17512bl.size() <= 1) {
            return 0L;
        }
        long m16515s = m16515s(mo17512bl);
        if (m16515s >= 0) {
            return m16515s;
        }
        return 0L;
    }

    /* renamed from: ok */
    public static String m16556ok(InterfaceC12620h interfaceC12620h, String str) {
        String m16588k = m16588k(interfaceC12620h.mo16912ok("Content-Disposition"));
        return TextUtils.isEmpty(m16588k) ? m16578n(str) : m16588k;
    }

    /* renamed from: bl */
    public static boolean m16595bl(Throwable th) {
        if (th == null) {
            return false;
        }
        String m16587k = m16587k(th);
        return !TextUtils.isEmpty(m16587k) && m16587k.contains("network not available");
    }

    /* renamed from: n */
    public static String m16582n() {
        return m16551ok(Downloader.getInstance(C12490bl.m17807l()).getGlobalSaveDir(), true);
    }

    /* renamed from: bl */
    public static boolean m16601bl(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    /* renamed from: ok */
    public static C12603n m16560ok(DownloadInfo downloadInfo, String str, String str2, int i) throws BaseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean z = false;
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (C12534ok.m17596ok(downloadInfo).m17593ok("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException((int) GLMapStaticValue.MAP_PARAMETERNAME_SCENIC, "download savePath directory can not created:" + str);
                                }
                                int i2 = 0;
                                while (!z) {
                                    int i3 = i2 + 1;
                                    if (i2 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        z = file2.mkdirs();
                                        i2 = i3;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!z) {
                                    if (m16518s(downloadInfo.getSavePath()) < 16384) {
                                        throw new BaseException(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException((int) GLMapStaticValue.MAP_PARAMETERNAME_SCENIC, "download savePath directory can not created:" + str);
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
                } catch (IOException e) {
                    throw new BaseException(1036, e);
                }
            }
            return new C12603n(file, i);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    /* renamed from: n */
    public static String m16577n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String m16578n = m16578n(str2);
        return (TextUtils.isEmpty(m16578n) || str.contains(m16578n)) ? str : new File(str, m16578n).getAbsolutePath();
    }

    /* renamed from: s */
    public static boolean m16522s() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: bl */
    private static void m16594bl(Throwable th, String str) throws C12527h {
        C12527h mo17738ok = C12490bl.m17831ah().mo17738ok(th, null);
        if (mo17738ok == null) {
            mo17738ok = C12490bl.m17831ah().mo17738ok(th.getCause(), null);
        }
        if (mo17738ok == null) {
            return;
        }
        throw new C12527h(mo17738ok.getErrorCode(), m16608a(mo17738ok, str)).m17615ok(mo17738ok.m17616ok());
    }

    /* renamed from: s */
    public static boolean m16516s(Throwable th) {
        if (th == null) {
            return false;
        }
        String m16587k = m16587k(th);
        return !TextUtils.isEmpty(m16587k) && m16587k.contains("Exception in connect");
    }

    /* renamed from: s */
    private static long m16515s(List<C12598a> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j = -1;
        for (C12598a c12598a : list) {
            if (c12598a != null && (c12598a.m17025rh() <= c12598a.m17042i() || c12598a.m17042i() == 0)) {
                if (j == -1 || j > c12598a.m17025rh()) {
                    j = c12598a.m17025rh();
                }
            }
        }
        return j;
    }

    /* renamed from: bl */
    public static long m16603bl(long j) {
        return System.currentTimeMillis() - j;
    }

    /* renamed from: bl */
    public static boolean m16593bl(List<C12601bl> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (C12601bl c12601bl : list) {
            if (c12601bl != null && !TextUtils.isEmpty(c12601bl.m16999ok()) && !TextUtils.isEmpty(c12601bl.m17000a()) && "download-tc21-1-15".equals(c12601bl.m16999ok()) && "download-tc21-1-15".equals(c12601bl.m17000a())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m16610a(String str, String str2, String str3) {
        return C12274bl.m18509ok(str3, new File(str, str2));
    }

    /* renamed from: a */
    public static String m16622a(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        if (i != 99) {
            switch (i) {
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
    /* renamed from: a */
    private static void m16613a(File file, File file2, boolean z) throws IOException {
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
                long j = 0;
                while (j < size) {
                    long j2 = size - j;
                    long transferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                    if (transferFrom == 0) {
                        break;
                    }
                    j += transferFrom;
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
                    if (z) {
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

    /* renamed from: ok */
    public static List<C12598a> m16539ok(List<C12598a> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (C12598a c12598a : list) {
            if (c12598a != null) {
                if (c12598a.m17024s()) {
                    sparseArray.put(c12598a.m17019zz(), c12598a);
                    List<C12598a> list2 = (List) sparseArray2.get(c12598a.m17019zz());
                    if (list2 != null) {
                        for (C12598a c12598a2 : list2) {
                            c12598a2.m17032ok(c12598a);
                        }
                        c12598a.m17030ok(list2);
                    }
                } else {
                    C12598a c12598a3 = (C12598a) sparseArray.get(c12598a.m17050a());
                    if (c12598a3 != null) {
                        List<C12598a> m17043h = c12598a3.m17043h();
                        if (m17043h == null) {
                            m17043h = new ArrayList<>();
                            c12598a3.m17030ok(m17043h);
                        }
                        c12598a.m17032ok(c12598a3);
                        m17043h.add(c12598a);
                    } else {
                        List list3 = (List) sparseArray2.get(c12598a.m17050a());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(c12598a.m17050a(), list3);
                        }
                        list3.add(c12598a);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    /* renamed from: a */
    public static boolean m16614a(File file, File file2) throws BaseException {
        String str = f35798ok;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = m16554ok(file, file2);
            try {
                Log.e(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    /* renamed from: a */
    public static boolean m16620a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager m16569ok = m16569ok(context);
            if (m16569ok != null && (activeNetworkInfo = m16569ok.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: ok */
    public static String m16543ok(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    /* renamed from: ok */
    public static String m16542ok(String str, String str2, String str3) {
        String m16543ok;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            m16543ok = m16543ok(str2, str3);
        } else {
            m16543ok = m16543ok(str, str3);
        }
        if (TextUtils.isEmpty(m16543ok)) {
            return null;
        }
        return String.format("%s.tp", m16543ok);
    }

    /* renamed from: a */
    public static boolean m16623a() {
        return !m16605bl() && C12490bl.m17830bl() && C12542j.m17583ok(true).mo17457h();
    }

    /* renamed from: a */
    public static boolean m16609a(Throwable th) {
        if (th == null) {
            return false;
        }
        String m16587k = m16587k(th);
        if (!(th instanceof C12525a) || (((C12525a) th).m17617ok() != 403 && (TextUtils.isEmpty(m16587k) || !m16587k.contains("403")))) {
            return !TextUtils.isEmpty(m16587k) && m16587k.contains("Forbidden");
        }
        return true;
    }

    /* renamed from: ok */
    public static void m16563ok(DownloadInfo downloadInfo) {
        m16559ok(downloadInfo, true);
    }

    /* renamed from: a */
    public static boolean m16619a(BaseException baseException) {
        if (baseException instanceof C12525a) {
            C12525a c12525a = (C12525a) baseException;
            if (c12525a.m17617ok() == 412 || c12525a.m17617ok() == 416) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static void m16559ok(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                m16597bl(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        m16597bl(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            m16617a(downloadInfo);
        }
        if (z) {
            String m16578n = m16578n(downloadInfo.getUrl());
            if (TextUtils.isEmpty(m16578n) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(m16578n)) {
                return;
            }
            m16523r(downloadInfo.getSavePath());
        }
    }

    /* renamed from: a */
    public static String m16608a(Throwable th, String str) {
        if (str == null) {
            return m16587k(th);
        }
        return str + "-" + m16587k(th);
    }

    /* renamed from: a */
    public static void m16606a(List<C12601bl> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new C12601bl("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    /* renamed from: a */
    public static String m16615a(InterfaceC12620h interfaceC12620h, String str) {
        if (interfaceC12620h == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String mo16912ok = interfaceC12620h.mo16912ok(str);
        if (C12534ok.m17605bl().m17606a("fix_get_http_resp_head_ignore_case", true)) {
            if (TextUtils.isEmpty(mo16912ok)) {
                mo16912ok = interfaceC12620h.mo16912ok(str.toLowerCase());
            }
            return TextUtils.isEmpty(mo16912ok) ? interfaceC12620h.mo16912ok(str.toUpperCase()) : mo16912ok;
        }
        return mo16912ok;
    }

    /* renamed from: ok */
    public static boolean m16568ok(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    /* renamed from: ok */
    public static boolean m16558ok(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (m16596bl(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m16618a(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && m16602bl(C12490bl.m17807l());
    }

    /* renamed from: ok */
    public static int m16552ok(File file, String str) {
        return C12274bl.m18509ok(str, file);
    }

    /* renamed from: ok */
    public static double m16570ok(long j) {
        double d = j;
        Double.isNaN(d);
        return d / 1048576.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m16562ok(com.p521ss.android.socialbase.downloader.model.DownloadInfo r18, com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y r19, com.p521ss.android.socialbase.downloader.depend.InterfaceC12430fd r20) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p556q.C12713kf.m16562ok(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.downloader.depend.y, com.ss.android.socialbase.downloader.depend.fd):void");
    }

    /* renamed from: ok */
    private static void m16571ok(int i, boolean z, BaseException baseException) {
        synchronized (f35802s) {
            List<InterfaceC12430fd> list = f35797n.get(i);
            if (list != null) {
                for (InterfaceC12430fd interfaceC12430fd : list) {
                    if (interfaceC12430fd != null) {
                        if (z) {
                            interfaceC12430fd.mo17705ok();
                        } else {
                            interfaceC12430fd.mo17704ok(baseException);
                        }
                    }
                }
            }
            String str = f35798ok;
            C12409ok.m17904a(str, "handleTempSaveCallback id:" + i);
            f35802s.remove(i);
        }
    }

    /* renamed from: ok */
    public static void m16561ok(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str2 = f35798ok;
        Log.e(str2, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!m16554ok(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    /* renamed from: ok */
    public static boolean m16554ok(File file, File file2) throws BaseException {
        return m16553ok(file, file2, true);
    }

    /* renamed from: ok */
    public static boolean m16553ok(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    String str = f35798ok;
                    Log.e(str, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    m16613a(file, file2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                m16540ok(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m16573ok(int i, String str) {
        if (C12717ok.m16510ok(16777216)) {
            return i == 206 || i == 1;
        } else if (i >= 400) {
            return false;
        } else {
            return i == 206 || i == 1 || "bytes".equals(str);
        }
    }

    /* renamed from: ok */
    public static List<C12601bl> m16536ok(List<C12601bl> list, String str, C12598a c12598a) {
        return m16537ok(list, str, c12598a.m17020z(), c12598a.m17042i());
    }

    /* renamed from: ok */
    public static List<C12601bl> m16537ok(List<C12601bl> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (C12601bl c12601bl : list) {
                if (c12601bl != null) {
                    arrayList.add(c12601bl);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new C12601bl("If-Match", str));
        }
        arrayList.add(new C12601bl("Accept-Encoding", "identity"));
        String format = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new C12601bl("Range", format));
        String str2 = f35798ok;
        C12409ok.m17904a(str2, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + format);
        return arrayList;
    }

    /* renamed from: ok */
    public static boolean m16572ok(int i, String str, String str2) {
        return i == -3 && !m16517s(str, str2);
    }

    /* renamed from: ok */
    public static ConnectivityManager m16569ok(Context context) {
        ConnectivityManager connectivityManager = f35800q;
        if (connectivityManager == null) {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            f35800q = connectivityManager2;
            return connectivityManager2;
        }
        return connectivityManager;
    }

    /* renamed from: ok */
    public static boolean m16575ok() {
        Boolean bool = f35795k;
        if (bool != null) {
            return bool.booleanValue();
        }
        String m16520s = m16520s(C12490bl.m17807l());
        if (m16520s == null || !m16520s.contains(":")) {
            f35795k = Boolean.valueOf(m16520s != null && m16520s.equals(C12490bl.m17807l().getPackageName()));
        } else {
            f35795k = Boolean.FALSE;
        }
        return f35795k.booleanValue();
    }

    /* renamed from: ok */
    public static boolean m16541ok(Throwable th) {
        if (th == null) {
            return false;
        }
        String m16587k = m16587k(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(m16587k)) {
                return false;
            }
            if (!m16587k.contains("time out") && !m16587k.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ok */
    public static boolean m16565ok(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    /* renamed from: ok */
    public static void m16540ok(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!m16541ok(th)) {
                    if (!m16576n(th)) {
                        if (!m16583kf(th)) {
                            if (!m16609a(th)) {
                                if (!m16595bl(th)) {
                                    if (!m16516s(th)) {
                                        if (th instanceof IOException) {
                                            m16594bl(th, str);
                                            m16550ok((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, m16608a(th, str2));
                                    }
                                    throw new BaseException(1041, m16608a(th, str2));
                                }
                                throw new BaseException(1049, m16608a(th, str2));
                            }
                            throw new BaseException(1047, m16608a(th, str2));
                        }
                        throw new C12525a(1004, TTAdConstant.LIVE_AD_CODE, m16608a(th, str2));
                    }
                    throw new C12525a(1004, TTAdConstant.IMAGE_URL_CODE, m16608a(th, str2));
                }
                throw new BaseException(1048, m16608a(th, str2));
            }
            throw new BaseException(1011, m16608a(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
        throw baseException;
    }

    /* renamed from: ok */
    public static void m16550ok(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String m16608a = m16608a(iOException, str);
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
                                                                        if (m16528p(iOException)) {
                                                                            throw new BaseException(1006, m16608a);
                                                                        }
                                                                        throw new BaseException(1023, m16608a);
                                                                    }
                                                                    throw new BaseException(1011, m16608a);
                                                                }
                                                                throw new BaseException(1067, m16608a);
                                                            }
                                                            throw new BaseException(1066, m16608a);
                                                        }
                                                        throw new BaseException(1065, m16608a);
                                                    }
                                                    throw new BaseException(1064, m16608a);
                                                }
                                                throw new BaseException(1063, m16608a);
                                            }
                                            throw new BaseException(1062, m16608a);
                                        }
                                        throw new BaseException(1061, m16608a);
                                    }
                                    throw new BaseException(1060, m16608a);
                                }
                                throw new BaseException(1059, m16608a);
                            }
                            throw new BaseException(1048, m16608a);
                        }
                        throw new BaseException(1058, m16608a);
                    }
                    throw new BaseException(1057, m16608a);
                }
                throw new BaseException(1056, m16608a);
            }
            throw new BaseException(1055, m16608a);
        }
        throw new BaseException(1041, m16608a);
    }

    /* renamed from: ok */
    public static boolean m16564ok(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    /* renamed from: ok */
    public static <K> HashMap<Integer, K> m16567ok(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i));
        }
        return hashMap;
    }

    /* renamed from: ok */
    public static <K> void m16566ok(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    /* renamed from: ok */
    public static boolean m16535ok(List<C12601bl> list, List<C12601bl> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    /* renamed from: ok */
    public static void m16531ok(Closeable... closeableArr) {
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

    /* renamed from: ok */
    public static void m16532ok(Cursor... cursorArr) {
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

    /* renamed from: ok */
    public static String m16545ok(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    /* renamed from: ok */
    public static String m16544ok(String str, C12534ok c12534ok) {
        JSONObject m17588s;
        String format;
        if (c12534ok == null || (m17588s = c12534ok.m17588s("download_dir")) == null) {
            return "";
        }
        String optString = m17588s.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
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

    /* renamed from: ok */
    private static String m16551ok(File file, boolean z) {
        Context m17807l = C12490bl.m17807l();
        if (m16555ok(file)) {
            return file.getAbsolutePath();
        }
        int i = m17807l.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            File externalFilesDir = m17807l.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (m16555ok(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            if (z) {
                File m16592h = m16592h();
                if (m16555ok(m16592h)) {
                    return m16592h.getAbsolutePath();
                }
            }
            File externalFilesDir2 = m17807l.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (m16555ok(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return m17807l.getFilesDir().getAbsolutePath();
    }

    /* renamed from: ok */
    public static boolean m16555ok(File file) {
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

    /* renamed from: ok */
    public static void m16538ok(List<C12601bl> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new C12601bl("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    /* renamed from: ok */
    public static int m16549ok(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    /* renamed from: ok */
    public static String m16548ok(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    /* renamed from: ok */
    public static boolean m16547ok(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }
}
