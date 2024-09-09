package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.pr;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends c {
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.c> wv;
    private int xk;

    public k(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
        this.wv = new ArrayList();
        this.xk = 0;
    }

    public static boolean c(me meVar) {
        if (meVar != null && ls.c(meVar)) {
            if (com.bytedance.sdk.openadsdk.core.bk.sr.c(String.valueOf(wv.gd(meVar)))) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(BidResponsedEx.KEY_CID, meVar.zb());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                com.bytedance.sdk.openadsdk.core.fz.a.c().c(meVar, "refresh_max", jSONObject);
                com.bytedance.sdk.openadsdk.core.a.xv.r(meVar, wv.c(meVar), "refresh_max", null);
                return false;
            }
            return true;
        }
        return false;
    }

    private com.bytedance.sdk.openadsdk.core.component.reward.layout.p ng() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.p) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.p) wVar;
        }
        return null;
    }

    private int ok() {
        int ux;
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.c cVar;
        me c4;
        ls dc;
        com.bytedance.sdk.openadsdk.core.component.reward.layout.p pVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.p) this.gd;
        if (pVar == null || (ux = pVar.ux()) < 0 || ux >= this.wv.size() || (cVar = this.wv.get(ux)) == null || (c4 = cVar.c()) == null || (dc = c4.dc()) == null) {
            return 0;
        }
        return dc.xv();
    }

    public static int w(me meVar) {
        return 11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public int ba() {
        return w(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int bw() {
        return this.xk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ev() {
        super.ev();
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.c cVar = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.c(this.f32502c, this.f32514w, this.f32501a, mt(), true);
        cVar.c(this.bk);
        this.wv.add(cVar);
        try {
            JSONArray jSONArray = new JSONArray(this.f32514w.yz());
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                com.bytedance.sdk.openadsdk.core.component.reward.swiper.c cVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.c(this.f32502c, com.bytedance.sdk.openadsdk.core.w.c(jSONArray.getJSONObject(i4)), this.f32501a, mt(), false);
                cVar2.c(this.bk);
                this.wv.add(cVar2);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View gd() {
        FrameLayout frameLayout = new FrameLayout(this.f32502c);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void i() {
        super.i();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.p) this.gd).w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ls() {
        super.ls();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.p) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.p) wVar).p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void me() {
        super.me();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.p) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.p) wVar).sr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        this.f32504i.c(false);
        this.f32504i.w(false);
        this.f32504i.ux(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void q() {
        super.q();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.p) this.gd).xv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int r(boolean z3) {
        if (z3) {
            return wx();
        }
        return pr.r(this.f32514w) - this.xk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void t() {
        super.t();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.p) this.gd).w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ux(boolean z3) {
        super.ux(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void w(boolean z3) {
        super.w(z3);
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.p) this.gd).xv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void wo() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int wx() {
        return pr.xv(this.f32514w) - this.xk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c, com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    protected void xv() {
        this.gd.xv(true);
        if (ng() != null) {
            ng().c(this.wv);
        }
        this.f32502c.w(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ys() {
        super.ys();
        this.gd.p();
        List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.c> list = this.wv;
        if (list != null) {
            for (com.bytedance.sdk.openadsdk.core.component.reward.swiper.c cVar : list) {
                cVar.gd();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void w(Map<String, Object> map) {
        super.w(map);
        map.put("refresh_num", Integer.valueOf(ok()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void w(View view) {
        super.w(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.p pVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.p(this.f32502c, this.f32514w, z3);
        pVar.c(new float[]{this.ux, this.f32503f});
        this.gd = pVar;
        return pVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public w.c c(final com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar) {
        this.f32502c.x();
        com.bytedance.sdk.openadsdk.core.component.reward.xv.ux uxVar = new com.bytedance.sdk.openadsdk.core.component.reward.xv.ux(this.f32502c, this.f32514w);
        uxVar.c(pr());
        return uxVar.w(new com.bytedance.sdk.openadsdk.core.component.reward.xv.p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.k.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void c() {
                super.c();
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.c();
                }
                k.this.f32502c.m();
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
                k.this.f32502c.m();
                k.this.f32502c.bm().c("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(Map<String, Object> map) {
        super.c(map);
        map.put("refresh_num", Integer.valueOf(ok()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        try {
            jSONObject.put("refresh_num", ok());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
