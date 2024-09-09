package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f41593a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f41594b;

    public ADEvent(int i4, Object... objArr) {
        this.f41593a = i4;
        this.f41594b = objArr;
        if (i4 < 100) {
            a("EventId \u9519\u8bef" + i4);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(int i4, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f41594b) == null || objArr.length <= i4) {
            return null;
        }
        T t3 = (T) objArr[i4];
        if (t3 == null) {
            GDTLogger.e("ADEvent \u53c2\u6570\u4e3a\u7a7a,type:" + this.f41593a);
            return null;
        } else if (cls.isInstance(objArr[i4])) {
            return t3;
        } else {
            GDTLogger.e("ADEvent" + this.f41593a + " \u53c2\u6570\u7c7b\u578b\u9519\u8bef,\u671f\u671b\u7c7b\u578b" + cls.getName() + "\u5b9e\u9645\u7c7b\u578b " + t3.getClass().getName());
            return null;
        }
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.f41593a;
    }
}
