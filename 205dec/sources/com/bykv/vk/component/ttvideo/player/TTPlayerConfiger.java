package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.plugin.w;
import com.stub.StubApp;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class TTPlayerConfiger {
    private static String APP_PATH = null;
    private static String CRASH_FILE_NAME = "ttplayer_crash.log";
    private static String CRASH_FILE_PATH = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_POOL_STACK_SIZE = 32;
    public static final int FALSE = 0;
    public static boolean IS_PRINT_INFO = false;
    public static final int IS_TIME_OUT_COUNT = 3;
    private static final SparseArray<Value> KEYS = new SparseArray<>();
    public static final int KEY_IS_BATTERY_INFO = 23;
    public static final int KEY_IS_CHECK_LIB = 3;
    public static final int KEY_IS_CHECK_TTPLAYER_MODEL = 0;
    public static final int KEY_IS_CRASHED = 7;
    public static final int KEY_IS_CRASH_FILE_NAME = 17;
    public static final int KEY_IS_CRASH_PATH = 19;
    public static final int KEY_IS_DEBUG_MODEL = 6;
    public static final int KEY_IS_FORBID_CREATED_OS_PLAYER = 11;
    public static final int KEY_IS_FOREGROUND = 21;
    public static final int KEY_IS_IPTTPLAYER_ON = 2;
    public static final int KEY_IS_LOG_FILE_DIR = 20;
    public static final int KEY_IS_ON_SCREEN = 22;
    public static final int KEY_IS_OPEN_DEVICE_FAIL = 8;
    public static final int KEY_IS_PORT_VERSION = 18;
    public static final int KEY_IS_PRINT_INFO = 5;
    public static final int KEY_IS_SDK_VERSION = 13;
    public static final int KEY_IS_SDK_VERSION_INFO = 15;
    public static final int KEY_IS_SDK_VERSION_NAME = 14;
    public static final int KEY_IS_START_SERVICE = 16;
    public static final int KEY_IS_STOP_SERVICE = 12;
    public static final int KEY_IS_THREAD_POOL_STACK_SIZE = 25;
    public static final int KEY_IS_THROW_CRASH = 4;
    public static final int KEY_IS_TIMEOUT_COUNT = 10;
    public static final int KEY_IS_TTPLAYER_ON = 1;
    public static final int KEY_IS_USED_THREAD_POOL = 24;
    private static String LIBRARY_DIR = null;
    private static String PLAYER_LIBRARY_NAME = "libttmplayer_lite.so";
    private static final int PORT_VERSION = 2;
    public static final String TAG = "ttplayer";
    public static final int TRUE = 1;
    private static String TTPLAYER_FILE_CACHE_DIR = null;
    private static final int VERSION = 1;
    private static final String VERSION_INFO = "version code:1,name:999.999.999.9default sdk info 2016-12-05";
    private static final String VERSION_NAME = "999.999.999.9";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class IntValue extends Value {
        private int mValue;

        public IntValue(int i4, int i5) {
            super(i4);
            this.mValue = i5;
        }

        public int getValue() {
            return this.mValue;
        }

        public void setValue(int i4) {
            this.mValue = i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class LongValue extends Value {
        private long mValue;

        public LongValue(int i4, long j4) {
            super(i4);
            this.mValue = j4;
        }

        public long getValue() {
            return this.mValue;
        }

        public void setValue(long j4) {
            this.mValue = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class StringValue extends Value {
        private String mValue;

        public StringValue(int i4, String str) {
            super(i4);
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }

        public void setValue(String str) {
            this.mValue = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class Value {
        private int mKey;

        protected Value(int i4) {
            this.mKey = i4;
        }

        public int getKey() {
            return this.mKey;
        }
    }

    static {
        setValue(13, 1);
        setValue(14, VERSION_NAME);
        setValue(15, VERSION_INFO);
        setValue(0, false);
        setValue(1, true);
        setValue(2, true);
        setValue(3, false);
        setValue(4, false);
        setValue(5, false);
        setValue(6, false);
        setValue(7, false);
        setValue(8, false);
        setValue(10, 0);
        setValue(11, false);
        setValue(18, 2);
        setValue(25, 32);
    }

    public static void checkDebugTTPlayerLib() {
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0088 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #10 {IOException -> 0x0084, blocks: (B:44:0x0080, B:48:0x0088), top: B:80:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean copyFile(java.lang.String r4, java.lang.String r5, boolean r6, boolean r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto Ld
            return r1
        Ld:
            boolean r5 = r0.isFile()
            if (r5 != 0) goto L14
            return r1
        L14:
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            boolean r2 = r5.exists()
            if (r2 == 0) goto L2a
            if (r6 == 0) goto L3f
            java.io.File r6 = new java.io.File
            r6.<init>(r4)
            r6.delete()
            goto L3f
        L2a:
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.exists()
            if (r4 != 0) goto L3f
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L3f
            return r1
        L3f:
            r4 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L90 java.io.FileNotFoundException -> La3
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L90 java.io.FileNotFoundException -> La3
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L91 java.io.FileNotFoundException -> La4
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L91 java.io.FileNotFoundException -> La4
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
        L4e:
            int r5 = r6.read(r4)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            r3 = -1
            if (r5 == r3) goto L59
            r2.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            goto L4e
        L59:
            r2.close()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            r6.close()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            if (r7 == 0) goto L64
            r0.delete()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
        L64:
            r4 = 1
            r2.close()     // Catch: java.io.IOException -> L6c
            r6.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r5 = move-exception
            r5.printStackTrace()
        L70:
            return r4
        L71:
            r4 = move-exception
            goto L7e
        L73:
            r4 = r2
            goto L91
        L75:
            r4 = r2
            goto La4
        L77:
            r5 = move-exception
            r2 = r4
            goto L7d
        L7a:
            r5 = move-exception
            r6 = r4
            r2 = r6
        L7d:
            r4 = r5
        L7e:
            if (r2 == 0) goto L86
            r2.close()     // Catch: java.io.IOException -> L84
            goto L86
        L84:
            r5 = move-exception
            goto L8c
        L86:
            if (r6 == 0) goto L8f
            r6.close()     // Catch: java.io.IOException -> L84
            goto L8f
        L8c:
            r5.printStackTrace()
        L8f:
            throw r4
        L90:
            r6 = r4
        L91:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L97
            goto L99
        L97:
            r4 = move-exception
            goto L9f
        L99:
            if (r6 == 0) goto La2
            r6.close()     // Catch: java.io.IOException -> L97
            goto La2
        L9f:
            r4.printStackTrace()
        La2:
            return r1
        La3:
            r6 = r4
        La4:
            if (r4 == 0) goto Lac
            r4.close()     // Catch: java.io.IOException -> Laa
            goto Lac
        Laa:
            r4 = move-exception
            goto Lb2
        Lac:
            if (r6 == 0) goto Lb5
            r6.close()     // Catch: java.io.IOException -> Laa
            goto Lb5
        Lb2:
            r4.printStackTrace()
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.TTPlayerConfiger.copyFile(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    @Deprecated
    public static final String getAppCrashFilePath(Context context) {
        if (CRASH_FILE_PATH == null && !new File(getAppCrashFileStorePath(context)).exists()) {
            return APP_PATH + File.separatorChar + "plugins" + File.separatorChar + "com.bykv.vk.component.ttvideo" + File.separatorChar + "data" + File.separatorChar + "files" + File.separatorChar + CRASH_FILE_NAME;
        }
        if (isPrintInfo()) {
            Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,278>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    public static final String getAppCrashFilePath2(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = w.c(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath();
        }
        if (CRASH_FILE_PATH == null) {
            if (APP_PATH == null) {
                APP_PATH = getAppFilesPath(context);
            }
            if (isPrintInfo()) {
                Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFilePath2,211>app files path:" + APP_PATH);
            }
            if (APP_PATH != null) {
                return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
            }
            return null;
        }
        if (isPrintInfo()) {
            Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,195>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    @Deprecated
    public static final String getAppCrashFileStorePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = w.c(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath();
        }
        if (CRASH_FILE_PATH == null) {
            if (APP_PATH == null) {
                APP_PATH = getAppFilesPath(context);
            }
            if (isPrintInfo()) {
                Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,245>app files path:" + APP_PATH);
            }
            if (APP_PATH != null) {
                return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
            }
            return null;
        }
        if (isPrintInfo()) {
            Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,253>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    public static final String getAppFileCachePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = w.c(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath();
        }
        String str = TTPLAYER_FILE_CACHE_DIR;
        if (str != null) {
            return str;
        }
        String str2 = APP_PATH;
        if (str2 != null) {
            return str2;
        }
        if (context == null) {
            return null;
        }
        try {
            String absolutePath = w.c(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath();
            APP_PATH = absolutePath;
            return absolutePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getAppFilesPath(Context context) {
        String str = APP_PATH;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return null;
        }
        try {
            String absolutePath = w.c(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath();
            APP_PATH = absolutePath;
            return absolutePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getExternalStorageDirectoryCrashFilePath() {
        return null;
    }

    public static String getPlayerLibraryPath(Context context) {
        if (APP_PATH == null || context != null) {
            APP_PATH = getAppFilesPath(context);
        }
        if (APP_PATH == null && LIBRARY_DIR == null) {
            return null;
        }
        String str = LIBRARY_DIR;
        if (str != null) {
            if (str.endsWith(String.valueOf(File.separatorChar))) {
                return LIBRARY_DIR + PLAYER_LIBRARY_NAME;
            }
            return LIBRARY_DIR + File.separatorChar + PLAYER_LIBRARY_NAME;
        }
        return APP_PATH + File.separatorChar + PLAYER_LIBRARY_NAME;
    }

    public static String getPlayerLibrarysDir(Context context) {
        String str = LIBRARY_DIR;
        if (str == null) {
            String str2 = getAppFilesPath(context) + File.separatorChar;
            LIBRARY_DIR = str2;
            return str2;
        } else if (str.endsWith(String.valueOf(File.separatorChar))) {
            return LIBRARY_DIR;
        } else {
            return LIBRARY_DIR + File.separatorChar;
        }
    }

    public static final String getPlugerCrashFilePath(Context context) {
        return APP_PATH + File.separatorChar + "plugins" + File.separatorChar + "com.bykv.vk.component.ttvideo" + File.separatorChar + "data" + File.separatorChar + "files" + File.separatorChar + CRASH_FILE_NAME;
    }

    public static final String getValue(int i4, String str) {
        if (i4 == 17) {
            return CRASH_FILE_NAME;
        }
        Value value = KEYS.get(i4);
        return (value == null || !(value instanceof StringValue)) ? str : ((StringValue) value).getValue();
    }

    public static final int getVersion() {
        return 1;
    }

    public static final boolean isOnTTPlayer() {
        if (getValue(6, 0) == 1) {
            return true;
        }
        if (getValue(1, 0) == 0) {
            return false;
        }
        if (getValue(11, 0) == 1) {
            return true;
        }
        return (getValue(7, 0) == 1 || getValue(8, 0) == 1 || getValue(10, 0) >= 3) ? false : true;
    }

    public static boolean isPrintInfo() {
        return IS_PRINT_INFO;
    }

    public static final boolean moveFile(String str, String str2, boolean z3) {
        return copyFile(str, str2, z3, true);
    }

    public static final void setCrashFileName(String str) {
        CRASH_FILE_NAME = str;
    }

    public static final void setCrashFilePath(String str) {
        CRASH_FILE_PATH = str;
    }

    public static final void setLibraryName(String str) {
        PLAYER_LIBRARY_NAME = str;
    }

    public static final void setLibrarysDir(String str) {
        LIBRARY_DIR = str;
    }

    public static final void setValue(int i4, boolean z3) {
        setValue(i4, z3 ? 1 : 0);
    }

    public static final void setValue(int i4, int i5) {
        SparseArray<Value> sparseArray = KEYS;
        Value value = sparseArray.get(i4);
        if (value != null) {
            if (value instanceof IntValue) {
                if (i4 == 2 && getValue(6, false)) {
                    return;
                }
                ((IntValue) value).setValue(i5);
                return;
            }
            sparseArray.remove(i4);
        }
        sparseArray.append(i4, new IntValue(i4, i5));
    }

    public static final boolean getValue(int i4, boolean z3) {
        Value value = KEYS.get(i4);
        return (value == null || !(value instanceof IntValue)) ? z3 : ((IntValue) value).getValue() == 1;
    }

    public static final int getValue(int i4, int i5) {
        Value value = KEYS.get(i4);
        return (value == null || !(value instanceof IntValue)) ? i5 : ((IntValue) value).getValue();
    }

    public static String getPlayerLibraryPath() {
        return getPlayerLibraryPath(null);
    }

    public static final void setValue(int i4, long j4) {
        SparseArray<Value> sparseArray = KEYS;
        Value value = sparseArray.get(i4);
        if (value != null) {
            if (value instanceof LongValue) {
                ((LongValue) value).setValue(j4);
                return;
            }
            sparseArray.remove(i4);
        }
        sparseArray.append(i4, new LongValue(i4, j4));
    }

    public static final long getValue(int i4, long j4) {
        Value value = KEYS.get(i4);
        return (value == null || !(value instanceof LongValue)) ? j4 : ((LongValue) value).getValue();
    }

    public static final void setValue(int i4, String str) {
        SparseArray<Value> sparseArray = KEYS;
        Value value = sparseArray.get(i4);
        if (value != null) {
            if (value instanceof StringValue) {
                ((StringValue) value).setValue(str);
                return;
            }
            sparseArray.remove(i4);
        }
        sparseArray.append(i4, new StringValue(i4, str));
    }
}
