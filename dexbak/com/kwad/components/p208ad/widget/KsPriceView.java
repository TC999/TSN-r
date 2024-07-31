package com.kwad.components.p208ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.InterfaceC9373d;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.kwad.components.ad.widget.KsPriceView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsPriceView extends TextView implements InterfaceC9373d {

    /* renamed from: If */
    private static String f28015If = "¥%s 到手约 ¥%s";

    /* renamed from: Ig */
    private static String f28016Ig = "¥%s  ¥%s";

    /* renamed from: Ih */
    private static String f28017Ih = "¥%s";

    /* renamed from: Ie */
    private C8520a f28018Ie;

    /* renamed from: Ii */
    private String f28019Ii;

    /* renamed from: Ij */
    private String f28020Ij;

    /* renamed from: Ik */
    private boolean f28021Ik;

    /* renamed from: com.kwad.components.ad.widget.KsPriceView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8520a {

        /* renamed from: Il */
        private int f28022Il;

        /* renamed from: Im */
        private int f28023Im;

        /* renamed from: In */
        private int f28024In;

        /* renamed from: Io */
        private int f28025Io;

        /* renamed from: Ip */
        private int f28026Ip;

        /* renamed from: Iq */
        private int f28027Iq;

        /* renamed from: ae */
        public final C8520a m30438ae(int i) {
            this.f28023Im = i;
            return this;
        }

        /* renamed from: af */
        public final C8520a m30437af(int i) {
            this.f28026Ip = i;
            return this;
        }

        /* renamed from: ag */
        public final C8520a m30436ag(int i) {
            this.f28027Iq = i;
            return this;
        }

        /* renamed from: mk */
        public final int m30430mk() {
            return this.f28024In;
        }

        /* renamed from: ml */
        public final int m30429ml() {
            return this.f28026Ip;
        }

        /* renamed from: mm */
        public final int m30428mm() {
            return this.f28025Io;
        }

        /* renamed from: mn */
        public final int m30427mn() {
            return this.f28027Iq;
        }

        /* renamed from: mo */
        public final int m30426mo() {
            return this.f28022Il;
        }

        /* renamed from: mp */
        public final int m30425mp() {
            return this.f28023Im;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.f28018Ie = new C8520a();
        m30443P(context);
    }

    /* renamed from: P */
    private void m30443P(Context context) {
        setMaxLines(1);
        C8520a c8520a = this.f28018Ie;
        Resources resources = context.getResources();
        int i = C9659R.C9660color.ksad_reward_main_color;
        c8520a.f28024In = resources.getColor(i);
        C8520a c8520a2 = this.f28018Ie;
        Resources resources2 = context.getResources();
        int i2 = C9659R.dimen.ksad_reward_order_price_size;
        c8520a2.f28025Io = resources2.getDimensionPixelSize(i2);
        this.f28018Ie.f28026Ip = context.getResources().getColor(C9659R.C9660color.ksad_reward_original_price);
        this.f28018Ie.f28027Iq = context.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_order_original_price_size);
        this.f28018Ie.f28022Il = context.getResources().getColor(i);
        this.f28018Ie.f28023Im = context.getResources().getDimensionPixelSize(i2);
    }

    @Nullable
    /* renamed from: a */
    private static SpannableString m30442a(String str, @Nullable String str2, boolean z, C8520a c8520a) {
        String format;
        if (str2 == null) {
            format = String.format(f28017Ih, str);
        } else {
            format = String.format(z ? f28016Ig : f28015If, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(c8520a.m30426mo()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(c8520a.m30425mp()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(c8520a.m30430mk()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(c8520a.m30428mm()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(c8520a.m30429ml()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(c8520a.m30427mn()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    /* renamed from: d */
    public final void m30441d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.f28019Ii = str;
        this.f28020Ij = str2;
        this.f28021Ik = z;
        SpannableString spannableString = null;
        if (TextUtils.isEmpty(str2)) {
            this.f28020Ij = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.f28018Ie.m30430mk());
        try {
            spannableString = m30442a(str, this.f28020Ij, z, this.f28018Ie);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    @NonNull
    public C8520a getConfig() {
        return this.f28018Ie;
    }

    /* renamed from: h */
    public final void m30440h(String str, String str2) {
        m30441d(str, str2, false);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28018Ie = new C8520a();
        m30443P(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28018Ie = new C8520a();
        m30443P(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f28018Ie = new C8520a();
        m30443P(context);
    }

    @Override // com.kwad.components.core.widget.InterfaceC9373d
    /* renamed from: a */
    public final void mo28874a(C9374e c9374e) {
        this.f28018Ie.f28024In = c9374e.m28873tt();
        m30441d(this.f28019Ii, this.f28020Ij, this.f28021Ik);
    }
}
