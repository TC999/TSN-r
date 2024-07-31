package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    static {
        System.loadLibrary("ipneigh-android");
    }

    KwaiIpNeigh() {
    }

    /* renamed from: aB */
    private static boolean m23486aB(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\s+");
        if (split.length < 2) {
            return false;
        }
        return split[0].equals(str2);
    }

    private static native int getARPTableFromJni(int i);

    private static native int getARPTableFromJni2(int i);

    /* renamed from: i */
    public static String m23485i(String str, boolean z) {
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
        if ((z ? getARPTableFromJni2(detachFd) : getARPTableFromJni(detachFd)) != 0) {
            Log.e(TAG, "ARP table reading failed, are you using targetSdk 32 and an Android 13 device?");
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                return "";
            }
        } while (!m23486aB(readLine, str));
        return readLine;
    }
}
