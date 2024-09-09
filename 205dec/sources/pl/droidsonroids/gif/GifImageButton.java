package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;
import pl.droidsonroids.gif.k;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class GifImageButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private boolean f61795a;

    public GifImageButton(Context context) {
        super(context);
    }

    private void a(k.a aVar) {
        this.f61795a = aVar.f61861a;
        int i4 = aVar.f61859c;
        if (i4 > 0) {
            super.setImageResource(i4);
        }
        int i5 = aVar.f61860d;
        if (i5 > 0) {
            super.setBackgroundResource(i5);
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
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.f61795a ? getDrawable() : null, this.f61795a ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        if (k.e(this, false, i4)) {
            return;
        }
        super.setBackgroundResource(i4);
    }

    public void setFreezesAnimation(boolean z3) {
        this.f61795a = z3;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i4) {
        if (k.e(this, true, i4)) {
            return;
        }
        super.setImageResource(i4);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (k.d(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(k.c(this, attributeSet, 0, 0));
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a(k.c(this, attributeSet, i4, 0));
    }

    @RequiresApi(21)
    public GifImageButton(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        a(k.c(this, attributeSet, i4, i5));
    }
}
