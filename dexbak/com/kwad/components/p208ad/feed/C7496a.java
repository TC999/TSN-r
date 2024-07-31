package com.kwad.components.p208ad.feed;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.feed.p225a.C7498b;
import com.kwad.components.p208ad.p210b.InterfaceC7345c;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;

/* renamed from: com.kwad.components.ad.feed.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7496a extends AbstractC9863d implements InterfaceC7345c {
    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC7345c.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7345c
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        C7591e.m32831a(ksScene, feedAdListener, true);
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7345c
    public final void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        C7591e.m32831a(ksScene, feedAdListener, !C7498b.m33147aX());
    }
}
