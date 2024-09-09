package cn.bluemobi.dylan.photoview.library;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DefaultOnDoubleTapListener.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a  reason: collision with root package name */
    private d f1883a;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.f1883a = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar = this.f1883a;
        if (dVar == null) {
            return false;
        }
        try {
            float scale = dVar.getScale();
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (scale < this.f1883a.getMediumScale()) {
                d dVar2 = this.f1883a;
                dVar2.b(dVar2.getMediumScale(), x3, y3, true);
            } else if (scale >= this.f1883a.getMediumScale() && scale < this.f1883a.getMaximumScale()) {
                d dVar3 = this.f1883a;
                dVar3.b(dVar3.getMaximumScale(), x3, y3, true);
            } else {
                d dVar4 = this.f1883a;
                dVar4.b(dVar4.getMinimumScale(), x3, y3, true);
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
        d dVar = this.f1883a;
        if (dVar == null) {
            return false;
        }
        ImageView u3 = dVar.u();
        if (this.f1883a.getOnPhotoTapListener() != null && (displayRect = this.f1883a.getDisplayRect()) != null) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (displayRect.contains(x3, y3)) {
                this.f1883a.getOnPhotoTapListener().a(u3, (x3 - displayRect.left) / displayRect.width(), (y3 - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.f1883a.getOnViewTapListener() != null) {
            this.f1883a.getOnViewTapListener().a(u3, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
