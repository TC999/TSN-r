package OcOsO.RddINbhi.wn.EFApGV.EE.r;

import CyVHHabzCrUqKeyhTwFaxBD.ources;
import android.content.res.Resources;
import dalvik.annotation.optimization.FastNative;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class ResourcesHook {
    public static native ClassLoader buildDummyClassLoader(ClassLoader classLoader, String str, String str2);

    public static native boolean initXResourcesNative();

    public static native boolean makeInheritable(Class cls);

    @FastNative
    public static native void rewriteXmlReferencesNative(long j4, ources ourcesVar, Resources resources);
}
