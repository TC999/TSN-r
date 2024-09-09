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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class DeviceUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f64401a = "x86";

    /* renamed from: b  reason: collision with root package name */
    public static final String f64402b = "mips";

    /* renamed from: c  reason: collision with root package name */
    private static ARCH f64403c = ARCH.Unknown;

    /* renamed from: d  reason: collision with root package name */
    private static final int f64404d = 40;

    /* renamed from: e  reason: collision with root package name */
    private static final int f64405e = 3;

    /* renamed from: f  reason: collision with root package name */
    private static final int f64406f = 8;

    /* renamed from: g  reason: collision with root package name */
    private static final int f64407g = 183;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
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
    public static synchronized ARCH a() {
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
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    } catch (IOException e5) {
                        e = e5;
                    }
                    try {
                        randomAccessFile.readFully(bArr);
                        r3 = 8;
                        r3 = 8;
                        r3 = 8;
                        r3 = 8;
                        int i4 = bArr[18] | (bArr[19] << 8);
                        if (i4 == 3) {
                            f64403c = ARCH.X86;
                        } else if (i4 == 8) {
                            f64403c = ARCH.MIPS;
                        } else if (i4 == 40) {
                            f64403c = ARCH.ARM;
                        } else if (i4 != 183) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("libc.so is unknown arch: ");
                            sb.append(Integer.toHexString(i4));
                            Log.e("NativeBitmapFactory", sb.toString());
                            r3 = sb;
                        } else {
                            f64403c = ARCH.ARM64;
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e7) {
                                e = e7;
                                e.printStackTrace();
                                return f64403c;
                            }
                        }
                        return f64403c;
                    } catch (IOException e8) {
                        e = e8;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e9) {
                                e = e9;
                                e.printStackTrace();
                                return f64403c;
                            }
                        }
                        return f64403c;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        randomAccessFile2 = r3;
                    } catch (IOException e11) {
                        e = e11;
                        e.printStackTrace();
                        return f64403c;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return f64403c;
    }

    public static String b() {
        return Build.CPU_ABI;
    }

    public static String c() {
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

    public static boolean d() {
        return !l() && ARCH.X86.equals(a());
    }

    public static boolean e() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    public static boolean f() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    public static boolean g() {
        return f() || e();
    }

    public static boolean h() {
        return (j("armeabi-v7a") || j("armeabi")) && ARCH.ARM.equals(a());
    }

    public static boolean i() {
        return j("x86") || ARCH.X86.equals(a());
    }

    public static boolean j(String str) {
        String b4 = b();
        if (TextUtils.isEmpty(b4) || !b4.equalsIgnoreCase(str)) {
            return !TextUtils.isEmpty(c()) && b4.equalsIgnoreCase(str);
        }
        return true;
    }

    public static boolean k() {
        return j("mips");
    }

    public static boolean l() {
        return j("x86");
    }
}
