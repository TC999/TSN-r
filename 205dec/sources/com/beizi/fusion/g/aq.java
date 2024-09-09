package com.beizi.fusion.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ScrollClickUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class aq {

    /* renamed from: j  reason: collision with root package name */
    private static AdSpacesBean.BuyerBean.ScrollClickBean f14855j;

    /* renamed from: a  reason: collision with root package name */
    ScrollClickView f14856a;

    /* renamed from: b  reason: collision with root package name */
    int f14857b;

    /* renamed from: c  reason: collision with root package name */
    int f14858c;

    /* renamed from: d  reason: collision with root package name */
    private Context f14859d;

    /* renamed from: e  reason: collision with root package name */
    private int f14860e;

    /* renamed from: f  reason: collision with root package name */
    private int f14861f;

    /* renamed from: g  reason: collision with root package name */
    private a f14862g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14863h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f14864i = 200;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f14865k;

    /* compiled from: ScrollClickUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void c_();
    }

    public aq(Context context) {
        this.f14859d = context;
    }

    private void c() {
        Pair<Integer, Boolean> c4 = c(this.f14861f);
        if (((Boolean) c4.second).booleanValue()) {
            aa.a(new Runnable() { // from class: com.beizi.fusion.g.aq.1
                @Override // java.lang.Runnable
                public void run() {
                    aq.this.a();
                }
            }, this.f14860e + (((Integer) c4.first).intValue() * 10));
        }
    }

    public void b(int i4) {
        this.f14861f = i4;
        c();
    }

    public void a(AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean) {
        if (scrollClickBean == null) {
            return;
        }
        f14855j = scrollClickBean;
        a(scrollClickBean.getRandomClickTime());
        b(scrollClickBean.getRandomClickNum());
    }

    public void b() {
        this.f14863h = false;
        ScrollClickView scrollClickView = this.f14856a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
        this.f14862g = null;
        this.f14859d = null;
        this.f14856a = null;
        this.f14864i = 200;
    }

    public void a(int i4) {
        this.f14860e = i4;
    }

    public static Pair<Integer, Boolean> c(int i4) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i4) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    public void a(a aVar) {
        this.f14862g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f14862g != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f14863h);
        af.a("ScrollClickUtil", sb.toString());
        if (this.f14862g == null || this.f14863h) {
            return;
        }
        af.a("ScrollClickUtil", "callback onShakeHappened()");
        this.f14862g.b("100", "200", "105", "206", "100", "200", "105", "206");
        this.f14863h = true;
        ScrollClickView scrollClickView = this.f14856a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
    }

    public View a(final int i4, final int i5, AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean) {
        String downloadDetails;
        int parseInt;
        int parseInt2;
        af.a("ScrollClickUtil", "enter getScrollClick");
        if (this.f14859d == null || scrollClickPositionBean == null) {
            return null;
        }
        ScrollClickView scrollClickView = new ScrollClickView(this.f14859d);
        this.f14856a = scrollClickView;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = f14855j;
            if (scrollClickBean != null) {
                scrollClickView.setScrollDirection(scrollClickBean.getScrollDirection());
                this.f14856a.setTitleText(f14855j.getTitle());
                this.f14856a.setTitleFont(f14855j.getTitleFont());
                if (!this.f14865k.booleanValue()) {
                    downloadDetails = f14855j.getDetails();
                } else {
                    downloadDetails = f14855j.getDownloadDetails();
                    if (TextUtils.isEmpty(downloadDetails)) {
                        downloadDetails = "\u4e0b\u8f7d\u5e94\u7528";
                    }
                }
                this.f14856a.setDetailText(downloadDetails);
                this.f14856a.setDetailsFont(f14855j.getDetailsFont());
                AdSpacesBean.BuyerBean.ScrollClickPositionBean position = f14855j.getPosition();
                String width = position.getWidth();
                String height = position.getHeight();
                if (width.endsWith("%")) {
                    parseInt = (Integer.parseInt(width.substring(0, width.indexOf("%"))) * i4) / 100;
                } else {
                    parseInt = Integer.parseInt(width);
                }
                if (height.endsWith("%")) {
                    parseInt2 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt) / 100;
                } else {
                    parseInt2 = Integer.parseInt(height);
                }
                this.f14856a.setHandWidth(parseInt);
                this.f14856a.setScrollbarHeight(parseInt2);
                this.f14856a.buildRealView();
            }
            String top2 = scrollClickPositionBean.getTop();
            String centerX = scrollClickPositionBean.getCenterX();
            centerX = (TextUtils.isEmpty(centerX) || "0".equals(centerX)) ? "50%" : "50%";
            top2 = (TextUtils.isEmpty(top2) || "0".equals(top2)) ? "50%" : "50%";
            aw.j(this.f14859d);
            if (centerX.endsWith("%")) {
                this.f14857b = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i4) / 100;
            } else {
                this.f14857b = Integer.parseInt(centerX);
            }
            if (top2.endsWith("%")) {
                this.f14858c = (Integer.parseInt(top2.substring(0, top2.indexOf("%"))) * i5) / 100;
            } else {
                this.f14858c = Integer.parseInt(top2);
            }
            this.f14857b = aw.a(this.f14859d, this.f14857b);
            this.f14858c = aw.a(this.f14859d, this.f14858c);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            af.a("ScrollClickUtil", "topInt = " + this.f14858c + ",centerXInt = " + this.f14857b + ",adWidthDp = " + i4 + ",adHeightDp = " + i5);
            this.f14856a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.g.aq.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ScrollClickView scrollClickView2 = aq.this.f14856a;
                    if (scrollClickView2 == null) {
                        return;
                    }
                    scrollClickView2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth = aq.this.f14856a.getMeasuredWidth();
                    aq aqVar = aq.this;
                    if (aqVar.f14858c == 0) {
                        aqVar.f14858c = aw.a(aqVar.f14859d, i5) / 2;
                    }
                    aq aqVar2 = aq.this;
                    if (aqVar2.f14857b == 0) {
                        aqVar2.f14857b = aw.a(aqVar2.f14859d, i4) / 2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = layoutParams;
                    aq aqVar3 = aq.this;
                    layoutParams2.topMargin = aqVar3.f14858c;
                    layoutParams2.leftMargin = aqVar3.f14857b - (measuredWidth / 2);
                    aqVar3.f14856a.setLayoutParams(layoutParams2);
                    af.a("ScrollClickUtil", "topMargin = " + layoutParams.topMargin + ",leftMargin = " + layoutParams.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
                }
            });
            this.f14856a.setLayoutParams(layoutParams);
            this.f14856a.postDelayed(new Runnable() { // from class: com.beizi.fusion.g.aq.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ScrollClickView scrollClickView2 = aq.this.f14856a;
                        if (scrollClickView2 != null) {
                            scrollClickView2.startAnim();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }, 10L);
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
        }
        return this.f14856a;
    }

    public void a(Boolean bool) {
        this.f14865k = bool;
    }
}
