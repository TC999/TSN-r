package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class NativeLibraryLoader {
    private static final String NATIVE_RESOURCE_HOME = "META-INF/native/";
    private static final String OSNAME;
    private static final File WORKDIR;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(NativeLibraryLoader.class);
        logger = internalLoggerFactory;
        OSNAME = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
        String str = SystemPropertyUtil.get("io.netty.native.workdir");
        if (str != null) {
            File file = new File(str);
            file.mkdirs();
            try {
                file = file.getAbsoluteFile();
            } catch (Exception unused) {
            }
            WORKDIR = file;
            InternalLogger internalLogger = logger;
            internalLogger.debug("-Dio.netty.native.workdir: " + file);
            return;
        }
        File tmpdir = tmpdir();
        WORKDIR = tmpdir;
        internalLoggerFactory.debug("-Dio.netty.native.workdir: " + tmpdir + " (io.netty.tmpdir)");
    }

    private NativeLibraryLoader() {
    }

    private static byte[] classToByteArray(Class<?> cls) throws ClassNotFoundException {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            name = name.substring(lastIndexOf + 1);
        }
        URL resource = cls.getResource(name + ".class");
        if (resource != null) {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
            InputStream inputStream = null;
            try {
                try {
                    inputStream = resource.openStream();
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            return byteArrayOutputStream.toByteArray();
                        }
                    }
                } catch (IOException e) {
                    throw new ClassNotFoundException(cls.getName(), e);
                }
            } finally {
                closeQuietly(inputStream);
                closeQuietly(byteArrayOutputStream);
            }
        } else {
            throw new ClassNotFoundException(cls.getName());
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static boolean isOSX() {
        String str = OSNAME;
        return str.startsWith("macosx") || str.startsWith("osx");
    }

    private static boolean isWindows() {
        return OSNAME.startsWith("windows");
    }

    public static void load(String str, ClassLoader classLoader) {
        File file;
        FileOutputStream fileOutputStream;
        String mapLibraryName = System.mapLibraryName(str);
        String str2 = NATIVE_RESOURCE_HOME + mapLibraryName;
        URL resource = classLoader.getResource(str2);
        if (resource == null && isOSX()) {
            if (str2.endsWith(".jnilib")) {
                resource = classLoader.getResource("META-INF/native/lib" + str + ".dynlib");
            } else {
                resource = classLoader.getResource("META-INF/native/lib" + str + ".jnilib");
            }
        }
        if (resource == null) {
            loadLibrary(classLoader, str, false);
            return;
        }
        int lastIndexOf = mapLibraryName.lastIndexOf(46);
        String substring = mapLibraryName.substring(0, lastIndexOf);
        String substring2 = mapLibraryName.substring(lastIndexOf, mapLibraryName.length());
        InputStream inputStream = null;
        try {
            file = File.createTempFile(substring, substring2, WORKDIR);
            try {
                InputStream openStream = resource.openStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = openStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        loadLibrary(classLoader, file.getPath(), true);
                        closeQuietly(openStream);
                        closeQuietly(fileOutputStream);
                        if (file.delete()) {
                            return;
                        }
                        file.deleteOnExit();
                    } catch (Exception e) {
                        e = e;
                        inputStream = openStream;
                        try {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("could not load a native library: " + str).initCause(e));
                        } catch (Throwable th) {
                            th = th;
                            closeQuietly(inputStream);
                            closeQuietly(fileOutputStream);
                            if (file != null && !file.delete()) {
                                file.deleteOnExit();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openStream;
                        closeQuietly(inputStream);
                        closeQuietly(fileOutputStream);
                        if (file != null) {
                            file.deleteOnExit();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            file = null;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            file = null;
            fileOutputStream = null;
        }
    }

    public static void loadFirstAvailable(ClassLoader classLoader, String... strArr) {
        for (String str : strArr) {
            try {
                load(str, classLoader);
                return;
            } catch (Throwable th) {
                logger.debug("Unable to load the library: " + str + '.', th);
            }
        }
        throw new IllegalArgumentException("Failed to load any of the given libraries: " + Arrays.toString(strArr));
    }

    private static void loadLibrary(ClassLoader classLoader, String str, boolean z) {
        try {
            loadLibraryByHelper(tryToLoadClass(classLoader, NativeLibraryUtil.class), str, z);
        } catch (Exception e) {
            InternalLogger internalLogger = logger;
            internalLogger.debug("Unable to load the library: " + str + '.', (Throwable) e);
            NativeLibraryUtil.loadLibrary(str, z);
        }
    }

    private static void loadLibraryByHelper(final Class<?> cls, final String str, final boolean z) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.NativeLibraryLoader.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    Method method = cls.getMethod("loadLibrary", String.class, Boolean.TYPE);
                    method.setAccessible(true);
                    return method.invoke(null, str, Boolean.valueOf(z));
                } catch (Exception e) {
                    throw new IllegalStateException("Load library failed!", e);
                }
            }
        });
    }

    private static File tmpdir() {
        File file;
        File directory;
        try {
            directory = toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
        } catch (Exception unused) {
        }
        if (directory != null) {
            InternalLogger internalLogger = logger;
            internalLogger.debug("-Dio.netty.tmpdir: " + directory);
            return directory;
        }
        File directory2 = toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
        if (directory2 != null) {
            InternalLogger internalLogger2 = logger;
            internalLogger2.debug("-Dio.netty.tmpdir: " + directory2 + " (java.io.tmpdir)");
            return directory2;
        }
        if (isWindows()) {
            File directory3 = toDirectory(System.getenv("TEMP"));
            if (directory3 != null) {
                InternalLogger internalLogger3 = logger;
                internalLogger3.debug("-Dio.netty.tmpdir: " + directory3 + " (%TEMP%)");
                return directory3;
            }
            String str = System.getenv("USERPROFILE");
            if (str != null) {
                File directory4 = toDirectory(str + "\\AppData\\Local\\Temp");
                if (directory4 != null) {
                    InternalLogger internalLogger4 = logger;
                    internalLogger4.debug("-Dio.netty.tmpdir: " + directory4 + " (%USERPROFILE%\\AppData\\Local\\Temp)");
                    return directory4;
                }
                File directory5 = toDirectory(str + "\\Local Settings\\Temp");
                if (directory5 != null) {
                    InternalLogger internalLogger5 = logger;
                    internalLogger5.debug("-Dio.netty.tmpdir: " + directory5 + " (%USERPROFILE%\\Local Settings\\Temp)");
                    return directory5;
                }
            }
        } else {
            File directory6 = toDirectory(System.getenv("TMPDIR"));
            if (directory6 != null) {
                InternalLogger internalLogger6 = logger;
                internalLogger6.debug("-Dio.netty.tmpdir: " + directory6 + " ($TMPDIR)");
                return directory6;
            }
        }
        if (isWindows()) {
            file = new File("C:\\Windows\\Temp");
        } else {
            file = new File("/tmp");
        }
        InternalLogger internalLogger7 = logger;
        internalLogger7.warn("Failed to get the temporary directory; falling back to: " + file);
        return file;
    }

    private static File toDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (file.isDirectory()) {
            try {
                return file.getAbsoluteFile();
            } catch (Exception unused) {
                return file;
            }
        }
        return null;
    }

    private static Class<?> tryToLoadClass(final ClassLoader classLoader, final Class<?> cls) throws ClassNotFoundException {
        try {
            return classLoader.loadClass(cls.getName());
        } catch (ClassNotFoundException unused) {
            final byte[] classToByteArray = classToByteArray(cls);
            return (Class) AccessController.doPrivileged(new PrivilegedAction<Class<?>>() { // from class: io.netty.util.internal.NativeLibraryLoader.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public Class<?> run() {
                    try {
                        Class cls2 = Integer.TYPE;
                        Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls2, cls2);
                        declaredMethod.setAccessible(true);
                        return (Class) declaredMethod.invoke(classLoader, cls.getName(), classToByteArray, 0, Integer.valueOf(classToByteArray.length));
                    } catch (Exception e) {
                        throw new IllegalStateException("Define class failed!", e);
                    }
                }
            });
        }
    }
}
