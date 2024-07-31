package cn.bluemobi.dylan.photoview.library;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* renamed from: cn.bluemobi.dylan.photoview.library.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DefaultOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a */
    private PhotoViewAttacher f1898a;

    public DefaultOnDoubleTapListener(PhotoViewAttacher photoViewAttacher) {
        m57553a(photoViewAttacher);
    }

    /* renamed from: a */
    public void m57553a(PhotoViewAttacher photoViewAttacher) {
        this.f1898a = photoViewAttacher;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        PhotoViewAttacher photoViewAttacher = this.f1898a;
        if (photoViewAttacher == null) {
            return false;
        }
        try {
            float scale = photoViewAttacher.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.f1898a.getMediumScale()) {
                PhotoViewAttacher photoViewAttacher2 = this.f1898a;
                photoViewAttacher2.mo57547b(photoViewAttacher2.getMediumScale(), x, y, true);
            } else if (scale >= this.f1898a.getMediumScale() && scale < this.f1898a.getMaximumScale()) {
                PhotoViewAttacher photoViewAttacher3 = this.f1898a;
                photoViewAttacher3.mo57547b(photoViewAttacher3.getMaximumScale(), x, y, true);
            } else {
                PhotoViewAttacher photoViewAttacher4 = this.f1898a;
                photoViewAttacher4.mo57547b(photoViewAttacher4.getMinimumScale(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        PhotoViewAttacher photoViewAttacher = this.f1898a;
        if (photoViewAttacher == null) {
            return false;
        }
        ImageView m57531u = photoViewAttacher.m57531u();
        if (this.f1898a.getOnPhotoTapListener() != null && (displayRect = this.f1898a.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.contains(x, y)) {
                this.f1898a.getOnPhotoTapListener().mo57521a(m57531u, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.f1898a.getOnViewTapListener() != null) {
            this.f1898a.getOnViewTapListener().m57519a(m57531u, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
