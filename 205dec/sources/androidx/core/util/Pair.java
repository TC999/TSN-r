package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Pair<F, S> {
    @Nullable
    public final F first;
    @Nullable
    public final S second;

    public Pair(@Nullable F f4, @Nullable S s3) {
        this.first = f4;
        this.second = s3;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(@Nullable A a4, @Nullable B b4) {
        return new Pair<>(a4, b4);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
        }
        return false;
    }

    public int hashCode() {
        F f4 = this.first;
        int hashCode = f4 == null ? 0 : f4.hashCode();
        S s3 = this.second;
        return hashCode ^ (s3 != null ? s3.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }
}
