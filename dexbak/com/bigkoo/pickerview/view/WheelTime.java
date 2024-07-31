package com.bigkoo.pickerview.view;

import android.view.View;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.bigkoo.pickerview.C3501R;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.lib.WheelView;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import p596h.NumericWheelAdapter;
import p600i.OnItemSelectedListener;

/* renamed from: com.bigkoo.pickerview.view.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WheelTime {

    /* renamed from: A */
    private static final int f13162A = 12;

    /* renamed from: B */
    private static final int f13163B = 1;

    /* renamed from: C */
    private static final int f13164C = 31;

    /* renamed from: w */
    public static DateFormat f13165w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: x */
    private static final int f13166x = 1900;

    /* renamed from: y */
    private static final int f13167y = 2100;

    /* renamed from: z */
    private static final int f13168z = 1;

    /* renamed from: a */
    private View f13169a;

    /* renamed from: b */
    private WheelView f13170b;

    /* renamed from: c */
    private WheelView f13171c;

    /* renamed from: d */
    private WheelView f13172d;

    /* renamed from: e */
    private WheelView f13173e;

    /* renamed from: f */
    private WheelView f13174f;

    /* renamed from: g */
    private WheelView f13175g;

    /* renamed from: h */
    private int f13176h;

    /* renamed from: i */
    private TimePickerView.Type f13177i;

    /* renamed from: j */
    private int f13178j;

    /* renamed from: k */
    private int f13179k;

    /* renamed from: l */
    private int f13180l;

    /* renamed from: m */
    private int f13181m;

    /* renamed from: n */
    private int f13182n;

    /* renamed from: o */
    private int f13183o;

    /* renamed from: p */
    private int f13184p;

    /* renamed from: q */
    private int f13185q;

    /* renamed from: r */
    int f13186r;

    /* renamed from: s */
    int f13187s;

    /* renamed from: t */
    int f13188t;

    /* renamed from: u */
    float f13189u;

    /* renamed from: v */
    private WheelView.DividerType f13190v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WheelTime.java */
    /* renamed from: com.bigkoo.pickerview.view.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3522a implements OnItemSelectedListener {

        /* renamed from: a */
        final /* synthetic */ List f13191a;

        /* renamed from: b */
        final /* synthetic */ List f13192b;

        C3522a(List list, List list2) {
            this.f13191a = list;
            this.f13192b = list2;
        }

        @Override // p600i.OnItemSelectedListener
        /* renamed from: a */
        public void mo12719a(int i) {
            int i2 = i + WheelTime.this.f13178j;
            WheelTime.this.f13184p = i2;
            int currentItem = WheelTime.this.f13171c.getCurrentItem();
            if (WheelTime.this.f13178j == WheelTime.this.f13179k) {
                WheelTime.this.f13171c.setAdapter(new NumericWheelAdapter(WheelTime.this.f13180l, WheelTime.this.f13181m));
                if (currentItem > WheelTime.this.f13171c.getAdapter().mo12730a() - 1) {
                    currentItem = WheelTime.this.f13171c.getAdapter().mo12730a() - 1;
                    WheelTime.this.f13171c.setCurrentItem(currentItem);
                }
                int i3 = currentItem + WheelTime.this.f13180l;
                if (WheelTime.this.f13180l == WheelTime.this.f13181m) {
                    WheelTime wheelTime = WheelTime.this;
                    wheelTime.m45826B(i2, i3, wheelTime.f13182n, WheelTime.this.f13183o, this.f13191a, this.f13192b);
                } else if (i3 == WheelTime.this.f13180l) {
                    WheelTime wheelTime2 = WheelTime.this;
                    wheelTime2.m45826B(i2, i3, wheelTime2.f13182n, 31, this.f13191a, this.f13192b);
                } else {
                    WheelTime.this.m45826B(i2, i3, 1, 31, this.f13191a, this.f13192b);
                }
            } else if (i2 == WheelTime.this.f13178j) {
                WheelTime.this.f13171c.setAdapter(new NumericWheelAdapter(WheelTime.this.f13180l, 12));
                if (currentItem > WheelTime.this.f13171c.getAdapter().mo12730a() - 1) {
                    currentItem = WheelTime.this.f13171c.getAdapter().mo12730a() - 1;
                    WheelTime.this.f13171c.setCurrentItem(currentItem);
                }
                int i4 = currentItem + WheelTime.this.f13180l;
                if (i4 == WheelTime.this.f13180l) {
                    WheelTime wheelTime3 = WheelTime.this;
                    wheelTime3.m45826B(i2, i4, wheelTime3.f13182n, 31, this.f13191a, this.f13192b);
                    return;
                }
                WheelTime.this.m45826B(i2, i4, 1, 31, this.f13191a, this.f13192b);
            } else if (i2 == WheelTime.this.f13179k) {
                WheelTime.this.f13171c.setAdapter(new NumericWheelAdapter(1, WheelTime.this.f13181m));
                if (currentItem > WheelTime.this.f13171c.getAdapter().mo12730a() - 1) {
                    currentItem = WheelTime.this.f13171c.getAdapter().mo12730a() - 1;
                    WheelTime.this.f13171c.setCurrentItem(currentItem);
                }
                int i5 = 1 + currentItem;
                if (i5 == WheelTime.this.f13181m) {
                    WheelTime wheelTime4 = WheelTime.this;
                    wheelTime4.m45826B(i2, i5, 1, wheelTime4.f13183o, this.f13191a, this.f13192b);
                    return;
                }
                WheelTime.this.m45826B(i2, i5, 1, 31, this.f13191a, this.f13192b);
            } else {
                WheelTime.this.f13171c.setAdapter(new NumericWheelAdapter(1, 12));
                WheelTime wheelTime5 = WheelTime.this;
                wheelTime5.m45826B(i2, 1 + wheelTime5.f13171c.getCurrentItem(), 1, 31, this.f13191a, this.f13192b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WheelTime.java */
    /* renamed from: com.bigkoo.pickerview.view.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3523b implements OnItemSelectedListener {

        /* renamed from: a */
        final /* synthetic */ List f13194a;

        /* renamed from: b */
        final /* synthetic */ List f13195b;

        C3523b(List list, List list2) {
            this.f13194a = list;
            this.f13195b = list2;
        }

        @Override // p600i.OnItemSelectedListener
        /* renamed from: a */
        public void mo12719a(int i) {
            int i2 = i + 1;
            if (WheelTime.this.f13178j == WheelTime.this.f13179k) {
                int i3 = (i2 + WheelTime.this.f13180l) - 1;
                if (WheelTime.this.f13180l == WheelTime.this.f13181m) {
                    WheelTime wheelTime = WheelTime.this;
                    wheelTime.m45826B(wheelTime.f13184p, i3, WheelTime.this.f13182n, WheelTime.this.f13183o, this.f13194a, this.f13195b);
                } else if (WheelTime.this.f13180l == i3) {
                    WheelTime wheelTime2 = WheelTime.this;
                    wheelTime2.m45826B(wheelTime2.f13184p, i3, WheelTime.this.f13182n, 31, this.f13194a, this.f13195b);
                } else if (WheelTime.this.f13181m == i3) {
                    WheelTime wheelTime3 = WheelTime.this;
                    wheelTime3.m45826B(wheelTime3.f13184p, i3, 1, WheelTime.this.f13183o, this.f13194a, this.f13195b);
                } else {
                    WheelTime wheelTime4 = WheelTime.this;
                    wheelTime4.m45826B(wheelTime4.f13184p, i3, 1, 31, this.f13194a, this.f13195b);
                }
            } else if (WheelTime.this.f13184p == WheelTime.this.f13178j) {
                int i4 = (i2 + WheelTime.this.f13180l) - 1;
                if (i4 == WheelTime.this.f13180l) {
                    WheelTime wheelTime5 = WheelTime.this;
                    wheelTime5.m45826B(wheelTime5.f13184p, i4, WheelTime.this.f13182n, 31, this.f13194a, this.f13195b);
                    return;
                }
                WheelTime wheelTime6 = WheelTime.this;
                wheelTime6.m45826B(wheelTime6.f13184p, i4, 1, 31, this.f13194a, this.f13195b);
            } else if (WheelTime.this.f13184p == WheelTime.this.f13179k) {
                if (i2 == WheelTime.this.f13181m) {
                    WheelTime wheelTime7 = WheelTime.this;
                    wheelTime7.m45826B(wheelTime7.f13184p, WheelTime.this.f13171c.getCurrentItem() + 1, 1, WheelTime.this.f13183o, this.f13194a, this.f13195b);
                    return;
                }
                WheelTime wheelTime8 = WheelTime.this;
                wheelTime8.m45826B(wheelTime8.f13184p, WheelTime.this.f13171c.getCurrentItem() + 1, 1, 31, this.f13194a, this.f13195b);
            } else {
                WheelTime wheelTime9 = WheelTime.this;
                wheelTime9.m45826B(wheelTime9.f13184p, i2, 1, 31, this.f13194a, this.f13195b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WheelTime.java */
    /* renamed from: com.bigkoo.pickerview.view.c$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C3524c {

        /* renamed from: a */
        static final /* synthetic */ int[] f13197a;

        static {
            int[] iArr = new int[TimePickerView.Type.values().length];
            f13197a = iArr;
            try {
                iArr[TimePickerView.Type.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13197a[TimePickerView.Type.YEAR_MONTH_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13197a[TimePickerView.Type.HOURS_MINS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13197a[TimePickerView.Type.MONTH_DAY_HOUR_MIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13197a[TimePickerView.Type.YEAR_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13197a[TimePickerView.Type.YEAR_MONTH_DAY_HOUR_MIN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public WheelTime(View view) {
        this.f13178j = 1900;
        this.f13179k = 2100;
        this.f13180l = 1;
        this.f13181m = 12;
        this.f13182n = 1;
        this.f13183o = 31;
        this.f13185q = 18;
        this.f13189u = 1.6f;
        this.f13169a = view;
        this.f13177i = TimePickerView.Type.ALL;
        m45820H(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m45826B(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.f13172d.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.f13172d.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.f13172d.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % FontStyle.WEIGHT_NORMAL == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.f13172d.setAdapter(new NumericWheelAdapter(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.f13172d.setAdapter(new NumericWheelAdapter(i3, i4));
        }
        if (currentItem > this.f13172d.getAdapter().mo12730a() - 1) {
            this.f13172d.setCurrentItem(this.f13172d.getAdapter().mo12730a() - 1);
        }
    }

    /* renamed from: D */
    private void m45824D() {
        this.f13172d.setTextColorCenter(this.f13187s);
        this.f13171c.setTextColorCenter(this.f13187s);
        this.f13170b.setTextColorCenter(this.f13187s);
        this.f13173e.setTextColorCenter(this.f13187s);
        this.f13174f.setTextColorCenter(this.f13187s);
        this.f13175g.setTextColorCenter(this.f13187s);
    }

    /* renamed from: F */
    private void m45822F() {
        this.f13172d.setTextColorOut(this.f13186r);
        this.f13171c.setTextColorOut(this.f13186r);
        this.f13170b.setTextColorOut(this.f13186r);
        this.f13173e.setTextColorOut(this.f13186r);
        this.f13174f.setTextColorOut(this.f13186r);
        this.f13175g.setTextColorOut(this.f13186r);
    }

    /* renamed from: o */
    private void m45805o() {
        this.f13172d.setTextSize(this.f13185q);
        this.f13171c.setTextSize(this.f13185q);
        this.f13170b.setTextSize(this.f13185q);
        this.f13173e.setTextSize(this.f13185q);
        this.f13174f.setTextSize(this.f13185q);
        this.f13175g.setTextSize(this.f13185q);
    }

    /* renamed from: q */
    private void m45803q() {
        this.f13172d.setDividerColor(this.f13188t);
        this.f13171c.setDividerColor(this.f13188t);
        this.f13170b.setDividerColor(this.f13188t);
        this.f13173e.setDividerColor(this.f13188t);
        this.f13174f.setDividerColor(this.f13188t);
        this.f13175g.setDividerColor(this.f13188t);
    }

    /* renamed from: s */
    private void m45801s() {
        this.f13172d.setDividerType(this.f13190v);
        this.f13171c.setDividerType(this.f13190v);
        this.f13170b.setDividerType(this.f13190v);
        this.f13173e.setDividerType(this.f13190v);
        this.f13174f.setDividerType(this.f13190v);
        this.f13175g.setDividerType(this.f13190v);
    }

    /* renamed from: w */
    private void m45797w() {
        this.f13172d.setLineSpacingMultiplier(this.f13189u);
        this.f13171c.setLineSpacingMultiplier(this.f13189u);
        this.f13170b.setLineSpacingMultiplier(this.f13189u);
        this.f13173e.setLineSpacingMultiplier(this.f13189u);
        this.f13174f.setLineSpacingMultiplier(this.f13189u);
        this.f13175g.setLineSpacingMultiplier(this.f13189u);
    }

    /* renamed from: A */
    public void m45827A(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.f13178j;
            if (i > i4) {
                this.f13179k = i;
                this.f13181m = i2;
                this.f13183o = i3;
            } else if (i == i4) {
                int i5 = this.f13180l;
                if (i2 > i5) {
                    this.f13179k = i;
                    this.f13181m = i2;
                    this.f13183o = i3;
                } else if (i2 != i5 || i2 <= this.f13182n) {
                } else {
                    this.f13179k = i;
                    this.f13181m = i2;
                    this.f13183o = i3;
                }
            }
        } else if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.f13178j = calendar.get(1);
            this.f13179k = calendar2.get(1);
            this.f13180l = calendar.get(2) + 1;
            this.f13181m = calendar2.get(2) + 1;
            this.f13182n = calendar.get(5);
            this.f13183o = calendar2.get(5);
        } else {
            int i6 = calendar.get(1);
            int i7 = calendar.get(2) + 1;
            int i8 = calendar.get(5);
            int i9 = this.f13179k;
            if (i6 < i9) {
                this.f13180l = i7;
                this.f13182n = i8;
                this.f13178j = i6;
            } else if (i6 == i9) {
                int i10 = this.f13181m;
                if (i7 < i10) {
                    this.f13180l = i7;
                    this.f13182n = i8;
                    this.f13178j = i6;
                } else if (i7 != i10 || i8 >= this.f13183o) {
                } else {
                    this.f13180l = i7;
                    this.f13182n = i8;
                    this.f13178j = i6;
                }
            }
        }
    }

    /* renamed from: C */
    public void m45825C(int i) {
        this.f13178j = i;
    }

    /* renamed from: E */
    public void m45823E(int i) {
        this.f13187s = i;
        m45824D();
    }

    /* renamed from: G */
    public void m45821G(int i) {
        this.f13186r = i;
        m45822F();
    }

    /* renamed from: H */
    public void m45820H(View view) {
        this.f13169a = view;
    }

    /* renamed from: k */
    public int m45809k() {
        return this.f13179k;
    }

    /* renamed from: l */
    public int m45808l() {
        return this.f13178j;
    }

    /* renamed from: m */
    public String m45807m() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f13184p == this.f13178j) {
            int currentItem = this.f13171c.getCurrentItem() + this.f13180l;
            PrintStream printStream = System.out;
            printStream.println("i:" + currentItem);
            int currentItem2 = this.f13171c.getCurrentItem();
            int i = this.f13180l;
            if (currentItem2 + i == i) {
                stringBuffer.append(this.f13170b.getCurrentItem() + this.f13178j);
                stringBuffer.append("-");
                stringBuffer.append(this.f13171c.getCurrentItem() + this.f13180l);
                stringBuffer.append("-");
                stringBuffer.append(this.f13172d.getCurrentItem() + this.f13182n);
                stringBuffer.append(" ");
                stringBuffer.append(this.f13173e.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f13174f.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f13175g.getCurrentItem());
            } else {
                stringBuffer.append(this.f13170b.getCurrentItem() + this.f13178j);
                stringBuffer.append("-");
                stringBuffer.append(this.f13171c.getCurrentItem() + this.f13180l);
                stringBuffer.append("-");
                stringBuffer.append(this.f13172d.getCurrentItem() + 1);
                stringBuffer.append(" ");
                stringBuffer.append(this.f13173e.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f13174f.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f13175g.getCurrentItem());
            }
        } else {
            stringBuffer.append(this.f13170b.getCurrentItem() + this.f13178j);
            stringBuffer.append("-");
            stringBuffer.append(this.f13171c.getCurrentItem() + 1);
            stringBuffer.append("-");
            stringBuffer.append(this.f13172d.getCurrentItem() + 1);
            stringBuffer.append(" ");
            stringBuffer.append(this.f13173e.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.f13174f.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.f13175g.getCurrentItem());
        }
        return stringBuffer.toString();
    }

    /* renamed from: n */
    public View m45806n() {
        return this.f13169a;
    }

    /* renamed from: p */
    public void m45804p(boolean z) {
        this.f13170b.setCyclic(z);
        this.f13171c.setCyclic(z);
        this.f13172d.setCyclic(z);
        this.f13173e.setCyclic(z);
        this.f13174f.setCyclic(z);
        this.f13175g.setCyclic(z);
    }

    /* renamed from: r */
    public void m45802r(int i) {
        this.f13188t = i;
        m45803q();
    }

    /* renamed from: t */
    public void m45800t(WheelView.DividerType dividerType) {
        this.f13190v = dividerType;
        m45801s();
    }

    /* renamed from: u */
    public void m45799u(int i) {
        this.f13179k = i;
    }

    /* renamed from: v */
    public void m45798v(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str != null) {
            this.f13170b.setLabel(str);
        } else {
            this.f13170b.setLabel(this.f13169a.getContext().getString(C3501R.C3506string.pickerview_year));
        }
        if (str2 != null) {
            this.f13171c.setLabel(str2);
        } else {
            this.f13171c.setLabel(this.f13169a.getContext().getString(C3501R.C3506string.pickerview_month));
        }
        if (str3 != null) {
            this.f13172d.setLabel(str3);
        } else {
            this.f13172d.setLabel(this.f13169a.getContext().getString(C3501R.C3506string.pickerview_day));
        }
        if (str4 != null) {
            this.f13173e.setLabel(str4);
        } else {
            this.f13173e.setLabel(this.f13169a.getContext().getString(C3501R.C3506string.pickerview_hours));
        }
        if (str5 != null) {
            this.f13174f.setLabel(str5);
        } else {
            this.f13174f.setLabel(this.f13169a.getContext().getString(C3501R.C3506string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f13175g.setLabel(str6);
        } else {
            this.f13175g.setLabel(this.f13169a.getContext().getString(C3501R.C3506string.pickerview_seconds));
        }
    }

    /* renamed from: x */
    public void m45796x(float f) {
        this.f13189u = f;
        m45797w();
    }

    /* renamed from: y */
    public void m45795y(int i, int i2, int i3) {
        m45794z(i, i2, i3, 0, 0, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x034d, code lost:
        if (r1 != 6) goto L26;
     */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m45794z(int r17, int r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 925
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigkoo.pickerview.view.WheelTime.m45794z(int, int, int, int, int, int):void");
    }

    public WheelTime(View view, TimePickerView.Type type, int i, int i2) {
        this.f13178j = 1900;
        this.f13179k = 2100;
        this.f13180l = 1;
        this.f13181m = 12;
        this.f13182n = 1;
        this.f13183o = 31;
        this.f13189u = 1.6f;
        this.f13169a = view;
        this.f13177i = type;
        this.f13176h = i;
        this.f13185q = i2;
        m45820H(view);
    }
}
