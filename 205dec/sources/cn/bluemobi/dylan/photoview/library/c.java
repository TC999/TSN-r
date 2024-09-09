package cn.bluemobi.dylan.photoview.library;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.photoview.library.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: IPhotoView.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface c {

    /* renamed from: a0  reason: collision with root package name */
    public static final float f1884a0 = 3.0f;

    /* renamed from: b0  reason: collision with root package name */
    public static final float f1885b0 = 1.75f;

    /* renamed from: c0  reason: collision with root package name */
    public static final float f1886c0 = 1.0f;

    /* renamed from: d0  reason: collision with root package name */
    public static final int f1887d0 = 200;

    boolean a();

    void b(float f4, float f5, float f6, boolean z3);

    void d(float f4, boolean z3);

    boolean f(Matrix matrix);

    Matrix getDisplayMatrix();

    RectF getDisplayRect();

    c getIPhotoViewImplementation();

    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getMediumScale();

    @Deprecated
    float getMidScale();

    @Deprecated
    float getMinScale();

    float getMinimumScale();

    d.f getOnPhotoTapListener();

    d.h getOnViewTapListener();

    float getScale();

    ImageView.ScaleType getScaleType();

    Bitmap getVisibleRectangleBitmap();

    void h(float f4, float f5, float f6);

    void setAllowParentInterceptOnEdge(boolean z3);

    @Deprecated
    void setMaxScale(float f4);

    void setMaximumScale(float f4);

    void setMediumScale(float f4);

    @Deprecated
    void setMidScale(float f4);

    @Deprecated
    void setMinScale(float f4);

    void setMinimumScale(float f4);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(d.e eVar);

    void setOnPhotoTapListener(d.f fVar);

    void setOnScaleChangeListener(d.g gVar);

    void setOnViewTapListener(d.h hVar);

    void setPhotoViewRotation(float f4);

    void setRotationBy(float f4);

    void setRotationTo(float f4);

    void setScale(float f4);

    void setScaleType(ImageView.ScaleType scaleType);

    void setZoomTransitionDuration(int i4);

    void setZoomable(boolean z3);
}
