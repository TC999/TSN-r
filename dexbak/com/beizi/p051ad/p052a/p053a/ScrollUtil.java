package com.beizi.p051ad.p052a.p053a;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.tencent.connect.common.Constants;
import java.util.List;

/* renamed from: com.beizi.ad.a.a.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ScrollUtil {

    /* renamed from: a */
    private Context f9478a;

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.ScrollClickBean f9479b;

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.ScrollClickBean f9480c;

    /* renamed from: d */
    private AdSpacesBean.BuyerBean.ScrollClickPositionBean f9481d;

    /* renamed from: f */
    private View f9483f;

    /* renamed from: g */
    private String f9484g;

    /* renamed from: l */
    private int f9489l;

    /* renamed from: m */
    private ValueAnimator f9490m;

    /* renamed from: n */
    private int f9491n;

    /* renamed from: o */
    private ImageView f9492o;

    /* renamed from: p */
    private ImageView f9493p;

    /* renamed from: q */
    private ImageView f9494q;

    /* renamed from: u */
    private LinearLayout f9498u;

    /* renamed from: e */
    private InterfaceC2770a f9482e = null;

    /* renamed from: h */
    private String f9485h = "up";

    /* renamed from: i */
    private String f9486i = ScrollClickView.DIR_DOWN;

    /* renamed from: j */
    private String f9487j = ScrollClickView.DIR_LEFT;

    /* renamed from: k */
    private String f9488k = ScrollClickView.DIR_RIGHT;

    /* renamed from: r */
    private String f9495r = "#9CBBFF";

    /* renamed from: s */
    private String f9496s = "#C1D4FF";

    /* renamed from: t */
    private String f9497t = "#FFFFFF";

    /* compiled from: ScrollUtil.java */
    /* renamed from: com.beizi.ad.a.a.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2770a {
        /* renamed from: a */
        void mo49675a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        /* renamed from: b */
        void mo49674b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public ScrollUtil(Context context, AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean, String str, String str2) {
        try {
            this.f9478a = context;
            this.f9479b = scrollClickBean;
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m50143a = m50143a(scrollClickBean.getOrderData(), str2);
            if (m50143a != null && m50143a.getScrollClick() != null) {
                this.f9480c = m50143a.getScrollClick();
            }
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.f9480c;
            if (scrollClickBean2 != null) {
                this.f9484g = scrollClickBean2.getScrollDirection();
                this.f9489l = this.f9480c.getScrollDistance();
                this.f9481d = this.f9480c.getPosition();
                return;
            }
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean3 = this.f9479b;
            if (scrollClickBean3 != null) {
                this.f9484g = scrollClickBean3.getScrollDirection();
                this.f9489l = this.f9479b.getScrollDistance();
                this.f9481d = this.f9479b.getPosition();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    static /* synthetic */ int m50132h(ScrollUtil scrollUtil) {
        int i = scrollUtil.f9491n;
        scrollUtil.f9491n = i + 1;
        return i;
    }

    /* renamed from: b */
    private void m50142b() {
        this.f9498u.setGravity(17);
        int i = this.f9498u.getLayoutParams().width;
        int i2 = this.f9498u.getLayoutParams().height;
        this.f9492o = new ImageView(this.f9478a);
        this.f9493p = new ImageView(this.f9478a);
        this.f9494q = new ImageView(this.f9478a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f9485h.equals(this.f9484g)) {
            this.f9498u.setOrientation(1);
            ImageView imageView = this.f9492o;
            int i3 = C2750R.mipmap.beizi_interaction_icon_arrow_up;
            imageView.setImageResource(i3);
            this.f9493p.setImageResource(i3);
            this.f9494q.setImageResource(i3);
            this.f9492o.setColorFilter(Color.parseColor(this.f9495r));
            this.f9493p.setColorFilter(Color.parseColor(this.f9496s));
            this.f9494q.setColorFilter(Color.parseColor(this.f9497t));
            layoutParams.width = i;
            layoutParams.height = i2 / 3;
        } else if (this.f9486i.equals(this.f9484g)) {
            this.f9498u.setOrientation(1);
            ImageView imageView2 = this.f9492o;
            int i4 = C2750R.mipmap.beizi_interaction_icon_arrow_down;
            imageView2.setImageResource(i4);
            this.f9493p.setImageResource(i4);
            this.f9494q.setImageResource(i4);
            this.f9492o.setColorFilter(Color.parseColor(this.f9497t));
            this.f9493p.setColorFilter(Color.parseColor(this.f9496s));
            this.f9494q.setColorFilter(Color.parseColor(this.f9495r));
            layoutParams.width = i;
            layoutParams.height = i2 / 3;
        } else if (this.f9487j.equals(this.f9484g)) {
            this.f9498u.setOrientation(0);
            ImageView imageView3 = this.f9492o;
            int i5 = C2750R.mipmap.beizi_interaction_icon_arrow_left;
            imageView3.setImageResource(i5);
            this.f9493p.setImageResource(i5);
            this.f9494q.setImageResource(i5);
            this.f9492o.setColorFilter(Color.parseColor(this.f9495r));
            this.f9493p.setColorFilter(Color.parseColor(this.f9496s));
            this.f9494q.setColorFilter(Color.parseColor(this.f9497t));
            layoutParams.width = i / 3;
            layoutParams.height = i2;
        } else if (this.f9488k.equals(this.f9484g)) {
            this.f9498u.setOrientation(0);
            ImageView imageView4 = this.f9492o;
            int i6 = C2750R.mipmap.beizi_interaction_icon_arrow_right;
            imageView4.setImageResource(i6);
            this.f9493p.setImageResource(i6);
            this.f9494q.setImageResource(i6);
            this.f9492o.setColorFilter(Color.parseColor(this.f9497t));
            this.f9493p.setColorFilter(Color.parseColor(this.f9496s));
            this.f9494q.setColorFilter(Color.parseColor(this.f9495r));
            layoutParams.width = i / 3;
            layoutParams.height = i2;
        }
        this.f9498u.addView(this.f9492o, layoutParams);
        this.f9498u.addView(this.f9493p, layoutParams);
        this.f9498u.addView(this.f9494q, layoutParams);
    }

    /* renamed from: c */
    private void m50139c() {
        View view = this.f9483f;
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.d.1

            /* renamed from: a */
            float f9499a;

            /* renamed from: b */
            float f9500b;

            /* renamed from: c */
            float f9501c;

            /* renamed from: d */
            float f9502d;

            /* renamed from: e */
            float f9503e;

            /* renamed from: f */
            float f9504f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f9499a = motionEvent.getX();
                    this.f9500b = motionEvent.getY();
                    this.f9501c = motionEvent.getX();
                    this.f9502d = motionEvent.getY();
                    this.f9503e = motionEvent.getRawX();
                    this.f9504f = motionEvent.getRawY();
                } else if (action == 1) {
                    LogUtil.m49045b("BeiZisAd", "mCurPosX = " + this.f9501c + ",mCurPosY = " + this.f9502d + ",mPosX = " + this.f9499a + ",mPosY = " + this.f9500b);
                    float f = this.f9502d;
                    float f2 = this.f9500b;
                    if (f - f2 > 0.0f && Math.abs(f - f2) > ScrollUtil.this.f9489l) {
                        if (ScrollUtil.this.f9486i.equalsIgnoreCase(ScrollUtil.this.f9484g) && ScrollUtil.this.f9482e != null) {
                            ScrollUtil.this.f9482e.mo49675a(this.f9499a + "", this.f9500b + "", this.f9503e + "", this.f9504f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        float f3 = this.f9502d;
                        float f4 = this.f9500b;
                        if (f3 - f4 < 0.0f && Math.abs(f3 - f4) > ScrollUtil.this.f9489l) {
                            if (ScrollUtil.this.f9485h.equalsIgnoreCase(ScrollUtil.this.f9484g) && ScrollUtil.this.f9482e != null) {
                                ScrollUtil.this.f9482e.mo49675a(this.f9499a + "", this.f9500b + "", this.f9503e + "", this.f9504f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            float f5 = this.f9501c;
                            float f6 = this.f9499a;
                            if (f5 - f6 < 0.0f && Math.abs(f5 - f6) > ScrollUtil.this.f9489l) {
                                if (ScrollUtil.this.f9487j.equalsIgnoreCase(ScrollUtil.this.f9484g) && ScrollUtil.this.f9482e != null) {
                                    ScrollUtil.this.f9482e.mo49675a(this.f9499a + "", this.f9500b + "", this.f9503e + "", this.f9504f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                float f7 = this.f9501c;
                                float f8 = this.f9499a;
                                if (f7 - f8 > 0.0f && Math.abs(f7 - f8) > ScrollUtil.this.f9489l) {
                                    if (ScrollUtil.this.f9488k.equalsIgnoreCase(ScrollUtil.this.f9484g) && ScrollUtil.this.f9482e != null) {
                                        ScrollUtil.this.f9482e.mo49675a(this.f9499a + "", this.f9500b + "", this.f9503e + "", this.f9504f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else if (Math.abs(this.f9501c - this.f9499a) <= 15.0f && Math.abs(this.f9502d - this.f9500b) <= 15.0f && ScrollUtil.this.f9482e != null) {
                                    ScrollUtil.this.f9482e.mo49674b(this.f9499a + "", this.f9500b + "", this.f9503e + "", this.f9504f + "", this.f9499a + "", this.f9500b + "", this.f9503e + "", this.f9504f + "");
                                }
                            }
                        }
                    }
                } else if (action == 2) {
                    this.f9501c = motionEvent.getX();
                    this.f9502d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    /* renamed from: d */
    private void m50137d() {
        try {
            ValueAnimator ofInt = ValueAnimator.ofInt(10, 0);
            this.f9490m = ofInt;
            ofInt.setDuration(500L);
            this.f9490m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.ad.a.a.d.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.f9490m.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.ad.a.a.d.3
                /* JADX WARN: Removed duplicated region for block: B:32:0x01f0 A[Catch: Exception -> 0x0208, TryCatch #0 {Exception -> 0x0208, blocks: (B:3:0x0007, B:5:0x0021, B:8:0x0035, B:10:0x0047, B:30:0x01e8, B:32:0x01f0, B:33:0x01f6, B:35:0x01fe, B:12:0x0059, B:14:0x0061, B:15:0x009c, B:17:0x00a4, B:18:0x00df, B:20:0x00e7, B:21:0x0122, B:23:0x012a, B:24:0x0165, B:26:0x016d, B:27:0x01a7, B:29:0x01af), top: B:40:0x0007 }] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x01fe A[Catch: Exception -> 0x0208, TRY_LEAVE, TryCatch #0 {Exception -> 0x0208, blocks: (B:3:0x0007, B:5:0x0021, B:8:0x0035, B:10:0x0047, B:30:0x01e8, B:32:0x01f0, B:33:0x01f6, B:35:0x01fe, B:12:0x0059, B:14:0x0061, B:15:0x009c, B:17:0x00a4, B:18:0x00df, B:20:0x00e7, B:21:0x0122, B:23:0x012a, B:24:0x0165, B:26:0x016d, B:27:0x01a7, B:29:0x01af), top: B:40:0x0007 }] */
                /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onAnimationEnd(android.animation.Animator r5) {
                    /*
                        Method dump skipped, instructions count: 525
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.p052a.p053a.ScrollUtil.C27693.onAnimationEnd(android.animation.Animator):void");
                }
            });
            ValueAnimator valueAnimator = this.f9490m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m50146a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f9478a == null) {
                    return;
                }
                this.f9498u = new LinearLayout(this.f9478a);
                int[] m50141b = m50141b(viewGroup);
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    if (m50141b[0] > 0) {
                        layoutParams.width = m50141b[0];
                    }
                    if (m50141b[1] > 0) {
                        layoutParams.height = m50141b[1];
                    }
                    layoutParams.leftMargin = m50141b[2];
                    layoutParams.topMargin = m50141b[3];
                    layoutParams.addRule(17);
                    viewGroup.addView(this.f9498u, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    if (m50141b[0] > 0) {
                        layoutParams2.width = m50141b[0];
                    }
                    if (m50141b[1] > 0) {
                        layoutParams2.height = m50141b[1];
                    }
                    layoutParams2.leftMargin = m50141b[2];
                    layoutParams2.topMargin = m50141b[3];
                    viewGroup.addView(this.f9498u, layoutParams2);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    if (m50141b[0] > 0) {
                        layoutParams3.width = m50141b[0];
                    }
                    if (m50141b[1] > 0) {
                        layoutParams3.height = m50141b[1];
                    }
                    layoutParams3.leftMargin = m50141b[2];
                    layoutParams3.topMargin = m50141b[3];
                    viewGroup.addView(this.f9498u, layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    if (m50141b[0] > 0) {
                        layoutParams4.width = m50141b[0];
                    }
                    if (m50141b[1] > 0) {
                        layoutParams4.height = m50141b[1];
                    }
                    viewGroup.addView(this.f9498u, layoutParams4);
                }
                m50142b();
                m50137d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m50147a(View view, InterfaceC2770a interfaceC2770a) {
        this.f9483f = view;
        this.f9482e = interfaceC2770a;
        m50139c();
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m50143a(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m50148a() {
        try {
            this.f9483f = null;
            this.f9482e = null;
            this.f9480c = null;
            this.f9479b = null;
            ValueAnimator valueAnimator = this.f9490m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f9490m.removeAllListeners();
            }
            this.f9490m = null;
            this.f9492o = null;
            this.f9493p = null;
            this.f9494q = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private int[] m50141b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                scrollClickPositionBean = this.f9481d;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (scrollClickPositionBean != null) {
                String centerX = scrollClickPositionBean.getCenterX();
                String top2 = this.f9481d.getTop();
                String width = this.f9481d.getWidth();
                String height = this.f9481d.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                }
                if (TextUtils.isEmpty(top2) || "0".equals(top2)) {
                    top2 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                }
                viewGroup.measure(0, 0);
                int px2dip = ViewUtil.px2dip(this.f9478a, viewGroup.getMeasuredWidth());
                int px2dip2 = ViewUtil.px2dip(this.f9478a, viewGroup.getMeasuredHeight());
                if (px2dip <= 0) {
                    px2dip = SystemUtil.m49022k(this.f9478a);
                }
                LogUtil.m49046a("ScrollUtil", "position containerWidth:" + px2dip + ";containerHeight:" + px2dip2 + ";" + viewGroup.getLayoutParams().width + ";" + viewGroup.getLayoutParams().height);
                width = (TextUtils.isEmpty(width) || "0".equals(width)) ? "20" : "20";
                height = (TextUtils.isEmpty(height) || "0".equals(height)) ? "20" : "20";
                if (centerX.endsWith("%")) {
                    parseInt = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * px2dip) / 100;
                } else {
                    parseInt = !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                }
                if (top2.endsWith("%")) {
                    parseInt2 = (px2dip2 * Integer.parseInt(top2.substring(0, top2.indexOf("%")))) / 100;
                } else {
                    parseInt2 = !TextUtils.isEmpty(top2) ? Integer.parseInt(top2) : 0;
                }
                int i = 20;
                if (width.endsWith("%")) {
                    parseInt3 = (px2dip * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    parseInt3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 20;
                }
                if (height.endsWith("%")) {
                    i = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt3) / 100;
                } else if (!TextUtils.isEmpty(width)) {
                    i = Integer.parseInt(height);
                }
                int dip2px = ViewUtil.dip2px(this.f9478a, parseInt3);
                int dip2px2 = ViewUtil.dip2px(this.f9478a, i);
                int dip2px3 = ViewUtil.dip2px(this.f9478a, parseInt);
                int dip2px4 = ViewUtil.dip2px(this.f9478a, parseInt2);
                iArr[0] = dip2px;
                iArr[1] = dip2px2;
                if (dip2px3 > 0) {
                    iArr[2] = dip2px3;
                }
                if (dip2px4 > 0) {
                    iArr[3] = dip2px4;
                }
                LogUtil.m49046a("ScrollUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + ";" + centerX + ";" + top2);
                return iArr;
            }
        }
        int dip2px5 = ViewUtil.dip2px(this.f9478a, 20.0f);
        int dip2px6 = ViewUtil.dip2px(this.f9478a, 10.0f);
        iArr[0] = dip2px5;
        iArr[1] = dip2px5;
        iArr[2] = dip2px6;
        iArr[3] = dip2px6;
        return iArr;
    }
}
