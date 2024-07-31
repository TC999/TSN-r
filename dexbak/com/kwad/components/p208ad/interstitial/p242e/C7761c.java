package com.kwad.components.p208ad.interstitial.p242e;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.page.C8791a;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.interstitial.AlertDialogC7725d;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.interstitial.p244f.C7793b;
import com.kwad.components.p208ad.interstitial.p245g.C7798d;
import com.kwad.components.p208ad.interstitial.report.C7802a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.mvp.AbstractC10868a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.interstitial.e.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7761c extends AbstractC10868a {
    @NonNull

    /* renamed from: dU */
    public KsAdVideoPlayConfig f26197dU;

    /* renamed from: eN */
    public TextureView$SurfaceTextureListenerC10537a f26198eN;

    /* renamed from: ib */
    public C7793b f26200ib;

    /* renamed from: ie */
    public KsInterstitialAd.AdInteractionListener f26201ie;

    /* renamed from: io */
    public AlertDialogC7725d f26202io;

    /* renamed from: jL */
    public C7798d f26203jL;

    /* renamed from: jM */
    public boolean f26204jM;

    /* renamed from: jN */
    public boolean f26205jN;

    /* renamed from: jO */
    public boolean f26206jO;

    /* renamed from: jP */
    public InterfaceC7768a f26207jP;

    /* renamed from: jR */
    public AbstractC9293e f26209jR;
    @NonNull

    /* renamed from: jS */
    public KSFrameLayout f26210jS;

    /* renamed from: jT */
    public InterfaceC7771d f26211jT;

    /* renamed from: jX */
    public boolean f26215jX;

    /* renamed from: jY */
    public boolean f26216jY;
    public AdResultData mAdResultData;
    public C8619c mApkDownloadHelper;

    /* renamed from: jQ */
    public List<InterfaceC7768a> f26208jQ = new CopyOnWriteArrayList();

    /* renamed from: fS */
    private Handler f26199fS = new Handler(Looper.getMainLooper());

    /* renamed from: jW */
    public volatile boolean f26214jW = false;

    /* renamed from: jZ */
    public int f26217jZ = -1;

    /* renamed from: jV */
    public List<View$OnClickListenerC8966a.InterfaceC8970c> f26213jV = new CopyOnWriteArrayList();

    /* renamed from: jU */
    public List<InterfaceC7770c> f26212jU = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.e.c$3 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    final class C77653 implements ImageLoadingListener {

        /* renamed from: fo */
        final /* synthetic */ View f26225fo;

        /* renamed from: gq */
        final /* synthetic */ Context f26226gq;

        C77653(Context context, View view) {
            this.f26226gq = context;
            this.f26225fo = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.c.3.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    C10331c.m26254d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    C10331c.m26254d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = C77653.this.f26226gq.getResources().getDimension(C9659R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(C77653.this.f26226gq.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    C77653.this.f26225fo.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.c.3.1.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C77653.this.f26225fo.setBackground(create);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7768a {
        /* renamed from: b */
        void mo32411b(long j, long j2);
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7769b {
        private final Context context;

        /* renamed from: kj */
        private int f26232kj;

        /* renamed from: kk */
        private boolean f26233kk;

        /* renamed from: kl */
        private int f26234kl;

        /* renamed from: km */
        private boolean f26235km;

        /* renamed from: kn */
        private C11008ac.C11009a f26236kn;

        /* renamed from: ko */
        public double f26237ko;

        /* renamed from: kp */
        public boolean f26238kp;

        public C7769b(Context context) {
            this.context = context;
        }

        /* renamed from: A */
        public final C7769b m32445A(int i) {
            this.f26234kl = i;
            return this;
        }

        /* renamed from: a */
        public final C7769b m32444a(C11008ac.C11009a c11009a) {
            this.f26236kn = c11009a;
            return this;
        }

        /* renamed from: cU */
        public final int m32441cU() {
            return this.f26232kj;
        }

        /* renamed from: cV */
        public final boolean m32440cV() {
            return this.f26233kk;
        }

        /* renamed from: cW */
        public final boolean m32439cW() {
            return this.f26235km;
        }

        /* renamed from: cX */
        public final int m32438cX() {
            return this.f26234kl;
        }

        /* renamed from: cY */
        public final double m32437cY() {
            return this.f26237ko;
        }

        public final Context getContext() {
            return this.context;
        }

        public final C11008ac.C11009a getTouchCoords() {
            return this.f26236kn;
        }

        /* renamed from: k */
        public final C7769b m32435k(boolean z) {
            this.f26233kk = z;
            return this;
        }

        /* renamed from: l */
        public final C7769b m32434l(boolean z) {
            this.f26235km = true;
            return this;
        }

        /* renamed from: m */
        public final C7769b m32433m(boolean z) {
            this.f26238kp = true;
            return this;
        }

        /* renamed from: z */
        public final C7769b m32432z(int i) {
            this.f26232kj = i;
            return this;
        }

        /* renamed from: c */
        public final C7769b m32443c(double d) {
            this.f26237ko = d;
            return this;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7770c {
        /* renamed from: cZ */
        void mo32410cZ();
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7771d {
        /* renamed from: da */
        void mo32388da();
    }

    /* renamed from: K */
    public final boolean m32468K(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return C10483a.m25900bH(C10487e.m25641dQ(adTemplate));
        }
        C10331c.m26246w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    /* renamed from: b */
    public final void m32452b(View$OnClickListenerC8966a.InterfaceC8970c interfaceC8970c) {
        this.f26213jV.remove(interfaceC8970c);
    }

    /* renamed from: cR */
    public final void m32449cR() {
        InterfaceC7771d interfaceC7771d = this.f26211jT;
        if (interfaceC7771d != null) {
            interfaceC7771d.mo32388da();
        }
    }

    /* renamed from: cS */
    public final void m32448cS() {
        for (InterfaceC7770c interfaceC7770c : this.f26212jU) {
            interfaceC7770c.mo32410cZ();
        }
    }

    /* renamed from: cT */
    public final boolean m32447cT() {
        C7798d c7798d = this.f26203jL;
        boolean z = c7798d == null || c7798d.getParent() == null;
        C10331c.m26254d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    /* renamed from: d */
    public final void m32446d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = C10485c.m25661n(adResultData);
    }

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        this.f26199fS.removeCallbacksAndMessages(null);
        this.f26213jV.clear();
        this.f26212jU.clear();
        C7793b c7793b = this.f26200ib;
        if (c7793b != null) {
            c7793b.m28899tx();
        }
    }

    /* renamed from: a */
    public final void m32459a(View$OnClickListenerC8966a.InterfaceC8970c interfaceC8970c) {
        if (this.f26213jV.contains(interfaceC8970c)) {
            return;
        }
        this.f26213jV.add(interfaceC8970c);
    }

    /* renamed from: b */
    public final void m32453b(C7769b c7769b) {
        C9913b c9913b = new C9913b();
        c9913b.m27247f(c7769b.getTouchCoords());
        if (!c7769b.m32440cV() && !c7769b.f26235km) {
            c7769b.m32445A(153);
        }
        C9908c.m27340a(this.mAdTemplate, new C9913b().m27266cK(c7769b.m32438cX()).m27247f(c7769b.getTouchCoords()).m27252cY(C11015ai.m24123LZ() ? 2 : 1).m27246l(c7769b.m32437cY()), (JSONObject) null);
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f26198eN;
        if (textureView$SurfaceTextureListenerC10537a != null) {
            long m32458a = m32458a(textureView$SurfaceTextureListenerC10537a);
            int m32451b = m32451b(this.f26198eN);
            c9913b.m27269ah(m32458a);
            c9913b.m27258cS(m32451b);
        }
        this.f26204jM = true;
        if (this.f26206jO) {
            return;
        }
        m32456b(1L, c7769b.f26234kl);
    }

    /* renamed from: a */
    public final void m32461a(final C7769b c7769b) {
        C7802a.m32299dM().m32302a(this.mAdTemplate, 1L, c7769b.f26234kl);
        boolean z = c7769b.m32441cU() == 1;
        if (C7721b.m32572cH() || z || c7769b.m32439cW() || c7769b.f26238kp) {
            C8615a.m30233a(new C8615a.C8616a(c7769b.getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30202ao(z).m30209al(1).m30207am(c7769b.f26234kl).m30158v(this.f26198eN.getCurrentPosition()).m30205an(c7769b.m32441cU()).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.interstitial.e.c.1
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    C7761c.this.m32453b(c7769b);
                    if (C7761c.this.f26202io == null || !C7721b.m32569cK()) {
                        return;
                    }
                    C7761c c7761c = C7761c.this;
                    c7761c.m32457a(false, -1, c7761c.f26198eN);
                    C7761c.this.f26199fS.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.c.1.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C7761c.this.f26202io.dismiss();
                        }
                    }, 500L);
                }
            }));
        }
    }

    /* renamed from: a */
    public final void m32465a(final Context context, final int i, int i2, int i3) {
        C7802a.m32299dM().m32302a(this.mAdTemplate, 6L, i);
        C8615a.m30233a(new C8615a.C8616a(context).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30202ao(false).m30205an(2).m30209al(6).m30207am(i).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.interstitial.e.c.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                C7761c c7761c = C7761c.this;
                int i4 = r2;
                int i5 = i;
                c7761c.m32467a(i4, i5, context, 6L, i5);
            }
        }));
    }

    /* renamed from: b */
    public final void m32454b(InterfaceC7768a interfaceC7768a) {
        if (interfaceC7768a == null) {
            return;
        }
        this.f26208jQ.remove(interfaceC7768a);
    }

    /* renamed from: b */
    public final void m32456b(long j, long j2) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        for (InterfaceC7768a interfaceC7768a : this.f26208jQ) {
            interfaceC7768a.mo32411b(j, j2);
        }
        InterfaceC7768a interfaceC7768a2 = this.f26207jP;
        if (interfaceC7768a2 != null) {
            interfaceC7768a2.mo32411b(j, j2);
        }
        if (this.f26206jO || (adInteractionListener = this.f26201ie) == null) {
            return;
        }
        adInteractionListener.onAdClicked();
    }

    /* renamed from: b */
    public final void m32455b(Context context, AdTemplate adTemplate) {
        if (this.f26214jW) {
            return;
        }
        C8791a.launch(context, adTemplate);
        this.f26214jW = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32467a(int i, int i2, Context context, long j, long j2) {
        C9908c.m27342a(this.mAdTemplate, new C9913b().m27259cR(i).m27266cK(i2).m27252cY(C11015ai.m24123LZ() ? 2 : 1).m27270Bs(), (JSONObject) null);
        this.f26204jM = true;
        if (this.f26206jO) {
            return;
        }
        m32456b(j, j2);
    }

    /* renamed from: b */
    private static int m32451b(@Nullable TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a) {
        if (textureView$SurfaceTextureListenerC10537a == null) {
            return -1;
        }
        long duration = textureView$SurfaceTextureListenerC10537a.getDuration();
        long currentPosition = textureView$SurfaceTextureListenerC10537a.getCurrentPosition();
        if (duration != 0) {
            return Math.round((((float) currentPosition) / ((float) duration)) * 100.0f);
        }
        return -1;
    }

    /* renamed from: a */
    public final void m32462a(InterfaceC7768a interfaceC7768a) {
        if (interfaceC7768a == null) {
            return;
        }
        this.f26208jQ.add(interfaceC7768a);
    }

    /* renamed from: a */
    public static boolean m32464a(Context context, AdInfo adInfo) {
        return C10483a.m25939aW(adInfo) && !C11015ai.m24123LZ();
    }

    /* renamed from: a */
    public final void m32463a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        if (view == null) {
            return;
        }
        String url = C10483a.m25862br(adInfo).getUrl();
        if (C11053bg.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new C77653(context, view));
    }

    /* renamed from: a */
    public final void m32457a(boolean z, int i, @Nullable TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a) {
        long j;
        int m32466a;
        C7802a.m32299dM().m32298l(this.mAdTemplate);
        if (textureView$SurfaceTextureListenerC10537a != null) {
            j = m32458a(textureView$SurfaceTextureListenerC10537a);
            m32466a = m32451b(textureView$SurfaceTextureListenerC10537a);
        } else {
            j = i;
            m32466a = m32466a(j, this.mAdTemplate);
        }
        C9908c.m27353a(this.mAdTemplate, z ? 14 : 1, j, m32466a, this.f26202io.getTimerHelper().getTime(), null);
    }

    /* renamed from: a */
    private static long m32458a(@Nullable TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a) {
        if (textureView$SurfaceTextureListenerC10537a == null) {
            return -1L;
        }
        return textureView$SurfaceTextureListenerC10537a.getCurrentPosition();
    }

    /* renamed from: a */
    private static int m32466a(long j, @NonNull AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float m25975M = ((float) C10483a.m25975M(C10487e.m25641dQ(adTemplate))) / 1000.0f;
        if (m25975M != 0.0f) {
            return Math.round((((float) j) / m25975M) * 100.0f);
        }
        return -1;
    }
}
