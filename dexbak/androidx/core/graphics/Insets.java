package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Insets {
    @NonNull
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;

    /* renamed from: top  reason: collision with root package name */
    public final int f47161top;

    private Insets(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f47161top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    @NonNull
    /* renamed from: of */
    public static Insets m60031of(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return NONE;
        }
        return new Insets(i, i2, i3, i4);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static Insets toCompatInsets(@NonNull android.graphics.Insets insets) {
        return m60031of(insets.left, insets.top, insets.right, insets.bottom);
    }

    @NonNull
    @Deprecated
    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Insets wrap(@NonNull android.graphics.Insets insets) {
        return toCompatInsets(insets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.f47161top == insets.f47161top;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.f47161top) * 31) + this.right) * 31) + this.bottom;
    }

    @NonNull
    @RequiresApi(api = 29)
    public android.graphics.Insets toPlatformInsets() {
        return android.graphics.Insets.of(this.left, this.f47161top, this.right, this.bottom);
    }

    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.f47161top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    @NonNull
    /* renamed from: of */
    public static Insets m60030of(@NonNull Rect rect) {
        return m60031of(rect.left, rect.top, rect.right, rect.bottom);
    }
}
