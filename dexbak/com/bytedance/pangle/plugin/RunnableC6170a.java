package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.C6165b;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p118c.C6073b;
import com.bytedance.pangle.p121f.p122a.C6117d;
import com.bytedance.pangle.p121f.p122a.C6118e;
import com.bytedance.pangle.util.C6251g;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bytedance.pangle.plugin.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RunnableC6170a implements Runnable {

    /* renamed from: a */
    private File f22082a;

    /* renamed from: b */
    private final String f22083b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC6170a(String str, File file) {
        this.f22082a = file;
        this.f22083b = str;
    }

    /* renamed from: a */
    private static File m37068a(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] listFiles = new File(file.getParent()).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    /* renamed from: b */
    private void m37066b() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.f22082a.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                C6251g.m36891b(this.f22082a.getAbsolutePath(), file.getAbsolutePath());
                File[] listFiles = file.listFiles();
                File file2 = this.f22082a;
                if (listFiles != null && listFiles.length > 0) {
                    file2 = listFiles[0];
                }
                File m37068a = m37068a(file2);
                if (m37068a != null && m37068a.exists() && m37068a.isFile()) {
                    this.f22082a = m37068a;
                    ZeusLogger.m37084d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                e.printStackTrace();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        m37069a();
    }

    /* renamed from: a */
    private static void m37067a(String str, int i, @NonNull String str2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", C6165b.m37072a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", C6165b.m37072a(str2));
            jSONObject.putOpt("version_code", C6165b.m37072a((Object) 0));
            jSONObject3.putOpt("duration", Integer.valueOf(C6165b.m37070b(Long.valueOf(j))));
            jSONObject2.putOpt("message", C6165b.m37072a(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C6073b.m37254a().m37253a(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m37069a() {
        if (C6251g.m36892b(this.f22082a)) {
            ZeusLogger.m37084d("Plugin install : start unZip file ~~~~");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            m37066b();
            m37067a(C6073b.f21870h, C6073b.C6074a.f21882G, this.f22083b, SystemClock.elapsedRealtime() - elapsedRealtime, "");
            ZeusLogger.m37084d("Plugin install : start install from unZip ~~~~");
        } else {
            ZeusLogger.m37084d("Plugin install : start install without unZip ~~~~");
        }
        C6118e m37148a = C6117d.m37148a(this.f22082a);
        if (m37148a == null) {
            String str = this.f22083b;
            ZeusPluginStateListener.postStateChange(str, 7, " read local file package info failed !!! pluginPkg = " + this.f22083b + " mApkFile.exists = " + this.f22082a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.f22083b);
            ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(m37148a.f22003a);
        if (plugin == null) {
            String str2 = this.f22083b;
            ZeusPluginStateListener.postStateChange(str2, 7, " plugin == null !!! pluginPkg = " + this.f22083b);
            ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + m37148a.f22003a);
            return false;
        }
        boolean install = plugin.install(this.f22082a, m37148a);
        if (install) {
            ZeusPluginStateListener.postStateChange(m37148a.f22003a, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(m37148a.f22003a, 7, "Internal error.");
        }
        return install;
    }
}
