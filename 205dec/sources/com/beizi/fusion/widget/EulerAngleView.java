package com.beizi.fusion.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.g.at;
import com.beizi.fusion.g.i;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class EulerAngleView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15173a;

    /* renamed from: b  reason: collision with root package name */
    private Context f15174b;

    /* renamed from: c  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f15175c;

    /* renamed from: d  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f15176d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f15177e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f15178f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f15179g;

    /* renamed from: h  reason: collision with root package name */
    private ShakeArcView f15180h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f15181i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f15182j;

    /* renamed from: k  reason: collision with root package name */
    private float f15183k;

    /* renamed from: l  reason: collision with root package name */
    private float f15184l;

    /* renamed from: m  reason: collision with root package name */
    private float f15185m;

    /* renamed from: n  reason: collision with root package name */
    private int f15186n;

    /* renamed from: o  reason: collision with root package name */
    private int f15187o;

    /* renamed from: p  reason: collision with root package name */
    private int f15188p;

    /* renamed from: q  reason: collision with root package name */
    private double f15189q;

    /* renamed from: r  reason: collision with root package name */
    private double f15190r;

    /* renamed from: s  reason: collision with root package name */
    private double f15191s;

    /* renamed from: t  reason: collision with root package name */
    private String f15192t;

    /* renamed from: u  reason: collision with root package name */
    private String f15193u;

    /* renamed from: v  reason: collision with root package name */
    private String f15194v;

    /* renamed from: w  reason: collision with root package name */
    private AnimatorSet f15195w;

    /* renamed from: x  reason: collision with root package name */
    private Boolean f15196x;

    public EulerAngleView(Context context) {
        super(context);
        this.f15173a = false;
        this.f15183k = 60.0f;
        this.f15184l = 60.0f;
        this.f15185m = 30.0f;
        this.f15186n = 350;
        this.f15189q = 0.0d;
        this.f15190r = 0.0d;
        this.f15191s = 0.0d;
        init(context);
    }

    public void buildEulerAngleView() {
        String str;
        TextView textView;
        TextView textView2;
        List<String> imgs;
        try {
            if (this.f15175c == null) {
                return;
            }
            RelativeLayout.inflate(getContext(), R.layout.beizi_interaction_euler_angle_view, this);
            this.f15177e = (LinearLayout) findViewById(R.id.bz_eav_container_ll);
            this.f15178f = (RelativeLayout) findViewById(R.id.bz_eav_img_container_rl);
            this.f15179g = (ImageView) findViewById(R.id.bz_eav_img_iv);
            this.f15180h = (ShakeArcView) findViewById(R.id.bz_eav_sav_iv);
            this.f15181i = (TextView) findViewById(R.id.bz_eav_title_tv);
            this.f15182j = (TextView) findViewById(R.id.bz_eav_subtitle_tv);
            RelativeLayout relativeLayout = this.f15178f;
            if (relativeLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.width = this.f15187o;
                layoutParams.height = this.f15188p;
                this.f15178f.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.f15179g;
            if (imageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                double d4 = this.f15187o;
                Double.isNaN(d4);
                layoutParams2.width = (int) (d4 * 0.35d);
                int i4 = this.f15188p;
                double d5 = i4;
                Double.isNaN(d5);
                layoutParams2.height = (int) (d5 * 0.5d);
                double d6 = i4;
                Double.isNaN(d6);
                layoutParams2.setMargins(0, 0, 0, (int) (d6 * 0.2d));
                this.f15179g.setLayoutParams(layoutParams2);
            }
            ShakeArcView shakeArcView = this.f15180h;
            if (shakeArcView != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) shakeArcView.getLayoutParams();
                double min = Math.min(this.f15187o, this.f15188p);
                Double.isNaN(min);
                layoutParams3.width = (int) (min * 0.7d);
                double min2 = Math.min(this.f15187o, this.f15188p);
                Double.isNaN(min2);
                layoutParams3.height = (int) (min2 * 0.7d);
                this.f15180h.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(this.f15192t)) {
                    this.f15180h.setArrowDirection(0);
                } else if (("1".equals(this.f15193u) && "1".equals(this.f15194v)) || ((TextUtils.isEmpty(this.f15193u) && "1".equals(this.f15194v)) || (TextUtils.isEmpty(this.f15194v) && "1".equals(this.f15193u)))) {
                    this.f15180h.setArrowDirection(1);
                } else if (("2".equals(this.f15193u) && "2".equals(this.f15194v)) || ((TextUtils.isEmpty(this.f15193u) && "2".equals(this.f15194v)) || (TextUtils.isEmpty(this.f15194v) && "2".equals(this.f15193u)))) {
                    this.f15180h.setArrowDirection(2);
                }
                try {
                    this.f15180h.setLineWidth(Math.min(this.f15187o, this.f15188p) / 30);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean = this.f15176d;
            String color = eulerAngleRenderBean != null ? eulerAngleRenderBean.getColor() : "#66333333";
            String str2 = null;
            if (!TextUtils.isEmpty(color) && color.startsWith("#")) {
                at.a(this.f15178f, color, 0, null, this.f15187o / 2);
            }
            AdSpacesBean.BuyerBean.EulerAngleStyleBean style = this.f15175c.getStyle();
            String str3 = (style == null || (imgs = style.getImgs()) == null || imgs.size() <= 0) ? null : imgs.get(0);
            if (!TextUtils.isEmpty(str3)) {
                i.a(this.f15174b).b(str3, new i.a() { // from class: com.beizi.fusion.widget.EulerAngleView.1
                    @Override // com.beizi.fusion.g.i.a
                    public void a() {
                    }

                    @Override // com.beizi.fusion.g.i.a
                    public void a(Bitmap bitmap) {
                        try {
                            if (EulerAngleView.this.f15179g == null || bitmap == null) {
                                return;
                            }
                            EulerAngleView.this.f15179g.setImageBitmap(bitmap);
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                });
            }
            ShakeArcView shakeArcView2 = this.f15180h;
            if (shakeArcView2 != null) {
                shakeArcView2.setMaxProgress(100.0d);
            }
            if (style != null) {
                str2 = style.getTitle();
                if (!this.f15196x.booleanValue()) {
                    str = style.getSubTitle();
                } else {
                    str = style.getDownloadSubTitle();
                    if (TextUtils.isEmpty(str)) {
                        str = "\u4e0b\u8f7d\u5e94\u7528";
                    }
                }
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2) && (textView2 = this.f15181i) != null) {
                textView2.setText(str2);
                this.f15181i.setTextColor(Color.parseColor("#FFFFFFFF"));
                this.f15181i.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            if (TextUtils.isEmpty(str) || (textView = this.f15182j) == null) {
                return;
            }
            textView.setText(str);
            this.f15182j.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.f15182j.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.f15173a) {
            return;
        }
        this.f15174b = context;
        this.f15173a = true;
    }

    public void onDestroy() {
        try {
            this.f15174b = null;
            AnimatorSet animatorSet = this.f15195w;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.f15195w = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setAngle(double d4, double d5, double d6) {
        this.f15189q = d4;
        this.f15190r = d5;
        this.f15191s = d6;
    }

    public void setAnimationViewWidthAndHeight(int i4, int i5) {
        this.f15187o = i4;
        this.f15188p = i5;
    }

    public void setCurrentProgress(double d4, double d5, double d6) {
        try {
            if (this.f15180h != null) {
                double d7 = 0.0d;
                double abs = (this.f15189q <= 0.0d || ((!"2".equals(this.f15192t) || d4 <= 0.0d) && ((!"1".equals(this.f15192t) || d4 >= 0.0d) && !"0".equals(this.f15192t)))) ? 0.0d : (Math.abs(d4) * 100.0d) / this.f15189q;
                double abs2 = (this.f15190r <= 0.0d || ((!"2".equals(this.f15193u) || d5 >= 0.0d) && ((!"1".equals(this.f15193u) || d5 <= 0.0d) && !"0".equals(this.f15193u)))) ? 0.0d : (Math.abs(d5) * 100.0d) / this.f15190r;
                if (this.f15191s > 0.0d && (("2".equals(this.f15194v) && d6 > 0.0d) || (("1".equals(this.f15194v) && d6 < 0.0d) || "0".equals(this.f15194v)))) {
                    d7 = (Math.abs(d6) * 100.0d) / this.f15191s;
                }
                this.f15180h.setCurrentProgress(Math.max(Math.max(abs, abs2), d7));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setDownloadApp(Boolean bool) {
        this.f15196x = bool;
    }

    public void setEulerAngleRenderBean(AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean) {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            this.f15176d = eulerAngleRenderBean;
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f15175c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        String direction = eulerAngleRuleBean.getDirection();
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f15192t = direction;
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f15193u = direction;
                        } else if ("z".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f15194v = direction;
                        }
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setEulerAngleViewRuleBean(AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean) {
        this.f15175c = eulerAngleViewRuleBean;
    }

    public void startContinuousRotations() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f15175c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null && eulerAngleRuleBean.getAngle() != 0.0d) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationX", 0.0f, -this.f15183k);
                                a(arrayList, "rotationX", -this.f15183k, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationX", 0.0f, this.f15183k);
                                a(arrayList, "rotationX", this.f15183k, 0.0f);
                            } else {
                                a(arrayList, "rotationX", 0.0f, this.f15183k);
                                a(arrayList, "rotationX", this.f15183k, 0.0f);
                                a(arrayList, "rotationX", 0.0f, -this.f15183k);
                                a(arrayList, "rotationX", -this.f15183k, 0.0f);
                            }
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationY", 0.0f, -this.f15184l);
                                a(arrayList, "rotationY", -this.f15184l, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationY", 0.0f, this.f15184l);
                                a(arrayList, "rotationY", this.f15184l, 0.0f);
                            } else {
                                a(arrayList, "rotationY", 0.0f, this.f15184l);
                                a(arrayList, "rotationY", this.f15184l, 0.0f);
                                a(arrayList, "rotationY", 0.0f, -this.f15184l);
                                a(arrayList, "rotationY", -this.f15184l, 0.0f);
                            }
                        } else if ("z".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotation", 0.0f, -this.f15185m);
                                a(arrayList, "rotation", -this.f15185m, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotation", 0.0f, this.f15185m);
                                a(arrayList, "rotation", this.f15185m, 0.0f);
                            } else {
                                a(arrayList, "rotation", 0.0f, this.f15185m);
                                a(arrayList, "rotation", this.f15185m, 0.0f);
                                a(arrayList, "rotation", 0.0f, -this.f15185m);
                                a(arrayList, "rotation", -this.f15185m, 0.0f);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f15195w = animatorSet;
                    animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.widget.EulerAngleView.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            try {
                                if (EulerAngleView.this.f15195w != null) {
                                    EulerAngleView.this.f15195w.start();
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }
                    });
                    this.f15195w.playSequentially(arrayList);
                    this.f15195w.start();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(List<Animator> list, String str, float f4, float f5) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15179g, str, f4, f5);
            ofFloat.setDuration(this.f15186n);
            list.add(ofFloat);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public EulerAngleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15173a = false;
        this.f15183k = 60.0f;
        this.f15184l = 60.0f;
        this.f15185m = 30.0f;
        this.f15186n = 350;
        this.f15189q = 0.0d;
        this.f15190r = 0.0d;
        this.f15191s = 0.0d;
        init(context);
    }

    public EulerAngleView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15173a = false;
        this.f15183k = 60.0f;
        this.f15184l = 60.0f;
        this.f15185m = 30.0f;
        this.f15186n = 350;
        this.f15189q = 0.0d;
        this.f15190r = 0.0d;
        this.f15191s = 0.0d;
        init(context);
    }
}
