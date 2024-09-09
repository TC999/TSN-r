package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.q;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends h {
    private b aiA;
    private Resources aiB;

    public a(String str) {
        super(str);
    }

    private b a(File file, File file2) {
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
        com.kwad.library.b.a.a aVar = new com.kwad.library.b.a.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.ajs.getAbsolutePath();
        com.kwad.library.solder.lib.c.b bVar = this.ajy;
        return new b(aVar, absolutePath, file3, absolutePath2, bVar.akn, bVar.akm);
    }

    private File d(File file) {
        File file2 = new File(file.getParentFile(), this.aiX.xB());
        q.X(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void g(Context context, String str) {
        super.g(context, str);
        File file = new File(str);
        try {
            this.aiA = a(d(file), file);
            try {
                this.aiB = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                a.a.a(this.aiA);
                a.a.a(this.aiB);
            } catch (Exception e4) {
                Log.getStackTraceString(e4);
                throw new PluginError.LoadError(e4, 4006);
            }
        } catch (IOException e5) {
            throw new PluginError.LoadError(e5, 4002);
        }
    }

    public final Resources getResources() {
        return this.aiB;
    }

    public final b wU() {
        return this.aiA;
    }
}
