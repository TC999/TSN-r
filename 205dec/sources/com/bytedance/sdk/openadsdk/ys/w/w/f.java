package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36489c;

    /* renamed from: w  reason: collision with root package name */
    private Bridge f36490w;

    public f(Bridge bridge) {
        Bridge bridge2 = b.f24741d;
        this.f36490w = bridge2;
        this.f36490w = bridge == null ? bridge2 : bridge;
    }

    private ValueSet r() {
        return b.a().l();
    }

    public String c() {
        return (String) this.f36490w.call(241103, b.b(0).l(), String.class);
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 241101:
                c(new f((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 241102:
                c(valueSet.booleanValue(0));
                break;
            case 241103:
                return (T) c();
            case 241104:
                return (T) w();
            case 241105:
                return (T) Boolean.class.cast(Boolean.valueOf(xv()));
            case 241106:
                return (T) Boolean.class.cast(Boolean.valueOf(f()));
            case 241107:
                return (T) Boolean.class.cast(Boolean.valueOf(ux()));
            case 241108:
                return (T) sr();
        }
        c(i4, valueSet, cls);
        return null;
    }

    public boolean f() {
        return ((Boolean) this.f36490w.call(241106, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public List<f> sr() {
        List<Bridge> list = (List) this.f36490w.call(241108, b.b(0).l(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new f(bridge));
        }
        return arrayList;
    }

    public boolean ux() {
        return ((Boolean) this.f36490w.call(241107, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36489c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet r3 = r();
        this.f36489c = r3;
        return r3;
    }

    public String w() {
        return (String) this.f36490w.call(241104, b.b(0).l(), String.class);
    }

    public boolean xv() {
        return ((Boolean) this.f36490w.call(241105, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    public void c(f fVar) {
        b b4 = b.b(1);
        b4.h(0, fVar);
        this.f36490w.call(241101, b4.l(), Void.class);
    }

    public void c(boolean z3) {
        b b4 = b.b(1);
        b4.j(0, z3);
        this.f36490w.call(241102, b4.l(), Void.class);
    }
}
