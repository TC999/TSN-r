package com.bykv.vk.component.ttvideo;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.log.MyLog;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private static Loader sLoader;

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public interface Loader {
        void loadLibrary(String str) throws Exception;

        void loadLibraryFromPath(String str) throws Exception;
    }

    public static void loadLibrary(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        if (loader != null) {
            String str2 = TAG;
            MyLog.d(str2, "Loading [" + str + "] with external loader " + loader);
            loader.loadLibrary(str);
            return;
        }
        System.loadLibrary(str);
    }

    public static void loadLibraryFromPath(String str) throws Exception {
        Loader loader = sLoader;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                throw new Exception("Not found library '" + str + "' file.");
            } else if (loader != null) {
                String str2 = TAG;
                MyLog.d(str2, "Loading [" + file.getAbsolutePath() + "] with external loader " + loader);
                loader.loadLibraryFromPath(file.getAbsolutePath());
                return;
            } else {
                System.load(file.getAbsolutePath());
                return;
            }
        }
        throw new Exception("Invalid library name.");
    }

    public static void setupLibraryLoader(Loader loader) {
        sLoader = loader;
    }
}
