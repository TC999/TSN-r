package ulL.WeEFDVoZmmWVmW.yXd;

import java.lang.reflect.Member;
import java.util.HashMap;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.IXUnhook;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class XC_MethodHook extends XCallback {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class MethodHookParam extends XCallback.Param {
        public Object[] args;
        public Member method;
        public Object thisObject;
        public Object result = null;
        public Throwable throwable = null;
        public boolean returnEarly = false;
        private final HashMap extras = new HashMap();

        public Object getResult() {
            return this.result;
        }

        public Object getResultOrThrowable() {
            Throwable th = this.throwable;
            if (th == null) {
                return this.result;
            }
            throw th;
        }

        public Throwable getThrowable() {
            return this.throwable;
        }

        public boolean hasThrowable() {
            return this.throwable != null;
        }

        public void setResult(Object obj) {
            this.result = obj;
            this.throwable = null;
            this.returnEarly = true;
        }

        public void setThrowable(Throwable th) {
            this.throwable = th;
            this.result = null;
            this.returnEarly = true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public class Unhook implements IXUnhook {
        private final Member hookMethod;

        public Unhook(Member member) {
            this.hookMethod = member;
        }

        @Override // ulL.WeEFDVoZmmWVmW.yXd.callbacks.IXUnhook
        public XC_MethodHook getCallback() {
            return XC_MethodHook.this;
        }

        public Member getHookedMethod() {
            return this.hookMethod;
        }

        @Override // ulL.WeEFDVoZmmWVmW.yXd.callbacks.IXUnhook
        public void unhook() {
            XposedBridge.unhookMethod(this.hookMethod, XC_MethodHook.this);
        }
    }

    public XC_MethodHook() {
    }

    public void afterHookedMethod(MethodHookParam methodHookParam) {
    }

    public void beforeHookedMethod(MethodHookParam methodHookParam) {
    }

    public void callAfterHookedMethod(MethodHookParam methodHookParam) {
        afterHookedMethod(methodHookParam);
    }

    public void callBeforeHookedMethod(MethodHookParam methodHookParam) {
        beforeHookedMethod(methodHookParam);
    }

    public XC_MethodHook(int i4) {
        super(i4);
    }
}
