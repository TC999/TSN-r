package com.bxkj.base.util;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PointLengthFilter.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class t implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private int f18424a;

    public t() {
        this.f18424a = 2;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i4, int i5, Spanned spanned, int i6, int i7) {
        int length;
        if ("".equals(charSequence.toString())) {
            return null;
        }
        String[] split = spanned.toString().split("\\.");
        if (split.length <= 1 || (length = (split[1].length() + 1) - this.f18424a) <= 0) {
            return null;
        }
        return charSequence.subSequence(i4, i5 - length);
    }

    public t(int i4) {
        this.f18424a = i4;
    }
}
