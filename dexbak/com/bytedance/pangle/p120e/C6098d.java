package com.bytedance.pangle.p120e;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.p120e.C6102f;
import java.io.File;

/* renamed from: com.bytedance.pangle.e.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6098d implements C6102f.InterfaceC6105a {
    @Override // com.bytedance.pangle.p120e.C6102f.InterfaceC6105a
    /* renamed from: a */
    public final boolean mo37184a(String str, int i) {
        String m37228b = C6081c.m37228b(str, i);
        ZeusLogger.m37083d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(m37228b)));
        String m37226c = C6081c.m37226c(str, i);
        StringBuilder sb = new StringBuilder();
        sb.append(m37226c);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(C6096b.m37192b(m37228b));
        String sb2 = sb.toString();
        String str3 = m37226c + str2 + C6096b.m37197a(m37228b);
        if (m37190a(m37228b, sb2)) {
            File file = new File(sb2);
            if (file.exists()) {
                file.renameTo(new File(str3));
            }
            String str4 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
            File file2 = new File(sb2.replace(str4, ".vdex"));
            if (file2.exists()) {
                file2.renameTo(new File(str3.replace(str4, ".vdex")));
            }
            boolean m37193a = C6096b.m37193a(str3);
            ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(m37193a)));
            return m37193a;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m37190a(@NonNull String str, @NonNull String str2) {
        try {
            return C6094a.m37200a(C6096b.m37195a(str, str2, C6096b.f21943b));
        } catch (Exception unused) {
            return false;
        }
    }
}
