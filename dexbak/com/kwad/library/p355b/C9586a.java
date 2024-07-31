package com.kwad.library.p355b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.p355b.p356a.C9587a;
import com.kwad.library.p355b.p356a.C9588b;
import com.kwad.library.p355b.p357b.C9589a;
import com.kwad.library.solder.lib.C9644h;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.sdk.utils.C11122q;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import p011a.R8$$SyntheticClass;

/* renamed from: com.kwad.library.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9586a extends C9644h {
    private C9588b aiA;
    private Resources aiB;

    public C9586a(String str) {
        super(str);
    }

    /* renamed from: a */
    private C9588b m28311a(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        File file3 = file;
        C9587a c9587a = new C9587a((BaseDexClassLoader) C9586a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.ajs.getAbsolutePath();
        C9617b c9617b = this.ajy;
        return new C9588b(c9587a, absolutePath, file3, absolutePath2, c9617b.akn, c9617b.akm);
    }

    /* renamed from: d */
    private File m28310d(File file) {
        File file2 = new File(file.getParentFile(), this.aiX.m28155xB());
        C11122q.m23736X(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.C9644h, com.kwad.library.solder.lib.C9643g, com.kwad.library.solder.lib.p360a.AbstractC9604a
    /* renamed from: g */
    public final void mo28113g(Context context, String str) {
        super.mo28113g(context, str);
        File file = new File(str);
        try {
            this.aiA = m28311a(m28310d(file), file);
            try {
                this.aiB = C9589a.m28307a(context, context.getResources(), str);
                R8$$SyntheticClass.m60055a(this.aiA);
                R8$$SyntheticClass.m60055a(this.aiB);
            } catch (Exception e) {
                Log.getStackTraceString(e);
                throw new PluginError.LoadError(e, 4006);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4002);
        }
    }

    public final Resources getResources() {
        return this.aiB;
    }

    /* renamed from: wU */
    public final C9588b m28309wU() {
        return this.aiA;
    }
}
