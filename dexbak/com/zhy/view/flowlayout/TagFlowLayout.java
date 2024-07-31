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
import com.zhy.view.flowlayout.TagAdapter;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TagFlowLayout extends FlowLayout implements TagAdapter.InterfaceC13568a {

    /* renamed from: q */
    private static final String f40070q = "TagFlowLayout";

    /* renamed from: r */
    private static final String f40071r = "key_choose_pos";

    /* renamed from: s */
    private static final String f40072s = "key_default";

    /* renamed from: j */
    private TagAdapter f40073j;

    /* renamed from: k */
    private boolean f40074k;

    /* renamed from: l */
    private int f40075l;

    /* renamed from: m */
    private MotionEvent f40076m;

    /* renamed from: n */
    private Set<Integer> f40077n;

    /* renamed from: o */
    private InterfaceC13565a f40078o;

    /* renamed from: p */
    private InterfaceC13566b f40079p;

    /* renamed from: com.zhy.view.flowlayout.TagFlowLayout$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13565a {
        /* renamed from: a */
        void mo12858a(Set<Integer> set);
    }

    /* renamed from: com.zhy.view.flowlayout.TagFlowLayout$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13566b {
        /* renamed from: a */
        boolean m12857a(View view, int i, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40074k = true;
        this.f40075l = -1;
        this.f40077n = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C13558R.styleable.TagFlowLayout);
        this.f40074k = obtainStyledAttributes.getBoolean(C13558R.styleable.TagFlowLayout_auto_select_effect, true);
        this.f40075l = obtainStyledAttributes.getInt(C13558R.styleable.TagFlowLayout_max_select, -1);
        obtainStyledAttributes.recycle();
        if (this.f40074k) {
            setClickable(true);
        }
    }

    /* renamed from: b */
    private void m12863b() {
        removeAllViews();
        TagAdapter tagAdapter = this.f40073j;
        HashSet<Integer> m12854c = tagAdapter.m12854c();
        for (int i = 0; i < tagAdapter.m12856a(); i++) {
            View mo12853d = tagAdapter.mo12853d(this, i, tagAdapter.m12855b(i));
            TagView tagView = new TagView(getContext());
            mo12853d.setDuplicateParentStateEnabled(true);
            if (mo12853d.getLayoutParams() != null) {
                tagView.setLayoutParams(mo12853d.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(m12862c(getContext(), 5.0f), m12862c(getContext(), 5.0f), m12862c(getContext(), 5.0f), m12862c(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            tagView.addView(mo12853d);
            addView(tagView);
            if (m12854c.contains(Integer.valueOf(i))) {
                tagView.setChecked(true);
            }
            if (this.f40073j.m12850g(i, tagAdapter.m12855b(i))) {
                this.f40077n.add(Integer.valueOf(i));
                tagView.setChecked(true);
            }
        }
        this.f40077n.addAll(m12854c);
    }

    /* renamed from: c */
    public static int m12862c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: d */
    private void m12861d(TagView tagView, int i) {
        if (this.f40074k) {
            if (!tagView.isChecked()) {
                if (this.f40075l == 1 && this.f40077n.size() == 1) {
                    Integer next = this.f40077n.iterator().next();
                    ((TagView) getChildAt(next.intValue())).setChecked(false);
                    tagView.setChecked(true);
                    this.f40077n.remove(next);
                    this.f40077n.add(Integer.valueOf(i));
                } else if (this.f40075l > 0 && this.f40077n.size() >= this.f40075l) {
                    return;
                } else {
                    tagView.setChecked(true);
                    this.f40077n.add(Integer.valueOf(i));
                }
            } else {
                tagView.setChecked(false);
                this.f40077n.remove(Integer.valueOf(i));
            }
            InterfaceC13565a interfaceC13565a = this.f40078o;
            if (interfaceC13565a != null) {
                interfaceC13565a.mo12858a(new HashSet(this.f40077n));
            }
        }
    }

    /* renamed from: e */
    private TagView m12860e(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8) {
                Rect rect = new Rect();
                tagView.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return tagView;
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    private int m12859f(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.zhy.view.flowlayout.TagAdapter.InterfaceC13568a
    /* renamed from: a */
    public void mo12847a() {
        this.f40077n.clear();
        m12863b();
    }

    public TagAdapter getAdapter() {
        return this.f40073j;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f40077n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhy.view.flowlayout.FlowLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString(f40071r);
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("\\|")) {
                    int parseInt = Integer.parseInt(str);
                    this.f40077n.add(Integer.valueOf(parseInt));
                    TagView tagView = (TagView) getChildAt(parseInt);
                    if (tagView != null) {
                        tagView.setChecked(true);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable(f40072s));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f40072s, super.onSaveInstanceState());
        String str = "";
        if (this.f40077n.size() > 0) {
            for (Integer num : this.f40077n) {
                str = str + num.intValue() + "|";
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString(f40071r, str);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f40076m = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        MotionEvent motionEvent = this.f40076m;
        if (motionEvent == null) {
            return super.performClick();
        }
        this.f40076m = null;
        TagView m12860e = m12860e((int) motionEvent.getX(), (int) this.f40076m.getY());
        int m12859f = m12859f(m12860e);
        if (m12860e != null) {
            m12861d(m12860e, m12859f);
            InterfaceC13566b interfaceC13566b = this.f40079p;
            if (interfaceC13566b != null) {
                return interfaceC13566b.m12857a(m12860e.getTagView(), m12859f, this);
            }
            return true;
        }
        return true;
    }

    public void setAdapter(TagAdapter tagAdapter) {
        this.f40073j = tagAdapter;
        tagAdapter.m12851f(this);
        this.f40077n.clear();
        m12863b();
    }

    public void setMaxSelectCount(int i) {
        if (this.f40077n.size() > i) {
            Log.w(f40070q, "you has already select more than " + i + " views , so it will be clear .");
            this.f40077n.clear();
        }
        this.f40075l = i;
    }

    public void setOnSelectListener(InterfaceC13565a interfaceC13565a) {
        this.f40078o = interfaceC13565a;
        if (interfaceC13565a != null) {
            setClickable(true);
        }
    }

    public void setOnTagClickListener(InterfaceC13566b interfaceC13566b) {
        this.f40079p = interfaceC13566b;
        if (interfaceC13566b != null) {
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
