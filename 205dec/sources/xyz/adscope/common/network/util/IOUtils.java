package xyz.adscope.common.network.util;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class IOUtils {
    public static boolean canRead(String str) {
        return new File(str).canRead();
    }

    public static boolean canWrite(String str) {
        return new File(str).canWrite();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) {
        int read;
        BufferedInputStream bufferedInputStream = toBufferedInputStream(inputStream);
        BufferedInputStream bufferedInputStream2 = toBufferedInputStream(inputStream2);
        do {
            read = bufferedInputStream.read();
            if (-1 == read) {
                return bufferedInputStream2.read() == -1;
            }
        } while (read == bufferedInputStream2.read());
        return false;
    }

    public static boolean contentEquals(Reader reader, Reader reader2) {
        int read;
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        do {
            read = bufferedReader.read();
            if (-1 == read) {
                return bufferedReader2.read() == -1;
            }
        } while (read == bufferedReader2.read());
        return false;
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) {
        String readLine;
        String readLine2;
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        do {
            readLine = bufferedReader.readLine();
            readLine2 = bufferedReader2.readLine();
            if (readLine == null || readLine2 == null) {
                break;
            }
        } while (readLine.equals(readLine2));
        return readLine != null && (readLine2 == null || readLine.equals(readLine2));
    }

    public static boolean createFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                return true;
            }
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFile(new File(str));
    }

    public static boolean createFolder(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            file.delete();
        }
        return file.mkdirs();
    }

    public static boolean createFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFolder(new File(str));
    }

    public static boolean createNewFile(File file) {
        if (file.exists()) {
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createNewFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createNewFile(new File(str));
    }

    public static boolean createNewFolder(File file) {
        return delFileOrFolder(file) && createFolder(file);
    }

    public static boolean createNewFolder(String str) {
        return delFileOrFolder(str) && createFolder(str);
    }

    public static boolean delFileOrFolder(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (!file.isFile()) {
            if (!file.isDirectory()) {
                return true;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    delFileOrFolder(file2);
                }
            }
        }
        file.delete();
        return true;
    }

    public static boolean delFileOrFolder(String str) {
        return delFileOrFolder(new File(str));
    }

    public static void flushQuietly(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Exception unused) {
            }
        }
    }

    public static long getDirSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static List<String> readLines(InputStream inputStream) {
        return readLines(new InputStreamReader(inputStream));
    }

    public static List<String> readLines(InputStream inputStream, String str) {
        return readLines(inputStream, Charset.forName(str));
    }

    public static List<String> readLines(InputStream inputStream, Charset charset) {
        return readLines(new InputStreamReader(inputStream, charset));
    }

    public static List<String> readLines(Reader reader) {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static BufferedInputStream toBufferedInputStream(InputStream inputStream) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    public static BufferedOutputStream toBufferedOutputStream(OutputStream outputStream) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static BufferedWriter toBufferedWriter(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(InputStream inputStream, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i4);
        }
        int i5 = 0;
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i4];
        while (i5 < i4) {
            int read = inputStream.read(bArr, i5, i4 - i5);
            if (read == -1) {
                break;
            }
            i5 += read;
        }
        if (i5 == i4) {
            return bArr;
        }
        throw new IOException("Unexpected byte count size. current: " + i5 + ", excepted: " + i4);
    }

    public static byte[] toByteArray(Reader reader) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(Reader reader, String str) {
        return toByteArray(reader, Charset.forName(str));
    }

    public static byte[] toByteArray(Reader reader, Charset charset) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream, charset);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(CharSequence charSequence) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes();
    }

    public static byte[] toByteArray(CharSequence charSequence, String str) {
        return toByteArray(charSequence, Charset.forName(str));
    }

    public static byte[] toByteArray(CharSequence charSequence, Charset charset) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes(charset);
    }

    public static char[] toCharArray(InputStream inputStream) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(InputStream inputStream, String str) {
        return toCharArray(inputStream, Charset.forName(str));
    }

    public static char[] toCharArray(InputStream inputStream, Charset charset) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(Reader reader) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(reader, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(CharSequence charSequence) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(charArrayWriter, charSequence);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(CharSequence charSequence) {
        return new ByteArrayInputStream(charSequence.toString().getBytes());
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) {
        return toInputStream(charSequence, Charset.forName(str));
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return new ByteArrayInputStream(charSequence.toString().getBytes(charset));
    }

    public static String toString(InputStream inputStream) {
        return new String(toByteArray(inputStream));
    }

    public static String toString(InputStream inputStream, String str) {
        return new String(toByteArray(inputStream), str);
    }

    public static String toString(InputStream inputStream, Charset charset) {
        return new String(toByteArray(inputStream), charset);
    }

    public static String toString(Reader reader) {
        return new String(toByteArray(reader));
    }

    public static String toString(Reader reader, String str) {
        return new String(toByteArray(reader), str);
    }

    public static String toString(Reader reader, Charset charset) {
        return new String(toByteArray(reader), charset);
    }

    public static String toString(byte[] bArr) {
        return new String(bArr);
    }

    public static String toString(byte[] bArr, String str) {
        return toString(bArr, Charset.forName(str));
    }

    public static String toString(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    public static void write(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
            outputStream.flush();
        }
    }

    public static void write(InputStream inputStream, OutputStream outputStream, String str) {
        write(inputStream, outputStream, Charset.forName(str));
    }

    public static void write(InputStream inputStream, OutputStream outputStream, Charset charset) {
        write(new InputStreamReader(inputStream, charset), outputStream);
    }

    public static void write(InputStream inputStream, Writer writer) {
        write(new InputStreamReader(inputStream), writer);
    }

    public static void write(InputStream inputStream, Writer writer, String str) {
        write(inputStream, writer, Charset.forName(str));
    }

    public static void write(InputStream inputStream, Writer writer, Charset charset) {
        write(new InputStreamReader(inputStream, charset), writer);
    }

    public static void write(OutputStream outputStream, CharSequence charSequence) {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes());
            outputStream.flush();
        }
    }

    public static void write(OutputStream outputStream, CharSequence charSequence, String str) {
        write(outputStream, charSequence, Charset.forName(str));
    }

    public static void write(OutputStream outputStream, CharSequence charSequence, Charset charset) {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes(charset));
            outputStream.flush();
        }
    }

    public static void write(OutputStream outputStream, byte[] bArr) {
        if (bArr != null) {
            outputStream.write(bArr);
            outputStream.flush();
        }
    }

    public static void write(OutputStream outputStream, char[] cArr) {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes());
            outputStream.flush();
        }
    }

    public static void write(OutputStream outputStream, char[] cArr, String str) {
        write(outputStream, cArr, Charset.forName(str));
    }

    public static void write(OutputStream outputStream, char[] cArr, Charset charset) {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(charset));
            outputStream.flush();
        }
    }

    public static void write(Reader reader, OutputStream outputStream) {
        write(reader, new OutputStreamWriter(outputStream));
    }

    public static void write(Reader reader, OutputStream outputStream, String str) {
        write(reader, outputStream, Charset.forName(str));
    }

    public static void write(Reader reader, OutputStream outputStream, Charset charset) {
        write(reader, new OutputStreamWriter(outputStream, charset));
    }

    public static void write(Reader reader, Writer writer) {
        char[] cArr = new char[4096];
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
            writer.flush();
        }
    }

    public static void write(Writer writer, CharSequence charSequence) {
        if (charSequence != null) {
            writer.write(charSequence.toString());
            writer.flush();
        }
    }

    public static void write(Writer writer, byte[] bArr) {
        if (bArr != null) {
            writer.write(new String(bArr));
            writer.flush();
        }
    }

    public static void write(Writer writer, byte[] bArr, String str) {
        write(writer, bArr, Charset.forName(str));
    }

    public static void write(Writer writer, byte[] bArr, Charset charset) {
        if (bArr != null) {
            writer.write(new String(bArr, charset));
            writer.flush();
        }
    }

    public static void write(Writer writer, char[] cArr) {
        if (cArr != null) {
            writer.write(cArr);
            writer.flush();
        }
    }
}
