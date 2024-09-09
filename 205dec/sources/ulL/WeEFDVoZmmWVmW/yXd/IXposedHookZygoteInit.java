package ulL.WeEFDVoZmmWVmW.yXd;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public interface IXposedHookZygoteInit extends IXposedMod {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class StartupParam {
        public String modulePath;
        public boolean startsSystemServer;
    }

    void initZygote(StartupParam startupParam);
}
