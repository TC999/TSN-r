package yaq;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.qq.e.comm.managers.GDTADManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class pro {
    static final int DexNum = 1;
    static final int ERROR_EXCEPTION = -2;
    static final int ERROR_FALSE = 0;
    static final int ERROR_FILE_EXIST = 2;
    static final int ERROR_FILE_MISMATCH = -4;
    static final int ERROR_FILE_NOT_FOUND = -1;
    static final int ERROR_FILE_NOT_FOUND_INZIP = -3;
    static final int ERROR_FLAG = 3;
    static final int ERROR_SUCCESS = 1;
    static String Pluginname = null;
    static String Pluginpath = null;
    static Context ctx = null;
    static final String data2name = "yaq2.sec";
    static final String data3name = "yaq3_0.sec";
    static final String dataname = "yaq.sec";
    static final String libName = "libyaqpro.so";
    static final String libbasicName = "libyaqbasic.so";
    static final String mmalibName = "libMMANDKSignature.so";
    static final String turingauName = "libturingau.so";
    static final String versioncookie = "84354167";
    static final String versionname = "yaqsdkcookie";
    static boolean isdebugmode = false;
    static int arch_code = 0;
    static String LibPath = null;
    static String LibBasicPath = null;
    static String mmaLibPath = null;
    static String turingauLibPath = null;
    static String DataPath = null;
    static String Data2Path = null;
    static String Data3Path = null;
    static long vmpctx = 0;
    static String CPUABI = null;

    public static native byte getBresult(int i4, int i5, Object... objArr);

    public static native char getCresult(int i4, int i5, Object... objArr);

    public static native double getDresult(int i4, int i5, Object... objArr);

    public static native float getFresult(int i4, int i5, Object... objArr);

    public static native int getIresult(int i4, int i5, Object... objArr);

    public static native long getJresult(int i4, int i5, Object... objArr);

    public static native short getSresult(int i4, int i5, Object... objArr);

    public static native void getVresult(int i4, int i5, Object... objArr);

    public static native boolean getZresult(int i4, int i5, Object... objArr);

    public static native Object getobjresult(int i4, int i5, Object... objArr);

    public static native void init(int i4);

    static {
        Pluginpath = null;
        Pluginname = null;
        ctx = null;
        try {
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        } catch (NoSuchFieldException e7) {
            e7.printStackTrace();
        }
        if (Build.VERSION.SDK_INT > 34) {
            throw new UnsupportedOperationException("unsupport OS version");
        }
        ctx = getContextinmainthread();
        if (ctx == null) {
            ctx = GDTADManager.getInstance().getAppContext();
            if (ctx == null) {
                throw new RuntimeException("cannot get context!");
            }
        }
        ClassLoader loader = pro.class.getClassLoader();
        Pluginpath = getAppPath(loader);
        String str = Pluginpath;
        if (str != null) {
            int prepare_result = preparefiles(str);
            if (prepare_result == -2) {
                throw new RuntimeException("prepare secure files error");
            }
            String str2 = Pluginpath;
            int lastslash = Pluginpath.lastIndexOf(47);
            if (lastslash >= 0) {
                String pluginname_tmp = Pluginpath.substring(lastslash + 1);
                Pluginname = pluginname_tmp.substring(0, pluginname_tmp.lastIndexOf(46));
            } else {
                String pluginname_tmp2 = Pluginpath;
                Pluginname = pluginname_tmp2.substring(0, pluginname_tmp2.lastIndexOf(46));
            }
        }
        try {
            if (!loadLib(LibPath) || !loadLib(LibBasicPath)) {
                throw new RuntimeException("load lib error");
            }
            if (!isdebugmode || arch_code == 1 || arch_code == 2) {
                if (!loadLib(mmaLibPath) || !loadLib(turingauLibPath)) {
                    throw new RuntimeException("load lib error");
                }
            }
        } catch (ClassNotFoundException e8) {
            e8.printStackTrace();
            throw new RuntimeException("load lib error");
        } catch (IllegalAccessException e9) {
            e9.printStackTrace();
            throw new RuntimeException("load lib error");
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            throw new RuntimeException("load lib error");
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            throw new RuntimeException("load lib error");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x001a -> B:29:0x0034). Please submit an issue!!! */
    public static int readelfarch(String filename) {
        int c4 = 0;
        RandomAccessFile rf = null;
        try {
            try {
                try {
                    try {
                        rf = new RandomAccessFile(filename, "r");
                        rf.seek(18L);
                        c4 = rf.read();
                        rf.close();
                    } catch (Throwable th) {
                        if (rf != null) {
                            try {
                                rf.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e5.printStackTrace();
                    if (rf != null) {
                        rf.close();
                    }
                }
            } catch (IOException e6) {
                e6.printStackTrace();
                if (rf != null) {
                    rf.close();
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        return c4;
    }

    public static HashSet<String> getsecfilelist(String plugindir) {
        HashSet<String> secfilelist = new HashSet<>();
        String[] allfilelist = new File(plugindir).list();
        for (String filename : allfilelist) {
            if (filename.matches("^libyaqpro.[0-9a-fA-F]+.so$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^libyaqbasic.[0-9a-fA-F]+.so$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^dexMethod.[0-9a-fA-F]+.dat$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^yaq.[0-9a-fA-F]+.sec$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^yaq2.[0-9a-fA-F]+.sec$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^yaq3_[0-9].[0-9a-fA-F]+.sec$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^libMMANDKSignature.[0-9a-fA-F]+.so$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^libturingau.[0-9a-fA-F]+.so$")) {
                secfilelist.add(filename);
            }
        }
        return secfilelist;
    }

    public static HashSet<String> getcookiefilelist(String plugindir) {
        HashSet<String> cookiefilelist = new HashSet<>();
        String[] allfilelist = new File(plugindir).list();
        for (String filename : allfilelist) {
            if (filename.matches("^\\d+.yaqcookie$")) {
                cookiefilelist.add(filename);
            }
        }
        return cookiefilelist;
    }

    public static String getelffilearch(String elffile, boolean isemumode) {
        String file_arch;
        String file_arch2;
        int archcode = readelfarch(elffile);
        if (archcode == 3) {
            if (isdebugmode && !isemumode) {
                file_arch = "x86";
            } else {
                file_arch = "armeabi";
            }
            arch_code = 3;
            return file_arch;
        } else if (archcode == 40) {
            arch_code = 1;
            return "armeabi";
        } else if (archcode != 62) {
            if (archcode == 183) {
                arch_code = 2;
                return "arm64-v8a";
            }
            arch_code = 999;
            return "unknown";
        } else {
            if (isdebugmode && !isemumode) {
                file_arch2 = "x86_64";
            } else {
                file_arch2 = "arm64-v8a";
            }
            arch_code = 4;
            return file_arch2;
        }
    }

    static boolean loadLib(String libPath) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException {
        Method tmpLoadlib;
        boolean result = false;
        Runtime tmpruntime = Runtime.getRuntime();
        Class clazz = Class.forName("java.lang.Runtime");
        Class[] argsClass = {String.class, ClassLoader.class};
        if (Build.VERSION.SDK_INT > 27) {
            tmpLoadlib = clazz.getDeclaredMethod("nativeLoad", argsClass);
            tmpLoadlib.setAccessible(true);
        } else if (Build.VERSION.SDK_INT > 24) {
            tmpLoadlib = clazz.getDeclaredMethod("doLoad", argsClass);
            tmpLoadlib.setAccessible(true);
        } else {
            tmpLoadlib = clazz.getDeclaredMethod("load", argsClass);
            tmpLoadlib.setAccessible(true);
        }
        ClassLoader loader = pro.class.getClassLoader();
        try {
            if (Build.VERSION.SDK_INT > 24) {
                String errormasg = (String) tmpLoadlib.invoke(tmpruntime, libPath, loader);
                if (errormasg == null) {
                    result = true;
                }
            } else {
                tmpLoadlib.invoke(tmpruntime, libPath, loader);
                result = true;
            }
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return result;
    }

    public static int writepidcookie(String plugindir, int pid, String cookie) {
        File Cookiefile = new File(plugindir + TTPathConst.sSeparator + pid + ".yaqcookie");
        BufferedOutputStream checkfbr = null;
        try {
            try {
                checkfbr = new BufferedOutputStream(new FileOutputStream(Cookiefile));
                checkfbr.write(cookie.getBytes());
                try {
                    checkfbr.close();
                    return 1;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return -2;
                }
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return -2;
                    }
                }
                return -1;
            } catch (IOException e7) {
                e7.printStackTrace();
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        return -2;
                    }
                }
                return -2;
            }
        } catch (Throwable e9) {
            if (checkfbr != null) {
                try {
                    checkfbr.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                    return -2;
                }
            }
            throw e9;
        }
    }

    public static int createcookiefile(File Cookiefile, String cookie) {
        BufferedOutputStream checkfbr = null;
        try {
            try {
                try {
                    checkfbr = new BufferedOutputStream(new FileOutputStream(Cookiefile));
                    checkfbr.write(cookie.getBytes());
                    try {
                        checkfbr.close();
                        return 1;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return -2;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                    if (checkfbr != null) {
                        try {
                            checkfbr.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return -2;
                        }
                    }
                    return -2;
                }
            } catch (FileNotFoundException e7) {
                e7.printStackTrace();
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        return -2;
                    }
                }
                return -1;
            }
        } catch (Throwable e9) {
            if (checkfbr != null) {
                try {
                    checkfbr.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                    return -2;
                }
            }
            throw e9;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static void cleanfiles(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: yaq.pro.cleanfiles(java.lang.String):void");
    }

    private static String readcookiefile(File pidcookie) {
        byte[] checkfilebuf = new byte[8];
        BufferedInputStream checkfbr = null;
        String tmpfilestr = null;
        try {
            try {
                checkfbr = new BufferedInputStream(new FileInputStream(pidcookie));
                checkfbr.read(checkfilebuf);
                tmpfilestr = new String(checkfilebuf);
                checkfbr.close();
            } catch (FileNotFoundException e12) {
                e12.printStackTrace();
                if (checkfbr != null) {
                    checkfbr.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (checkfbr != null) {
                    checkfbr.close();
                }
            }
            return tmpfilestr;
        } catch (IOException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static int Comparecookie(ZipFile pluginzf, String filepathinzip, File fileinfiledir) {
        BufferedInputStream checkzbr = null;
        BufferedInputStream checkfbr = null;
        try {
            try {
                ZipEntry cookie_entry = pluginzf.getEntry(filepathinzip);
                if (cookie_entry == null) {
                    if (0 != 0) {
                        try {
                            try {
                                checkzbr.close();
                                if (0 != 0) {
                                    try {
                                        checkfbr.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        return -2;
                                    }
                                }
                            } catch (Throwable e5) {
                                if (0 != 0) {
                                    try {
                                        checkfbr.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                        return -2;
                                    }
                                }
                                throw e5;
                            }
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                    return -2;
                                }
                            }
                            return -2;
                        }
                    }
                    return -3;
                }
                byte[] checkzipbuf = new byte[8];
                checkzbr = new BufferedInputStream(pluginzf.getInputStream(cookie_entry));
                int readziplen = checkzbr.read(checkzipbuf);
                String tmpzipstr = new String(checkzipbuf).substring(0, readziplen);
                if (!tmpzipstr.equals(versioncookie)) {
                    try {
                        try {
                            checkzbr.close();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                    return -2;
                                }
                            }
                            return -4;
                        } catch (Throwable e10) {
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                    return -2;
                                }
                            }
                            throw e10;
                        }
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        if (0 != 0) {
                            try {
                                checkfbr.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                                return -2;
                            }
                        }
                        return -2;
                    }
                } else if (fileinfiledir == null) {
                    try {
                        try {
                            checkzbr.close();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                    return -2;
                                }
                            }
                            return 1;
                        } catch (IOException e15) {
                            e15.printStackTrace();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    return -2;
                                }
                            }
                            return -2;
                        }
                    } catch (Throwable e17) {
                        if (0 != 0) {
                            try {
                                checkfbr.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                return -2;
                            }
                        }
                        throw e17;
                    }
                } else {
                    byte[] checkfilebuf = new byte[8];
                    checkfbr = new BufferedInputStream(new FileInputStream(fileinfiledir));
                    int readfilelen = checkfbr.read(checkfilebuf);
                    String tmpfilestr = new String(checkfilebuf).substring(0, readfilelen);
                    int result = tmpfilestr.equals(tmpzipstr) ? 1 : 0;
                    try {
                        try {
                            checkzbr.close();
                            try {
                                checkfbr.close();
                                return result;
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                return -2;
                            }
                        } catch (Throwable e20) {
                            try {
                                checkfbr.close();
                                throw e20;
                            } catch (IOException e21) {
                                e21.printStackTrace();
                                return -2;
                            }
                        }
                    } catch (IOException e22) {
                        e22.printStackTrace();
                        try {
                            checkfbr.close();
                            return -2;
                        } catch (IOException e23) {
                            e23.printStackTrace();
                            return -2;
                        }
                    }
                }
            } catch (Throwable e24) {
                try {
                    if (checkzbr != null) {
                        try {
                            checkzbr.close();
                            if (checkfbr != null) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e25) {
                                    e25.printStackTrace();
                                    return -2;
                                }
                            }
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            if (checkfbr != null) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                    return -2;
                                }
                            }
                            return -2;
                        }
                    }
                    throw e24;
                } catch (Throwable e28) {
                    if (checkfbr != null) {
                        try {
                            checkfbr.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                            return -2;
                        }
                    }
                    throw e28;
                }
            }
        } catch (Exception e30) {
            e30.printStackTrace();
            try {
                if (checkzbr != null) {
                    try {
                        checkzbr.close();
                        if (checkfbr != null) {
                            try {
                                checkfbr.close();
                            } catch (IOException e31) {
                                e31.printStackTrace();
                                return -2;
                            }
                        }
                    } catch (IOException e32) {
                        e32.printStackTrace();
                        if (checkfbr != null) {
                            try {
                                checkfbr.close();
                            } catch (IOException e33) {
                                e33.printStackTrace();
                                return -2;
                            }
                        }
                        return -2;
                    }
                }
                return -2;
            } catch (Throwable e34) {
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e35) {
                        e35.printStackTrace();
                        return -2;
                    }
                }
                throw e34;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:1078:0x0cd6  */
    /* JADX WARN: Removed duplicated region for block: B:1338:0x0f67  */
    /* JADX WARN: Removed duplicated region for block: B:1596:0x11f7  */
    /* JADX WARN: Removed duplicated region for block: B:1853:0x1466 A[Catch: all -> 0x07a9, Exception -> 0x07af, TRY_ENTER, TryCatch #967 {Exception -> 0x07af, all -> 0x07a9, blocks: (B:302:0x051c, B:306:0x052e, B:822:0x0a50, B:826:0x0a5b, B:1339:0x0f69, B:1343:0x0f77, B:1853:0x1466, B:1857:0x1471, B:2361:0x192e, B:2365:0x1939, B:2878:0x1e4b, B:2882:0x1e56, B:3395:0x2364, B:3399:0x2372, B:3908:0x285b, B:3658:0x2606, B:3140:0x20e1, B:2624:0x1bca, B:2110:0x16d3, B:1602:0x120d, B:1084:0x0ce6, B:568:0x07cf), top: B:6367:0x051a }] */
    /* JADX WARN: Removed duplicated region for block: B:2105:0x16c4 A[Catch: all -> 0x2aac, Exception -> 0x2ab2, TRY_ENTER, TRY_LEAVE, TryCatch #963 {Exception -> 0x2ab2, all -> 0x2aac, blocks: (B:300:0x047b, B:820:0x0a4a, B:1336:0x0f61, B:1851:0x1460, B:2358:0x1926, B:2876:0x1e45, B:3392:0x235c, B:3910:0x2860, B:3653:0x25f7, B:3135:0x20d3, B:2619:0x1bbc, B:2105:0x16c4, B:1597:0x11fe, B:1079:0x0cd8, B:563:0x07c1), top: B:6374:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:2360:0x192c  */
    /* JADX WARN: Removed duplicated region for block: B:2618:0x1bb7  */
    /* JADX WARN: Removed duplicated region for block: B:2878:0x1e4b A[Catch: all -> 0x07a9, Exception -> 0x07af, TRY_ENTER, TryCatch #967 {Exception -> 0x07af, all -> 0x07a9, blocks: (B:302:0x051c, B:306:0x052e, B:822:0x0a50, B:826:0x0a5b, B:1339:0x0f69, B:1343:0x0f77, B:1853:0x1466, B:1857:0x1471, B:2361:0x192e, B:2365:0x1939, B:2878:0x1e4b, B:2882:0x1e56, B:3395:0x2364, B:3399:0x2372, B:3908:0x285b, B:3658:0x2606, B:3140:0x20e1, B:2624:0x1bca, B:2110:0x16d3, B:1602:0x120d, B:1084:0x0ce6, B:568:0x07cf), top: B:6367:0x051a }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x051c A[Catch: all -> 0x07a9, Exception -> 0x07af, TRY_ENTER, TryCatch #967 {Exception -> 0x07af, all -> 0x07a9, blocks: (B:302:0x051c, B:306:0x052e, B:822:0x0a50, B:826:0x0a5b, B:1339:0x0f69, B:1343:0x0f77, B:1853:0x1466, B:1857:0x1471, B:2361:0x192e, B:2365:0x1939, B:2878:0x1e4b, B:2882:0x1e56, B:3395:0x2364, B:3399:0x2372, B:3908:0x285b, B:3658:0x2606, B:3140:0x20e1, B:2624:0x1bca, B:2110:0x16d3, B:1602:0x120d, B:1084:0x0ce6, B:568:0x07cf), top: B:6367:0x051a }] */
    /* JADX WARN: Removed duplicated region for block: B:3134:0x20d1  */
    /* JADX WARN: Removed duplicated region for block: B:3394:0x2362  */
    /* JADX WARN: Removed duplicated region for block: B:3652:0x25f1  */
    /* JADX WARN: Removed duplicated region for block: B:3908:0x285b A[Catch: all -> 0x07a9, Exception -> 0x07af, TRY_ENTER, TRY_LEAVE, TryCatch #967 {Exception -> 0x07af, all -> 0x07a9, blocks: (B:302:0x051c, B:306:0x052e, B:822:0x0a50, B:826:0x0a5b, B:1339:0x0f69, B:1343:0x0f77, B:1853:0x1466, B:1857:0x1471, B:2361:0x192e, B:2365:0x1939, B:2878:0x1e4b, B:2882:0x1e56, B:3395:0x2364, B:3399:0x2372, B:3908:0x285b, B:3658:0x2606, B:3140:0x20e1, B:2624:0x1bca, B:2110:0x16d3, B:1602:0x120d, B:1084:0x0ce6, B:568:0x07cf), top: B:6367:0x051a }] */
    /* JADX WARN: Removed duplicated region for block: B:3910:0x2860 A[Catch: all -> 0x2aac, Exception -> 0x2ab2, TRY_ENTER, TRY_LEAVE, TryCatch #963 {Exception -> 0x2ab2, all -> 0x2aac, blocks: (B:300:0x047b, B:820:0x0a4a, B:1336:0x0f61, B:1851:0x1460, B:2358:0x1926, B:2876:0x1e45, B:3392:0x235c, B:3910:0x2860, B:3653:0x25f7, B:3135:0x20d3, B:2619:0x1bbc, B:2105:0x16c4, B:1597:0x11fe, B:1079:0x0cd8, B:563:0x07c1), top: B:6374:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:3918:0x287f  */
    /* JADX WARN: Removed duplicated region for block: B:4001:0x2938 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:4456:0x2de9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:5031:0x2df7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5463:0x2889 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:562:0x07bd  */
    /* JADX WARN: Removed duplicated region for block: B:6259:0x2c0b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:822:0x0a50 A[Catch: all -> 0x07a9, Exception -> 0x07af, TRY_ENTER, TryCatch #967 {Exception -> 0x07af, all -> 0x07a9, blocks: (B:302:0x051c, B:306:0x052e, B:822:0x0a50, B:826:0x0a5b, B:1339:0x0f69, B:1343:0x0f77, B:1853:0x1466, B:1857:0x1471, B:2361:0x192e, B:2365:0x1939, B:2878:0x1e4b, B:2882:0x1e56, B:3395:0x2364, B:3399:0x2372, B:3908:0x285b, B:3658:0x2606, B:3140:0x20e1, B:2624:0x1bca, B:2110:0x16d3, B:1602:0x120d, B:1084:0x0ce6, B:568:0x07cf), top: B:6367:0x051a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int preparefiles(java.lang.String r42) {
        /*
            Method dump skipped, instructions count: 12364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: yaq.pro.preparefiles(java.lang.String):int");
    }

    static String getAppPath(ClassLoader loader) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, ClassNotFoundException {
        String[] outPathList;
        if (Build.VERSION.SDK_INT >= 9 && Build.VERSION.SDK_INT <= 13) {
            Field loaderfield = Class.forName("dalvik.system.DexClassLoader").getDeclaredField("mFiles");
            loaderfield.setAccessible(true);
            Object[] objelements = (Object[]) loaderfield.get(loader);
            outPathList = new String[objelements.length];
            for (int i4 = 0; i4 < objelements.length; i4++) {
                File fileelement = (File) objelements[i4];
                if (fileelement != null) {
                    outPathList[i4] = fileelement.getAbsolutePath();
                }
            }
        } else {
            Field loaderfield2 = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
            loaderfield2.setAccessible(true);
            Object objdexpathlist = loaderfield2.get(loader);
            Field pathlistfield = objdexpathlist.getClass().getDeclaredField("dexElements");
            pathlistfield.setAccessible(true);
            Object[] objelements2 = (Object[]) pathlistfield.get(objdexpathlist);
            outPathList = new String[objelements2.length];
            for (int i5 = 0; i5 < objelements2.length; i5++) {
                try {
                    Field zipfield = objelements2[i5].getClass().getDeclaredField("zip");
                    zipfield.setAccessible(true);
                    File zip = (File) zipfield.get(objelements2[i5]);
                    if (zip != null) {
                        outPathList[i5] = zip.getAbsolutePath();
                    }
                } catch (NoSuchFieldException e4) {
                    try {
                        Field zipfilefield = objelements2[i5].getClass().getDeclaredField("zipFile");
                        zipfilefield.setAccessible(true);
                        ZipFile zipFile = (ZipFile) zipfilefield.get(objelements2[i5]);
                        outPathList[i5] = new File(zipFile.getName()).getAbsolutePath();
                    } catch (NoSuchFieldException e5) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            String elementstoString = objelements2[i5].toString();
                            int iszipfile = elementstoString.indexOf("zip file");
                            if (iszipfile == 0) {
                                int lastindexofquotes = elementstoString.lastIndexOf("\"");
                                int lastlastindexofquotes = elementstoString.lastIndexOf("\"", lastindexofquotes - 1);
                                outPathList[i5] = elementstoString.substring(lastlastindexofquotes + 1, lastindexofquotes);
                            }
                        } else {
                            Field pathfield = objelements2[i5].getClass().getDeclaredField("path");
                            pathfield.setAccessible(true);
                            File path = (File) pathfield.get(objelements2[i5]);
                            if (path != null) {
                                outPathList[i5] = path.getAbsolutePath();
                            }
                        }
                    }
                }
            }
        }
        try {
            if (outPathList[0] == null) {
                return null;
            }
            String result = new File(outPathList[0]).getCanonicalPath();
            return result;
        } catch (IOException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    static Context getContextinmainthread() {
        int tid = Process.myTid();
        int pid = Process.myPid();
        if (tid == pid) {
            return getContext();
        }
        return getContextRaw();
    }

    static Handler getMainHandler() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class activityThreadClass = Class.forName("android.app.ActivityThread");
        Field handlerfield = activityThreadClass.getDeclaredField("sMainThreadHandler");
        handlerfield.setAccessible(true);
        Handler handler = (Handler) handlerfield.get(activityThreadClass);
        return handler;
    }

    static Context getContextinner(Class activityThreadClass, Object objactivityThread) {
        try {
            Method getappmethod = activityThreadClass.getMethod("getApplication", new Class[0]);
            Context tmpctx = (Context) getappmethod.invoke(objactivityThread, new Object[0]);
            return tmpctx;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
            return null;
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    static Context getContextnormal(Class activityThreadClass) {
        try {
            Method getthreadmethod = activityThreadClass.getMethod("currentActivityThread", new Class[0]);
            Object threadtmp = getthreadmethod.invoke(null, new Object[0]);
            Context tmpctx = getContextinner(activityThreadClass, threadtmp);
            return tmpctx;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
            return null;
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:21:0x00c3
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    static android.content.Context getContextRaw() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: yaq.pro.getContextRaw():android.content.Context");
    }

    static Context getContext() {
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Context tmpctx = getContextnormal(activityThreadClass);
            return tmpctx;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static int SafeUnzipFile(ZipFile zf, String filepathinzip, File fileinfiledir) {
        return SafeUnzipFile(zf, filepathinzip, fileinfiledir, 0L);
    }

    public static int SafeUnzipFile(ZipFile zf, String filepathinzip, File fileinfiledir, long crc) {
        BufferedOutputStream Output_fos = null;
        try {
            try {
                ZipEntry ze = zf.getEntry(filepathinzip);
                if (ze == null) {
                    if (0 != 0) {
                        try {
                            Output_fos.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return -2;
                        }
                    }
                    return -3;
                } else if (crc != 0 && ze.getCrc() == crc) {
                    if (0 != 0) {
                        try {
                            Output_fos.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            return -2;
                        }
                    }
                    return 1;
                } else {
                    byte[] buf = UnzipFile(zf, ze);
                    int compareResult = Comparecookie(zf, "assets/yaqsdkcookie", null);
                    if (compareResult != 1) {
                        if (0 != 0) {
                            try {
                                Output_fos.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                return -2;
                            }
                        }
                        return compareResult;
                    }
                    if (1 != 0) {
                        Output_fos = new BufferedOutputStream(new FileOutputStream(fileinfiledir));
                        Output_fos.write(buf, 0, buf.length);
                    }
                    if (Output_fos != null) {
                        try {
                            Output_fos.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            return -2;
                        }
                    }
                    return 1;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                if (Output_fos != null) {
                    try {
                        Output_fos.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return -2;
                    }
                }
                return -2;
            }
        } catch (Throwable e10) {
            if (Output_fos != null) {
                try {
                    Output_fos.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    return -2;
                }
            }
            throw e10;
        }
    }

    public static byte[] UnzipFile(ZipFile zf, ZipEntry ze) throws IOException {
        byte[] buf = new byte[(int) ze.getSize()];
        BufferedInputStream bufbr = new BufferedInputStream(zf.getInputStream(ze));
        int totallen = 0;
        do {
            try {
                int readlen = bufbr.read(buf, totallen, ((int) ze.getSize()) - totallen);
                if (readlen < 0) {
                    break;
                }
                totallen += readlen;
            } catch (Throwable th) {
                try {
                    bufbr.close();
                    throw th;
                } catch (IOException e4) {
                    throw e4;
                }
            }
        } while (totallen != ze.getSize());
        if (totallen != ((int) ze.getSize())) {
            throw new IOException("incorrect zip file size");
        }
        try {
            bufbr.close();
            return buf;
        } catch (IOException e5) {
            throw e5;
        }
    }

    public static String getCPUABI() {
        if (CPUABI == null) {
            try {
                String os_cpuabi = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
                if (os_cpuabi.contains("x86")) {
                    CPUABI = "x86";
                } else if (os_cpuabi.contains("arm64-v8a")) {
                    CPUABI = "arm64-v8a";
                } else if (os_cpuabi.contains("armeabi-v7a")) {
                    CPUABI = "armeabi-v7a";
                } else {
                    CPUABI = "armeabi";
                }
            } catch (Exception e4) {
                CPUABI = "armeabi";
            }
        }
        return CPUABI;
    }

    public static String getCRC32HEX(String cookie, String path) {
        CRC32 crc32 = new CRC32();
        crc32.update((cookie + path).getBytes());
        int crc32_result = (int) crc32.getValue();
        String hex_int = Integer.toHexString(crc32_result);
        return ("00000000" + hex_int).substring(hex_int.length(), hex_int.length() + 8);
    }

    private static long getFileCRC32(File file) {
        long result = -1;
        byte[] filebuf = new byte[(int) file.length()];
        BufferedInputStream filebr = null;
        CRC32 crc32 = new CRC32();
        try {
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        try {
            try {
                filebr = new BufferedInputStream(new FileInputStream(file));
                int totallen = 0;
                while (true) {
                    int readlen = filebr.read(filebuf);
                    if (readlen < 0) {
                        break;
                    }
                    crc32.update(filebuf);
                    totallen += readlen;
                }
                result = crc32.getValue();
                filebr.close();
            } catch (FileNotFoundException e12) {
                e12.printStackTrace();
                if (filebr != null) {
                    filebr.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
                if (filebr != null) {
                    filebr.close();
                }
            }
            return result;
        } catch (Throwable th) {
            if (filebr != null) {
                try {
                    filebr.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void setaccessible(Constructor a4) {
        a4.setAccessible(true);
    }

    public static void setaccessible(Method a4) {
        a4.setAccessible(true);
    }

    public static void setaccessible(Field a4) {
        a4.setAccessible(true);
    }

    public static Object setaccessibleobj(Class a4) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor c4 = a4.getDeclaredConstructor(new Class[0]);
        c4.setAccessible(true);
        Object result = c4.newInstance(new Object[0]);
        return result;
    }
}
