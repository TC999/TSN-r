package androidx.databinding;

import androidx.databinding.ViewDataBinding;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public void onBound(T t) {
    }

    public void onCanceled(T t) {
    }

    public boolean onPreBind(T t) {
        return true;
    }
}
