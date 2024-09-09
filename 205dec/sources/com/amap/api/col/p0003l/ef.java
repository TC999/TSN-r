package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: IndoorFloorSwitchView.java */
/* renamed from: com.amap.api.col.3l.ef  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ef extends ScrollView {

    /* renamed from: r  reason: collision with root package name */
    public static final String f7534r = ef.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private Context f7535a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f7536b;

    /* renamed from: c  reason: collision with root package name */
    private int f7537c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f7538d;

    /* renamed from: e  reason: collision with root package name */
    private int f7539e;

    /* renamed from: f  reason: collision with root package name */
    private int f7540f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f7541g;

    /* renamed from: h  reason: collision with root package name */
    private int f7542h;

    /* renamed from: i  reason: collision with root package name */
    private int f7543i;

    /* renamed from: j  reason: collision with root package name */
    private int f7544j;

    /* renamed from: k  reason: collision with root package name */
    private int f7545k;

    /* renamed from: l  reason: collision with root package name */
    private int f7546l;

    /* renamed from: m  reason: collision with root package name */
    int f7547m;

    /* renamed from: n  reason: collision with root package name */
    private int f7548n;

    /* renamed from: o  reason: collision with root package name */
    private Runnable f7549o;

    /* renamed from: p  reason: collision with root package name */
    private int f7550p;

    /* renamed from: q  reason: collision with root package name */
    private d f7551q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements Runnable {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: IndoorFloorSwitchView.java */
        /* renamed from: com.amap.api.col.3l.ef$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class RunnableC0102a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f7553a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f7554b;

            RunnableC0102a(int i4, int i5) {
                this.f7553a = i4;
                this.f7554b = i5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ef efVar = ef.this;
                efVar.smoothScrollTo(0, (efVar.f7548n - this.f7553a) + ef.this.f7537c);
                ef efVar2 = ef.this;
                efVar2.f7547m = this.f7554b + efVar2.f7545k + 1;
                ef.this.w();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: IndoorFloorSwitchView.java */
        /* renamed from: com.amap.api.col.3l.ef$a$b */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f7556a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f7557b;

            b(int i4, int i5) {
                this.f7556a = i4;
                this.f7557b = i5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ef efVar = ef.this;
                efVar.smoothScrollTo(0, efVar.f7548n - this.f7556a);
                ef efVar2 = ef.this;
                efVar2.f7547m = this.f7557b + efVar2.f7545k;
                ef.this.w();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ef.this.f7548n - ef.this.getScrollY() == 0) {
                if (ef.this.f7537c == 0) {
                    return;
                }
                int i4 = ef.this.f7548n % ef.this.f7537c;
                int i5 = ef.this.f7548n / ef.this.f7537c;
                if (i4 == 0) {
                    ef efVar = ef.this;
                    efVar.f7547m = i5 + efVar.f7545k;
                    ef.this.w();
                    return;
                } else if (i4 > ef.this.f7537c / 2) {
                    ef.this.post(new RunnableC0102a(i4, i5));
                    return;
                } else {
                    ef.this.post(new b(i4, i5));
                    return;
                }
            }
            ef efVar2 = ef.this;
            efVar2.f7548n = efVar2.getScrollY();
            ef efVar3 = ef.this;
            efVar3.postDelayed(efVar3.f7549o, ef.this.f7550p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends Drawable {
        b() {
        }

        private void a(Canvas canvas) {
            canvas.drawColor(ef.this.f7542h);
        }

        private void b(Canvas canvas) {
            Paint paint = new Paint();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = ef.this.f7541g.getWidth() + 0;
            rect.bottom = ef.this.f7541g.getHeight() + 0;
            rect2.left = 0;
            rect2.top = ef.this.u()[0];
            rect2.right = ef.this.f7540f + 0;
            rect2.bottom = ef.this.u()[1];
            canvas.drawBitmap(ef.this.f7541g, rect, rect2, paint);
        }

        private void c(Canvas canvas) {
            Paint paint = new Paint();
            Rect clipBounds = canvas.getClipBounds();
            paint.setColor(ef.this.f7543i);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(ef.this.f7544j);
            canvas.drawRect(clipBounds, paint);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            try {
                a(canvas);
                b(canvas);
                c(canvas);
            } catch (Throwable unused) {
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i4) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7560a;

        c(int i4) {
            this.f7560a = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ef efVar = ef.this;
            efVar.smoothScrollTo(0, this.f7560a * efVar.f7537c);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface d {
        void a(int i4);
    }

    public ef(Context context) {
        super(context);
        this.f7537c = 0;
        this.f7539e = -1;
        this.f7541g = null;
        this.f7542h = Color.parseColor("#eeffffff");
        this.f7543i = Color.parseColor("#44383838");
        this.f7544j = 4;
        this.f7545k = 1;
        this.f7547m = 1;
        this.f7550p = 50;
        g(context);
    }

    private static int a(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int b(View view) {
        n(view);
        return view.getMeasuredHeight();
    }

    private void f(int i4) {
        int i5 = this.f7537c;
        if (i5 == 0) {
            return;
        }
        int i6 = this.f7545k;
        int i7 = (i4 / i5) + i6;
        int i8 = i4 % i5;
        int i9 = i4 / i5;
        if (i8 == 0) {
            i7 = i9 + i6;
        } else if (i8 > i5 / 2) {
            i7 = i9 + i6 + 1;
        }
        int childCount = this.f7536b.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            TextView textView = (TextView) this.f7536b.getChildAt(i10);
            if (textView == null) {
                return;
            }
            if (i7 == i10) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    private void g(Context context) {
        this.f7535a = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f7541g == null) {
                InputStream open = u2.b(context).open("map_indoor_select.png");
                this.f7541g = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f7536b = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f7536b);
        this.f7549o = new a();
    }

    private TextView m(String str) {
        TextView textView = new TextView(this.f7535a);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a4 = a(this.f7535a, 8.0f);
        int a5 = a(this.f7535a, 6.0f);
        textView.setPadding(a4, a5, a4, a5);
        if (this.f7537c == 0) {
            this.f7537c = b(textView);
            this.f7536b.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f7537c * this.f7546l));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.f7537c * this.f7546l));
        }
        return textView;
    }

    private static void n(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void q() {
        this.f7548n = getScrollY();
        postDelayed(this.f7549o, this.f7550p);
    }

    private void r() {
        List<String> list = this.f7538d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f7536b.removeAllViews();
        this.f7546l = (this.f7545k * 2) + 1;
        for (int size = this.f7538d.size() - 1; size >= 0; size--) {
            this.f7536b.addView(m(this.f7538d.get(size)));
        }
        f(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] u() {
        int i4 = this.f7537c;
        int i5 = this.f7545k;
        return new int[]{i4 * i5, i4 * (i5 + 1)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        d dVar = this.f7551q;
        if (dVar != null) {
            try {
                dVar.a(x());
            } catch (Throwable unused) {
            }
        }
    }

    private int x() {
        List<String> list = this.f7538d;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f7538d.size() - (this.f7545k * 2), Math.max(0, ((this.f7538d.size() - 1) - this.f7547m) - this.f7545k));
    }

    public final void e() {
        Bitmap bitmap = this.f7541g;
        if (bitmap != null && !bitmap.isRecycled()) {
            a3.B(this.f7541g);
            this.f7541g = null;
        }
        if (this.f7551q != null) {
            this.f7551q = null;
        }
    }

    @Override // android.widget.ScrollView
    public void fling(int i4) {
        super.fling(i4 / 3);
    }

    public final void h(d dVar) {
        this.f7551q = dVar;
    }

    public final void i(String str) {
        List<String> list = this.f7538d;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f7538d.indexOf(str);
        int size = this.f7538d.size();
        int i4 = this.f7545k;
        int i5 = ((size - i4) - 1) - indexOf;
        this.f7547m = i4 + i5;
        post(new c(i5));
    }

    public final void j(boolean z3) {
        setVisibility(z3 ? 0 : 8);
    }

    public final void k(String[] strArr) {
        if (this.f7538d == null) {
            this.f7538d = new ArrayList();
        }
        this.f7538d.clear();
        for (String str : strArr) {
            this.f7538d.add(str);
        }
        for (int i4 = 0; i4 < this.f7545k; i4++) {
            this.f7538d.add(0, "");
            this.f7538d.add("");
        }
        r();
    }

    public final boolean o() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        f(i5);
        if (i5 > i7) {
            this.f7539e = 1;
        } else {
            this.f7539e = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f7540f = i4;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            q();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f7542h = i4;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f7540f == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.f7535a.getSystemService("window");
                if (windowManager != null) {
                    this.f7540f = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new b());
    }
}
