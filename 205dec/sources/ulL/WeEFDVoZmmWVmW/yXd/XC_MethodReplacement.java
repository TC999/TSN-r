package ulL.WeEFDVoZmmWVmW.yXd;

import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class XC_MethodReplacement extends XC_MethodHook {
    public static final XC_MethodReplacement DO_NOTHING = new XC_MethodReplacement(20000) { // from class: ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement.1
        @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement
        public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            return null;
        }
    };

    public XC_MethodReplacement() {
    }

    public static XC_MethodReplacement returnConstant(Object obj) {
        return returnConstant(50, obj);
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        try {
            methodHookParam.setResult(replaceHookedMethod(methodHookParam));
        } catch (Throwable th) {
            XposedBridge.log(th);
            methodHookParam.setThrowable(th);
        }
    }

    public abstract Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam);

    public XC_MethodReplacement(int i4) {
        super(i4);
    }

    public static XC_MethodReplacement returnConstant(int i4, final Object obj) {
        return new XC_MethodReplacement(i4) { // from class: ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement.2
            @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement
            public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
                return obj;
            }
        };
    }
}
