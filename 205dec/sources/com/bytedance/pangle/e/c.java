package com.bytedance.pangle.e;

import androidx.annotation.NonNull;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i4) {
        String a4 = g.a(str, i4);
        String c4 = com.bytedance.pangle.d.c.c(str, i4);
        String[] split = a4.split(":");
        ZeusLogger.i("Zeus/install_pangle", "full DexOpt start:".concat(a4));
        long currentTimeMillis = System.currentTimeMillis();
        int length = split.length;
        boolean z3 = false;
        int i5 = 0;
        boolean z4 = false;
        while (true) {
            if (i5 >= length) {
                z3 = z4;
                break;
            }
            String str2 = split[i5];
            if (!a(str2, c4 + File.separator + b.a(str2))) {
                break;
            }
            ZeusLogger.i("Zeus/install_pangle", "full DexOpt result:true");
            i5++;
            z4 = true;
        }
        ZeusLogger.d("Zeus/load_pangle", "compile cost:" + (System.currentTimeMillis() - currentTimeMillis) + " result:" + z3);
        return z3;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
