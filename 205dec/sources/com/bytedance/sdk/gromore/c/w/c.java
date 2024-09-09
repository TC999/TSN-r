package com.bytedance.sdk.gromore.c.w;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f31243c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ys.w.xv.c f31244w;
    private com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c xv;

    private c(ValueSet valueSet) {
        this.f31243c = valueSet;
        if (valueSet != null) {
            com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = new com.bytedance.sdk.openadsdk.ys.w.xv.c(valueSet);
            this.f31244w = cVar;
            this.xv = cVar.ys();
        }
    }

    public static c c(ValueSet valueSet) {
        return new c(valueSet);
    }

    public boolean a() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.k();
        }
        return false;
    }

    public Bridge ba() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null && cVar.sr() != null) {
            Object obj = this.xv.sr().get("qa_preview_tool");
            if (obj instanceof Bridge) {
                return (Bridge) obj;
            }
        }
        return null;
    }

    public int[] bk() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.gd();
        }
        return null;
    }

    public Bridge ck() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null && cVar.sr() != null) {
            Object obj = this.xv.sr().get("qa_event_tool");
            if (obj instanceof Bridge) {
                return (Bridge) obj;
            }
        }
        return null;
    }

    public String ev() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.sr();
        }
        return null;
    }

    public String f() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.w();
        }
        return null;
    }

    public boolean fp() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.w();
        }
        return false;
    }

    public boolean fz() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.ux();
        }
        return false;
    }

    public Bridge gb() {
        return (Bridge) this.f31243c.objectValue(8318, Bridge.class);
    }

    public String gd() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.ux();
        }
        return null;
    }

    public String i() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        return cVar != null ? cVar.r() : "";
    }

    public xv ia() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.xv();
        }
        return null;
    }

    public boolean j() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.gd();
        }
        return false;
    }

    public boolean k() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.r();
        }
        return false;
    }

    public boolean ls() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.p();
        }
        return false;
    }

    public Bridge n() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null && cVar.sr() != null) {
            Object obj = this.xv.sr().get("qa_config_tool");
            if (obj instanceof Bridge) {
                return (Bridge) obj;
            }
        }
        return null;
    }

    public int p() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.f();
        }
        return 0;
    }

    public boolean q() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.ev();
        }
        return false;
    }

    public boolean r() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.xv();
        }
        return false;
    }

    public Map<String, Object> s() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.sr();
        }
        return null;
    }

    public boolean sr() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.ev();
        }
        return false;
    }

    public boolean t() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.p();
        }
        return false;
    }

    public JSONObject u() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    public String ux() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public ValueSet w() {
        return this.f31243c;
    }

    public EventListener xv() {
        ValueSet valueSet = this.f31243c;
        if (valueSet != null) {
            return (EventListener) valueSet.objectValue(15, EventListener.class);
        }
        return null;
    }

    public String ys() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public Bridge z() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar = this.xv;
        if (cVar != null && cVar.sr() != null) {
            Object obj = this.xv.sr().get("qa_onetap_tool");
            if (obj instanceof Bridge) {
                return (Bridge) obj;
            }
        }
        return null;
    }

    public boolean c() {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = this.f31244w;
        if (cVar != null) {
            return cVar.fp();
        }
        return false;
    }
}
