package com.qq.e.comm.plugin.gdtnativead.p.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.gdtnativead.p.b.h;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends RelativeLayout implements f {

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f43979c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f43980d;

    /* renamed from: e  reason: collision with root package name */
    private View f43981e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f43982f;

    /* renamed from: g  reason: collision with root package name */
    private int f43983g;

    /* renamed from: h  reason: collision with root package name */
    private View f43984h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f43985i;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayout f43986a;

        a(LinearLayout linearLayout) {
            this.f43986a = linearLayout;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            if (i.this.getHeight() < i.this.f43983g) {
                if (i.this.f43985i) {
                    return;
                }
                i.this.f43985i = true;
                this.f43986a.removeAllViews();
                this.f43986a.addView(i.this.f43984h);
            } else if (i.this.f43985i) {
                i.this.f43985i = false;
                this.f43986a.addView(i.this.f43980d);
                this.f43986a.addView(i.this.f43982f);
                this.f43986a.addView(i.this.f43981e);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h.a f43988c;

        b(h.a aVar) {
            this.f43988c = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f43988c != null) {
                i iVar = i.this;
                this.f43988c.a(iVar, com.qq.e.comm.plugin.e.a.a().a(iVar));
            }
        }
    }

    public i(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        super(context);
        if (eVar == null) {
            return;
        }
        this.f43979c = eVar;
        dismiss();
        a(context);
        LinearLayout c4 = c(context);
        addView(c4);
        c4.measure(0, 0);
        this.f43983g = c4.getMeasuredHeight();
        addOnLayoutChangeListener(new a(c4));
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public View a() {
        return this;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void destroy() {
        removeAllViews();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void dismiss() {
        setVisibility(4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this);
        if (d4 != null) {
            d4.a(motionEvent, false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void loadUrl(String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.qq.e.comm.plugin.e.a.a().a(this, this.f43979c);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.qq.e.comm.plugin.e.a.a().b(this);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public boolean show() {
        setVisibility(0);
        return true;
    }

    private View b(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2);
        String B = this.f43979c.B();
        if (TextUtils.isEmpty(B)) {
            B = this.f43979c.X0() ? "\u4e0b\u8f7d\u5e94\u7528" : "\u4e86\u89e3\u8be6\u60c5";
        }
        textView.setText(B);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f1.a(context, 120), f1.a(context, 36));
        layoutParams.topMargin = f1.a(context, 8);
        textView.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#3185FC"));
        gradientDrawable.setCornerRadius(f1.a(context, 25));
        textView.setBackgroundDrawable(gradientDrawable);
        return textView;
    }

    private LinearLayout c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(5);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        ImageView d4 = d(context);
        this.f43984h = d4;
        linearLayout.addView(d4);
        TextView e4 = e(context);
        this.f43980d = e4;
        linearLayout.addView(e4);
        this.f43982f = a(context, linearLayout);
        if (this.f43979c.X0()) {
            linearLayout.addView(this.f43982f);
        }
        View b4 = b(context);
        this.f43981e = b4;
        linearLayout.addView(b4);
        return linearLayout;
    }

    private ImageView d(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(4);
        int a4 = f1.a(context, 50);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a4, a4));
        com.qq.e.comm.plugin.b0.b.a().a(this.f43979c.Y(), imageView);
        return imageView;
    }

    private TextView e(Context context) {
        String J0;
        com.qq.e.comm.plugin.g0.b q3;
        TextView textView = new TextView(context);
        textView.setId(1);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = f1.a(context, 8);
        textView.setLayoutParams(layoutParams);
        if (this.f43979c.X0() && (q3 = this.f43979c.q()) != null) {
            J0 = q3.a();
        } else {
            J0 = this.f43979c.J0();
        }
        textView.setText(J0);
        return textView;
    }

    private ImageView a(Context context, LinearLayout linearLayout) {
        ImageView imageView = new ImageView(context);
        imageView.setId(3);
        imageView.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAAU8AAAAwCAYAAACRzvhSAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAABT6ADAAQAAAABAAAAMAAAAACWUydLAAAHxklEQVR4Ae2dy48VRRTGTw0PGR9jEBOjyEMMCowKJsYQY2LiKxEEF8Q/gCAxLgTRha58bjQaTVwZNb7i0pj43rDSvcIAo4kODBFdGEUBdZgZofyqhzvTc2/f7/a90923+/J10unq+rqr+/zq5KSqu7raTIsIiIAIiEB5CPhDtjCs5bmjct2J+PD6EB/x4QS4WoT/9PFb6Ez1w3alTdphrCP+gF3RWSm9e5b48LoVH/HhBLhalP/kEjxt3F4xb0uxXm1n7GVu6nmoig+vdPERH06AqwX5j+N30b6K5vJym7ARnDn/3NmT1mer3Ho71n5pvXeG+PA6FR/x4QS4WqT/ZN/ynLTdMK8WOIOlC7DuCgktICA+3A3ER3w4Aa4W6D+Ztjz9jzZgf9vPsG6gzsIT1m/L3Bo7VZd/Xu2KD69u8REfToCrRftPti3Pf2wnzKsPnMHiS23MdnDTzwNVfHgli4/4cAJcLdh/Mgue3qOr7kn33NluHDOPW9+7qvjwuhUf8eEEuNoN/8kseNqQPQjzljc10dtK22/bmuq9LogPr2HxER9OgKtd8J/sgudZe5xbF6lPpDimNw8RH16v4iM+nABXu+A/mQRPP2R3wLJbuHVQvd3q99ntLY/rsQPEh1eo+IgPJ8DVbvlPJsHTzlo7Lcp2juXUqqKKD68p8REfToCrXfKfOQ9VQkvyOlj2A1qV6cpyCLUL7Ho3aD9xIr2hig+vR/ERH06Aq930nyxanntSB87AweN7ownbw5H0lCo+vDrFR3w4Aa52zX/StRbP3Xw0CHXMViAAroxWi7aPQO7n9jWo/6Kd+gZyR7GdWvvtqFttJxuOrFCG+PDKEh/x4QS4Wjb/mRU8/Ug0mH0lOtZTwdEjUIYAWVu9LebmzVF1dhwlHMU6Gq0hsIb0POT126i71k5gv2uL+HD04iM+nABXq+Y/UfD039mzaAE+hNbkUm5el1UXTS7ylttgzxd5J+LDaYuP+HACXK2q/zj/vS2x0/Y7N6906mJ3s/1VxF2JD6csPuLDCXC1yv7T59baH2h1vstNLJX6dlGBM1gtPrzuxUd8OAGuVtl/pt62r7eHEUDf42aWQHX2jm2w8IKq2EV8OG/xER9OgKsV9Z8oeDpnk3iOuB0BtNBniZxonersGdzjDtzrf3VK7rviwxGLj/hwAlytqv9EL4zipmHQ6Xa8OHoTefEJjeOHFJ0OM9HvxEz07xd94aTriU8SlZk88ZlhkZQSnyQqM3lV4tMQPIMZMOBebD5CEL1kxqyupE5imNI2d5Pt7crVm1xUfJqAOZctPuLDCXC1Kv6TGDyDaf6grccvI75E8ipuak6qs18QODe5GzHZXQkX8eGVIj7iwwlwtQr+M/XCKMEOdwNm35xvG/Ec9GCCnG+WswO47sayBs5gvPhwFxAf8eEEuFoF/2na8qyZFo36P2Ufowt/Zy0v5+1euxhd9Yp8qik+3BvER3w4Aa6W2X+atjxrJkWfRC6w+9AS/LCWl+P2AwxF2lSVwBk4iA/3BvERH06Aq2X2n5Ytz7hpfr+9hu/eH4vnZZZ29iqGIlV6rk/x4d4gPuLDCXC1bP7TsuVZZ85o3X6Wu3mWneV9srLytCHPsplNWWp52pBn2VkyYGXlaUOeZTObstTytKHtstsLnmejIUxZwoiXdU98p5Jp8eHVJj7iwwlwtWT+k7rb7g/ZQgxdOo4XRxdxCztUnZ3C4Kgl4WuDDkvo6mniw/GLj/hwAlwto/+kb3lO2G25Bc7ALQzIH8LQqKou4sNrTnzEhxPgagn9J33wtFy77FPgfAHX4FU0FzV8lZXvIj6cr/iIDyfA1Tb9p53gWcQzyfwDEMc3F1V8OD3xER9OgKul859UzzyjCUvH7Td0rdsJthxFkhr+rNlnl+Nb9j+T5LLmiQ+vGfERH06Aq2X1n3TBcNzu7iBwjgFJWNMvITh7uyv9CSU5Unx4RYiP+HACXC2p/6QLnmbtNpk/sQtsLULhIL5M+oyTaVCr2HUXn4ZqnJUhPrNwNOyITwOSWRml5JN2zs60AW3E5tmj6HZ/FTN9K37wtBlB9HW0KlfF8pOTvu1AnVxOsbniw3mLj/hwAlxtx392If6E2eBqS27xp2XL0w/ZGgS9ZbU7abIdQ3B8GhN6DNYFzuhw/HPoC/zUeBAt0fCXztNNypjKxj/h/bCtpseUSBQfXhniIz6cAFc78J944IwKzyv+tAyeeIXTqsn8Ke5wHb5LfwETeow3Q+GusdOYDf45BM91WD9vdlyUP9nymvT0QkXx4bjFR3w4Aa6W2H9aB89m4zudHYbV9yOqP4B1lBOYURFAjyDQbkErdCuC6JEZJZbK9zOs2IUySSZ3KcSnBld8aiSSt+KTzKWWW1o+dKiS95gOeT+GDXl0yGtL6HY7e9EG7CWH1mQtu5OtP2KL8Pf1p1Dek7jGolgZJzE13WX4VPNMLK90SfHhVSI+4sMJcLXs/sOD57CtQEd8dNrE0N12tiu0HqfzMkjgucYqPB4IL5Q2TxfXZ8twnWPT+yVM4Nms+JB6ER8CB5L49DAf/6tdiDfl+/BDpq+jN+bc1jmrmK9vC671DdZvo1bpnEvMtwDx4XzFR3w4Aa7KfzgfqSIgAiIgAiIgAiIgAiIgAiIgAiIgAk0J/A+BPh7ch7TXOwAAAABJRU5ErkJggg=="));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, f1.a(context, 8));
        layoutParams.topMargin = f1.a(context, 4);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private void a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.qq.e.comm.plugin.b0.b.a().a(this.f43979c.X(), imageView);
        addView(imageView);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#C0000000"));
        addView(view);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void a(h.a aVar) {
        b bVar = new b(aVar);
        this.f43981e.setOnClickListener(bVar);
        setOnClickListener(bVar);
    }
}
