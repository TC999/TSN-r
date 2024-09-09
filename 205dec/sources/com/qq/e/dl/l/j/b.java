package com.qq.e.dl.l.j;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.dl.k.l;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    private final boolean f47112g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f47113h;

    /* renamed from: i  reason: collision with root package name */
    private final int f47114i;

    /* renamed from: j  reason: collision with root package name */
    private final Boolean f47115j;

    /* renamed from: k  reason: collision with root package name */
    private final Boolean f47116k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f47117l;

    /* renamed from: m  reason: collision with root package name */
    private final int f47118m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f47119n;

    public b(c cVar, boolean z3, int i4) {
        super(cVar);
        Object opt;
        Object opt2;
        this.f47117l = z3;
        this.f47118m = i4;
        this.f47112g = cVar.f47120a == 4;
        JSONObject jSONObject = cVar.f47122c;
        if (jSONObject != null && jSONObject.length() > 0) {
            int optInt = jSONObject.optInt("vp");
            if (optInt == 2) {
                this.f47116k = Boolean.TRUE;
            } else if (optInt == 1) {
                this.f47116k = Boolean.FALSE;
            } else {
                this.f47116k = null;
            }
            int optInt2 = jSONObject.optInt("tp");
            if (optInt2 == 1) {
                this.f47115j = Boolean.TRUE;
            } else if (optInt2 == 2) {
                this.f47115j = Boolean.FALSE;
            } else {
                this.f47115j = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("as");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ds");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
            if (length2 <= 0 && (opt2 = jSONObject.opt("cr")) != null) {
                optJSONArray2 = new JSONArray((Collection) Collections.singletonList(opt2));
                length2 = 1;
            }
            int max = Math.max(length2, (length + 1) / 2);
            this.f47114i = max;
            if (max == 0) {
                this.f47113h = null;
                return;
            }
            this.f47113h = new int[max * 3];
            for (int i5 = 0; i5 < this.f47114i; i5++) {
                int i6 = i5 * 3;
                this.f47113h[i6] = (length2 <= 0 || (opt = optJSONArray2.opt(i5)) == null) ? -1 : l.c(opt).a(new JSONObject[0]);
                this.f47113h[i6 + 1] = length > 0 ? optJSONArray.optInt(i5 * 2, 0) : 0;
                int[] iArr = this.f47113h;
                int i7 = i6 + 2;
                int i8 = 360;
                if (length > 0) {
                    i8 = optJSONArray.optInt((i5 * 2) + 1, 360);
                }
                iArr[i7] = i8;
            }
            return;
        }
        this.f47113h = null;
        this.f47114i = 0;
        this.f47115j = null;
        this.f47116k = null;
    }

    @Override // com.qq.e.dl.l.j.a, com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        this.f47119n = false;
        return super.a(view, motionEvent, pointF);
    }

    @Override // com.qq.e.dl.l.j.a, com.qq.e.dl.l.j.g
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        if (this.f47117l && !this.f47119n) {
            float f4 = pointF2.y - pointF.y;
            float f5 = pointF2.x - pointF.x;
            double hypot = Math.hypot(f4, f5);
            d1.a("moving process detect delta x = %.2f, delta y = %.2f, hypot = %.2f, slop = %d", Float.valueOf(f5), Float.valueOf(f4), Double.valueOf(hypot), Integer.valueOf(this.f47118m));
            if (hypot > this.f47118m) {
                if (!d(view, motionEvent, pointF, pointF2)) {
                    f.a(view, false);
                }
                this.f47119n = true;
            }
        }
        return super.b(view, motionEvent, pointF, pointF2);
    }

    @Override // com.qq.e.dl.l.j.a
    boolean d(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        float abs;
        double d4;
        double atan2;
        if (pointF != null && pointF2 != null) {
            Boolean bool = this.f47115j;
            if (bool != null) {
                if (bool.booleanValue()) {
                    float x3 = motionEvent.getX();
                    float y3 = motionEvent.getY();
                    if (x3 < 0.0f || y3 < 0.0f || x3 > view.getWidth() || y3 > view.getHeight()) {
                        return false;
                    }
                } else {
                    float x4 = motionEvent.getX();
                    float y4 = motionEvent.getY();
                    if (x4 >= 0.0f && y4 >= 0.0f && x4 <= view.getWidth() && y4 <= view.getHeight()) {
                        return false;
                    }
                }
            }
            if (this.f47114i <= 0) {
                return true;
            }
            float f4 = pointF2.x - pointF.x;
            float f5 = pointF2.y - pointF.y;
            Boolean bool2 = this.f47116k;
            if (bool2 == null) {
                d4 = Math.hypot(f4, f5);
            } else {
                if (bool2.booleanValue()) {
                    abs = Math.abs(f5);
                } else {
                    abs = Math.abs(f4);
                }
                d4 = abs;
            }
            if (f4 == 0.0f && f5 == 0.0f) {
                atan2 = Double.NaN;
            } else {
                atan2 = (Math.atan2(f5, f4) / 3.141592653589793d) * 180.0d;
                if (atan2 < 0.0d) {
                    atan2 += 360.0d;
                }
            }
            for (int i4 = 0; i4 < this.f47114i; i4++) {
                int i5 = i4 * 3;
                int i6 = this.f47113h[i5];
                if (i6 > -1) {
                    if (this.f47112g) {
                        if (d4 < i6) {
                            continue;
                        }
                    } else if (d4 > i6) {
                        continue;
                    }
                }
                if (Double.isNaN(atan2)) {
                    return true;
                }
                int[] iArr = this.f47113h;
                int i7 = iArr[i5 + 1];
                int i8 = iArr[i5 + 2];
                if ((i7 >= i8 || (atan2 >= i7 && atan2 <= i8)) && (i7 < i8 || atan2 >= i7 || atan2 <= i8)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.qq.e.dl.l.j.a, com.qq.e.dl.l.j.g
    public boolean a() {
        return this.f47117l || super.a();
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0 || jSONObject.optInt("sys") != 1;
    }
}
