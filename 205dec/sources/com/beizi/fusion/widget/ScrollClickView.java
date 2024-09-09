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
import com.beizi.fusion.R;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ScrollClickView extends LinearLayout {
    public static final String DIR_DOWN = "down";
    public static final String DIR_LEFT = "left";
    public static final String DIR_RIGHT = "right";
    public static final String DIR_UP = "up";

    /* renamed from: a  reason: collision with root package name */
    ImageView f15222a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f15223b;

    /* renamed from: c  reason: collision with root package name */
    TextView f15224c;

    /* renamed from: d  reason: collision with root package name */
    TextView f15225d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15226e;

    /* renamed from: f  reason: collision with root package name */
    private String f15227f;

    /* renamed from: g  reason: collision with root package name */
    private String f15228g;

    /* renamed from: h  reason: collision with root package name */
    private int f15229h;

    /* renamed from: i  reason: collision with root package name */
    private int f15230i;

    /* renamed from: j  reason: collision with root package name */
    private String f15231j;

    /* renamed from: k  reason: collision with root package name */
    private int f15232k;

    /* renamed from: l  reason: collision with root package name */
    private int f15233l;

    /* renamed from: m  reason: collision with root package name */
    private ValueAnimator f15234m;

    /* renamed from: n  reason: collision with root package name */
    private Context f15235n;

    /* renamed from: o  reason: collision with root package name */
    private FrameLayout f15236o;

    /* renamed from: p  reason: collision with root package name */
    private FrameLayout f15237p;

    /* renamed from: q  reason: collision with root package name */
    private LinearLayout f15238q;

    public ScrollClickView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15226e = false;
        this.f15231j = "up";
        this.f15232k = 45;
        this.f15233l = 180;
        this.f15238q = null;
        init(context);
    }

    public void buildRealView() {
        try {
            if ("up".equalsIgnoreCase(this.f15231j)) {
                this.f15238q = (LinearLayout) LayoutInflater.from(this.f15235n).inflate(R.layout.layout_scrollview_up, this);
            } else if ("down".equalsIgnoreCase(this.f15231j)) {
                this.f15238q = (LinearLayout) LayoutInflater.from(this.f15235n).inflate(R.layout.layout_scrollview_down, this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if ("up".equalsIgnoreCase(this.f15231j)) {
                this.f15238q = (LinearLayout) LayoutInflater.from(StubApp.getOrigApplicationContext(this.f15235n.getApplicationContext())).inflate(R.layout.layout_scrollview_up, this);
            } else if ("down".equalsIgnoreCase(this.f15231j)) {
                this.f15238q = (LinearLayout) LayoutInflater.from(StubApp.getOrigApplicationContext(this.f15235n.getApplicationContext())).inflate(R.layout.layout_scrollview_down, this);
            }
        }
        try {
            LinearLayout linearLayout = this.f15238q;
            if (linearLayout == null) {
                return;
            }
            this.f15222a = (ImageView) linearLayout.findViewById(R.id.hand);
            this.f15223b = (ImageView) this.f15238q.findViewById(R.id.scrollbar);
            this.f15224c = (TextView) this.f15238q.findViewById(R.id.title);
            this.f15225d = (TextView) this.f15238q.findViewById(R.id.details);
            this.f15236o = (FrameLayout) this.f15238q.findViewById(R.id.scroll_container);
            this.f15237p = (FrameLayout) this.f15238q.findViewById(R.id.scrollbar_container);
            this.f15232k = aw.a(this.f15235n, this.f15232k);
            this.f15233l = aw.a(this.f15235n, this.f15233l) + this.f15232k;
            TextView textView = this.f15224c;
            if (textView != null) {
                textView.setText(this.f15227f);
                this.f15224c.setTextSize(2, this.f15229h);
            }
            TextView textView2 = this.f15225d;
            if (textView2 != null) {
                textView2.setText(this.f15228g);
                this.f15225d.setTextSize(2, this.f15230i);
            }
            ImageView imageView = this.f15222a;
            if (imageView == null || this.f15223b == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f15223b.getLayoutParams();
            if (layoutParams != null) {
                int i4 = this.f15232k;
                layoutParams.width = i4;
                layoutParams.height = i4;
                if (layoutParams2 != null) {
                    layoutParams2.height = this.f15233l;
                    layoutParams2.width = (int) (i4 * 0.55f);
                }
            }
            if ("down".equalsIgnoreCase(this.f15231j)) {
                b();
            } else if ("up".equalsIgnoreCase(this.f15231j)) {
                a();
            } else if ("left".equalsIgnoreCase(this.f15231j)) {
            } else {
                "right".equalsIgnoreCase(this.f15231j);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.f15226e) {
            return;
        }
        this.f15235n = context;
        this.f15226e = true;
    }

    public void setDetailText(String str) {
        this.f15228g = str;
    }

    public void setDetailsFont(int i4) {
        this.f15230i = i4;
    }

    public void setHandWidth(int i4) {
        this.f15232k = i4;
    }

    public void setScrollDirection(String str) {
        this.f15231j = str;
    }

    public void setScrollbarHeight(int i4) {
        this.f15233l = i4;
    }

    public void setTitleFont(int i4) {
        this.f15229h = i4;
    }

    public void setTitleText(String str) {
        this.f15227f = str;
    }

    public void startAnim() {
        StringBuilder sb = new StringBuilder();
        sb.append("startAnim animator != null ? ");
        sb.append(this.f15234m != null);
        af.b("ScrollClickUtil", sb.toString());
        try {
            ValueAnimator valueAnimator = this.f15234m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void stopAnim() {
        try {
            ValueAnimator valueAnimator = this.f15234m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f15234m.cancel();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void b() {
        try {
            this.f15222a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.f15236o != null && ScrollClickView.this.f15237p != null) {
                            if (ScrollClickView.this.f15222a.getLayoutParams() == null) {
                                return;
                            }
                            final int i4 = ScrollClickView.this.f15222a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.f15234m = ValueAnimator.ofInt(i4, scrollClickView.f15233l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f15223b.getLayoutParams();
                            af.b("ScrollClickUtil", "handHeight = " + i4);
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.f15233l;
                            }
                            ScrollClickView.this.f15234m.setDuration(1000L);
                            ScrollClickView.this.f15234m.setRepeatCount(-1);
                            ScrollClickView.this.f15234m.setRepeatMode(1);
                            ScrollClickView.this.f15234m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.2.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f15236o.getLayoutParams();
                                        if (layoutParams2 != null) {
                                            layoutParams2.height = intValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.f15237p.getLayoutParams();
                                        if (layoutParams3 != null) {
                                            layoutParams3.height = intValue - (i4 / 3);
                                        }
                                        ScrollClickView.this.f15236o.requestLayout();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        af.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a() {
        try {
            this.f15222a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.f15236o != null && ScrollClickView.this.f15237p != null) {
                            if (ScrollClickView.this.f15222a.getLayoutParams() == null) {
                                return;
                            }
                            final int i4 = ScrollClickView.this.f15222a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.f15234m = ValueAnimator.ofInt(i4, scrollClickView.f15233l);
                            af.b("ScrollClickUtil", "handHeight = " + i4 + ",scrollbarHeight = " + ScrollClickView.this.f15233l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f15223b.getLayoutParams();
                            StringBuilder sb = new StringBuilder();
                            sb.append("handHeight = ");
                            sb.append(i4);
                            af.b("ScrollClickUtil", sb.toString());
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.f15233l;
                            }
                            ScrollClickView.this.f15234m.setDuration(1000L);
                            ScrollClickView.this.f15234m.setRepeatCount(-1);
                            ScrollClickView.this.f15234m.setRepeatMode(1);
                            ScrollClickView.this.f15234m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.1.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f15222a.getLayoutParams();
                                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                            ((FrameLayout.LayoutParams) layoutParams2).topMargin = ScrollClickView.this.f15233l - intValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.f15237p.getLayoutParams();
                                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                                            layoutParams3.height = intValue - (i4 / 3);
                                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                                            layoutParams4.topMargin = ScrollClickView.this.f15233l - layoutParams4.height;
                                        }
                                        ScrollClickView.this.f15236o.requestLayout();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        af.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public ScrollClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15226e = false;
        this.f15231j = "up";
        this.f15232k = 45;
        this.f15233l = 180;
        this.f15238q = null;
        init(context);
    }

    public ScrollClickView(Context context) {
        super(context);
        this.f15226e = false;
        this.f15231j = "up";
        this.f15232k = 45;
        this.f15233l = 180;
        this.f15238q = null;
        init(context);
    }
}
