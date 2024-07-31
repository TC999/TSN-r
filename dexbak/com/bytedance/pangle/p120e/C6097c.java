package com.bytedance.pangle.p120e;

import androidx.annotation.NonNull;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.p120e.C6102f;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bytedance.pangle.e.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6097c implements C6102f.InterfaceC6105a {
    @Override // com.bytedance.pangle.p120e.C6102f.InterfaceC6105a
    /* renamed from: a */
    public final boolean mo37184a(String str, int i) {
        String m37179a = C6106g.m37179a(str, i);
        String m37226c = C6081c.m37226c(str, i);
        String[] split = m37179a.split(":");
        ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(m37179a));
        long currentTimeMillis = System.currentTimeMillis();
        int length = split.length;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= length) {
                z = z2;
                break;
            }
            String str2 = split[i2];
            if (!m37191a(str2, m37226c + File.separator + C6096b.m37197a(str2))) {
                break;
            }
            ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i2++;
            z2 = true;
        }
        ZeusLogger.m37083d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - currentTimeMillis) + " result:" + z);
        return z;
    }

    /* renamed from: a */
    private static boolean m37191a(@NonNull String str, @NonNull String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
