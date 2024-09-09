package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: PersistableBundle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle persistableBundleOf(@NotNull Pair<String, ? extends Object>... pairs) {
        f0.q(pairs, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(pairs.length);
        for (Pair<String, ? extends Object> pair : pairs) {
            String component1 = pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                persistableBundle.putString(component1, null);
            } else if (component2 instanceof Boolean) {
                if (Build.VERSION.SDK_INT >= 22) {
                    persistableBundle.putBoolean(component1, ((Boolean) component2).booleanValue());
                } else {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + component1 + '\"');
                }
            } else if (component2 instanceof Double) {
                persistableBundle.putDouble(component1, ((Number) component2).doubleValue());
            } else if (component2 instanceof Integer) {
                persistableBundle.putInt(component1, ((Number) component2).intValue());
            } else if (component2 instanceof Long) {
                persistableBundle.putLong(component1, ((Number) component2).longValue());
            } else if (component2 instanceof String) {
                persistableBundle.putString(component1, (String) component2);
            } else if (component2 instanceof boolean[]) {
                if (Build.VERSION.SDK_INT >= 22) {
                    persistableBundle.putBooleanArray(component1, (boolean[]) component2);
                } else {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + component1 + '\"');
                }
            } else if (component2 instanceof double[]) {
                persistableBundle.putDoubleArray(component1, (double[]) component2);
            } else if (component2 instanceof int[]) {
                persistableBundle.putIntArray(component1, (int[]) component2);
            } else if (component2 instanceof long[]) {
                persistableBundle.putLongArray(component1, (long[]) component2);
            } else if (component2 instanceof Object[]) {
                Class<?> componentType = component2.getClass().getComponentType();
                if (componentType == null) {
                    f0.L();
                }
                f0.h(componentType, "value::class.java.componentType!!");
                if (String.class.isAssignableFrom(componentType)) {
                    persistableBundle.putStringArray(component1, (String[]) component2);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + component1 + '\"');
                }
            } else {
                throw new IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + component1 + '\"');
            }
        }
        return persistableBundle;
    }
}
