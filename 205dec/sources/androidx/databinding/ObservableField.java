package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ObservableField<T> extends BaseObservableField implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t3) {
        this.mValue = t3;
    }

    @Nullable
    public T get() {
        return this.mValue;
    }

    public void set(T t3) {
        if (t3 != this.mValue) {
            this.mValue = t3;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(Observable... observableArr) {
        super(observableArr);
    }
}
