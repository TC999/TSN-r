package xyz.adscope.amps.tool;

import java.lang.reflect.Constructor;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSAdapterFactory {
    protected static AMPSAdapterFactory instance = new AMPSAdapterFactory();

    public static AMPSBaseAdapter createAdapterClass(String str) {
        if (str != null) {
            try {
                return instance.internalCreateClass(Class.forName(str).asSubclass(AMPSBaseAdapter.class));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static AMPSChannelInitMediation createAdapterInit(String str) {
        if (str != null) {
            try {
                return instance.internalCreateInit(Class.forName(str).asSubclass(AMPSChannelInitMediation.class));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    protected AMPSBaseAdapter internalCreateClass(Class<? extends AMPSBaseAdapter> cls) throws Exception {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<? extends AMPSBaseAdapter> declaredConstructor = cls.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    protected AMPSChannelInitMediation internalCreateInit(Class<? extends AMPSChannelInitMediation> cls) throws Exception {
        if (cls == null) {
            return null;
        }
        try {
            return (AMPSChannelInitMediation) cls.getMethod("getInstance", new Class[0]).invoke(new Class[0], new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
