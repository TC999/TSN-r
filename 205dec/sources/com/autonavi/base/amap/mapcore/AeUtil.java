package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.w5;
import com.amap.api.col.p0003l.x2;
import com.amap.api.col.p0003l.y2;
import com.autonavi.amap.mapcore.MsgProcessor;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.config.a;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AeUtil {
    private static final String AMAP_ASSETS_DB_CK_PATH = "ae/res.ck";
    private static final String AMAP_GLOBAL_DB_NAME = "global.db";
    private static final String AMAP_GLOBAL_SP_ITEM_MD5 = "amap_res_global_db_md5";
    private static final String AMAP_GLOBAL_SP_NAME = "amap_res_global_db";
    private static final String AMAP_INTERSECTION_ASSETS_DIR = "VM3DRes";
    public static final String AMAP_RESZIP_TARGET_DIR_NAME = "res920";
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    private static String global_db_path;

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.getName().contains("global.db")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String formatFileSeparator(String str) {
        return str != null ? str.replace("//", TTPathConst.sSeparator) : str;
    }

    private static String getAssetsGlobalDbMd5(Context context) {
        return new String(FileUtil.readFileContentsFromAssets(context, "ae/res.ck"));
    }

    public static String getGlobalDbPath() {
        return global_db_path;
    }

    public static void initCrashHandle(Context context) {
        p4 s3;
        try {
            if (!w5.a(a3.s()).c(context) || (s3 = a3.s()) == null) {
                return;
            }
            MsgProcessor.nativeInitInfo(context, w5.a(s3).d(context), s3.a(), s3.e(), s3.f(), s3.i());
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    public static void initIntersectionRes(final Context context, final GLMapEngine.InitParam initParam) {
        String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/VM3DRes/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        initParam.mIntersectionResPath = str;
        initParam.mIntersectionResPath = formatFileSeparator(str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                y2.a().b(new a8() { // from class: com.autonavi.base.amap.mapcore.AeUtil.2
                    @Override // com.amap.api.col.p0003l.a8
                    public final void runTask() {
                        AeUtil.loadAndSaveIntersectionRes("map_assets/VM3DRes", GLMapEngine.InitParam.this.mIntersectionResPath, context);
                    }
                });
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        loadAndSaveIntersectionRes("map_assets/VM3DRes", initParam.mIntersectionResPath, context);
    }

    public static GLMapEngine.InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/data_v6/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                y2.a().b(new a8() { // from class: com.autonavi.base.amap.mapcore.AeUtil.1
                    @Override // com.amap.api.col.p0003l.a8
                    public final void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                String str2 = new String(readFileContentsFromAssets, "utf-8");
                initParam.mConfigContent = str2;
                if (!str2.contains("data_v6")) {
                    throw new Exception("GNaviConfig.xml \u548c\u6570\u636e\u76ee\u5f55data_v6\u4e0d\u5339\u914d");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                x2.o(context, "initConfig error:" + th.getMessage());
            }
        }
        String str3 = str + "/map/";
        initParam.mOfflineDataPath = str3;
        initParam.mP3dCrossPath = str;
        initParam.mOfflineDataPath = formatFileSeparator(str3);
        initParam.mRootPath = formatFileSeparator(initParam.mRootPath);
        initParam.mP3dCrossPath = formatFileSeparator(initParam.mP3dCrossPath);
        return initParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadAndSaveIntersectionRes(String str, String str2, Context context) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String[] list = context.getAssets().list(str);
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                readAssetsFileAndSave(str + TTPathConst.sSeparator + str3, new File(str2, str3).getAbsolutePath(), context);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(1:53)(1:5)|6|(6:8|(1:10)|(1:13)|14|15|(6:23|24|(1:26)|27|29|(2:19|20)(1:22))(2:17|(0)(0)))|50|(0)|14|15|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r8.equals(r10) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00ba -> B:51:0x00da). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void loadEngineRes(java.lang.String r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "loadEngineRes error:"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "res920"
            r1.<init>(r10, r2)
            boolean r10 = r1.exists()
            r2 = 1
            r3 = 0
            r4 = 0
            if (r10 == 0) goto L18
            boolean r10 = r1.isDirectory()
            if (r10 != 0) goto L24
        L18:
            boolean r10 = r1.mkdirs()
            if (r10 == 0) goto L24
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            r5 = 1
            goto L26
        L24:
            r10 = r4
            r5 = 0
        L26:
            java.lang.String r6 = "amap_res_global_db_md5"
            java.lang.String r7 = "amap_res_global_db"
            if (r5 != 0) goto L43
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            java.lang.String r8 = ""
            java.lang.String r8 = com.amap.api.col.p0003l.q2.b(r11, r7, r6, r8)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L44
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L43
            goto L44
        L43:
            r2 = r5
        L44:
            if (r2 == 0) goto L47
            goto L4b
        L47:
            boolean r3 = checkEngineRes(r1)
        L4b:
            java.lang.String r5 = "/global.db"
            if (r3 != 0) goto Lc9
            android.content.res.AssetManager r3 = r11.getAssets()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.String r8 = "ae/res.zip"
            java.io.InputStream r4 = r3.open(r8)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.String r3 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            com.autonavi.base.amap.mapcore.FileUtil.decompress(r4, r3)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            r3.append(r1)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            r3.append(r5)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r1     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            if (r4 == 0) goto Lda
            r4.close()     // Catch: java.io.IOException -> Lb9
            goto Lda
        L77:
            r10 = move-exception
            goto Lbe
        L79:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.a3.D(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            r3.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.x2.o(r11, r0)     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto Lda
            r4.close()     // Catch: java.io.IOException -> Lb9
            goto Lda
        L99:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.a3.D(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            r3.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.x2.o(r11, r0)     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto Lda
            r4.close()     // Catch: java.io.IOException -> Lb9
            goto Lda
        Lb9:
            r0 = move-exception
            r0.printStackTrace()
            goto Lda
        Lbe:
            if (r4 == 0) goto Lc8
            r4.close()     // Catch: java.io.IOException -> Lc4
            goto Lc8
        Lc4:
            r11 = move-exception
            r11.printStackTrace()
        Lc8:
            throw r10
        Lc9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r0
        Lda:
            if (r2 == 0) goto Ldf
            com.amap.api.col.p0003l.q2.c(r11, r7, r6, r10)
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.AeUtil.loadEngineRes(java.lang.String, android.content.Context):void");
    }

    public static boolean loadLib(Context context) {
        try {
            if (!a.f12060b) {
                System.loadLibrary(a.f12059a);
                a.f12060b = true;
            }
            return true;
        } catch (Throwable th) {
            u5.p(th, "AeUtil", "loadLib");
            a3.D(th);
            String str = b3.f7206c;
            c3.l(str, "load so failed " + th.getMessage());
            return false;
        }
    }

    public static void readAssetsFileAndSave(String str, String str2, Context context) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fileOutputStream2 = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                inputStream = open;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr, 0, 1024);
                    if (read > 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                open.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } catch (Throwable th2) {
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                th = th2;
                try {
                    th.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }
}
