package com.kwad.components.core.page.p321c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.page.recycle.C8850e;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.page.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8799a extends Presenter {

    /* renamed from: Ow */
    private int f28538Ow;

    /* renamed from: Ox */
    private FeedVideoView f28539Ox;

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        final C8850e c8850e = (C8850e) m24613Jx();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(c8850e.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.f28539Ox = feedVideoView;
        feedVideoView.mo28891b(C10485c.m25662dB(c8850e.adTemplate));
        this.f28539Ox.m28962a(build, c8850e.f28661Kz);
        this.f28539Ox.setVisibility(0);
        final AdInfo m25641dQ = C10487e.m25641dQ(c8850e.adTemplate);
        this.f28539Ox.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (C10483a.m25956aF(m25641dQ)) {
                        if (c8850e.f28661Kz != null) {
                            C8615a.m30233a(new C8615a.C8616a(C8799a.this.getActivity()).m30202ao(false).m30200ap(false).m30193at(true).m30198aq(c8850e.adTemplate).m30195ar(false));
                            C9908c.m27349a(c8850e.adTemplate, 50, C8799a.this.f28539Ox.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = c8850e.f28662PU;
                    if (recyclerView == null || recyclerView.getAdapter() == null || c8850e.f28662PU.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    c8850e.f28662PU.scrollToPosition(1);
                    C9908c.m27349a(c8850e.adTemplate, 50, C8799a.this.f28539Ox.getTouchCoords());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (C10483a.m25919aq(m25641dQ)) {
            this.f28539Ox.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (C10483a.m25956aF(m25641dQ)) {
                            if (c8850e.f28661Kz != null) {
                                C8615a.m30233a(new C8615a.C8616a(C8799a.this.getActivity()).m30202ao(false).m30200ap(false).m30193at(true).m30198aq(c8850e.adTemplate).m30195ar(false));
                                C9908c.m27349a(c8850e.adTemplate, 171, C8799a.this.f28539Ox.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = c8850e.f28662PU;
                        if (recyclerView == null || recyclerView.getAdapter() == null || c8850e.f28662PU.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        c8850e.f28662PU.scrollToPosition(1);
                        C9908c.m27349a(c8850e.adTemplate, 171, C8799a.this.f28539Ox.getTouchCoords());
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
        this.f28539Ox.setWindowFullScreenListener(new FeedVideoView.InterfaceC9357a() { // from class: com.kwad.components.core.page.c.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.InterfaceC9357a
            /* renamed from: pq */
            public final void mo28931pq() {
                RecyclerView recyclerView = c8850e.f28662PU;
                if (recyclerView != null) {
                    C8799a.this.f28538Ow = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.InterfaceC9357a
            /* renamed from: pr */
            public final void mo28930pr() {
                RecyclerView recyclerView = c8850e.f28662PU;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(C8799a.this.f28538Ow);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f28539Ox.release();
    }
}
