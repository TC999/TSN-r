package com.kwad.components.p208ad.reward.p264n;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.n.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8072p extends AbstractC8075s implements View.OnClickListener {

    /* renamed from: qo */
    private C7907g f26923qo;

    /* renamed from: zS */
    private ImageView f26924zS;

    /* renamed from: zT */
    private TextView f26925zT;

    /* renamed from: zU */
    private TextView f26926zU;

    /* renamed from: zV */
    private TextView f26927zV;

    /* renamed from: zW */
    private TextView f26928zW;

    /* renamed from: zX */
    private TextView f26929zX;

    /* renamed from: zY */
    private TextView f26930zY;

    /* renamed from: zZ */
    private TextView f26931zZ;

    public View$OnClickListenerC8072p(C7907g c7907g) {
        this.f26923qo = c7907g;
    }

    /* renamed from: b */
    private void m31650b(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        KSImageLoader.loadCircleIcon(this.f26924zS, C10483a.m25820cf(m25641dQ), this.f26924zS.getResources().getDrawable(C9659R.C9661drawable.ksad_ic_default_user_avatar));
        this.f26925zT.setText(C10483a.m25823cc(m25641dQ));
    }

    private void initView() {
        ViewGroup viewGroup = this.f26932sz;
        if (viewGroup == null) {
            return;
        }
        this.f26924zS = (ImageView) viewGroup.findViewById(C9659R.C9662id.ksad_live_end_page_author_icon);
        this.f26925zT = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_author_name_txt);
        this.f26926zU = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_live_end_detail_watch_person_count);
        this.f26927zV = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_live_end_detail_like_person_count);
        this.f26928zW = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_live_end_detail_watch_time);
        this.f26929zX = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_live_end_bottom_title);
        this.f26930zY = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_live_end_bottom_action_btn);
        this.f26931zZ = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_live_end_bottom_des_btn);
        this.f26930zY.setOnClickListener(this);
        this.f26931zZ.setOnClickListener(this);
    }

    /* renamed from: m */
    private static String m31648m(long j) {
        long j2 = j / C7193bi.f24584s;
        long j3 = (j / 60000) - (j2 * 60);
        long j4 = ((j / 1000) - (60 * j3)) - (3600 * j2);
        return j2 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)) : String.format("%02d:%02d", Long.valueOf(j3), Long.valueOf(j4));
    }

    /* renamed from: T */
    public final void m31653T(int i) {
        TextView textView = this.f26929zX;
        if (textView == null || i <= 0) {
            return;
        }
        if (this.f26923qo.f26544oY) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i));
            SpannableString spannableString = new SpannableString(format);
            int color = mo31643gF().getResources().getColor(C9659R.C9660color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.f26929zX.setText(spannableString);
            return;
        }
        textView.setText("已获得奖励");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        m31650b(c8074r.getAdTemplate());
    }

    /* renamed from: h */
    public final void m31649h(ViewGroup viewGroup) {
        super.m31644a(viewGroup, C9659R.C9662id.ksad_reward_origin_live_end_page_stub, C9659R.C9662id.ksad_live_end_page_layout_root);
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C9913b c9913b = new C9913b();
        c9913b.m27257cT(24);
        if (view.equals(this.f26930zY)) {
            this.f26923qo.m32058a(2, view.getContext(), 38, 1, 0L, false, c9913b);
        } else if (view.equals(this.f26931zZ)) {
            this.f26923qo.m32058a(2, view.getContext(), 37, 1, 0L, false, c9913b);
        }
    }

    /* renamed from: a */
    public final void m31652a(C7907g c7907g, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j) {
        this.f26927zV.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.f26928zW.setText(m31648m(adLivePushEndInfo.mLiveDuration));
        this.f26926zU.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (c7907g.f26544oY) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(C10483a.m25929ag(C10487e.m25641dQ(c7907g.mAdTemplate)) - j, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(format);
            int color = mo31643gF().getResources().getColor(C9659R.C9660color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.f26929zX.setText(spannableString);
            return;
        }
        this.f26929zX.setText("内容很精彩，不要错过哦");
    }
}
