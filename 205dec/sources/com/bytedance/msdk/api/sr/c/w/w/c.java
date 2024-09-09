package com.bytedance.msdk.api.sr.c.w.w;

import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.w.f;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    protected com.bytedance.msdk.api.sr.c.w.xv f27602c = new com.bytedance.msdk.api.sr.c.w.xv();

    public void c(int i4) {
        this.f27602c.setAdType(i4);
    }

    @Nullable
    public f k() {
        return this.f27602c.sr();
    }

    @Nullable
    public com.bytedance.msdk.api.sr.c.w.xv p() {
        return this.f27602c;
    }

    public void w(Map<String, Object> map) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar != null) {
            xvVar.putExtraMsg(map);
        }
    }

    public void c(w wVar) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar != null) {
            xvVar.c(wVar);
        }
    }

    public void c(double d4) {
        this.f27602c.setCpm(d4);
    }

    public void c(Map<String, Object> map) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar;
        if (map == null || (xvVar = this.f27602c) == null) {
            return;
        }
        xvVar.setMediaExtraInfo(map);
    }
}
