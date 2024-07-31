package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.page.widget.C8873b;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.components.core.widget.C9377h;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {

    /* renamed from: Un */
    public C8873b f28877Un;

    /* renamed from: Uo */
    private C8978b f28878Uo;

    /* renamed from: Up */
    private SurfaceTexture f28879Up;

    /* renamed from: Uq */
    public Surface f28880Uq;

    /* renamed from: Ur */
    private InterfaceC8960a f28881Ur;

    /* renamed from: Us */
    private PhotoInfo.VideoInfo f28882Us;

    /* renamed from: Ut */
    private final RectF f28883Ut;

    /* renamed from: Uu */
    private int f28884Uu;

    /* renamed from: Uv */
    private int f28885Uv;
    @NonNull

    /* renamed from: Uw */
    private final C8992d f28886Uw;
    private Matrix mMatrix;

    /* renamed from: com.kwad.components.core.video.DetailVideoView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8960a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f28883Ut = new RectF();
        this.f28884Uu = 0;
        this.f28885Uv = 0;
        this.f28886Uw = new C8992d();
        m29523B(context);
    }

    /* renamed from: B */
    private void m29523B(Context context) {
        this.mMatrix = new Matrix();
        this.f28877Un = new C8873b(context);
        addView(this.f28877Un, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        m29514rz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rA */
    public void m29515rA() {
        Surface surface = this.f28880Uq;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
            }
            this.f28880Uq = null;
        }
    }

    /* renamed from: rz */
    private void m29514rz() {
        this.f28877Un.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.f28879Up == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.f28879Up = surfaceTexture;
                DetailVideoView.this.m29515rA();
                DetailVideoView.this.f28880Uq = new Surface(surfaceTexture);
                if (DetailVideoView.this.f28878Uo != null) {
                    DetailVideoView.this.f28878Uo.setSurface(DetailVideoView.this.f28880Uq);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public final void adaptVideoSize(int i, int i2) {
        if (this.f28877Un == null) {
            C10331c.m26246w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.f28885Uv = i2;
        this.f28884Uu = i;
        if (this.f28886Uw.m29439rB()) {
            int m29438rC = this.f28886Uw.m29438rC();
            VideoAdapters.AbstractC8962a abstractC8962a = null;
            if (m29438rC == 1) {
                abstractC8962a = new VideoAdapters.C8964c();
            } else if (m29438rC == 2) {
                abstractC8962a = new VideoAdapters.C8963b();
            }
            if (abstractC8962a != null) {
                C8873b c8873b = this.f28877Un;
                abstractC8962a.mo29442a(c8873b, (View) c8873b.getParent(), i, i2);
            }
        } else if (this.f28886Uw.m29433rH()) {
            C10751a.m24927D(this.f28877Un);
        } else if (this.f28886Uw.m29437rD()) {
            C10751a.m24910e(this.f28877Un, i, i2);
        } else if (this.f28886Uw.m29435rF()) {
            C10751a.m24909f(this.f28877Un, i, i2);
        } else if (this.f28886Uw.m29436rE()) {
            C10751a.m24912d(this.f28877Un, i, i2);
        } else if (this.f28886Uw.m29434rG()) {
            m29522a(this.f28877Un, i, i2);
        } else {
            View view = (View) this.f28877Un.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.f28882Us;
            if (videoInfo != null && C10490h.m25613a(this.mMatrix, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.f28877Un.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.f28877Un.setTransform(this.mMatrix);
                this.f28877Un.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f28877Un.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = (int) ((i2 / (i * 1.0f)) * width);
                this.mMatrix.reset();
                this.f28877Un.setTransform(this.mMatrix);
                this.f28877Un.setLayoutParams(layoutParams2);
            }
            this.f28883Ut.set(this.f28877Un.getLeft(), this.f28877Un.getTop(), this.f28877Un.getRight(), this.f28877Un.getBottom());
        }
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.f28886Uw.m29440aR(z);
    }

    /* renamed from: g */
    public final void m29516g(boolean z, int i) {
        this.f28886Uw.setAd(true);
        this.f28886Uw.m29441aN(i);
    }

    public int getTextureViewGravity() {
        C8873b c8873b = this.f28877Un;
        if (c8873b == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = c8873b.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f28877Un) {
            InterfaceC8960a interfaceC8960a = this.f28881Ur;
            if (interfaceC8960a != null) {
                interfaceC8960a.onClickVideoView();
                return;
            }
            return;
        }
        InterfaceC8960a interfaceC8960a2 = this.f28881Ur;
        if (interfaceC8960a2 != null) {
            interfaceC8960a2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m29515rA();
        SurfaceTexture surfaceTexture = this.f28879Up;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f28879Up = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        int i6 = this.f28884Uu;
        if (i6 <= 0 || (i5 = this.f28885Uv) <= 0) {
            return;
        }
        adaptVideoSize(i6, i5);
    }

    @Deprecated
    public void setAd(boolean z) {
        this.f28886Uw.setAd(z);
    }

    public void setClickListener(InterfaceC8960a interfaceC8960a) {
        this.f28881Ur = interfaceC8960a;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.f28886Uw.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.f28886Uw.setForce(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.f28886Uw.setHorizontalVideo(z);
    }

    public void setMediaPlayer(C8978b c8978b) {
        this.f28878Uo = c8978b;
        Surface surface = this.f28880Uq;
        if (surface == null || c8978b == null) {
            return;
        }
        c8978b.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            C9377h.m28870b(this, f);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.f28882Us = videoInfo;
    }

    public final void updateTextureViewGravity(int i) {
        C8873b c8873b = this.f28877Un;
        if (c8873b == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = c8873b.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.f28877Un.requestLayout();
        }
    }

    /* renamed from: a */
    private void m29522a(View view, long j, long j2) {
        View view2;
        if (view == null || j == 0 || j2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f = ((float) j) / ((float) j2);
        float f2 = height * f;
        float f3 = width;
        if (f2 > f3) {
            height = (int) (f3 / f);
        } else {
            width = (int) f2;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.f28877Un.setLayoutParams(layoutParams);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28883Ut = new RectF();
        this.f28884Uu = 0;
        this.f28885Uv = 0;
        this.f28886Uw = new C8992d();
        m29523B(context);
    }

    /* renamed from: a */
    public final ValueAnimator m29520a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean m25965W = C10483a.m25965W(C10487e.m25641dQ(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (m25965W) {
                    int i2 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i2;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i2, intValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = intValue;
                        layoutParams3.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams3);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(create);
        return ofInt;
    }
}
