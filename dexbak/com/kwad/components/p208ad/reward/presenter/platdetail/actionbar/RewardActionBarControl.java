package com.kwad.components.p208ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;

    /* renamed from: qo */
    private C7907g f27255qo;

    /* renamed from: uE */
    private InterfaceC8256b f27256uE;
    @Nullable

    /* renamed from: uI */
    private InterfaceC8258d f27257uI;
    @Nullable

    /* renamed from: uJ */
    private InterfaceC8257c f27258uJ;

    /* renamed from: uL */
    private final long f27260uL;
    @NonNull

    /* renamed from: uK */
    private C8255a f27259uK = new C8255a((byte) 0);

    /* renamed from: fS */
    private Handler f27254fS = new Handler(Looper.getMainLooper());

    /* renamed from: uM */
    private boolean f27261uM = false;

    /* renamed from: uN */
    private boolean f27262uN = false;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$ShowActionBarResult */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8255a implements InterfaceC8259a {

        /* renamed from: uS */
        private List<InterfaceC8259a> f27267uS;

        /* renamed from: uT */
        private ShowActionBarResult f27268uT;

        private C8255a() {
            this.f27267uS = new CopyOnWriteArrayList();
        }

        /* renamed from: c */
        public final void m31185c(InterfaceC8259a interfaceC8259a) {
            this.f27267uS.add(interfaceC8259a);
        }

        /* renamed from: d */
        public final void m31184d(InterfaceC8259a interfaceC8259a) {
            this.f27267uS.remove(interfaceC8259a);
        }

        @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a
        /* renamed from: a */
        public final void mo31183a(ShowActionBarResult showActionBarResult, View view) {
            C10331c.m26254d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.f27268uT = showActionBarResult;
            for (InterfaceC8259a interfaceC8259a : this.f27267uS) {
                interfaceC8259a.mo31183a(showActionBarResult, view);
            }
        }

        /* synthetic */ C8255a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8256b {
        /* renamed from: a */
        void mo31149a(boolean z, InterfaceC8259a interfaceC8259a);
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8257c {
        /* renamed from: e */
        void mo31134e(InterfaceC8259a interfaceC8259a);
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8258d {
        /* renamed from: f */
        boolean mo31093f(InterfaceC8259a interfaceC8259a);
    }

    public RewardActionBarControl(C7907g c7907g, Context context, AdTemplate adTemplate) {
        this.f27255qo = c7907g;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        long m25756cl = C10484b.m25756cl(adTemplate) > 0 ? C10484b.m25756cl(adTemplate) : 1000L;
        this.f27260uL = m25756cl > 0 ? m25756cl : 1000L;
    }

    /* renamed from: P */
    private ShowActionBarResult m31204P(boolean z) {
        InterfaceC8257c interfaceC8257c;
        if (C7844b.m32178i(this.mAdInfo) && (interfaceC8257c = this.f27258uJ) != null) {
            interfaceC8257c.mo31134e(this.f27259uK);
            return ShowActionBarResult.SHOW_ORDER;
        } else if (C10484b.m25755cm(this.mAdTemplate) && !C10483a.m25876bd(this.mAdInfo) && this.f27257uI != null) {
            C10331c.m26254d("ActionBarControl", "showWebActionBar success in " + this.f27260uL);
            if (this.f27257uI.mo31093f(this.f27259uK)) {
                return ShowActionBarResult.SHOW_H5_SUCCESS;
            }
            return ShowActionBarResult.SHOW_H5_FAILURE;
        } else {
            m31203Q(z);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public void m31203Q(boolean z) {
        if (this.f27256uE != null) {
            C10331c.m26254d("ActionBarControl", "showNativeActionBar");
            this.f27262uN = true;
            this.f27256uE.mo31149a(z, this.f27259uK);
        }
    }

    /* renamed from: O */
    public final void m31205O(boolean z) {
        ShowActionBarResult m31204P = m31204P(z);
        C10331c.m26254d("ActionBarControl", "showActionBarOnVideoStart result: " + m31204P);
        if (m31204P != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.f27254fS.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                RewardActionBarControl.m31198a(RewardActionBarControl.this, true);
                C10331c.m26254d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.f27257uI != null && !RewardActionBarControl.this.f27262uN && RewardActionBarControl.this.f27257uI.mo31093f(RewardActionBarControl.this.f27259uK)) {
                    C10331c.m26254d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.f27260uL);
                    return;
                }
                C10331c.m26254d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.f27260uL);
                C8766a.m29888qi().m29890i(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.f27260uL);
                C8032c.m31773a(RewardActionBarControl.this.f27255qo.mAdTemplate, RewardActionBarControl.this.f27255qo.f26544oY, "play_card", C10484b.m25757ck(RewardActionBarControl.this.f27255qo.mAdTemplate), RewardActionBarControl.this.f27260uL, 1);
                RewardActionBarControl.this.m31203Q(true);
            }
        }, this.f27260uL);
    }

    /* renamed from: if */
    public final void m31188if() {
        if (this.f27261uM) {
            C10331c.m26248i("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f27254fS.removeCallbacksAndMessages(null);
        m31204P(true);
    }

    @Nullable
    /* renamed from: ig */
    public final ShowActionBarResult m31187ig() {
        return this.f27259uK.f27268uT;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m31198a(RewardActionBarControl rewardActionBarControl, boolean z) {
        rewardActionBarControl.f27261uM = true;
        return true;
    }

    @MainThread
    /* renamed from: a */
    public final void m31202a(InterfaceC8256b interfaceC8256b) {
        this.f27256uE = interfaceC8256b;
    }

    /* renamed from: b */
    public final void m31193b(InterfaceC8259a interfaceC8259a) {
        this.f27259uK.m31184d(interfaceC8259a);
    }

    @MainThread
    /* renamed from: a */
    public final void m31200a(InterfaceC8258d interfaceC8258d) {
        this.f27257uI = interfaceC8258d;
    }

    @MainThread
    /* renamed from: a */
    public final void m31201a(@Nullable InterfaceC8257c interfaceC8257c) {
        this.f27258uJ = interfaceC8257c;
    }

    /* renamed from: a */
    public final void m31197a(InterfaceC8259a interfaceC8259a) {
        this.f27259uK.m31185c(interfaceC8259a);
    }

    /* renamed from: a */
    public static void m31196a(final InterfaceC8259a interfaceC8259a, final View view, final ShowActionBarResult showActionBarResult) {
        if (interfaceC8259a != null) {
            view.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    InterfaceC8259a.this.mo31183a(showActionBarResult, view);
                }
            });
        }
    }
}
