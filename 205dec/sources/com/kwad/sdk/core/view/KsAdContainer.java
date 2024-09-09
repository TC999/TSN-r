package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.ac;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsAdContainer extends RelativeLayout {
    protected ac.a aCH;

    public KsAdContainer(Context context) {
        super(context);
        this.aCH = new ac.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            ac.a aVar = new ac.a(getWidth(), getHeight());
            this.aCH = aVar;
            aVar.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aCH.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public ac.a getTouchCoords() {
        return this.aCH;
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCH = new ac.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.aCH = new ac.a();
    }
}
