package cn.bluemobi.dylan.base.adapter.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.o;
import com.bumptech.glide.d;
import com.bumptech.glide.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<View> f1697a;

    /* renamed from: b  reason: collision with root package name */
    private View f1698b;

    /* renamed from: c  reason: collision with root package name */
    private Context f1699c;

    /* renamed from: d  reason: collision with root package name */
    private int f1700d;

    /* renamed from: e  reason: collision with root package name */
    private int f1701e;

    public ViewHolder(Context context, View view, ViewGroup viewGroup) {
        super(view);
        this.f1701e = getLayoutPosition();
        this.f1699c = context;
        this.f1698b = view;
        this.f1697a = new SparseArray<>();
        this.f1698b.setTag(this);
    }

    public static ViewHolder a(Context context, View view, ViewGroup viewGroup, int i4) {
        if (view == null) {
            ViewHolder viewHolder = new ViewHolder(context, LayoutInflater.from(context).inflate(i4, viewGroup, false), viewGroup);
            viewHolder.f1700d = i4;
            return viewHolder;
        }
        return (ViewHolder) view.getTag();
    }

    public ViewHolder A(int i4, int i5, int i6) {
        ProgressBar progressBar = (ProgressBar) h(i4);
        progressBar.setMax(i6);
        progressBar.setProgress(i5);
        return this;
    }

    public ViewHolder B(int i4, float f4) {
        ((RatingBar) h(i4)).setRating(f4);
        return this;
    }

    public ViewHolder C(int i4, float f4, int i5) {
        RatingBar ratingBar = (RatingBar) h(i4);
        ratingBar.setMax(i5);
        ratingBar.setRating(f4);
        return this;
    }

    public ViewHolder D(int i4, String str, int i5) {
        o.c(this.f1699c, str, (ImageView) h(i4), i5);
        return this;
    }

    public ViewHolder E(int i4, String str, int i5, int i6, int i7) {
        o.d(this.f1699c, str, (ImageView) h(i4), i6, i7, i5);
        return this;
    }

    public ViewHolder F(int i4, String str) {
        o.e(this.f1699c, str, (ImageView) h(i4));
        return this;
    }

    public ViewHolder G(int i4, String str, int i5, int i6) {
        o.f(this.f1699c, str, (ImageView) h(i4), i5, i6);
        return this;
    }

    public ViewHolder H(int i4, int i5, Object obj) {
        h(i4).setTag(i5, obj);
        return this;
    }

    public ViewHolder I(int i4, Object obj) {
        h(i4).setTag(obj);
        return this;
    }

    public ViewHolder J(int i4, CharSequence charSequence) {
        ((TextView) h(i4)).setText(charSequence);
        return this;
    }

    public ViewHolder K(int i4, int i5) {
        ((TextView) h(i4)).setTextColor(i5);
        return this;
    }

    public ViewHolder L(int i4, int i5) {
        ((TextView) h(i4)).setTextColor(this.f1699c.getResources().getColor(i5));
        return this;
    }

    public ViewHolder M(Typeface typeface, int... iArr) {
        for (int i4 : iArr) {
            TextView textView = (TextView) h(i4);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public ViewHolder N(int i4, boolean z3) {
        h(i4).setVisibility(z3 ? 0 : 8);
        return this;
    }

    public View b() {
        return this.f1698b;
    }

    public boolean c(int i4) {
        return h(i4).isEnabled();
    }

    public String d(int i4) {
        return ((TextView) h(i4)).getHint().toString().trim();
    }

    public int e() {
        return this.f1700d;
    }

    public int f() {
        return this.f1701e;
    }

    public String g(int i4) {
        return ((TextView) h(i4)).getText().toString().trim();
    }

    public <T extends View> T h(int i4) {
        T t3 = (T) this.f1697a.get(i4);
        if (t3 == null) {
            T t4 = (T) this.f1698b.findViewById(i4);
            this.f1697a.put(i4, t4);
            return t4;
        }
        return t3;
    }

    public ViewHolder i(int i4) {
        Linkify.addLinks((TextView) h(i4), 15);
        return this;
    }

    @SuppressLint({"NewApi"})
    public ViewHolder j(int i4, float f4) {
        h(i4).setAlpha(f4);
        return this;
    }

    public ViewHolder k(int i4, int i5) {
        h(i4).setBackgroundColor(i5);
        return this;
    }

    public ViewHolder l(int i4, int i5) {
        h(i4).setBackgroundResource(i5);
        return this;
    }

    public ViewHolder m(int i4, boolean z3) {
        ((Checkable) h(i4)).setChecked(z3);
        return this;
    }

    public ViewHolder n(int i4, boolean z3) {
        h(i4).setEnabled(z3);
        return this;
    }

    public ViewHolder o(int i4, String str) {
        ((TextView) h(i4)).setHint(str);
        return this;
    }

    public ViewHolder p(int i4, Bitmap bitmap) {
        ((ImageView) h(i4)).setImageBitmap(bitmap);
        return this;
    }

    public ViewHolder q(int i4, Drawable drawable) {
        ((ImageView) h(i4)).setImageDrawable(drawable);
        return this;
    }

    public ViewHolder r(int i4, int i5) {
        ((ImageView) h(i4)).setImageResource(i5);
        return this;
    }

    public ViewHolder s(int i4, String str) {
        d.C(this.f1699c).a(str).j1((ImageView) h(i4));
        return this;
    }

    public ViewHolder t(int i4, String str, int i5, int i6) {
        ((i) ((i) d.C(this.f1699c).a(str).x0(i5)).y(i6)).j1((ImageView) h(i4));
        return this;
    }

    public ViewHolder u(int i4, int i5) {
        ((ProgressBar) h(i4)).setMax(i5);
        return this;
    }

    public ViewHolder v(int i4) {
        this.f1701e = i4;
        return this;
    }

    public ViewHolder w(int i4, View.OnClickListener onClickListener) {
        h(i4).setOnClickListener(onClickListener);
        return this;
    }

    public ViewHolder x(int i4, View.OnLongClickListener onLongClickListener) {
        h(i4).setOnLongClickListener(onLongClickListener);
        return this;
    }

    public ViewHolder y(int i4, View.OnTouchListener onTouchListener) {
        h(i4).setOnTouchListener(onTouchListener);
        return this;
    }

    public ViewHolder z(int i4, int i5) {
        ((ProgressBar) h(i4)).setProgress(i5);
        return this;
    }
}
