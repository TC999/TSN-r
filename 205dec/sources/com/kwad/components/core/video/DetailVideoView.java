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
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b Un;
    private b Uo;
    private SurfaceTexture Up;
    public Surface Uq;
    private a Ur;
    private PhotoInfo.VideoInfo Us;
    private final RectF Ut;
    private int Uu;
    private int Uv;
    @NonNull
    private final d Uw;
    private Matrix mMatrix;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Ut = new RectF();
        this.Uu = 0;
        this.Uv = 0;
        this.Uw = new d();
        B(context);
    }

    private void B(Context context) {
        this.mMatrix = new Matrix();
        this.Un = new com.kwad.components.core.page.widget.b(context);
        addView(this.Un, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        rz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        Surface surface = this.Uq;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
            this.Uq = null;
        }
    }

    private void rz() {
        this.Un.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
                if (DetailVideoView.this.Up == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.Up = surfaceTexture;
                DetailVideoView.this.rA();
                DetailVideoView.this.Uq = new Surface(surfaceTexture);
                if (DetailVideoView.this.Uo != null) {
                    DetailVideoView.this.Uo.setSurface(DetailVideoView.this.Uq);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public final void adaptVideoSize(int i4, int i5) {
        if (this.Un == null) {
            com.kwad.sdk.core.e.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.Uv = i5;
        this.Uu = i4;
        if (this.Uw.rB()) {
            int rC = this.Uw.rC();
            VideoAdapters.a aVar = null;
            if (rC == 1) {
                aVar = new VideoAdapters.c();
            } else if (rC == 2) {
                aVar = new VideoAdapters.b();
            }
            if (aVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.Un;
                aVar.a(bVar, (View) bVar.getParent(), i4, i5);
            }
        } else if (this.Uw.rH()) {
            com.kwad.sdk.d.a.a.D(this.Un);
        } else if (this.Uw.rD()) {
            com.kwad.sdk.d.a.a.e(this.Un, i4, i5);
        } else if (this.Uw.rF()) {
            com.kwad.sdk.d.a.a.f(this.Un, i4, i5);
        } else if (this.Uw.rE()) {
            com.kwad.sdk.d.a.a.d(this.Un, i4, i5);
        } else if (this.Uw.rG()) {
            a(this.Un, i4, i5);
        } else {
            View view = (View) this.Un.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.Us;
            if (videoInfo != null && com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.Un.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.Un.setTransform(this.mMatrix);
                this.Un.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.Un.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = (int) ((i5 / (i4 * 1.0f)) * width);
                this.mMatrix.reset();
                this.Un.setTransform(this.mMatrix);
                this.Un.setLayoutParams(layoutParams2);
            }
            this.Ut.set(this.Un.getLeft(), this.Un.getTop(), this.Un.getRight(), this.Un.getBottom());
        }
    }

    @Deprecated
    public final void fixWidth(boolean z3) {
        this.Uw.aR(z3);
    }

    public final void g(boolean z3, int i4) {
        this.Uw.setAd(true);
        this.Uw.aN(i4);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.Un;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.Un) {
            a aVar = this.Ur;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Ur;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rA();
        SurfaceTexture surfaceTexture = this.Up;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Up = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        int i8;
        super.onSizeChanged(i4, i5, i6, i7);
        int i9 = this.Uu;
        if (i9 <= 0 || (i8 = this.Uv) <= 0) {
            return;
        }
        adaptVideoSize(i9, i8);
    }

    @Deprecated
    public void setAd(boolean z3) {
        this.Uw.setAd(z3);
    }

    public void setClickListener(a aVar) {
        this.Ur = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z3) {
        this.Uw.setFillXY(z3);
    }

    @Deprecated
    public void setForce(boolean z3) {
        this.Uw.setForce(z3);
    }

    public void setHorizontalVideo(boolean z3) {
        this.Uw.setHorizontalVideo(z3);
    }

    public void setMediaPlayer(b bVar) {
        this.Uo = bVar;
        Surface surface = this.Uq;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.kwad.components.core.widget.h.b(this, f4);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Us = videoInfo;
    }

    public final void updateTextureViewGravity(int i4) {
        com.kwad.components.core.page.widget.b bVar = this.Un;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i4;
            this.Un.requestLayout();
        }
    }

    private void a(View view, long j4, long j5) {
        View view2;
        if (view == null || j4 == 0 || j5 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f4 = ((float) j4) / ((float) j5);
        float f5 = height * f4;
        float f6 = width;
        if (f5 > f6) {
            height = (int) (f6 / f4);
        } else {
            width = (int) f5;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.Un.setLayoutParams(layoutParams);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ut = new RectF();
        this.Uu = 0;
        this.Uv = 0;
        this.Uw = new d();
        B(context);
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i4, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean W = com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i4);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (W) {
                    int i5 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i5;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i5, intValue);
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
