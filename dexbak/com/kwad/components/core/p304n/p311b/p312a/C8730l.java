package com.kwad.components.core.p304n.p311b.p312a;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.library.p355b.p358c.C9596a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.core.n.b.a.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8730l extends IOfflineCompoWrapper {
    public C8730l(String str) {
        super(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context unwrapContextIfNeed(Context context) {
        return C9596a.unwrapContextIfNeed(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context wrapContextIfNeed(@Nullable Context context) {
        return C9596a.m28269h(context, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Application wrapGetApplication(Context context) {
        return C10887l.m24567Ob();
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        return C9596a.m28278a(layoutInflater, this.mOfflinePackageName);
    }
}
