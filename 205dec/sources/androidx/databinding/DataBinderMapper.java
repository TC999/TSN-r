package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class DataBinderMapper {
    @NonNull
    public List<DataBinderMapper> collectDependencies() {
        return Collections.emptyList();
    }

    public abstract String convertBrIdToString(int i4);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i4);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i4);

    public abstract int getLayoutId(String str);
}
