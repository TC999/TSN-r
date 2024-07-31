package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SystemUtil {
    private static long aQj;
    private static long aQk;
    private static int aQl;
    private static LEVEL aQm;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        int value;

        LEVEL(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* renamed from: com.kwad.sdk.utils.SystemUtil$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10976a {
        public long aQn;
        public long aQo;
        public long aQp;
        public long aQq;
        public long aQr;
        public int mThreadsCount;
    }

    /* renamed from: MQ */
    public static long m24273MQ() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        C10738b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    C10738b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    C10738b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            C10738b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* renamed from: MR */
    public static C10976a m24272MR() {
        String m24271ay;
        C10976a c10976a = new C10976a();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/self/status", "r");
            while (true) {
                try {
                    String readLine = randomAccessFile2.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                            String m24271ay2 = m24271ay(readLine, "VmSize");
                            if (m24271ay2 != null) {
                                c10976a.aQo = Long.valueOf(m24271ay2).longValue();
                            }
                        } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String m24271ay3 = m24271ay(readLine, "VmRSS:");
                            if (m24271ay3 != null) {
                                c10976a.aQp = Long.valueOf(m24271ay3).longValue();
                            }
                        } else if (readLine.startsWith("Threads:") && (m24271ay = m24271ay(readLine, "Threads:")) != null) {
                            c10976a.mThreadsCount = Integer.valueOf(m24271ay).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    C10738b.closeQuietly(randomAccessFile);
                    return c10976a;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    C10738b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
            C10738b.closeQuietly(randomAccessFile2);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return c10976a;
    }

    /* renamed from: ay */
    private static String m24271ay(String str, String str2) {
        int length = str2.length();
        int i = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (i != -1) {
                    break;
                }
            } else if (i == -1) {
                i = length;
            }
            length++;
        }
        if (i == -1) {
            return null;
        }
        return length == -1 ? str.substring(i) : str.substring(i, length);
    }

    /* renamed from: b */
    public static boolean m24270b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i = 0; i <= 0; i++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: cU */
    public static boolean m24269cU(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return m24270b(context, C7282g.f24945c);
    }

    /* renamed from: cV */
    public static long m24268cV(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static void checkUiThread() {
    }

    /* renamed from: ed */
    public static boolean m24267ed(int i) {
        return getApiLevel() >= i;
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return C11024aq.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return C11024aq.isInMainProcess(context);
    }
}
