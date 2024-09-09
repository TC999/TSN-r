package com.bytedance.sdk.openadsdk.n;

import com.bytedance.sdk.component.utils.a;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr {
    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e4) {
                a.xv("FileUtils", e4);
            }
        }
    }

    private static void w(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                c(file2);
            }
        }
    }

    public static File c(File file, String str) {
        File file2;
        File[] listFiles;
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file2 = new File(file.getParentFile(), str);
                try {
                    if (file.exists() && file.isDirectory()) {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                        try {
                            for (File file3 : file.listFiles()) {
                                zipOutputStream2.putNextEntry(new ZipEntry(file3.getName()));
                                c(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream = zipOutputStream2;
                        } catch (IOException e4) {
                            e = e4;
                            zipOutputStream = zipOutputStream2;
                            a.xv("FileUtils", e);
                            c(zipOutputStream);
                            return file2;
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            c(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (IOException e6) {
                e = e6;
                file2 = null;
            }
            c(zipOutputStream);
            return file2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void c(String str, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter2.write(str);
                    c(bufferedWriter2);
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedWriter = bufferedWriter2;
                    a.xv("FileUtils", e);
                    c(bufferedWriter);
                } catch (IOException e5) {
                    e = e5;
                    bufferedWriter = bufferedWriter2;
                    a.xv("FileUtils", e);
                    c(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    c(bufferedWriter);
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void c(OutputStream outputStream, File file) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            c(fileInputStream2);
                            return;
                        }
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileInputStream = fileInputStream2;
                    a.xv("FileUtils", e);
                    c(fileInputStream);
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream = fileInputStream2;
                    a.xv("FileUtils", e);
                    c(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    c(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void c(File file) {
        if (file.isDirectory()) {
            w(file);
        } else {
            file.delete();
        }
    }
}
