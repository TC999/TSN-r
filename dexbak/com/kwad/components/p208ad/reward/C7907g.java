package com.kwad.components.p208ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p298i.C8665a;
import com.kwad.components.core.p298i.C8674c;
import com.kwad.components.core.p298i.C8675d;
import com.kwad.components.core.p301l.AbstractC8691b;
import com.kwad.components.core.p301l.C8688a;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9289a;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.p208ad.p247k.C7815a;
import com.kwad.components.p208ad.reward.DialogFragmentC7931h;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p250c.C7863a;
import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.components.p208ad.reward.p252e.C7885f;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7881b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7883d;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7884e;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7895o;
import com.kwad.components.p208ad.reward.p253f.C7897a;
import com.kwad.components.p208ad.reward.p257j.C7954a;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.p258k.InterfaceC7958a;
import com.kwad.components.p208ad.reward.p258k.InterfaceC7993r;
import com.kwad.components.p208ad.reward.p258k.p259a.DialogFragmentC7960b;
import com.kwad.components.p208ad.reward.p260l.p261a.C8005a;
import com.kwad.components.p208ad.reward.p260l.p262b.C8009a;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.components.p208ad.reward.p263m.InterfaceC8020c;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8072p;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11063bm;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7907g extends C8688a {

    /* renamed from: fP */
    public boolean f26523fP;

    /* renamed from: fS */
    private Handler f26524fS;

    /* renamed from: gt */
    public boolean f26525gt;

    /* renamed from: jY */
    public boolean f26526jY;
    public AdResultData mAdResultData;
    @NonNull
    public InterfaceC7883d mAdRewardStepListener;
    @Nullable
    public C8619c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;
    @Nullable
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;
    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public C11063bm mTimerHelper;
    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;

    /* renamed from: oH */
    public boolean f26527oH;
    @NonNull

    /* renamed from: oI */
    public InterfaceC7881b f26528oI;

    /* renamed from: oJ */
    public C8025e f26529oJ;
    @Nullable

    /* renamed from: oK */
    public IAdLiveOfflineView f26530oK;
    @Nullable

    /* renamed from: oL */
    public C8874a f26531oL;
    @NonNull

    /* renamed from: oM */
    public RewardActionBarControl f26532oM;
    @Nullable

    /* renamed from: oN */
    public C7951j f26533oN;
    @Nullable

    /* renamed from: oO */
    public C7815a f26534oO;
    @Nullable

    /* renamed from: oP */
    public C7872d f26535oP;

    /* renamed from: oQ */
    private final PriorityQueue<InterfaceC7886g> f26536oQ;

    /* renamed from: oR */
    public final List<InterfaceC7958a> f26537oR;

    /* renamed from: oS */
    private final List<InterfaceC7993r> f26538oS;

    /* renamed from: oT */
    private final List<InterfaceC8020c> f26539oT;

    /* renamed from: oU */
    public Set<InterfaceC7884e> f26540oU;
    @Nullable

    /* renamed from: oV */
    private InterfaceC9289a f26541oV;

    /* renamed from: oW */
    private boolean f26542oW;

    /* renamed from: oX */
    private boolean f26543oX;

    /* renamed from: oY */
    public boolean f26544oY;

    /* renamed from: oZ */
    public boolean f26545oZ;

    /* renamed from: pA */
    public boolean f26546pA;
    @NonNull

    /* renamed from: pB */
    public LoadStrategy f26547pB;

    /* renamed from: pC */
    private RewardRenderResult f26548pC;

    /* renamed from: pD */
    private List<InterfaceC7920a> f26549pD;

    /* renamed from: pE */
    private List<InterfaceC7921b> f26550pE;

    /* renamed from: pF */
    private List<C8665a.InterfaceC8672a> f26551pF;

    /* renamed from: pa */
    public boolean f26552pa;

    /* renamed from: pb */
    public boolean f26553pb;

    /* renamed from: pc */
    private boolean f26554pc;

    /* renamed from: pd */
    public boolean f26555pd;

    /* renamed from: pe */
    public boolean f26556pe;

    /* renamed from: pf */
    public List<Integer> f26557pf;

    /* renamed from: pg */
    public int f26558pg;

    /* renamed from: ph */
    public boolean f26559ph;
    @Nullable

    /* renamed from: pi */
    public View$OnClickListenerC8072p f26560pi;

    /* renamed from: pj */
    public boolean f26561pj;
    @Nullable

    /* renamed from: pk */
    private PlayableSource f26562pk;

    /* renamed from: pl */
    private boolean f26563pl;

    /* renamed from: pm */
    public long f26564pm;

    /* renamed from: pn */
    private List<DialogInterface.OnDismissListener> f26565pn;
    @Nullable

    /* renamed from: po */
    public InterfaceC7895o f26566po;

    /* renamed from: pp */
    public boolean f26567pp;
    @Nullable

    /* renamed from: pq */
    public C8009a f26568pq;
    @Nullable

    /* renamed from: pr */
    public C8005a f26569pr;

    /* renamed from: ps */
    public int f26570ps;

    /* renamed from: pt */
    private int f26571pt;

    /* renamed from: pu */
    public long f26572pu;

    /* renamed from: pv */
    public long f26573pv;

    /* renamed from: pw */
    public boolean f26574pw;

    /* renamed from: px */
    private boolean f26575px;

    /* renamed from: py */
    private boolean f26576py;

    /* renamed from: pz */
    public boolean f26577pz;

    /* renamed from: com.kwad.components.ad.reward.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7920a {
        /* renamed from: fU */
        void mo31309fU();

        /* renamed from: fV */
        void mo31308fV();

        /* renamed from: fW */
        void mo31307fW();

        /* renamed from: fX */
        void mo31306fX();
    }

    /* renamed from: com.kwad.components.ad.reward.g$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7921b {
        boolean interceptPlayCardResume();
    }

    public C7907g(AbstractC8691b<?> abstractC8691b) {
        super(abstractC8691b);
        this.f26527oH = false;
        this.f26536oQ = new PriorityQueue<>();
        this.f26537oR = new CopyOnWriteArrayList();
        this.f26538oS = new CopyOnWriteArrayList();
        this.f26539oT = new CopyOnWriteArrayList();
        this.f26540oU = new HashSet();
        this.f26542oW = false;
        this.f26543oX = false;
        this.f26545oZ = false;
        this.f26552pa = false;
        this.f26553pb = false;
        this.f26554pc = false;
        this.f26555pd = false;
        this.mRewardVerifyCalled = false;
        this.f26556pe = false;
        this.f26557pf = new ArrayList();
        this.mCheckExposureResult = true;
        this.f26558pg = 0;
        this.f26559ph = false;
        this.f26561pj = false;
        this.f26562pk = null;
        this.f26563pl = false;
        this.f26525gt = false;
        this.f26565pn = new CopyOnWriteArrayList();
        this.f26524fS = new Handler(Looper.getMainLooper());
        this.f26567pp = false;
        this.f26571pt = 2;
        this.f26575px = false;
        this.f26576py = false;
        this.f26577pz = false;
        this.f26546pA = false;
        this.f26547pB = LoadStrategy.FULL_TK;
        this.f26549pD = new CopyOnWriteArrayList();
        this.f26550pE = new CopyOnWriteArrayList();
        this.f26551pF = new CopyOnWriteArrayList();
        this.f28358Ms.add(new InterfaceC8689a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: c */
            public final void mo29623c(AbstractC8886c abstractC8886c) {
                C7907g.this.m31998fu();
            }

            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: d */
            public final void mo29622d(AbstractC8886c abstractC8886c) {
                C7907g.this.m31997fv();
            }

            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: fP */
            public final void mo29621fP() {
                C7907g.this.m31999ft();
            }

            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: fQ */
            public final void mo29620fQ() {
                C7907g.this.m31996fw();
            }
        });
    }

    /* renamed from: F */
    public static boolean m32063F(AdTemplate adTemplate) {
        return C10487e.m25654F(adTemplate);
    }

    /* renamed from: G */
    public static boolean m32062G(AdTemplate adTemplate) {
        if (C10483a.m25836cR(C10487e.m25641dQ(adTemplate))) {
            return false;
        }
        return m32065E(adTemplate) || m32063F(adTemplate);
    }

    /* renamed from: fA */
    private void m32014fA() {
        this.f26536oQ.clear();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.clear();
        }
        C7951j c7951j = this.f26533oN;
        if (c7951j != null) {
            c7951j.release();
        }
        C7872d c7872d = this.f26535oP;
        if (c7872d != null) {
            c7872d.release();
        }
        Set<InterfaceC7884e> set = this.f26540oU;
        if (set != null) {
            set.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fC */
    public void m32012fC() {
        try {
            int size = this.f26536oQ.size();
            for (int i = 0; i < size; i++) {
                InterfaceC7886g poll = this.f26536oQ.poll();
                if (poll != null) {
                    poll.mo31009bL();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ft */
    public void m31999ft() {
        for (InterfaceC7920a interfaceC7920a : this.f26549pD) {
            interfaceC7920a.mo31309fU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fw */
    public void m31996fw() {
        for (InterfaceC7920a interfaceC7920a : this.f26549pD) {
            interfaceC7920a.mo31306fX();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: A */
    public final void m32069A(boolean z) {
        this.f26576py = z;
    }

    /* renamed from: B */
    public final void m32068B(boolean z) {
        this.f26563pl = true;
    }

    /* renamed from: C */
    public final void m32067C(boolean z) {
        this.f26575px = true;
    }

    /* renamed from: D */
    public final void m32066D(boolean z) {
        this.f26542oW = z;
    }

    /* renamed from: E */
    public final void m32064E(final boolean z) {
        if (z != this.mRewardVerifyCalled) {
            m32038a(this.f26538oS, new InterfaceC10761a<InterfaceC7993r>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.p434g.InterfaceC10761a
                /* renamed from: c */
                public void accept(InterfaceC7993r interfaceC7993r) {
                    interfaceC7993r.mo31900aa(z);
                }
            });
        }
        this.mRewardVerifyCalled = z;
    }

    /* renamed from: L */
    public final void m32061L(int i) {
        this.f26571pt = i;
    }

    /* renamed from: b */
    public final void m32033b(InterfaceC7920a interfaceC7920a) {
        this.f26549pD.remove(interfaceC7920a);
    }

    /* renamed from: d */
    public final void m32018d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = C10485c.m25661n(adResultData);
    }

    /* renamed from: fB */
    public final void m32013fB() {
        if (isMainThread()) {
            m32012fC();
        } else {
            this.f26524fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.g.6
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C7907g.this.m32012fC();
                }
            });
        }
    }

    /* renamed from: fD */
    public final boolean m32011fD() {
        return this.f26576py;
    }

    /* renamed from: fE */
    public final void m32010fE() {
        InterfaceC9289a interfaceC9289a = this.f26541oV;
        if (interfaceC9289a == null) {
            return;
        }
        interfaceC9289a.mo29102ja();
    }

    /* renamed from: fF */
    public final boolean m32009fF() {
        return this.f26554pc;
    }

    @Nullable
    /* renamed from: fG */
    public final PlayableSource m32008fG() {
        return this.f26562pk;
    }

    /* renamed from: fH */
    public final boolean m32007fH() {
        return this.f26563pl;
    }

    /* renamed from: fI */
    public final List<C8665a.InterfaceC8672a> m32006fI() {
        return this.f26551pF;
    }

    /* renamed from: fJ */
    public final RewardRenderResult m32005fJ() {
        return this.f26548pC;
    }

    /* renamed from: fK */
    public final boolean m32004fK() {
        return RewardRenderResult.NEO_TK.equals(this.f26548pC);
    }

    /* renamed from: fL */
    public final boolean m32003fL() {
        return this.f26575px;
    }

    /* renamed from: fM */
    public final boolean m32002fM() {
        return this.f26542oW;
    }

    /* renamed from: fN */
    public final boolean m32001fN() {
        return this.mRewardVerifyCalled;
    }

    /* renamed from: fO */
    public final void m32000fO() {
        long j = this.f26573pv;
        int i = j != 0 ? (int) (j / 1000) : 0;
        AdTemplate adTemplate = this.mAdTemplate;
        C9908c.m27308e(adTemplate, C10483a.m25931ae(C10487e.m25641dQ(adTemplate)), i);
    }

    /* renamed from: fu */
    public final void m31998fu() {
        if (this.f26543oX || this.f26542oW || this.f26575px) {
            return;
        }
        boolean z = false;
        for (InterfaceC7921b interfaceC7921b : this.f26550pE) {
            z |= interfaceC7921b.interceptPlayCardResume();
        }
        if (z) {
            return;
        }
        for (InterfaceC7920a interfaceC7920a : this.f26549pD) {
            interfaceC7920a.mo31308fV();
        }
    }

    /* renamed from: fv */
    public final void m31997fv() {
        for (InterfaceC7920a interfaceC7920a : this.f26549pD) {
            interfaceC7920a.mo31307fW();
        }
    }

    /* renamed from: fx */
    public final boolean m31995fx() {
        return this.f26543oX;
    }

    /* renamed from: fy */
    public final void m31994fy() {
        m32038a(this.f26539oT, new InterfaceC10761a<InterfaceC8020c>() { // from class: com.kwad.components.ad.reward.g.5
            /* renamed from: c */
            private static void m31987c(InterfaceC8020c interfaceC8020c) {
                interfaceC8020c.mo31208iq();
            }

            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* synthetic */ void accept(InterfaceC8020c interfaceC8020c) {
                m31987c(interfaceC8020c);
            }
        });
    }

    @Nullable
    /* renamed from: fz */
    public final String m31993fz() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    @Override // com.kwad.components.core.p301l.C8688a, com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        m32014fA();
        C8025e c8025e = this.f26529oJ;
        if (c8025e != null) {
            c8025e.release();
        }
    }

    /* renamed from: x */
    public final void m31990x(String str) {
        int i = -1;
        try {
            if (C10251d.m26501yT()) {
                i = C7954a.m31932a(getActivity());
            }
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        C7955b.m31928a(this.mContext, this.mAdTemplate, str, i, this.mReportExtData);
    }

    /* renamed from: z */
    public final void m31989z(boolean z) {
        this.f26543oX = z;
        if (z) {
            m31997fv();
        } else {
            m31998fu();
        }
    }

    /* renamed from: g */
    public static boolean m31991g(AdInfo adInfo) {
        return C10484b.m25669g(adInfo) && !C7844b.m32176k(adInfo);
    }

    /* renamed from: a */
    public final void m32049a(InterfaceC7920a interfaceC7920a) {
        this.f26549pD.add(interfaceC7920a);
    }

    /* renamed from: b */
    public final void m32032b(InterfaceC7921b interfaceC7921b) {
        this.f26550pE.remove(interfaceC7921b);
    }

    @MainThread
    /* renamed from: c */
    public final void m32024c(InterfaceC7886g interfaceC7886g) {
        this.f26536oQ.remove(interfaceC7886g);
    }

    /* renamed from: c */
    private static DialogFragmentC7960b m32023c(C7907g c7907g) {
        DialogFragmentC9274e.C9277b c9277b = new DialogFragmentC9274e.C9277b();
        c9277b.m29132d(c7907g.mAdResultData);
        c9277b.m29138aU(C10484b.m25681du(c7907g.mAdTemplate));
        c9277b.m29137aW(false);
        c9277b.m29136aX(true);
        return DialogFragmentC7960b.m31920a(c7907g, c9277b);
    }

    /* renamed from: a */
    public final void m32048a(InterfaceC7921b interfaceC7921b) {
        this.f26550pE.add(interfaceC7921b);
    }

    /* renamed from: b */
    public final void m32029b(InterfaceC7958a interfaceC7958a) {
        this.f26537oR.remove(interfaceC7958a);
    }

    /* renamed from: d */
    public final void m32021d(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.f26565pn) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* renamed from: E */
    public static boolean m32065E(AdTemplate adTemplate) {
        return C10487e.m25624i(adTemplate, C7844b.m32176k(C10487e.m25641dQ(adTemplate)));
    }

    /* renamed from: a */
    public final void m32045a(InterfaceC7958a interfaceC7958a) {
        this.f26537oR.add(interfaceC7958a);
    }

    /* renamed from: b */
    public final void m32028b(InterfaceC7993r interfaceC7993r) {
        this.f26538oS.remove(interfaceC7993r);
    }

    /* renamed from: a */
    public final void m32044a(InterfaceC7993r interfaceC7993r) {
        this.f26538oS.add(interfaceC7993r);
    }

    /* renamed from: b */
    public final void m32027b(InterfaceC8020c interfaceC8020c) {
        if (interfaceC8020c != null) {
            this.f26539oT.remove(interfaceC8020c);
        }
    }

    /* renamed from: d */
    public final void m32019d(@Nullable PlayableSource playableSource) {
        this.f26562pk = playableSource;
    }

    /* renamed from: a */
    public final void m32043a(InterfaceC8020c interfaceC8020c) {
        if (interfaceC8020c != null) {
            this.f26539oT.add(interfaceC8020c);
        }
    }

    @MainThread
    /* renamed from: b */
    public final void m32034b(InterfaceC7886g interfaceC7886g) {
        this.f26536oQ.offer(interfaceC7886g);
    }

    /* renamed from: d */
    public final void m32017d(final boolean z, final boolean z2) {
        if (this.f26529oJ.m31821jM()) {
            C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C7897a m31820jN = C7907g.this.f26529oJ.m31820jN();
                    if (m31820jN != null) {
                        m31820jN.setAudioEnabled(z, z2);
                    }
                }
            }, 500L);
        }
    }

    /* renamed from: a */
    public static <T> void m32038a(List<T> list, InterfaceC10761a<T> interfaceC10761a) {
        if (list != null) {
            for (T t : list) {
                interfaceC10761a.accept(t);
            }
        }
    }

    /* renamed from: b */
    public final void m32037b(int i, Context context, int i2, int i3) {
        m32058a(i, context, i2, i3, 0L, false, null);
    }

    /* renamed from: d */
    private static DialogFragmentC7960b m32020d(C7907g c7907g) {
        if (C10483a.m25825cb(C10487e.m25641dQ(c7907g.mAdTemplate)) == 4 || C10483a.m25825cb(C10487e.m25641dQ(c7907g.mAdTemplate)) == 3) {
            return m32023c(c7907g);
        }
        return null;
    }

    /* renamed from: b */
    public final void m32036b(DialogInterface.OnDismissListener onDismissListener) {
        this.f26565pn.remove(onDismissListener);
    }

    /* renamed from: a */
    public final void m32056a(long j, long j2, int i) {
        for (InterfaceC7884e interfaceC7884e : this.f26540oU) {
            interfaceC7884e.mo31215ce();
        }
    }

    /* renamed from: b */
    public final void m32035b(C7864b c7864b) {
        C7863a.m32133gL().m32136a(this.mAdTemplate, c7864b);
    }

    /* renamed from: b */
    public final void m32025b(final C8674c c8674c) {
        final C8675d m32093I = C7885f.m32093I(this.mAdTemplate.getUniqueId());
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.g.10
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8675d c8675d = m32093I;
                if (c8675d != null) {
                    c8675d.m30035d(c8674c);
                }
            }
        });
    }

    /* renamed from: a */
    public final void m32060a(int i, Context context, int i2, int i3) {
        m32037b(i, context, i2, i3);
    }

    /* renamed from: a */
    public final void m32059a(int i, Context context, int i2, int i3, long j) {
        m32058a(1, context, 40, 1, j, false, null);
    }

    /* renamed from: a */
    public final void m32058a(int i, Context context, final int i2, int i3, long j, boolean z, final C9913b c9913b) {
        C8615a.m30233a(new C8615a.C8616a(context).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30202ao(false).m30205an(i3).m30158v(j).m30207am(i2).m30209al(i).m30213af(m31993fz()).m30214a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: fS */
            public String call() {
                C8025e c8025e = C7907g.this.f26529oJ;
                if (c8025e != null) {
                    return c8025e.m31820jN().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                try {
                    C7907g.this.m32057a(i2, c9913b);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* renamed from: b */
    public final void m32026b(C8665a.InterfaceC8672a interfaceC8672a) {
        List<C8665a.InterfaceC8672a> list = this.f26551pF;
        if (list != null) {
            list.remove(interfaceC8672a);
        }
    }

    /* renamed from: b */
    public static boolean m32031b(C7907g c7907g) {
        return c7907g.f26542oW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m32030b(C7907g c7907g, DialogFragmentC7931h.C7944c c7944c, DialogFragmentC7931h.InterfaceC7942a interfaceC7942a) {
        boolean m32031b = m32031b(c7907g);
        C10331c.m26254d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + m32031b);
        if (m32031b) {
            return;
        }
        DialogFragmentC7931h.m31976a(c7907g.getActivity(), c7907g.mAdTemplate, c7944c, interfaceC7942a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32057a(int i, C9913b c9913b) {
        if (c9913b == null) {
            c9913b = new C9913b();
        }
        c9913b.m27266cK(i);
        c9913b.m27247f(this.mRootContainer.getTouchCoords());
        C7955b.m31927a(this.mAdTemplate, (String) null, (String) null, c9913b, this.mReportExtData);
        C7863a.m32133gL().m32135c(this.mAdTemplate, C7864b.STATUS_NONE);
        this.f26528oI.mo32088bJ();
    }

    /* renamed from: a */
    public final void m32052a(DialogInterface.OnDismissListener onDismissListener) {
        this.f26565pn.add(onDismissListener);
    }

    /* renamed from: a */
    public final void m32050a(@Nullable InterfaceC7895o interfaceC7895o) {
        this.f26566po = interfaceC7895o;
    }

    /* renamed from: a */
    public final void m32040a(InterfaceC9289a interfaceC9289a) {
        this.f26541oV = interfaceC9289a;
    }

    /* renamed from: a */
    public final void m32041a(final C8674c c8674c) {
        final C8675d m32093I = C7885f.m32093I(this.mAdTemplate.getUniqueId());
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.g.9
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8675d c8675d = m32093I;
                if (c8675d != null) {
                    c8675d.m30036c(c8674c);
                }
            }
        });
    }

    /* renamed from: a */
    public final void m32042a(C8665a.InterfaceC8672a interfaceC8672a) {
        List<C8665a.InterfaceC8672a> list = this.f26551pF;
        if (list != null) {
            list.add(interfaceC8672a);
        }
    }

    @Nullable
    /* renamed from: a */
    public static C8674c m32039a(List<C8674c> list, long j) {
        if (j >= 0 && list != null) {
            for (C8674c c8674c : list) {
                if (C10487e.m25631ea(c8674c.getAdTemplate()) == j) {
                    return c8674c;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void m32051a(RewardRenderResult rewardRenderResult) {
        this.f26548pC = rewardRenderResult;
    }

    /* renamed from: a */
    public static void m32053a(Context context, C7907g c7907g, ViewGroup viewGroup) {
        AdInfo m25641dQ = C10487e.m25641dQ(c7907g.mAdTemplate);
        InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
        if (interfaceC8695a != null && interfaceC8695a.mo28869oK() && C10483a.m25842cL(C10487e.m25641dQ(c7907g.mAdTemplate))) {
            IAdLiveOfflineView iAdLiveOfflineView = null;
            try {
                iAdLiveOfflineView = interfaceC8695a.getView(context, C10483a.m25874bf(m25641dQ) == 8 ? 1 : 0);
            } catch (Throwable unused) {
            }
            if (iAdLiveOfflineView != null) {
                View view = iAdLiveOfflineView.getView();
                c7907g.f26530oK = iAdLiveOfflineView;
                viewGroup.addView(view);
                c7907g.f26529oJ.m31829a(2, new C7897a(c7907g.mAdTemplate, interfaceC8695a.getAdLivePlayModule(iAdLiveOfflineView, ServiceProvider.getAppId(), String.valueOf(C10483a.m25819cg(m25641dQ)), C10483a.m25818ch(m25641dQ), C10483a.m25817ci(m25641dQ))));
            }
        }
    }

    /* renamed from: a */
    public static long m32055a(long j, AdInfo adInfo) {
        return Math.min(C10483a.m25929ag(adInfo), j);
    }

    /* renamed from: a */
    public static void m32046a(C7907g c7907g, final DialogFragmentC7931h.C7944c c7944c, final DialogFragmentC7931h.InterfaceC7942a interfaceC7942a) {
        if (!c7907g.f26529oJ.m31821jM()) {
            AdInfo m25641dQ = C10487e.m25641dQ(c7907g.mAdTemplate);
            r1 = C7844b.m32177j(m25641dQ) || C10483a.m25825cb(m25641dQ) == 2 ? m32023c(c7907g) : null;
            if (r1 == null) {
                r1 = m32020d(c7907g);
            }
        }
        DialogFragmentC7960b dialogFragmentC7960b = r1;
        if (dialogFragmentC7960b != null) {
            DialogFragmentC7960b.m31919a(dialogFragmentC7960b, c7907g.getActivity(), c7907g.f26529oJ.getPlayDuration(), interfaceC7942a, new DialogFragmentC9274e.InterfaceC9276a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e.InterfaceC9276a
                /* renamed from: fT */
                public final boolean mo29141fT() {
                    C7907g.m32030b(C7907g.this, c7944c, interfaceC7942a);
                    return true;
                }
            });
        } else {
            m32030b(c7907g, c7944c, interfaceC7942a);
        }
    }

    /* renamed from: a */
    public static void m32054a(Activity activity, C7907g c7907g) {
        C10331c.m26254d("RewardCallerContext", "showExtraDialog");
        DialogFragmentC7960b.m31921a(c7907g, activity, c7907g.f26529oJ.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                C7907g.this.m32021d(dialogInterface);
                C10232b.m26625DD();
                Activity currentActivity = C10232b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(C7907g.this.getActivity())) {
                    return;
                }
                C7907g.this.f26529oJ.resume();
            }
        }, new DialogFragmentC7931h.C7943b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: fR */
            public final void mo29099fR() {
                C7907g.this.f26529oJ.pause();
            }
        });
    }
}
