package com.mbridge.msdk.foundation.p470b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p470b.p471a.FeedBackBtnBean;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* renamed from: com.mbridge.msdk.foundation.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class FeedbackManager {

    /* renamed from: a */
    public static int f30243a = -2;

    /* renamed from: b */
    public static int f30244b = -2;

    /* renamed from: c */
    public static volatile boolean f30245c;

    /* renamed from: d */
    private final ConcurrentHashMap<String, FeedBackBtnBean> f30246d;

    /* renamed from: e */
    private final RelativeLayout.LayoutParams f30247e;

    /* renamed from: f */
    private Setting f30248f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FeedbackManager.java */
    /* renamed from: com.mbridge.msdk.foundation.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11260a {

        /* renamed from: a */
        private static final FeedbackManager f30249a = new FeedbackManager();
    }

    /* renamed from: a */
    public static FeedbackManager m22907a() {
        return C11260a.f30249a;
    }

    /* renamed from: b */
    public final boolean m22894b() {
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        this.f30248f = m23252b;
        if (m23252b == null) {
            this.f30248f = SettingManager.m23261a().m23253b();
        }
        return this.f30248f.m23389aI() != 0;
    }

    /* renamed from: c */
    public final void m22890c(String str, int i) {
        m22904a(str).m22920c(i);
    }

    private FeedbackManager() {
        this.f30246d = new ConcurrentHashMap<>();
        this.f30247e = new RelativeLayout.LayoutParams(f30243a, f30244b);
    }

    /* renamed from: a */
    public final Activity m22906a(Context context) {
        Activity activity;
        Context m22872c = MBSDKContext.m22865f().m22872c();
        Activity activity2 = null;
        try {
            Activity activity3 = m22872c instanceof Activity ? (Activity) m22872c : null;
            try {
                if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                    activity3 = (Activity) context;
                }
                WeakReference<Activity> m22888a = MBSDKContext.m22865f().m22888a();
                if (m22888a != null && (activity = m22888a.get()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    activity3 = activity;
                }
                if (activity3 == null || activity3.isFinishing()) {
                    return null;
                }
                if (activity3.isDestroyed()) {
                    return null;
                }
                return activity3;
            } catch (Exception e) {
                e = e;
                activity2 = activity3;
                e.printStackTrace();
                return activity2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: c */
    public final void m22891c(String str) {
        try {
            String m22860k = TextUtils.isEmpty(str) ? MBSDKContext.m22865f().m22860k() : str;
            FeedBackBtnBean feedBackBtnBean = this.f30246d.containsKey(m22860k) ? this.f30246d.get(m22860k) : null;
            if (feedBackBtnBean != null) {
                feedBackBtnBean.m22918d();
            }
            this.f30246d.remove(str);
            f30245c = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m22892b(String str, int i) {
        m22904a(str).m22923b(i);
    }

    /* renamed from: b */
    public final FeedBackButton m22893b(String str) {
        return m22904a(str).m22921c();
    }

    /* renamed from: a */
    private boolean m22905a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity m22906a = m22906a(context);
        if (m22906a == null || mBFeedBackDialog == null || m22906a.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || m22906a.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m22898a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog == null) {
            SameLogTool.m21736b("", "mbAlertDialog  is null");
            return false;
        }
        return m22905a(context, mBFeedBackDialog);
    }

    /* renamed from: a */
    public final void m22900a(String str, int i, ViewGroup viewGroup) {
        FeedBackBtnBean m22904a = m22904a(str);
        if (m22904a.m22921c() != null) {
            m22904a.m22934a(i);
            if (i == 0) {
                m22899a(str, MBSDKContext.m22865f().m22861j(), viewGroup, null, null);
            }
        }
    }

    /* renamed from: a */
    public final void m22902a(String str, int i, int i2, int i3, float f, float f2, float f3, String str2, String str3, float f4, JSONArray jSONArray) {
        FeedBackBtnBean m22904a = m22904a(str);
        Context m22861j = MBSDKContext.m22865f().m22861j();
        m22904a.m22933a(SameTool.m22001b(m22861j, f), SameTool.m22001b(m22861j, f2), SameTool.m22001b(m22861j, i), SameTool.m22001b(m22861j, i2), SameTool.m22001b(m22861j, i3), f3, str2, str3, f4, jSONArray);
    }

    /* renamed from: a */
    public final void m22897a(String str, FeedbackDialogEventListener feedbackDialogEventListener) {
        FeedBackBtnBean m22904a = m22904a(str);
        if (feedbackDialogEventListener != null) {
            m22904a.m22930a(new FeedBackBtnBean.C11258a(str, feedbackDialogEventListener));
        }
    }

    /* renamed from: a */
    public final void m22899a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, FeedbackDialogEventListener feedbackDialogEventListener) {
        if (m22894b()) {
            FeedBackBtnBean m22904a = m22904a(str);
            if (feedbackDialogEventListener != null) {
                m22904a.m22930a(new FeedBackBtnBean.C11258a(str, feedbackDialogEventListener));
            }
            FeedBackButton m22921c = m22904a.m22921c();
            if (m22921c != null) {
                if (layoutParams == null) {
                    int m22001b = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 10.0f);
                    this.f30247e.setMargins(m22001b, m22001b, m22001b, m22001b);
                    layoutParams = this.f30247e;
                }
                ViewGroup viewGroup2 = (ViewGroup) m22921c.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(m22921c);
                }
                Activity m22906a = m22906a(context);
                if (m22906a != null && viewGroup == null) {
                    viewGroup = (ViewGroup) m22906a.findViewById(16908290);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(m22921c);
                    viewGroup.addView(m22921c, layoutParams);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m22903a(String str, int i) {
        FeedBackBtnBean m22904a = m22904a(str);
        if (i == 1) {
            m22904a.m22924b();
        } else {
            m22904a.m22935a();
        }
    }

    /* renamed from: a */
    public final void m22896a(String str, CampaignEx campaignEx) {
        m22904a(str).m22928a(campaignEx);
    }

    /* renamed from: a */
    public final FeedBackBtnBean m22904a(String str) {
        FeedBackBtnBean feedBackBtnBean;
        if (TextUtils.isEmpty(str)) {
            str = MBSDKContext.m22865f().m22860k();
        }
        if (!this.f30246d.containsKey(str)) {
            feedBackBtnBean = new FeedBackBtnBean(str);
            this.f30246d.put(str, feedBackBtnBean);
        } else {
            feedBackBtnBean = this.f30246d.get(str);
        }
        if (feedBackBtnBean == null) {
            FeedBackBtnBean feedBackBtnBean2 = new FeedBackBtnBean(str);
            this.f30246d.put(str, feedBackBtnBean2);
            return feedBackBtnBean2;
        }
        return feedBackBtnBean;
    }

    /* renamed from: a */
    public final void m22895a(String str, FeedBackButton feedBackButton) {
        m22904a(str).m22927a(feedBackButton);
    }

    /* renamed from: a */
    public final void m22901a(String str, int i, int i2, String str2) {
        FeedBackBtnBean m22904a = m22904a(str);
        CampaignEx m22916e = m22904a.m22916e();
        C11385e.m22067a(m22916e, m22916e != null ? m22916e.getCampaignUnitId() : "", m22904a.m22915f(), m22904a.m22914g(), !TextUtils.isEmpty(str2) ? str2 : "", i, m22916e != null ? m22916e.getAdType() : 0, i2);
    }
}
