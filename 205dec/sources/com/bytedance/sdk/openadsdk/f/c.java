package com.bytedance.sdk.openadsdk.f;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.a;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements xv {

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<Method> f35857c = new SparseArray<>();

    /* renamed from: w  reason: collision with root package name */
    private Object f35858w;

    public abstract String c();

    @Override // com.bytedance.sdk.openadsdk.f.xv
    public void c(int i4, Method method) {
        this.f35857c.put(i4, method);
    }

    @Override // com.bytedance.sdk.openadsdk.f.xv
    public <T> T call(int i4, Object... objArr) {
        Object obj;
        Method method = this.f35857c.get(i4);
        if (method != null && (obj = this.f35858w) != null) {
            try {
                if (obj instanceof Class) {
                    return (T) method.invoke(null, objArr);
                }
                return (T) method.invoke(obj, objArr);
            } catch (Throwable th) {
                String c4 = c();
                a.sr(c4, "call method " + i4 + " failed: " + th.getMessage());
                return null;
            }
        }
        String c5 = c();
        a.sr(c5, "call method " + i4 + " failed for null ");
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.f.xv
    public void c(Object obj) {
        this.f35858w = obj;
    }
}
