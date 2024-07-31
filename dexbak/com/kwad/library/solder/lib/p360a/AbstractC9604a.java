package com.kwad.library.solder.lib.p360a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.C9645i;
import com.kwad.library.solder.lib.ext.C9633c;
import com.kwad.library.solder.lib.p362c.C9617b;
import java.io.File;

/* renamed from: com.kwad.library.solder.lib.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9604a {
    protected File ajs;
    protected String ajt;
    protected String aju;
    private final String ajx;
    protected C9617b ajy;
    protected String mVersion;
    private final byte[] ajw = new byte[0];
    private boolean ajv = false;
    protected C9633c aiX = C9645i.m28105xe().m28106wY();

    public AbstractC9604a(String str) {
        this.ajx = str;
        this.ajt = str;
    }

    /* renamed from: xi */
    private void m28243xi() {
        if (this.ajv) {
            return;
        }
        synchronized (this.ajw) {
            this.ajv = true;
        }
    }

    /* renamed from: a */
    public final AbstractC9604a m28248a(@NonNull C9617b c9617b) {
        this.ajy = c9617b;
        return this;
    }

    /* renamed from: bI */
    public final void m28247bI(String str) {
        this.mVersion = str;
    }

    /* renamed from: bJ */
    public final void m28246bJ(String str) {
        this.aju = str;
    }

    /* renamed from: bK */
    public final void m28245bK(String str) {
        this.ajt = str;
    }

    /* renamed from: g */
    protected abstract void mo28113g(Context context, String str);

    public final String getId() {
        return this.aju;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isLoaded() {
        boolean z;
        if (this.ajv) {
            return true;
        }
        synchronized (this.ajw) {
            z = this.ajv;
        }
        return z;
    }

    /* renamed from: l */
    public final void m28244l(Context context, String str) {
        mo28113g(context, str);
        m28243xi();
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.ajx + "'}";
    }

    /* renamed from: xj */
    public final String m28242xj() {
        return this.ajx;
    }

    /* renamed from: xk */
    public final String m28241xk() {
        C9617b c9617b = this.ajy;
        if (c9617b != null) {
            return c9617b.aki;
        }
        return null;
    }
}
