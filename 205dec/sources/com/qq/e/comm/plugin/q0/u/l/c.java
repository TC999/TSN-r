package com.qq.e.comm.plugin.q0.u.l;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.qq.e.comm.plugin.b0.f;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.s.g;
import com.qq.e.comm.plugin.q0.u.i;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f45643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.b0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f45644a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.d f45645b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f45646c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f45647d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f45648e;

        a(g gVar, com.qq.e.comm.plugin.q0.s.d dVar, String str, String str2, String str3) {
            this.f45644a = gVar;
            this.f45645b = dVar;
            this.f45646c = str;
            this.f45647d = str2;
            this.f45648e = str3;
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
            c.this.a(this.f45644a, this.f45645b, this.f45646c, this.f45647d, this.f45648e, null);
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, f fVar) {
            Bitmap b4 = fVar.b();
            if (b4 == null) {
                b4 = BitmapFactory.decodeFile(fVar.d().getAbsolutePath());
            }
            c.this.a(this.f45644a, this.f45645b, this.f45646c, this.f45647d, this.f45648e, b4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f45643a = str;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "updateTimelineShareData";
    }

    private void a(g gVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        if (d4 == null) {
            return;
        }
        String optString = d4.optString("title");
        com.qq.e.comm.plugin.b0.b.a().a(d4.optString("imgUrl"), (ImageView) null, new a(gVar, dVar, d4.optString("link"), optString, d4.optString("desc")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, com.qq.e.comm.plugin.q0.s.d dVar, String str, String str2, String str3, Bitmap bitmap) {
        int a4 = com.qq.e.comm.plugin.s0.b.a(this.f45643a, str, str2, str3, bitmap);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("code", Integer.valueOf(a4));
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        d1.a("shareToTimeline result " + a4, new Object[0]);
        gVar.a(new e(dVar, e.a.f45548c, jSONObject));
        v.b(1130015, null, Integer.valueOf(a4));
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        a(hVar.c(), dVar);
    }
}
