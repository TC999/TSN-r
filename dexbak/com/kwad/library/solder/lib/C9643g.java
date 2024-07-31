package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import java.io.File;

/* renamed from: com.kwad.library.solder.lib.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9643g extends AbstractC9604a {
    public C9643g(String str) {
        super(str);
    }

    /* renamed from: e */
    private static void m28118e(File file) {
        if (file.exists()) {
            if (file.getAbsolutePath().trim().startsWith("/data/")) {
                return;
            }
            file.getAbsolutePath();
            return;
        }
        throw new PluginError.LoadError("Apk file not exist.", 4001);
    }

    @Override // com.kwad.library.solder.lib.p360a.AbstractC9604a
    /* renamed from: g */
    public void mo28113g(Context context, String str) {
        m28118e(new File(str));
    }
}
