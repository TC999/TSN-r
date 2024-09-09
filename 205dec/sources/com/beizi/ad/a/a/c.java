package com.beizi.ad.a.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.p;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RegionClickUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f13166a;

    /* renamed from: b  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f13167b;

    /* renamed from: c  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f13168c;

    /* renamed from: d  reason: collision with root package name */
    private a f13169d = null;

    /* renamed from: e  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.PercentPositionBean f13170e;

    /* renamed from: f  reason: collision with root package name */
    private String f13171f;

    /* renamed from: g  reason: collision with root package name */
    private String f13172g;

    /* renamed from: h  reason: collision with root package name */
    private double f13173h;

    /* renamed from: i  reason: collision with root package name */
    private String f13174i;

    /* renamed from: j  reason: collision with root package name */
    private int f13175j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RegionClickUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public c(Context context, AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean, String str, boolean z3) {
        this.f13171f = null;
        this.f13172g = null;
        this.f13173h = 0.0d;
        this.f13174i = null;
        this.f13175j = 0;
        try {
            this.f13166a = context;
            this.f13167b = regionalClickViewBean;
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a4 = a(regionalClickViewBean.getOrderData(), str);
            if (a4 != null && a4.getRegionalClickView() != null) {
                this.f13168c = a4.getRegionalClickView();
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.f13168c;
            if (regionalClickViewBean2 != null) {
                if (!z3) {
                    this.f13174i = regionalClickViewBean2.getTitle();
                } else {
                    String downloadTitle = regionalClickViewBean2.getDownloadTitle();
                    this.f13174i = downloadTitle;
                    if (TextUtils.isEmpty(downloadTitle)) {
                        this.f13174i = "\u70b9\u51fb\u4e0b\u8f7d\u5e94\u7528";
                    }
                }
                this.f13170e = this.f13168c.getPosition();
                this.f13171f = this.f13168c.getTitleColor();
                this.f13172g = this.f13168c.getBackgroundColor();
                this.f13173h = this.f13168c.getBackgroundAlpha();
                this.f13175j = this.f13168c.getIsDisableClick();
            } else {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean3 = this.f13167b;
                if (regionalClickViewBean3 != null) {
                    if (!z3) {
                        this.f13174i = regionalClickViewBean3.getTitle();
                    } else {
                        String downloadTitle2 = regionalClickViewBean3.getDownloadTitle();
                        this.f13174i = downloadTitle2;
                        if (TextUtils.isEmpty(downloadTitle2)) {
                            this.f13174i = "\u70b9\u51fb\u4e0b\u8f7d\u5e94\u7528";
                        }
                    }
                    this.f13170e = this.f13167b.getPosition();
                    this.f13171f = this.f13167b.getTitleColor();
                    this.f13172g = this.f13167b.getBackgroundColor();
                    this.f13173h = this.f13167b.getBackgroundAlpha();
                    this.f13175j = this.f13167b.getIsDisableClick();
                }
            }
            if (TextUtils.isEmpty(this.f13174i)) {
                this.f13174i = "\u70b9\u51fb\u8df3\u8f6c\u7f51\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
            }
            if (TextUtils.isEmpty(this.f13172g)) {
                this.f13172g = "#3976FF";
            }
            if (TextUtils.isEmpty(this.f13171f)) {
                this.f13171f = "#FFFFFF";
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private int[] b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                percentPositionBean = this.f13170e;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (percentPositionBean != null) {
                String centerX = percentPositionBean.getCenterX();
                String centerY = this.f13170e.getCenterY();
                String width = this.f13170e.getWidth();
                String height = this.f13170e.getHeight();
                centerX = (TextUtils.isEmpty(centerX) || "0".equals(centerX)) ? "0" : "0";
                centerY = (TextUtils.isEmpty(centerY) || "0".equals(centerY)) ? "0" : "0";
                viewGroup.measure(0, 0);
                int px2dip = ViewUtil.px2dip(this.f13166a, viewGroup.getMeasuredWidth());
                int px2dip2 = ViewUtil.px2dip(this.f13166a, viewGroup.getMeasuredHeight());
                if (px2dip <= 0) {
                    px2dip = p.k(this.f13166a);
                }
                l.a("RegionClickUtil", "position containerWidth:" + px2dip + ";containerHeight:" + px2dip2 + ";" + viewGroup.getLayoutParams().width + ";" + viewGroup.getLayoutParams().height);
                if (TextUtils.isEmpty(width) || "0".equals(width)) {
                    width = String.valueOf(px2dip);
                }
                height = (TextUtils.isEmpty(height) || "0".equals(height)) ? "40" : "40";
                int i4 = 40;
                if (centerX.endsWith("%")) {
                    parseInt = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * px2dip) / 100;
                } else {
                    parseInt = !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                }
                if (centerY.endsWith("%")) {
                    parseInt2 = (px2dip2 * Integer.parseInt(centerY.substring(0, centerY.indexOf("%")))) / 100;
                } else {
                    parseInt2 = !TextUtils.isEmpty(centerY) ? Integer.parseInt(centerY) : 0;
                }
                if (width.endsWith("%")) {
                    parseInt3 = (px2dip * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    parseInt3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 0;
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt3) / 100;
                } else if (!TextUtils.isEmpty(width)) {
                    i4 = Integer.parseInt(height);
                }
                int dip2px = ViewUtil.dip2px(this.f13166a, parseInt3);
                int dip2px2 = ViewUtil.dip2px(this.f13166a, i4);
                int dip2px3 = ViewUtil.dip2px(this.f13166a, parseInt);
                int dip2px4 = ViewUtil.dip2px(this.f13166a, parseInt2);
                iArr[0] = dip2px;
                iArr[1] = dip2px2;
                if (dip2px3 > 0) {
                    iArr[2] = dip2px3;
                }
                if (dip2px4 > 0) {
                    iArr[3] = dip2px4;
                }
                l.a("RegionClickUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + ";" + centerX + ";" + centerY);
                return iArr;
            }
        }
        int i5 = viewGroup.getLayoutParams().width;
        int dip2px5 = ViewUtil.dip2px(this.f13166a, 40.0f);
        iArr[0] = i5;
        iArr[1] = dip2px5;
        iArr[2] = 0;
        iArr[3] = 0;
        return iArr;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f13166a == null) {
                    return;
                }
                TextView textView = new TextView(this.f13166a);
                textView.setVisibility(0);
                textView.setLines(1);
                textView.setGravity(17);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f13175j == 0) {
                    textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.c.1

                        /* renamed from: a  reason: collision with root package name */
                        float f13176a;

                        /* renamed from: b  reason: collision with root package name */
                        float f13177b;

                        /* renamed from: c  reason: collision with root package name */
                        float f13178c;

                        /* renamed from: d  reason: collision with root package name */
                        float f13179d;

                        /* renamed from: e  reason: collision with root package name */
                        float f13180e;

                        /* renamed from: f  reason: collision with root package name */
                        float f13181f;

                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this.f13176a = motionEvent.getX();
                                this.f13177b = motionEvent.getY();
                                this.f13178c = motionEvent.getRawX();
                                this.f13179d = motionEvent.getRawY();
                                this.f13180e = motionEvent.getX();
                                this.f13181f = motionEvent.getY();
                            } else if (action != 1) {
                                if (action == 2) {
                                    this.f13180e = motionEvent.getX();
                                    this.f13181f = motionEvent.getY();
                                }
                            } else if (Math.abs(this.f13180e - this.f13176a) <= 15.0f && Math.abs(this.f13181f - this.f13177b) <= 15.0f && c.this.f13169d != null) {
                                c.this.f13169d.a(String.valueOf(this.f13176a), String.valueOf(this.f13177b), String.valueOf(this.f13178c), String.valueOf(this.f13179d), String.valueOf(this.f13176a), String.valueOf(this.f13177b), String.valueOf(this.f13178c), String.valueOf(this.f13179d));
                            }
                            return true;
                        }
                    });
                }
                if (!TextUtils.isEmpty(this.f13174i)) {
                    textView.setText(this.f13174i);
                }
                if (TextUtils.isEmpty(this.f13171f)) {
                    this.f13171f = "#FFFFFF";
                }
                if (!TextUtils.isEmpty(this.f13171f) && this.f13171f.startsWith("#")) {
                    textView.setTextColor(Color.parseColor(this.f13171f));
                }
                if (TextUtils.isEmpty(this.f13172g)) {
                    this.f13172g = "#80000000";
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (!TextUtils.isEmpty(this.f13172g) && this.f13172g.startsWith("#")) {
                    gradientDrawable.setColor(Color.parseColor(this.f13172g));
                }
                double d4 = this.f13173h;
                if (d4 > 0.0d) {
                    gradientDrawable.setAlpha((int) (d4 * 255.0d));
                }
                gradientDrawable.setCornerRadius(ViewUtil.dip2px(this.f13166a, 7.0f));
                textView.setBackgroundDrawable(gradientDrawable);
                int[] b4 = b(viewGroup);
                try {
                    textView.setTextSize(2, (float) (b4[1] > 0 ? ViewUtil.px2dip(this.f13166a, b4[1]) / 3 : 14.0d));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    if (b4[0] > 0) {
                        layoutParams.width = b4[0];
                    }
                    if (b4[1] > 0) {
                        layoutParams.height = b4[1];
                    }
                    layoutParams.leftMargin = b4[2];
                    layoutParams.topMargin = b4[3];
                    layoutParams.addRule(17);
                    viewGroup.addView(textView, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    if (b4[0] > 0) {
                        layoutParams2.width = b4[0];
                    }
                    if (b4[1] > 0) {
                        layoutParams2.height = b4[1];
                    }
                    layoutParams2.leftMargin = b4[2];
                    layoutParams2.topMargin = b4[3];
                    viewGroup.addView(textView, layoutParams2);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    if (b4[0] > 0) {
                        layoutParams3.width = b4[0];
                    }
                    if (b4[1] > 0) {
                        layoutParams3.height = b4[1];
                    }
                    layoutParams3.leftMargin = b4[2];
                    layoutParams3.topMargin = b4[3];
                    viewGroup.addView(textView, layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    if (b4[0] > 0) {
                        layoutParams4.width = b4[0];
                    }
                    if (b4[1] > 0) {
                        layoutParams4.height = b4[1];
                    }
                    viewGroup.addView(textView, layoutParams4);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.f13169d = aVar;
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    public void a() {
        this.f13167b = null;
        this.f13168c = null;
        this.f13170e = null;
        this.f13169d = null;
        this.f13166a = null;
    }
}
