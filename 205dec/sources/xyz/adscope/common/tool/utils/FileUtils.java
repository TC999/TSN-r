package xyz.adscope.common.tool.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FileUtils {
    public static long a(File[] fileArr) {
        long j4 = 0;
        for (File file : fileArr) {
            if (file.isFile()) {
                j4 += file.length();
            }
        }
        return j4;
    }

    public static List<File> a(File file, List<File> list) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(file2, list);
            } else {
                list.add(file2);
            }
        }
        return list;
    }

    public static void a(File[] fileArr, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (File file : fileArr) {
            if (file.isFile()) {
                try {
                    if (simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(file.lastModified()))).before(date)) {
                        file.delete();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public static void deleteOldFiles(Context context) {
        File[] listFiles;
        try {
            File resourceCacheDirectory = getResourceCacheDirectory(context);
            if (!resourceCacheDirectory.exists() || (listFiles = resourceCacheDirectory.listFiles()) == null) {
                return;
            }
            long a4 = a(listFiles);
            if (a4 > 524288000) {
                a(listFiles, new Date(System.currentTimeMillis() - 604800000));
                listFiles = resourceCacheDirectory.listFiles();
                a4 = a(listFiles);
            }
            int i4 = 1;
            while (a4 > 262144000) {
                a(listFiles, new Date(System.currentTimeMillis() - (((((7 / ((int) Math.pow(2.0d, i4 - 1))) * 24) * 60) * 60) * 1000)));
                listFiles = resourceCacheDirectory.listFiles();
                a4 = a(listFiles);
                i4++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File getAppRootPath(Context context) {
        return context.getFilesDir();
    }

    public static File getExternalFileDirectory(Context context) {
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    file = context.getExternalFilesDir(null);
                }
                return file == null ? context.getFilesDir() : file;
            }
            return context.getFilesDir();
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static List<File> getFileList(String str) {
        File file = new File(str);
        if (file.exists()) {
            return a(file, new ArrayList());
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0054, code lost:
        if (r0.exists() == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0056, code lost:
        r0.mkdirs();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0028, code lost:
        if (r0.exists() == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File getResourceCacheDirectory(android.content.Context r2) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L2b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r2 = r2.getCacheDir()
            java.lang.String r2 = r2.getPath()
            r0.append(r2)
            java.lang.String r2 = "/asnp/material/"
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L59
            goto L56
        L2b:
            java.io.File r0 = r2.getCacheDir()
            if (r0 != 0) goto L59
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "/data/data/"
            r0.append(r1)
            java.lang.String r2 = r2.getPackageName()
            r0.append(r2)
            java.lang.String r2 = "/cache/asnp/material/"
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L59
        L56:
            r0.mkdirs()
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.tool.utils.FileUtils.getResourceCacheDirectory(android.content.Context):java.io.File");
    }

    public static String readFileContent(File file) {
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                fileInputStream.close();
            } catch (Exception e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
            }
            return sb.toString();
        }
        return null;
    }

    public static boolean sdCardIsAvailable() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        }
        return false;
    }
}
