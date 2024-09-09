package pl.droidsonroids.relinker;

import android.os.Build;
import pl.droidsonroids.relinker.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemLibraryLoader.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class e implements c.b {
    @Override // pl.droidsonroids.relinker.c.b
    public String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // pl.droidsonroids.relinker.c.b
    public String b(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // pl.droidsonroids.relinker.c.b
    public String[] c() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // pl.droidsonroids.relinker.c.b
    public void d(String str) {
        System.load(str);
    }

    @Override // pl.droidsonroids.relinker.c.b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
