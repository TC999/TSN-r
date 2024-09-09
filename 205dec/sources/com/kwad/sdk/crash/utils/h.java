package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    public static final char aHQ = File.separatorChar;
    public static final String aHR;

    static {
        PrintWriter printWriter;
        Throwable th;
        StringBuilderWriter stringBuilderWriter;
        Exception e4;
        String str;
        try {
            try {
                stringBuilderWriter = new StringBuilderWriter(4);
            } catch (Exception e5) {
                printWriter = null;
                e4 = e5;
                stringBuilderWriter = null;
            } catch (Throwable th2) {
                printWriter = null;
                th = th2;
                stringBuilderWriter = null;
            }
            try {
                printWriter = new PrintWriter(stringBuilderWriter);
            } catch (Exception e6) {
                printWriter = null;
                e4 = e6;
            } catch (Throwable th3) {
                printWriter = null;
                th = th3;
                b.closeQuietly(printWriter);
                b.closeQuietly(stringBuilderWriter);
                throw th;
            }
            try {
                printWriter.println();
                str = stringBuilderWriter.toString();
                b.closeQuietly(printWriter);
                b.closeQuietly(stringBuilderWriter);
            } catch (Exception e7) {
                e4 = e7;
                e4.printStackTrace();
                b.closeQuietly(printWriter);
                b.closeQuietly(stringBuilderWriter);
                str = "\n";
                aHR = str;
            }
            aHR = str;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String I(File file) {
        return a(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), a.UTF_8));
    }

    public static long J(File file) {
        try {
            if (file.exists()) {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                if (Build.VERSION.SDK_INT < 18) {
                    return statFs.getBlockSize() * statFs.getAvailableBlocks();
                }
                return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long K(File file) {
        try {
            if (file.exists()) {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                if (Build.VERSION.SDK_INT < 18) {
                    return statFs.getBlockSize() * statFs.getBlockCount();
                }
                return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th2) {
            stringWriter = stringWriter2;
            th = th2;
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    String stringWriter3 = stringWriter.toString();
                    b.closeQuietly(reader);
                    b.closeQuietly(stringWriter);
                    return stringWriter3;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            b.closeQuietly(reader);
            b.closeQuietly(stringWriter);
            throw th;
        }
    }

    public static String b(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static String c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String a4 = a(bufferedReader);
            b.closeQuietly(bufferedReader);
            b.closeQuietly(inputStreamReader);
            return a4;
        } catch (Throwable th4) {
            th = th4;
            b.closeQuietly(bufferedReader);
            b.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    public static String d(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }

    public static int g(InputStream inputStream, OutputStream outputStream) {
        long h4 = h(inputStream, outputStream);
        if (h4 > 2147483647L) {
            return -1;
        }
        return (int) h4;
    }

    public static long getAvailableBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return J(new File(str));
    }

    public static long getTotalBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return K(new File(str));
    }

    private static long h(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, new byte[4096]);
    }

    public static void k(String str, String str2, boolean z3) {
        FileWriter fileWriter;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                fileWriter.write(str2);
                fileWriter.flush();
                b.closeQuietly(fileWriter);
            } catch (Throwable unused) {
                b.closeQuietly(fileWriter);
            }
        } catch (Throwable unused2) {
            fileWriter = null;
        }
    }

    private static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static String J(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return a(inputStream, a.a(Charset.defaultCharset()));
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    public static String a(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(a.a(charset)));
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j4;
            }
            outputStream.write(bArr, 0, read);
            j4 += read;
        }
    }

    private static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    private static int a(Reader reader, Writer writer) {
        long b4 = b(reader, writer);
        if (b4 > 2147483647L) {
            return -1;
        }
        return (int) b4;
    }

    private static long a(Reader reader, Writer writer, char[] cArr) {
        long j4 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j4;
            }
            writer.write(cArr, 0, read);
            j4 += read;
        }
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray());
                    b.closeQuietly(inputStream);
                    b.closeQuietly(byteArrayOutputStream);
                    return str;
                }
            } catch (IOException unused) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        }
    }
}
