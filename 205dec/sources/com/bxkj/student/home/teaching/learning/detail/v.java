package com.bxkj.student.home.teaching.learning.detail;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Code.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private final char[] f20830a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: b  reason: collision with root package name */
    private int[] f20831b;

    /* renamed from: c  reason: collision with root package name */
    private SpannableString f20832c;

    /* renamed from: d  reason: collision with root package name */
    private Context f20833d;

    public v(Context mContext) {
        this.f20833d = mContext;
    }

    public SpannableString a() {
        this.f20831b = new int[]{ContextCompat.getColor(this.f20833d, 2131034172), ContextCompat.getColor(this.f20833d, 2131034175), ContextCompat.getColor(this.f20833d, 2131034177), ContextCompat.getColor(this.f20833d, 2131034489), ContextCompat.getColor(this.f20833d, 2131034189), ContextCompat.getColor(this.f20833d, 2131034462), ContextCompat.getColor(this.f20833d, 2131034471), ContextCompat.getColor(this.f20833d, 2131034190), ContextCompat.getColor(this.f20833d, 2131034199), ContextCompat.getColor(this.f20833d, 2131034176)};
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 4; i4++) {
            sb.append(this.f20830a[new Random().nextInt(this.f20830a.length)]);
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        this.f20832c = spannableString;
        spannableString.setSpan(new ForegroundColorSpan(this.f20831b[new Random().nextInt(this.f20831b.length)]), 0, 1, 33);
        this.f20832c.setSpan(new ForegroundColorSpan(this.f20831b[new Random().nextInt(this.f20831b.length)]), 1, 2, 33);
        this.f20832c.setSpan(new ForegroundColorSpan(this.f20831b[new Random().nextInt(this.f20831b.length)]), 2, 3, 33);
        this.f20832c.setSpan(new ForegroundColorSpan(this.f20831b[new Random().nextInt(this.f20831b.length)]), 3, 4, 33);
        return this.f20832c;
    }

    public SpannableString b() {
        return this.f20832c;
    }
}
