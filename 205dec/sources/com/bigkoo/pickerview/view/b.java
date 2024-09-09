package com.bigkoo.pickerview.view;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.lib.WheelView;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: WheelOptions.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private View f16341a;

    /* renamed from: b  reason: collision with root package name */
    private WheelView f16342b;

    /* renamed from: c  reason: collision with root package name */
    private WheelView f16343c;

    /* renamed from: d  reason: collision with root package name */
    private WheelView f16344d;

    /* renamed from: e  reason: collision with root package name */
    private List<T> f16345e;

    /* renamed from: f  reason: collision with root package name */
    private List<List<T>> f16346f;

    /* renamed from: g  reason: collision with root package name */
    private List<T> f16347g;

    /* renamed from: h  reason: collision with root package name */
    private List<List<List<T>>> f16348h;

    /* renamed from: i  reason: collision with root package name */
    private List<T> f16349i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16350j;

    /* renamed from: k  reason: collision with root package name */
    private i.c f16351k;

    /* renamed from: l  reason: collision with root package name */
    private i.c f16352l;

    /* renamed from: m  reason: collision with root package name */
    int f16353m;

    /* renamed from: n  reason: collision with root package name */
    int f16354n;

    /* renamed from: o  reason: collision with root package name */
    int f16355o;

    /* renamed from: p  reason: collision with root package name */
    private WheelView.DividerType f16356p;

    /* renamed from: q  reason: collision with root package name */
    float f16357q = 1.6f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: WheelOptions.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements i.c {
        a() {
        }

        @Override // i.c
        public void a(int i4) {
            int i5;
            if (b.this.f16346f != null) {
                i5 = b.this.f16343c.getCurrentItem();
                if (i5 >= ((List) b.this.f16346f.get(i4)).size() - 1) {
                    i5 = ((List) b.this.f16346f.get(i4)).size() - 1;
                }
                b.this.f16343c.setAdapter(new h.a((List) b.this.f16346f.get(i4)));
                b.this.f16343c.setCurrentItem(i5);
            } else {
                i5 = 0;
            }
            if (b.this.f16348h != null) {
                b.this.f16352l.a(i5);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: WheelOptions.java */
    /* renamed from: com.bigkoo.pickerview.view.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class C0160b implements i.c {
        C0160b() {
        }

        @Override // i.c
        public void a(int i4) {
            if (b.this.f16348h != null) {
                int currentItem = b.this.f16342b.getCurrentItem();
                if (currentItem >= b.this.f16348h.size() - 1) {
                    currentItem = b.this.f16348h.size() - 1;
                }
                if (i4 >= ((List) b.this.f16346f.get(currentItem)).size() - 1) {
                    i4 = ((List) b.this.f16346f.get(currentItem)).size() - 1;
                }
                int currentItem2 = b.this.f16344d.getCurrentItem();
                if (currentItem2 >= ((List) ((List) b.this.f16348h.get(currentItem)).get(i4)).size() - 1) {
                    currentItem2 = ((List) ((List) b.this.f16348h.get(currentItem)).get(i4)).size() - 1;
                }
                b.this.f16344d.setAdapter(new h.a((List) ((List) b.this.f16348h.get(b.this.f16342b.getCurrentItem())).get(i4)));
                b.this.f16344d.setCurrentItem(currentItem2);
            }
        }
    }

    public b(View view, Boolean bool) {
        this.f16350j = bool.booleanValue();
        this.f16341a = view;
        this.f16342b = (WheelView) view.findViewById(R.id.options1);
        this.f16343c = (WheelView) view.findViewById(R.id.options2);
        this.f16344d = (WheelView) view.findViewById(R.id.options3);
    }

    private void i(int i4, int i5, int i6) {
        List<List<T>> list = this.f16346f;
        if (list != null) {
            this.f16343c.setAdapter(new h.a(list.get(i4)));
            this.f16343c.setCurrentItem(i5);
        }
        List<List<List<T>>> list2 = this.f16348h;
        if (list2 != null) {
            this.f16344d.setAdapter(new h.a(list2.get(i4).get(i5)));
            this.f16344d.setCurrentItem(i6);
        }
    }

    private void m() {
        this.f16342b.setDividerColor(this.f16355o);
        this.f16343c.setDividerColor(this.f16355o);
        this.f16344d.setDividerColor(this.f16355o);
    }

    private void o() {
        this.f16342b.setDividerType(this.f16356p);
        this.f16343c.setDividerType(this.f16356p);
        this.f16344d.setDividerType(this.f16356p);
    }

    private void r() {
        this.f16342b.setLineSpacingMultiplier(this.f16357q);
        this.f16343c.setLineSpacingMultiplier(this.f16357q);
        this.f16344d.setLineSpacingMultiplier(this.f16357q);
    }

    private void v() {
        this.f16342b.setTextColorCenter(this.f16354n);
        this.f16343c.setTextColorCenter(this.f16354n);
        this.f16344d.setTextColorCenter(this.f16354n);
    }

    private void x() {
        this.f16342b.setTextColorOut(this.f16353m);
        this.f16343c.setTextColorOut(this.f16353m);
        this.f16344d.setTextColorOut(this.f16353m);
    }

    public void A(Typeface typeface) {
        this.f16342b.setTypeface(typeface);
        this.f16343c.setTypeface(typeface);
        this.f16344d.setTypeface(typeface);
    }

    public void B(View view) {
        this.f16341a = view;
    }

    public int[] g() {
        int[] iArr = new int[3];
        iArr[0] = this.f16342b.getCurrentItem();
        List<List<T>> list = this.f16346f;
        if (list != null && list.size() > 0) {
            iArr[1] = this.f16343c.getCurrentItem() > this.f16346f.get(iArr[0]).size() - 1 ? 0 : this.f16343c.getCurrentItem();
        } else {
            iArr[1] = this.f16343c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f16348h;
        if (list2 != null && list2.size() > 0) {
            iArr[2] = this.f16344d.getCurrentItem() <= this.f16348h.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f16344d.getCurrentItem() : 0;
        } else {
            iArr[2] = this.f16344d.getCurrentItem();
        }
        return iArr;
    }

    public View h() {
        return this.f16341a;
    }

    public void j(int i4, int i5, int i6) {
        if (this.f16350j) {
            i(i4, i5, i6);
        }
        this.f16342b.setCurrentItem(i4);
        this.f16343c.setCurrentItem(i5);
        this.f16344d.setCurrentItem(i6);
    }

    public void k(boolean z3) {
        this.f16342b.setCyclic(z3);
        this.f16343c.setCyclic(z3);
        this.f16344d.setCyclic(z3);
    }

    public void l(boolean z3, boolean z4, boolean z5) {
        this.f16342b.setCyclic(z3);
        this.f16343c.setCyclic(z4);
        this.f16344d.setCyclic(z5);
    }

    public void n(int i4) {
        this.f16355o = i4;
        m();
    }

    public void p(WheelView.DividerType dividerType) {
        this.f16356p = dividerType;
        o();
    }

    public void q(String str, String str2, String str3) {
        if (str != null) {
            this.f16342b.setLabel(str);
        }
        if (str2 != null) {
            this.f16343c.setLabel(str2);
        }
        if (str3 != null) {
            this.f16344d.setLabel(str3);
        }
    }

    public void s(float f4) {
        this.f16357q = f4;
        r();
    }

    public void t(List<T> list, List<T> list2, List<T> list3) {
        this.f16345e = list;
        this.f16347g = list2;
        this.f16349i = list3;
        int i4 = list3 == null ? 8 : 4;
        if (list2 == null) {
            i4 = 12;
        }
        this.f16342b.setAdapter(new h.a(list, i4));
        this.f16342b.setCurrentItem(0);
        List<T> list4 = this.f16347g;
        if (list4 != null) {
            this.f16343c.setAdapter(new h.a(list4));
        }
        this.f16343c.setCurrentItem(this.f16342b.getCurrentItem());
        List<T> list5 = this.f16349i;
        if (list5 != null) {
            this.f16344d.setAdapter(new h.a(list5));
        }
        WheelView wheelView = this.f16344d;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        this.f16342b.setIsOptions(true);
        this.f16343c.setIsOptions(true);
        this.f16344d.setIsOptions(true);
        if (this.f16347g == null) {
            this.f16343c.setVisibility(8);
        }
        if (this.f16349i == null) {
            this.f16344d.setVisibility(8);
        }
    }

    public void u(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f16345e = list;
        this.f16346f = list2;
        this.f16348h = list3;
        int i4 = list3 == null ? 8 : 4;
        if (list2 == null) {
            i4 = 12;
        }
        this.f16342b.setAdapter(new h.a(list, i4));
        this.f16342b.setCurrentItem(0);
        List<List<T>> list4 = this.f16346f;
        if (list4 != null) {
            this.f16343c.setAdapter(new h.a(list4.get(0)));
        }
        this.f16343c.setCurrentItem(this.f16342b.getCurrentItem());
        List<List<List<T>>> list5 = this.f16348h;
        if (list5 != null) {
            this.f16344d.setAdapter(new h.a(list5.get(0).get(0)));
        }
        WheelView wheelView = this.f16344d;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        this.f16342b.setIsOptions(true);
        this.f16343c.setIsOptions(true);
        this.f16344d.setIsOptions(true);
        if (this.f16346f == null) {
            this.f16343c.setVisibility(8);
        }
        if (this.f16348h == null) {
            this.f16344d.setVisibility(8);
        }
        this.f16351k = new a();
        this.f16352l = new C0160b();
        if (list2 != null && this.f16350j) {
            this.f16342b.setOnItemSelectedListener(this.f16351k);
        }
        if (list3 == null || !this.f16350j) {
            return;
        }
        this.f16343c.setOnItemSelectedListener(this.f16352l);
    }

    public void w(int i4) {
        this.f16354n = i4;
        v();
    }

    public void y(int i4) {
        this.f16353m = i4;
        x();
    }

    public void z(int i4) {
        float f4 = i4;
        this.f16342b.setTextSize(f4);
        this.f16343c.setTextSize(f4);
        this.f16344d.setTextSize(f4);
    }
}
