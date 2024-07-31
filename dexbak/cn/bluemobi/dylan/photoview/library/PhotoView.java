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
import cn.bluemobi.dylan.photoview.library.PhotoViewAttacher;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PhotoView extends ImageView implements IPhotoView {

    /* renamed from: a */
    private PhotoViewAttacher f1895a;

    /* renamed from: b */
    private ImageView.ScaleType f1896b;

    public PhotoView(Context context) {
        this(context, null);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: a */
    public boolean mo57548a() {
        return this.f1895a.mo57548a();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: b */
    public void mo57547b(float f, float f2, float f3, boolean z) {
        this.f1895a.mo57547b(f, f2, f3, z);
    }

    /* renamed from: c */
    protected void m57559c() {
        PhotoViewAttacher photoViewAttacher = this.f1895a;
        if (photoViewAttacher == null || photoViewAttacher.m57531u() == null) {
            this.f1895a = new PhotoViewAttacher(this);
        }
        ImageView.ScaleType scaleType = this.f1896b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f1896b = null;
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: d */
    public void mo57546d(float f, boolean z) {
        this.f1895a.mo57546d(f, z);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: f */
    public boolean mo57545f(Matrix matrix) {
        return this.f1895a.mo57545f(matrix);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public Matrix getDisplayMatrix() {
        return this.f1895a.getDisplayMatrix();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public RectF getDisplayRect() {
        return this.f1895a.getDisplayRect();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public IPhotoView getIPhotoViewImplementation() {
        return this.f1895a;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getMaximumScale() {
        return this.f1895a.getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getMediumScale() {
        return this.f1895a.getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getMinimumScale() {
        return this.f1895a.getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public PhotoViewAttacher.InterfaceC1210f getOnPhotoTapListener() {
        return this.f1895a.getOnPhotoTapListener();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public PhotoViewAttacher.InterfaceC1212h getOnViewTapListener() {
        return this.f1895a.getOnViewTapListener();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getScale() {
        return this.f1895a.getScale();
    }

    @Override // android.widget.ImageView, cn.bluemobi.dylan.photoview.library.IPhotoView
    public ImageView.ScaleType getScaleType() {
        return this.f1895a.getScaleType();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public Bitmap getVisibleRectangleBitmap() {
        return this.f1895a.getVisibleRectangleBitmap();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: h */
    public void mo57544h(float f, float f2, float f3) {
        this.f1895a.mo57544h(f, f2, f3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        m57559c();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.f1895a.m57534r();
        super.onDetachedFromWindow();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f1895a.setAllowParentInterceptOnEdge(z);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f1895a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.f1895a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f1895a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setMaximumScale(float f) {
        this.f1895a.setMaximumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setMediumScale(float f) {
        this.f1895a.setMediumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setMinimumScale(float f) {
        this.f1895a.setMinimumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f1895a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View, cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1895a.setOnLongClickListener(onLongClickListener);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnMatrixChangeListener(PhotoViewAttacher.InterfaceC1209e interfaceC1209e) {
        this.f1895a.setOnMatrixChangeListener(interfaceC1209e);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnPhotoTapListener(PhotoViewAttacher.InterfaceC1210f interfaceC1210f) {
        this.f1895a.setOnPhotoTapListener(interfaceC1210f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnScaleChangeListener(PhotoViewAttacher.InterfaceC1211g interfaceC1211g) {
        this.f1895a.setOnScaleChangeListener(interfaceC1211g);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnViewTapListener(PhotoViewAttacher.InterfaceC1212h interfaceC1212h) {
        this.f1895a.setOnViewTapListener(interfaceC1212h);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setPhotoViewRotation(float f) {
        this.f1895a.setRotationTo(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setRotationBy(float f) {
        this.f1895a.setRotationBy(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setRotationTo(float f) {
        this.f1895a.setRotationTo(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setScale(float f) {
        this.f1895a.setScale(f);
    }

    @Override // android.widget.ImageView, cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f1895a;
        if (photoViewAttacher != null) {
            photoViewAttacher.setScaleType(scaleType);
        } else {
            this.f1896b = scaleType;
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setZoomTransitionDuration(int i) {
        this.f1895a.setZoomTransitionDuration(i);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setZoomable(boolean z) {
        this.f1895a.setZoomable(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        m57559c();
    }
}
