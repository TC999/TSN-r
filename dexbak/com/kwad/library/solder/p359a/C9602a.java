package com.kwad.library.solder.p359a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.p355b.C9586a;
import com.kwad.library.solder.lib.C9645i;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p361b.C9612a;
import com.kwad.library.solder.lib.p361b.C9614c;
import com.kwad.library.solder.lib.p362c.C9617b;

/* renamed from: com.kwad.library.solder.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9602a {
    /* renamed from: a */
    public static void m28256a(Context context, @NonNull C9617b c9617b, InterfaceC9629b.C9632c c9632c) {
        C9645i.m28105xe().m28112a(context, new C9614c(c9617b), c9632c);
    }

    /* renamed from: i */
    public static C9586a m28255i(Context context, String str) {
        AbstractC9604a m28107k = C9645i.m28105xe().m28107k(context, str);
        if (m28107k != null && m28107k.isLoaded() && (m28107k instanceof C9586a)) {
            return (C9586a) m28107k;
        }
        return null;
    }

    /* renamed from: j */
    public static void m28254j(Context context, String str) {
        C9645i.m28105xe().m28108j(context, str);
    }

    /* renamed from: a */
    public static void m28257a(Context context, @NonNull C9617b c9617b, InterfaceC9629b.C9630a c9630a) {
        C9645i.m28105xe().m28112a(context, new C9612a(c9617b), c9630a);
    }
}
