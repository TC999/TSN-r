package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import ms.bz.bd.c.Pgl.pblt;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class pblr implements pblt.pgla {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class pgla {

        /* renamed from: a  reason: collision with root package name */
        public ZipFile f61441a;

        /* renamed from: b  reason: collision with root package name */
        public ZipEntry f61442b;

        public pgla(ZipFile zipFile, ZipEntry zipEntry) {
            this.f61441a = zipFile;
            this.f61442b = zipEntry;
        }
    }

    private pgla a(Context context, String[] strArr, String str, pblu pbluVar) {
        String[] d4 = d(context);
        int length = d4.length;
        char c4 = 0;
        int i4 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i4 >= length) {
                return null;
            }
            String str2 = d4[i4];
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i5 = i6;
                }
            }
            if (zipFile != null) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i7 < 5) {
                        int length2 = strArr.length;
                        int i9 = 0;
                        while (i9 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i9] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c4] = str3;
                            objArr[1] = str2;
                            pbluVar.getClass();
                            String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new pgla(zipFile, entry);
                            }
                            i9++;
                            c4 = 0;
                        }
                        i7 = i8;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i4++;
            c4 = 0;
        }
    }

    private void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private String[] d(Context context) {
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

    private String[] e(Context context, String str) {
        Pattern compile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        ZipFile zipFile = null;
        for (String str2 : d(context)) {
            try {
                ZipFile zipFile2 = new ZipFile(new File(str2), 1);
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
                zipFile = zipFile2;
            } catch (IOException unused) {
            }
        }
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public void b(Context context, String[] strArr, String str, File file, pblu pbluVar) {
        String[] strArr2;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        pgla pglaVar = null;
        r0 = null;
        Closeable closeable = null;
        try {
            pgla a4 = a(context, strArr, str, pbluVar);
            try {
                if (a4 == null) {
                    try {
                        strArr2 = e(context, str);
                    } catch (Exception e4) {
                        strArr2 = new String[]{e4.toString()};
                    }
                    throw new pbls(str, strArr, strArr2);
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 >= 5) {
                        try {
                            ZipFile zipFile = a4.f61441a;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    String.format(Locale.US, "Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = a4.f61441a.getInputStream(a4.f61442b);
                            } catch (FileNotFoundException | IOException unused2) {
                                inputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = null;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                long j4 = 0;
                                try {
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                        j4 += read;
                                    }
                                    fileOutputStream.flush();
                                    fileOutputStream.getFD().sync();
                                    if (j4 == file.length()) {
                                        c(inputStream);
                                        c(fileOutputStream);
                                        file.setReadable(true, false);
                                        file.setExecutable(true, false);
                                        file.setWritable(true);
                                        try {
                                            ZipFile zipFile2 = a4.f61441a;
                                            if (zipFile2 != null) {
                                                zipFile2.close();
                                                return;
                                            }
                                            return;
                                        } catch (IOException unused3) {
                                            return;
                                        }
                                    }
                                } catch (FileNotFoundException | IOException unused4) {
                                } catch (Throwable th3) {
                                    th = th3;
                                    closeable = fileOutputStream;
                                    c(inputStream);
                                    c(closeable);
                                    throw th;
                                }
                            } catch (FileNotFoundException | IOException unused5) {
                                fileOutputStream = null;
                                c(inputStream);
                                c(fileOutputStream);
                                i4 = i5;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            c(inputStream);
                            c(fileOutputStream);
                        }
                    } catch (IOException unused6) {
                    }
                    i4 = i5;
                }
            } catch (Throwable th5) {
                th = th5;
                pglaVar = a4;
                if (pglaVar != null) {
                    try {
                        ZipFile zipFile3 = pglaVar.f61441a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused7) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
