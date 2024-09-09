package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g extends com.kwad.library.solder.lib.a.a {
    public g(String str) {
        super(str);
    }

    private static void e(File file) {
        if (file.exists()) {
            if (file.getAbsolutePath().trim().startsWith("/data/")) {
                return;
            }
            file.getAbsolutePath();
            return;
        }
        throw new PluginError.LoadError("Apk file not exist.", 4001);
    }

    @Override // com.kwad.library.solder.lib.a.a
    public void g(Context context, String str) {
        e(new File(str));
    }
}
