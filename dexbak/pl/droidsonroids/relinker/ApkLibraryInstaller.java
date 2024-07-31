package pl.droidsonroids.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import pl.droidsonroids.relinker.ReLinker;

/* renamed from: pl.droidsonroids.relinker.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ApkLibraryInstaller implements ReLinker.InterfaceC15462a {

    /* renamed from: a */
    private static final int f44470a = 5;

    /* renamed from: b */
    private static final int f44471b = 4096;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ApkLibraryInstaller.java */
    /* renamed from: pl.droidsonroids.relinker.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15460a {

        /* renamed from: a */
        public ZipFile f44472a;

        /* renamed from: b */
        public ZipEntry f44473b;

        public C15460a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f44472a = zipFile;
            this.f44473b = zipEntry;
        }
    }

    /* renamed from: b */
    private void m2362b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: c */
    private long m2361c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    /* renamed from: d */
    private C15460a m2360d(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        int i;
        String[] m2359e = m2359e(context);
        int length = m2359e.length;
        char c = 0;
        ZipFile zipFile = null;
        int i2 = 0;
        while (i2 < length) {
            String str2 = m2359e[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                i = 5;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < i) {
                        int length2 = strArr.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c] = str3;
                            objArr[1] = str2;
                            reLinkerInstance.m2337m("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C15460a(zipFile, entry);
                            }
                            i7++;
                            c = 0;
                        }
                        i5 = i6;
                        i = 5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            c = 0;
        }
        return null;
    }

    /* renamed from: e */
    private String[] m2359e(Context context) {
        String[] strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // pl.droidsonroids.relinker.ReLinker.InterfaceC15462a
    /* renamed from: a */
    public void mo2351a(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance) {
        C15460a m2360d;
        Closeable closeable;
        InputStream inputStream;
        long m2361c;
        C15460a c15460a = null;
        Closeable closeable2 = null;
        try {
            m2360d = m2360d(context, strArr, str, reLinkerInstance);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (m2360d == null) {
                throw new MissingLibraryException(str);
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i < 5) {
                    reLinkerInstance.m2337m("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = m2360d.f44472a.getInputStream(m2360d.f44473b);
                                try {
                                    closeable = new FileOutputStream(file);
                                } catch (FileNotFoundException unused) {
                                    closeable = null;
                                } catch (IOException unused2) {
                                    closeable = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    closeable = null;
                                }
                            } catch (FileNotFoundException unused3) {
                                inputStream = null;
                                closeable = null;
                            } catch (IOException unused4) {
                                inputStream = null;
                                closeable = null;
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = null;
                            }
                            try {
                                m2361c = m2361c(inputStream, closeable);
                                closeable.getFD().sync();
                            } catch (FileNotFoundException unused5) {
                                m2362b(inputStream);
                                m2362b(closeable);
                                i = i2;
                            } catch (IOException unused6) {
                                m2362b(inputStream);
                                m2362b(closeable);
                                i = i2;
                            } catch (Throwable th4) {
                                th = th4;
                                closeable2 = inputStream;
                                m2362b(closeable2);
                                m2362b(closeable);
                                throw th;
                            }
                            if (m2361c != file.length()) {
                                m2362b(inputStream);
                                m2362b(closeable);
                            } else {
                                m2362b(inputStream);
                                m2362b(closeable);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile = m2360d.f44472a;
                                    if (zipFile != null) {
                                        zipFile.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused7) {
                                    return;
                                }
                            }
                        }
                    } catch (IOException unused8) {
                    }
                    i = i2;
                } else {
                    reLinkerInstance.m2338l("FATAL! Couldn't extract the library from the APK!");
                    try {
                        ZipFile zipFile2 = m2360d.f44472a;
                        if (zipFile2 != null) {
                            zipFile2.close();
                            return;
                        }
                        return;
                    } catch (IOException unused9) {
                        return;
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            c15460a = m2360d;
            if (c15460a != null) {
                try {
                    ZipFile zipFile3 = c15460a.f44472a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused10) {
                }
            }
            throw th;
        }
    }
}
