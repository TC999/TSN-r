package com.beizi.ad.a.a;

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
import com.beizi.ad.R;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.p;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ScrollUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f13183a;

    /* renamed from: b  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ScrollClickBean f13184b;

    /* renamed from: c  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ScrollClickBean f13185c;

    /* renamed from: d  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ScrollClickPositionBean f13186d;

    /* renamed from: f  reason: collision with root package name */
    private View f13188f;

    /* renamed from: g  reason: collision with root package name */
    private String f13189g;

    /* renamed from: l  reason: collision with root package name */
    private int f13194l;

    /* renamed from: m  reason: collision with root package name */
    private ValueAnimator f13195m;

    /* renamed from: n  reason: collision with root package name */
    private int f13196n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView f13197o;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f13198p;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f13199q;

    /* renamed from: u  reason: collision with root package name */
    private LinearLayout f13203u;

    /* renamed from: e  reason: collision with root package name */
    private a f13187e = null;

    /* renamed from: h  reason: collision with root package name */
    private String f13190h = "up";

    /* renamed from: i  reason: collision with root package name */
    private String f13191i = "down";

    /* renamed from: j  reason: collision with root package name */
    private String f13192j = "left";

    /* renamed from: k  reason: collision with root package name */
    private String f13193k = "right";

    /* renamed from: r  reason: collision with root package name */
    private String f13200r = "#9CBBFF";

    /* renamed from: s  reason: collision with root package name */
    private String f13201s = "#C1D4FF";

    /* renamed from: t  reason: collision with root package name */
    private String f13202t = "#FFFFFF";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ScrollUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public d(Context context, AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean, String str, String str2) {
        try {
            this.f13183a = context;
            this.f13184b = scrollClickBean;
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean a4 = a(scrollClickBean.getOrderData(), str2);
            if (a4 != null && a4.getScrollClick() != null) {
                this.f13185c = a4.getScrollClick();
            }
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.f13185c;
            if (scrollClickBean2 != null) {
                this.f13189g = scrollClickBean2.getScrollDirection();
                this.f13194l = this.f13185c.getScrollDistance();
                this.f13186d = this.f13185c.getPosition();
                return;
            }
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean3 = this.f13184b;
            if (scrollClickBean3 != null) {
                this.f13189g = scrollClickBean3.getScrollDirection();
                this.f13194l = this.f13184b.getScrollDistance();
                this.f13186d = this.f13184b.getPosition();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    static /* synthetic */ int h(d dVar) {
        int i4 = dVar.f13196n;
        dVar.f13196n = i4 + 1;
        return i4;
    }

    private void b() {
        this.f13203u.setGravity(17);
        int i4 = this.f13203u.getLayoutParams().width;
        int i5 = this.f13203u.getLayoutParams().height;
        this.f13197o = new ImageView(this.f13183a);
        this.f13198p = new ImageView(this.f13183a);
        this.f13199q = new ImageView(this.f13183a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f13190h.equals(this.f13189g)) {
            this.f13203u.setOrientation(1);
            ImageView imageView = this.f13197o;
            int i6 = R.mipmap.beizi_interaction_icon_arrow_up;
            imageView.setImageResource(i6);
            this.f13198p.setImageResource(i6);
            this.f13199q.setImageResource(i6);
            this.f13197o.setColorFilter(Color.parseColor(this.f13200r));
            this.f13198p.setColorFilter(Color.parseColor(this.f13201s));
            this.f13199q.setColorFilter(Color.parseColor(this.f13202t));
            layoutParams.width = i4;
            layoutParams.height = i5 / 3;
        } else if (this.f13191i.equals(this.f13189g)) {
            this.f13203u.setOrientation(1);
            ImageView imageView2 = this.f13197o;
            int i7 = R.mipmap.beizi_interaction_icon_arrow_down;
            imageView2.setImageResource(i7);
            this.f13198p.setImageResource(i7);
            this.f13199q.setImageResource(i7);
            this.f13197o.setColorFilter(Color.parseColor(this.f13202t));
            this.f13198p.setColorFilter(Color.parseColor(this.f13201s));
            this.f13199q.setColorFilter(Color.parseColor(this.f13200r));
            layoutParams.width = i4;
            layoutParams.height = i5 / 3;
        } else if (this.f13192j.equals(this.f13189g)) {
            this.f13203u.setOrientation(0);
            ImageView imageView3 = this.f13197o;
            int i8 = R.mipmap.beizi_interaction_icon_arrow_left;
            imageView3.setImageResource(i8);
            this.f13198p.setImageResource(i8);
            this.f13199q.setImageResource(i8);
            this.f13197o.setColorFilter(Color.parseColor(this.f13200r));
            this.f13198p.setColorFilter(Color.parseColor(this.f13201s));
            this.f13199q.setColorFilter(Color.parseColor(this.f13202t));
            layoutParams.width = i4 / 3;
            layoutParams.height = i5;
        } else if (this.f13193k.equals(this.f13189g)) {
            this.f13203u.setOrientation(0);
            ImageView imageView4 = this.f13197o;
            int i9 = R.mipmap.beizi_interaction_icon_arrow_right;
            imageView4.setImageResource(i9);
            this.f13198p.setImageResource(i9);
            this.f13199q.setImageResource(i9);
            this.f13197o.setColorFilter(Color.parseColor(this.f13202t));
            this.f13198p.setColorFilter(Color.parseColor(this.f13201s));
            this.f13199q.setColorFilter(Color.parseColor(this.f13200r));
            layoutParams.width = i4 / 3;
            layoutParams.height = i5;
        }
        this.f13203u.addView(this.f13197o, layoutParams);
        this.f13203u.addView(this.f13198p, layoutParams);
        this.f13203u.addView(this.f13199q, layoutParams);
    }

    private void c() {
        View view = this.f13188f;
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.d.1

            /* renamed from: a  reason: collision with root package name */
            float f13204a;

            /* renamed from: b  reason: collision with root package name */
            float f13205b;

            /* renamed from: c  reason: collision with root package name */
            float f13206c;

            /* renamed from: d  reason: collision with root package name */
            float f13207d;

            /* renamed from: e  reason: collision with root package name */
            float f13208e;

            /* renamed from: f  reason: collision with root package name */
            float f13209f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f13204a = motionEvent.getX();
                    this.f13205b = motionEvent.getY();
                    this.f13206c = motionEvent.getX();
                    this.f13207d = motionEvent.getY();
                    this.f13208e = motionEvent.getRawX();
                    this.f13209f = motionEvent.getRawY();
                } else if (action == 1) {
                    l.b("BeiZisAd", "mCurPosX = " + this.f13206c + ",mCurPosY = " + this.f13207d + ",mPosX = " + this.f13204a + ",mPosY = " + this.f13205b);
                    float f4 = this.f13207d;
                    float f5 = this.f13205b;
                    if (f4 - f5 > 0.0f && Math.abs(f4 - f5) > d.this.f13194l) {
                        if (d.this.f13191i.equalsIgnoreCase(d.this.f13189g) && d.this.f13187e != null) {
                            d.this.f13187e.a(this.f13204a + "", this.f13205b + "", this.f13208e + "", this.f13209f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        float f6 = this.f13207d;
                        float f7 = this.f13205b;
                        if (f6 - f7 < 0.0f && Math.abs(f6 - f7) > d.this.f13194l) {
                            if (d.this.f13190h.equalsIgnoreCase(d.this.f13189g) && d.this.f13187e != null) {
                                d.this.f13187e.a(this.f13204a + "", this.f13205b + "", this.f13208e + "", this.f13209f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            float f8 = this.f13206c;
                            float f9 = this.f13204a;
                            if (f8 - f9 < 0.0f && Math.abs(f8 - f9) > d.this.f13194l) {
                                if (d.this.f13192j.equalsIgnoreCase(d.this.f13189g) && d.this.f13187e != null) {
                                    d.this.f13187e.a(this.f13204a + "", this.f13205b + "", this.f13208e + "", this.f13209f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                float f10 = this.f13206c;
                                float f11 = this.f13204a;
                                if (f10 - f11 > 0.0f && Math.abs(f10 - f11) > d.this.f13194l) {
                                    if (d.this.f13193k.equalsIgnoreCase(d.this.f13189g) && d.this.f13187e != null) {
                                        d.this.f13187e.a(this.f13204a + "", this.f13205b + "", this.f13208e + "", this.f13209f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else if (Math.abs(this.f13206c - this.f13204a) <= 15.0f && Math.abs(this.f13207d - this.f13205b) <= 15.0f && d.this.f13187e != null) {
                                    d.this.f13187e.b(this.f13204a + "", this.f13205b + "", this.f13208e + "", this.f13209f + "", this.f13204a + "", this.f13205b + "", this.f13208e + "", this.f13209f + "");
                                }
                            }
                        }
                    }
                } else if (action == 2) {
                    this.f13206c = motionEvent.getX();
                    this.f13207d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    private void d() {
        try {
            ValueAnimator ofInt = ValueAnimator.ofInt(10, 0);
            this.f13195m = ofInt;
            ofInt.setDuration(500L);
            this.f13195m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.ad.a.a.d.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.f13195m.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.ad.a.a.d.3
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
                    throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.d.AnonymousClass3.onAnimationEnd(android.animation.Animator):void");
                }
            });
            ValueAnimator valueAnimator = this.f13195m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f13183a == null) {
                    return;
                }
                this.f13203u = new LinearLayout(this.f13183a);
                int[] b4 = b(viewGroup);
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
                    viewGroup.addView(this.f13203u, layoutParams);
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
                    viewGroup.addView(this.f13203u, layoutParams2);
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
                    viewGroup.addView(this.f13203u, layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    if (b4[0] > 0) {
                        layoutParams4.width = b4[0];
                    }
                    if (b4[1] > 0) {
                        layoutParams4.height = b4[1];
                    }
                    viewGroup.addView(this.f13203u, layoutParams4);
                }
                b();
                d();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void a(View view, a aVar) {
        this.f13188f = view;
        this.f13187e = aVar;
        c();
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean a(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
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

    public void a() {
        try {
            this.f13188f = null;
            this.f13187e = null;
            this.f13185c = null;
            this.f13184b = null;
            ValueAnimator valueAnimator = this.f13195m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f13195m.removeAllListeners();
            }
            this.f13195m = null;
            this.f13197o = null;
            this.f13198p = null;
            this.f13199q = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private int[] b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                scrollClickPositionBean = this.f13186d;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (scrollClickPositionBean != null) {
                String centerX = scrollClickPositionBean.getCenterX();
                String top2 = this.f13186d.getTop();
                String width = this.f13186d.getWidth();
                String height = this.f13186d.getHeight();
                centerX = (TextUtils.isEmpty(centerX) || "0".equals(centerX)) ? "10" : "10";
                top2 = (TextUtils.isEmpty(top2) || "0".equals(top2)) ? "10" : "10";
                viewGroup.measure(0, 0);
                int px2dip = ViewUtil.px2dip(this.f13183a, viewGroup.getMeasuredWidth());
                int px2dip2 = ViewUtil.px2dip(this.f13183a, viewGroup.getMeasuredHeight());
                if (px2dip <= 0) {
                    px2dip = p.k(this.f13183a);
                }
                l.a("ScrollUtil", "position containerWidth:" + px2dip + ";containerHeight:" + px2dip2 + ";" + viewGroup.getLayoutParams().width + ";" + viewGroup.getLayoutParams().height);
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
                int i4 = 20;
                if (width.endsWith("%")) {
                    parseInt3 = (px2dip * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    parseInt3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 20;
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt3) / 100;
                } else if (!TextUtils.isEmpty(width)) {
                    i4 = Integer.parseInt(height);
                }
                int dip2px = ViewUtil.dip2px(this.f13183a, parseInt3);
                int dip2px2 = ViewUtil.dip2px(this.f13183a, i4);
                int dip2px3 = ViewUtil.dip2px(this.f13183a, parseInt);
                int dip2px4 = ViewUtil.dip2px(this.f13183a, parseInt2);
                iArr[0] = dip2px;
                iArr[1] = dip2px2;
                if (dip2px3 > 0) {
                    iArr[2] = dip2px3;
                }
                if (dip2px4 > 0) {
                    iArr[3] = dip2px4;
                }
                l.a("ScrollUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + ";" + centerX + ";" + top2);
                return iArr;
            }
        }
        int dip2px5 = ViewUtil.dip2px(this.f13183a, 20.0f);
        int dip2px6 = ViewUtil.dip2px(this.f13183a, 10.0f);
        iArr[0] = dip2px5;
        iArr[1] = dip2px5;
        iArr[2] = dip2px6;
        iArr[3] = dip2px6;
        return iArr;
    }
}
