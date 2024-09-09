package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    static {
        System.loadLibrary("ipneigh-android");
    }

    KwaiIpNeigh() {
    }

    private static boolean aB(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\s+");
        if (split.length < 2) {
            return false;
        }
        return split[0].equals(str2);
    }

    private static native int getARPTableFromJni(int i4);

    private static native int getARPTableFromJni2(int i4);

    public static String i(String str, boolean z3) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        int detachFd;
        String readLine;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
            ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
            autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            detachFd = parcelFileDescriptor2.detachFd();
        } catch (Throwable th) {
            th.printStackTrace();
            String str2 = TAG;
            Log.e(str2, "getARPResult exception:" + th.getMessage());
        }
        if ((z3 ? getARPTableFromJni2(detachFd) : getARPTableFromJni(detachFd)) != 0) {
            Log.e(TAG, "ARP table reading failed, are you using targetSdk 32 and an Android 13 device?");
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                return "";
            }
        } while (!aB(readLine, str));
        return readLine;
    }
}
