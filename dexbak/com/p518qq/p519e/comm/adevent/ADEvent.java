package com.p518qq.p519e.comm.adevent;

import com.p518qq.p519e.comm.util.GDTLogger;

/* renamed from: com.qq.e.comm.adevent.ADEvent */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ADEvent {

    /* renamed from: a */
    private final int f32878a;

    /* renamed from: b */
    private final Object[] f32879b;

    public ADEvent(int i, Object... objArr) {
        this.f32878a = i;
        this.f32879b = objArr;
        if (i < 100) {
            m20355a("EventId 错误" + i);
        }
    }

    /* renamed from: a */
    private void m20355a(String str) {
        GDTLogger.m20307e(str);
    }

    public <T> T getParam(int i, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f32879b) == null || objArr.length <= i) {
            return null;
        }
        T t = (T) objArr[i];
        if (t == null) {
            GDTLogger.m20307e("ADEvent 参数为空,type:" + this.f32878a);
            return null;
        } else if (cls.isInstance(objArr[i])) {
            return t;
        } else {
            GDTLogger.m20307e("ADEvent" + this.f32878a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName());
            return null;
        }
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.f32878a;
    }
}
