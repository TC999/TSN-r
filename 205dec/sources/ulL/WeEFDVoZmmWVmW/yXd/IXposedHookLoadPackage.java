package ulL.WeEFDVoZmmWVmW.yXd;

import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public interface IXposedHookLoadPackage extends IXposedMod {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class Wrapper extends XC_LoadPackage {
        private final IXposedHookLoadPackage instance;

        public Wrapper(IXposedHookLoadPackage iXposedHookLoadPackage) {
            this.instance = iXposedHookLoadPackage;
        }

        @Override // ulL.WeEFDVoZmmWVmW.yXd.IXposedHookLoadPackage
        public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
            this.instance.handleLoadPackage(loadPackageParam);
        }
    }

    void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam);
}
