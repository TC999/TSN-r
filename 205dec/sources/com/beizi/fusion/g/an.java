package com.beizi.fusion.g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.RegionClickView;
import com.beizi.fusion.widget.TwistView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RegionClickUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class an {

    /* renamed from: d  reason: collision with root package name */
    private static String f14810d;

    /* renamed from: e  reason: collision with root package name */
    private static String f14811e;

    /* renamed from: f  reason: collision with root package name */
    private static String f14812f;

    /* renamed from: g  reason: collision with root package name */
    private static String f14813g;

    /* renamed from: a  reason: collision with root package name */
    private Context f14814a;

    /* renamed from: b  reason: collision with root package name */
    private a f14815b;

    /* renamed from: c  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f14816c = null;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f14817h;

    /* compiled from: RollUtil.java */
    /* renamed from: com.beizi.fusion.g.an$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass3 implements View.OnTouchListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    String unused = an.f14810d = motionEvent.getX() + "";
                    String unused2 = an.f14811e = motionEvent.getY() + "";
                    String unused3 = an.f14812f = motionEvent.getRawX() + "";
                    String unused4 = an.f14813g = motionEvent.getRawY() + "";
                    return false;
                }
                return false;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }
    }

    /* compiled from: RollUtil.java */
    /* renamed from: com.beizi.fusion.g.an$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass4 implements TwistView.a {
        AnonymousClass4() {
        }

        @Override // com.beizi.fusion.widget.TwistView.a
        public void a() {
            if (an.l(an.this)) {
                return;
            }
            an.d(an.this, true);
            if (an.k(an.this) != null) {
                an.k(an.this).a();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RegionClickUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public an(Context context) {
        this.f14814a = context;
    }

    public void a(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        this.f14816c = regionalClickViewBean;
    }

    public View a(int i4, int i5, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean, boolean z3) {
        if (this.f14814a == null || percentPositionBean == null) {
            return null;
        }
        af.c("BeiZis", "adWidthDp = " + i4 + ",adHeightDp = " + i5);
        RegionClickView regionClickView = new RegionClickView(this.f14814a);
        if (this.f14816c != null) {
            regionClickView.setDownloadApp(this.f14817h);
            regionClickView.setRegionalClickViewBean(this.f14816c);
        }
        regionClickView.setLayoutParams(a(i4, i5, percentPositionBean));
        if (z3) {
            regionClickView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.g.an.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.f14815b != null) {
                        an.this.f14815b.a(an.f14810d, an.f14811e, an.f14812f, an.f14813g, an.f14810d, an.f14811e, an.f14812f, an.f14813g);
                    }
                }
            });
            regionClickView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.g.an.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (motionEvent.getAction() == 0) {
                            String unused = an.f14810d = motionEvent.getX() + "";
                            String unused2 = an.f14811e = motionEvent.getY() + "";
                            String unused3 = an.f14812f = motionEvent.getRawX() + "";
                            String unused4 = an.f14813g = motionEvent.getRawY() + "";
                            return false;
                        }
                        return false;
                    } catch (Exception e4) {
                        e4.printStackTrace();
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.ViewGroup.MarginLayoutParams a(int r11, int r12, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r13) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.g.an.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.ViewGroup$MarginLayoutParams");
    }

    public void a(a aVar) {
        this.f14815b = aVar;
    }

    public void a() {
        this.f14814a = null;
        this.f14816c = null;
    }

    public void a(Boolean bool) {
        this.f14817h = bool;
    }
}
