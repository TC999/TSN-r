package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private File f28843a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28844b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, File file) {
        this.f28843a = file;
        this.f28844b = str;
    }

    private static File a(File file) {
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

    private void b() {
        int i4 = 3;
        while (i4 > 0) {
            i4--;
            try {
                File file = new File(this.f28843a.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                g.b(this.f28843a.getAbsolutePath(), file.getAbsolutePath());
                File[] listFiles = file.listFiles();
                File file2 = this.f28843a;
                if (listFiles != null && listFiles.length > 0) {
                    file2 = listFiles[0];
                }
                File a4 = a(file2);
                if (a4 != null && a4.exists() && a4.isFile()) {
                    this.f28843a = a4;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i4));
                    return;
                }
            } catch (Exception e4) {
                ZeusLogger.errReport("Zeus/init_pangle", "Plugin install : unZip file failed !!!", e4);
                e4.printStackTrace();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }

    private static void a(String str, int i4, @NonNull String str2, long j4, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i4)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a((Object) 0));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j4))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        if (g.b(this.f28843a)) {
            ZeusLogger.d("Plugin install : start unZip file ~~~~");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b();
            a(com.bytedance.pangle.c.b.f28639h, b.a.G, this.f28844b, SystemClock.elapsedRealtime() - elapsedRealtime, "");
            ZeusLogger.d("Plugin install : start install from unZip ~~~~");
        } else {
            ZeusLogger.d("Plugin install : start install without unZip ~~~~");
        }
        e a4 = com.bytedance.pangle.f.a.d.a(this.f28843a);
        if (a4 == null) {
            String str = this.f28844b;
            ZeusPluginStateListener.postStateChange(str, 7, " read local file package info failed !!! pluginPkg = " + this.f28844b + " mApkFile.exists = " + this.f28843a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.f28844b);
            ZeusLogger.w("Zeus/install_pangle", sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(a4.f28764a);
        if (plugin == null) {
            String str2 = this.f28844b;
            ZeusPluginStateListener.postStateChange(str2, 7, " plugin == null !!! pluginPkg = " + this.f28844b);
            ZeusLogger.w("Zeus/install_pangle", "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a4.f28764a);
            return false;
        }
        boolean install = plugin.install(this.f28843a, a4);
        if (install) {
            ZeusPluginStateListener.postStateChange(a4.f28764a, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(a4.f28764a, 7, "Internal error.");
        }
        return install;
    }
}
