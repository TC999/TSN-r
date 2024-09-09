package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.mbridge.msdk.foundation.tools.r;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBCircularProgressButton extends AppCompatButton {
    public static final int ERROR_STATE_PROGRESS = -1;
    public static final int IDLE_STATE_PROGRESS = 0;
    public static final int INDETERMINATE_STATE_PROGRESS = 50;
    public static final int SUCCESS_STATE_PROGRESS = 100;
    private d A;
    private d B;

    /* renamed from: a  reason: collision with root package name */
    private f f41197a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.widget.custom.baseview.a f41198b;

    /* renamed from: c  reason: collision with root package name */
    private b f41199c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f41200d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f41201e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f41202f;

    /* renamed from: g  reason: collision with root package name */
    private StateListDrawable f41203g;

    /* renamed from: h  reason: collision with root package name */
    private StateListDrawable f41204h;

    /* renamed from: i  reason: collision with root package name */
    private StateListDrawable f41205i;

    /* renamed from: j  reason: collision with root package name */
    private e f41206j;

    /* renamed from: k  reason: collision with root package name */
    private a f41207k;

    /* renamed from: l  reason: collision with root package name */
    private int f41208l;

    /* renamed from: m  reason: collision with root package name */
    private int f41209m;

    /* renamed from: n  reason: collision with root package name */
    private int f41210n;

    /* renamed from: o  reason: collision with root package name */
    private int f41211o;

    /* renamed from: p  reason: collision with root package name */
    private int f41212p;

    /* renamed from: q  reason: collision with root package name */
    private int f41213q;

    /* renamed from: r  reason: collision with root package name */
    private int f41214r;

    /* renamed from: s  reason: collision with root package name */
    private float f41215s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f41216t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f41217u;

    /* renamed from: v  reason: collision with root package name */
    private int f41218v;

    /* renamed from: w  reason: collision with root package name */
    private int f41219w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f41220x;

    /* renamed from: y  reason: collision with root package name */
    private d f41221y;

    /* renamed from: z  reason: collision with root package name */
    private d f41222z;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private boolean f41228a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f41229b;

        /* renamed from: c  reason: collision with root package name */
        private int f41230c;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f41230c);
            parcel.writeInt(this.f41228a ? 1 : 0);
            parcel.writeInt(this.f41229b ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f41230c = parcel.readInt();
            this.f41228a = parcel.readInt() == 1;
            this.f41229b = parcel.readInt() == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum a {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    public MBCircularProgressButton(Context context) {
        super(context);
        this.f41221y = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.1
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.PROGRESS;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.f41222z = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.2
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                if (MBCircularProgressButton.this.f41211o != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.a(mBCircularProgressButton, mBCircularProgressButton.f41211o);
                }
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.COMPLETE;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.A = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.3
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                MBCircularProgressButton.this.a();
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.IDLE;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.B = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.4
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                if (MBCircularProgressButton.this.f41212p != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.a(mBCircularProgressButton, mBCircularProgressButton.f41212p);
                }
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.ERROR;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        a(context, (AttributeSet) null);
    }

    private int d(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        a aVar = this.f41207k;
        if (aVar == a.COMPLETE) {
            f a4 = a(b(this.f41201e));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f41204h = stateListDrawable;
            stateListDrawable.addState(new int[]{16842919}, a4.a());
            this.f41204h.addState(StateSet.WILD_CARD, this.f41197a.a());
            setBackgroundCompat(this.f41204h);
        } else if (aVar == a.IDLE) {
            b();
            setBackgroundCompat(this.f41203g);
        } else if (aVar == a.ERROR) {
            f a5 = a(b(this.f41202f));
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            this.f41205i = stateListDrawable2;
            stateListDrawable2.addState(new int[]{16842919}, a5.a());
            this.f41205i.addState(StateSet.WILD_CARD, this.f41197a.a());
            setBackgroundCompat(this.f41205i);
        }
        if (this.f41207k != a.PROGRESS) {
            super.drawableStateChanged();
        }
    }

    public int getProgress() {
        return this.f41219w;
    }

    public boolean isIndeterminateProgressMode() {
        return this.f41216t;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f41219w <= 0 || this.f41207k != a.PROGRESS || this.f41220x) {
            return;
        }
        if (this.f41216t) {
            com.mbridge.msdk.widget.custom.baseview.a aVar = this.f41198b;
            if (aVar == null) {
                int width = (getWidth() - getHeight()) / 2;
                this.f41198b = new com.mbridge.msdk.widget.custom.baseview.a(this.f41209m, com.mbridge.msdk.widget.custom.b.a.a(getContext(), 2.0f));
                int i4 = this.f41214r + width;
                int width2 = (getWidth() - width) - this.f41214r;
                int height = getHeight();
                int i5 = this.f41214r;
                this.f41198b.setBounds(i4, i5, width2, height - i5);
                this.f41198b.setCallback(this);
                this.f41198b.start();
                return;
            }
            aVar.draw(canvas);
            return;
        }
        if (this.f41199c == null) {
            b bVar = new b(getHeight() - (this.f41214r * 2), com.mbridge.msdk.widget.custom.b.a.a(getContext(), 4), this.f41209m);
            this.f41199c = bVar;
            int i6 = this.f41214r;
            int width3 = ((getWidth() - getHeight()) / 2) + i6;
            bVar.setBounds(width3, i6, width3, i6);
        }
        this.f41199c.a((360.0f / this.f41218v) * this.f41219w);
        this.f41199c.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (z3) {
            setProgress(this.f41219w);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f41219w = savedState.f41230c;
            this.f41216t = savedState.f41228a;
            this.f41217u = savedState.f41229b;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(this.f41219w);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f41230c = this.f41219w;
        savedState.f41228a = this.f41216t;
        savedState.f41229b = true;
        return savedState;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f41197a.a().setColor(i4);
    }

    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setIndeterminateProgressMode(boolean z3) {
        this.f41216t = z3;
    }

    public void setProgress(int i4) {
        this.f41219w = i4;
        if (this.f41220x || getWidth() == 0) {
            return;
        }
        this.f41206j.a(this);
        int i5 = this.f41219w;
        if (i5 >= this.f41218v) {
            a aVar = this.f41207k;
            if (aVar == a.PROGRESS) {
                c a4 = a(getHeight(), this.f41215s, getHeight(), getWidth());
                a4.d(this.f41208l);
                a4.e(a(this.f41201e));
                a4.f(this.f41209m);
                a4.g(a(this.f41201e));
                a4.a(this.f41222z);
                a4.a();
            } else if (aVar == a.IDLE) {
                c c4 = c();
                c4.d(a(this.f41200d));
                c4.e(a(this.f41201e));
                c4.f(a(this.f41200d));
                c4.g(a(this.f41201e));
                c4.a(this.f41222z);
                c4.a();
            }
        } else if (i5 > 0) {
            a aVar2 = this.f41207k;
            if (aVar2 == a.IDLE) {
                setWidth(getWidth());
                c a5 = a(this.f41215s, getHeight(), getWidth(), getHeight());
                a5.d(a(this.f41200d));
                a5.e(this.f41208l);
                a5.f(a(this.f41200d));
                a5.g(this.f41210n);
                a5.a(this.f41221y);
                a5.a();
            } else if (aVar2 == a.PROGRESS) {
                invalidate();
            }
        } else if (i5 == -1) {
            a aVar3 = this.f41207k;
            if (aVar3 == a.PROGRESS) {
                c a6 = a(getHeight(), this.f41215s, getHeight(), getWidth());
                a6.d(this.f41208l);
                a6.e(a(this.f41202f));
                a6.f(this.f41209m);
                a6.g(a(this.f41202f));
                a6.a(this.B);
                a6.a();
            } else if (aVar3 == a.IDLE) {
                c c5 = c();
                c5.d(a(this.f41200d));
                c5.e(a(this.f41202f));
                c5.f(a(this.f41200d));
                c5.g(a(this.f41202f));
                c5.a(this.B);
                c5.a();
            }
        } else if (i5 == 0) {
            a aVar4 = this.f41207k;
            if (aVar4 == a.COMPLETE) {
                c c6 = c();
                c6.d(a(this.f41201e));
                c6.e(a(this.f41200d));
                c6.f(a(this.f41201e));
                c6.g(a(this.f41200d));
                c6.a(this.A);
                c6.a();
            } else if (aVar4 == a.PROGRESS) {
                if (this.f41216t) {
                    c a7 = a(getHeight(), this.f41215s, getHeight(), getWidth());
                    a7.d(this.f41208l);
                    a7.e(a(this.f41200d));
                    a7.f(this.f41209m);
                    a7.g(a(this.f41200d));
                    a7.a(new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.5
                        @Override // com.mbridge.msdk.widget.custom.baseview.d
                        public final void a() {
                            MBCircularProgressButton.this.a();
                            MBCircularProgressButton.this.f41220x = false;
                            MBCircularProgressButton.this.f41207k = a.IDLE;
                            MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
                        }
                    });
                    a7.a();
                }
            } else if (aVar4 == a.ERROR) {
                c c7 = c();
                c7.d(a(this.f41202f));
                c7.e(a(this.f41200d));
                c7.f(a(this.f41202f));
                c7.g(a(this.f41200d));
                c7.a(this.A);
                c7.a();
            }
        }
    }

    public void setStrokeColor(int i4) {
        this.f41197a.b(i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f41198b || super.verifyDrawable(drawable);
    }

    private void b() {
        int a4 = a(this.f41200d);
        int b4 = b(this.f41200d);
        int c4 = c(this.f41200d);
        int d4 = d(this.f41200d);
        if (this.f41197a == null) {
            this.f41197a = a(a4);
        }
        f a5 = a(d4);
        f a6 = a(c4);
        f a7 = a(b4);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f41203g = stateListDrawable;
        stateListDrawable.addState(new int[]{16842919}, a7.a());
        this.f41203g.addState(new int[]{16842908}, a6.a());
        this.f41203g.addState(new int[]{-16842910}, a5.a());
        this.f41203g.addState(StateSet.WILD_CARD, this.f41197a.a());
    }

    private int c(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842908}, 0);
    }

    private c c() {
        this.f41220x = true;
        c cVar = new c(this, this.f41197a);
        cVar.a(this.f41215s);
        cVar.b(this.f41215s);
        cVar.b(getWidth());
        cVar.c(getWidth());
        if (this.f41217u) {
            cVar.a(1);
        } else {
            cVar.a(500);
        }
        this.f41217u = false;
        return cVar;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f41213q = 0;
        b(context, attributeSet);
        this.f41218v = 100;
        this.f41207k = a.IDLE;
        this.f41206j = new e(this);
        b();
        setBackgroundCompat(this.f41203g);
    }

    public MBCircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41221y = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.1
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.PROGRESS;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.f41222z = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.2
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                if (MBCircularProgressButton.this.f41211o != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.a(mBCircularProgressButton, mBCircularProgressButton.f41211o);
                }
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.COMPLETE;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.A = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.3
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                MBCircularProgressButton.this.a();
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.IDLE;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.B = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.4
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                if (MBCircularProgressButton.this.f41212p != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.a(mBCircularProgressButton, mBCircularProgressButton.f41212p);
                }
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.ERROR;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        a(context, attributeSet);
    }

    private int a(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    private f a(int i4) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(r.a(getContext(), "mbridge_cpb_background", "drawable")).mutate();
        gradientDrawable.setColor(i4);
        gradientDrawable.setCornerRadius(this.f41215s);
        f fVar = new f(gradientDrawable);
        fVar.b(i4);
        fVar.a(this.f41213q);
        return fVar;
    }

    public MBCircularProgressButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f41221y = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.1
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.PROGRESS;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.f41222z = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.2
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                if (MBCircularProgressButton.this.f41211o != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.a(mBCircularProgressButton, mBCircularProgressButton.f41211o);
                }
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.COMPLETE;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.A = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.3
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                MBCircularProgressButton.this.a();
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.IDLE;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        this.B = new d() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.4
            @Override // com.mbridge.msdk.widget.custom.baseview.d
            public final void a() {
                if (MBCircularProgressButton.this.f41212p != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.a(mBCircularProgressButton, mBCircularProgressButton.f41212p);
                }
                MBCircularProgressButton.this.f41220x = false;
                MBCircularProgressButton.this.f41207k = a.ERROR;
                MBCircularProgressButton.this.f41206j.b(MBCircularProgressButton.this);
            }
        };
        a(context, attributeSet);
    }

    private int b(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842919}, 0);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f41215s = 100.0f;
        this.f41214r = 0;
        int b4 = b(r.a(context, "mbridge_cpb_green", "color"));
        int b5 = b(r.a(context, "mbridge_cpb_white", "color"));
        int b6 = b(r.a(context, "mbridge_cpb_grey", "color"));
        this.f41200d = getResources().getColorStateList(r.a(context, "mbridge_cpb_idle_state_selector", "color"));
        this.f41201e = getResources().getColorStateList(r.a(context, "mbridge_cpb_complete_state_selector", "color"));
        this.f41202f = getResources().getColorStateList(r.a(context, "mbridge_cpb_error_state_selector", "color"));
        this.f41208l = b5;
        this.f41209m = b4;
        this.f41210n = b6;
    }

    private c a(float f4, float f5, int i4, int i5) {
        this.f41220x = true;
        c cVar = new c(this, this.f41197a);
        cVar.a(f4);
        cVar.b(f5);
        cVar.c(this.f41214r);
        cVar.b(i4);
        cVar.c(i5);
        if (this.f41217u) {
            cVar.a(1);
        } else {
            cVar.a(500);
        }
        this.f41217u = false;
        return cVar;
    }

    protected final void a() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(0, 0, 0, 0);
    }

    static /* synthetic */ void a(MBCircularProgressButton mBCircularProgressButton, int i4) {
        Drawable drawable = mBCircularProgressButton.getResources().getDrawable(i4);
        if (drawable != null) {
            mBCircularProgressButton.setCompoundDrawablesWithIntrinsicBounds(i4, 0, 0, 0);
            mBCircularProgressButton.setPadding((mBCircularProgressButton.getWidth() / 2) - (drawable.getIntrinsicWidth() / 2), 0, 0, 0);
        }
    }

    private int b(int i4) {
        return getResources().getColor(i4);
    }
}
