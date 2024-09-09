package com.baidu.idl.main.facesdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FileUitls {
    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean assetOpen(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L12
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto La
            goto L12
        La:
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Exception -> L12
            r2.open(r3)     // Catch: java.lang.Exception -> L12
            r0 = 1
        L12:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.assetOpen(android.content.Context, java.lang.String):boolean");
    }

    public static void deleteLicense(Context context, String str) {
        File file = new File(context.getFilesDir().getParent() + TTPathConst.sSeparator + str);
        if (file.exists()) {
            file.delete();
        }
        File dir = context.getDir(str, 0);
        if (dir == null || !dir.exists()) {
            return;
        }
        dir.delete();
    }

    public static boolean fileIsExists(String str) {
        try {
            if (new File(str).exists()) {
                return true;
            }
            Log.i("wtf", "file_state->file not exits");
            return false;
        } catch (Exception e4) {
            Log.i("wtf", "file_state->" + e4.getMessage());
            return false;
        }
    }

    public static File getBatchFaceDirectory(String str) {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, str);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap getBitmap(android.content.Context r1, java.lang.String r2) {
        /*
            r0 = 0
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L30
            if (r1 == 0) goto L1b
            r1.close()     // Catch: java.io.IOException -> L17
            goto L1b
        L17:
            r1 = move-exception
            r1.printStackTrace()
        L1b:
            return r2
        L1c:
            r2 = move-exception
            goto L22
        L1e:
            r2 = move-exception
            goto L32
        L20:
            r2 = move-exception
            r1 = r0
        L22:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.io.IOException -> L2b
            goto L2f
        L2b:
            r1 = move-exception
            r1.printStackTrace()
        L2f:
            return r0
        L30:
            r2 = move-exception
            r0 = r1
        L32:
            if (r0 == 0) goto L3c
            r0.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r1 = move-exception
            r1.printStackTrace()
        L3c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.getBitmap(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static byte[] getByteArrayFromAssets(Context context, String str) {
        byte[] bArr = null;
        try {
            InputStream open = context.getAssets().open(str);
            bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (IOException e4) {
            Log.e("zq", "e-->" + e4.getMessage());
            e4.printStackTrace();
            return bArr;
        }
    }

    public static File getFaceDirectory() {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, "faces");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        if (r3 == null) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 == null) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
        if (r3 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getModelContent(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            byte[] r0 = new byte[r0]
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 == 0) goto L3b
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L30 java.io.FileNotFoundException -> L38
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L30 java.io.FileNotFoundException -> L38
            int r1 = r2.available()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25 java.io.FileNotFoundException -> L27
            byte[] r0 = new byte[r1]     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25 java.io.FileNotFoundException -> L27
            r2.read(r0)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25 java.io.FileNotFoundException -> L27
            r2.close()     // Catch: java.io.IOException -> L20
        L20:
            r3 = r2
            goto L3b
        L22:
            r4 = move-exception
            r3 = r2
            goto L2a
        L25:
            r3 = r2
            goto L30
        L27:
            r3 = r2
            goto L38
        L29:
            r4 = move-exception
        L2a:
            if (r3 == 0) goto L2f
            r3.close()     // Catch: java.io.IOException -> L2f
        L2f:
            throw r4
        L30:
            if (r3 == 0) goto L3b
        L32:
            r3.close()     // Catch: java.io.IOException -> L36
            goto L3b
        L36:
            goto L3b
        L38:
            if (r3 == 0) goto L3b
            goto L32
        L3b:
            int r1 = r0.length
            if (r1 <= 0) goto L3f
            return r0
        L3f:
            android.content.res.Resources r4 = r4.getResources()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            java.io.InputStream r3 = r4.open(r5)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            int r4 = r3.available()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            byte[] r0 = new byte[r4]     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            r3.read(r0)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
        L54:
            r3.close()     // Catch: java.io.IOException -> L61
            goto L61
        L58:
            r4 = move-exception
            goto L62
        L5a:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r3 == 0) goto L61
            goto L54
        L61:
            return r0
        L62:
            if (r3 == 0) goto L67
            r3.close()     // Catch: java.io.IOException -> L67
        L67:
            goto L69
        L68:
            throw r4
        L69:
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.getModelContent(android.content.Context, java.lang.String):byte[]");
    }

    public static String getSDPath() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.toString();
        }
        return null;
    }

    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String readFile(String str) {
        File file = new File(str);
        String str2 = "";
        if (file.isDirectory()) {
            Log.d("TestFile", "The File doesn't not exist.");
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = readLine;
                }
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
                Log.d("TestFile", "The File doesn't not exist.");
            } catch (IOException e4) {
                Log.d("TestFile", e4.getMessage());
            }
        }
        return str2;
    }

    public static ArrayList<String> readLicense(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(str);
        if (file.isDirectory()) {
            Log.d("TestFile", "The File doesn't not exist.");
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
                Log.d("TestFile", "The File doesn't not exist.");
            } catch (IOException e4) {
                Log.d("TestFile", e4.getMessage());
            }
        }
        return arrayList;
    }

    public static boolean saveFile(File file, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    return true;
                } catch (Exception e5) {
                    e = e5;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }
}
