package com.bxkj.base.util;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.bxkj.base.util.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PointLengthFilter implements InputFilter {

    /* renamed from: a */
    private int f14940a;

    public PointLengthFilter() {
        this.f14940a = 2;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int length;
        if ("".equals(charSequence.toString())) {
            return null;
        }
        String[] split = spanned.toString().split("\\.");
        if (split.length <= 1 || (length = (split[1].length() + 1) - this.f14940a) <= 0) {
            return null;
        }
        return charSequence.subSequence(i, i2 - length);
    }

    public PointLengthFilter(int i) {
        this.f14940a = i;
    }
}
