package com.bytedance.pangle.plugin;

import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.util.C6251g;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bytedance.pangle.plugin.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RunnableC6182d implements Runnable {
    /* renamed from: a */
    private void m37039a(File file) {
        ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                if (!file2.getName().endsWith(".apk") && !C6251g.m36892b(file2) && !file2.getName().endsWith(".7z.zip") && !file2.getName().endsWith(".jar")) {
                    if ((file2.getAbsolutePath().endsWith(".temp") || file2.getAbsolutePath().endsWith(".tp")) && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                        ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                    } else {
                        C6251g.m36899a(file2);
                        ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                    }
                    return false;
                }
                PluginManager.getInstance().asyncInstall(null, file2);
                return true;
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        m37039a(new File(C6081c.m37234a()));
        String m37227c = C6081c.m37227c();
        if (TextUtils.isEmpty(m37227c)) {
            return;
        }
        m37039a(new File(m37227c));
    }
}
