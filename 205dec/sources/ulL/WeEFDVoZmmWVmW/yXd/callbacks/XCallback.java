package ulL.WeEFDVoZmmWVmW.yXd.callbacks;

import android.os.Bundle;
import java.io.Serializable;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class XCallback {
    public static final int PRIORITY_DEFAULT = 50;
    public static final int PRIORITY_HIGHEST = 10000;
    public static final int PRIORITY_LOWEST = -10000;
    public final int priority;

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public abstract class Param {
        public final XCallback[] callbacks;
        private Bundle extra;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\155424.dex */
        public class SerializeWrapper implements Serializable {
            private static final long serialVersionUID = 1;
            private final Object object;

            public SerializeWrapper(Object obj) {
                this.object = obj;
            }
        }

        @Deprecated
        public Param() {
            this.callbacks = null;
        }

        public synchronized Bundle getExtra() {
            try {
                if (this.extra == null) {
                    this.extra = new Bundle();
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.extra;
        }

        public Object getObjectExtra(String str) {
            Serializable serializable = getExtra().getSerializable(str);
            if (serializable instanceof SerializeWrapper) {
                return ((SerializeWrapper) serializable).object;
            }
            return null;
        }

        public void setObjectExtra(String str, Object obj) {
            getExtra().putSerializable(str, new SerializeWrapper(obj));
        }

        public Param(XCallback[] xCallbackArr) {
            this.callbacks = xCallbackArr;
        }
    }

    @Deprecated
    public XCallback() {
        this.priority = 50;
    }

    public static void callAll(Param param) {
        if (param instanceof XC_LoadPackage.LoadPackageParam) {
            XC_LoadPackage.LoadPackageParam loadPackageParam = (XC_LoadPackage.LoadPackageParam) param;
            AbstractC1457e.a(loadPackageParam.packageName, loadPackageParam.classLoader);
        }
        if (param.callbacks == null) {
            throw new IllegalStateException("This object was not created for use with callAll");
        }
        int i4 = 0;
        while (true) {
            XCallback[] xCallbackArr = param.callbacks;
            if (i4 >= xCallbackArr.length) {
                return;
            }
            try {
                xCallbackArr[i4].call(param);
            } catch (Throwable th) {
                XposedBridge.log(th);
            }
            i4++;
        }
    }

    public void call(Param param) {
    }

    public XCallback(int i4) {
        this.priority = i4;
    }
}
