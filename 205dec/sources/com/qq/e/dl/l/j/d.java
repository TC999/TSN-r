package com.qq.e.dl.l.j;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f47133a;

    /* renamed from: b  reason: collision with root package name */
    private final j f47134b;

    /* renamed from: c  reason: collision with root package name */
    private final int f47135c;

    /* renamed from: d  reason: collision with root package name */
    private final int f47136d;

    /* renamed from: e  reason: collision with root package name */
    private final j f47137e;

    /* renamed from: f  reason: collision with root package name */
    private final int f47138f;

    /* renamed from: g  reason: collision with root package name */
    private PointF f47139g;

    /* renamed from: h  reason: collision with root package name */
    private int f47140h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f47141i = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f47142j;

    private d(JSONObject jSONObject) {
        this.f47133a = jSONObject.optInt("dd", 0);
        this.f47134b = new j(jSONObject.optJSONArray("da"), true);
        this.f47135c = jSONObject.optInt(CampaignUnit.JSON_KEY_ADS, 0);
        this.f47136d = jSONObject.optInt("adf", 0);
        this.f47137e = new j(jSONObject.optJSONArray("aa"), false);
        int optInt = jSONObject.optInt("at");
        this.f47138f = optInt > 0 ? optInt : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, PointF pointF) {
        Float valueOf;
        Float valueOf2;
        Float f4 = null;
        switch (this.f47133a) {
            case 0:
                f4 = Float.valueOf(pointF.x - this.f47139g.x);
                valueOf = Float.valueOf(pointF.y - this.f47139g.y);
                break;
            case 1:
                valueOf2 = Float.valueOf(pointF.x - this.f47139g.x);
                f4 = valueOf2;
                valueOf = null;
                break;
            case 2:
                valueOf = Float.valueOf(pointF.y - this.f47139g.y);
                break;
            case 3:
                valueOf = Float.valueOf(Math.min(pointF.y - this.f47139g.y, -view.getTranslationY()));
                break;
            case 4:
                valueOf = Float.valueOf(Math.max(pointF.y - this.f47139g.y, -view.getTranslationY()));
                break;
            case 5:
                valueOf2 = Float.valueOf(Math.min(pointF.x - this.f47139g.x, -view.getTranslationX()));
                f4 = valueOf2;
                valueOf = null;
                break;
            case 6:
                valueOf2 = Float.valueOf(Math.max(pointF.x - this.f47139g.x, -view.getTranslationX()));
                f4 = valueOf2;
                valueOf = null;
                break;
            default:
                return;
        }
        Float b4 = b(view, f4, true);
        Float b5 = b(view, valueOf, false);
        if (b4 == null && b5 == null) {
            return;
        }
        ViewPropertyAnimator animate = view.animate();
        if (b4 != null) {
            animate.translationX(b4.floatValue());
        }
        if (b5 != null) {
            animate.translationY(b5.floatValue());
        }
        animate.setDuration(0L).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, PointF pointF) {
        this.f47139g = new PointF(pointF.x - view.getTranslationX(), pointF.y - view.getTranslationY());
        if (this.f47142j) {
            return;
        }
        this.f47142j = true;
        this.f47134b.a(view);
        this.f47137e.a(view);
        View view2 = (View) view.getParent();
        this.f47140h = view2.getWidth();
        this.f47141i = view2.getHeight();
    }

    private Float b(View view, Float f4, boolean z3) {
        if (f4 == null) {
            return null;
        }
        float b4 = z3 ? this.f47134b.b() : this.f47134b.d();
        float a4 = z3 ? this.f47134b.a() : this.f47134b.c();
        float translationX = z3 ? view.getTranslationX() : view.getTranslationY();
        if (f4.floatValue() < b4) {
            if (translationX != b4) {
                return Float.valueOf(b4);
            }
        } else if (f4.floatValue() <= a4) {
            return f4;
        } else {
            if (translationX != a4) {
                return Float.valueOf(a4);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3, View view) {
        Float valueOf;
        Float valueOf2;
        int i4 = z3 ? this.f47135c : this.f47136d;
        if (i4 == 0) {
            return;
        }
        Float f4 = null;
        switch (i4) {
            case 1:
                if (view.getLeft() + view.getTranslationX() + (view.getWidth() / 2.0f) > this.f47140h / 2.0f) {
                    valueOf = Float.valueOf(this.f47137e.a());
                } else {
                    valueOf = Float.valueOf(this.f47137e.b());
                }
                f4 = valueOf;
                valueOf2 = null;
                break;
            case 2:
                if (view.getTop() + view.getTranslationY() + (view.getHeight() / 2.0f) > this.f47141i / 2.0f) {
                    valueOf2 = Float.valueOf(this.f47137e.c());
                    break;
                } else {
                    valueOf2 = Float.valueOf(this.f47137e.d());
                    break;
                }
            case 3:
                valueOf2 = Float.valueOf(this.f47137e.d());
                break;
            case 4:
                valueOf2 = Float.valueOf(this.f47137e.c());
                break;
            case 5:
                valueOf = Float.valueOf(this.f47137e.b());
                f4 = valueOf;
                valueOf2 = null;
                break;
            case 6:
                valueOf = Float.valueOf(this.f47137e.a());
                f4 = valueOf;
                valueOf2 = null;
                break;
            case 7:
                f4 = Float.valueOf(0.0f);
                valueOf2 = Float.valueOf(0.0f);
                break;
            default:
                return;
        }
        Float a4 = a(view, f4, true);
        Float a5 = a(view, valueOf2, false);
        ViewPropertyAnimator animate = view.animate();
        if (a4 != null) {
            animate.translationX(a4.floatValue());
        }
        if (a5 != null) {
            animate.translationY(a5.floatValue());
        }
        animate.setDuration(this.f47138f).start();
    }

    private Float a(View view, Float f4, boolean z3) {
        if (f4 != null) {
            return f4;
        }
        float translationX = z3 ? view.getTranslationX() : view.getTranslationY();
        float b4 = z3 ? this.f47137e.b() : this.f47137e.d();
        float a4 = z3 ? this.f47137e.a() : this.f47137e.c();
        if (translationX < b4) {
            return Float.valueOf(b4);
        }
        return translationX > a4 ? Float.valueOf(a4) : f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(JSONObject jSONObject) {
        if (jSONObject.optInt("dg") == 1) {
            return new d(jSONObject);
        }
        return null;
    }
}
