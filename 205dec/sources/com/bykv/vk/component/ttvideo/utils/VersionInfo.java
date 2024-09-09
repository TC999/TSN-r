package com.bykv.vk.component.ttvideo.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class VersionInfo {
    private static String[] mVersion;

    public static String[] getVersion() {
        FileReader fileReader;
        if (mVersion == null) {
            String[] strArr = {"null", "null", "null", "null"};
            BufferedReader bufferedReader = null;
            try {
                try {
                    fileReader = new FileReader("/proc/version");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                        try {
                            strArr[0] = bufferedReader2.readLine().split("\\s+")[2];
                            bufferedReader2.close();
                            fileReader.close();
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            strArr[1] = Build.VERSION.RELEASE;
                            strArr[2] = Build.MODEL;
                            strArr[3] = Build.DISPLAY;
                            mVersion = strArr;
                            return mVersion;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    fileReader = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            mVersion = strArr;
        }
        return mVersion;
    }
}
