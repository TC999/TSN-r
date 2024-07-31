package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import android.util.Log;
import com.github.mikephil.charting.utils.Utils;
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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CacheExector {

    /* renamed from: a */
    private static final String f39545a = "CacheExector";

    /* renamed from: b */
    private final int f39546b = 32;

    /* renamed from: c */
    private final int f39547c = 5120;

    /* renamed from: d */
    private final int f39548d = 8;

    /* renamed from: e */
    private String f39549e;

    public CacheExector(String str) {
        this.f39549e = str;
    }

    /* renamed from: a */
    private File m13254a() {
        if (TextUtils.isEmpty(this.f39549e)) {
            Log.d(f39545a, "Couldn't create directory mDirPath is null");
            return null;
        }
        File file = new File(this.f39549e);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        String str = f39545a;
        Log.d(str, "Couldn't create directory" + this.f39549e);
        return null;
    }

    /* renamed from: b */
    private File m13246b(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        String[] list = file.list();
        if (list != null && list.length > 0) {
            File m13245c = m13245c(file, str);
            return m13245c == null ? m13250a(file, str) : m13245c;
        }
        return m13250a(file, str);
    }

    /* renamed from: c */
    private File m13245c(File file, String str) {
        File[] m13251a = m13251a(file);
        if (m13251a == null || m13251a.length <= 0 || m13251a.length <= 0) {
            return null;
        }
        File file2 = m13251a[0];
        if (m13253a(file2.length()) > 32.0d) {
            return null;
        }
        return file2;
    }

    /* renamed from: d */
    private File m13244d(File file, String str) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return null;
        }
        return m13243e(file, str);
    }

    /* renamed from: e */
    private File m13243e(File file, String str) {
        File[] m13251a = m13251a(file);
        if (m13251a != null && m13251a.length > 0) {
            for (File file2 : m13251a) {
                if (m13253a(file2.length()) <= 40 && file2.getName().endsWith(str)) {
                    return file2;
                }
                Log.e(f39545a, "getReadableFileFromFiles:file length don't legal" + file2.length());
                deleteFile(file2.getName());
            }
        }
        return null;
    }

    public double checkSize(String str) {
        File m13254a = m13254a();
        double d = Utils.DOUBLE_EPSILON;
        if (m13254a != null && m13254a.isDirectory()) {
            File[] listFiles = m13254a.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i] != null && listFiles[i].getName().contains(str)) {
                    d += m13253a(listFiles[i].length());
                }
            }
        }
        return d;
    }

    public boolean deleteFile(String str) {
        File[] listFiles = m13254a().listFiles();
        boolean z = false;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i] != null && listFiles[i].getName().contains(str)) {
                z = listFiles[i].delete();
            }
        }
        return z;
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
        ?? r2;
        BufferedReader bufferedReader;
        T t;
        int i;
        File m13244d = m13244d(m13254a(), str);
        Closeable closeable = null;
        if (m13244d == null) {
            return null;
        }
        try {
            fileInputStream = new AtomicFile(m13244d).openRead();
        } catch (IOException e) {
            str2 = UmengText.CACHE.CACHEFILE;
            SLog.error(str2, e);
            deleteFile(m13244d.getName());
            fileInputStream = null;
        }
        try {
            if (fileInputStream == null) {
                return null;
            }
            try {
                t = (T) m13248a(m13244d.getName(), cls);
                cls = (Class<T>) new InputStreamReader(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                cls = 0;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                r2 = 0;
                m13252a(fileInputStream);
                m13252a(closeable);
                m13252a(r2);
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(cls);
                i = 0;
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
                closeable = cls;
                r2 = str2;
                m13252a(fileInputStream);
                m13252a(closeable);
                m13252a(r2);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    i++;
                    Log.d(f39545a, "read file:" + i + readLine);
                    if (!TextUtils.isEmpty(readLine)) {
                        try {
                            sb.append(readLine);
                        } catch (Exception e4) {
                            SLog.error(UmengText.CACHE.CACHEFILE, e4);
                        }
                    }
                }
                if (t != null) {
                    t.create(sb.toString());
                }
                m13252a(fileInputStream);
                m13252a(cls);
                m13252a(bufferedReader);
                return t;
            } catch (IOException e5) {
                e = e5;
                SLog.error(UmengText.CACHE.CACHEFILE, e);
                m13252a(fileInputStream);
                m13252a(cls);
                m13252a(bufferedReader);
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
        File m13246b = m13246b(m13254a(), str2);
        boolean z = false;
        if (m13246b == null) {
            return false;
        }
        AtomicFile atomicFile = new AtomicFile(m13246b);
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = atomicFile.startWrite(true);
        } catch (IOException e) {
            e = e;
            SLog.error(UmengText.CACHE.CACHEFILE, e);
            deleteFile(m13246b.getName());
            fileOutputStream = null;
        }
        try {
            if (fileOutputStream == null) {
                return false;
            }
            try {
            } catch (IOException e2) {
                e = e2;
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
                        z = true;
                        e = e;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        atomicFile.failWrite(fileOutputStream);
                        SLog.error(UmengText.CACHE.CACHEFILE, e);
                        e = e;
                        m13252a(bufferedWriter);
                        m13252a(e);
                        m13252a(fileOutputStream);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        m13252a(bufferedWriter);
                        m13252a(e);
                        m13252a(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
                m13252a(bufferedWriter);
                m13252a(e);
                m13252a(fileOutputStream);
                return z;
            }
            e = 0;
            m13252a(bufferedWriter);
            m13252a(e);
            m13252a(fileOutputStream);
            return z;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    private File m13250a(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        return new File(file, m13249a(str));
    }

    /* renamed from: b */
    private Comparator<File> m13247b() {
        return new Comparator<File>() { // from class: com.umeng.socialize.net.dplus.cache1.CacheExector.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
            }
        };
    }

    /* renamed from: a */
    private String m13249a(String str) {
        return String.valueOf(System.currentTimeMillis()) + str;
    }

    /* renamed from: a */
    private File[] m13251a(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, m13247b());
        return listFiles;
    }

    /* renamed from: a */
    private double m13253a(long j) {
        if (j <= 0) {
            return Utils.DOUBLE_EPSILON;
        }
        double d = j;
        Double.isNaN(d);
        return d / 1024.0d;
    }

    /* renamed from: a */
    private void m13252a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                SLog.error(UmengText.CACHE.CACHEFILE, e);
            }
        }
    }

    /* renamed from: a */
    private <T extends IReader> T m13248a(String str, Class<T> cls) {
        try {
            return cls.getConstructor(String.class).newInstance(str);
        } catch (Throwable th) {
            SLog.error(UmengText.CACHE.CACHEFILE, th);
            return null;
        }
    }
}
