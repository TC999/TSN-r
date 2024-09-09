package com.bytedance.msdk.adapter.xv.c.xv;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.msdk.adapter.xv.c.c {
    private com.bytedance.msdk.api.sr.c.w.sr.w xv;

    public xv(String str, com.bytedance.msdk.api.sr.c.w.w.w wVar) {
        super(str, wVar);
        com.bytedance.msdk.api.sr.c.w.w.w wVar2 = this.f27249w;
        if (wVar2 instanceof com.bytedance.msdk.api.sr.c.w.sr.w) {
            this.xv = (com.bytedance.msdk.api.sr.c.w.sr.w) wVar2;
        }
    }

    public void c(int i4, String str) {
        com.bytedance.msdk.api.sr.c.w.sr.w wVar = this.xv;
        if (wVar != null) {
            wVar.c(new com.bytedance.msdk.api.sr.c.w.c(i4, str));
        }
    }

    public boolean ev() {
        com.bytedance.msdk.api.sr.c.w.sr.w wVar = this.xv;
        if (wVar != null) {
            return wVar.f();
        }
        return false;
    }

    public boolean gd() {
        com.bytedance.msdk.api.sr.c.w.sr.w wVar = this.xv;
        if (wVar != null) {
            return wVar.ux();
        }
        return false;
    }

    public void c(List<Bridge> list) {
        if (this.xv != null) {
            ArrayList arrayList = new ArrayList();
            for (Bridge bridge : list) {
                arrayList.add(new c(this.f27249w, bridge));
            }
            this.xv.c(arrayList);
        }
    }

    @Override // com.bytedance.msdk.adapter.xv.c.c
    public <T> T c(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8222) {
            return (T) Boolean.valueOf(ev());
        }
        if (i4 == 8223) {
            return (T) Boolean.valueOf(gd());
        }
        if (i4 == 8123) {
            c(valueSet.intValue(8014), valueSet.stringValue(8015));
            return null;
        } else if (i4 == 8107) {
            c((List) valueSet.objectValue(8303, List.class));
            return null;
        } else {
            return null;
        }
    }
}
