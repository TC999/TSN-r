package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import pl.droidsonroids.gif.GifViewUtils;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GifImageButton extends ImageButton {

    /* renamed from: a */
    private boolean f44382a;

    public GifImageButton(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m2539a(GifViewUtils.C15446a c15446a) {
        this.f44382a = c15446a.f44448a;
        int i = c15446a.f44446c;
        if (i > 0) {
            super.setImageResource(i);
        }
        int i2 = c15446a.f44447d;
        if (i2 > 0) {
            super.setBackgroundResource(i2);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.m2479a(getDrawable(), 0);
        gifViewSavedState.m2479a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.f44382a ? getDrawable() : null, this.f44382a ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (GifViewUtils.m2372e(this, false, i)) {
            return;
        }
        super.setBackgroundResource(i);
    }

    public void setFreezesAnimation(boolean z) {
        this.f44382a = z;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (GifViewUtils.m2372e(this, true, i)) {
            return;
        }
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (GifViewUtils.m2373d(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2539a(GifViewUtils.m2374c(this, attributeSet, 0, 0));
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2539a(GifViewUtils.m2374c(this, attributeSet, i, 0));
    }

    @RequiresApi(21)
    public GifImageButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m2539a(GifViewUtils.m2374c(this, attributeSet, i, i2));
    }
}
