package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.nativeadunified.k;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f44826a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k.c f44827b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NativeUnifiedADData f44828c;

        a(Method method, k.c cVar, NativeUnifiedADData nativeUnifiedADData) {
            this.f44826a = method;
            this.f44827b = cVar;
            this.f44828c = nativeUnifiedADData;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.f44826a.equals(method)) {
                this.f44827b.a((ADListener) objArr[0]);
                return method.invoke(this.f44828c, this.f44827b);
            }
            return method.invoke(this.f44828c, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BaseNativeUnifiedAd a(String str, Context context, String str2, String str3, String str4) throws Exception {
        return (BaseNativeUnifiedAd) Class.forName(str).asSubclass(BaseNativeUnifiedAd.class).getDeclaredConstructor(Context.class, String.class, String.class, String.class).newInstance(context, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeUnifiedADData a(NativeUnifiedADData nativeUnifiedADData, k.c cVar) {
        if (nativeUnifiedADData instanceof ADEventListener) {
            try {
                return (NativeUnifiedADData) Proxy.newProxyInstance(NativeUnifiedADData.class.getClassLoader(), new Class[]{NativeUnifiedADData.class, ADEventListener.class}, new a(ADEventListener.class.getDeclaredMethod("setAdListener", ADListener.class), cVar, nativeUnifiedADData));
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return nativeUnifiedADData;
            }
        }
        return nativeUnifiedADData;
    }
}
