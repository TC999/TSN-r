package com.beizi.fusion.p072g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.RegionClickView;

/* compiled from: RegionClickUtil.java */
/* renamed from: com.beizi.fusion.g.am */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3120am {

    /* renamed from: d */
    private static String f11269d;

    /* renamed from: e */
    private static String f11270e;

    /* renamed from: f */
    private static String f11271f;

    /* renamed from: g */
    private static String f11272g;

    /* renamed from: a */
    private Context f11273a;

    /* renamed from: b */
    private InterfaceC3123a f11274b;

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f11275c = null;

    /* compiled from: RegionClickUtil.java */
    /* renamed from: com.beizi.fusion.g.am$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3123a {
        /* renamed from: a */
        void mo46594a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public C3120am(Context context) {
        this.f11273a = context;
    }

    /* renamed from: a */
    public void m48429a(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        this.f11275c = regionalClickViewBean;
    }

    /* renamed from: a */
    public View m48432a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean, boolean z) {
        if (this.f11273a == null || percentPositionBean == null) {
            return null;
        }
        C3116af.m48494c("BeiZis", "adWidthDp = " + i + ",adHeightDp = " + i2);
        RegionClickView regionClickView = new RegionClickView(this.f11273a);
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = this.f11275c;
        if (regionalClickViewBean != null) {
            regionClickView.setRegionalClickViewBean(regionalClickViewBean);
        }
        regionClickView.setLayoutParams(m48433a(i, i2, percentPositionBean));
        if (z) {
            regionClickView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.g.am.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C3120am.this.f11274b != null) {
                        C3120am.this.f11274b.mo46594a(C3120am.f11269d, C3120am.f11270e, C3120am.f11271f, C3120am.f11272g, C3120am.f11269d, C3120am.f11270e, C3120am.f11271f, C3120am.f11272g);
                    }
                }
            });
            regionClickView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.g.am.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (motionEvent.getAction() == 0) {
                            String unused = C3120am.f11269d = motionEvent.getX() + "";
                            String unused2 = C3120am.f11270e = motionEvent.getY() + "";
                            String unused3 = C3120am.f11271f = motionEvent.getRawX() + "";
                            String unused4 = C3120am.f11272g = motionEvent.getRawY() + "";
                            return false;
                        }
                        return false;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            });
        }
        return regionClickView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fd, code lost:
        if (r2 >= 400) goto L29;
     */
    @androidx.annotation.NonNull
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.ViewGroup.MarginLayoutParams m48433a(int r11, int r12, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r13) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.C3120am.m48433a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.ViewGroup$MarginLayoutParams");
    }

    /* renamed from: a */
    public void m48431a(InterfaceC3123a interfaceC3123a) {
        this.f11274b = interfaceC3123a;
    }

    /* renamed from: a */
    public void m48434a() {
        this.f11273a = null;
        this.f11275c = null;
    }
}
