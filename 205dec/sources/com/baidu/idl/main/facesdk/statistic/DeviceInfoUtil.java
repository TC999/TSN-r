package com.baidu.idl.main.facesdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DeviceInfoUtil {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.baidu.idl.main.facesdk.statistic.DeviceInfoUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i4 = 3; i4 < name.length(); i4++) {
                    if (name.charAt(i4) < '0' || name.charAt(i4) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
    private static final String CurPath = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    public static Integer getCPUBit() {
        String str;
        try {
            str = getFieldFromCpuinfo("Processor");
        } catch (IOException e4) {
            e4.printStackTrace();
            str = null;
        }
        if (str == null) {
            return 0;
        }
        if (str.contains("aarch64")) {
            return 64;
        }
        return 32;
    }

    public static int getDeviceBasicFrequency() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        IOException e4;
        FileNotFoundException e5;
        try {
            try {
                try {
                    fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                } catch (FileNotFoundException e6) {
                    bufferedReader2 = null;
                    e5 = e6;
                    fileReader = null;
                } catch (IOException e7) {
                    bufferedReader2 = null;
                    e4 = e7;
                    fileReader = null;
                } catch (Throwable th) {
                    bufferedReader = null;
                    th = th;
                    fileReader = null;
                }
                try {
                    bufferedReader2 = new BufferedReader(fileReader);
                } catch (FileNotFoundException e8) {
                    bufferedReader2 = null;
                    e5 = e8;
                } catch (IOException e9) {
                    bufferedReader2 = null;
                    e4 = e9;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    int parseInt = Integer.parseInt(bufferedReader2.readLine().trim());
                    try {
                        fileReader.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    try {
                        bufferedReader2.close();
                        return parseInt;
                    } catch (IOException e13) {
                        e13.printStackTrace();
                        return parseInt;
                    }
                } catch (FileNotFoundException e14) {
                    e5 = e14;
                    e5.printStackTrace();
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                } catch (IOException e16) {
                    e4 = e16;
                    e4.printStackTrace();
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
                return 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String getDeviceBoard() {
        return Build.BOARD;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceProcessor() {
        try {
            String[] split = new BufferedReader(new FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2);
            for (int i4 = 0; i4 < split.length; i4++) {
            }
            return split[1];
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            return null;
        } catch (IOException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static String getDeviceProduct() {
        return Build.PRODUCT;
    }

    public static int getDeviceSDK() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getFieldFromCpuinfo(String str) throws IOException {
        Matcher matcher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        Pattern compile = Pattern.compile(str + "\\s*:\\s*(.*)");
        do {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return null;
                }
                matcher = compile.matcher(readLine);
            } finally {
                bufferedReader.close();
            }
        } while (!matcher.matches());
        return matcher.group(1);
    }

    public static int getNumberOfCPUCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return 0;
        }
    }

    public static long getRamInfo(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String getStorageInfo(Context context, int i4) {
        String storagePath = getStoragePath(context, i4);
        if (!isSDCardMount() || storagePath == null || storagePath.equals("")) {
            return "\u65e0\u5916\u7f6eSD\u5361";
        }
        StatFs statFs = new StatFs(new File(storagePath).getPath());
        long blockCountLong = statFs.getBlockCountLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        long j4 = blockCountLong * blockSizeLong;
        long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
        return "\u53ef\u7528/\u603b\u5171\uff1a" + Long.toString(availableBlocksLong) + TTPathConst.sSeparator + Long.toString(j4);
    }

    public static String getStoragePath(Context context, int i4) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
            if (i4 != 0) {
                if (i4 == 1 && strArr.length > 1) {
                    return strArr[i4];
                }
                return null;
            }
            return strArr[i4];
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static boolean isSDCardMount() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
