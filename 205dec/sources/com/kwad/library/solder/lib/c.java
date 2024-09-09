package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements com.kwad.library.solder.lib.a.b {
    private final File aiV;
    private final File aiW;
    private final com.kwad.library.solder.lib.ext.c aiX;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mContext = origApplicationContext;
        this.aiX = cVar;
        this.aiV = origApplicationContext.getDir(cVar.xA(), 0);
        this.aiW = origApplicationContext.getCacheDir();
    }

    private String E(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(wX());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return F(aVar.getId(), aVar.getVersion());
    }

    private static void delete(String str) {
        q.delete(str);
    }

    private boolean i(String str, String str2, boolean z3) {
        if (q.gt(str)) {
            if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, ad.gz(str))) {
                return true;
            }
            delete(str);
            return false;
        }
        return false;
    }

    private String wX() {
        return this.aiV.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void D(String str, String str2) {
        File file = new File(E(str, str2));
        if (file.exists()) {
            q.R(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String F(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(wX());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(this.aiX.xF());
        return sb.toString();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) {
        String a4 = a(aVar);
        if (!TextUtils.isEmpty(a4)) {
            aVar.getId();
            File file = new File(a4);
            if (file.exists() && !this.aiX.xG() && i(file.getAbsolutePath(), aVar.xk(), true)) {
                return a4;
            }
            String xj = aVar.xj();
            aVar.getId();
            File file2 = new File(xj);
            if (file2.exists()) {
                aVar.getId();
                if (i(xj, aVar.xk(), true)) {
                    if (file2.renameTo(file)) {
                        aVar.getId();
                        return a4;
                    }
                    try {
                        wW();
                        try {
                            q.f(file2, file);
                            q.R(file2);
                            return a4;
                        } catch (Throwable th) {
                            a.e("PluginInstallerImpl", th);
                            throw new PluginError.InstallError(th, 3004);
                        }
                    } catch (Throwable th2) {
                        a.e("PluginInstallerImpl", th2);
                        throw new PluginError.InstallError(th2, 3005);
                    }
                }
                throw new PluginError.InstallError("check plugin md5 fail", 3003);
            }
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        throw new PluginError.InstallError("Can not get install path.", 3006);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void bE(String str) {
        File file = new File(bF(str));
        if (file.exists()) {
            q.R(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String bF(@NonNull String str) {
        return wX() + File.separator + str;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z3) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (z3) {
            StringBuilder sb = new StringBuilder();
            sb.append(md5);
            if (this.aiX.xE() != null) {
                sb.append(this.aiX.xE());
            }
            File file = new File(this.aiW, sb.toString());
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
        return File.createTempFile(md5 + System.currentTimeMillis(), this.aiX.xE(), this.aiW);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void wW() {
        if (this.aiV.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.aiX.xG()) {
            return false;
        }
        return i(F(str, str2), str3, true);
    }
}
