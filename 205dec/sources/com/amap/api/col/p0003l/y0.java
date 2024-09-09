package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: UnZipFile.java */
/* renamed from: com.amap.api.col.3l.y0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    private c f9504a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9506a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f9507a;

        /* renamed from: b  reason: collision with root package name */
        private String f9508b;

        /* renamed from: c  reason: collision with root package name */
        private u0 f9509c;

        /* renamed from: d  reason: collision with root package name */
        private b f9510d = new b();

        /* renamed from: e  reason: collision with root package name */
        private String f9511e;

        public c(v0 v0Var, u0 u0Var) {
            this.f9509c = null;
            this.f9507a = v0Var.x();
            this.f9508b = v0Var.y();
            this.f9509c = u0Var;
        }

        public final String a() {
            return this.f9507a;
        }

        public final void b(String str) {
            if (str.length() > 1) {
                this.f9511e = str;
            }
        }

        public final String c() {
            return this.f9508b;
        }

        public final String d() {
            return this.f9511e;
        }

        public final u0 e() {
            return this.f9509c;
        }

        public final b f() {
            return this.f9510d;
        }

        public final void g() {
            this.f9510d.f9506a = true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface d {
        void a();

        void a(long j4);
    }

    public y0(v0 v0Var, u0 u0Var) {
        this.f9504a = new c(v0Var, u0Var);
    }

    private static int a(File file, ZipInputStream zipInputStream, long j4, long j5, d dVar, b bVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i4 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                if (bVar != null && bVar.f9506a) {
                    bufferedOutputStream.close();
                    return i4;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i4 += read;
                if (j5 > 0 && dVar != null) {
                    long j6 = ((i4 + j4) * 100) / j5;
                    if (bVar == null || !bVar.f9506a) {
                        dVar.a(j6);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i4;
            }
        }
    }

    private static void c(c cVar) {
        if (cVar == null) {
            return;
        }
        u0 e4 = cVar.e();
        if (e4 != null) {
            e4.p();
        }
        String a4 = cVar.a();
        String c4 = cVar.c();
        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(c4)) {
            File file = new File(a4);
            if (!file.exists()) {
                if (cVar.f().f9506a) {
                    if (e4 != null) {
                        e4.r();
                        return;
                    }
                    return;
                } else if (e4 != null) {
                    e4.q();
                    return;
                } else {
                    return;
                }
            }
            File file2 = new File(c4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            a aVar = new a(e4);
            try {
                if (cVar.f().f9506a && e4 != null) {
                    e4.r();
                }
                e(file, file2, aVar, cVar);
                if (cVar.f().f9506a) {
                    if (e4 != null) {
                        e4.r();
                    }
                } else if (e4 != null) {
                    e4.b(cVar.d());
                }
            } catch (Throwable unused) {
                if (cVar.f().f9506a) {
                    if (e4 != null) {
                        e4.r();
                    }
                } else if (e4 != null) {
                    e4.q();
                }
            }
        } else if (cVar.f().f9506a) {
            if (e4 != null) {
                e4.r();
            }
        } else if (e4 != null) {
            e4.q();
        }
    }

    private static void d(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        d(parentFile);
        parentFile.mkdir();
    }

    private static void e(File file, File file2, d dVar, c cVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        b f4 = cVar.f();
        long j4 = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (f4 != null && f4.f9506a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!g(nextEntry.getName())) {
                            dVar.a();
                            break;
                        } else {
                            stringBuffer.append(nextEntry.getName());
                            stringBuffer.append(";");
                        }
                    }
                    j4 += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            cVar.b(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        f(file2, zipInputStream2, j4, dVar, f4);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void f(File file, ZipInputStream zipInputStream, long j4, d dVar, b bVar) throws Exception {
        int i4 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (bVar != null && bVar.f9506a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!g(nextEntry.getName())) {
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            File file2 = new File(str);
            d(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                i4 += a(file2, zipInputStream, i4, j4, dVar, bVar);
            }
            zipInputStream.closeEntry();
        }
    }

    private static boolean g(String str) {
        return (str.contains("..") || str.contains(TTPathConst.sSeparator) || str.contains("\\") || str.contains("%")) ? false : true;
    }

    public final void b() {
        c cVar = this.f9504a;
        if (cVar != null) {
            cVar.g();
        }
    }

    public final void h() {
        c cVar = this.f9504a;
        if (cVar != null) {
            c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u0 f9505a;

        a(u0 u0Var) {
            this.f9505a = u0Var;
        }

        @Override // com.amap.api.col.p0003l.y0.d
        public final void a(long j4) {
            try {
                u0 u0Var = this.f9505a;
                if (u0Var != null) {
                    u0Var.a(j4);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.amap.api.col.p0003l.y0.d
        public final void a() {
            u0 u0Var = this.f9505a;
            if (u0Var != null) {
                u0Var.q();
            }
        }
    }
}
