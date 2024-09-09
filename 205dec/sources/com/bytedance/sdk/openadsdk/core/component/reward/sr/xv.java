package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.xv;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.pr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.core.component.reward.sr.c {
    private int bw;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.sr gw;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicBoolean f32541m;
    private int pr;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.draw.w> wv;
    private int wx;

    /* renamed from: x  reason: collision with root package name */
    private final AtomicBoolean f32542x;
    private int xk;
    private int yu;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(int i4);

        void sr();

        void w();

        Map<String, Object> xv();
    }

    public xv(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
        this.wv = new ArrayList();
        this.xk = 0;
        this.yu = 0;
        this.wx = 0;
        this.pr = 0;
        this.bw = 0;
        this.f32542x = new AtomicBoolean(false);
        this.f32541m = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm() {
        com.bykv.vk.openvk.component.video.api.xv.sr srVar;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar2 = this.gw;
        me meVar = null;
        com.bykv.vk.openvk.component.video.api.sr.xv yu = srVar2 != null ? srVar2.yu() : null;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar = this.wv.get(this.wx);
        if (wVar != null) {
            meVar = wVar.c();
            srVar = wVar.k();
        } else {
            srVar = null;
        }
        this.f32509q.c(meVar, yu, srVar);
        this.f32509q.c(this.f32502c.a());
    }

    private void h() {
        boolean z3;
        boolean z4 = Math.max(0, this.ys - gb()) == 0;
        int sr = pr.sr(this.f32514w);
        int ux = pr.ux(this.f32514w);
        int f4 = f(false);
        String str = "\u9886\u53d6\u6210\u529f";
        if (sr == 0) {
            if (f4 > 0) {
                str = f4 + "s\u540e\u53ef\u9886\u53d6\u5956\u52b1";
            }
            z3 = true;
        } else {
            if (f4 > 0) {
                str = f4 + "s";
            }
            z3 = false;
        }
        w(f(true));
        this.f32504i.c(z3, str, (z4 && ux == 1) ? "\u8df3\u8fc7" : null, z4 && ux == 0, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.sr ng() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.sr) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.sr) wVar;
        }
        return null;
    }

    private void oh() {
        if (this.fp <= pr.ev(this.f32514w) || this.f32541m.get() || ng() == null) {
            return;
        }
        ng().ux();
    }

    private void ok() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar = this.gw;
        if (srVar == null || !srVar.wx()) {
            int sr = this.wv.get(this.wx).sr();
            if (sr > 0) {
                this.xk += sr;
            }
            if ((pr.xv(this.f32514w) <= this.yu) && !this.f32542x.get()) {
                this.f32502c.sr(0);
                this.f32502c.ia();
                this.f32542x.set(true);
            }
            int i4 = this.yu;
            if (i4 < this.xk) {
                this.yu = i4 + 1;
            }
        }
    }

    public static int w(me meVar) {
        return 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public int ba() {
        return w(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int bw() {
        return this.yu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void i() {
        super.i();
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.sr) ng().w().sr(this.pr);
            if (srVar != null) {
                srVar.c();
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv("cubic pause exception:" + e4.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ls() {
        super.ls();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.f32505j.c(jSONObject);
        i();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return this.f32514w.sc() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        this.f32504i.c(true);
        this.f32504i.w(this.f32514w.bx());
        this.f32504i.xv(true);
        this.f32504i.ux(true);
        this.f32504i.ev();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void q() {
        if (this.f32505j.yu()) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.sr) ng().w().sr(this.pr);
            if (srVar != null) {
                srVar.w();
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv("cubic  resume exception:" + e4.getMessage());
        }
        super.q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void wo() {
        h();
        ok();
        oh();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int wx() {
        return pr.xv(this.f32514w) - this.yu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ys() {
        super.ys();
        List<com.bytedance.sdk.openadsdk.core.component.reward.draw.w> list = this.wv;
        if (list != null) {
            for (com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar : list) {
                wVar.gd();
            }
        }
        if (ng() != null) {
            ng().xv().sr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ev() {
        super.ev();
        this.wv.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.w(this.f32502c, this.f32514w, this.f32501a, mt(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.f32514w.yz());
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                this.wv.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.w(this.f32502c, com.bytedance.sdk.openadsdk.core.w.c(jSONArray.getJSONObject(i4)), this.f32501a, mt(), false));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        for (com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar : this.wv) {
            wVar.c(this.bk);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View gd() {
        return com.bytedance.sdk.openadsdk.res.ux.k(this.f32502c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int r(boolean z3) {
        if (z3) {
            return wx();
        }
        return pr.r(this.f32514w) - this.yu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ux(boolean z3) {
        super.ux(z3);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar = this.gw;
        if (srVar != null) {
            srVar.xv(z3);
        }
        for (com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar : this.wv) {
            wVar.c(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void w(View view) {
        super.w(view);
        this.gw.c(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c, com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    protected void xv() {
        this.gd.xv(true);
        if (ng() != null) {
            ng().xv().c(this.wv);
            ng().sr().c(new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.xv.c
                public void c() {
                    xv.this.wx = 0;
                    c((com.bytedance.sdk.openadsdk.core.component.reward.draw.sr) xv.this.ng().w().sr(0));
                    xv.this.fm();
                    if (xv.this.wv.size() >= 1) {
                        ((com.bytedance.sdk.openadsdk.core.component.reward.draw.w) xv.this.wv.get(1)).r();
                    }
                    xv.this.f32502c.w(false, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.xv.c
                public void c(boolean z3, int i4, boolean z4) {
                    int i5 = xv.this.pr;
                    if (xv.this.gw != null) {
                        xv.this.f32502c.bm().c(z3, i5 + 1, xv.this.gw.eq());
                    }
                    xv.this.pr = i4;
                    xv xvVar = xv.this;
                    xvVar.bw = Math.max(xvVar.bw, i4 + 1);
                    xv xvVar2 = xv.this;
                    xvVar2.wx = i4 % xvVar2.wv.size();
                    c((com.bytedance.sdk.openadsdk.core.component.reward.draw.sr) xv.this.ng().w().sr(i4));
                    xv.this.ng().f();
                    xv.this.f32541m.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.xv.c
                public void c(boolean z3, int i4) {
                    com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.sr) xv.this.ng().w().sr(i4);
                    if (srVar != null) {
                        srVar.w(false);
                    }
                }

                private void c(com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar) {
                    if (srVar != null) {
                        xv.this.gw = srVar;
                        xv.this.gw.w(true);
                        xv.this.gw.c(new c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.c
                            public void c() {
                                xv xvVar = xv.this;
                                xvVar.fz = true;
                                xvVar.ng().c(false);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.c
                            public void sr() {
                                if (!pr.f(xv.this.f32514w) || xv.this.ng() == null) {
                                    return;
                                }
                                xv.this.ng().w().xv(xv.this.pr + 1);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.c
                            public void w() {
                                xv xvVar = xv.this;
                                xvVar.fz = false;
                                xvVar.ng().c(true);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.c
                            public Map<String, Object> xv() {
                                return xv.this.f32502c.a();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.c
                            public void c(int i4) {
                                xv.this.xk += i4;
                                xv.this.yu += i4;
                            }
                        });
                        xv.this.fz = srVar.wx();
                        xv.this.ng().c(!srVar.pr());
                    } else {
                        xv.this.fz = false;
                    }
                    xv.this.fm();
                }
            });
        }
        n();
    }

    public static boolean c(me meVar) {
        if (meVar != null && pr.c(meVar)) {
            return !TextUtils.isEmpty(meVar.yz());
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.sr srVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.sr(this.f32502c, this.f32514w, z3);
        float[] fArr = {this.ux, this.f32503f};
        if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
            fArr = fz();
        }
        srVar.c(fArr);
        this.gd = srVar;
        return srVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public w.c c(final com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar) {
        this.f32502c.x();
        com.bytedance.sdk.openadsdk.core.component.reward.xv.ux uxVar = new com.bytedance.sdk.openadsdk.core.component.reward.xv.ux(this.f32502c, this.f32514w);
        uxVar.c(pr());
        return uxVar.w(new com.bytedance.sdk.openadsdk.core.component.reward.xv.p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.xv.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void c() {
                super.c();
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.c();
                }
                xv.this.f32502c.m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void w() {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void xv() {
                super.xv();
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.xv();
                }
                xv.this.f32502c.m();
                if (xv.this.ng() != null) {
                    xv.this.ng().w().xv(xv.this.pr + 1);
                }
                xv.this.f32502c.bm().c("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(Map<String, Object> map) {
        super.c(map);
        map.put("group_pos", Integer.valueOf(this.pr + 1));
        com.bytedance.sdk.openadsdk.core.component.reward.draw.sr srVar = this.gw;
        if (srVar != null) {
            map.put("duration", Long.valueOf(srVar.eq()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        try {
            jSONObject.put("group_pos", this.wx + 1);
            jSONObject.put("duration", this.gw.eq());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
