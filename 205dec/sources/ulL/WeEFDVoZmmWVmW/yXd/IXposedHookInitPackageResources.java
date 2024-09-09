package ulL.WeEFDVoZmmWVmW.yXd;

import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_InitPackageResources;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public interface IXposedHookInitPackageResources extends IXposedMod {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class Wrapper extends XC_InitPackageResources {
        private final IXposedHookInitPackageResources instance;

        public Wrapper(IXposedHookInitPackageResources iXposedHookInitPackageResources) {
            this.instance = iXposedHookInitPackageResources;
        }

        @Override // ulL.WeEFDVoZmmWVmW.yXd.IXposedHookInitPackageResources
        public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam) {
            this.instance.handleInitPackageResources(initPackageResourcesParam);
        }
    }

    void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam);
}
