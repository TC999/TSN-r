package com.kwad.components.p208ad.p246j;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.InterfaceC8997h;
import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.components.ad.j.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC7812a<L extends InterfaceC8997h> {
    public AdTemplate mAdTemplate;

    public AbstractC7812a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    /* renamed from: a */
    public abstract void mo31844a(L l);

    @MainThread
    /* renamed from: b */
    public abstract void mo31843b(L l);

    public long getPlayDuration() {
        return 0L;
    }

    /* renamed from: jH */
    public boolean mo31846jH() {
        return false;
    }

    public abstract void pause();

    @WorkerThread
    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z, boolean z2) {
    }

    public void skipToEnd() {
    }
}
