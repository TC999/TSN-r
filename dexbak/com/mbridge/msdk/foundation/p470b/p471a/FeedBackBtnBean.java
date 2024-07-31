package com.mbridge.msdk.foundation.p470b.p471a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener;
import com.mbridge.msdk.foundation.p470b.FeedbackManager;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBAlertDialogListener;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.mbridge.msdk.foundation.b.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class FeedBackBtnBean {

    /* renamed from: t */
    private static int f30211t = -1;

    /* renamed from: y */
    private static String f30212y;

    /* renamed from: a */
    private String f30213a;

    /* renamed from: b */
    private CampaignEx f30214b;

    /* renamed from: c */
    private FeedBackButton f30215c;

    /* renamed from: d */
    private int f30216d;

    /* renamed from: e */
    private int f30217e;

    /* renamed from: k */
    private JSONArray f30223k;

    /* renamed from: p */
    private String f30228p;

    /* renamed from: q */
    private String f30229q;

    /* renamed from: v */
    private MBFeedBackDialog f30233v;

    /* renamed from: w */
    private List<C11258a> f30234w;

    /* renamed from: f */
    private int f30218f = -1;

    /* renamed from: g */
    private int f30219g = -1;

    /* renamed from: h */
    private int f30220h = -1;

    /* renamed from: i */
    private int f30221i = -1;

    /* renamed from: j */
    private float f30222j = -1.0f;

    /* renamed from: l */
    private int f30224l = -1;

    /* renamed from: m */
    private int f30225m = -1;

    /* renamed from: n */
    private int f30226n = -1;

    /* renamed from: o */
    private int f30227o = -1;

    /* renamed from: r */
    private float f30230r = 1.0f;

    /* renamed from: s */
    private int f30231s = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 20.0f);

    /* renamed from: u */
    private int f30232u = f30211t;

    /* renamed from: x */
    private MBAlertDialogListener f30235x = new MBAlertDialogListener() { // from class: com.mbridge.msdk.foundation.b.a.a.1
        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
        /* renamed from: a */
        public final void mo20509a() {
            FeedBackBtnBean.m22929a(FeedBackBtnBean.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
        /* renamed from: b */
        public final void mo20508b() {
            FeedBackBtnBean.m22922b(FeedBackBtnBean.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
        /* renamed from: c */
        public final void mo20507c() {
            FeedBackBtnBean.m22919c(FeedBackBtnBean.this);
        }
    };

    public FeedBackBtnBean(String str) {
        this.f30234w = new ArrayList();
        this.f30213a = str;
        if (this.f30234w == null) {
            this.f30234w = new ArrayList();
        }
        m22912i();
        m22909l();
        m22911j();
    }

    /* renamed from: i */
    private void m22912i() {
        if (this.f30235x == null) {
            this.f30235x = new MBAlertDialogListener() { // from class: com.mbridge.msdk.foundation.b.a.a.2
                @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                /* renamed from: a */
                public final void mo20509a() {
                    FeedBackBtnBean.m22929a(FeedBackBtnBean.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                /* renamed from: b */
                public final void mo20508b() {
                    FeedBackBtnBean.m22922b(FeedBackBtnBean.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                /* renamed from: c */
                public final void mo20507c() {
                    FeedBackBtnBean.m22919c(FeedBackBtnBean.this);
                }
            };
        }
    }

    /* renamed from: j */
    private void m22911j() {
        try {
            if (FeedbackManager.m22907a().m22906a(MBSDKContext.m22865f().m22861j()) != null) {
                Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                if (m23252b == null) {
                    m23252b = SettingManager.m23261a().m23253b();
                }
                Setting.C11194b m23388aJ = m23252b.m23388aJ();
                if (m23388aJ == null) {
                    SameLogTool.m21736b("", "feedback fbk is null");
                    return;
                }
                m22912i();
                this.f30233v = new MBFeedBackDialog(FeedbackManager.m22907a().m22906a(MBSDKContext.m22865f().m22861j()), this.f30235x);
                FeedbackRadioGroup m22931a = m22931a(m23388aJ);
                this.f30233v.setCancelText(m23388aJ.m23263c());
                this.f30233v.setConfirmText(m23388aJ.m23264b());
                this.f30233v.setTitle(m23388aJ.m23266a());
                this.f30233v.setContent(m22931a);
                this.f30233v.setCancelButtonClickable(!TextUtils.isEmpty(f30212y));
                m22926a(m22931a, m23388aJ);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m22910k() {
        FeedBackButton feedBackButton = this.f30215c;
        if (feedBackButton != null) {
            int i = this.f30218f;
            if (i > -1) {
                feedBackButton.setX(i);
            }
            int i2 = this.f30219g;
            if (i2 > -1) {
                this.f30215c.setY(i2);
            }
            float f = this.f30230r;
            if (f >= 0.0f) {
                this.f30215c.setAlpha(f);
                this.f30215c.setEnabled(this.f30230r != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.f30215c.getLayoutParams();
            int i3 = this.f30220h;
            if (i3 > 0) {
                this.f30215c.setWidth(i3);
                if (layoutParams != null) {
                    layoutParams.width = this.f30220h;
                }
            }
            int i4 = this.f30221i;
            if (i4 > 0) {
                this.f30215c.setHeight(i4);
                if (layoutParams != null) {
                    layoutParams.height = this.f30221i;
                }
            }
            if (layoutParams != null) {
                this.f30215c.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.f30228p)) {
                    this.f30215c.setTextColor(Color.parseColor(this.f30228p));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            float f2 = this.f30222j;
            if (f2 > 0.0f) {
                this.f30215c.setTextSize(f2);
            }
            JSONArray jSONArray = this.f30223k;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context m22861j = MBSDKContext.m22865f().m22861j();
                this.f30215c.setPadding(SameTool.m22001b(m22861j, (float) this.f30223k.optDouble(0)), SameTool.m22001b(m22861j, (float) this.f30223k.optDouble(1)), SameTool.m22001b(m22861j, (float) this.f30223k.optDouble(2)), SameTool.m22001b(m22861j, (float) this.f30223k.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i5 = this.f30231s;
            if (i5 > 0) {
                gradientDrawable.setCornerRadius(i5);
            }
            if (!TextUtils.isEmpty(this.f30229q)) {
                gradientDrawable.setColor(Color.parseColor(this.f30229q));
            } else {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            }
            this.f30215c.setBackground(gradientDrawable);
        }
    }

    /* renamed from: l */
    private void m22909l() {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (m22861j != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(m22861j);
                this.f30215c = feedBackButton;
                int i = 8;
                if (this.f30232u != 8) {
                    i = 0;
                }
                feedBackButton.setVisibility(i);
                this.f30215c.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.b.a.a.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedBackBtnBean.this.m22935a();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public final void m22924b() {
        MBFeedBackDialog mBFeedBackDialog = this.f30233v;
        if (mBFeedBackDialog == null || !mBFeedBackDialog.isShowing()) {
            return;
        }
        this.f30233v.cancel();
    }

    /* renamed from: c */
    public final FeedBackButton m22921c() {
        if (this.f30215c == null) {
            m22909l();
        }
        return this.f30215c;
    }

    /* renamed from: e */
    public final CampaignEx m22916e() {
        return this.f30214b;
    }

    /* renamed from: f */
    public final int m22915f() {
        return this.f30216d;
    }

    /* renamed from: g */
    public final int m22914g() {
        return this.f30217e;
    }

    /* renamed from: a */
    public final void m22935a() {
        FeedbackManager.m22907a().m22901a(this.f30213a, 0, 1, f30212y);
        Activity m22906a = FeedbackManager.m22907a().m22906a(MBSDKContext.m22865f().m22861j());
        MBFeedBackDialog mBFeedBackDialog = this.f30233v;
        if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != m22906a) {
            m22911j();
        }
        Context m22861j = MBSDKContext.m22865f().m22861j();
        FeedBackButton feedBackButton = this.f30215c;
        if (feedBackButton != null) {
            m22861j = feedBackButton.getContext();
        }
        int i = FeedbackManager.m22907a().m22898a(this.f30213a, m22861j, this.f30233v) ? 2 : 3;
        if (i == 2) {
            FeedbackManager.m22907a().m22901a(this.f30213a, 0, 2, f30212y);
        } else {
            FeedbackManager.m22907a().m22901a(this.f30213a, 0, 3, f30212y);
        }
        List<C11258a> list = this.f30234w;
        if (list != null) {
            for (C11258a c11258a : list) {
                if (c11258a != null) {
                    c11258a.m22908a(i);
                }
            }
        }
    }

    /* renamed from: d */
    public final void m22918d() {
        FeedBackButton feedBackButton = this.f30215c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.f30215c.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.f30215c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f30215c);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.f30233v;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.f30233v.setListener(null);
        }
        this.f30233v = null;
        this.f30234w = null;
        this.f30215c = null;
        this.f30235x = null;
    }

    /* compiled from: FeedBackBtnBean.java */
    /* renamed from: com.mbridge.msdk.foundation.b.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11258a implements MBAlertDialogListener {

        /* renamed from: a */
        private FeedbackDialogEventListener f30241a;

        /* renamed from: b */
        private String f30242b;

        public C11258a(String str, FeedbackDialogEventListener feedbackDialogEventListener) {
            this.f30241a = feedbackDialogEventListener;
            this.f30242b = str;
        }

        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
        /* renamed from: a */
        public final void mo20509a() {
            FeedbackManager.f30245c = false;
            FeedbackDialogEventListener feedbackDialogEventListener = this.f30241a;
            if (feedbackDialogEventListener != null) {
                feedbackDialogEventListener.mo20985a(FeedBackBtnBean.f30212y);
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
        /* renamed from: b */
        public final void mo20508b() {
            FeedbackManager.f30245c = false;
            FeedbackDialogEventListener feedbackDialogEventListener = this.f30241a;
            if (feedbackDialogEventListener != null) {
                feedbackDialogEventListener.mo20984b();
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
        /* renamed from: c */
        public final void mo20507c() {
        }

        /* renamed from: a */
        public final void m22908a(int i) {
            FeedbackManager.f30245c = true;
            FeedbackDialogEventListener feedbackDialogEventListener = this.f30241a;
            if (feedbackDialogEventListener == null || i != 2) {
                return;
            }
            feedbackDialogEventListener.mo20986a();
        }
    }

    /* renamed from: b */
    public final void m22923b(int i) {
        this.f30216d = i;
    }

    /* renamed from: b */
    static /* synthetic */ void m22922b(FeedBackBtnBean feedBackBtnBean) {
        FeedbackManager.m22907a().m22901a(feedBackBtnBean.f30213a, 0, 4, f30212y);
        List<C11258a> list = feedBackBtnBean.f30234w;
        if (list != null) {
            for (C11258a c11258a : list) {
                if (c11258a != null) {
                    c11258a.mo20508b();
                }
            }
        }
        f30212y = "";
    }

    /* renamed from: c */
    public final void m22920c(int i) {
        this.f30217e = i;
    }

    /* renamed from: c */
    static /* synthetic */ void m22919c(FeedBackBtnBean feedBackBtnBean) {
        List<C11258a> list = feedBackBtnBean.f30234w;
        if (list != null) {
            for (C11258a c11258a : list) {
                if (c11258a != null) {
                    c11258a.mo20507c();
                }
            }
        }
    }

    /* renamed from: a */
    public final void m22934a(int i) {
        this.f30232u = i;
        FeedBackButton feedBackButton = this.f30215c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m22926a(com.mbridge.msdk.widget.FeedbackRadioGroup r12, com.mbridge.msdk.p457c.Setting.C11194b r13) {
        /*
            r11 = this;
            org.json.JSONArray r13 = r13.m23262d()
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            android.content.Context r0 = r0.m22861j()
            if (r13 == 0) goto L7e
            int r1 = r13.length()
            if (r1 <= 0) goto L7e
            if (r0 == 0) goto L7e
            java.lang.String r1 = "mbridge_cm_feedback_choice_btn_bg"
            java.lang.String r2 = "drawable"
            int r1 = com.mbridge.msdk.foundation.tools.ResourceUtil.m21814a(r0, r1, r2)
            android.content.res.Resources r2 = com.mbridge.msdk.foundation.tools.ResourceUtil.m21815a(r0)
            java.lang.String r3 = "mbridge_cm_feedback_rb_text_color_color_list"
            java.lang.String r4 = "color"
            int r3 = com.mbridge.msdk.foundation.tools.ResourceUtil.m21814a(r0, r3, r4)
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
            int r3 = com.mbridge.msdk.foundation.tools.SameTool.m22001b(r0, r3)
            r5 = 1088421888(0x40e00000, float:7.0)
            int r5 = com.mbridge.msdk.foundation.tools.SameTool.m22001b(r0, r5)
            r6 = 1086324736(0x40c00000, float:6.0)
            int r6 = com.mbridge.msdk.foundation.tools.SameTool.m22001b(r0, r6)
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
            r11.m22932a(r9)
            r12.addView(r9, r8)
            int r7 = r7 + 1
            goto L4a
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p470b.p471a.FeedBackBtnBean.m22926a(com.mbridge.msdk.widget.FeedbackRadioGroup, com.mbridge.msdk.c.a$b):void");
    }

    /* renamed from: a */
    private FeedbackRadioGroup m22931a(Setting.C11194b c11194b) {
        JSONArray m23262d = c11194b.m23262d();
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (m23262d == null || m23262d.length() <= 0 || m22861j == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(m22861j);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    /* renamed from: a */
    private void m22932a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mbridge.msdk.foundation.b.a.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        String unused = FeedBackBtnBean.f30212y = (String) compoundButton.getText();
                    }
                    if (FeedBackBtnBean.this.f30233v != null) {
                        FeedBackBtnBean.this.f30233v.setCancelButtonClickable(!TextUtils.isEmpty(FeedBackBtnBean.f30212y));
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public final void m22930a(C11258a c11258a) {
        if (this.f30234w == null) {
            this.f30234w = new ArrayList();
        }
        this.f30234w.add(c11258a);
    }

    /* renamed from: a */
    public final void m22933a(int i, int i2, int i3, int i4, int i5, float f, String str, String str2, float f2, JSONArray jSONArray) {
        if (i > -1) {
            this.f30218f = i;
        }
        if (i2 > -1) {
            this.f30219g = i2;
        }
        if (i3 > -1) {
            this.f30220h = i3;
        }
        if (i4 > -1) {
            this.f30221i = i4;
        }
        if (f2 > -1.0f) {
            this.f30222j = f2;
        }
        if (jSONArray != null) {
            this.f30223k = jSONArray;
        }
        this.f30228p = str;
        this.f30229q = str2;
        this.f30230r = f;
        this.f30231s = i5;
        m22910k();
    }

    /* renamed from: a */
    public final void m22928a(CampaignEx campaignEx) {
        this.f30214b = campaignEx;
    }

    /* renamed from: a */
    public final void m22927a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.f30215c;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f30230r);
            feedBackButton.setEnabled(this.f30230r != 0.0f);
            feedBackButton.setVisibility(this.f30232u != 8 ? 0 : 8);
            this.f30215c = feedBackButton;
            CampaignEx campaignEx = this.f30214b;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                m22910k();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.b.a.a.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBackBtnBean.this.m22935a();
                }
            });
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22929a(FeedBackBtnBean feedBackBtnBean) {
        FeedbackManager.m22907a().m22901a(feedBackBtnBean.f30213a, 1, 4, f30212y);
        List<C11258a> list = feedBackBtnBean.f30234w;
        if (list != null) {
            for (C11258a c11258a : list) {
                if (c11258a != null) {
                    c11258a.mo20509a();
                }
            }
        }
        f30212y = "";
    }
}
