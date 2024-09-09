package ulL.WeEFDVoZmmWVmW.yXd;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public interface IXposedHookCmdInit extends IXposedMod {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class StartupParam {
        public String modulePath;
        public String startClassName;
    }

    void initCmdApp(StartupParam startupParam);
}
