package tv.cjump.jni;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DeviceUtils {

    /* renamed from: a */
    public static final String f47125a = "x86";

    /* renamed from: b */
    public static final String f47126b = "mips";

    /* renamed from: c */
    private static ARCH f47127c = ARCH.Unknown;

    /* renamed from: d */
    private static final int f47128d = 40;

    /* renamed from: e */
    private static final int f47129e = 3;

    /* renamed from: f */
    private static final int f47130f = 8;

    /* renamed from: g */
    private static final int f47131g = 183;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum ARCH {
        Unknown,
        ARM,
        X86,
        MIPS,
        ARM64
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* renamed from: a */
    public static synchronized ARCH m279a() {
        RandomAccessFile randomAccessFile;
        ?? r3;
        synchronized (DeviceUtils.class) {
            byte[] bArr = new byte[20];
            File file = new File(Environment.getRootDirectory(), "lib/libc.so");
            if (file.canRead()) {
                RandomAccessFile randomAccessFile2 = null;
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                    } catch (FileNotFoundException e) {
                        e = e;
                    } catch (IOException e2) {
                        e = e2;
                    }
                    try {
                        randomAccessFile.readFully(bArr);
                        r3 = 8;
                        r3 = 8;
                        r3 = 8;
                        r3 = 8;
                        int i = bArr[18] | (bArr[19] << 8);
                        if (i == 3) {
                            f47127c = ARCH.X86;
                        } else if (i == 8) {
                            f47127c = ARCH.MIPS;
                        } else if (i == 40) {
                            f47127c = ARCH.ARM;
                        } else if (i != 183) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("libc.so is unknown arch: ");
                            sb.append(Integer.toHexString(i));
                            Log.e("NativeBitmapFactory", sb.toString());
                            r3 = sb;
                        } else {
                            f47127c = ARCH.ARM64;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e4) {
                                e = e4;
                                e.printStackTrace();
                                return f47127c;
                            }
                        }
                        return f47127c;
                    } catch (IOException e5) {
                        e = e5;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e6) {
                                e = e6;
                                e.printStackTrace();
                                return f47127c;
                            }
                        }
                        return f47127c;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        randomAccessFile2 = r3;
                    } catch (IOException e8) {
                        e = e8;
                        e.printStackTrace();
                        return f47127c;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return f47127c;
    }

    /* renamed from: b */
    public static String m278b() {
        return Build.CPU_ABI;
    }

    /* renamed from: c */
    public static String m277c() {
        try {
            Field declaredField = Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            Object obj = declaredField.get(null);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m276d() {
        return !m268l() && ARCH.X86.equals(m279a());
    }

    /* renamed from: e */
    public static boolean m275e() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    /* renamed from: f */
    public static boolean m274f() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    /* renamed from: g */
    public static boolean m273g() {
        return m274f() || m275e();
    }

    /* renamed from: h */
    public static boolean m272h() {
        return (m270j("armeabi-v7a") || m270j("armeabi")) && ARCH.ARM.equals(m279a());
    }

    /* renamed from: i */
    public static boolean m271i() {
        return m270j(f47125a) || ARCH.X86.equals(m279a());
    }

    /* renamed from: j */
    public static boolean m270j(String str) {
        String m278b = m278b();
        if (TextUtils.isEmpty(m278b) || !m278b.equalsIgnoreCase(str)) {
            return !TextUtils.isEmpty(m277c()) && m278b.equalsIgnoreCase(str);
        }
        return true;
    }

    /* renamed from: k */
    public static boolean m269k() {
        return m270j(f47126b);
    }

    /* renamed from: l */
    public static boolean m268l() {
        return m270j(f47125a);
    }
}
