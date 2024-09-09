package cn.jpush.android.u;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.helper.Logger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    private ImageView f4393g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f4394h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f4395i;

    /* renamed from: j  reason: collision with root package name */
    private View f4396j;

    public c(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i4) {
        super(context, aVar, dVar, i4);
    }

    @Override // cn.jpush.android.u.e
    protected void a() {
        this.f4394h = (ImageView) b("image");
        this.f4395i = (TextView) b("btn_countdown");
        this.f4393g = (ImageView) b("image_close");
        this.f4396j = b("countdown_container");
    }

    @Override // cn.jpush.android.u.e
    protected String b() {
        return "jpush_full";
    }

    @Override // cn.jpush.android.u.b
    public void c() {
    }

    @Override // cn.jpush.android.u.b
    public void d() {
        try {
            JSONObject jSONObject = new JSONObject(this.f4382b.f4132i);
            if (31 == this.f4385e) {
                this.f4393g.setVisibility(0);
                this.f4395i.setVisibility(8);
                this.f4393g.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.a(3, (String) null, 2);
                    }
                });
            } else {
                this.f4393g.setVisibility(8);
                this.f4395i.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4396j.getLayoutParams();
                layoutParams.width = a(140);
                this.f4396j.setLayoutParams(layoutParams);
                a(this.f4395i, jSONObject.getJSONObject("full"), 3);
                this.f4395i.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.a(3, (String) null, 3);
                    }
                });
            }
            String string = jSONObject.getString("image");
            JSONObject optJSONObject = jSONObject.optJSONObject("click");
            DisplayMetrics displayMetrics = this.f4384d.getResources().getDisplayMetrics();
            a(this.f4394h, string, optJSONObject, 1, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "full bindDataToView throwable=" + th);
        }
    }

    @Override // cn.jpush.android.u.e, cn.jpush.android.u.b
    public void g() {
        a(this.f4395i);
    }
}
