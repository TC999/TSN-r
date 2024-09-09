package com.bytedance.sdk.openadsdk.mediation.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.lang.reflect.Field;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c extends com.bytedance.sdk.openadsdk.ys.w.xv.w {

    /* renamed from: w  reason: collision with root package name */
    private final ValueSet f36122w;

    public c(ValueSet valueSet) {
        super(valueSet);
        this.f36122w = valueSet == null ? b.f24740c : valueSet;
    }

    private static Bridge c(ValueSet valueSet) {
        if (valueSet != null) {
            Bridge bridge = (Bridge) valueSet.objectValue(8260028, Bridge.class);
            if (bridge == null) {
                try {
                    return (Bridge) valueSet.objectValue(260026, Bridge.class);
                } catch (Throwable unused) {
                    return bridge;
                }
            }
            return bridge;
        }
        return null;
    }

    public ValueSet w() {
        return this.f36122w;
    }

    public w c() {
        Bridge c4 = c(this.f36122w);
        if (c4 != null) {
            return new w(c4);
        }
        return null;
    }

    public static final ValueSet c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        Field[] declaredFields;
        b a4 = b.a();
        if (wVar == null) {
            return a4.l();
        }
        a4.i(260001, wVar.xv());
        a4.i(260002, wVar.sr());
        a4.i(260003, wVar.ux());
        a4.i(260004, wVar.f());
        a4.j(260005, wVar.r());
        a4.e(260006, wVar.ev());
        a4.e(260007, wVar.gd());
        a4.e(7, wVar.ev());
        a4.e(8, wVar.gd());
        a4.d(260008, wVar.p());
        a4.d(260009, wVar.k());
        a4.d(10, wVar.p());
        a4.d(9, wVar.k());
        a4.j(260010, wVar.a());
        a4.j(260011, wVar.bk());
        a4.e(2600012, wVar.t());
        a4.i(260013, wVar.ys());
        a4.i(260014, wVar.fp());
        a4.e(260015, wVar.ia());
        a4.e(260016, wVar.s());
        a4.h(260017, wVar.fz());
        a4.e(260018, wVar.u());
        a4.i(260019, wVar.i());
        a4.e(260020, wVar.q());
        a4.i(260021, wVar.j());
        a4.i(260022, wVar.ls());
        a4.h(260023, wVar.gb());
        ValueSet valueSet = null;
        try {
            for (Field field : wVar.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(wVar) instanceof ValueSet) {
                    valueSet = (ValueSet) field.get(wVar);
                }
                field.setAccessible(false);
            }
        } catch (Exception unused) {
        }
        if (valueSet != null) {
            a4.h(8260028, c(valueSet));
            a4.h(260027, valueSet.objectValue(260027, IMediationAdSlot.class));
        }
        a4.i(260024, wVar.n());
        a4.e(260025, wVar.ck());
        a4.d(260008, wVar.p());
        return a4.l();
    }

    public static ValueSet c(ValueSet valueSet, String str) {
        b k4 = b.k(valueSet);
        k4.i(260022, str);
        return k4.l();
    }
}
