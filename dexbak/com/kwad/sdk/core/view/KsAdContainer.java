package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.C11008ac;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsAdContainer extends RelativeLayout {
    protected C11008ac.C11009a aCH;

    public KsAdContainer(Context context) {
        super(context);
        this.aCH = new C11008ac.C11009a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            C11008ac.C11009a c11009a = new C11008ac.C11009a(getWidth(), getHeight());
            this.aCH = c11009a;
            c11009a.m24148f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aCH.m24147g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public C11008ac.C11009a getTouchCoords() {
        return this.aCH;
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCH = new C11008ac.C11009a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCH = new C11008ac.C11009a();
    }
}
