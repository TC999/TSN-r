package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new C15437a();

    /* renamed from: a */
    final long[][] f44401a;

    /* renamed from: pl.droidsonroids.gif.GifViewSavedState$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15437a implements Parcelable.Creator<GifViewSavedState> {
        C15437a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (C15437a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GifViewSavedState[] newArray(int i) {
            return new GifViewSavedState[i];
        }
    }

    /* synthetic */ GifViewSavedState(Parcel parcel, C15437a c15437a) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2479a(Drawable drawable, int i) {
        long[][] jArr = this.f44401a;
        if (jArr[i] == null || !(drawable instanceof GifDrawable)) {
            return;
        }
        GifDrawable gifDrawable = (GifDrawable) drawable;
        gifDrawable.m2448J(gifDrawable.f44417g.m2533E(jArr[i], gifDrawable.f44416f));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f44401a.length);
        for (long[] jArr : this.f44401a) {
            parcel.writeLongArray(jArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f44401a = new long[drawableArr.length];
        for (int i = 0; i < drawableArr.length; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof GifDrawable) {
                this.f44401a[i] = ((GifDrawable) drawable).f44417g.m2508o();
            } else {
                this.f44401a[i] = null;
            }
        }
    }

    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f44401a = new long[parcel.readInt()];
        int i = 0;
        while (true) {
            long[][] jArr = this.f44401a;
            if (i >= jArr.length) {
                return;
            }
            jArr[i] = parcel.createLongArray();
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f44401a = r2;
        long[][] jArr2 = {jArr};
    }
}
