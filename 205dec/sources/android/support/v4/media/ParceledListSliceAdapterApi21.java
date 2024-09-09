package android.support.v4.media;

import android.media.browse.MediaBrowser;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RequiresApi(21)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    static {
        try {
            sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            e4.printStackTrace();
        }
    }

    private ParceledListSliceAdapterApi21() {
    }

    static Object newInstance(List<MediaBrowser.MediaItem> list) {
        try {
            return sConstructor.newInstance(list);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
