package pl.droidsonroids.relinker;

import android.os.Build;
import pl.droidsonroids.relinker.ReLinker;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: pl.droidsonroids.relinker.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SystemLibraryLoader implements ReLinker.InterfaceC15463b {
    @Override // pl.droidsonroids.relinker.ReLinker.InterfaceC15463b
    /* renamed from: a */
    public String mo2335a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // pl.droidsonroids.relinker.ReLinker.InterfaceC15463b
    /* renamed from: b */
    public String mo2334b(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // pl.droidsonroids.relinker.ReLinker.InterfaceC15463b
    /* renamed from: c */
    public String[] mo2333c() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        String str = Build.CPU_ABI2;
        return !TextUtils.m2319a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // pl.droidsonroids.relinker.ReLinker.InterfaceC15463b
    /* renamed from: d */
    public void mo2332d(String str) {
        System.load(str);
    }

    @Override // pl.droidsonroids.relinker.ReLinker.InterfaceC15463b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
