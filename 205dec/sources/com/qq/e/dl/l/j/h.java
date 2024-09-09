package com.qq.e.dl.l.j;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends a {

    /* renamed from: g  reason: collision with root package name */
    private final float f47174g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f47175h;

    /* renamed from: i  reason: collision with root package name */
    private final List<PointF> f47176i;

    /* renamed from: j  reason: collision with root package name */
    private List<PointF> f47177j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        super(cVar);
        int length;
        JSONObject jSONObject = cVar.f47122c;
        if (jSONObject != null && jSONObject.length() > 0) {
            this.f47175h = jSONObject.optInt("rtdrn", 0) == 1;
            double optDouble = jSONObject.optDouble("sml", 0.0d);
            if (optDouble > 1.0d) {
                optDouble = 1.0d;
            } else if (optDouble < -1.0d) {
                optDouble = -1.0d;
            }
            this.f47174g = (float) optDouble;
            JSONArray optJSONArray = jSONObject.optJSONArray("pts");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                this.f47176i = new ArrayList((length + 1) / 2);
                for (int i4 = 0; i4 < length; i4 += 2) {
                    this.f47176i.add(new PointF((float) optJSONArray.optDouble(i4, 0.0d), (float) optJSONArray.optDouble(i4 + 1, 0.0d)));
                }
                return;
            }
            this.f47176i = null;
            return;
        }
        this.f47174g = 0.0f;
        this.f47175h = false;
        this.f47176i = null;
    }

    @Override // com.qq.e.dl.l.j.a, com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        ArrayList arrayList = new ArrayList(20);
        this.f47177j = arrayList;
        arrayList.add(pointF);
        return super.a(view, motionEvent, pointF);
    }

    @Override // com.qq.e.dl.l.j.a, com.qq.e.dl.l.j.g
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        List<PointF> list = this.f47177j;
        if (list != null) {
            list.add(pointF2);
        }
        return super.b(view, motionEvent, pointF, pointF2);
    }

    @Override // com.qq.e.dl.l.j.a
    boolean d(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        return com.qq.e.comm.plugin.x.a.a(this.f47176i, this.f47177j, this.f47175h) >= this.f47174g;
    }

    @Override // com.qq.e.dl.l.j.a, com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        List<PointF> list = this.f47177j;
        if (list != null) {
            list.add(pointF2);
        }
        return super.a(view, motionEvent, pointF, pointF2);
    }
}
