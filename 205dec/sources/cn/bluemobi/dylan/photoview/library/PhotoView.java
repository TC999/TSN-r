package cn.bluemobi.dylan.photoview.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.photoview.library.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PhotoView extends ImageView implements c {

    /* renamed from: a  reason: collision with root package name */
    private d f1880a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f1881b;

    public PhotoView(Context context) {
        this(context, null);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean a() {
        return this.f1880a.a();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void b(float f4, float f5, float f6, boolean z3) {
        this.f1880a.b(f4, f5, f6, z3);
    }

    protected void c() {
        d dVar = this.f1880a;
        if (dVar == null || dVar.u() == null) {
            this.f1880a = new d(this);
        }
        ImageView.ScaleType scaleType = this.f1881b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f1881b = null;
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void d(float f4, boolean z3) {
        this.f1880a.d(f4, z3);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean f(Matrix matrix) {
        return this.f1880a.f(matrix);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Matrix getDisplayMatrix() {
        return this.f1880a.getDisplayMatrix();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public RectF getDisplayRect() {
        return this.f1880a.getDisplayRect();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public c getIPhotoViewImplementation() {
        return this.f1880a;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMaximumScale() {
        return this.f1880a.getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMediumScale() {
        return this.f1880a.getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMinimumScale() {
        return this.f1880a.getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public d.f getOnPhotoTapListener() {
        return this.f1880a.getOnPhotoTapListener();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public d.h getOnViewTapListener() {
        return this.f1880a.getOnViewTapListener();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getScale() {
        return this.f1880a.getScale();
    }

    @Override // android.widget.ImageView, cn.bluemobi.dylan.photoview.library.c
    public ImageView.ScaleType getScaleType() {
        return this.f1880a.getScaleType();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Bitmap getVisibleRectangleBitmap() {
        return this.f1880a.getVisibleRectangleBitmap();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void h(float f4, float f5, float f6) {
        this.f1880a.h(f4, f5, f6);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        c();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.f1880a.r();
        super.onDetachedFromWindow();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setAllowParentInterceptOnEdge(boolean z3) {
        this.f1880a.setAllowParentInterceptOnEdge(z3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d dVar = this.f1880a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i4) {
        super.setImageResource(i4);
        d dVar = this.f1880a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d dVar = this.f1880a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMaxScale(float f4) {
        setMaximumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMaximumScale(float f4) {
        this.f1880a.setMaximumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMediumScale(float f4) {
        this.f1880a.setMediumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMidScale(float f4) {
        setMediumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMinScale(float f4) {
        setMinimumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMinimumScale(float f4) {
        this.f1880a.setMinimumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f1880a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View, cn.bluemobi.dylan.photoview.library.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1880a.setOnLongClickListener(onLongClickListener);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnMatrixChangeListener(d.e eVar) {
        this.f1880a.setOnMatrixChangeListener(eVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnPhotoTapListener(d.f fVar) {
        this.f1880a.setOnPhotoTapListener(fVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnScaleChangeListener(d.g gVar) {
        this.f1880a.setOnScaleChangeListener(gVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnViewTapListener(d.h hVar) {
        this.f1880a.setOnViewTapListener(hVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setPhotoViewRotation(float f4) {
        this.f1880a.setRotationTo(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationBy(float f4) {
        this.f1880a.setRotationBy(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationTo(float f4) {
        this.f1880a.setRotationTo(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setScale(float f4) {
        this.f1880a.setScale(f4);
    }

    @Override // android.widget.ImageView, cn.bluemobi.dylan.photoview.library.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        d dVar = this.f1880a;
        if (dVar != null) {
            dVar.setScaleType(scaleType);
        } else {
            this.f1881b = scaleType;
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomTransitionDuration(int i4) {
        this.f1880a.setZoomTransitionDuration(i4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomable(boolean z3) {
        this.f1880a.setZoomable(z3);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        c();
    }
}
