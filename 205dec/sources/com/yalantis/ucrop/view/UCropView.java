package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import c1.c;
import c1.d;
import com.yalantis.ucrop.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UCropView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private GestureCropImageView f54519a;

    /* renamed from: b  reason: collision with root package name */
    private final OverlayView f54520b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements c {
        a() {
        }

        @Override // c1.c
        public void a(float f4) {
            UCropView.this.f54520b.setTargetAspectRatio(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements d {
        b() {
        }

        @Override // c1.d
        public void a(RectF rectF) {
            UCropView.this.f54519a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void d() {
        this.f54519a.setCropBoundsChangeListener(new a());
        this.f54520b.setOverlayViewChangeListener(new b());
    }

    public void c() {
        removeView(this.f54519a);
        this.f54519a = new GestureCropImageView(getContext());
        d();
        this.f54519a.setCropRect(getOverlayView().getCropViewRect());
        addView(this.f54519a, 0);
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f54519a;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.f54520b;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        this.f54519a = (GestureCropImageView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.f54520b = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.h(obtainStyledAttributes);
        this.f54519a.x(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        d();
    }
}
