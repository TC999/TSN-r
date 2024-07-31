package cn.bluemobi.dylan.photoview.library;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.photoview.library.PhotoViewAttacher;

/* renamed from: cn.bluemobi.dylan.photoview.library.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface IPhotoView {

    /* renamed from: a0 */
    public static final float f1899a0 = 3.0f;

    /* renamed from: b0 */
    public static final float f1900b0 = 1.75f;

    /* renamed from: c0 */
    public static final float f1901c0 = 1.0f;

    /* renamed from: d0 */
    public static final int f1902d0 = 200;

    /* renamed from: a */
    boolean mo57548a();

    /* renamed from: b */
    void mo57547b(float f, float f2, float f3, boolean z);

    /* renamed from: d */
    void mo57546d(float f, boolean z);

    /* renamed from: f */
    boolean mo57545f(Matrix matrix);

    Matrix getDisplayMatrix();

    RectF getDisplayRect();

    IPhotoView getIPhotoViewImplementation();

    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getMediumScale();

    @Deprecated
    float getMidScale();

    @Deprecated
    float getMinScale();

    float getMinimumScale();

    PhotoViewAttacher.InterfaceC1210f getOnPhotoTapListener();

    PhotoViewAttacher.InterfaceC1212h getOnViewTapListener();

    float getScale();

    ImageView.ScaleType getScaleType();

    Bitmap getVisibleRectangleBitmap();

    /* renamed from: h */
    void mo57544h(float f, float f2, float f3);

    void setAllowParentInterceptOnEdge(boolean z);

    @Deprecated
    void setMaxScale(float f);

    void setMaximumScale(float f);

    void setMediumScale(float f);

    @Deprecated
    void setMidScale(float f);

    @Deprecated
    void setMinScale(float f);

    void setMinimumScale(float f);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(PhotoViewAttacher.InterfaceC1209e interfaceC1209e);

    void setOnPhotoTapListener(PhotoViewAttacher.InterfaceC1210f interfaceC1210f);

    void setOnScaleChangeListener(PhotoViewAttacher.InterfaceC1211g interfaceC1211g);

    void setOnViewTapListener(PhotoViewAttacher.InterfaceC1212h interfaceC1212h);

    void setPhotoViewRotation(float f);

    void setRotationBy(float f);

    void setRotationTo(float f);

    void setScale(float f);

    void setScaleType(ImageView.ScaleType scaleType);

    void setZoomTransitionDuration(int i);

    void setZoomable(boolean z);
}
