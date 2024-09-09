package com.bytedance.pangle.e;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class d implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i4) {
        String b4 = com.bytedance.pangle.d.c.b(str, i4);
        ZeusLogger.d("Zeus/install_pangle", "full DexOpt:".concat(String.valueOf(b4)));
        String c4 = com.bytedance.pangle.d.c.c(str, i4);
        StringBuilder sb = new StringBuilder();
        sb.append(c4);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(b.b(b4));
        String sb2 = sb.toString();
        String str3 = c4 + str2 + b.a(b4);
        if (a(b4, sb2)) {
            File file = new File(sb2);
            if (file.exists()) {
                file.renameTo(new File(str3));
            }
            String str4 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
            File file2 = new File(sb2.replace(str4, ".vdex"));
            if (file2.exists()) {
                file2.renameTo(new File(str3.replace(str4, ".vdex")));
            }
            boolean a4 = b.a(str3);
            ZeusLogger.i("Zeus/install_pangle", "full DexOpt result:".concat(String.valueOf(a4)));
            return a4;
        }
        return false;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            return a.a(b.a(str, str2, b.f28704b));
        } catch (Exception unused) {
            return false;
        }
    }
}
