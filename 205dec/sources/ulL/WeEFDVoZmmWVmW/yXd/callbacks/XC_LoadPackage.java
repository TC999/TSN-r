package ulL.WeEFDVoZmmWVmW.yXd.callbacks;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.CopyOnWriteArraySet;
import ulL.WeEFDVoZmmWVmW.yXd.IXposedHookLoadPackage;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class XC_LoadPackage extends XCallback implements IXposedHookLoadPackage {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class LoadPackageParam extends XCallback.Param {
        public ApplicationInfo appInfo;
        public ClassLoader classLoader;
        public boolean isFirstApplication;
        public String packageName;
        public String processName;

        public LoadPackageParam(CopyOnWriteArraySet copyOnWriteArraySet) {
            super((XCallback[]) copyOnWriteArraySet.toArray(new XCallback[0]));
        }
    }

    public XC_LoadPackage() {
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback
    public void call(XCallback.Param param) {
        if (param instanceof LoadPackageParam) {
            handleLoadPackage((LoadPackageParam) param);
        }
    }

    public XC_LoadPackage(int i4) {
        super(i4);
    }
}
