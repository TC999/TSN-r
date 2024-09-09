package cn.jpush.android.u;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.ui.RoundedImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d extends e {

    /* renamed from: g  reason: collision with root package name */
    private TextView f4399g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f4400h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f4401i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f4402j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f4403k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f4404l;

    /* renamed from: m  reason: collision with root package name */
    private View f4405m;

    /* renamed from: n  reason: collision with root package name */
    private View f4406n;

    /* renamed from: o  reason: collision with root package name */
    private View f4407o;

    /* renamed from: p  reason: collision with root package name */
    private View f4408p;

    /* renamed from: q  reason: collision with root package name */
    private FrameLayout f4409q;

    /* renamed from: r  reason: collision with root package name */
    private RoundedImageView f4410r;

    /* renamed from: s  reason: collision with root package name */
    private RoundedImageView f4411s;

    public d(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i4) {
        super(context, aVar, dVar, i4);
    }

    private void l() {
        this.f4410r.setVisibility(8);
        GradientDrawable gradientDrawable = (GradientDrawable) this.f4407o.getBackground();
        gradientDrawable.mutate();
        gradientDrawable.setCornerRadius(m.a(this.f4384d, 15));
    }

    @Override // cn.jpush.android.u.e
    protected void a() {
        this.f4410r = (RoundedImageView) b("image");
        this.f4404l = (ImageView) b("img_bottom_close");
        this.f4403k = (ImageView) b("img_top_close");
        this.f4411s = (RoundedImageView) b("image_only");
        this.f4402j = (TextView) b("btn_two");
        this.f4401i = (TextView) b("btn_one");
        this.f4400h = (TextView) b("text_content");
        this.f4399g = (TextView) b("text_title");
        this.f4405m = b("content_view");
        this.f4409q = (FrameLayout) b("frame");
        this.f4406n = b("margeview");
        this.f4407o = b("bg_view");
        this.f4408p = b("btn_parent_view");
        this.f4400h.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f4400h.setMaxHeight(b(150));
    }

    @Override // cn.jpush.android.u.e
    protected String b() {
        return "jpush_interstitial";
    }

    @Override // cn.jpush.android.u.b
    public void c() {
        if (((e) this).f4413f != null) {
            ((e) this).f4413f = null;
        }
    }

    @Override // cn.jpush.android.u.b
    public void d() {
        int i4;
        JSONObject jSONObject;
        TextView textView;
        try {
            JSONObject jSONObject2 = new JSONObject(this.f4382b.f4132i);
            int a4 = a(30);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4409q.getLayoutParams();
            layoutParams.leftMargin = a4;
            layoutParams.rightMargin = a4;
            this.f4409q.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4403k.getLayoutParams();
            layoutParams2.rightMargin = a4;
            this.f4403k.setLayoutParams(layoutParams2);
            if (21 == this.f4385e) {
                this.f4411s.setVisibility(0);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f4411s.getLayoutParams();
                layoutParams3.width = a(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT);
                layoutParams3.height = b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP);
                this.f4411s.setLayoutParams(layoutParams3);
                this.f4410r.setRadius(45, 45, 45, 45);
                this.f4405m.setVisibility(8);
                if (jSONObject2.has("image")) {
                    a(this.f4411s, jSONObject2.getString("image"), jSONObject2.optJSONObject("click"), 1, a(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT), b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP));
                }
                i4 = 0;
            } else {
                this.f4411s.setVisibility(8);
                this.f4405m.setVisibility(0);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f4406n.getLayoutParams();
                layoutParams4.leftMargin = a(22);
                layoutParams4.rightMargin = a(21);
                this.f4406n.setLayoutParams(layoutParams4);
                if (jSONObject2.has("image")) {
                    String optString = jSONObject2.optString("image");
                    if (!TextUtils.isEmpty(optString)) {
                        this.f4410r.setVisibility(0);
                        i4 = 0;
                        a(this.f4410r, optString, jSONObject2.optJSONObject("click"), 1, a(22), a(22));
                        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f4410r.getLayoutParams();
                        layoutParams5.height = b(142);
                        layoutParams5.width = a(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT);
                        this.f4410r.setLayoutParams(layoutParams5);
                        this.f4410r.setRadius(45, 45, 0, 0);
                    }
                }
                i4 = 0;
                l();
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("interstitial");
            if (jSONObject3.has("title")) {
                JSONObject optJSONObject = jSONObject3.optJSONObject("title");
                if (optJSONObject == null) {
                    return;
                }
                this.f4399g.setVisibility(i4);
                a(this.f4399g, optJSONObject, -1);
            } else {
                this.f4399g.setVisibility(8);
            }
            if (jSONObject3.has("content")) {
                JSONObject optJSONObject2 = jSONObject3.optJSONObject("content");
                if (optJSONObject2 == null) {
                    return;
                }
                this.f4400h.setVisibility(i4);
                a(this.f4400h, optJSONObject2, -1);
            } else {
                this.f4400h.setVisibility(8);
            }
            if (jSONObject3.has("close_location")) {
                int optInt = jSONObject3.optInt("close_location", 1);
                ImageView imageView = null;
                if (optInt == 1) {
                    imageView = this.f4404l;
                } else if (optInt == 2) {
                    imageView = this.f4403k;
                }
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(i4);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.a(3, "", 2);
                    }
                });
            } else {
                this.f4404l.setVisibility(8);
                this.f4403k.setVisibility(8);
            }
            if (!jSONObject3.has("buttons")) {
                this.f4408p.setVisibility(8);
                return;
            }
            JSONArray optJSONArray = jSONObject3.optJSONArray("buttons");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f4408p.setVisibility(i4);
                if (optJSONArray.length() > 1) {
                    this.f4401i.setVisibility(i4);
                    a(this.f4401i, (JSONObject) optJSONArray.get(i4), 4);
                    jSONObject = (JSONObject) optJSONArray.get(1);
                    textView = this.f4402j;
                } else {
                    this.f4401i.setVisibility(8);
                    jSONObject = (JSONObject) optJSONArray.get(i4);
                    textView = this.f4402j;
                }
                a(textView, jSONObject, 5);
                return;
            }
            this.f4408p.setVisibility(8);
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "interstitial bindDataToView throwable=" + th);
        }
    }
}
