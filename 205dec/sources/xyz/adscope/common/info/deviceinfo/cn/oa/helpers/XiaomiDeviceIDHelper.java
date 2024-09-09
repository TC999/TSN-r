package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.Context;
import java.lang.reflect.Method;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class XiaomiDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64704a;

    /* renamed from: b  reason: collision with root package name */
    public Class f64705b;

    /* renamed from: c  reason: collision with root package name */
    public Object f64706c;

    /* renamed from: d  reason: collision with root package name */
    public Method f64707d;

    public XiaomiDeviceIDHelper(Context context) {
        this.f64704a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f64705b = cls;
            this.f64706c = cls.newInstance();
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
        try {
            this.f64707d = this.f64705b.getMethod("getOAID", Context.class);
        } catch (Exception e5) {
            LogUtil.e(CommonConstants.TAG, "e : " + e5);
        }
    }

    public final String a(Context context, Method method) {
        Object obj = this.f64706c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
            }
        }
        return null;
    }

    public String getOAID() {
        return a(this.f64704a, this.f64707d);
    }
}
