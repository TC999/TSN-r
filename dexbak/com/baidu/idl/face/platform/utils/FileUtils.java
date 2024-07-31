package com.baidu.idl.face.platform.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class FileUtils {
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
    private static final Pattern RESERVED_CHARS_PATTERN = Pattern.compile("[\\\\/:\\*\\?\\\"<>|]");

    private FileUtils() {
    }

    public static void cleanDir(File file) {
        deleteDir(file, false);
    }

    public static long computeFolderSize(File file) {
        long computeFolderSize;
        long j = 0;
        if (file == null) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    computeFolderSize = file2.length();
                } else if (file2.isDirectory()) {
                    j += file2.length();
                    computeFolderSize = computeFolderSize(file2);
                }
                j += computeFolderSize;
            }
        }
        return j;
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        if (file.exists()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3.isDirectory()) {
                    copyDirectory(file3, new File(file2, file3.getName()));
                } else {
                    copyFile(file3, new File(file2, file3.getName()));
                }
            }
        }
    }

    public static void copyFile(String str, String str2) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    IoUtils.copyStream(fileInputStream2, new File(str2));
                    IoUtils.closeQuietly(fileInputStream2);
                } catch (IOException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    IoUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static File createCollectDirectory() {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, "CollectBest");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static void deleteDir(String str) {
        deleteDir(new File(str));
    }

    public static boolean deleteFileIfExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void ensureDir(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                file.mkdirs();
                return;
            }
            return;
        }
        file.mkdirs();
    }

    public static boolean ensureMkdir(File file) {
        if (file == null) {
            return false;
        }
        int i = 1;
        File file2 = file;
        while (file2.exists()) {
            String parent = file.getParent();
            file2 = new File(parent, file.getName() + "(" + i + ")");
            i++;
        }
        return file2.mkdir();
    }

    public static void ensureParent(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean existsFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsFile(new File(str));
    }

    public static String getExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getExtension(new File(str));
    }

    public static String getFileNameWithoutExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public static String getFileNameWithoutExtensionByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileNameWithoutExtension(new File(str));
    }

    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static File getUserDir() {
        return new File(System.getProperty("user.dir"));
    }

    public static File getUserHome() {
        return new File(System.getProperty("user.home"));
    }

    public static boolean isFilenameSafe(File file) {
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    public static boolean isFilenameValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !RESERVED_CHARS_PATTERN.matcher(str).find();
    }

    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static FileOutputStream openNewFileOutput(File file) throws IOException {
        deleteFileIfExist(file);
        ensureParent(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public static byte[] readAssetFileContent(AssetManager assetManager, String str) throws IOException {
        Log.i("FileUtil", " try to read asset file :" + str);
        InputStream open = assetManager.open(str);
        int available = open.available();
        byte[] bArr = new byte[available];
        int read = open.read(bArr);
        if (read == available) {
            open.close();
            return bArr;
        }
        throw new IOException("realSize is not equal to size: " + read + " : " + available);
    }

    public static String readAssetFileUtf8String(AssetManager assetManager, String str) throws IOException {
        return new String(readAssetFileContent(assetManager, str), Charset.forName("UTF-8"));
    }

    public static Map<String, String> readConfig(File file) {
        HashMap hashMap = new HashMap();
        String readFileText = readFileText(file);
        if (readFileText != null && !TextUtils.isEmpty(readFileText)) {
            for (String str : readFileText.split(ShellAdbUtils.f33810d)) {
                String trim = str.trim();
                if (!TextUtils.isEmpty(trim) && !trim.startsWith("#")) {
                    String[] split = trim.split("=", 2);
                    if (split.length >= 2) {
                        hashMap.put(split[0].trim(), split[1].trim());
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public static byte[] readFileBytes(File file) {
        FileInputStream fileInputStream;
        ?? existsFile = existsFile(file);
        Closeable closeable = null;
        try {
            if (existsFile != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(closeable);
                    throw th;
                }
                try {
                    byte[] loadBytes = IoUtils.loadBytes(fileInputStream);
                    IoUtils.closeQuietly(fileInputStream);
                    return loadBytes;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable = existsFile;
        }
    }

    public static String readFileText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileText(new File(str));
    }

    public static void writeToFile(File file, String str) {
        writeToFile(file, str, false, "utf-8");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void writeToFileNio(InputStream inputStream, File file) {
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel2 = null;
        try {
            int available = inputStream.available();
            readableByteChannel = Channels.newChannel(inputStream);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                fileChannel = null;
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
            }
            try {
                fileChannel2 = fileOutputStream.getChannel();
                fileChannel2.transferFrom(readableByteChannel, 0L, available);
                IoUtils.closeQuietly(fileOutputStream);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel2);
            } catch (IOException e2) {
                e = e2;
                fileChannel = fileChannel2;
                fileChannel2 = fileOutputStream;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileChannel2);
                    IoUtils.closeQuietly(readableByteChannel);
                    IoUtils.closeQuietly(fileChannel);
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.closeQuietly(fileChannel2);
                    IoUtils.closeQuietly(readableByteChannel);
                    IoUtils.closeQuietly(fileChannel);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = fileChannel2;
                fileChannel2 = fileOutputStream;
                IoUtils.closeQuietly(fileChannel2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            readableByteChannel = null;
            fileChannel = null;
        } catch (Throwable th4) {
            th = th4;
            readableByteChannel = null;
            fileChannel = null;
        }
    }

    public static void cleanDir(File file, FilenameFilter filenameFilter) {
        deleteDir(file, false, filenameFilter);
    }

    public static void deleteDir(File file) {
        deleteDir(file, true);
    }

    public static void writeToFile(File file, String str, boolean z) {
        writeToFile(file, str, z, "utf-8");
    }

    public static void cleanDir(File file, FileFilter fileFilter) {
        deleteDir(file, false, fileFilter);
    }

    public static void deleteDir(File file, FileFilter fileFilter) {
        deleteDir(file, true, fileFilter);
    }

    public static boolean existsFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static String getExtension(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf >= 0 ? name.substring(lastIndexOf + 1) : "";
    }

    public static String getFileNameWithoutExtension(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf >= 0 ? name.substring(0, lastIndexOf) : name;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public static String readFileText(File file) {
        FileInputStream fileInputStream;
        ?? existsFile = existsFile(file);
        Closeable closeable = null;
        try {
            if (existsFile != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(closeable);
                    throw th;
                }
                try {
                    String loadContent = IoUtils.loadContent(fileInputStream);
                    IoUtils.closeQuietly(fileInputStream);
                    return loadContent;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable = existsFile;
        }
    }

    public static void writeToFile(File file, String str, String str2) {
        writeToFile(file, str, false, str2);
    }

    public static void deleteDir(File file, FilenameFilter filenameFilter) {
        deleteDir(file, true, filenameFilter);
    }

    public static void writeToFile(File file, String str, boolean z, String str2) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        ensureParent(file);
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, z), str2);
                try {
                    outputStreamWriter2.write(str);
                    IoUtils.closeQuietly(outputStreamWriter2);
                } catch (IOException e) {
                    e = e;
                    outputStreamWriter = outputStreamWriter2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(outputStreamWriter);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    IoUtils.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void deleteDir(File file, boolean z) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2, z);
                } else {
                    file2.delete();
                }
            }
        }
        if (z) {
            file.delete();
        }
    }

    public static boolean deleteFileIfExist(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void copyFile(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel fileChannel3 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                fileChannel = null;
            }
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    fileChannel3 = fileOutputStream.getChannel();
                    fileChannel.transferTo(0L, fileChannel.size(), fileChannel3);
                    IoUtils.closeQuietly(fileInputStream);
                    IoUtils.closeQuietly(fileChannel);
                    IoUtils.closeQuietly(fileOutputStream);
                    IoUtils.closeQuietly(fileChannel3);
                } catch (IOException e2) {
                    e = e2;
                    fileChannel2 = fileChannel3;
                    fileChannel3 = fileInputStream;
                    try {
                        e.printStackTrace();
                        IoUtils.closeQuietly(fileChannel3);
                        IoUtils.closeQuietly(fileChannel);
                        IoUtils.closeQuietly(fileOutputStream);
                        IoUtils.closeQuietly(fileChannel2);
                    } catch (Throwable th2) {
                        th = th2;
                        IoUtils.closeQuietly(fileChannel3);
                        IoUtils.closeQuietly(fileChannel);
                        IoUtils.closeQuietly(fileOutputStream);
                        IoUtils.closeQuietly(fileChannel2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel2 = fileChannel3;
                    fileChannel3 = fileInputStream;
                    IoUtils.closeQuietly(fileChannel3);
                    IoUtils.closeQuietly(fileChannel);
                    IoUtils.closeQuietly(fileOutputStream);
                    IoUtils.closeQuietly(fileChannel2);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileChannel = null;
                fileChannel3 = fileInputStream;
                fileChannel2 = fileChannel;
                e.printStackTrace();
                IoUtils.closeQuietly(fileChannel3);
                IoUtils.closeQuietly(fileChannel);
                IoUtils.closeQuietly(fileOutputStream);
                IoUtils.closeQuietly(fileChannel2);
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileChannel3 = fileInputStream;
                fileChannel2 = fileChannel;
                IoUtils.closeQuietly(fileChannel3);
                IoUtils.closeQuietly(fileChannel);
                IoUtils.closeQuietly(fileOutputStream);
                IoUtils.closeQuietly(fileChannel2);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
            fileChannel = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fileChannel = null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001c: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:17:0x001c */
    public static String readFileText(String str, String str2) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(closeable2);
                throw th;
            }
            try {
                String loadContent = IoUtils.loadContent(fileInputStream, str2);
                IoUtils.closeQuietly(fileInputStream);
                return loadContent;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                IoUtils.closeQuietly(fileInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            IoUtils.closeQuietly(closeable2);
            throw th;
        }
    }

    public static final void writeToFile(File file, byte[] bArr) {
        if (file == null || bArr == null) {
            return;
        }
        ensureParent(file);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    IoUtils.closeQuietly(fileOutputStream2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    IoUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void deleteDir(File file, boolean z, FileFilter fileFilter) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles(fileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2, z, fileFilter);
                } else {
                    file2.delete();
                }
            }
        }
        if (z) {
            file.delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void writeToFileNio(File file, byte[] bArr) {
        FileChannel fileChannel;
        ReadableByteChannel readableByteChannel;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel2 = null;
        try {
            readableByteChannel = Channels.newChannel(new ByteArrayInputStream(bArr));
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                fileChannel = null;
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
            }
        } catch (IOException e2) {
            e = e2;
            fileChannel = null;
            readableByteChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            readableByteChannel = null;
        }
        try {
            fileChannel2 = fileOutputStream.getChannel();
            fileChannel2.transferFrom(readableByteChannel, 0L, bArr.length);
            IoUtils.closeQuietly(fileOutputStream);
            IoUtils.closeQuietly(readableByteChannel);
            IoUtils.closeQuietly(fileChannel2);
        } catch (IOException e3) {
            e = e3;
            fileChannel = fileChannel2;
            fileChannel2 = fileOutputStream;
            try {
                e.printStackTrace();
                IoUtils.closeQuietly(fileChannel2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
            } catch (Throwable th3) {
                th = th3;
                IoUtils.closeQuietly(fileChannel2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileChannel = fileChannel2;
            fileChannel2 = fileOutputStream;
            IoUtils.closeQuietly(fileChannel2);
            IoUtils.closeQuietly(readableByteChannel);
            IoUtils.closeQuietly(fileChannel);
            throw th;
        }
    }

    public static void deleteDir(File file, boolean z, FilenameFilter filenameFilter) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2, z, filenameFilter);
                } else {
                    file2.delete();
                }
            }
        }
        if (z) {
            file.delete();
        }
    }
}
