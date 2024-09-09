package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final long[][] f61814a;

    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements Parcelable.Creator<GifViewSavedState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GifViewSavedState[] newArray(int i4) {
            return new GifViewSavedState[i4];
        }
    }

    /* synthetic */ GifViewSavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable, int i4) {
        long[][] jArr = this.f61814a;
        if (jArr[i4] == null || !(drawable instanceof e)) {
            return;
        }
        e eVar = (e) drawable;
        eVar.J(eVar.f61830g.E(jArr[i4], eVar.f61829f));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f61814a.length);
        for (long[] jArr : this.f61814a) {
            parcel.writeLongArray(jArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f61814a = new long[drawableArr.length];
        for (int i4 = 0; i4 < drawableArr.length; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable instanceof e) {
                this.f61814a[i4] = ((e) drawable).f61830g.o();
            } else {
                this.f61814a[i4] = null;
            }
        }
    }

    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f61814a = new long[parcel.readInt()];
        int i4 = 0;
        while (true) {
            long[][] jArr = this.f61814a;
            if (i4 >= jArr.length) {
                return;
            }
            jArr[i4] = parcel.createLongArray();
            i4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f61814a = r2;
        long[][] jArr2 = {jArr};
    }
}
