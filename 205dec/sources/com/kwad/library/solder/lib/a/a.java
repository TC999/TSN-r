package com.kwad.library.solder.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a {
    protected File ajs;
    protected String ajt;
    protected String aju;
    private final String ajx;
    protected com.kwad.library.solder.lib.c.b ajy;
    protected String mVersion;
    private final byte[] ajw = new byte[0];
    private boolean ajv = false;
    protected com.kwad.library.solder.lib.ext.c aiX = i.xe().wY();

    public a(String str) {
        this.ajx = str;
        this.ajt = str;
    }

    private void xi() {
        if (this.ajv) {
            return;
        }
        synchronized (this.ajw) {
            this.ajv = true;
        }
    }

    public final a a(@NonNull com.kwad.library.solder.lib.c.b bVar) {
        this.ajy = bVar;
        return this;
    }

    public final void bI(String str) {
        this.mVersion = str;
    }

    public final void bJ(String str) {
        this.aju = str;
    }

    public final void bK(String str) {
        this.ajt = str;
    }

    protected abstract void g(Context context, String str);

    public final String getId() {
        return this.aju;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isLoaded() {
        boolean z3;
        if (this.ajv) {
            return true;
        }
        synchronized (this.ajw) {
            z3 = this.ajv;
        }
        return z3;
    }

    public final void l(Context context, String str) {
        g(context, str);
        xi();
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.ajx + "'}";
    }

    public final String xj() {
        return this.ajx;
    }

    public final String xk() {
        com.kwad.library.solder.lib.c.b bVar = this.ajy;
        if (bVar != null) {
            return bVar.aki;
        }
        return null;
    }
}
