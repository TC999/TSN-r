package com.beizi.fusion.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ScrollClickView extends LinearLayout {
    public static final String DIR_DOWN = "down";
    public static final String DIR_LEFT = "left";
    public static final String DIR_RIGHT = "right";
    public static final String DIR_UP = "up";

    /* renamed from: a */
    ImageView f11635a;

    /* renamed from: b */
    ImageView f11636b;

    /* renamed from: c */
    TextView f11637c;

    /* renamed from: d */
    TextView f11638d;

    /* renamed from: e */
    private boolean f11639e;

    /* renamed from: f */
    private String f11640f;

    /* renamed from: g */
    private String f11641g;

    /* renamed from: h */
    private int f11642h;

    /* renamed from: i */
    private int f11643i;

    /* renamed from: j */
    private String f11644j;

    /* renamed from: k */
    private int f11645k;

    /* renamed from: l */
    private int f11646l;

    /* renamed from: m */
    private ValueAnimator f11647m;

    /* renamed from: n */
    private Context f11648n;

    /* renamed from: o */
    private FrameLayout f11649o;

    /* renamed from: p */
    private FrameLayout f11650p;

    /* renamed from: q */
    private LinearLayout f11651q;

    public ScrollClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11639e = false;
        this.f11644j = "up";
        this.f11645k = 45;
        this.f11646l = 180;
        this.f11651q = null;
        init(context);
    }

    public void buildRealView() {
        try {
            if ("up".equalsIgnoreCase(this.f11644j)) {
                this.f11651q = (LinearLayout) LayoutInflater.from(this.f11648n).inflate(C3025R.C3029layout.layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.f11644j)) {
                this.f11651q = (LinearLayout) LayoutInflater.from(this.f11648n).inflate(C3025R.C3029layout.layout_scrollview_down, this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if ("up".equalsIgnoreCase(this.f11644j)) {
                this.f11651q = (LinearLayout) LayoutInflater.from(StubApp.getOrigApplicationContext(this.f11648n.getApplicationContext())).inflate(C3025R.C3029layout.layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.f11644j)) {
                this.f11651q = (LinearLayout) LayoutInflater.from(StubApp.getOrigApplicationContext(this.f11648n.getApplicationContext())).inflate(C3025R.C3029layout.layout_scrollview_down, this);
            }
        }
        try {
            LinearLayout linearLayout = this.f11651q;
            if (linearLayout == null) {
                return;
            }
            this.f11635a = (ImageView) linearLayout.findViewById(C3025R.C3028id.hand);
            this.f11636b = (ImageView) this.f11651q.findViewById(C3025R.C3028id.scrollbar);
            this.f11637c = (TextView) this.f11651q.findViewById(C3025R.C3028id.title);
            this.f11638d = (TextView) this.f11651q.findViewById(C3025R.C3028id.details);
            this.f11649o = (FrameLayout) this.f11651q.findViewById(C3025R.C3028id.scroll_container);
            this.f11650p = (FrameLayout) this.f11651q.findViewById(C3025R.C3028id.scrollbar_container);
            this.f11645k = C3138av.m48304a(this.f11648n, this.f11645k);
            this.f11646l = C3138av.m48304a(this.f11648n, this.f11646l) + this.f11645k;
            TextView textView = this.f11637c;
            if (textView != null) {
                textView.setText(this.f11640f);
                this.f11637c.setTextSize(2, this.f11642h);
            }
            TextView textView2 = this.f11638d;
            if (textView2 != null) {
                textView2.setText(this.f11641g);
                this.f11638d.setTextSize(2, this.f11643i);
            }
            ImageView imageView = this.f11635a;
            if (imageView == null || this.f11636b == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f11636b.getLayoutParams();
            if (layoutParams != null) {
                int i = this.f11645k;
                layoutParams.width = i;
                layoutParams.height = i;
                if (layoutParams2 != null) {
                    layoutParams2.height = this.f11646l;
                    layoutParams2.width = (int) (i * 0.55f);
                }
            }
            if (DIR_DOWN.equalsIgnoreCase(this.f11644j)) {
                m48055b();
            } else if ("up".equalsIgnoreCase(this.f11644j)) {
                m48058a();
            } else if (DIR_LEFT.equalsIgnoreCase(this.f11644j)) {
            } else {
                DIR_RIGHT.equalsIgnoreCase(this.f11644j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.f11639e) {
            return;
        }
        this.f11648n = context;
        this.f11639e = true;
    }

    public void setDetailText(String str) {
        this.f11641g = str;
    }

    public void setDetailsFont(int i) {
        this.f11643i = i;
    }

    public void setHandWidth(int i) {
        this.f11645k = i;
    }

    public void setScrollDirection(String str) {
        this.f11644j = str;
    }

    public void setScrollbarHeight(int i) {
        this.f11646l = i;
    }

    public void setTitleFont(int i) {
        this.f11642h = i;
    }

    public void setTitleText(String str) {
        this.f11640f = str;
    }

    public void startAnim() {
        StringBuilder sb = new StringBuilder();
        sb.append("startAnim animator != null ? ");
        sb.append(this.f11647m != null);
        C3116af.m48495b("ScrollClickUtil", sb.toString());
        try {
            ValueAnimator valueAnimator = this.f11647m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopAnim() {
        try {
            ValueAnimator valueAnimator = this.f11647m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f11647m.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m48055b() {
        try {
            this.f11635a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.f11649o != null && ScrollClickView.this.f11650p != null) {
                            if (ScrollClickView.this.f11635a.getLayoutParams() == null) {
                                return;
                            }
                            final int i = ScrollClickView.this.f11635a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.f11647m = ValueAnimator.ofInt(i, scrollClickView.f11646l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f11636b.getLayoutParams();
                            C3116af.m48495b("ScrollClickUtil", "handHeight = " + i);
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.f11646l;
                            }
                            ScrollClickView.this.f11647m.setDuration(1000L);
                            ScrollClickView.this.f11647m.setRepeatCount(-1);
                            ScrollClickView.this.f11647m.setRepeatMode(1);
                            ScrollClickView.this.f11647m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.2.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f11649o.getLayoutParams();
                                        if (layoutParams2 != null) {
                                            layoutParams2.height = intValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.f11650p.getLayoutParams();
                                        if (layoutParams3 != null) {
                                            layoutParams3.height = intValue - (i / 3);
                                        }
                                        ScrollClickView.this.f11649o.requestLayout();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        C3116af.m48495b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m48058a() {
        try {
            this.f11635a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.f11649o != null && ScrollClickView.this.f11650p != null) {
                            if (ScrollClickView.this.f11635a.getLayoutParams() == null) {
                                return;
                            }
                            final int i = ScrollClickView.this.f11635a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.f11647m = ValueAnimator.ofInt(i, scrollClickView.f11646l);
                            C3116af.m48495b("ScrollClickUtil", "handHeight = " + i + ",scrollbarHeight = " + ScrollClickView.this.f11646l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f11636b.getLayoutParams();
                            StringBuilder sb = new StringBuilder();
                            sb.append("handHeight = ");
                            sb.append(i);
                            C3116af.m48495b("ScrollClickUtil", sb.toString());
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.f11646l;
                            }
                            ScrollClickView.this.f11647m.setDuration(1000L);
                            ScrollClickView.this.f11647m.setRepeatCount(-1);
                            ScrollClickView.this.f11647m.setRepeatMode(1);
                            ScrollClickView.this.f11647m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.1.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f11635a.getLayoutParams();
                                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                            ((FrameLayout.LayoutParams) layoutParams2).topMargin = ScrollClickView.this.f11646l - intValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.f11650p.getLayoutParams();
                                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                                            layoutParams3.height = intValue - (i / 3);
                                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                                            layoutParams4.topMargin = ScrollClickView.this.f11646l - layoutParams4.height;
                                        }
                                        ScrollClickView.this.f11649o.requestLayout();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        C3116af.m48495b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ScrollClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11639e = false;
        this.f11644j = "up";
        this.f11645k = 45;
        this.f11646l = 180;
        this.f11651q = null;
        init(context);
    }

    public ScrollClickView(Context context) {
        super(context);
        this.f11639e = false;
        this.f11644j = "up";
        this.f11645k = 45;
        this.f11646l = 180;
        this.f11651q = null;
        init(context);
    }
}
