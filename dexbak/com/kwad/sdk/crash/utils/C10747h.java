package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.snail.antifake.deviceid.ShellAdbUtils;
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

/* renamed from: com.kwad.sdk.crash.utils.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10747h {
    public static final char aHQ = File.separatorChar;
    public static final String aHR;

    static {
        PrintWriter printWriter;
        Throwable th;
        StringBuilderWriter stringBuilderWriter;
        Exception e;
        String str;
        try {
            try {
                stringBuilderWriter = new StringBuilderWriter(4);
            } catch (Exception e2) {
                printWriter = null;
                e = e2;
                stringBuilderWriter = null;
            } catch (Throwable th2) {
                printWriter = null;
                th = th2;
                stringBuilderWriter = null;
            }
            try {
                printWriter = new PrintWriter(stringBuilderWriter);
            } catch (Exception e3) {
                printWriter = null;
                e = e3;
            } catch (Throwable th3) {
                printWriter = null;
                th = th3;
                C10738b.closeQuietly(printWriter);
                C10738b.closeQuietly(stringBuilderWriter);
                throw th;
            }
            try {
                printWriter.println();
                str = stringBuilderWriter.toString();
                C10738b.closeQuietly(printWriter);
                C10738b.closeQuietly(stringBuilderWriter);
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                C10738b.closeQuietly(printWriter);
                C10738b.closeQuietly(stringBuilderWriter);
                str = ShellAdbUtils.f33810d;
                aHR = str;
            }
            aHR = str;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: I */
    public static String m24957I(File file) {
        return m24949a(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), C10737a.UTF_8));
    }

    /* renamed from: J */
    public static long m24955J(File file) {
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

    /* renamed from: K */
    public static long m24954K(File file) {
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

    /* renamed from: a */
    private static String m24949a(Reader reader) {
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
                    C10738b.closeQuietly(reader);
                    C10738b.closeQuietly(stringWriter);
                    return stringWriter3;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            C10738b.closeQuietly(reader);
            C10738b.closeQuietly(stringWriter);
            throw th;
        }
    }

    /* renamed from: b */
    public static String m24945b(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        m24948a(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    /* renamed from: c */
    public static String m24943c(InputStream inputStream) {
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
            String m24949a = m24949a(bufferedReader);
            C10738b.closeQuietly(bufferedReader);
            C10738b.closeQuietly(inputStreamReader);
            return m24949a;
        } catch (Throwable th4) {
            th = th4;
            C10738b.closeQuietly(bufferedReader);
            C10738b.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* renamed from: d */
    public static String m24942d(InputStream inputStream) {
        return m24950a(inputStream, Charset.defaultCharset());
    }

    /* renamed from: g */
    public static int m24941g(InputStream inputStream, OutputStream outputStream) {
        long m24940h = m24940h(inputStream, outputStream);
        if (m24940h > 2147483647L) {
            return -1;
        }
        return (int) m24940h;
    }

    public static long getAvailableBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return m24955J(new File(str));
    }

    public static long getTotalBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return m24954K(new File(str));
    }

    /* renamed from: h */
    private static long m24940h(InputStream inputStream, OutputStream outputStream) {
        return m24952a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: k */
    public static void m24939k(String str, String str2, boolean z) {
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
                C10738b.closeQuietly(fileWriter);
            } catch (Throwable unused) {
                C10738b.closeQuietly(fileWriter);
            }
        } catch (Throwable unused2) {
            fileWriter = null;
        }
    }

    /* renamed from: b */
    private static long m24944b(Reader reader, Writer writer) {
        return m24947a(reader, writer, new char[4096]);
    }

    /* renamed from: J */
    public static String m24956J(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return m24950a(inputStream, C10737a.m25008a(Charset.defaultCharset()));
        } finally {
            C10738b.closeQuietly(inputStream);
        }
    }

    /* renamed from: a */
    public static String m24950a(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        m24951a(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    /* renamed from: a */
    public static void m24946a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(C10737a.m25008a(charset)));
        }
    }

    /* renamed from: a */
    private static long m24952a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    /* renamed from: a */
    private static void m24951a(InputStream inputStream, Writer writer, Charset charset) {
        m24948a(new InputStreamReader(inputStream, C10737a.m25008a(charset)), writer);
    }

    /* renamed from: a */
    private static int m24948a(Reader reader, Writer writer) {
        long m24944b = m24944b(reader, writer);
        if (m24944b > 2147483647L) {
            return -1;
        }
        return (int) m24944b;
    }

    /* renamed from: a */
    private static long m24947a(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
        }
    }

    /* renamed from: a */
    public static String m24953a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray());
                    C10738b.closeQuietly(inputStream);
                    C10738b.closeQuietly(byteArrayOutputStream);
                    return str;
                }
            } catch (IOException unused) {
                C10738b.closeQuietly(inputStream);
                C10738b.closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                C10738b.closeQuietly(inputStream);
                C10738b.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        }
    }
}
