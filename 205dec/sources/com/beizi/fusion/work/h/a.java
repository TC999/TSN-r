package com.beizi.fusion.work.h;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.d.h;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aq;
import com.beizi.fusion.g.as;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.i;
import com.beizi.fusion.g.s;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.CoordinateBean;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseUnifiedCustomWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {
    protected ImageView A;
    protected ImageView B;
    protected TextView C;
    protected TextView D;
    protected TextView E;
    protected TextView F;
    protected TextView G;
    protected long H;
    protected float I;
    protected float J;
    protected boolean K = false;

    /* renamed from: L  reason: collision with root package name */
    protected boolean f15629L = false;
    protected boolean M = false;
    protected Context N;
    protected Activity O;
    protected as P;
    protected aq Q;
    protected CountDownTimer R;
    protected AdSpacesBean.RenderViewBean S;
    protected AdSpacesBean.BuyerBean.RenderAds T;
    protected List<AdSpacesBean.RenderViewBean> U;
    protected List<Pair<String, Integer>> V;

    /* renamed from: n  reason: collision with root package name */
    protected View f15630n;

    /* renamed from: o  reason: collision with root package name */
    protected View f15631o;

    /* renamed from: p  reason: collision with root package name */
    protected View f15632p;

    /* renamed from: q  reason: collision with root package name */
    protected ViewGroup f15633q;

    /* renamed from: r  reason: collision with root package name */
    protected ViewGroup f15634r;

    /* renamed from: s  reason: collision with root package name */
    protected ViewGroup f15635s;

    /* renamed from: t  reason: collision with root package name */
    protected ViewGroup f15636t;

    /* renamed from: u  reason: collision with root package name */
    protected ViewGroup f15637u;

    /* renamed from: v  reason: collision with root package name */
    protected ViewGroup f15638v;

    /* renamed from: w  reason: collision with root package name */
    protected ViewGroup f15639w;

    /* renamed from: x  reason: collision with root package name */
    protected ViewGroup f15640x;

    /* renamed from: y  reason: collision with root package name */
    protected ImageView f15641y;

    /* renamed from: z  reason: collision with root package name */
    protected ImageView f15642z;

    public a(Context context, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, int i4) {
        this.N = context;
        this.H = j4;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15374k = i4;
        this.f15369f = forwardBean;
        this.I = aw.l(context);
        this.J = aw.m(context);
        aH();
        r();
    }

    private void aZ() {
        List<String> clickView = this.T.getClickView();
        ArrayList arrayList = new ArrayList();
        if (clickView != null && clickView.size() > 0) {
            if (clickView.contains("bg")) {
                arrayList.add(this.f15633q);
                arrayList.add(this.f15635s);
                arrayList.add(this.f15639w);
            } else if (clickView.contains("ad")) {
                arrayList.add(this.f15635s);
            } else {
                if (clickView.contains("image")) {
                    arrayList.add(this.f15636t);
                }
                if (clickView.contains("title")) {
                    arrayList.add(this.D);
                }
                if (clickView.contains("desc")) {
                    arrayList.add(this.E);
                }
                if (clickView.contains(RewardPlus.ICON)) {
                    arrayList.add(this.A);
                }
                if (clickView.contains("target")) {
                    arrayList.add(this.f15638v);
                }
            }
        }
        a(arrayList);
    }

    private void b(Activity activity) {
        if (activity == null || this.f15632p == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        this.f15630n = decorView;
        if (decorView instanceof FrameLayout) {
            aw.a(this.f15632p);
            ((FrameLayout) this.f15630n).addView(this.f15632p);
            b(this.f15634r);
        }
    }

    private void ba() {
        ((FrameLayout) this.f15630n).removeView(this.f15632p);
    }

    private void c(int i4, int i5) {
        a(this.f15636t, this.T.getImageCoordinate(), i4, i5);
        aR();
    }

    private void e(int i4, int i5) {
        a(this.E, this.T.getDescCoordinate(), i4, i5);
        if (TextUtils.isEmpty(aT())) {
            return;
        }
        this.E.setText(aT());
    }

    private void f(int i4, int i5) {
        a(this.A, this.T.getIconCoordinate(), i4, i5);
        if (this.A.getVisibility() != 0 || TextUtils.isEmpty(aU())) {
            return;
        }
        i.a(this.N).a(aU(), new i.a() { // from class: com.beizi.fusion.work.h.a.2
            @Override // com.beizi.fusion.g.i.a
            public void a() {
            }

            @Override // com.beizi.fusion.g.i.a
            public void a(Bitmap bitmap) {
                a.this.A.setImageBitmap(bitmap);
            }
        });
    }

    private void g(int i4, int i5) {
        a(this.f15638v, this.T.getActionCoordinate(), i4, i5);
        if (TextUtils.isEmpty(aV())) {
            return;
        }
        this.F.setText(aV());
    }

    private void h(int i4, int i5) {
        a(this.f15637u, this.T.getCloseCoordinate(), i4, i5);
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        try {
            if (this.M) {
                return;
            }
            this.M = true;
            this.O = activity;
            b(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(List<View> list) {
    }

    public int aG() {
        return -1;
    }

    public void aH() {
        if (aG() == -1) {
            return;
        }
        View inflate = LayoutInflater.from(this.N).inflate(aG(), (ViewGroup) null);
        this.f15631o = inflate;
        this.f15633q = (ViewGroup) inflate.findViewById(R.id.rl_bg_container);
        this.f15634r = (ViewGroup) this.f15631o.findViewById(R.id.rl_anim_container);
        this.f15635s = (ViewGroup) this.f15631o.findViewById(R.id.rl_container);
        this.f15636t = (ViewGroup) this.f15631o.findViewById(R.id.fl_img_container);
        this.f15641y = (ImageView) this.f15631o.findViewById(R.id.iv_imageview);
        this.f15637u = (ViewGroup) this.f15631o.findViewById(R.id.rl_close);
        this.C = (TextView) this.f15631o.findViewById(R.id.tv_close);
        this.f15642z = (ImageView) this.f15631o.findViewById(R.id.iv_close);
        this.D = (TextView) this.f15631o.findViewById(R.id.tv_title);
        this.E = (TextView) this.f15631o.findViewById(R.id.tv_desc);
        this.A = (ImageView) this.f15631o.findViewById(R.id.iv_icon);
        this.f15638v = (ViewGroup) this.f15631o.findViewById(R.id.rl_action);
        this.F = (TextView) this.f15631o.findViewById(R.id.tv_action);
        this.f15639w = (ViewGroup) this.f15631o.findViewById(R.id.rl_slide_down_container);
        this.G = (TextView) this.f15631o.findViewById(R.id.tv_slide_down_title);
        this.B = (ImageView) this.f15631o.findViewById(R.id.iv_slide_down_arrow);
        this.f15640x = (ViewGroup) this.f15631o.findViewById(R.id.fl_event_container);
    }

    public void aI() {
    }

    public void aJ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aK() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onADClicked()");
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null && eVar.s() != 2) {
            this.f15367d.d(g());
        }
        if (this.f15629L) {
            return;
        }
        this.f15629L = true;
        E();
        ai();
        if (this.f15374k != 2) {
            aY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aL() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onAdShow()");
        this.f15373j = com.beizi.fusion.f.a.ADSHOW;
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null && eVar.s() != 2) {
            this.f15367d.b(g());
        }
        if (this.K) {
            return;
        }
        this.K = true;
        az();
        aW();
        C();
        D();
        ah();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aM() {
        try {
            if (Y()) {
                b();
            } else {
                O();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aN() {
        if (this.T != null) {
            a((int) this.I, (int) this.J);
            this.f15642z.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aO();
                }
            });
        }
        this.f15632p = this.f15631o;
        aP();
    }

    public void aO() {
    }

    public void aP() {
    }

    public void aQ() {
    }

    public void aR() {
    }

    public String aS() {
        return "";
    }

    public String aT() {
        return "";
    }

    public String aU() {
        return "";
    }

    public String aV() {
        return "";
    }

    protected void aW() {
        AdSpacesBean.BuyerBean.RenderAds renderAds;
        if (this.C == null || this.f15642z == null || (renderAds = this.T) == null) {
            return;
        }
        if (renderAds.getAutoClose() == 0 && this.T.getMinTime() == 0) {
            this.C.setVisibility(8);
            this.f15642z.setVisibility(0);
        } else {
            this.f15642z.setVisibility(8);
            this.C.setVisibility(0);
            a(this.T.getAutoClose(), this.T.getMinTime(), this.T.getMaxTime());
        }
        this.f15637u.setVisibility(0);
    }

    public void aX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aY() {
        Log.d("BeiZis", "UnifiedCustomAd onADClosed()");
        as asVar = this.P;
        if (asVar != null) {
            asVar.c();
        }
        aq aqVar = this.Q;
        if (aqVar != null) {
            aqVar.b();
        }
        ac();
        G();
        c(this.O);
    }

    public void b(boolean z3) {
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null || aG() == -1) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        List<AdSpacesBean.RenderViewBean> renderView = this.f15368e.getRenderView();
        this.U = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.U.get(0);
            this.S = renderViewBean;
            this.V = s.a(renderViewBean.getDpLinkUrlList());
        }
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                aI();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "";
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.a
    public void l() {
        w();
        ag();
        this.T = this.f15368e.getRenderAds();
        aJ();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15632p;
    }

    private void i(int i4, int i5) {
        b(this.f15639w, this.T.getScrollCoordinate(), i4, i5);
    }

    private void c(Activity activity) {
        if (activity != null) {
            if (this.f15630n == null) {
                this.f15630n = activity.getWindow().getDecorView();
            }
            if (this.f15630n instanceof FrameLayout) {
                ba();
            }
        }
        m();
    }

    private void a(int i4, int i5) {
        a(this.f15633q, this.T.getBgCoordinate(), i4, i5);
        int i6 = this.f15633q.getLayoutParams().width;
        int i7 = this.f15633q.getLayoutParams().height;
        b(i6, i7);
        i(i6, i7);
    }

    private void b(View view) {
        if (view != null) {
            view.setVisibility(8);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(500L);
            view.setVisibility(0);
            view.startAnimation(translateAnimation);
        }
    }

    private void a(final int i4, final int i5, final int i6) {
        CountDownTimer countDownTimer = this.R;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(600 + (i6 * 1000), 1000L) { // from class: com.beizi.fusion.work.h.a.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (i4 == 1) {
                    a.this.aY();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                a aVar = a.this;
                TextView textView = aVar.C;
                if (textView == null || aVar.f15642z == null) {
                    return;
                }
                int i7 = (int) (((float) j4) / 1000.0f);
                if (i6 - i7 >= i5) {
                    textView.setVisibility(8);
                    a.this.f15642z.setVisibility(0);
                    return;
                }
                textView.setText(String.valueOf(i7));
            }
        };
        this.R = countDownTimer2;
        countDownTimer2.start();
    }

    private void b() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeAdWorker:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            aX();
            if (this.f15632p != null) {
                this.f15367d.a(g(), this.f15632p);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private void d(int i4, int i5) {
        a(this.D, this.T.getTitleCoordinate(), i4, i5);
        if (TextUtils.isEmpty(aS())) {
            return;
        }
        this.D.setText(aS());
    }

    private void a(View view, String str, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams;
        boolean z3;
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
        } else if (str.equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            view.setVisibility(8);
        } else {
            CoordinateBean coordinate = CoordinateBean.getCoordinate(str);
            if (coordinate == null) {
                view.setVisibility(8);
                return;
            }
            int[] a4 = a(coordinate, i4, i5);
            int[] a5 = a(coordinate, i4, i5, a4);
            boolean z4 = view instanceof TextView;
            if (z4) {
                layoutParams = new RelativeLayout.LayoutParams(a5[0], -2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(a5[0], a5[1]);
            }
            layoutParams.setMargins(a4[0], a4[1], a4[2], a4[3]);
            if (!coordinate.getTop().equals("-1") || coordinate.getBottom().equals("-1")) {
                z3 = false;
            } else {
                layoutParams.addRule(12, -1);
                z3 = true;
            }
            if (coordinate.getLeft().equals("-1") && !coordinate.getRight().equals("-1")) {
                layoutParams.addRule(11, -1);
            }
            view.setLayoutParams(layoutParams);
            if (!coordinate.getFontOrCorner().equals("-1")) {
                if (z4) {
                    ((TextView) view).setTextSize(Float.parseFloat(coordinate.getFontOrCorner()));
                } else if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    if (view != this.f15637u && view != this.f15638v) {
                        int a6 = aw.a(this.N, Float.parseFloat(coordinate.getFontOrCorner()));
                        if (z3) {
                            float f4 = a6;
                            gradientDrawable.setCornerRadii(new float[]{f4, f4, f4, f4, 0.0f, 0.0f, 0.0f, 0.0f});
                        } else {
                            gradientDrawable.setCornerRadius(a6);
                        }
                    } else {
                        gradientDrawable.setCornerRadius(a5[1]);
                    }
                }
            }
            if (coordinate.getColor().equals("-1")) {
                return;
            }
            if (z4) {
                ((TextView) view).setTextColor(Color.parseColor(coordinate.getColor()));
            } else if (view != this.f15640x) {
                if (view.getBackground() instanceof GradientDrawable) {
                    ((GradientDrawable) view.getBackground()).setColor(Color.parseColor(coordinate.getColor()));
                } else {
                    view.setBackgroundColor(Color.parseColor(coordinate.getColor()));
                }
            }
        }
    }

    private void b(int i4, int i5) {
        String adCoordinate = this.T.getAdCoordinate();
        a(this.f15635s, adCoordinate, i4, i5);
        a(this.f15640x, adCoordinate, i4, i5);
        int i6 = this.f15635s.getLayoutParams().width;
        int i7 = this.f15635s.getLayoutParams().height;
        c(i6, i7);
        d(i6, i7);
        e(i6, i7);
        f(i6, i7);
        g(i6, i7);
        h(i6, i7);
        aQ();
        aZ();
    }

    private int b(String str, int i4) {
        if (str.contains("%")) {
            return (i4 * ((int) Float.parseFloat(str.substring(0, str.indexOf("%"))))) / 100;
        }
        return aw.a(this.N, Float.parseFloat(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0145, code lost:
        if (r2 <= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0170, code lost:
        if (r3 <= 0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.view.View r18, java.lang.String r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.h.a.b(android.view.View, java.lang.String, int, int):void");
    }

    private int[] a(CoordinateBean coordinateBean, int i4, int i5, int[] iArr) {
        int b4;
        int b5;
        int[] iArr2 = new int[2];
        if (coordinateBean.getWidth().equals("-1")) {
            b4 = (i4 - iArr[0]) - iArr[2];
        } else {
            b4 = b(coordinateBean.getWidth(), i4);
        }
        if (!coordinateBean.getScale().equals("-1") && !coordinateBean.getScale().equals("0")) {
            b5 = (int) (b4 / Float.parseFloat(coordinateBean.getScale()));
        } else if (coordinateBean.getHeight().equals("-1")) {
            b5 = (i5 - iArr[1]) - iArr[3];
        } else {
            b5 = b(coordinateBean.getHeight(), i5);
        }
        iArr2[0] = b4;
        iArr2[1] = b5;
        return iArr2;
    }

    private int[] a(CoordinateBean coordinateBean, int i4, int i5) {
        int[] iArr = new int[4];
        String left = coordinateBean.getLeft();
        int b4 = (left.equals("0%") || left.equals("0") || left.equals("-1")) ? 0 : b(left, i4);
        String top2 = coordinateBean.getTop();
        int b5 = (top2.equals("0%") || top2.equals("0") || top2.equals("-1")) ? 0 : b(top2, i5);
        String right = coordinateBean.getRight();
        int b6 = (right.equals("0%") || right.equals("0") || right.equals("-1")) ? 0 : b(right, i4);
        String bottom = coordinateBean.getBottom();
        int b7 = (bottom.equals("0%") || bottom.equals("0") || bottom.equals("-1")) ? 0 : b(bottom, i5);
        iArr[0] = b4;
        iArr[1] = b5;
        iArr[2] = b6;
        iArr[3] = b7;
        return iArr;
    }

    protected void a(View view) {
        a(view, "", 30, (aq.a) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(View view, final String str, int i4, final aq.a aVar) {
        final int a4 = aw.a(this.N, i4);
        final boolean z3 = view == this.f15633q;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.h.a.4

            /* renamed from: a  reason: collision with root package name */
            float f15649a;

            /* renamed from: b  reason: collision with root package name */
            float f15650b;

            /* renamed from: c  reason: collision with root package name */
            float f15651c;

            /* renamed from: d  reason: collision with root package name */
            float f15652d;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                aq.a aVar2;
                aq.a aVar3;
                aq.a aVar4;
                aq.a aVar5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f15649a = motionEvent.getX();
                    this.f15650b = motionEvent.getY();
                    this.f15651c = motionEvent.getX();
                    this.f15652d = motionEvent.getY();
                    if (z3) {
                        a.this.f15633q.onTouchEvent(motionEvent);
                    } else {
                        a.this.f15635s.dispatchTouchEvent(motionEvent);
                    }
                } else if (action == 1) {
                    af.b("SlideClickUtil", "mCurPosX = " + this.f15651c + ",mCurPosY = " + this.f15652d + ",mPosX = " + this.f15649a + ",mPosY = " + this.f15650b);
                    float f4 = this.f15652d;
                    float f5 = this.f15650b;
                    int i5 = a4;
                    if (f4 - f5 > i5) {
                        if (!TextUtils.isEmpty(a.this.T.getScrollCoordinate()) && !a.this.T.getScrollCoordinate().equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
                            a.this.b(z3);
                        } else if ("down".equalsIgnoreCase(str) && (aVar5 = aVar) != null) {
                            aVar5.c_();
                        }
                    } else if (f5 - f4 > i5) {
                        if ("up".equalsIgnoreCase(str) && (aVar4 = aVar) != null) {
                            aVar4.c_();
                        }
                    } else {
                        float f6 = this.f15649a;
                        float f7 = this.f15651c;
                        if (f6 - f7 > i5) {
                            if ("left".equalsIgnoreCase(str) && (aVar3 = aVar) != null) {
                                aVar3.c_();
                            }
                        } else if (f7 - f6 > i5) {
                            if ("right".equalsIgnoreCase(str) && (aVar2 = aVar) != null) {
                                aVar2.c_();
                            }
                        } else if (z3) {
                            a.this.f15633q.onTouchEvent(motionEvent);
                        } else {
                            a.this.f15635s.dispatchTouchEvent(motionEvent);
                        }
                    }
                } else if (action == 2) {
                    this.f15651c = motionEvent.getX();
                    this.f15652d = motionEvent.getY();
                }
                return true;
            }
        });
    }
}
