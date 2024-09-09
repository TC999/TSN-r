package com.bykv.vk.component.ttvideo.player;

import android.annotation.SuppressLint;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTPlayerLibLoader {
    private static final int DEGRADED_VERSION = 2925;
    private static final String TAG = "TTPlayerLibLoader";
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mLibraryLoader;
    private static ILibraryLoader mDefaultLibLoader = new DefaultLibraryLoader();
    private static boolean mLibraryLoaded = false;
    private static boolean IsErrored = false;
    private static String mErrorInfo = null;
    private static int mVersion = 0;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class DefaultLibraryLoader implements ILibraryLoader {
        private DefaultLibraryLoader() {
        }

        @Override // com.bykv.vk.component.ttvideo.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    System.loadLibrary(str);
                    String str2 = TTPlayerLibLoader.TAG;
                    Log.d(str2, "load " + str + " done");
                } catch (Throwable th) {
                    String unused = TTPlayerLibLoader.mErrorInfo = th.getMessage();
                    String str3 = TTPlayerLibLoader.TAG;
                    Log.d(str3, "load lib failed = " + str + ",error:" + TTPlayerLibLoader.mErrorInfo);
                    return false;
                }
            }
            return true;
        }
    }

    public static String getErrorInfo() {
        return mErrorInfo;
    }

    public static boolean isError() {
        return IsErrored;
    }

    public static final synchronized void loadLibrary() {
        synchronized (TTPlayerLibLoader.class) {
            try {
                if (mVersion == 0) {
                    mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;
                }
                int i4 = mVersion;
                if (TTPlayerConfiger.getValue(3, false)) {
                    if (!loadPlayerlibrary("ttmplayer_lite")) {
                        IsErrored = true;
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("ttmplayer_lite");
                    IsErrored = loadLibs(arrayList, false) ? false : true;
                }
            } catch (Throwable th) {
                IsErrored = true;
                th.printStackTrace();
                mErrorInfo = "load default library error." + th.toString();
            }
        }
    }

    private static boolean loadLibs(List<String> list, boolean z3) {
        boolean z4 = mLibraryLoaded;
        if ((!z3) && z4) {
            return z4;
        }
        ILibraryLoader iLibraryLoader = mLibraryLoader;
        if (iLibraryLoader != null) {
            try {
                mLibraryLoaded = iLibraryLoader.onLoadNativeLibs(list);
            } catch (Throwable th) {
                mErrorInfo = th.getMessage();
            }
        } else {
            mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(list);
        }
        return mLibraryLoaded;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static boolean loadPlayerlibrary(String str) {
        String str2;
        try {
            TTPlayerConfiger.setLibraryName("lib" + str + ".so");
            TTPlayerConfiger.checkDebugTTPlayerLib();
            str2 = TTPlayerConfiger.getPlayerLibraryPath();
            if (str2 != null && !new File(str2).exists()) {
                str2 = null;
            }
            if (str2 != null) {
                if (mDebugLibraryLoader != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    Log.d(TAG, "load library path = " + str2);
                    mDebugLibraryLoader.onLoadNativeLibs(arrayList);
                } else {
                    System.load(str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            mErrorInfo = "load path library error." + th.toString();
            str2 = null;
        }
        if (str2 == null) {
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                loadLibs(arrayList2, true);
                mErrorInfo = null;
            } catch (Throwable unused) {
                Log.e(TAG, "load lib failed name = " + str);
                return false;
            }
        }
        return true;
    }

    public static final void setDebugLibraryLoader(ILibraryLoader iLibraryLoader) {
        mDebugLibraryLoader = iLibraryLoader;
    }

    public static final void setLibraryLoader(ILibraryLoader iLibraryLoader) {
        mLibraryLoader = iLibraryLoader;
    }
}
