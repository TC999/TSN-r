package com.beizi.p051ad.p052a.p053a;

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
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* renamed from: com.beizi.ad.a.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RegionClickUtil {

    /* renamed from: a */
    private Context f9461a;

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f9462b;

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f9463c;

    /* renamed from: d */
    private InterfaceC2766a f9464d = null;

    /* renamed from: e */
    private AdSpacesBean.BuyerBean.PercentPositionBean f9465e;

    /* renamed from: f */
    private String f9466f;

    /* renamed from: g */
    private String f9467g;

    /* renamed from: h */
    private double f9468h;

    /* renamed from: i */
    private String f9469i;

    /* renamed from: j */
    private int f9470j;

    /* compiled from: RegionClickUtil.java */
    /* renamed from: com.beizi.ad.a.a.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2766a {
        /* renamed from: a */
        void mo49677a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public RegionClickUtil(Context context, AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean, String str) {
        this.f9466f = null;
        this.f9467g = null;
        this.f9468h = Utils.DOUBLE_EPSILON;
        this.f9469i = null;
        this.f9470j = 0;
        try {
            this.f9461a = context;
            this.f9462b = regionalClickViewBean;
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean m50150a = m50150a(regionalClickViewBean.getOrderData(), str);
            if (m50150a != null && m50150a.getRegionalClickView() != null) {
                this.f9463c = m50150a.getRegionalClickView();
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.f9463c;
            if (regionalClickViewBean2 != null) {
                this.f9469i = regionalClickViewBean2.getTitle();
                this.f9465e = this.f9463c.getPosition();
                this.f9466f = this.f9463c.getTitleColor();
                this.f9467g = this.f9463c.getBackgroundColor();
                this.f9468h = this.f9463c.getBackgroundAlpha();
                this.f9470j = this.f9463c.getIsDisableClick();
            } else {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean3 = this.f9462b;
                if (regionalClickViewBean3 != null) {
                    this.f9469i = regionalClickViewBean3.getTitle();
                    this.f9465e = this.f9462b.getPosition();
                    this.f9466f = this.f9462b.getTitleColor();
                    this.f9467g = this.f9462b.getBackgroundColor();
                    this.f9468h = this.f9462b.getBackgroundAlpha();
                    this.f9470j = this.f9462b.getIsDisableClick();
                }
            }
            if (TextUtils.isEmpty(this.f9469i)) {
                this.f9469i = "点击跳转网页或第三方应用";
            }
            if (TextUtils.isEmpty(this.f9467g)) {
                this.f9467g = "#3976FF";
            }
            if (TextUtils.isEmpty(this.f9466f)) {
                this.f9466f = "#FFFFFF";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private int[] m50149b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                percentPositionBean = this.f9465e;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (percentPositionBean != null) {
                String centerX = percentPositionBean.getCenterX();
                String centerY = this.f9465e.getCenterY();
                String width = this.f9465e.getWidth();
                String height = this.f9465e.getHeight();
                centerX = (TextUtils.isEmpty(centerX) || "0".equals(centerX)) ? "0" : "0";
                centerY = (TextUtils.isEmpty(centerY) || "0".equals(centerY)) ? "0" : "0";
                viewGroup.measure(0, 0);
                int px2dip = ViewUtil.px2dip(this.f9461a, viewGroup.getMeasuredWidth());
                int px2dip2 = ViewUtil.px2dip(this.f9461a, viewGroup.getMeasuredHeight());
                if (px2dip <= 0) {
                    px2dip = SystemUtil.m49022k(this.f9461a);
                }
                LogUtil.m49046a("RegionClickUtil", "position containerWidth:" + px2dip + ";containerHeight:" + px2dip2 + ";" + viewGroup.getLayoutParams().width + ";" + viewGroup.getLayoutParams().height);
                if (TextUtils.isEmpty(width) || "0".equals(width)) {
                    width = String.valueOf(px2dip);
                }
                height = (TextUtils.isEmpty(height) || "0".equals(height)) ? "40" : "40";
                int i = 40;
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
                    i = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt3) / 100;
                } else if (!TextUtils.isEmpty(width)) {
                    i = Integer.parseInt(height);
                }
                int dip2px = ViewUtil.dip2px(this.f9461a, parseInt3);
                int dip2px2 = ViewUtil.dip2px(this.f9461a, i);
                int dip2px3 = ViewUtil.dip2px(this.f9461a, parseInt);
                int dip2px4 = ViewUtil.dip2px(this.f9461a, parseInt2);
                iArr[0] = dip2px;
                iArr[1] = dip2px2;
                if (dip2px3 > 0) {
                    iArr[2] = dip2px3;
                }
                if (dip2px4 > 0) {
                    iArr[3] = dip2px4;
                }
                LogUtil.m49046a("RegionClickUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + ";" + centerX + ";" + centerY);
                return iArr;
            }
        }
        int i2 = viewGroup.getLayoutParams().width;
        int dip2px5 = ViewUtil.dip2px(this.f9461a, 40.0f);
        iArr[0] = i2;
        iArr[1] = dip2px5;
        iArr[2] = 0;
        iArr[3] = 0;
        return iArr;
    }

    /* renamed from: a */
    public void m50153a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f9461a == null) {
                    return;
                }
                TextView textView = new TextView(this.f9461a);
                textView.setVisibility(0);
                textView.setLines(1);
                textView.setGravity(17);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f9470j == 0) {
                    textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.c.1

                        /* renamed from: a */
                        float f9471a;

                        /* renamed from: b */
                        float f9472b;

                        /* renamed from: c */
                        float f9473c;

                        /* renamed from: d */
                        float f9474d;

                        /* renamed from: e */
                        float f9475e;

                        /* renamed from: f */
                        float f9476f;

                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this.f9471a = motionEvent.getX();
                                this.f9472b = motionEvent.getY();
                                this.f9473c = motionEvent.getRawX();
                                this.f9474d = motionEvent.getRawY();
                                this.f9475e = motionEvent.getX();
                                this.f9476f = motionEvent.getY();
                            } else if (action != 1) {
                                if (action == 2) {
                                    this.f9475e = motionEvent.getX();
                                    this.f9476f = motionEvent.getY();
                                }
                            } else if (Math.abs(this.f9475e - this.f9471a) <= 15.0f && Math.abs(this.f9476f - this.f9472b) <= 15.0f && RegionClickUtil.this.f9464d != null) {
                                RegionClickUtil.this.f9464d.mo49677a(String.valueOf(this.f9471a), String.valueOf(this.f9472b), String.valueOf(this.f9473c), String.valueOf(this.f9474d), String.valueOf(this.f9471a), String.valueOf(this.f9472b), String.valueOf(this.f9473c), String.valueOf(this.f9474d));
                            }
                            return true;
                        }
                    });
                }
                if (!TextUtils.isEmpty(this.f9469i)) {
                    textView.setText(this.f9469i);
                }
                if (TextUtils.isEmpty(this.f9466f)) {
                    this.f9466f = "#FFFFFF";
                }
                if (!TextUtils.isEmpty(this.f9466f) && this.f9466f.startsWith("#")) {
                    textView.setTextColor(Color.parseColor(this.f9466f));
                }
                if (TextUtils.isEmpty(this.f9467g)) {
                    this.f9467g = "#80000000";
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (!TextUtils.isEmpty(this.f9467g) && this.f9467g.startsWith("#")) {
                    gradientDrawable.setColor(Color.parseColor(this.f9467g));
                }
                double d = this.f9468h;
                if (d > Utils.DOUBLE_EPSILON) {
                    gradientDrawable.setAlpha((int) (d * 255.0d));
                }
                gradientDrawable.setCornerRadius(ViewUtil.dip2px(this.f9461a, 7.0f));
                textView.setBackgroundDrawable(gradientDrawable);
                int[] m50149b = m50149b(viewGroup);
                try {
                    textView.setTextSize(2, (float) (m50149b[1] > 0 ? ViewUtil.px2dip(this.f9461a, m50149b[1]) / 3 : 14.0d));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    if (m50149b[0] > 0) {
                        layoutParams.width = m50149b[0];
                    }
                    if (m50149b[1] > 0) {
                        layoutParams.height = m50149b[1];
                    }
                    layoutParams.leftMargin = m50149b[2];
                    layoutParams.topMargin = m50149b[3];
                    layoutParams.addRule(17);
                    viewGroup.addView(textView, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    if (m50149b[0] > 0) {
                        layoutParams2.width = m50149b[0];
                    }
                    if (m50149b[1] > 0) {
                        layoutParams2.height = m50149b[1];
                    }
                    layoutParams2.leftMargin = m50149b[2];
                    layoutParams2.topMargin = m50149b[3];
                    viewGroup.addView(textView, layoutParams2);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    if (m50149b[0] > 0) {
                        layoutParams3.width = m50149b[0];
                    }
                    if (m50149b[1] > 0) {
                        layoutParams3.height = m50149b[1];
                    }
                    layoutParams3.leftMargin = m50149b[2];
                    layoutParams3.topMargin = m50149b[3];
                    viewGroup.addView(textView, layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    if (m50149b[0] > 0) {
                        layoutParams4.width = m50149b[0];
                    }
                    if (m50149b[1] > 0) {
                        layoutParams4.height = m50149b[1];
                    }
                    viewGroup.addView(textView, layoutParams4);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m50152a(InterfaceC2766a interfaceC2766a) {
        this.f9464d = interfaceC2766a;
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean m50150a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
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

    /* renamed from: a */
    public void m50154a() {
        this.f9462b = null;
        this.f9463c = null;
        this.f9465e = null;
        this.f9464d = null;
        this.f9461a = null;
    }
}
