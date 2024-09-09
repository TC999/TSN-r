package com.mbridge.msdk.foundation.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.b.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* compiled from: FeedbackManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f39070a = -2;

    /* renamed from: b  reason: collision with root package name */
    public static int f39071b = -2;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f39072c;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.b.a.a> f39073d;

    /* renamed from: e  reason: collision with root package name */
    private final RelativeLayout.LayoutParams f39074e;

    /* renamed from: f  reason: collision with root package name */
    private com.mbridge.msdk.c.a f39075f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FeedbackManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f39076a = new b();
    }

    public static b a() {
        return a.f39076a;
    }

    public final boolean b() {
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        this.f39075f = b4;
        if (b4 == null) {
            this.f39075f = com.mbridge.msdk.c.b.a().b();
        }
        return this.f39075f.aI() != 0;
    }

    public final void c(String str, int i4) {
        a(str).c(i4);
    }

    private b() {
        this.f39073d = new ConcurrentHashMap<>();
        this.f39074e = new RelativeLayout.LayoutParams(f39070a, f39071b);
    }

    public final Activity a(Context context) {
        Activity activity;
        Context c4 = com.mbridge.msdk.foundation.controller.a.f().c();
        Activity activity2 = null;
        try {
            Activity activity3 = c4 instanceof Activity ? (Activity) c4 : null;
            try {
                if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                    activity3 = (Activity) context;
                }
                WeakReference<Activity> a4 = com.mbridge.msdk.foundation.controller.a.f().a();
                if (a4 != null && (activity = a4.get()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    activity3 = activity;
                }
                if (activity3 == null || activity3.isFinishing()) {
                    return null;
                }
                if (activity3.isDestroyed()) {
                    return null;
                }
                return activity3;
            } catch (Exception e4) {
                e = e4;
                activity2 = activity3;
                e.printStackTrace();
                return activity2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public final void c(String str) {
        try {
            String k4 = TextUtils.isEmpty(str) ? com.mbridge.msdk.foundation.controller.a.f().k() : str;
            com.mbridge.msdk.foundation.b.a.a aVar = this.f39073d.containsKey(k4) ? this.f39073d.get(k4) : null;
            if (aVar != null) {
                aVar.d();
            }
            this.f39073d.remove(str);
            f39072c = false;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void b(String str, int i4) {
        a(str).b(i4);
    }

    public final FeedBackButton b(String str) {
        return a(str).c();
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity a4 = a(context);
        if (a4 == null || mBFeedBackDialog == null || a4.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || a4.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog == null) {
            x.b("", "mbAlertDialog  is null");
            return false;
        }
        return a(context, mBFeedBackDialog);
    }

    public final void a(String str, int i4, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.b.a.a a4 = a(str);
        if (a4.c() != null) {
            a4.a(i4);
            if (i4 == 0) {
                a(str, com.mbridge.msdk.foundation.controller.a.f().j(), viewGroup, null, null);
            }
        }
    }

    public final void a(String str, int i4, int i5, int i6, float f4, float f5, float f6, String str2, String str3, float f7, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.b.a.a a4 = a(str);
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        a4.a(ac.b(j4, f4), ac.b(j4, f5), ac.b(j4, i4), ac.b(j4, i5), ac.b(j4, i6), f6, str2, str3, f7, jSONArray);
    }

    public final void a(String str, com.mbridge.msdk.foundation.b.a aVar) {
        com.mbridge.msdk.foundation.b.a.a a4 = a(str);
        if (aVar != null) {
            a4.a(new a.C0736a(str, aVar));
        }
    }

    public final void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.mbridge.msdk.foundation.b.a aVar) {
        if (b()) {
            com.mbridge.msdk.foundation.b.a.a a4 = a(str);
            if (aVar != null) {
                a4.a(new a.C0736a(str, aVar));
            }
            FeedBackButton c4 = a4.c();
            if (c4 != null) {
                if (layoutParams == null) {
                    int b4 = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 10.0f);
                    this.f39074e.setMargins(b4, b4, b4, b4);
                    layoutParams = this.f39074e;
                }
                ViewGroup viewGroup2 = (ViewGroup) c4.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(c4);
                }
                Activity a5 = a(context);
                if (a5 != null && viewGroup == null) {
                    viewGroup = (ViewGroup) a5.findViewById(16908290);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(c4);
                    viewGroup.addView(c4, layoutParams);
                }
            }
        }
    }

    public final void a(String str, int i4) {
        com.mbridge.msdk.foundation.b.a.a a4 = a(str);
        if (i4 == 1) {
            a4.b();
        } else {
            a4.a();
        }
    }

    public final void a(String str, CampaignEx campaignEx) {
        a(str).a(campaignEx);
    }

    public final com.mbridge.msdk.foundation.b.a.a a(String str) {
        com.mbridge.msdk.foundation.b.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.a.f().k();
        }
        if (!this.f39073d.containsKey(str)) {
            aVar = new com.mbridge.msdk.foundation.b.a.a(str);
            this.f39073d.put(str, aVar);
        } else {
            aVar = this.f39073d.get(str);
        }
        if (aVar == null) {
            com.mbridge.msdk.foundation.b.a.a aVar2 = new com.mbridge.msdk.foundation.b.a.a(str);
            this.f39073d.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final void a(String str, int i4, int i5, String str2) {
        com.mbridge.msdk.foundation.b.a.a a4 = a(str);
        CampaignEx e4 = a4.e();
        e.a(e4, e4 != null ? e4.getCampaignUnitId() : "", a4.f(), a4.g(), !TextUtils.isEmpty(str2) ? str2 : "", i4, e4 != null ? e4.getAdType() : 0, i5);
    }
}
