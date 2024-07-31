package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.ef */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IndoorFloorSwitchView extends ScrollView {

    /* renamed from: r */
    public static final String f3956r = IndoorFloorSwitchView.class.getSimpleName();

    /* renamed from: a */
    private Context f3957a;

    /* renamed from: b */
    private LinearLayout f3958b;

    /* renamed from: c */
    private int f3959c;

    /* renamed from: d */
    private List<String> f3960d;

    /* renamed from: e */
    private int f3961e;

    /* renamed from: f */
    private int f3962f;

    /* renamed from: g */
    private Bitmap f3963g;

    /* renamed from: h */
    private int f3964h;

    /* renamed from: i */
    private int f3965i;

    /* renamed from: j */
    private int f3966j;

    /* renamed from: k */
    private int f3967k;

    /* renamed from: l */
    private int f3968l;

    /* renamed from: m */
    int f3969m;

    /* renamed from: n */
    private int f3970n;

    /* renamed from: o */
    private Runnable f3971o;

    /* renamed from: p */
    private int f3972p;

    /* renamed from: q */
    private InterfaceC1789d f3973q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class RunnableC1784a implements Runnable {

        /* compiled from: IndoorFloorSwitchView.java */
        /* renamed from: com.amap.api.col.3l.ef$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class RunnableC1785a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f3975a;

            /* renamed from: b */
            final /* synthetic */ int f3976b;

            RunnableC1785a(int i, int i2) {
                this.f3975a = i;
                this.f3976b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IndoorFloorSwitchView indoorFloorSwitchView = IndoorFloorSwitchView.this;
                indoorFloorSwitchView.smoothScrollTo(0, (indoorFloorSwitchView.f3970n - this.f3975a) + IndoorFloorSwitchView.this.f3959c);
                IndoorFloorSwitchView indoorFloorSwitchView2 = IndoorFloorSwitchView.this;
                indoorFloorSwitchView2.f3969m = this.f3976b + indoorFloorSwitchView2.f3967k + 1;
                IndoorFloorSwitchView.this.m55160w();
            }
        }

        /* compiled from: IndoorFloorSwitchView.java */
        /* renamed from: com.amap.api.col.3l.ef$a$b */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class RunnableC1786b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f3978a;

            /* renamed from: b */
            final /* synthetic */ int f3979b;

            RunnableC1786b(int i, int i2) {
                this.f3978a = i;
                this.f3979b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IndoorFloorSwitchView indoorFloorSwitchView = IndoorFloorSwitchView.this;
                indoorFloorSwitchView.smoothScrollTo(0, indoorFloorSwitchView.f3970n - this.f3978a);
                IndoorFloorSwitchView indoorFloorSwitchView2 = IndoorFloorSwitchView.this;
                indoorFloorSwitchView2.f3969m = this.f3979b + indoorFloorSwitchView2.f3967k;
                IndoorFloorSwitchView.this.m55160w();
            }
        }

        RunnableC1784a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (IndoorFloorSwitchView.this.f3970n - IndoorFloorSwitchView.this.getScrollY() == 0) {
                if (IndoorFloorSwitchView.this.f3959c == 0) {
                    return;
                }
                int i = IndoorFloorSwitchView.this.f3970n % IndoorFloorSwitchView.this.f3959c;
                int i2 = IndoorFloorSwitchView.this.f3970n / IndoorFloorSwitchView.this.f3959c;
                if (i == 0) {
                    IndoorFloorSwitchView indoorFloorSwitchView = IndoorFloorSwitchView.this;
                    indoorFloorSwitchView.f3969m = i2 + indoorFloorSwitchView.f3967k;
                    IndoorFloorSwitchView.this.m55160w();
                    return;
                } else if (i > IndoorFloorSwitchView.this.f3959c / 2) {
                    IndoorFloorSwitchView.this.post(new RunnableC1785a(i, i2));
                    return;
                } else {
                    IndoorFloorSwitchView.this.post(new RunnableC1786b(i, i2));
                    return;
                }
            }
            IndoorFloorSwitchView indoorFloorSwitchView2 = IndoorFloorSwitchView.this;
            indoorFloorSwitchView2.f3970n = indoorFloorSwitchView2.getScrollY();
            IndoorFloorSwitchView indoorFloorSwitchView3 = IndoorFloorSwitchView.this;
            indoorFloorSwitchView3.postDelayed(indoorFloorSwitchView3.f3971o, IndoorFloorSwitchView.this.f3972p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1787b extends Drawable {
        C1787b() {
        }

        /* renamed from: a */
        private void m55156a(Canvas canvas) {
            canvas.drawColor(IndoorFloorSwitchView.this.f3964h);
        }

        /* renamed from: b */
        private void m55155b(Canvas canvas) {
            Paint paint = new Paint();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = IndoorFloorSwitchView.this.f3963g.getWidth() + 0;
            rect.bottom = IndoorFloorSwitchView.this.f3963g.getHeight() + 0;
            rect2.left = 0;
            rect2.top = IndoorFloorSwitchView.this.m55162u()[0];
            rect2.right = IndoorFloorSwitchView.this.f3962f + 0;
            rect2.bottom = IndoorFloorSwitchView.this.m55162u()[1];
            canvas.drawBitmap(IndoorFloorSwitchView.this.f3963g, rect, rect2, paint);
        }

        /* renamed from: c */
        private void m55154c(Canvas canvas) {
            Paint paint = new Paint();
            Rect clipBounds = canvas.getClipBounds();
            paint.setColor(IndoorFloorSwitchView.this.f3965i);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(IndoorFloorSwitchView.this.f3966j);
            canvas.drawRect(clipBounds, paint);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            try {
                m55156a(canvas);
                m55155b(canvas);
                m55154c(canvas);
            } catch (Throwable unused) {
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class RunnableC1788c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f3982a;

        RunnableC1788c(int i) {
            this.f3982a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IndoorFloorSwitchView indoorFloorSwitchView = IndoorFloorSwitchView.this;
            indoorFloorSwitchView.smoothScrollTo(0, this.f3982a * indoorFloorSwitchView.f3959c);
        }
    }

    /* compiled from: IndoorFloorSwitchView.java */
    /* renamed from: com.amap.api.col.3l.ef$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1789d {
        /* renamed from: a */
        void mo54275a(int i);
    }

    public IndoorFloorSwitchView(Context context) {
        super(context);
        this.f3959c = 0;
        this.f3961e = -1;
        this.f3963g = null;
        this.f3964h = Color.parseColor("#eeffffff");
        this.f3965i = Color.parseColor("#44383838");
        this.f3966j = 4;
        this.f3967k = 1;
        this.f3969m = 1;
        this.f3972p = 50;
        m55176g(context);
    }

    /* renamed from: a */
    private static int m55182a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    private static int m55181b(View view) {
        m55169n(view);
        return view.getMeasuredHeight();
    }

    /* renamed from: f */
    private void m55177f(int i) {
        int i2 = this.f3959c;
        if (i2 == 0) {
            return;
        }
        int i3 = this.f3967k;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.f3958b.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            TextView textView = (TextView) this.f3958b.getChildAt(i7);
            if (textView == null) {
                return;
            }
            if (i4 == i7) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    /* renamed from: g */
    private void m55176g(Context context) {
        this.f3957a = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f3963g == null) {
                InputStream open = ResourcesUtil.m53805b(context).open("map_indoor_select.png");
                this.f3963g = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f3958b = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f3958b);
        this.f3971o = new RunnableC1784a();
    }

    /* renamed from: m */
    private TextView m55170m(String str) {
        TextView textView = new TextView(this.f3957a);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int m55182a = m55182a(this.f3957a, 8.0f);
        int m55182a2 = m55182a(this.f3957a, 6.0f);
        textView.setPadding(m55182a, m55182a2, m55182a, m55182a2);
        if (this.f3959c == 0) {
            this.f3959c = m55181b(textView);
            this.f3958b.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f3959c * this.f3968l));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.f3959c * this.f3968l));
        }
        return textView;
    }

    /* renamed from: n */
    private static void m55169n(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    /* renamed from: q */
    private void m55166q() {
        this.f3970n = getScrollY();
        postDelayed(this.f3971o, this.f3972p);
    }

    /* renamed from: r */
    private void m55165r() {
        List<String> list = this.f3960d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f3958b.removeAllViews();
        this.f3968l = (this.f3967k * 2) + 1;
        for (int size = this.f3960d.size() - 1; size >= 0; size--) {
            this.f3958b.addView(m55170m(this.f3960d.get(size)));
        }
        m55177f(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public int[] m55162u() {
        int i = this.f3959c;
        int i2 = this.f3967k;
        return new int[]{i * i2, i * (i2 + 1)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m55160w() {
        InterfaceC1789d interfaceC1789d = this.f3973q;
        if (interfaceC1789d != null) {
            try {
                interfaceC1789d.mo54275a(m55159x());
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: x */
    private int m55159x() {
        List<String> list = this.f3960d;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f3960d.size() - (this.f3967k * 2), Math.max(0, ((this.f3960d.size() - 1) - this.f3969m) - this.f3967k));
    }

    /* renamed from: e */
    public final void m55178e() {
        Bitmap bitmap = this.f3963g;
        if (bitmap != null && !bitmap.isRecycled()) {
            C1732a3.m55743B(this.f3963g);
            this.f3963g = null;
        }
        if (this.f3973q != null) {
            this.f3973q = null;
        }
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    /* renamed from: h */
    public final void m55175h(InterfaceC1789d interfaceC1789d) {
        this.f3973q = interfaceC1789d;
    }

    /* renamed from: i */
    public final void m55174i(String str) {
        List<String> list = this.f3960d;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f3960d.indexOf(str);
        int size = this.f3960d.size();
        int i = this.f3967k;
        int i2 = ((size - i) - 1) - indexOf;
        this.f3969m = i + i2;
        post(new RunnableC1788c(i2));
    }

    /* renamed from: j */
    public final void m55173j(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    /* renamed from: k */
    public final void m55172k(String[] strArr) {
        if (this.f3960d == null) {
            this.f3960d = new ArrayList();
        }
        this.f3960d.clear();
        for (String str : strArr) {
            this.f3960d.add(str);
        }
        for (int i = 0; i < this.f3967k; i++) {
            this.f3960d.add(0, "");
            this.f3960d.add("");
        }
        m55165r();
    }

    /* renamed from: o */
    public final boolean m55168o() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m55177f(i2);
        if (i2 > i4) {
            this.f3961e = 1;
        } else {
            this.f3961e = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3962f = i;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m55166q();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f3964h = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f3962f == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.f3957a.getSystemService("window");
                if (windowManager != null) {
                    this.f3962f = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new C1787b());
    }
}
