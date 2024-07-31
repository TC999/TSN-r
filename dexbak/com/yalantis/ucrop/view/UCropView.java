package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.C13495R;
import p028c1.CropBoundsChangeListener;
import p028c1.OverlayViewChangeListener;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UCropView extends FrameLayout {

    /* renamed from: a */
    private GestureCropImageView f40012a;

    /* renamed from: b */
    private final OverlayView f40013b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.view.UCropView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13540a implements CropBoundsChangeListener {
        C13540a() {
        }

        @Override // p028c1.CropBoundsChangeListener
        /* renamed from: a */
        public void mo12916a(float f) {
            UCropView.this.f40013b.setTargetAspectRatio(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.view.UCropView$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13541b implements OverlayViewChangeListener {
        C13541b() {
        }

        @Override // p028c1.OverlayViewChangeListener
        /* renamed from: a */
        public void mo12915a(RectF rectF) {
            UCropView.this.f40012a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: d */
    private void m12917d() {
        this.f40012a.setCropBoundsChangeListener(new C13540a());
        this.f40013b.setOverlayViewChangeListener(new C13541b());
    }

    /* renamed from: c */
    public void m12918c() {
        removeView(this.f40012a);
        this.f40012a = new GestureCropImageView(getContext());
        m12917d();
        this.f40012a.setCropRect(getOverlayView().getCropViewRect());
        addView(this.f40012a, 0);
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f40012a;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.f40013b;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(C13495R.C13501layout.ucrop_view, (ViewGroup) this, true);
        this.f40012a = (GestureCropImageView) findViewById(C13495R.C13499id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(C13495R.C13499id.view_overlay);
        this.f40013b = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C13495R.styleable.ucrop_UCropView);
        overlayView.m12944h(obtainStyledAttributes);
        this.f40012a.m12960x(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        m12917d();
    }
}
