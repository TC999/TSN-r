package com.qq.e.dl.l.i;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.dl.k.l;
import com.qq.e.dl.k.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f47102a;

    /* renamed from: b  reason: collision with root package name */
    private final int f47103b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f47104c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Paint f47105d;

    private e(int i4, JSONObject jSONObject) {
        this.f47102a = i4;
        this.f47103b = jSONObject.optInt("tvfo", 0);
        Paint paint = new Paint();
        this.f47105d = paint;
        paint.setStyle(Paint.Style.STROKE);
        JSONArray optJSONArray = jSONObject.optJSONArray("tvd");
        if (optJSONArray != null && (r1 = optJSONArray.length()) > 0) {
            int length = length % 2 != 0 ? length + 1 : length;
            float[] fArr = new float[length];
            for (int i5 = 0; i5 < length; i5++) {
                fArr[i5] = l.c(optJSONArray.opt(i5)).a(new JSONObject[0]);
            }
            this.f47105d.setPathEffect(new DashPathEffect(fArr, 0.0f));
        } else {
            this.f47105d.setStrokeCap(Paint.Cap.ROUND);
            this.f47105d.setStrokeJoin(Paint.Join.ROUND);
        }
        Object opt = jSONObject.opt("tvs");
        if (opt != null) {
            this.f47105d.setStrokeWidth(l.c(opt).a(new JSONObject[0]));
        }
        String optString = jSONObject.optString("tvc");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f47105d.setColor(n.a(l.c((Object) optString)));
    }

    @Override // com.qq.e.dl.l.i.d
    public void a(Canvas canvas, int i4, int i5) {
    }

    public void a(View view, MotionEvent motionEvent) {
        if (-1 == this.f47103b) {
            return;
        }
        this.f47104c.reset();
        view.invalidate();
    }

    @Override // com.qq.e.dl.l.i.d
    public void b(Canvas canvas, int i4, int i5) {
        if (this.f47102a == 1) {
            canvas.drawPath(this.f47104c, this.f47105d);
        }
    }

    public void c(View view, MotionEvent motionEvent) {
        if (this.f47102a == 1) {
            this.f47104c.moveTo(motionEvent.getX(), motionEvent.getY());
        }
    }

    public void b(View view, MotionEvent motionEvent) {
        if (this.f47102a == 1) {
            this.f47104c.lineTo(motionEvent.getX(), motionEvent.getY());
            view.invalidate();
        }
    }

    public static e a(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("tvt", 0);
        if (optInt == 0) {
            return null;
        }
        return new e(optInt, jSONObject);
    }
}
