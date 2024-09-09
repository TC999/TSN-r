package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.zhy.view.flowlayout.b;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class TagFlowLayout extends FlowLayout implements b.a {

    /* renamed from: q  reason: collision with root package name */
    private static final String f54576q = "TagFlowLayout";

    /* renamed from: r  reason: collision with root package name */
    private static final String f54577r = "key_choose_pos";

    /* renamed from: s  reason: collision with root package name */
    private static final String f54578s = "key_default";

    /* renamed from: j  reason: collision with root package name */
    private com.zhy.view.flowlayout.b f54579j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f54580k;

    /* renamed from: l  reason: collision with root package name */
    private int f54581l;

    /* renamed from: m  reason: collision with root package name */
    private MotionEvent f54582m;

    /* renamed from: n  reason: collision with root package name */
    private Set<Integer> f54583n;

    /* renamed from: o  reason: collision with root package name */
    private a f54584o;

    /* renamed from: p  reason: collision with root package name */
    private b f54585p;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a(Set<Integer> set);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface b {
        boolean a(View view, int i4, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f54580k = true;
        this.f54581l = -1;
        this.f54583n = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f54580k = obtainStyledAttributes.getBoolean(R.styleable.TagFlowLayout_auto_select_effect, true);
        this.f54581l = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_max_select, -1);
        obtainStyledAttributes.recycle();
        if (this.f54580k) {
            setClickable(true);
        }
    }

    private void b() {
        removeAllViews();
        com.zhy.view.flowlayout.b bVar = this.f54579j;
        HashSet<Integer> c4 = bVar.c();
        for (int i4 = 0; i4 < bVar.a(); i4++) {
            View d4 = bVar.d(this, i4, bVar.b(i4));
            TagView tagView = new TagView(getContext());
            d4.setDuplicateParentStateEnabled(true);
            if (d4.getLayoutParams() != null) {
                tagView.setLayoutParams(d4.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(c(getContext(), 5.0f), c(getContext(), 5.0f), c(getContext(), 5.0f), c(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            tagView.addView(d4);
            addView(tagView);
            if (c4.contains(Integer.valueOf(i4))) {
                tagView.setChecked(true);
            }
            if (this.f54579j.g(i4, bVar.b(i4))) {
                this.f54583n.add(Integer.valueOf(i4));
                tagView.setChecked(true);
            }
        }
        this.f54583n.addAll(c4);
    }

    public static int c(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void d(TagView tagView, int i4) {
        if (this.f54580k) {
            if (!tagView.isChecked()) {
                if (this.f54581l == 1 && this.f54583n.size() == 1) {
                    Integer next = this.f54583n.iterator().next();
                    ((TagView) getChildAt(next.intValue())).setChecked(false);
                    tagView.setChecked(true);
                    this.f54583n.remove(next);
                    this.f54583n.add(Integer.valueOf(i4));
                } else if (this.f54581l > 0 && this.f54583n.size() >= this.f54581l) {
                    return;
                } else {
                    tagView.setChecked(true);
                    this.f54583n.add(Integer.valueOf(i4));
                }
            } else {
                tagView.setChecked(false);
                this.f54583n.remove(Integer.valueOf(i4));
            }
            a aVar = this.f54584o;
            if (aVar != null) {
                aVar.a(new HashSet(this.f54583n));
            }
        }
    }

    private TagView e(int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            TagView tagView = (TagView) getChildAt(i6);
            if (tagView.getVisibility() != 8) {
                Rect rect = new Rect();
                tagView.getHitRect(rect);
                if (rect.contains(i4, i5)) {
                    return tagView;
                }
            }
        }
        return null;
    }

    private int f(View view) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (getChildAt(i4) == view) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.zhy.view.flowlayout.b.a
    public void a() {
        this.f54583n.clear();
        b();
    }

    public com.zhy.view.flowlayout.b getAdapter() {
        return this.f54579j;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f54583n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhy.view.flowlayout.FlowLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            TagView tagView = (TagView) getChildAt(i6);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("\\|")) {
                    int parseInt = Integer.parseInt(str);
                    this.f54583n.add(Integer.valueOf(parseInt));
                    TagView tagView = (TagView) getChildAt(parseInt);
                    if (tagView != null) {
                        tagView.setChecked(true);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String str = "";
        if (this.f54583n.size() > 0) {
            for (Integer num : this.f54583n) {
                str = str + num.intValue() + "|";
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString("key_choose_pos", str);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f54582m = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        MotionEvent motionEvent = this.f54582m;
        if (motionEvent == null) {
            return super.performClick();
        }
        this.f54582m = null;
        TagView e4 = e((int) motionEvent.getX(), (int) this.f54582m.getY());
        int f4 = f(e4);
        if (e4 != null) {
            d(e4, f4);
            b bVar = this.f54585p;
            if (bVar != null) {
                return bVar.a(e4.getTagView(), f4, this);
            }
            return true;
        }
        return true;
    }

    public void setAdapter(com.zhy.view.flowlayout.b bVar) {
        this.f54579j = bVar;
        bVar.f(this);
        this.f54583n.clear();
        b();
    }

    public void setMaxSelectCount(int i4) {
        if (this.f54583n.size() > i4) {
            Log.w("TagFlowLayout", "you has already select more than " + i4 + " views , so it will be clear .");
            this.f54583n.clear();
        }
        this.f54581l = i4;
    }

    public void setOnSelectListener(a aVar) {
        this.f54584o = aVar;
        if (aVar != null) {
            setClickable(true);
        }
    }

    public void setOnTagClickListener(b bVar) {
        this.f54585p = bVar;
        if (bVar != null) {
            setClickable(true);
        }
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }
}
