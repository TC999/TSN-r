package android.support.p015v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.p015v4.media.session.MediaSessionCompatApi21;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(23)
/* renamed from: android.support.v4.media.session.MediaSessionCompatApi23 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MediaSessionCompatApi23 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$Callback */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$CallbackProxy */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
