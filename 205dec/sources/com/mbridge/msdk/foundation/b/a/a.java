package com.mbridge.msdk.foundation.b.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.mbridge.msdk.c.a;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: FeedBackBtnBean.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: t  reason: collision with root package name */
    private static int f39038t = -1;

    /* renamed from: y  reason: collision with root package name */
    private static String f39039y;

    /* renamed from: a  reason: collision with root package name */
    private String f39040a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f39041b;

    /* renamed from: c  reason: collision with root package name */
    private FeedBackButton f39042c;

    /* renamed from: d  reason: collision with root package name */
    private int f39043d;

    /* renamed from: e  reason: collision with root package name */
    private int f39044e;

    /* renamed from: k  reason: collision with root package name */
    private JSONArray f39050k;

    /* renamed from: p  reason: collision with root package name */
    private String f39055p;

    /* renamed from: q  reason: collision with root package name */
    private String f39056q;

    /* renamed from: v  reason: collision with root package name */
    private MBFeedBackDialog f39060v;

    /* renamed from: w  reason: collision with root package name */
    private List<C0736a> f39061w;

    /* renamed from: f  reason: collision with root package name */
    private int f39045f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f39046g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f39047h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f39048i = -1;

    /* renamed from: j  reason: collision with root package name */
    private float f39049j = -1.0f;

    /* renamed from: l  reason: collision with root package name */
    private int f39051l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f39052m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f39053n = -1;

    /* renamed from: o  reason: collision with root package name */
    private int f39054o = -1;

    /* renamed from: r  reason: collision with root package name */
    private float f39057r = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    private int f39058s = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 20.0f);

    /* renamed from: u  reason: collision with root package name */
    private int f39059u = f39038t;

    /* renamed from: x  reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f39062x = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.b.a.a.1
        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            a.a(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            a.b(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
            a.c(a.this);
        }
    };

    public a(String str) {
        this.f39061w = new ArrayList();
        this.f39040a = str;
        if (this.f39061w == null) {
            this.f39061w = new ArrayList();
        }
        i();
        l();
        j();
    }

    private void i() {
        if (this.f39062x == null) {
            this.f39062x = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.b.a.a.2
                @Override // com.mbridge.msdk.widget.dialog.a
                public final void a() {
                    a.a(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void b() {
                    a.b(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void c() {
                    a.c(a.this);
                }
            };
        }
    }

    private void j() {
        try {
            if (b.a().a(com.mbridge.msdk.foundation.controller.a.f().j()) != null) {
                com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                if (b4 == null) {
                    b4 = com.mbridge.msdk.c.b.a().b();
                }
                a.b aJ = b4.aJ();
                if (aJ == null) {
                    x.b("", "feedback fbk is null");
                    return;
                }
                i();
                this.f39060v = new MBFeedBackDialog(b.a().a(com.mbridge.msdk.foundation.controller.a.f().j()), this.f39062x);
                FeedbackRadioGroup a4 = a(aJ);
                this.f39060v.setCancelText(aJ.c());
                this.f39060v.setConfirmText(aJ.b());
                this.f39060v.setTitle(aJ.a());
                this.f39060v.setContent(a4);
                this.f39060v.setCancelButtonClickable(!TextUtils.isEmpty(f39039y));
                a(a4, aJ);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void k() {
        FeedBackButton feedBackButton = this.f39042c;
        if (feedBackButton != null) {
            int i4 = this.f39045f;
            if (i4 > -1) {
                feedBackButton.setX(i4);
            }
            int i5 = this.f39046g;
            if (i5 > -1) {
                this.f39042c.setY(i5);
            }
            float f4 = this.f39057r;
            if (f4 >= 0.0f) {
                this.f39042c.setAlpha(f4);
                this.f39042c.setEnabled(this.f39057r != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.f39042c.getLayoutParams();
            int i6 = this.f39047h;
            if (i6 > 0) {
                this.f39042c.setWidth(i6);
                if (layoutParams != null) {
                    layoutParams.width = this.f39047h;
                }
            }
            int i7 = this.f39048i;
            if (i7 > 0) {
                this.f39042c.setHeight(i7);
                if (layoutParams != null) {
                    layoutParams.height = this.f39048i;
                }
            }
            if (layoutParams != null) {
                this.f39042c.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.f39055p)) {
                    this.f39042c.setTextColor(Color.parseColor(this.f39055p));
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            float f5 = this.f39049j;
            if (f5 > 0.0f) {
                this.f39042c.setTextSize(f5);
            }
            JSONArray jSONArray = this.f39050k;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                this.f39042c.setPadding(ac.b(j4, (float) this.f39050k.optDouble(0)), ac.b(j4, (float) this.f39050k.optDouble(1)), ac.b(j4, (float) this.f39050k.optDouble(2)), ac.b(j4, (float) this.f39050k.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i8 = this.f39058s;
            if (i8 > 0) {
                gradientDrawable.setCornerRadius(i8);
            }
            if (!TextUtils.isEmpty(this.f39056q)) {
                gradientDrawable.setColor(Color.parseColor(this.f39056q));
            } else {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            }
            this.f39042c.setBackground(gradientDrawable);
        }
    }

    private void l() {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (j4 != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(j4);
                this.f39042c = feedBackButton;
                int i4 = 8;
                if (this.f39059u != 8) {
                    i4 = 0;
                }
                feedBackButton.setVisibility(i4);
                this.f39042c.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.b.a.a.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.this.a();
                    }
                });
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void b() {
        MBFeedBackDialog mBFeedBackDialog = this.f39060v;
        if (mBFeedBackDialog == null || !mBFeedBackDialog.isShowing()) {
            return;
        }
        this.f39060v.cancel();
    }

    public final FeedBackButton c() {
        if (this.f39042c == null) {
            l();
        }
        return this.f39042c;
    }

    public final CampaignEx e() {
        return this.f39041b;
    }

    public final int f() {
        return this.f39043d;
    }

    public final int g() {
        return this.f39044e;
    }

    public final void a() {
        b.a().a(this.f39040a, 0, 1, f39039y);
        Activity a4 = b.a().a(com.mbridge.msdk.foundation.controller.a.f().j());
        MBFeedBackDialog mBFeedBackDialog = this.f39060v;
        if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != a4) {
            j();
        }
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        FeedBackButton feedBackButton = this.f39042c;
        if (feedBackButton != null) {
            j4 = feedBackButton.getContext();
        }
        int i4 = b.a().a(this.f39040a, j4, this.f39060v) ? 2 : 3;
        if (i4 == 2) {
            b.a().a(this.f39040a, 0, 2, f39039y);
        } else {
            b.a().a(this.f39040a, 0, 3, f39039y);
        }
        List<C0736a> list = this.f39061w;
        if (list != null) {
            for (C0736a c0736a : list) {
                if (c0736a != null) {
                    c0736a.a(i4);
                }
            }
        }
    }

    public final void d() {
        FeedBackButton feedBackButton = this.f39042c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.f39042c.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.f39042c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f39042c);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.f39060v;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.f39060v.setListener(null);
        }
        this.f39060v = null;
        this.f39061w = null;
        this.f39042c = null;
        this.f39062x = null;
    }

    /* compiled from: FeedBackBtnBean.java */
    /* renamed from: com.mbridge.msdk.foundation.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0736a implements com.mbridge.msdk.widget.dialog.a {

        /* renamed from: a  reason: collision with root package name */
        private com.mbridge.msdk.foundation.b.a f39068a;

        /* renamed from: b  reason: collision with root package name */
        private String f39069b;

        public C0736a(String str, com.mbridge.msdk.foundation.b.a aVar) {
            this.f39068a = aVar;
            this.f39069b = str;
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            b.f39072c = false;
            com.mbridge.msdk.foundation.b.a aVar = this.f39068a;
            if (aVar != null) {
                aVar.a(a.f39039y);
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            b.f39072c = false;
            com.mbridge.msdk.foundation.b.a aVar = this.f39068a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
        }

        public final void a(int i4) {
            b.f39072c = true;
            com.mbridge.msdk.foundation.b.a aVar = this.f39068a;
            if (aVar == null || i4 != 2) {
                return;
            }
            aVar.a();
        }
    }

    public final void b(int i4) {
        this.f39043d = i4;
    }

    static /* synthetic */ void b(a aVar) {
        b.a().a(aVar.f39040a, 0, 4, f39039y);
        List<C0736a> list = aVar.f39061w;
        if (list != null) {
            for (C0736a c0736a : list) {
                if (c0736a != null) {
                    c0736a.b();
                }
            }
        }
        f39039y = "";
    }

    public final void c(int i4) {
        this.f39044e = i4;
    }

    static /* synthetic */ void c(a aVar) {
        List<C0736a> list = aVar.f39061w;
        if (list != null) {
            for (C0736a c0736a : list) {
                if (c0736a != null) {
                    c0736a.c();
                }
            }
        }
    }

    public final void a(int i4) {
        this.f39059u = i4;
        FeedBackButton feedBackButton = this.f39042c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.mbridge.msdk.widget.FeedbackRadioGroup r12, com.mbridge.msdk.c.a.b r13) {
        /*
            r11 = this;
            org.json.JSONArray r13 = r13.d()
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.f()
            android.content.Context r0 = r0.j()
            if (r13 == 0) goto L7e
            int r1 = r13.length()
            if (r1 <= 0) goto L7e
            if (r0 == 0) goto L7e
            java.lang.String r1 = "mbridge_cm_feedback_choice_btn_bg"
            java.lang.String r2 = "drawable"
            int r1 = com.mbridge.msdk.foundation.tools.r.a(r0, r1, r2)
            android.content.res.Resources r2 = com.mbridge.msdk.foundation.tools.r.a(r0)
            java.lang.String r3 = "mbridge_cm_feedback_rb_text_color_color_list"
            java.lang.String r4 = "color"
            int r3 = com.mbridge.msdk.foundation.tools.r.a(r0, r3, r4)
            r4 = 0
            if (r2 == 0) goto L36
            android.content.res.ColorStateList r2 = r2.getColorStateList(r3)     // Catch: java.lang.Exception -> L32
            goto L37
        L32:
            r2 = move-exception
            r2.printStackTrace()
        L36:
            r2 = r4
        L37:
            r3 = 1096810496(0x41600000, float:14.0)
            int r3 = com.mbridge.msdk.foundation.tools.ac.b(r0, r3)
            r5 = 1088421888(0x40e00000, float:7.0)
            int r5 = com.mbridge.msdk.foundation.tools.ac.b(r0, r5)
            r6 = 1086324736(0x40c00000, float:6.0)
            int r6 = com.mbridge.msdk.foundation.tools.ac.b(r0, r6)
            r7 = 0
        L4a:
            int r8 = r13.length()
            if (r7 >= r8) goto L7e
            java.lang.String r8 = r13.optString(r7)
            android.widget.RadioButton r9 = new android.widget.RadioButton
            r9.<init>(r0)
            r9.setButtonDrawable(r4)
            r9.setBackgroundResource(r1)
            r9.setText(r8)
            if (r2 == 0) goto L67
            r9.setTextColor(r2)
        L67:
            r9.setPadding(r3, r5, r3, r5)
            android.widget.RadioGroup$LayoutParams r8 = new android.widget.RadioGroup$LayoutParams
            r10 = -2
            r8.<init>(r10, r10)
            int r10 = r6 / 4
            r8.setMargins(r6, r10, r6, r10)
            r11.a(r9)
            r12.addView(r9, r8)
            int r7 = r7 + 1
            goto L4a
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.b.a.a.a(com.mbridge.msdk.widget.FeedbackRadioGroup, com.mbridge.msdk.c.a$b):void");
    }

    private FeedbackRadioGroup a(a.b bVar) {
        JSONArray d4 = bVar.d();
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (d4 == null || d4.length() <= 0 || j4 == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(j4);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mbridge.msdk.foundation.b.a.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    if (z3) {
                        String unused = a.f39039y = (String) compoundButton.getText();
                    }
                    if (a.this.f39060v != null) {
                        a.this.f39060v.setCancelButtonClickable(!TextUtils.isEmpty(a.f39039y));
                    }
                }
            });
        }
    }

    public final void a(C0736a c0736a) {
        if (this.f39061w == null) {
            this.f39061w = new ArrayList();
        }
        this.f39061w.add(c0736a);
    }

    public final void a(int i4, int i5, int i6, int i7, int i8, float f4, String str, String str2, float f5, JSONArray jSONArray) {
        if (i4 > -1) {
            this.f39045f = i4;
        }
        if (i5 > -1) {
            this.f39046g = i5;
        }
        if (i6 > -1) {
            this.f39047h = i6;
        }
        if (i7 > -1) {
            this.f39048i = i7;
        }
        if (f5 > -1.0f) {
            this.f39049j = f5;
        }
        if (jSONArray != null) {
            this.f39050k = jSONArray;
        }
        this.f39055p = str;
        this.f39056q = str2;
        this.f39057r = f4;
        this.f39058s = i8;
        k();
    }

    public final void a(CampaignEx campaignEx) {
        this.f39041b = campaignEx;
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.f39042c;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f39057r);
            feedBackButton.setEnabled(this.f39057r != 0.0f);
            feedBackButton.setVisibility(this.f39059u != 8 ? 0 : 8);
            this.f39042c = feedBackButton;
            CampaignEx campaignEx = this.f39041b;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                k();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.b.a.a.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.this.a();
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar) {
        b.a().a(aVar.f39040a, 1, 4, f39039y);
        List<C0736a> list = aVar.f39061w;
        if (list != null) {
            for (C0736a c0736a : list) {
                if (c0736a != null) {
                    c0736a.a();
                }
            }
        }
        f39039y = "";
    }
}
