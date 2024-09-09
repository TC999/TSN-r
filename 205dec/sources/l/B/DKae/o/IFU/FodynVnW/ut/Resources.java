package L.B.DKae.o.IFU.FodynVnW.ut;

import CyVHHabzCrUqKeyhTwFaxBD.Forwarder;
import CyVHHabzCrUqKeyhTwFaxBD.ources;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import lqOZNrLir.i.oAmVOoq.C.Helper;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class Resources extends android.content.res.Resources {
    private Resources(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
    }

    public static Resources createInstance(String str, ources ourcesVar) {
        if (str != null) {
            AssetManager assetManager = new AssetManager();
            assetManager.addAssetPath(str);
            Resources resources = ourcesVar != null ? new Resources(assetManager, ourcesVar.getDisplayMetrics(), ourcesVar.getConfiguration()) : new Resources(assetManager, null, null);
            Helper.addActiveResource(str, resources);
            return resources;
        }
        throw new IllegalArgumentException("path must not be null");
    }

    public Forwarder fwd(int i4) {
        return new Forwarder(this, i4);
    }
}
