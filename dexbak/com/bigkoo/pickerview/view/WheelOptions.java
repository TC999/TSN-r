package com.bigkoo.pickerview.view;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.C3501R;
import com.bigkoo.pickerview.lib.WheelView;
import java.util.List;
import p596h.ArrayWheelAdapter;
import p600i.OnItemSelectedListener;

/* renamed from: com.bigkoo.pickerview.view.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WheelOptions<T> {

    /* renamed from: a */
    private View f13143a;

    /* renamed from: b */
    private WheelView f13144b;

    /* renamed from: c */
    private WheelView f13145c;

    /* renamed from: d */
    private WheelView f13146d;

    /* renamed from: e */
    private List<T> f13147e;

    /* renamed from: f */
    private List<List<T>> f13148f;

    /* renamed from: g */
    private List<T> f13149g;

    /* renamed from: h */
    private List<List<List<T>>> f13150h;

    /* renamed from: i */
    private List<T> f13151i;

    /* renamed from: j */
    private boolean f13152j;

    /* renamed from: k */
    private OnItemSelectedListener f13153k;

    /* renamed from: l */
    private OnItemSelectedListener f13154l;

    /* renamed from: m */
    int f13155m;

    /* renamed from: n */
    int f13156n;

    /* renamed from: o */
    int f13157o;

    /* renamed from: p */
    private WheelView.DividerType f13158p;

    /* renamed from: q */
    float f13159q = 1.6f;

    /* compiled from: WheelOptions.java */
    /* renamed from: com.bigkoo.pickerview.view.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3520a implements OnItemSelectedListener {
        C3520a() {
        }

        @Override // p600i.OnItemSelectedListener
        /* renamed from: a */
        public void mo12719a(int i) {
            int i2;
            if (WheelOptions.this.f13148f != null) {
                i2 = WheelOptions.this.f13145c.getCurrentItem();
                if (i2 >= ((List) WheelOptions.this.f13148f.get(i)).size() - 1) {
                    i2 = ((List) WheelOptions.this.f13148f.get(i)).size() - 1;
                }
                WheelOptions.this.f13145c.setAdapter(new ArrayWheelAdapter((List) WheelOptions.this.f13148f.get(i)));
                WheelOptions.this.f13145c.setCurrentItem(i2);
            } else {
                i2 = 0;
            }
            if (WheelOptions.this.f13150h != null) {
                WheelOptions.this.f13154l.mo12719a(i2);
            }
        }
    }

    /* compiled from: WheelOptions.java */
    /* renamed from: com.bigkoo.pickerview.view.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3521b implements OnItemSelectedListener {
        C3521b() {
        }

        @Override // p600i.OnItemSelectedListener
        /* renamed from: a */
        public void mo12719a(int i) {
            if (WheelOptions.this.f13150h != null) {
                int currentItem = WheelOptions.this.f13144b.getCurrentItem();
                if (currentItem >= WheelOptions.this.f13150h.size() - 1) {
                    currentItem = WheelOptions.this.f13150h.size() - 1;
                }
                if (i >= ((List) WheelOptions.this.f13148f.get(currentItem)).size() - 1) {
                    i = ((List) WheelOptions.this.f13148f.get(currentItem)).size() - 1;
                }
                int currentItem2 = WheelOptions.this.f13146d.getCurrentItem();
                if (currentItem2 >= ((List) ((List) WheelOptions.this.f13150h.get(currentItem)).get(i)).size() - 1) {
                    currentItem2 = ((List) ((List) WheelOptions.this.f13150h.get(currentItem)).get(i)).size() - 1;
                }
                WheelOptions.this.f13146d.setAdapter(new ArrayWheelAdapter((List) ((List) WheelOptions.this.f13150h.get(WheelOptions.this.f13144b.getCurrentItem())).get(i)));
                WheelOptions.this.f13146d.setCurrentItem(currentItem2);
            }
        }
    }

    public WheelOptions(View view, Boolean bool) {
        this.f13152j = bool.booleanValue();
        this.f13143a = view;
        this.f13144b = (WheelView) view.findViewById(C3501R.C3504id.options1);
        this.f13145c = (WheelView) view.findViewById(C3501R.C3504id.options2);
        this.f13146d = (WheelView) view.findViewById(C3501R.C3504id.options3);
    }

    /* renamed from: i */
    private void m45845i(int i, int i2, int i3) {
        List<List<T>> list = this.f13148f;
        if (list != null) {
            this.f13145c.setAdapter(new ArrayWheelAdapter(list.get(i)));
            this.f13145c.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.f13150h;
        if (list2 != null) {
            this.f13146d.setAdapter(new ArrayWheelAdapter(list2.get(i).get(i2)));
            this.f13146d.setCurrentItem(i3);
        }
    }

    /* renamed from: m */
    private void m45841m() {
        this.f13144b.setDividerColor(this.f13157o);
        this.f13145c.setDividerColor(this.f13157o);
        this.f13146d.setDividerColor(this.f13157o);
    }

    /* renamed from: o */
    private void m45839o() {
        this.f13144b.setDividerType(this.f13158p);
        this.f13145c.setDividerType(this.f13158p);
        this.f13146d.setDividerType(this.f13158p);
    }

    /* renamed from: r */
    private void m45836r() {
        this.f13144b.setLineSpacingMultiplier(this.f13159q);
        this.f13145c.setLineSpacingMultiplier(this.f13159q);
        this.f13146d.setLineSpacingMultiplier(this.f13159q);
    }

    /* renamed from: v */
    private void m45832v() {
        this.f13144b.setTextColorCenter(this.f13156n);
        this.f13145c.setTextColorCenter(this.f13156n);
        this.f13146d.setTextColorCenter(this.f13156n);
    }

    /* renamed from: x */
    private void m45830x() {
        this.f13144b.setTextColorOut(this.f13155m);
        this.f13145c.setTextColorOut(this.f13155m);
        this.f13146d.setTextColorOut(this.f13155m);
    }

    /* renamed from: A */
    public void m45855A(Typeface typeface) {
        this.f13144b.setTypeface(typeface);
        this.f13145c.setTypeface(typeface);
        this.f13146d.setTypeface(typeface);
    }

    /* renamed from: B */
    public void m45854B(View view) {
        this.f13143a = view;
    }

    /* renamed from: g */
    public int[] m45847g() {
        int[] iArr = new int[3];
        iArr[0] = this.f13144b.getCurrentItem();
        List<List<T>> list = this.f13148f;
        if (list != null && list.size() > 0) {
            iArr[1] = this.f13145c.getCurrentItem() > this.f13148f.get(iArr[0]).size() - 1 ? 0 : this.f13145c.getCurrentItem();
        } else {
            iArr[1] = this.f13145c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f13150h;
        if (list2 != null && list2.size() > 0) {
            iArr[2] = this.f13146d.getCurrentItem() <= this.f13150h.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f13146d.getCurrentItem() : 0;
        } else {
            iArr[2] = this.f13146d.getCurrentItem();
        }
        return iArr;
    }

    /* renamed from: h */
    public View m45846h() {
        return this.f13143a;
    }

    /* renamed from: j */
    public void m45844j(int i, int i2, int i3) {
        if (this.f13152j) {
            m45845i(i, i2, i3);
        }
        this.f13144b.setCurrentItem(i);
        this.f13145c.setCurrentItem(i2);
        this.f13146d.setCurrentItem(i3);
    }

    /* renamed from: k */
    public void m45843k(boolean z) {
        this.f13144b.setCyclic(z);
        this.f13145c.setCyclic(z);
        this.f13146d.setCyclic(z);
    }

    /* renamed from: l */
    public void m45842l(boolean z, boolean z2, boolean z3) {
        this.f13144b.setCyclic(z);
        this.f13145c.setCyclic(z2);
        this.f13146d.setCyclic(z3);
    }

    /* renamed from: n */
    public void m45840n(int i) {
        this.f13157o = i;
        m45841m();
    }

    /* renamed from: p */
    public void m45838p(WheelView.DividerType dividerType) {
        this.f13158p = dividerType;
        m45839o();
    }

    /* renamed from: q */
    public void m45837q(String str, String str2, String str3) {
        if (str != null) {
            this.f13144b.setLabel(str);
        }
        if (str2 != null) {
            this.f13145c.setLabel(str2);
        }
        if (str3 != null) {
            this.f13146d.setLabel(str3);
        }
    }

    /* renamed from: s */
    public void m45835s(float f) {
        this.f13159q = f;
        m45836r();
    }

    /* renamed from: t */
    public void m45834t(List<T> list, List<T> list2, List<T> list3) {
        this.f13147e = list;
        this.f13149g = list2;
        this.f13151i = list3;
        int i = list3 == null ? 8 : 4;
        if (list2 == null) {
            i = 12;
        }
        this.f13144b.setAdapter(new ArrayWheelAdapter(list, i));
        this.f13144b.setCurrentItem(0);
        List<T> list4 = this.f13149g;
        if (list4 != null) {
            this.f13145c.setAdapter(new ArrayWheelAdapter(list4));
        }
        this.f13145c.setCurrentItem(this.f13144b.getCurrentItem());
        List<T> list5 = this.f13151i;
        if (list5 != null) {
            this.f13146d.setAdapter(new ArrayWheelAdapter(list5));
        }
        WheelView wheelView = this.f13146d;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        this.f13144b.setIsOptions(true);
        this.f13145c.setIsOptions(true);
        this.f13146d.setIsOptions(true);
        if (this.f13149g == null) {
            this.f13145c.setVisibility(8);
        }
        if (this.f13151i == null) {
            this.f13146d.setVisibility(8);
        }
    }

    /* renamed from: u */
    public void m45833u(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f13147e = list;
        this.f13148f = list2;
        this.f13150h = list3;
        int i = list3 == null ? 8 : 4;
        if (list2 == null) {
            i = 12;
        }
        this.f13144b.setAdapter(new ArrayWheelAdapter(list, i));
        this.f13144b.setCurrentItem(0);
        List<List<T>> list4 = this.f13148f;
        if (list4 != null) {
            this.f13145c.setAdapter(new ArrayWheelAdapter(list4.get(0)));
        }
        this.f13145c.setCurrentItem(this.f13144b.getCurrentItem());
        List<List<List<T>>> list5 = this.f13150h;
        if (list5 != null) {
            this.f13146d.setAdapter(new ArrayWheelAdapter(list5.get(0).get(0)));
        }
        WheelView wheelView = this.f13146d;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        this.f13144b.setIsOptions(true);
        this.f13145c.setIsOptions(true);
        this.f13146d.setIsOptions(true);
        if (this.f13148f == null) {
            this.f13145c.setVisibility(8);
        }
        if (this.f13150h == null) {
            this.f13146d.setVisibility(8);
        }
        this.f13153k = new C3520a();
        this.f13154l = new C3521b();
        if (list2 != null && this.f13152j) {
            this.f13144b.setOnItemSelectedListener(this.f13153k);
        }
        if (list3 == null || !this.f13152j) {
            return;
        }
        this.f13145c.setOnItemSelectedListener(this.f13154l);
    }

    /* renamed from: w */
    public void m45831w(int i) {
        this.f13156n = i;
        m45832v();
    }

    /* renamed from: y */
    public void m45829y(int i) {
        this.f13155m = i;
        m45830x();
    }

    /* renamed from: z */
    public void m45828z(int i) {
        float f = i;
        this.f13144b.setTextSize(f);
        this.f13145c.setTextSize(f);
        this.f13146d.setTextSize(f);
    }
}
