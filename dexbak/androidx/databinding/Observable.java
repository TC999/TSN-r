package androidx.databinding;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface Observable {

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable sender, int propertyId);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback callback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback);
}
