package defpackage;

import android.content.BroadcastReceiver;
import android.util.AndroidRuntimeException;
import android.webkit.WebViewDelegate;
import android.webkit.WebViewFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* renamed from: C0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C0 extends XC_MethodReplacement {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10a;

    @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodReplacement
    public final Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object[] objArr;
        Method method;
        switch (this.f10a) {
            case 0:
                for (Object obj : methodHookParam.args) {
                    if (obj instanceof BroadcastReceiver.PendingResult) {
                        ((BroadcastReceiver.PendingResult) obj).finish();
                    }
                }
                return null;
            default:
                Object staticObjectField = XposedHelpers.getStaticObjectField(WebViewFactory.class, "sProviderInstance");
                if (staticObjectField == null) {
                    try {
                        method = ((Class) XposedHelpers.callStaticMethod(WebViewFactory.class, "getProviderClass", new Object[0])).getMethod("create", WebViewDelegate.class);
                    } catch (Exception e4) {
                        AbstractC1457e.e("error instantiating provider with static factory method", e4);
                        method = null;
                    }
                    try {
                        Constructor declaredConstructor = WebViewDelegate.class.getDeclaredConstructor(new Class[0]);
                        declaredConstructor.setAccessible(true);
                        if (method != null) {
                            staticObjectField = method.invoke(null, declaredConstructor.newInstance(new Object[0]));
                        }
                        XposedHelpers.setStaticObjectField(WebViewFactory.class, "sProviderInstance", staticObjectField);
                        AbstractC1457e.d("Loaded provider: " + staticObjectField);
                    } catch (Exception e5) {
                        AbstractC1457e.e("error instantiating provider", e5);
                        throw new AndroidRuntimeException(e5);
                    }
                }
                return staticObjectField;
        }
    }
}
