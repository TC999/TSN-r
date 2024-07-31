package com.bxkj.student.home.teaching.learning.detail;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.bxkj.student.C4215R;
import java.util.Random;

/* compiled from: Code.java */
/* renamed from: com.bxkj.student.home.teaching.learning.detail.v */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C4679v {

    /* renamed from: a */
    private final char[] f17487a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: b */
    private int[] f17488b;

    /* renamed from: c */
    private SpannableString f17489c;

    /* renamed from: d */
    private Context f17490d;

    public C4679v(Context mContext) {
        this.f17490d = mContext;
    }

    /* renamed from: a */
    public SpannableString m41643a() {
        this.f17488b = new int[]{ContextCompat.getColor(this.f17490d, 2131034172), ContextCompat.getColor(this.f17490d, 2131034175), ContextCompat.getColor(this.f17490d, 2131034177), ContextCompat.getColor(this.f17490d, 2131034489), ContextCompat.getColor(this.f17490d, 2131034189), ContextCompat.getColor(this.f17490d, C4215R.C4217color.purple), ContextCompat.getColor(this.f17490d, C4215R.C4217color.speed1), ContextCompat.getColor(this.f17490d, 2131034190), ContextCompat.getColor(this.f17490d, C4215R.C4217color.color_red_light), ContextCompat.getColor(this.f17490d, 2131034176)};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(this.f17487a[new Random().nextInt(this.f17487a.length)]);
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        this.f17489c = spannableString;
        spannableString.setSpan(new ForegroundColorSpan(this.f17488b[new Random().nextInt(this.f17488b.length)]), 0, 1, 33);
        this.f17489c.setSpan(new ForegroundColorSpan(this.f17488b[new Random().nextInt(this.f17488b.length)]), 1, 2, 33);
        this.f17489c.setSpan(new ForegroundColorSpan(this.f17488b[new Random().nextInt(this.f17488b.length)]), 2, 3, 33);
        this.f17489c.setSpan(new ForegroundColorSpan(this.f17488b[new Random().nextInt(this.f17488b.length)]), 3, 4, 33);
        return this.f17489c;
    }

    /* renamed from: b */
    public SpannableString m41642b() {
        return this.f17489c;
    }
}
