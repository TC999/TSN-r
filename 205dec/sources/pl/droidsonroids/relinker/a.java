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
import pl.droidsonroids.relinker.c;

/* compiled from: ApkLibraryInstaller.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class a implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f61883a = 5;

    /* renamed from: b  reason: collision with root package name */
    private static final int f61884b = 4096;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ApkLibraryInstaller.java */
    /* renamed from: pl.droidsonroids.relinker.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class C1253a {

        /* renamed from: a  reason: collision with root package name */
        public ZipFile f61885a;

        /* renamed from: b  reason: collision with root package name */
        public ZipEntry f61886b;

        public C1253a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f61885a = zipFile;
            this.f61886b = zipEntry;
        }
    }

    private void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j4;
            }
            outputStream.write(bArr, 0, read);
            j4 += read;
        }
    }

    private C1253a d(Context context, String[] strArr, String str, d dVar) {
        int i4;
        String[] e4 = e(context);
        int length = e4.length;
        char c4 = 0;
        ZipFile zipFile = null;
        int i5 = 0;
        while (i5 < length) {
            String str2 = e4[i5];
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                i4 = 5;
                if (i6 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i6 = i7;
                }
            }
            if (zipFile != null) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (i8 < i4) {
                        int length2 = strArr.length;
                        int i10 = 0;
                        while (i10 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i10] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c4] = str3;
                            objArr[1] = str2;
                            dVar.m("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C1253a(zipFile, entry);
                            }
                            i10++;
                            c4 = 0;
                        }
                        i8 = i9;
                        i4 = 5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i5++;
            c4 = 0;
        }
        return null;
    }

    private String[] e(Context context) {
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

    @Override // pl.droidsonroids.relinker.c.a
    public void a(Context context, String[] strArr, String str, File file, d dVar) {
        C1253a d4;
        Closeable closeable;
        InputStream inputStream;
        long c4;
        C1253a c1253a = null;
        Closeable closeable2 = null;
        try {
            d4 = d(context, strArr, str, dVar);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (d4 == null) {
                throw new MissingLibraryException(str);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 < 5) {
                    dVar.m("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = d4.f61885a.getInputStream(d4.f61886b);
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
                                c4 = c(inputStream, closeable);
                                closeable.getFD().sync();
                            } catch (FileNotFoundException unused5) {
                                b(inputStream);
                                b(closeable);
                                i4 = i5;
                            } catch (IOException unused6) {
                                b(inputStream);
                                b(closeable);
                                i4 = i5;
                            } catch (Throwable th4) {
                                th = th4;
                                closeable2 = inputStream;
                                b(closeable2);
                                b(closeable);
                                throw th;
                            }
                            if (c4 != file.length()) {
                                b(inputStream);
                                b(closeable);
                            } else {
                                b(inputStream);
                                b(closeable);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile = d4.f61885a;
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
                    i4 = i5;
                } else {
                    dVar.l("FATAL! Couldn't extract the library from the APK!");
                    try {
                        ZipFile zipFile2 = d4.f61885a;
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
            c1253a = d4;
            if (c1253a != null) {
                try {
                    ZipFile zipFile3 = c1253a.f61885a;
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
