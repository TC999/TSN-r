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
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p072g.BeiZiImageUtils;
import com.beizi.fusion.p072g.ShapeUtil;
import com.beizi.fusion.update.ShakeArcView;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class EulerAngleView extends RelativeLayout {

    /* renamed from: a */
    private boolean f11588a;

    /* renamed from: b */
    private Context f11589b;

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f11590c;

    /* renamed from: d */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f11591d;

    /* renamed from: e */
    private LinearLayout f11592e;

    /* renamed from: f */
    private RelativeLayout f11593f;

    /* renamed from: g */
    private ImageView f11594g;

    /* renamed from: h */
    private ShakeArcView f11595h;

    /* renamed from: i */
    private TextView f11596i;

    /* renamed from: j */
    private TextView f11597j;

    /* renamed from: k */
    private float f11598k;

    /* renamed from: l */
    private float f11599l;

    /* renamed from: m */
    private float f11600m;

    /* renamed from: n */
    private int f11601n;

    /* renamed from: o */
    private int f11602o;

    /* renamed from: p */
    private int f11603p;

    /* renamed from: q */
    private double f11604q;

    /* renamed from: r */
    private double f11605r;

    /* renamed from: s */
    private double f11606s;

    /* renamed from: t */
    private String f11607t;

    /* renamed from: u */
    private String f11608u;

    /* renamed from: v */
    private String f11609v;

    /* renamed from: w */
    private AnimatorSet f11610w;

    public EulerAngleView(Context context) {
        super(context);
        this.f11588a = false;
        this.f11598k = 60.0f;
        this.f11599l = 60.0f;
        this.f11600m = 30.0f;
        this.f11601n = 350;
        this.f11604q = Utils.DOUBLE_EPSILON;
        this.f11605r = Utils.DOUBLE_EPSILON;
        this.f11606s = Utils.DOUBLE_EPSILON;
        init(context);
    }

    public void buildEulerAngleView() {
        String str;
        TextView textView;
        TextView textView2;
        List<String> imgs;
        try {
            if (this.f11590c == null) {
                return;
            }
            RelativeLayout.inflate(getContext(), C3025R.C3029layout.beizi_interaction_euler_angle_view, this);
            this.f11592e = (LinearLayout) findViewById(C3025R.C3028id.bz_eav_container_ll);
            this.f11593f = (RelativeLayout) findViewById(C3025R.C3028id.bz_eav_img_container_rl);
            this.f11594g = (ImageView) findViewById(C3025R.C3028id.bz_eav_img_iv);
            this.f11595h = (ShakeArcView) findViewById(C3025R.C3028id.bz_eav_sav_iv);
            this.f11596i = (TextView) findViewById(C3025R.C3028id.bz_eav_title_tv);
            this.f11597j = (TextView) findViewById(C3025R.C3028id.bz_eav_subtitle_tv);
            RelativeLayout relativeLayout = this.f11593f;
            if (relativeLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.width = this.f11602o;
                layoutParams.height = this.f11603p;
                this.f11593f.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.f11594g;
            if (imageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                double d = this.f11602o;
                Double.isNaN(d);
                layoutParams2.width = (int) (d * 0.35d);
                int i = this.f11603p;
                double d2 = i;
                Double.isNaN(d2);
                layoutParams2.height = (int) (d2 * 0.5d);
                double d3 = i;
                Double.isNaN(d3);
                layoutParams2.setMargins(0, 0, 0, (int) (d3 * 0.2d));
                this.f11594g.setLayoutParams(layoutParams2);
            }
            ShakeArcView shakeArcView = this.f11595h;
            if (shakeArcView != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) shakeArcView.getLayoutParams();
                double min = Math.min(this.f11602o, this.f11603p);
                Double.isNaN(min);
                layoutParams3.width = (int) (min * 0.7d);
                double min2 = Math.min(this.f11602o, this.f11603p);
                Double.isNaN(min2);
                layoutParams3.height = (int) (min2 * 0.7d);
                this.f11595h.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(this.f11607t)) {
                    this.f11595h.setArrowDirection(0);
                } else if (("1".equals(this.f11608u) && "1".equals(this.f11609v)) || ((TextUtils.isEmpty(this.f11608u) && "1".equals(this.f11609v)) || (TextUtils.isEmpty(this.f11609v) && "1".equals(this.f11608u)))) {
                    this.f11595h.setArrowDirection(1);
                } else if (("2".equals(this.f11608u) && "2".equals(this.f11609v)) || ((TextUtils.isEmpty(this.f11608u) && "2".equals(this.f11609v)) || (TextUtils.isEmpty(this.f11609v) && "2".equals(this.f11608u)))) {
                    this.f11595h.setArrowDirection(2);
                }
                try {
                    this.f11595h.setLineWidth(Math.min(this.f11602o, this.f11603p) / 30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean = this.f11591d;
            String color = eulerAngleRenderBean != null ? eulerAngleRenderBean.getColor() : "#66333333";
            String str2 = null;
            if (!TextUtils.isEmpty(color) && color.startsWith("#")) {
                ShapeUtil.m48318a(this.f11593f, color, 0, null, this.f11602o / 2);
            }
            AdSpacesBean.BuyerBean.EulerAngleStyleBean style = this.f11590c.getStyle();
            String str3 = (style == null || (imgs = style.getImgs()) == null || imgs.size() <= 0) ? null : imgs.get(0);
            if (!TextUtils.isEmpty(str3)) {
                BeiZiImageUtils.m48258a(this.f11589b).m48250b(str3, new BeiZiImageUtils.InterfaceC3151a() { // from class: com.beizi.fusion.widget.EulerAngleView.1
                    @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                    /* renamed from: a */
                    public void mo47232a() {
                    }

                    @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                    /* renamed from: a */
                    public void mo47231a(Bitmap bitmap) {
                        try {
                            if (EulerAngleView.this.f11594g == null || bitmap == null) {
                                return;
                            }
                            EulerAngleView.this.f11594g.setImageBitmap(bitmap);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
            ShakeArcView shakeArcView2 = this.f11595h;
            if (shakeArcView2 != null) {
                shakeArcView2.setMaxProgress(100.0d);
            }
            if (style != null) {
                str2 = style.getTitle();
                str = style.getSubTitle();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2) && (textView2 = this.f11596i) != null) {
                textView2.setText(str2);
                this.f11596i.setTextColor(Color.parseColor("#FFFFFFFF"));
                this.f11596i.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            if (TextUtils.isEmpty(str) || (textView = this.f11597j) == null) {
                return;
            }
            textView.setText(str);
            this.f11597j.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.f11597j.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.f11588a) {
            return;
        }
        this.f11589b = context;
        this.f11588a = true;
    }

    public void onDestroy() {
        try {
            this.f11589b = null;
            AnimatorSet animatorSet = this.f11610w;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.f11610w = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAngle(double d, double d2, double d3) {
        this.f11604q = d;
        this.f11605r = d2;
        this.f11606s = d3;
    }

    public void setAnimationViewWidthAndHeight(int i, int i2) {
        this.f11602o = i;
        this.f11603p = i2;
    }

    public void setCurrentProgress(double d, double d2, double d3) {
        try {
            if (this.f11595h != null) {
                double d4 = this.f11604q;
                double d5 = Utils.DOUBLE_EPSILON;
                double abs = (d4 <= Utils.DOUBLE_EPSILON || ((!"2".equals(this.f11607t) || d <= Utils.DOUBLE_EPSILON) && ((!"1".equals(this.f11607t) || d >= Utils.DOUBLE_EPSILON) && !"0".equals(this.f11607t)))) ? 0.0d : (Math.abs(d) * 100.0d) / this.f11604q;
                double abs2 = (this.f11605r <= Utils.DOUBLE_EPSILON || ((!"2".equals(this.f11608u) || d2 >= Utils.DOUBLE_EPSILON) && ((!"1".equals(this.f11608u) || d2 <= Utils.DOUBLE_EPSILON) && !"0".equals(this.f11608u)))) ? 0.0d : (Math.abs(d2) * 100.0d) / this.f11605r;
                if (this.f11606s > Utils.DOUBLE_EPSILON && (("2".equals(this.f11609v) && d3 > Utils.DOUBLE_EPSILON) || (("1".equals(this.f11609v) && d3 < Utils.DOUBLE_EPSILON) || "0".equals(this.f11609v)))) {
                    d5 = (Math.abs(d3) * 100.0d) / this.f11606s;
                }
                this.f11595h.setCurrentProgress(Math.max(Math.max(abs, abs2), d5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEulerAngleRenderBean(AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean) {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            this.f11591d = eulerAngleRenderBean;
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11590c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        String direction = eulerAngleRuleBean.getDirection();
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f11607t = direction;
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f11608u = direction;
                        } else if (UMCommonContent.f37777aG.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f11609v = direction;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEulerAngleViewRuleBean(AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean) {
        this.f11590c = eulerAngleViewRuleBean;
    }

    public void startContinuousRotations() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11590c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null && eulerAngleRuleBean.getAngle() != Utils.DOUBLE_EPSILON) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                m48078a(arrayList, "rotationX", 0.0f, -this.f11598k);
                                m48078a(arrayList, "rotationX", -this.f11598k, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                m48078a(arrayList, "rotationX", 0.0f, this.f11598k);
                                m48078a(arrayList, "rotationX", this.f11598k, 0.0f);
                            } else {
                                m48078a(arrayList, "rotationX", 0.0f, this.f11598k);
                                m48078a(arrayList, "rotationX", this.f11598k, 0.0f);
                                m48078a(arrayList, "rotationX", 0.0f, -this.f11598k);
                                m48078a(arrayList, "rotationX", -this.f11598k, 0.0f);
                            }
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                m48078a(arrayList, "rotationY", 0.0f, -this.f11599l);
                                m48078a(arrayList, "rotationY", -this.f11599l, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                m48078a(arrayList, "rotationY", 0.0f, this.f11599l);
                                m48078a(arrayList, "rotationY", this.f11599l, 0.0f);
                            } else {
                                m48078a(arrayList, "rotationY", 0.0f, this.f11599l);
                                m48078a(arrayList, "rotationY", this.f11599l, 0.0f);
                                m48078a(arrayList, "rotationY", 0.0f, -this.f11599l);
                                m48078a(arrayList, "rotationY", -this.f11599l, 0.0f);
                            }
                        } else if (UMCommonContent.f37777aG.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                m48078a(arrayList, "rotation", 0.0f, -this.f11600m);
                                m48078a(arrayList, "rotation", -this.f11600m, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                m48078a(arrayList, "rotation", 0.0f, this.f11600m);
                                m48078a(arrayList, "rotation", this.f11600m, 0.0f);
                            } else {
                                m48078a(arrayList, "rotation", 0.0f, this.f11600m);
                                m48078a(arrayList, "rotation", this.f11600m, 0.0f);
                                m48078a(arrayList, "rotation", 0.0f, -this.f11600m);
                                m48078a(arrayList, "rotation", -this.f11600m, 0.0f);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f11610w = animatorSet;
                    animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.widget.EulerAngleView.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            try {
                                if (EulerAngleView.this.f11610w != null) {
                                    EulerAngleView.this.f11610w.start();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }
                    });
                    this.f11610w.playSequentially(arrayList);
                    this.f11610w.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m48078a(List<Animator> list, String str, float f, float f2) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11594g, str, f, f2);
            ofFloat.setDuration(this.f11601n);
            list.add(ofFloat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EulerAngleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11588a = false;
        this.f11598k = 60.0f;
        this.f11599l = 60.0f;
        this.f11600m = 30.0f;
        this.f11601n = 350;
        this.f11604q = Utils.DOUBLE_EPSILON;
        this.f11605r = Utils.DOUBLE_EPSILON;
        this.f11606s = Utils.DOUBLE_EPSILON;
        init(context);
    }

    public EulerAngleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11588a = false;
        this.f11598k = 60.0f;
        this.f11599l = 60.0f;
        this.f11600m = 30.0f;
        this.f11601n = 350;
        this.f11604q = Utils.DOUBLE_EPSILON;
        this.f11605r = Utils.DOUBLE_EPSILON;
        this.f11606s = Utils.DOUBLE_EPSILON;
        init(context);
    }
}
