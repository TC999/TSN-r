package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.dl.l.h;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c0 extends com.qq.e.dl.l.k.e.b {
    private static final Random D = new Random();
    private boolean A;
    private final boolean B;
    private JSONObject C;

    /* renamed from: y  reason: collision with root package name */
    private Integer f42385y;

    /* renamed from: z  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f42386z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.dl.f.p {
        a() {
        }

        @Override // com.qq.e.dl.f.b
        public void a(String str) {
            com.qq.e.comm.plugin.o0.h.f b4;
            c0.this.h(2);
            h0.b bVar = (h0.b) ((com.qq.e.dl.l.h) c0.this).f47074l.getRootView().findViewWithTag("GDTDLVideoView");
            if (bVar == null || (b4 = bVar.b()) == null) {
                return;
            }
            b4.play();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new c0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends com.qq.e.dl.l.k.e.c {

        /* renamed from: d  reason: collision with root package name */
        private final p.h f42388d;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements p.h {
            a() {
            }

            @Override // com.qq.e.comm.plugin.util.p.h
            public boolean b() {
                return false;
            }

            @Override // com.qq.e.comm.plugin.util.p.h
            public boolean c() {
                c0.b(((com.qq.e.dl.l.k.e.c) c.this).f47191c, false, null, false);
                return false;
            }
        }

        public c(Context context) {
            super(context);
            this.f42388d = new a();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            com.qq.e.comm.plugin.util.p.b().a(this.f42388d);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            com.qq.e.comm.plugin.util.p.b().b(this.f42388d);
        }
    }

    public c0(com.qq.e.dl.a aVar) {
        super(aVar);
        this.A = false;
        h(2);
        this.B = D.nextBoolean();
    }

    private void d(JSONObject jSONObject) {
        com.qq.e.comm.plugin.n0.v.a(1403020, com.qq.e.comm.plugin.n0.c.a(this.f42386z), 3);
        b(this, false, null, false);
    }

    private void e(JSONObject jSONObject) {
        com.qq.e.comm.plugin.n0.v.a(1403020, com.qq.e.comm.plugin.n0.c.a(this.f42386z), 2);
        if (jSONObject != null) {
            com.qq.e.comm.plugin.fs.e.d.a(jSONObject.optInt("reduceTimeForFail"));
        }
        this.f47074l.c("showErrorTip");
        b(this, false, "errorTipVis", true);
    }

    private void f(JSONObject jSONObject) {
        com.qq.e.comm.plugin.n0.v.a(1403020, com.qq.e.comm.plugin.n0.c.a(this.f42386z), 1);
        if (jSONObject != null) {
            com.qq.e.comm.plugin.fs.e.d.a(jSONObject.optInt("reducedTime"));
        }
        this.f47074l.c("showCorrectTip");
        b(this, false, "correctTipVis", true);
    }

    private void j(int i4) {
        Integer num;
        if (this.A || (num = this.f42385y) == null || i4 / 1000 < num.intValue()) {
            return;
        }
        this.A = true;
        b(this, true, null, false);
    }

    private void y() {
        if (!this.A || q() == 2) {
            return;
        }
        if (com.qq.e.comm.plugin.util.p.b().c()) {
            this.f47074l.a("dismissPopup", new a());
            return;
        }
        this.f47074l.c("dismissPopup");
        h(2);
    }

    private void z() {
        com.qq.e.comm.plugin.o0.h.f b4;
        com.qq.e.comm.plugin.n0.v.a(1403020, com.qq.e.comm.plugin.n0.c.a(this.f42386z), 0);
        this.f47074l.c("showPopup");
        h0.b bVar = (h0.b) this.f47074l.getRootView().findViewWithTag("GDTDLVideoView");
        if (bVar != null && (b4 = bVar.b()) != null) {
            b4.pause();
        }
        h(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.k.e.b
    /* renamed from: b */
    public c a(com.qq.e.dl.a aVar) {
        return new c(aVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.qq.e.dl.l.h hVar, boolean z3, String str, boolean z4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("dlInfo", jSONObject2);
            int i4 = 0;
            jSONObject2.put("popupVis", z3 ? 0 : 2);
            if (TextUtils.isEmpty(str)) {
                hVar.c(jSONObject);
            } else {
                if (!z4) {
                    i4 = 2;
                }
                jSONObject2.put(str, i4);
                hVar.p().a(jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.k.d, com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case -1169023802:
                if (str.equals("adModel")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case -338830486:
                if (str.equals("showTime")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1572:
                if (str.equals("15")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 3076010:
                if (str.equals("data")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1611883964:
                if (str.equals("videoPlayTime")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        if (c4 == 0) {
            this.f42386z = (com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]);
        } else if (c4 == 1) {
            this.f42385y = Integer.valueOf(gVar.b(new JSONObject[0]));
        } else if (c4 == 2) {
            j(gVar.b(new JSONObject[0]));
        } else if (c4 == 3) {
            int b4 = gVar.b(new JSONObject[0]);
            if (b4 == 0) {
                z();
            } else if (2 == b4) {
                y();
            } else {
                h(b4);
            }
        } else if (c4 != 4) {
            return super.a(str, gVar);
        } else {
            try {
                this.C = a(gVar.c(new JSONObject[0]));
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private JSONObject a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            if (length <= 0) {
                return null;
            }
            jSONObject = jSONArray.optJSONObject(D.nextInt(length));
        } else if (!(obj instanceof JSONObject)) {
            return null;
        } else {
            jSONObject = (JSONObject) obj;
        }
        Object opt = jSONObject.opt("originCorrect");
        if (opt == null) {
            opt = jSONObject.opt("correctOption");
            jSONObject.put("originCorrect", opt);
        }
        String opt2 = jSONObject.opt("originError");
        if (opt2 == null) {
            opt2 = jSONObject.opt("errorOptions");
            jSONObject.put("originError", opt2);
        }
        if (opt2 instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) opt2;
            int length2 = jSONArray2.length();
            opt2 = length2 == 0 ? "" : jSONArray2.opt(D.nextInt(length2));
        }
        if (this.B) {
            jSONObject.put("correctOption", opt2);
            jSONObject.put("errorOptions", opt);
        } else {
            jSONObject.put("correctOption", opt);
            jSONObject.put("errorOptions", opt2);
        }
        return jSONObject;
    }

    @Override // com.qq.e.dl.l.k.d, com.qq.e.dl.l.h
    public void a(h.d dVar) {
        Object c4;
        if (this.C != null) {
            String str = this.B ? "errorOptions" : "correctOption";
            Object opt = this.C.opt(str);
            if (opt != null && (c4 = com.qq.e.dl.k.l.a(opt).c(this.f42386z.l())) != null) {
                try {
                    this.C.put(str, c4);
                } catch (JSONException unused) {
                }
            }
            c(new com.qq.e.comm.plugin.util.j0().a("dlInfo", this.C).a());
        }
        super.a(dVar);
    }

    @Override // com.qq.e.dl.l.k.d, com.qq.e.dl.l.h
    public void a(String str, JSONObject jSONObject) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == -1936979796) {
            if (str.equals("popupClose")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else if (hashCode != -155481098) {
            if (hashCode == 158711817 && str.equals("popupFailed")) {
                c4 = 2;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("popupSucceed")) {
                c4 = 1;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            d(jSONObject);
        } else if (c4 == 1) {
            if (this.B) {
                e(jSONObject);
            } else {
                f(jSONObject);
            }
        } else if (c4 != 2) {
            super.a(str, jSONObject);
        } else if (this.B) {
            f(jSONObject);
        } else {
            e(jSONObject);
        }
    }
}
