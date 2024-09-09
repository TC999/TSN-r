package ulL.WeEFDVoZmmWVmW.yXd.callbacks;

import CyVHHabzCrUqKeyhTwFaxBD.ources;
import java.util.concurrent.CopyOnWriteArraySet;
import ulL.WeEFDVoZmmWVmW.yXd.IXposedHookInitPackageResources;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class XC_InitPackageResources extends XCallback implements IXposedHookInitPackageResources {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class InitPackageResourcesParam extends XCallback.Param {
        public String packageName;
        public ources res;

        public InitPackageResourcesParam(CopyOnWriteArraySet copyOnWriteArraySet) {
            super((XCallback[]) copyOnWriteArraySet.toArray(new XCallback[0]));
        }
    }

    public XC_InitPackageResources() {
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback
    public void call(XCallback.Param param) {
        if (param instanceof InitPackageResourcesParam) {
            handleInitPackageResources((InitPackageResourcesParam) param);
        }
    }

    public XC_InitPackageResources(int i4) {
        super(i4);
    }
}
