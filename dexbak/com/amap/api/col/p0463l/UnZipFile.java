package com.amap.api.col.p0463l;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.amap.api.col.3l.y0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class UnZipFile {

    /* renamed from: a */
    private C2004c f5772a;

    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2003b {

        /* renamed from: a */
        public boolean f5774a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2004c {

        /* renamed from: a */
        private String f5775a;

        /* renamed from: b */
        private String f5776b;

        /* renamed from: c */
        private IUnZipListener f5777c;

        /* renamed from: d */
        private C2003b f5778d = new C2003b();

        /* renamed from: e */
        private String f5779e;

        public C2004c(IUnzipItem iUnzipItem, IUnZipListener iUnZipListener) {
            this.f5777c = null;
            this.f5775a = iUnzipItem.mo53672x();
            this.f5776b = iUnzipItem.mo53671y();
            this.f5777c = iUnZipListener;
        }

        /* renamed from: a */
        public final String m53423a() {
            return this.f5775a;
        }

        /* renamed from: b */
        public final void m53422b(String str) {
            if (str.length() > 1) {
                this.f5779e = str;
            }
        }

        /* renamed from: c */
        public final String m53421c() {
            return this.f5776b;
        }

        /* renamed from: d */
        public final String m53420d() {
            return this.f5779e;
        }

        /* renamed from: e */
        public final IUnZipListener m53419e() {
            return this.f5777c;
        }

        /* renamed from: f */
        public final C2003b m53418f() {
            return this.f5778d;
        }

        /* renamed from: g */
        public final void m53417g() {
            this.f5778d.f5774a = true;
        }
    }

    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2005d {
        /* renamed from: a */
        void mo53416a();

        /* renamed from: a */
        void mo53415a(long j);
    }

    public UnZipFile(IUnzipItem iUnzipItem, IUnZipListener iUnZipListener) {
        this.f5772a = new C2004c(iUnzipItem, iUnZipListener);
    }

    /* renamed from: a */
    private static int m53431a(File file, ZipInputStream zipInputStream, long j, long j2, InterfaceC2005d interfaceC2005d, C2003b c2003b) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                if (c2003b != null && c2003b.f5774a) {
                    bufferedOutputStream.close();
                    return i;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && interfaceC2005d != null) {
                    long j3 = ((i + j) * 100) / j2;
                    if (c2003b == null || !c2003b.f5774a) {
                        interfaceC2005d.mo53415a(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    /* renamed from: c */
    private static void m53429c(C2004c c2004c) {
        if (c2004c == null) {
            return;
        }
        IUnZipListener m53419e = c2004c.m53419e();
        if (m53419e != null) {
            m53419e.mo53810p();
        }
        String m53423a = c2004c.m53423a();
        String m53421c = c2004c.m53421c();
        if (!TextUtils.isEmpty(m53423a) && !TextUtils.isEmpty(m53421c)) {
            File file = new File(m53423a);
            if (!file.exists()) {
                if (c2004c.m53418f().f5774a) {
                    if (m53419e != null) {
                        m53419e.mo53808r();
                        return;
                    }
                    return;
                } else if (m53419e != null) {
                    m53419e.mo53809q();
                    return;
                } else {
                    return;
                }
            }
            File file2 = new File(m53421c);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            C2002a c2002a = new C2002a(m53419e);
            try {
                if (c2004c.m53418f().f5774a && m53419e != null) {
                    m53419e.mo53808r();
                }
                m53427e(file, file2, c2002a, c2004c);
                if (c2004c.m53418f().f5774a) {
                    if (m53419e != null) {
                        m53419e.mo53808r();
                    }
                } else if (m53419e != null) {
                    m53419e.mo53811b(c2004c.m53420d());
                }
            } catch (Throwable unused) {
                if (c2004c.m53418f().f5774a) {
                    if (m53419e != null) {
                        m53419e.mo53808r();
                    }
                } else if (m53419e != null) {
                    m53419e.mo53809q();
                }
            }
        } else if (c2004c.m53418f().f5774a) {
            if (m53419e != null) {
                m53419e.mo53808r();
            }
        } else if (m53419e != null) {
            m53419e.mo53809q();
        }
    }

    /* renamed from: d */
    private static void m53428d(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        m53428d(parentFile);
        parentFile.mkdir();
    }

    /* renamed from: e */
    private static void m53427e(File file, File file2, InterfaceC2005d interfaceC2005d, C2004c c2004c) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        C2003b m53418f = c2004c.m53418f();
        long j = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (m53418f != null && m53418f.f5774a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!m53425g(nextEntry.getName())) {
                            interfaceC2005d.mo53416a();
                            break;
                        } else {
                            stringBuffer.append(nextEntry.getName());
                            stringBuffer.append(";");
                        }
                    }
                    j += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            c2004c.m53422b(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        m53426f(file2, zipInputStream2, j, interfaceC2005d, m53418f);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    /* renamed from: f */
    private static void m53426f(File file, ZipInputStream zipInputStream, long j, InterfaceC2005d interfaceC2005d, C2003b c2003b) throws Exception {
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (c2003b != null && c2003b.f5774a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!m53425g(nextEntry.getName())) {
                if (interfaceC2005d != null) {
                    interfaceC2005d.mo53416a();
                    return;
                }
                return;
            }
            File file2 = new File(str);
            m53428d(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                i += m53431a(file2, zipInputStream, i, j, interfaceC2005d, c2003b);
            }
            zipInputStream.closeEntry();
        }
    }

    /* renamed from: g */
    private static boolean m53425g(String str) {
        return (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    /* renamed from: b */
    public final void m53430b() {
        C2004c c2004c = this.f5772a;
        if (c2004c != null) {
            c2004c.m53417g();
        }
    }

    /* renamed from: h */
    public final void m53424h() {
        C2004c c2004c = this.f5772a;
        if (c2004c != null) {
            m53429c(c2004c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnZipFile.java */
    /* renamed from: com.amap.api.col.3l.y0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2002a implements InterfaceC2005d {

        /* renamed from: a */
        final /* synthetic */ IUnZipListener f5773a;

        C2002a(IUnZipListener iUnZipListener) {
            this.f5773a = iUnZipListener;
        }

        @Override // com.amap.api.col.p0463l.UnZipFile.InterfaceC2005d
        /* renamed from: a */
        public final void mo53415a(long j) {
            try {
                IUnZipListener iUnZipListener = this.f5773a;
                if (iUnZipListener != null) {
                    iUnZipListener.mo53812a(j);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.amap.api.col.p0463l.UnZipFile.InterfaceC2005d
        /* renamed from: a */
        public final void mo53416a() {
            IUnZipListener iUnZipListener = this.f5773a;
            if (iUnZipListener != null) {
                iUnZipListener.mo53809q();
            }
        }
    }
}
