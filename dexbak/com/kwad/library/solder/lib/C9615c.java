package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.C9633c;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.InterfaceC9605b;
import com.kwad.library.solder.lib.p363d.C9620b;
import com.kwad.sdk.utils.C11010ad;
import com.kwad.sdk.utils.C11122q;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.library.solder.lib.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9615c implements InterfaceC9605b {
    private final File aiV;
    private final File aiW;
    private final C9633c aiX;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9615c(Context context, C9633c c9633c) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mContext = origApplicationContext;
        this.aiX = c9633c;
        this.aiV = origApplicationContext.getDir(c9633c.m28156xA(), 0);
        this.aiW = origApplicationContext.getCacheDir();
    }

    /* renamed from: E */
    private String m28211E(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(m28201wX());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    /* renamed from: a */
    private String m28209a(AbstractC9604a abstractC9604a) {
        return mo28210F(abstractC9604a.getId(), abstractC9604a.getVersion());
    }

    private static void delete(String str) {
        C11122q.delete(str);
    }

    /* renamed from: i */
    private boolean m28203i(String str, String str2, boolean z) {
        if (C11122q.m23717gt(str)) {
            if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, C11010ad.m24142gz(str))) {
                return true;
            }
            delete(str);
            return false;
        }
        return false;
    }

    /* renamed from: wX */
    private String m28201wX() {
        return this.aiV.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: D */
    public final void mo28212D(String str, String str2) {
        File file = new File(m28211E(str, str2));
        if (file.exists()) {
            C11122q.m23742R(file);
        }
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: F */
    public final String mo28210F(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(m28201wX());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(this.aiX.m28151xF());
        return sb.toString();
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: b */
    public final String mo28207b(AbstractC9604a abstractC9604a) {
        String m28209a = m28209a(abstractC9604a);
        if (!TextUtils.isEmpty(m28209a)) {
            abstractC9604a.getId();
            File file = new File(m28209a);
            if (file.exists() && !this.aiX.m28150xG() && m28203i(file.getAbsolutePath(), abstractC9604a.m28241xk(), true)) {
                return m28209a;
            }
            String m28242xj = abstractC9604a.m28242xj();
            abstractC9604a.getId();
            File file2 = new File(m28242xj);
            if (file2.exists()) {
                abstractC9604a.getId();
                if (m28203i(m28242xj, abstractC9604a.m28241xk(), true)) {
                    if (file2.renameTo(file)) {
                        abstractC9604a.getId();
                        return m28209a;
                    }
                    try {
                        mo28202wW();
                        try {
                            C11122q.m23721f(file2, file);
                            C11122q.m23742R(file2);
                            return m28209a;
                        } catch (Throwable th) {
                            C9603a.m28250e("PluginInstallerImpl", th);
                            throw new PluginError.InstallError(th, 3004);
                        }
                    } catch (Throwable th2) {
                        C9603a.m28250e("PluginInstallerImpl", th2);
                        throw new PluginError.InstallError(th2, 3005);
                    }
                }
                throw new PluginError.InstallError("check plugin md5 fail", 3003);
            }
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        throw new PluginError.InstallError("Can not get install path.", (int) PluginError.ERROR_INS_INSTALL_PATH);
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: bE */
    public final void mo28206bE(String str) {
        File file = new File(mo28205bF(str));
        if (file.exists()) {
            C11122q.m23742R(file);
        }
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: bF */
    public final String mo28205bF(@NonNull String str) {
        return m28201wX() + File.separator + str;
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: e */
    public final File mo28204e(String str, boolean z) {
        String md5;
        if (str == null || (md5 = C9620b.getMD5(str)) == null) {
            return null;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(md5);
            if (this.aiX.m28152xE() != null) {
                sb.append(this.aiX.m28152xE());
            }
            File file = new File(this.aiW, sb.toString());
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
        return File.createTempFile(md5 + System.currentTimeMillis(), this.aiX.m28152xE(), this.aiW);
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: wW */
    public final void mo28202wW() {
        if (this.aiV.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9605b
    /* renamed from: a */
    public final boolean mo28208a(String str, String str2, String str3) {
        if (this.aiX.m28150xG()) {
            return false;
        }
        return m28203i(mo28210F(str, str2), str3, true);
    }
}
