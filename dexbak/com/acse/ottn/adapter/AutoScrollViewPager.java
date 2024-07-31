package com.acse.ottn.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.C1239R;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AutoScrollViewPager extends RelativeLayout {

    /* renamed from: a */
    private static final String f2215a = "right";

    /* renamed from: b */
    private static final String f2216b = "center";

    /* renamed from: c */
    private static final int f2217c = 0;

    /* renamed from: d */
    private static final int f2218d = 1;

    /* renamed from: e */
    private C1310b f2219e;

    /* renamed from: f */
    private Context f2220f;

    /* renamed from: g */
    private LinearLayout f2221g;

    /* renamed from: h */
    private View f2222h;

    /* renamed from: i */
    private TextView f2223i;

    public AutoScrollViewPager(Context context) {
        this(context, null);
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r8.equals("right") == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AutoScrollViewPager(android.content.Context r6, android.util.AttributeSet r7, int r8) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            int[] r0 = com.acse.ottn.C1239R.styleable.AutoScrollViewPager
            r1 = 0
            android.content.res.TypedArray r7 = r6.obtainStyledAttributes(r7, r0, r8, r1)
            int r8 = com.acse.ottn.C1239R.styleable.AutoScrollViewPager_point_layout
            java.lang.String r8 = r7.getString(r8)
            java.lang.String r0 = "center"
            if (r8 != 0) goto L15
            r8 = r0
        L15:
            r2 = -1
            int r3 = r8.hashCode()
            r4 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            if (r3 == r4) goto L2e
            r0 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r3 == r0) goto L25
            goto L36
        L25:
            java.lang.String r0 = "right"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L36
            goto L37
        L2e:
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L36
            r1 = 1
            goto L37
        L36:
            r1 = -1
        L37:
            r8 = 0
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r6)
            if (r1 == 0) goto L41
            int r1 = com.acse.ottn.C1239R.C1244layout.point_center_text
            goto L43
        L41:
            int r1 = com.acse.ottn.C1239R.C1244layout.point_right_text
        L43:
            android.view.View r8 = r0.inflate(r1, r8)
            r5.f2222h = r8
            r7.recycle()
            r5.m57246a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.adapter.AutoScrollViewPager.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* renamed from: a */
    private void m57246a(Context context) {
        this.f2220f = context;
        C1310b c1310b = new C1310b(context);
        this.f2219e = c1310b;
        addView(c1310b);
        View view = this.f2222h;
        if (view != null) {
            this.f2223i = (TextView) view.findViewById(C1239R.C1242id.subTitle);
            this.f2221g = (LinearLayout) this.f2222h.findViewById(C1239R.C1242id.pointLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            this.f2222h.setLayoutParams(layoutParams);
            addView(this.f2222h);
        }
    }

    /* renamed from: a */
    public void m57249a() {
        C1310b c1310b = this.f2219e;
        if (c1310b != null) {
            c1310b.m57237b();
        }
    }

    /* renamed from: a */
    public void m57248a(int i) {
        m57247a(i, 0);
    }

    /* renamed from: a */
    public void m57247a(int i, int i2) {
        this.f2221g.removeAllViews();
        int i3 = 0;
        while (i3 < i) {
            ImageView imageView = new ImageView(this.f2220f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
            layoutParams.leftMargin = 8;
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundResource(i3 == i2 ? C1239R.C1241drawable.point_checked : C1239R.C1241drawable.point_normal);
            this.f2221g.addView(imageView);
            i3++;
        }
    }

    /* renamed from: b */
    public void m57245b() {
        C1310b c1310b = this.f2219e;
        if (c1310b != null) {
            c1310b.m57232d();
        }
    }

    /* renamed from: b */
    public void m57244b(int i) {
        int childCount = this.f2221g.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            ((ImageView) this.f2221g.getChildAt(i2)).setBackgroundResource(i2 == i ? C1239R.C1241drawable.point_checked : C1239R.C1241drawable.point_normal);
            i2++;
        }
    }

    /* renamed from: c */
    public void m57243c() {
        C1310b c1310b = this.f2219e;
        if (c1310b == null || c1310b.m57242a()) {
            return;
        }
        this.f2219e.m57231e();
    }

    public TextView getSubTitle() {
        return this.f2223i;
    }

    public C1310b getViewPager() {
        return this.f2219e;
    }

    public void setAdapter(AbstractC1314d abstractC1314d) {
        C1310b c1310b = this.f2219e;
        if (c1310b != null) {
            c1310b.m57238a(c1310b, abstractC1314d);
        }
    }
}
