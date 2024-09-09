package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RequiresApi(21)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class VolumeProviderCompatApi21 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface Delegate {
        void onAdjustVolume(int i4);

        void onSetVolumeTo(int i4);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i4, int i5, int i6, final Delegate delegate) {
        return new VolumeProvider(i4, i5, i6) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i7) {
                delegate.onAdjustVolume(i7);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i7) {
                delegate.onSetVolumeTo(i7);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i4) {
        ((VolumeProvider) obj).setCurrentVolume(i4);
    }
}
