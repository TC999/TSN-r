package com.kwad.components.p208ad.reward;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p330s.C8946i;
import com.kwad.components.core.proxy.AbstractDialogFragmentC8890g;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p260l.AbstractC8004a;
import com.kwad.components.p208ad.reward.p260l.p261a.C8005a;
import com.kwad.components.p208ad.reward.p260l.p262b.C8009a;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8058j;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8064m;
import com.kwad.components.p208ad.reward.widget.RewardTaskStepView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogFragmentC7931h extends AbstractDialogFragmentC8890g {

    /* renamed from: pQ */
    private static String f26622pQ = "进阶奖励还差 %s 步到手，\n确认放弃吗？";

    /* renamed from: pR */
    private static String f26623pR = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;

    /* renamed from: pP */
    private InterfaceC7942a f26624pP;

    /* renamed from: com.kwad.components.ad.reward.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7942a extends InterfaceC9291c {
        /* renamed from: fY */
        void mo31452fY();

        /* renamed from: g */
        void mo31451g(int i, int i2);
    }

    /* renamed from: com.kwad.components.ad.reward.h$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7943b implements InterfaceC7942a {
        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: F */
        public void mo29100F(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: fR */
        public void mo29099fR() {
        }

        @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.InterfaceC7942a
        /* renamed from: fY */
        public void mo31452fY() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: fZ */
        public void mo29098fZ() {
        }

        @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.InterfaceC7942a
        /* renamed from: g */
        public void mo31451g(int i, int i2) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: ga */
        public void mo29097ga() {
        }
    }

    /* renamed from: a */
    public static C7944c m31973a(C7907g c7907g, @Nullable String str) {
        int i;
        AdTemplate adTemplate = c7907g.mAdTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C8009a c8009a = c7907g.f26568pq;
        C8005a c8005a = c7907g.f26569pr;
        int i2 = c7907g.f26570ps;
        boolean m25624i = C10487e.m25624i(adTemplate, C7844b.m32176k(C10487e.m25641dQ(adTemplate)));
        int i3 = 0;
        if (m25624i || C10487e.m25654F(adTemplate)) {
            int m25932ad = (int) C10483a.m25932ad(m25641dQ);
            int m25976L = C10483a.m25976L(m25641dQ);
            if (m25932ad > m25976L) {
                m25932ad = m25976L;
            }
            long playDuration = c7907g.f26529oJ.getPlayDuration();
            if (playDuration < (m25932ad * 1000) - 800 && (i = (int) (m25932ad - ((((float) playDuration) / 1000.0f) + 0.5f))) >= 0) {
                i3 = i;
            }
        }
        if (m25624i && c8009a != null) {
            return C7944c.m31959a(c8009a, adTemplate, String.valueOf(i3));
        }
        if (C10487e.m25654F(adTemplate) && c8005a != null) {
            return C7944c.m31960a(c8005a, adTemplate, String.valueOf(i3));
        }
        if (C7844b.m32178i(m25641dQ)) {
            return C7944c.m31947h(m25641dQ);
        }
        if (C10483a.m25825cb(m25641dQ) == 1 && C7844b.m32179gz() == 1) {
            return C7944c.m31958a(m25641dQ, i2);
        }
        if (adTemplate.isNativeRewardPreview) {
            return C7944c.m31946i(str, i2);
        }
        if (C10483a.m25842cL(m25641dQ)) {
            return C7944c.m31957b(adTemplate, i2);
        }
        if (C10483a.m25824cb(adTemplate)) {
            return C7944c.m31956c(adTemplate, i2);
        }
        if (C7844b.m32185gt() == 1) {
            return C7944c.m31945j(i2);
        }
        return C7944c.m31944y(str);
    }

    /* renamed from: b */
    private static View m31969b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, C7944c c7944c, AdTemplate adTemplate, InterfaceC7942a interfaceC7942a) {
        return m31970a(c7944c.m31952ge(), dialogFragment, layoutInflater, viewGroup, c7944c, adTemplate, interfaceC7942a);
    }

    /* renamed from: c */
    private static View m31968c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, C7944c c7944c, AdTemplate adTemplate, final InterfaceC7942a interfaceC7942a) {
        View inflate = layoutInflater.inflate(C9659R.C9663layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(C9659R.C9662id.ksad_reward_order_dialog_icon), c7944c.f26651qa, adTemplate);
        ((TextView) inflate.findViewById(C9659R.C9662id.ksad_reward_order_dialog_desc)).setText(c7944c.getTitle());
        inflate.findViewById(C9659R.C9662id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29097ga();
                }
            }
        });
        inflate.findViewById(C9659R.C9662id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterfaceC7942a interfaceC7942a2 = InterfaceC7942a.this;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo31452fY();
                }
            }
        });
        inflate.findViewById(C9659R.C9662id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29100F(false);
                }
            }
        });
        return inflate;
    }

    /* renamed from: e */
    private static SpannableString m31967e(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        int i = C9659R.C9660color.ksad_reward_main_color;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(C10751a.getColor(context, i));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(C10751a.getColor(context, i));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    /* renamed from: h */
    public static C7944c m31966h(String str, int i) {
        return C7944c.m31946i(str, i);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        InterfaceC7942a interfaceC7942a = this.f26624pP;
        if (interfaceC7942a != null) {
            interfaceC7942a.mo29099fR();
        }
    }

    @KsJson
    /* renamed from: com.kwad.components.ad.reward.h$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7944c extends C10482a {

        /* renamed from: pW */
        public String f26645pW;

        /* renamed from: pX */
        public String f26646pX;

        /* renamed from: pY */
        public String f26647pY;

        /* renamed from: pZ */
        public String f26648pZ;

        /* renamed from: pq */
        public C8009a f26649pq;

        /* renamed from: pr */
        public C8005a f26650pr;

        /* renamed from: qa */
        public String f26651qa;

        /* renamed from: qb */
        public String f26652qb;

        /* renamed from: qc */
        public String f26653qc;

        /* renamed from: qd */
        public String f26654qd;
        public int style;
        public String title;

        private C7944c() {
        }

        /* renamed from: A */
        private void m31961A(String str) {
            this.f26654qd = str;
        }

        /* renamed from: a */
        static C7944c m31959a(C8009a c8009a, AdTemplate adTemplate, String str) {
            C7944c c7944c = new C7944c();
            c7944c.style = 1;
            c7944c.f26649pq = c8009a;
            c7944c.f26648pZ = str;
            c7944c.f26651qa = C10483a.m25820cf(C10487e.m25641dQ(adTemplate));
            return c7944c;
        }

        /* renamed from: b */
        static C7944c m31957b(AdTemplate adTemplate, long j) {
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            C7944c c7944c = new C7944c();
            c7944c.style = 8;
            c7944c.f26651qa = C10483a.m25820cf(m25641dQ);
            c7944c.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            c7944c.f26652qb = C10483a.m25823cc(m25641dQ);
            c7944c.f26653qc = C10483a.m25915au(m25641dQ);
            c7944c.f26645pW = "放弃奖励";
            c7944c.f26646pX = "继续观看";
            c7944c.f26647pY = C10483a.m25957aE(C10487e.m25641dQ(adTemplate));
            return c7944c;
        }

        /* renamed from: c */
        static C7944c m31956c(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo m25717db = C10484b.m25717db(adTemplate);
            C7944c c7944c = new C7944c();
            c7944c.style = 8;
            c7944c.f26651qa = m25717db.userHeadUrl;
            c7944c.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            c7944c.f26652qb = m25717db.title;
            c7944c.f26645pW = "放弃奖励";
            c7944c.f26646pX = "继续观看";
            c7944c.f26647pY = C10483a.m25957aE(C10487e.m25641dQ(adTemplate));
            return c7944c;
        }

        /* renamed from: h */
        static C7944c m31947h(AdInfo adInfo) {
            C7944c c7944c = new C7944c();
            c7944c.style = 4;
            AdProductInfo m25838cP = C10483a.m25838cP(adInfo);
            c7944c.title = C10483a.m25915au(adInfo);
            c7944c.f26651qa = m25838cP.getIcon();
            return c7944c;
        }

        /* renamed from: i */
        public static C7944c m31946i(String str, int i) {
            C7944c c7944c = new C7944c();
            c7944c.style = 6;
            c7944c.title = str;
            c7944c.f26645pW = "残忍离开";
            c7944c.f26646pX = "留下看看";
            if (i > 0) {
                c7944c.f26654qd = String.valueOf(i);
            }
            return c7944c;
        }

        /* renamed from: j */
        static C7944c m31945j(long j) {
            C7944c c7944c = new C7944c();
            c7944c.style = 6;
            c7944c.f26645pW = "残忍离开";
            c7944c.f26646pX = "留下看看";
            if (j > 0) {
                c7944c.m31961A(String.valueOf(j));
            } else {
                c7944c.m31961A(null);
            }
            return c7944c;
        }

        /* renamed from: y */
        static C7944c m31944y(String str) {
            C7944c c7944c = new C7944c();
            c7944c.style = 0;
            c7944c.title = str;
            c7944c.f26645pW = "关闭广告";
            c7944c.f26646pX = "继续观看";
            return c7944c;
        }

        /* renamed from: z */
        public static C7944c m31943z(String str) {
            C7944c c7944c = new C7944c();
            try {
                c7944c.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return c7944c;
        }

        @Override // com.kwad.sdk.core.response.p408a.C10482a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.f26649pq == null) {
                    this.f26649pq = new C8009a();
                }
                this.f26649pq.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.f26650pr == null) {
                    this.f26650pr = new C8005a();
                }
                this.f26650pr.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.p408a.C10482a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            C8009a c8009a = this.f26649pq;
            if (c8009a != null) {
                C11126t.m23678a(jSONObject, "mLaunchAppTask", c8009a);
            }
            C8005a c8005a = this.f26650pr;
            if (c8005a != null) {
                C11126t.m23678a(jSONObject, "mLandPageOpenTask", c8005a);
            }
        }

        /* renamed from: gb */
        public final String m31955gb() {
            return TextUtils.isEmpty(this.f26645pW) ? "关闭广告" : this.f26645pW;
        }

        /* renamed from: gc */
        public final String m31954gc() {
            return TextUtils.isEmpty(this.f26646pX) ? "继续观看" : this.f26646pX;
        }

        /* renamed from: gd */
        public final C8009a m31953gd() {
            return this.f26649pq;
        }

        /* renamed from: ge */
        public final C8005a m31952ge() {
            return this.f26650pr;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        /* renamed from: gf */
        public final String m31951gf() {
            return this.f26651qa;
        }

        /* renamed from: gg */
        public final String m31950gg() {
            return this.f26652qb;
        }

        /* renamed from: gh */
        public final String m31949gh() {
            return this.f26653qc;
        }

        /* renamed from: gi */
        public final String m31948gi() {
            return TextUtils.isEmpty(this.f26654qd) ? "" : String.format("再看%s秒，可获得优惠", this.f26654qd);
        }

        /* renamed from: a */
        static C7944c m31960a(C8005a c8005a, AdTemplate adTemplate, String str) {
            C7944c c7944c = new C7944c();
            c7944c.style = 2;
            c7944c.f26650pr = c8005a;
            c7944c.f26648pZ = str;
            c7944c.f26651qa = C10483a.m25820cf(C10487e.m25641dQ(adTemplate));
            return c7944c;
        }

        /* renamed from: a */
        public static C7944c m31958a(AdInfo adInfo, long j) {
            C7944c c7944c = new C7944c();
            c7944c.style = 5;
            AdProductInfo m25838cP = C10483a.m25838cP(adInfo);
            c7944c.f26652qb = C10483a.m25915au(adInfo);
            String name = m25838cP.getName();
            c7944c.title = name;
            if (TextUtils.isEmpty(name)) {
                c7944c.title = C10483a.m25912ax(adInfo);
            }
            c7944c.f26651qa = m25838cP.getIcon();
            if (j > 0) {
                c7944c.m31961A(String.valueOf(j));
            } else {
                c7944c.m31961A(null);
            }
            return c7944c;
        }
    }

    /* renamed from: a */
    public static DialogFragmentC7931h m31976a(Activity activity, AdTemplate adTemplate, C7944c c7944c, InterfaceC7942a interfaceC7942a) {
        DialogFragmentC7931h dialogFragmentC7931h = new DialogFragmentC7931h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", c7944c.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        dialogFragmentC7931h.setArguments(bundle);
        dialogFragmentC7931h.m31972a(interfaceC7942a);
        dialogFragmentC7931h.show(activity.getFragmentManager(), "videoCloseDialog");
        return dialogFragmentC7931h;
    }

    /* renamed from: a */
    private void m31972a(InterfaceC7942a interfaceC7942a) {
        this.f26624pP = interfaceC7942a;
    }

    @Override // com.kwad.components.core.proxy.AbstractDialogFragmentC8890g
    @Nullable
    /* renamed from: a */
    public final View mo29154a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View m31974a;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        C7944c m31943z = C7944c.m31943z(string);
        int style = m31943z.getStyle();
        if (style == 1) {
            m31974a = m31974a(this, layoutInflater, viewGroup, m31943z, this.mAdTemplate, this.f26624pP);
        } else if (style == 2) {
            m31974a = m31969b(this, layoutInflater, viewGroup, m31943z, this.mAdTemplate, this.f26624pP);
        } else if (style == 4) {
            m31974a = m31968c(this, layoutInflater, viewGroup, m31943z, this.mAdTemplate, this.f26624pP);
            C8946i.m29551a(new C9374e(), (ViewGroup) m31974a);
        } else if (style == 5) {
            View$OnClickListenerC8058j view$OnClickListenerC8058j = new View$OnClickListenerC8058j(this, this.mAdTemplate, layoutInflater, viewGroup, this.f26624pP);
            view$OnClickListenerC8058j.m31685a(m31943z);
            m31974a = view$OnClickListenerC8058j.mo31643gF();
        } else if (style == 6) {
            m31974a = m31971a(this, layoutInflater, viewGroup, m31943z, this.f26624pP);
        } else if (style != 8) {
            m31974a = m31975a((DialogFragment) this, layoutInflater, viewGroup, m31943z, this.f26624pP);
        } else {
            View$OnClickListenerC8064m view$OnClickListenerC8064m = new View$OnClickListenerC8064m(this, this.mAdTemplate, layoutInflater, viewGroup, this.f26624pP);
            view$OnClickListenerC8064m.m31669a(m31943z);
            m31974a = view$OnClickListenerC8064m.mo31643gF();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return m31974a;
    }

    /* renamed from: a */
    private static View m31975a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, C7944c c7944c, final InterfaceC7942a interfaceC7942a) {
        View inflate = layoutInflater.inflate(C9659R.C9663layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(C9659R.C9662id.ksad_title)).setText(c7944c.getTitle());
        TextView textView = (TextView) inflate.findViewById(C9659R.C9662id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(C9659R.C9662id.ksad_continue_btn);
        textView.setText(c7944c.m31955gb());
        textView2.setText(c7944c.m31954gc());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29100F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29097ga();
                }
            }
        });
        return inflate;
    }

    /* renamed from: a */
    private View m31971a(final DialogFragmentC7931h dialogFragmentC7931h, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, C7944c c7944c, final InterfaceC7942a interfaceC7942a) {
        View inflate = layoutInflater.inflate(C9659R.C9663layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(C9659R.C9662id.ksad_reward_close_extend_dialog_play_time_tips)).setText(m31967e(inflate.getContext(), c7944c.f26654qd));
        TextView textView = (TextView) inflate.findViewById(C9659R.C9662id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) inflate.findViewById(C9659R.C9662id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(c7944c.m31955gb());
        textView2.setText(c7944c.m31954gc());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragmentC7931h.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29100F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragmentC7931h.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29097ga();
                }
            }
        });
        return inflate;
    }

    /* renamed from: a */
    private static View m31970a(AbstractC8004a abstractC8004a, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, C7944c c7944c, AdTemplate adTemplate, final InterfaceC7942a interfaceC7942a) {
        String format;
        int i;
        View inflate = layoutInflater.inflate(C9659R.C9663layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (abstractC8004a instanceof C8009a) {
            C8009a.m31878a((C8009a) abstractC8004a, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(C9659R.C9662id.ksad_reward_task_dialog_steps)).m30966a(abstractC8004a.mo31870jq(), c7944c.f26648pZ);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(C9659R.C9662id.ksad_reward_task_dialog_icon), c7944c.m31951gf(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(C9659R.C9662id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(C9659R.C9662id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(C9659R.C9662id.ksad_reward_task_dialog_title);
        StringBuilder sb = new StringBuilder();
        sb.append(abstractC8004a.mo31869jr());
        String sb2 = sb.toString();
        String str = c7944c.f26648pZ;
        boolean equals = "0".equals(str);
        if (equals) {
            format = String.format(f26622pQ, sb2);
        } else {
            format = String.format(f26623pR, str);
        }
        int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            if (equals) {
                i = indexOf + 1;
            } else {
                i = str.length() > 1 ? indexOf + 3 : indexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(C9659R.C9660color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29100F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                InterfaceC7942a interfaceC7942a2 = interfaceC7942a;
                if (interfaceC7942a2 != null) {
                    interfaceC7942a2.mo29097ga();
                }
            }
        });
        return inflate;
    }

    /* renamed from: a */
    private static View m31974a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, C7944c c7944c, AdTemplate adTemplate, InterfaceC7942a interfaceC7942a) {
        return m31970a(c7944c.m31953gd(), dialogFragment, layoutInflater, viewGroup, c7944c, adTemplate, interfaceC7942a);
    }
}
