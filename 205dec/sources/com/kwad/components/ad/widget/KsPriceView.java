package com.kwad.components.ad.widget;

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
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.e.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsPriceView extends TextView implements d {
    private static String If = "\u00a5%s \u5230\u624b\u7ea6 \u00a5%s";
    private static String Ig = "\u00a5%s  \u00a5%s";
    private static String Ih = "\u00a5%s";
    private a Ie;
    private String Ii;
    private String Ij;
    private boolean Ik;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private int Il;
        private int Im;
        private int In;
        private int Io;
        private int Ip;
        private int Iq;

        public final a ae(int i4) {
            this.Im = i4;
            return this;
        }

        public final a af(int i4) {
            this.Ip = i4;
            return this;
        }

        public final a ag(int i4) {
            this.Iq = i4;
            return this;
        }

        public final int mk() {
            return this.In;
        }

        public final int ml() {
            return this.Ip;
        }

        public final int mm() {
            return this.Io;
        }

        public final int mn() {
            return this.Iq;
        }

        public final int mo() {
            return this.Il;
        }

        public final int mp() {
            return this.Im;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.Ie = new a();
        P(context);
    }

    private void P(Context context) {
        setMaxLines(1);
        a aVar = this.Ie;
        Resources resources = context.getResources();
        int i4 = R.color.ksad_reward_main_color;
        aVar.In = resources.getColor(i4);
        a aVar2 = this.Ie;
        Resources resources2 = context.getResources();
        int i5 = R.dimen.ksad_reward_order_price_size;
        aVar2.Io = resources2.getDimensionPixelSize(i5);
        this.Ie.Ip = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.Ie.Iq = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.Ie.Il = context.getResources().getColor(i4);
        this.Ie.Im = context.getResources().getDimensionPixelSize(i5);
    }

    @Nullable
    private static SpannableString a(String str, @Nullable String str2, boolean z3, a aVar) {
        String format;
        if (str2 == null) {
            format = String.format(Ih, str);
        } else {
            format = String.format(z3 ? Ig : If, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("\u00a5")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.mo()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mp()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.mk()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.mm()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.ml()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mn()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    public final void d(String str, String str2, boolean z3) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.Ii = str;
        this.Ij = str2;
        this.Ik = z3;
        SpannableString spannableString = null;
        if (TextUtils.isEmpty(str2)) {
            this.Ij = null;
        }
        if (str != null && str.startsWith("\u00a5")) {
            str = str.replaceFirst("\u00a5", "");
        }
        setTextColor(this.Ie.mk());
        try {
            spannableString = a(str, this.Ij, z3, this.Ie);
        } catch (Exception e4) {
            c.printStackTraceOnly(e4);
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    @NonNull
    public a getConfig() {
        return this.Ie;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ie = new a();
        P(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Ie = new a();
        P(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.Ie = new a();
        P(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.Ie.In = eVar.tt();
        d(this.Ii, this.Ij, this.Ik);
    }
}
