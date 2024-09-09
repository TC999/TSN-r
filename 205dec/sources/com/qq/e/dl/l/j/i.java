package com.qq.e.dl.l.j;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final c f47178a;

    public i(c cVar) {
        this.f47178a = cVar;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        a(view, motionEvent);
        return Boolean.FALSE;
    }

    @Override // com.qq.e.dl.l.j.g
    public boolean a() {
        return true;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        a(view, motionEvent);
        return Boolean.FALSE;
    }

    @Override // com.qq.e.dl.l.j.g
    public void b() {
    }

    @Override // com.qq.e.dl.l.j.g
    public com.qq.e.dl.l.i.d c() {
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean c(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public boolean d() {
        return false;
    }

    @Override // com.qq.e.dl.l.j.g
    public c e() {
        return this.f47178a;
    }

    @Override // com.qq.e.dl.l.j.g
    public int f() {
        return 0;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        a(view, motionEvent);
        return Boolean.TRUE;
    }

    private void a(View view, MotionEvent motionEvent) {
        try {
            this.f47178a.f47122c.put("motionEvent", motionEvent);
            this.f47178a.f47122c.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, view);
        } catch (JSONException unused) {
        }
    }
}
