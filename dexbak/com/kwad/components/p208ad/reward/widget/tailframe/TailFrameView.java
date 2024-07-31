package com.kwad.components.p208ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TailFrameView extends KSFrameLayout {

    /* renamed from: BM */
    private AbstractC8345a f27572BM;

    /* renamed from: qo */
    private C7907g f27573qo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8341a extends AbstractC8345a implements InterfaceC11145c {
        public C8341a() {
            super(C9659R.C9663layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.p208ad.reward.widget.tailframe.AbstractC8345a
        /* renamed from: a */
        public final void mo30926a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, InterfaceC8348b interfaceC8348b) {
            super.mo30926a(adTemplate, jSONObject, interfaceC8348b);
            KSImageLoader.loadImage(this.f27579BD, C10483a.m25964X(this.mAdInfo), this.mAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameView$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8342b extends AbstractC8345a implements InterfaceC11145c {

        /* renamed from: BN */
        private ImageView f27574BN;

        /* renamed from: BO */
        private ImageView f27575BO;

        /* renamed from: BP */
        private ImageView f27576BP;

        public C8342b() {
            super(C9659R.C9663layout.ksad_video_tf_view_landscape_vertical);
        }

        /* renamed from: kn */
        private void m30930kn() {
            KSImageLoader.loadImage(this.f27574BN, C10483a.m25964X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.f27575BO, C10483a.m25964X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.f27576BP, C10483a.m25964X(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.p208ad.reward.widget.tailframe.AbstractC8345a
        /* renamed from: B */
        public final void mo30928B(Context context) {
            super.mo30928B(context);
            this.f27574BN = (ImageView) this.f27578BC.findViewById(C9659R.C9662id.ksad_video_thumb_left);
            this.f27575BO = (ImageView) this.f27578BC.findViewById(C9659R.C9662id.ksad_video_thumb_mid);
            this.f27576BP = (ImageView) this.f27578BC.findViewById(C9659R.C9662id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.p208ad.reward.widget.tailframe.AbstractC8345a
        /* renamed from: a */
        public final void mo30926a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, InterfaceC8348b interfaceC8348b) {
            super.mo30926a(adTemplate, jSONObject, interfaceC8348b);
            m30930kn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameView$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8343c extends AbstractC8345a implements InterfaceC11145c {

        /* renamed from: BQ */
        private View f27577BQ;

        public C8343c() {
            super(C9659R.C9663layout.ksad_video_tf_view_portrait_horizontal);
        }

        /* renamed from: kn */
        private void m30929kn() {
            AdInfo.AdMaterialInfo.MaterialFeature m25938aX = C10483a.m25938aX(this.mAdInfo);
            int i = m25938aX.width;
            int i2 = m25938aX.height;
            int screenWidth = C10751a.getScreenWidth(this.f27578BC.getContext());
            ViewGroup.LayoutParams layoutParams = this.f27579BD.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = (int) (screenWidth * (i2 / i));
            KSImageLoader.loadImage(this.f27579BD, m25938aX.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.p208ad.reward.widget.tailframe.AbstractC8345a
        /* renamed from: B */
        public final void mo30928B(Context context) {
            super.mo30928B(context);
            this.f27577BQ = this.f27578BC.findViewById(C9659R.C9662id.video_cover);
        }

        @Override // com.kwad.components.p208ad.reward.widget.tailframe.AbstractC8345a
        /* renamed from: a */
        public final void mo30926a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, InterfaceC8348b interfaceC8348b) {
            super.mo30926a(adTemplate, jSONObject, interfaceC8348b);
            if (C10487e.m25654F(this.mAdTemplate)) {
                this.f27577BQ.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.f27578BC.setBackground(null);
            }
            m30929kn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameView$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8344d extends AbstractC8345a {
        public C8344d() {
            super(C9659R.C9663layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.p208ad.reward.widget.tailframe.AbstractC8345a
        /* renamed from: a */
        public final void mo30926a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, InterfaceC8348b interfaceC8348b) {
            super.mo30926a(adTemplate, jSONObject, interfaceC8348b);
            if (C10487e.m25654F(this.mAdTemplate)) {
                this.f27578BC.setBackground(null);
                this.f27579BD.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.f27579BD, C10483a.m25964X(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    /* renamed from: f */
    private void m30932f(boolean z, boolean z2) {
        if (this.f27572BM != null) {
            return;
        }
        if (z) {
            if (z2) {
                this.f27572BM = new C8344d();
            } else {
                this.f27572BM = new C8343c();
            }
        } else if (z2) {
            this.f27572BM = new C8342b();
        } else {
            this.f27572BM = new C8341a();
        }
    }

    /* renamed from: a */
    public final void m30933a(InterfaceC8348b interfaceC8348b) {
        this.f27572BM.setCallerContext(this.f27573qo);
        AbstractC8345a abstractC8345a = this.f27572BM;
        C7907g c7907g = this.f27573qo;
        abstractC8345a.mo30926a(c7907g.mAdTemplate, c7907g.mReportExtData, interfaceC8348b);
    }

    public final void destroy() {
        AbstractC8345a abstractC8345a = this.f27572BM;
        if (abstractC8345a != null) {
            abstractC8345a.destroy();
        }
    }

    /* renamed from: jQ */
    public final void m30931jQ() {
        this.f27572BM.m30921jQ();
    }

    public void setCallerContext(C7907g c7907g) {
        this.f27573qo = c7907g;
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public final void m30934a(Context context, boolean z, boolean z2) {
        m30932f(z, z2);
        this.f27572BM.mo30928B(context);
        this.f27572BM.m30922f(z, z2);
        addView(this.f27572BM.m30919kj(), -1, -1);
    }

    public TailFrameView(@NonNull Context context, View view) {
        super(context, view);
    }
}
