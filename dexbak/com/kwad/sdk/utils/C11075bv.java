package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* renamed from: com.kwad.sdk.utils.bv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11075bv {

    /* renamed from: com.kwad.sdk.utils.bv$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11076a extends ZipOutputStream {
        private Map<String, Integer> aRk;

        public C11076a(OutputStream outputStream) {
            super(outputStream);
            this.aRk = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) {
            ZipEntry zipEntry2;
            Integer num;
            String name = zipEntry.getName();
            Integer num2 = this.aRk.get(name);
            if (num2 != null && num2.intValue() > 0) {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + num2 + ")."));
                num = Integer.valueOf(num2.intValue() + 1);
            } else {
                zipEntry2 = zipEntry;
                num = 1;
            }
            this.aRk.put(name, num);
            super.putNextEntry(zipEntry2);
        }
    }

    /* renamed from: a */
    private static boolean m23841a(File[] fileArr, File file) {
        if (file == null) {
            return false;
        }
        C11076a c11076a = null;
        try {
            byte[] bArr = new byte[4096];
            C11076a c11076a2 = new C11076a(new BufferedOutputStream(new FileOutputStream(file, false)));
            for (int i = 0; i <= 0; i++) {
                try {
                    m23842a(c11076a2, fileArr[0], null, bArr);
                } catch (Throwable th) {
                    th = th;
                    c11076a = c11076a2;
                    try {
                        C10331c.m26249e("ZipUtils", "error zip", th);
                        return false;
                    } finally {
                        C10738b.closeQuietly(c11076a);
                    }
                }
            }
            c11076a2.flush();
            c11076a2.closeEntry();
            C10738b.closeQuietly(c11076a2);
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: hc */
    private static String m23840hc(String str) {
        return ((!TextUtils.isEmpty(str) || str.length() <= 1) && !TextUtils.isEmpty(str) && str.charAt(0) == '.') ? str.substring(1) : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static boolean unZip(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(bufferedInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry != null) {
                                String name = nextEntry.getName();
                                if (!name.contains("../")) {
                                    if (nextEntry.isDirectory()) {
                                        new File(str + "/" + name).mkdirs();
                                    } else {
                                        File file2 = new File(str + "/" + name);
                                        if (!file2.getParentFile().exists()) {
                                            file2.getParentFile().mkdirs();
                                        }
                                        try {
                                            fileOutputStream = new FileOutputStream(file2);
                                            while (true) {
                                                try {
                                                    try {
                                                        int read = zipInputStream2.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        fileOutputStream.write(bArr, 0, read);
                                                    } catch (IOException e) {
                                                        e = e;
                                                        C10331c.m26249e("ZipUtils", "error unZip when write", e);
                                                        closeable = fileOutputStream;
                                                        C10738b.closeQuietly(closeable);
                                                        zipInputStream2.closeEntry();
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipInputStream = fileOutputStream;
                                                    C10738b.closeQuietly(zipInputStream);
                                                    throw th;
                                                }
                                            }
                                            fileOutputStream.flush();
                                            fileOutputStream.getFD().sync();
                                            closeable = fileOutputStream;
                                        } catch (IOException e2) {
                                            e = e2;
                                            fileOutputStream = 0;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                        C10738b.closeQuietly(closeable);
                                        zipInputStream2.closeEntry();
                                    }
                                }
                            } else {
                                C10738b.closeQuietly(zipInputStream2);
                                C10738b.closeQuietly(bufferedInputStream);
                                return true;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        zipInputStream = zipInputStream2;
                        C10331c.m26249e("ZipUtils", "error unZip", e);
                        C10738b.closeQuietly(zipInputStream);
                        C10738b.closeQuietly(bufferedInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream = zipInputStream2;
                        C10738b.closeQuietly(zipInputStream);
                        C10738b.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean zip(File file, File file2) {
        return m23841a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip")) {
            return;
        }
        if (zip(file, new File(absolutePath + ".zip"))) {
            file.delete();
        }
    }

    /* renamed from: a */
    private static void m23842a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        File[] listFiles;
        if (zipOutputStream != null && file != null) {
            if (!file.exists()) {
                C10331c.m26249e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
                return;
            }
            BufferedInputStream bufferedInputStream = null;
            String m23840hc = TextUtils.isEmpty(str) ? m23840hc(file.getName()) : str + File.separator + m23840hc(file.getName());
            if (file.isFile()) {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(m23840hc));
                        while (true) {
                            int read = bufferedInputStream2.read(bArr, 0, bArr.length);
                            if (-1 != read) {
                                zipOutputStream.write(bArr, 0, read);
                            } else {
                                C10738b.closeQuietly(bufferedInputStream2);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        C10331c.m26249e("ZipUtils", "error doZip", e);
                        C10738b.closeQuietly(bufferedInputStream);
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    m23842a(zipOutputStream, file2, m23840hc, bArr);
                }
            }
        } else {
            C10331c.m26249e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
        }
    }
}
