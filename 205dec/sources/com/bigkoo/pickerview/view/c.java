package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.lib.WheelView;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: WheelTime.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c {
    private static final int A = 12;
    private static final int B = 1;
    private static final int C = 31;

    /* renamed from: w  reason: collision with root package name */
    public static DateFormat f16360w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: x  reason: collision with root package name */
    private static final int f16361x = 1900;

    /* renamed from: y  reason: collision with root package name */
    private static final int f16362y = 2100;

    /* renamed from: z  reason: collision with root package name */
    private static final int f16363z = 1;

    /* renamed from: a  reason: collision with root package name */
    private View f16364a;

    /* renamed from: b  reason: collision with root package name */
    private WheelView f16365b;

    /* renamed from: c  reason: collision with root package name */
    private WheelView f16366c;

    /* renamed from: d  reason: collision with root package name */
    private WheelView f16367d;

    /* renamed from: e  reason: collision with root package name */
    private WheelView f16368e;

    /* renamed from: f  reason: collision with root package name */
    private WheelView f16369f;

    /* renamed from: g  reason: collision with root package name */
    private WheelView f16370g;

    /* renamed from: h  reason: collision with root package name */
    private int f16371h;

    /* renamed from: i  reason: collision with root package name */
    private TimePickerView.Type f16372i;

    /* renamed from: j  reason: collision with root package name */
    private int f16373j;

    /* renamed from: k  reason: collision with root package name */
    private int f16374k;

    /* renamed from: l  reason: collision with root package name */
    private int f16375l;

    /* renamed from: m  reason: collision with root package name */
    private int f16376m;

    /* renamed from: n  reason: collision with root package name */
    private int f16377n;

    /* renamed from: o  reason: collision with root package name */
    private int f16378o;

    /* renamed from: p  reason: collision with root package name */
    private int f16379p;

    /* renamed from: q  reason: collision with root package name */
    private int f16380q;

    /* renamed from: r  reason: collision with root package name */
    int f16381r;

    /* renamed from: s  reason: collision with root package name */
    int f16382s;

    /* renamed from: t  reason: collision with root package name */
    int f16383t;

    /* renamed from: u  reason: collision with root package name */
    float f16384u;

    /* renamed from: v  reason: collision with root package name */
    private WheelView.DividerType f16385v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: WheelTime.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements i.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f16386a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f16387b;

        a(List list, List list2) {
            this.f16386a = list;
            this.f16387b = list2;
        }

        @Override // i.c
        public void a(int i4) {
            int i5 = i4 + c.this.f16373j;
            c.this.f16379p = i5;
            int currentItem = c.this.f16366c.getCurrentItem();
            if (c.this.f16373j == c.this.f16374k) {
                c.this.f16366c.setAdapter(new h.b(c.this.f16375l, c.this.f16376m));
                if (currentItem > c.this.f16366c.getAdapter().a() - 1) {
                    currentItem = c.this.f16366c.getAdapter().a() - 1;
                    c.this.f16366c.setCurrentItem(currentItem);
                }
                int i6 = currentItem + c.this.f16375l;
                if (c.this.f16375l == c.this.f16376m) {
                    c cVar = c.this;
                    cVar.B(i5, i6, cVar.f16377n, c.this.f16378o, this.f16386a, this.f16387b);
                } else if (i6 == c.this.f16375l) {
                    c cVar2 = c.this;
                    cVar2.B(i5, i6, cVar2.f16377n, 31, this.f16386a, this.f16387b);
                } else {
                    c.this.B(i5, i6, 1, 31, this.f16386a, this.f16387b);
                }
            } else if (i5 == c.this.f16373j) {
                c.this.f16366c.setAdapter(new h.b(c.this.f16375l, 12));
                if (currentItem > c.this.f16366c.getAdapter().a() - 1) {
                    currentItem = c.this.f16366c.getAdapter().a() - 1;
                    c.this.f16366c.setCurrentItem(currentItem);
                }
                int i7 = currentItem + c.this.f16375l;
                if (i7 == c.this.f16375l) {
                    c cVar3 = c.this;
                    cVar3.B(i5, i7, cVar3.f16377n, 31, this.f16386a, this.f16387b);
                    return;
                }
                c.this.B(i5, i7, 1, 31, this.f16386a, this.f16387b);
            } else if (i5 == c.this.f16374k) {
                c.this.f16366c.setAdapter(new h.b(1, c.this.f16376m));
                if (currentItem > c.this.f16366c.getAdapter().a() - 1) {
                    currentItem = c.this.f16366c.getAdapter().a() - 1;
                    c.this.f16366c.setCurrentItem(currentItem);
                }
                int i8 = 1 + currentItem;
                if (i8 == c.this.f16376m) {
                    c cVar4 = c.this;
                    cVar4.B(i5, i8, 1, cVar4.f16378o, this.f16386a, this.f16387b);
                    return;
                }
                c.this.B(i5, i8, 1, 31, this.f16386a, this.f16387b);
            } else {
                c.this.f16366c.setAdapter(new h.b(1, 12));
                c cVar5 = c.this;
                cVar5.B(i5, 1 + cVar5.f16366c.getCurrentItem(), 1, 31, this.f16386a, this.f16387b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: WheelTime.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b implements i.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f16389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f16390b;

        b(List list, List list2) {
            this.f16389a = list;
            this.f16390b = list2;
        }

        @Override // i.c
        public void a(int i4) {
            int i5 = i4 + 1;
            if (c.this.f16373j == c.this.f16374k) {
                int i6 = (i5 + c.this.f16375l) - 1;
                if (c.this.f16375l == c.this.f16376m) {
                    c cVar = c.this;
                    cVar.B(cVar.f16379p, i6, c.this.f16377n, c.this.f16378o, this.f16389a, this.f16390b);
                } else if (c.this.f16375l == i6) {
                    c cVar2 = c.this;
                    cVar2.B(cVar2.f16379p, i6, c.this.f16377n, 31, this.f16389a, this.f16390b);
                } else if (c.this.f16376m == i6) {
                    c cVar3 = c.this;
                    cVar3.B(cVar3.f16379p, i6, 1, c.this.f16378o, this.f16389a, this.f16390b);
                } else {
                    c cVar4 = c.this;
                    cVar4.B(cVar4.f16379p, i6, 1, 31, this.f16389a, this.f16390b);
                }
            } else if (c.this.f16379p == c.this.f16373j) {
                int i7 = (i5 + c.this.f16375l) - 1;
                if (i7 == c.this.f16375l) {
                    c cVar5 = c.this;
                    cVar5.B(cVar5.f16379p, i7, c.this.f16377n, 31, this.f16389a, this.f16390b);
                    return;
                }
                c cVar6 = c.this;
                cVar6.B(cVar6.f16379p, i7, 1, 31, this.f16389a, this.f16390b);
            } else if (c.this.f16379p == c.this.f16374k) {
                if (i5 == c.this.f16376m) {
                    c cVar7 = c.this;
                    cVar7.B(cVar7.f16379p, c.this.f16366c.getCurrentItem() + 1, 1, c.this.f16378o, this.f16389a, this.f16390b);
                    return;
                }
                c cVar8 = c.this;
                cVar8.B(cVar8.f16379p, c.this.f16366c.getCurrentItem() + 1, 1, 31, this.f16389a, this.f16390b);
            } else {
                c cVar9 = c.this;
                cVar9.B(cVar9.f16379p, i5, 1, 31, this.f16389a, this.f16390b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: WheelTime.java */
    /* renamed from: com.bigkoo.pickerview.view.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static /* synthetic */ class C0161c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16392a;

        static {
            int[] iArr = new int[TimePickerView.Type.values().length];
            f16392a = iArr;
            try {
                iArr[TimePickerView.Type.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16392a[TimePickerView.Type.YEAR_MONTH_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16392a[TimePickerView.Type.HOURS_MINS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16392a[TimePickerView.Type.MONTH_DAY_HOUR_MIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16392a[TimePickerView.Type.YEAR_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16392a[TimePickerView.Type.YEAR_MONTH_DAY_HOUR_MIN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public c(View view) {
        this.f16373j = 1900;
        this.f16374k = 2100;
        this.f16375l = 1;
        this.f16376m = 12;
        this.f16377n = 1;
        this.f16378o = 31;
        this.f16380q = 18;
        this.f16384u = 1.6f;
        this.f16364a = view;
        this.f16372i = TimePickerView.Type.ALL;
        H(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i4, int i5, int i6, int i7, List<String> list, List<String> list2) {
        int currentItem = this.f16367d.getCurrentItem();
        if (list.contains(String.valueOf(i5))) {
            if (i7 > 31) {
                i7 = 31;
            }
            this.f16367d.setAdapter(new h.b(i6, i7));
        } else if (list2.contains(String.valueOf(i5))) {
            if (i7 > 30) {
                i7 = 30;
            }
            this.f16367d.setAdapter(new h.b(i6, i7));
        } else if ((i4 % 4 == 0 && i4 % 100 != 0) || i4 % 400 == 0) {
            if (i7 > 29) {
                i7 = 29;
            }
            this.f16367d.setAdapter(new h.b(i6, i7));
        } else {
            if (i7 > 28) {
                i7 = 28;
            }
            this.f16367d.setAdapter(new h.b(i6, i7));
        }
        if (currentItem > this.f16367d.getAdapter().a() - 1) {
            this.f16367d.setCurrentItem(this.f16367d.getAdapter().a() - 1);
        }
    }

    private void D() {
        this.f16367d.setTextColorCenter(this.f16382s);
        this.f16366c.setTextColorCenter(this.f16382s);
        this.f16365b.setTextColorCenter(this.f16382s);
        this.f16368e.setTextColorCenter(this.f16382s);
        this.f16369f.setTextColorCenter(this.f16382s);
        this.f16370g.setTextColorCenter(this.f16382s);
    }

    private void F() {
        this.f16367d.setTextColorOut(this.f16381r);
        this.f16366c.setTextColorOut(this.f16381r);
        this.f16365b.setTextColorOut(this.f16381r);
        this.f16368e.setTextColorOut(this.f16381r);
        this.f16369f.setTextColorOut(this.f16381r);
        this.f16370g.setTextColorOut(this.f16381r);
    }

    private void o() {
        this.f16367d.setTextSize(this.f16380q);
        this.f16366c.setTextSize(this.f16380q);
        this.f16365b.setTextSize(this.f16380q);
        this.f16368e.setTextSize(this.f16380q);
        this.f16369f.setTextSize(this.f16380q);
        this.f16370g.setTextSize(this.f16380q);
    }

    private void q() {
        this.f16367d.setDividerColor(this.f16383t);
        this.f16366c.setDividerColor(this.f16383t);
        this.f16365b.setDividerColor(this.f16383t);
        this.f16368e.setDividerColor(this.f16383t);
        this.f16369f.setDividerColor(this.f16383t);
        this.f16370g.setDividerColor(this.f16383t);
    }

    private void s() {
        this.f16367d.setDividerType(this.f16385v);
        this.f16366c.setDividerType(this.f16385v);
        this.f16365b.setDividerType(this.f16385v);
        this.f16368e.setDividerType(this.f16385v);
        this.f16369f.setDividerType(this.f16385v);
        this.f16370g.setDividerType(this.f16385v);
    }

    private void w() {
        this.f16367d.setLineSpacingMultiplier(this.f16384u);
        this.f16366c.setLineSpacingMultiplier(this.f16384u);
        this.f16365b.setLineSpacingMultiplier(this.f16384u);
        this.f16368e.setLineSpacingMultiplier(this.f16384u);
        this.f16369f.setLineSpacingMultiplier(this.f16384u);
        this.f16370g.setLineSpacingMultiplier(this.f16384u);
    }

    public void A(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i4 = calendar2.get(1);
            int i5 = calendar2.get(2) + 1;
            int i6 = calendar2.get(5);
            int i7 = this.f16373j;
            if (i4 > i7) {
                this.f16374k = i4;
                this.f16376m = i5;
                this.f16378o = i6;
            } else if (i4 == i7) {
                int i8 = this.f16375l;
                if (i5 > i8) {
                    this.f16374k = i4;
                    this.f16376m = i5;
                    this.f16378o = i6;
                } else if (i5 != i8 || i5 <= this.f16377n) {
                } else {
                    this.f16374k = i4;
                    this.f16376m = i5;
                    this.f16378o = i6;
                }
            }
        } else if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.f16373j = calendar.get(1);
            this.f16374k = calendar2.get(1);
            this.f16375l = calendar.get(2) + 1;
            this.f16376m = calendar2.get(2) + 1;
            this.f16377n = calendar.get(5);
            this.f16378o = calendar2.get(5);
        } else {
            int i9 = calendar.get(1);
            int i10 = calendar.get(2) + 1;
            int i11 = calendar.get(5);
            int i12 = this.f16374k;
            if (i9 < i12) {
                this.f16375l = i10;
                this.f16377n = i11;
                this.f16373j = i9;
            } else if (i9 == i12) {
                int i13 = this.f16376m;
                if (i10 < i13) {
                    this.f16375l = i10;
                    this.f16377n = i11;
                    this.f16373j = i9;
                } else if (i10 != i13 || i11 >= this.f16378o) {
                } else {
                    this.f16375l = i10;
                    this.f16377n = i11;
                    this.f16373j = i9;
                }
            }
        }
    }

    public void C(int i4) {
        this.f16373j = i4;
    }

    public void E(int i4) {
        this.f16382s = i4;
        D();
    }

    public void G(int i4) {
        this.f16381r = i4;
        F();
    }

    public void H(View view) {
        this.f16364a = view;
    }

    public int k() {
        return this.f16374k;
    }

    public int l() {
        return this.f16373j;
    }

    public String m() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f16379p == this.f16373j) {
            int currentItem = this.f16366c.getCurrentItem() + this.f16375l;
            PrintStream printStream = System.out;
            printStream.println("i:" + currentItem);
            int currentItem2 = this.f16366c.getCurrentItem();
            int i4 = this.f16375l;
            if (currentItem2 + i4 == i4) {
                stringBuffer.append(this.f16365b.getCurrentItem() + this.f16373j);
                stringBuffer.append("-");
                stringBuffer.append(this.f16366c.getCurrentItem() + this.f16375l);
                stringBuffer.append("-");
                stringBuffer.append(this.f16367d.getCurrentItem() + this.f16377n);
                stringBuffer.append(" ");
                stringBuffer.append(this.f16368e.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f16369f.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f16370g.getCurrentItem());
            } else {
                stringBuffer.append(this.f16365b.getCurrentItem() + this.f16373j);
                stringBuffer.append("-");
                stringBuffer.append(this.f16366c.getCurrentItem() + this.f16375l);
                stringBuffer.append("-");
                stringBuffer.append(this.f16367d.getCurrentItem() + 1);
                stringBuffer.append(" ");
                stringBuffer.append(this.f16368e.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f16369f.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f16370g.getCurrentItem());
            }
        } else {
            stringBuffer.append(this.f16365b.getCurrentItem() + this.f16373j);
            stringBuffer.append("-");
            stringBuffer.append(this.f16366c.getCurrentItem() + 1);
            stringBuffer.append("-");
            stringBuffer.append(this.f16367d.getCurrentItem() + 1);
            stringBuffer.append(" ");
            stringBuffer.append(this.f16368e.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.f16369f.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.f16370g.getCurrentItem());
        }
        return stringBuffer.toString();
    }

    public View n() {
        return this.f16364a;
    }

    public void p(boolean z3) {
        this.f16365b.setCyclic(z3);
        this.f16366c.setCyclic(z3);
        this.f16367d.setCyclic(z3);
        this.f16368e.setCyclic(z3);
        this.f16369f.setCyclic(z3);
        this.f16370g.setCyclic(z3);
    }

    public void r(int i4) {
        this.f16383t = i4;
        q();
    }

    public void t(WheelView.DividerType dividerType) {
        this.f16385v = dividerType;
        s();
    }

    public void u(int i4) {
        this.f16374k = i4;
    }

    public void v(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str != null) {
            this.f16365b.setLabel(str);
        } else {
            this.f16365b.setLabel(this.f16364a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f16366c.setLabel(str2);
        } else {
            this.f16366c.setLabel(this.f16364a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f16367d.setLabel(str3);
        } else {
            this.f16367d.setLabel(this.f16364a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f16368e.setLabel(str4);
        } else {
            this.f16368e.setLabel(this.f16364a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f16369f.setLabel(str5);
        } else {
            this.f16369f.setLabel(this.f16364a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f16370g.setLabel(str6);
        } else {
            this.f16370g.setLabel(this.f16364a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public void x(float f4) {
        this.f16384u = f4;
        w();
    }

    public void y(int i4, int i5, int i6) {
        z(i4, i5, i6, 0, 0, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x034d, code lost:
        if (r1 != 6) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(int r17, int r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 925
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigkoo.pickerview.view.c.z(int, int, int, int, int, int):void");
    }

    public c(View view, TimePickerView.Type type, int i4, int i5) {
        this.f16373j = 1900;
        this.f16374k = 2100;
        this.f16375l = 1;
        this.f16376m = 12;
        this.f16377n = 1;
        this.f16378o = 31;
        this.f16384u = 1.6f;
        this.f16364a = view;
        this.f16372i = type;
        this.f16371h = i4;
        this.f16380q = i5;
        H(view);
    }
}
