package j0;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.swiper.Swiper;
import com.bytedance.adsdk.ugeno.w.i;
import l0.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c extends com.bytedance.adsdk.ugeno.component.a<Swiper> {
    private String A;
    private boolean B;
    private int C;
    private int D;
    private float E;
    private JSONArray F;
    private com.bytedance.adsdk.ugeno.component.b G;
    private float H;
    private float I;
    private float J;

    /* renamed from: d  reason: collision with root package name */
    private String f55214d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f55215e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f55216l;

    /* renamed from: o  reason: collision with root package name */
    private float f55217o;

    /* renamed from: v  reason: collision with root package name */
    private float f55218v;

    public c(Context context) {
        super(context);
        this.f55215e = true;
        this.f55216l = true;
        this.f55217o = 0.0f;
        this.f55218v = 2000.0f;
        this.A = "normal";
        this.B = true;
        this.C = Color.parseColor("#666666");
        this.D = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.component.a
    public void c(com.bytedance.adsdk.ugeno.component.b bVar) {
        this.G = bVar;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.component.a, com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        JSONArray jSONArray = this.F;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.ux).sr((int) this.H).ux((int) this.I).f((int) this.J).xv(this.B).w(this.D).xv(this.C).c(this.A).sr(this.f55215e).c(this.E).c(this.f55216l).c((int) this.f55218v).xv(this.B);
        for (int i4 = 0; i4 < this.F.length(); i4++) {
            i iVar = new i(this.f26040w);
            iVar.g(this.gw);
            com.bytedance.adsdk.ugeno.component.b<View> b4 = iVar.b(this.G.a(), null);
            iVar.k(this.F.optJSONObject(i4));
            ((Swiper) this.ux).c((Swiper) b4);
        }
        if (this.f55216l) {
            ((Swiper) this.ux).c();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public View xv() {
        Swiper swiper = new Swiper(this.f26040w);
        this.ux = swiper;
        swiper.a(this);
        return this.ux;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    c4 = 3;
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c4 = 4;
                    break;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    c4 = 5;
                    break;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    c4 = 6;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c4 = 7;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    c4 = 11;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    c4 = '\r';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f55217o = l0.i.a(str2, 0.0f);
                return;
            case 1:
                this.C = l0.a.a(str2);
                return;
            case 2:
                this.J = l0.b.a(this.f26040w, l0.i.a(str2, 0.0f));
                return;
            case 3:
                this.A = str2;
                return;
            case 4:
                this.f55214d = str2;
                return;
            case 5:
                this.B = l0.i.d(str2, true);
                return;
            case 6:
                this.I = l0.b.a(this.f26040w, l0.i.a(str2, 0.0f));
                return;
            case 7:
                this.f55215e = l0.i.d(str2, true);
                return;
            case '\b':
                this.f55218v = l0.i.a(str2, 500.0f);
                return;
            case '\t':
                this.E = l0.i.a(str2, 1.0f);
                return;
            case '\n':
                this.H = l0.b.a(this.f26040w, l0.i.a(str2, 0.0f));
                return;
            case 11:
                this.D = l0.a.a(str2);
                return;
            case '\f':
                this.f55216l = l0.i.d(str2, true);
                return;
            case '\r':
                this.F = h.a(str2, null);
                return;
            default:
                return;
        }
    }
}
