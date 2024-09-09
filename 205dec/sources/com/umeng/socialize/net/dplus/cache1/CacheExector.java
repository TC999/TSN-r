package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import android.util.Log;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CacheExector {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54120a = "CacheExector";

    /* renamed from: b  reason: collision with root package name */
    private final int f54121b = 32;

    /* renamed from: c  reason: collision with root package name */
    private final int f54122c = 5120;

    /* renamed from: d  reason: collision with root package name */
    private final int f54123d = 8;

    /* renamed from: e  reason: collision with root package name */
    private String f54124e;

    public CacheExector(String str) {
        this.f54124e = str;
    }

    private File a() {
        if (TextUtils.isEmpty(this.f54124e)) {
            Log.d(f54120a, "Couldn't create directory mDirPath is null");
            return null;
        }
        File file = new File(this.f54124e);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        String str = f54120a;
        Log.d(str, "Couldn't create directory" + this.f54124e);
        return null;
    }

    private File b(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        String[] list = file.list();
        if (list != null && list.length > 0) {
            File c4 = c(file, str);
            return c4 == null ? a(file, str) : c4;
        }
        return a(file, str);
    }

    private File c(File file, String str) {
        File[] a4 = a(file);
        if (a4 == null || a4.length <= 0 || a4.length <= 0) {
            return null;
        }
        File file2 = a4[0];
        if (a(file2.length()) > 32.0d) {
            return null;
        }
        return file2;
    }

    private File d(File file, String str) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return null;
        }
        return e(file, str);
    }

    private File e(File file, String str) {
        File[] a4 = a(file);
        if (a4 != null && a4.length > 0) {
            for (File file2 : a4) {
                if (a(file2.length()) <= 40 && file2.getName().endsWith(str)) {
                    return file2;
                }
                Log.e(f54120a, "getReadableFileFromFiles:file length don't legal" + file2.length());
                deleteFile(file2.getName());
            }
        }
        return null;
    }

    public double checkSize(String str) {
        File a4 = a();
        double d4 = 0.0d;
        if (a4 != null && a4.isDirectory()) {
            File[] listFiles = a4.listFiles();
            for (int i4 = 0; i4 < listFiles.length; i4++) {
                if (listFiles[i4] != null && listFiles[i4].getName().contains(str)) {
                    d4 += a(listFiles[i4].length());
                }
            }
        }
        return d4;
    }

    public boolean deleteFile(String str) {
        File[] listFiles = a().listFiles();
        boolean z3 = false;
        for (int i4 = 0; i4 < listFiles.length; i4++) {
            if (listFiles[i4] != null && listFiles[i4].getName().contains(str)) {
                z3 = listFiles[i4].delete();
            }
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Class, java.lang.Class<T extends com.umeng.socialize.net.dplus.cache1.IReader>] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.Closeable, java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.umeng.socialize.net.dplus.cache1.CacheExector] */
    public <T extends IReader> T readFile(String str, Class<T> cls) {
        String str2;
        FileInputStream fileInputStream;
        ?? r22;
        BufferedReader bufferedReader;
        T t3;
        int i4;
        File d4 = d(a(), str);
        Closeable closeable = null;
        if (d4 == null) {
            return null;
        }
        try {
            fileInputStream = new AtomicFile(d4).openRead();
        } catch (IOException e4) {
            str2 = UmengText.CACHE.CACHEFILE;
            SLog.error(str2, e4);
            deleteFile(d4.getName());
            fileInputStream = null;
        }
        try {
            if (fileInputStream == null) {
                return null;
            }
            try {
                t3 = (T) a(d4.getName(), cls);
                cls = (Class<T>) new InputStreamReader(fileInputStream);
            } catch (IOException e5) {
                e = e5;
                cls = 0;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                r22 = 0;
                a(fileInputStream);
                a(closeable);
                a(r22);
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(cls);
                i4 = 0;
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
                closeable = cls;
                r22 = str2;
                a(fileInputStream);
                a(closeable);
                a(r22);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    i4++;
                    Log.d(f54120a, "read file:" + i4 + readLine);
                    if (!TextUtils.isEmpty(readLine)) {
                        try {
                            sb.append(readLine);
                        } catch (Exception e7) {
                            SLog.error(UmengText.CACHE.CACHEFILE, e7);
                        }
                    }
                }
                if (t3 != null) {
                    t3.create(sb.toString());
                }
                a(fileInputStream);
                a(cls);
                a(bufferedReader);
                return t3;
            } catch (IOException e8) {
                e = e8;
                SLog.error(UmengText.CACHE.CACHEFILE, e);
                a(fileInputStream);
                a(cls);
                a(bufferedReader);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.Writer, java.io.OutputStreamWriter] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.umeng.socialize.net.dplus.cache1.CacheExector] */
    public boolean save(String str, String str2) {
        FileOutputStream fileOutputStream;
        File b4 = b(a(), str2);
        boolean z3 = false;
        if (b4 == null) {
            return false;
        }
        AtomicFile atomicFile = new AtomicFile(b4);
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = atomicFile.startWrite(true);
        } catch (IOException e4) {
            e = e4;
            SLog.error(UmengText.CACHE.CACHEFILE, e);
            deleteFile(b4.getName());
            fileOutputStream = null;
        }
        try {
            if (fileOutputStream == null) {
                return false;
            }
            try {
            } catch (IOException e5) {
                e = e5;
                e = 0;
            } catch (Throwable th) {
                th = th;
                e = 0;
            }
            if (!TextUtils.isEmpty(str)) {
                e = new OutputStreamWriter(fileOutputStream);
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(e);
                    try {
                        bufferedWriter2.write(str);
                        bufferedWriter2.newLine();
                        bufferedWriter2.flush();
                        atomicFile.finishWrite(fileOutputStream);
                        bufferedWriter = bufferedWriter2;
                        z3 = true;
                        e = e;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedWriter = bufferedWriter2;
                        atomicFile.failWrite(fileOutputStream);
                        SLog.error(UmengText.CACHE.CACHEFILE, e);
                        e = e;
                        a(bufferedWriter);
                        a(e);
                        a(fileOutputStream);
                        return z3;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        a(bufferedWriter);
                        a(e);
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                }
                a(bufferedWriter);
                a(e);
                a(fileOutputStream);
                return z3;
            }
            e = 0;
            a(bufferedWriter);
            a(e);
            a(fileOutputStream);
            return z3;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private File a(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        return new File(file, a(str));
    }

    private Comparator<File> b() {
        return new Comparator<File>() { // from class: com.umeng.socialize.net.dplus.cache1.CacheExector.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
            }
        };
    }

    private String a(String str) {
        return String.valueOf(System.currentTimeMillis()) + str;
    }

    private File[] a(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, b());
        return listFiles;
    }

    private double a(long j4) {
        if (j4 <= 0) {
            return 0.0d;
        }
        double d4 = j4;
        Double.isNaN(d4);
        return d4 / 1024.0d;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e4) {
                SLog.error(UmengText.CACHE.CACHEFILE, e4);
            }
        }
    }

    private <T extends IReader> T a(String str, Class<T> cls) {
        try {
            return cls.getConstructor(String.class).newInstance(str);
        } catch (Throwable th) {
            SLog.error(UmengText.CACHE.CACHEFILE, th);
            return null;
        }
    }
}
