package cn.jpush.android.u;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.ui.RoundedImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends e {

    /* renamed from: g  reason: collision with root package name */
    private View f4371g;

    /* renamed from: h  reason: collision with root package name */
    private RoundedImageView f4372h;

    /* renamed from: i  reason: collision with root package name */
    private RoundedImageView f4373i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f4374j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f4375k;

    /* renamed from: l  reason: collision with root package name */
    private View f4376l;

    /* renamed from: m  reason: collision with root package name */
    private View f4377m;

    public a(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i4) {
        super(context, aVar, dVar, i4);
    }

    @Override // cn.jpush.android.u.e
    protected void a() {
        this.f4371g = b("banner_content");
        this.f4372h = (RoundedImageView) b("image_only");
        this.f4374j = (TextView) b("text_content");
        this.f4375k = (TextView) b("text_title");
        this.f4373i = (RoundedImageView) b("image_small");
        this.f4376l = b("banner");
        this.f4377m = b("bg_view");
    }

    @Override // cn.jpush.android.u.e
    protected String b() {
        return "jpush_banner";
    }

    @Override // cn.jpush.android.u.b
    public void c() {
    }

    @Override // cn.jpush.android.u.b
    public void d() {
        RoundedImageView roundedImageView;
        try {
            JSONObject jSONObject = new JSONObject(this.f4382b.f4132i);
            JSONObject optJSONObject = jSONObject.optJSONObject("click");
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4376l.getLayoutParams();
            layoutParams.leftMargin = a(14);
            layoutParams.width = a(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS);
            layoutParams.rightMargin = a(14);
            if (optJSONObject != null) {
                final int optInt = optJSONObject.optInt("type");
                final String optString = optJSONObject.optString("action");
                ((e) this).f4413f.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.a(optInt, optString, 1);
                    }
                });
            }
            if (11 == this.f4385e) {
                layoutParams.height = b(92);
                this.f4376l.setLayoutParams(layoutParams);
                this.f4377m.setVisibility(8);
                this.f4372h.setVisibility(0);
                String string = jSONObject.getString("image");
                this.f4372h.setRadius(45, 45, 45, 45);
                a(this.f4372h, string, null, -1, -1, -1);
                return;
            }
            this.f4377m.setVisibility(0);
            this.f4372h.setVisibility(8);
            this.f4376l.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4371g.getLayoutParams();
            layoutParams2.leftMargin = a(17);
            layoutParams2.rightMargin = a(19);
            layoutParams2.topMargin = b(15);
            layoutParams2.bottomMargin = b(12);
            this.f4371g.setLayoutParams(layoutParams2);
            JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
            if (jSONObject2.has("small_image")) {
                String optString2 = jSONObject2.optString("small_image");
                if (!TextUtils.isEmpty(optString2)) {
                    this.f4373i.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f4373i.getLayoutParams();
                    layoutParams3.width = a(42);
                    layoutParams3.height = a(42);
                    this.f4373i.setLayoutParams(layoutParams3);
                    this.f4373i.setRadius(0, 0, 0, 0);
                    a(this.f4373i, optString2, null, -1, -1, -1);
                    a(this.f4375k, jSONObject2.getJSONObject("title"), -1);
                    a(this.f4374j, jSONObject2.getJSONObject("content"), -1);
                }
                roundedImageView = this.f4373i;
            } else {
                roundedImageView = this.f4373i;
            }
            roundedImageView.setVisibility(8);
            a(this.f4375k, jSONObject2.getJSONObject("title"), -1);
            a(this.f4374j, jSONObject2.getJSONObject("content"), -1);
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "banner bindDataToView throwable=" + th);
        }
    }
}
