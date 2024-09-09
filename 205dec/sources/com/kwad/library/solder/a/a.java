package com.kwad.library.solder.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static void a(Context context, @NonNull b bVar, b.c cVar) {
        i.xe().a(context, new c(bVar), cVar);
    }

    public static com.kwad.library.b.a i(Context context, String str) {
        com.kwad.library.solder.lib.a.a k4 = i.xe().k(context, str);
        if (k4 != null && k4.isLoaded() && (k4 instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) k4;
        }
        return null;
    }

    public static void j(Context context, String str) {
        i.xe().j(context, str);
    }

    public static void a(Context context, @NonNull com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.xe().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }
}
