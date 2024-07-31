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
import cn.bluemobi.dylan.base.utils.MyImageLoader;
import com.bumptech.glide.Glide;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private SparseArray<View> f1711a;

    /* renamed from: b */
    private View f1712b;

    /* renamed from: c */
    private Context f1713c;

    /* renamed from: d */
    private int f1714d;

    /* renamed from: e */
    private int f1715e;

    public ViewHolder(Context context, View view, ViewGroup viewGroup) {
        super(view);
        this.f1715e = getLayoutPosition();
        this.f1713c = context;
        this.f1712b = view;
        this.f1711a = new SparseArray<>();
        this.f1712b.setTag(this);
    }

    /* renamed from: a */
    public static ViewHolder m57869a(Context context, View view, ViewGroup viewGroup, int i) {
        if (view == null) {
            ViewHolder viewHolder = new ViewHolder(context, LayoutInflater.from(context).inflate(i, viewGroup, false), viewGroup);
            viewHolder.f1714d = i;
            return viewHolder;
        }
        return (ViewHolder) view.getTag();
    }

    /* renamed from: A */
    public ViewHolder m57883A(int i, int i2, int i3) {
        ProgressBar progressBar = (ProgressBar) m57862h(i);
        progressBar.setMax(i3);
        progressBar.setProgress(i2);
        return this;
    }

    /* renamed from: B */
    public ViewHolder m57882B(int i, float f) {
        ((RatingBar) m57862h(i)).setRating(f);
        return this;
    }

    /* renamed from: C */
    public ViewHolder m57881C(int i, float f, int i2) {
        RatingBar ratingBar = (RatingBar) m57862h(i);
        ratingBar.setMax(i2);
        ratingBar.setRating(f);
        return this;
    }

    /* renamed from: D */
    public ViewHolder m57880D(int i, String str, int i2) {
        MyImageLoader.m57722c(this.f1713c, str, (ImageView) m57862h(i), i2);
        return this;
    }

    /* renamed from: E */
    public ViewHolder m57879E(int i, String str, int i2, int i3, int i4) {
        MyImageLoader.m57721d(this.f1713c, str, (ImageView) m57862h(i), i3, i4, i2);
        return this;
    }

    /* renamed from: F */
    public ViewHolder m57878F(int i, String str) {
        MyImageLoader.m57720e(this.f1713c, str, (ImageView) m57862h(i));
        return this;
    }

    /* renamed from: G */
    public ViewHolder m57877G(int i, String str, int i2, int i3) {
        MyImageLoader.m57719f(this.f1713c, str, (ImageView) m57862h(i), i2, i3);
        return this;
    }

    /* renamed from: H */
    public ViewHolder m57876H(int i, int i2, Object obj) {
        m57862h(i).setTag(i2, obj);
        return this;
    }

    /* renamed from: I */
    public ViewHolder m57875I(int i, Object obj) {
        m57862h(i).setTag(obj);
        return this;
    }

    /* renamed from: J */
    public ViewHolder m57874J(int i, CharSequence charSequence) {
        ((TextView) m57862h(i)).setText(charSequence);
        return this;
    }

    /* renamed from: K */
    public ViewHolder m57873K(int i, int i2) {
        ((TextView) m57862h(i)).setTextColor(i2);
        return this;
    }

    /* renamed from: L */
    public ViewHolder m57872L(int i, int i2) {
        ((TextView) m57862h(i)).setTextColor(this.f1713c.getResources().getColor(i2));
        return this;
    }

    /* renamed from: M */
    public ViewHolder m57871M(Typeface typeface, int... iArr) {
        for (int i : iArr) {
            TextView textView = (TextView) m57862h(i);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    /* renamed from: N */
    public ViewHolder m57870N(int i, boolean z) {
        m57862h(i).setVisibility(z ? 0 : 8);
        return this;
    }

    /* renamed from: b */
    public View m57868b() {
        return this.f1712b;
    }

    /* renamed from: c */
    public boolean m57867c(int i) {
        return m57862h(i).isEnabled();
    }

    /* renamed from: d */
    public String m57866d(int i) {
        return ((TextView) m57862h(i)).getHint().toString().trim();
    }

    /* renamed from: e */
    public int m57865e() {
        return this.f1714d;
    }

    /* renamed from: f */
    public int m57864f() {
        return this.f1715e;
    }

    /* renamed from: g */
    public String m57863g(int i) {
        return ((TextView) m57862h(i)).getText().toString().trim();
    }

    /* renamed from: h */
    public <T extends View> T m57862h(int i) {
        T t = (T) this.f1711a.get(i);
        if (t == null) {
            T t2 = (T) this.f1712b.findViewById(i);
            this.f1711a.put(i, t2);
            return t2;
        }
        return t;
    }

    /* renamed from: i */
    public ViewHolder m57861i(int i) {
        Linkify.addLinks((TextView) m57862h(i), 15);
        return this;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: j */
    public ViewHolder m57860j(int i, float f) {
        m57862h(i).setAlpha(f);
        return this;
    }

    /* renamed from: k */
    public ViewHolder m57859k(int i, int i2) {
        m57862h(i).setBackgroundColor(i2);
        return this;
    }

    /* renamed from: l */
    public ViewHolder m57858l(int i, int i2) {
        m57862h(i).setBackgroundResource(i2);
        return this;
    }

    /* renamed from: m */
    public ViewHolder m57857m(int i, boolean z) {
        ((Checkable) m57862h(i)).setChecked(z);
        return this;
    }

    /* renamed from: n */
    public ViewHolder m57856n(int i, boolean z) {
        m57862h(i).setEnabled(z);
        return this;
    }

    /* renamed from: o */
    public ViewHolder m57855o(int i, String str) {
        ((TextView) m57862h(i)).setHint(str);
        return this;
    }

    /* renamed from: p */
    public ViewHolder m57854p(int i, Bitmap bitmap) {
        ((ImageView) m57862h(i)).setImageBitmap(bitmap);
        return this;
    }

    /* renamed from: q */
    public ViewHolder m57853q(int i, Drawable drawable) {
        ((ImageView) m57862h(i)).setImageDrawable(drawable);
        return this;
    }

    /* renamed from: r */
    public ViewHolder m57852r(int i, int i2) {
        ((ImageView) m57862h(i)).setImageResource(i2);
        return this;
    }

    /* renamed from: s */
    public ViewHolder m57851s(int i, String str) {
        Glide.m45751C(this.f1713c).mo45507a(str).m45551i1((ImageView) m57862h(i));
        return this;
    }

    /* renamed from: t */
    public ViewHolder m57850t(int i, String str, int i2, int i3) {
        Glide.m45751C(this.f1713c).mo45507a(str).m44601w0(i2).m44600x(i3).m45551i1((ImageView) m57862h(i));
        return this;
    }

    /* renamed from: u */
    public ViewHolder m57849u(int i, int i2) {
        ((ProgressBar) m57862h(i)).setMax(i2);
        return this;
    }

    /* renamed from: v */
    public ViewHolder m57848v(int i) {
        this.f1715e = i;
        return this;
    }

    /* renamed from: w */
    public ViewHolder m57847w(int i, View.OnClickListener onClickListener) {
        m57862h(i).setOnClickListener(onClickListener);
        return this;
    }

    /* renamed from: x */
    public ViewHolder m57846x(int i, View.OnLongClickListener onLongClickListener) {
        m57862h(i).setOnLongClickListener(onLongClickListener);
        return this;
    }

    /* renamed from: y */
    public ViewHolder m57845y(int i, View.OnTouchListener onTouchListener) {
        m57862h(i).setOnTouchListener(onTouchListener);
        return this;
    }

    /* renamed from: z */
    public ViewHolder m57844z(int i, int i2) {
        ((ProgressBar) m57862h(i)).setProgress(i2);
        return this;
    }
}
