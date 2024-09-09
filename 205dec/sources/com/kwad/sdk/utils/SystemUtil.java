package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class SystemUtil {
    private static long aQj;
    private static long aQk;
    private static int aQl;
    private static LEVEL aQm;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        int value;

        LEVEL(int i4) {
            this.value = i4;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        public long aQn;
        public long aQo;
        public long aQp;
        public long aQq;
        public long aQr;
        public int mThreadsCount;
    }

    public static long MQ() {
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
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static a MR() {
        String ay;
        a aVar = new a();
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
                            String ay2 = ay(readLine, "VmSize");
                            if (ay2 != null) {
                                aVar.aQo = Long.valueOf(ay2).longValue();
                            }
                        } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String ay3 = ay(readLine, "VmRSS:");
                            if (ay3 != null) {
                                aVar.aQp = Long.valueOf(ay3).longValue();
                            }
                        } else if (readLine.startsWith("Threads:") && (ay = ay(readLine, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(ay).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    return aVar;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return aVar;
    }

    private static String ay(String str, String str2) {
        int length = str2.length();
        int i4 = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (i4 != -1) {
                    break;
                }
            } else if (i4 == -1) {
                i4 = length;
            }
            length++;
        }
        if (i4 == -1) {
            return null;
        }
        return length == -1 ? str.substring(i4) : str.substring(i4, length);
    }

    public static boolean b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i4 = 0; i4 <= 0; i4++) {
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

    public static boolean cU(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, "android.permission.READ_PHONE_STATE");
    }

    public static long cV(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static void checkUiThread() {
    }

    public static boolean ed(int i4) {
        return getApiLevel() >= i4;
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return aq.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return aq.isInMainProcess(context);
    }
}
