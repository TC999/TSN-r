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
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.widget.custom.p517b.DensityUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBCircularProgressButton extends AppCompatButton {
    public static final int ERROR_STATE_PROGRESS = -1;
    public static final int IDLE_STATE_PROGRESS = 0;
    public static final int INDETERMINATE_STATE_PROGRESS = 50;
    public static final int SUCCESS_STATE_PROGRESS = 100;

    /* renamed from: A */
    private OnAnimationEndListener f32508A;

    /* renamed from: B */
    private OnAnimationEndListener f32509B;

    /* renamed from: a */
    private StrokeGradientDrawable f32510a;

    /* renamed from: b */
    private CircularAnimatedDrawable f32511b;

    /* renamed from: c */
    private CircularProgressDrawable f32512c;

    /* renamed from: d */
    private ColorStateList f32513d;

    /* renamed from: e */
    private ColorStateList f32514e;

    /* renamed from: f */
    private ColorStateList f32515f;

    /* renamed from: g */
    private StateListDrawable f32516g;

    /* renamed from: h */
    private StateListDrawable f32517h;

    /* renamed from: i */
    private StateListDrawable f32518i;

    /* renamed from: j */
    private StateManager f32519j;

    /* renamed from: k */
    private EnumC11762a f32520k;

    /* renamed from: l */
    private int f32521l;

    /* renamed from: m */
    private int f32522m;

    /* renamed from: n */
    private int f32523n;

    /* renamed from: o */
    private int f32524o;

    /* renamed from: p */
    private int f32525p;

    /* renamed from: q */
    private int f32526q;

    /* renamed from: r */
    private int f32527r;

    /* renamed from: s */
    private float f32528s;

    /* renamed from: t */
    private boolean f32529t;

    /* renamed from: u */
    private boolean f32530u;

    /* renamed from: v */
    private int f32531v;

    /* renamed from: w */
    private int f32532w;

    /* renamed from: x */
    private boolean f32533x;

    /* renamed from: y */
    private OnAnimationEndListener f32534y;

    /* renamed from: z */
    private OnAnimationEndListener f32535z;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        private boolean f32541a;

        /* renamed from: b */
        private boolean f32542b;

        /* renamed from: c */
        private int f32543c;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f32543c);
            parcel.writeInt(this.f32541a ? 1 : 0);
            parcel.writeInt(this.f32542b ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f32543c = parcel.readInt();
            this.f32541a = parcel.readInt() == 1;
            this.f32542b = parcel.readInt() == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC11762a {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    public MBCircularProgressButton(Context context) {
        super(context);
        this.f32534y = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.1
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.PROGRESS;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32535z = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.2
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                if (MBCircularProgressButton.this.f32524o != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.m20558a(mBCircularProgressButton, mBCircularProgressButton.f32524o);
                }
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.COMPLETE;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32508A = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.3
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                MBCircularProgressButton.this.m20564a();
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.IDLE;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32509B = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.4
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                if (MBCircularProgressButton.this.f32525p != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.m20558a(mBCircularProgressButton, mBCircularProgressButton.f32525p);
                }
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.ERROR;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        m20561a(context, (AttributeSet) null);
    }

    /* renamed from: d */
    private int m20547d(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        EnumC11762a enumC11762a = this.f32520k;
        if (enumC11762a == EnumC11762a.COMPLETE) {
            StrokeGradientDrawable m20562a = m20562a(m20552b(this.f32514e));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f32517h = stateListDrawable;
            stateListDrawable.addState(new int[]{16842919}, m20562a.m20514a());
            this.f32517h.addState(StateSet.WILD_CARD, this.f32510a.m20514a());
            setBackgroundCompat(this.f32517h);
        } else if (enumC11762a == EnumC11762a.IDLE) {
            m20555b();
            setBackgroundCompat(this.f32516g);
        } else if (enumC11762a == EnumC11762a.ERROR) {
            StrokeGradientDrawable m20562a2 = m20562a(m20552b(this.f32515f));
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            this.f32518i = stateListDrawable2;
            stateListDrawable2.addState(new int[]{16842919}, m20562a2.m20514a());
            this.f32518i.addState(StateSet.WILD_CARD, this.f32510a.m20514a());
            setBackgroundCompat(this.f32518i);
        }
        if (this.f32520k != EnumC11762a.PROGRESS) {
            super.drawableStateChanged();
        }
    }

    public int getProgress() {
        return this.f32532w;
    }

    public boolean isIndeterminateProgressMode() {
        return this.f32529t;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f32532w <= 0 || this.f32520k != EnumC11762a.PROGRESS || this.f32533x) {
            return;
        }
        if (this.f32529t) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.f32511b;
            if (circularAnimatedDrawable == null) {
                int width = (getWidth() - getHeight()) / 2;
                this.f32511b = new CircularAnimatedDrawable(this.f32522m, DensityUtil.m20579a(getContext(), 2.0f));
                int i = this.f32527r + width;
                int width2 = (getWidth() - width) - this.f32527r;
                int height = getHeight();
                int i2 = this.f32527r;
                this.f32511b.setBounds(i, i2, width2, height - i2);
                this.f32511b.setCallback(this);
                this.f32511b.start();
                return;
            }
            circularAnimatedDrawable.draw(canvas);
            return;
        }
        if (this.f32512c == null) {
            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getHeight() - (this.f32527r * 2), DensityUtil.m20578a(getContext(), 4), this.f32522m);
            this.f32512c = circularProgressDrawable;
            int i3 = this.f32527r;
            int width3 = ((getWidth() - getHeight()) / 2) + i3;
            circularProgressDrawable.setBounds(width3, i3, width3, i3);
        }
        this.f32512c.m20535a((360.0f / this.f32531v) * this.f32532w);
        this.f32512c.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            setProgress(this.f32532w);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f32532w = savedState.f32543c;
            this.f32529t = savedState.f32541a;
            this.f32530u = savedState.f32542b;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(this.f32532w);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f32543c = this.f32532w;
        savedState.f32541a = this.f32529t;
        savedState.f32542b = true;
        return savedState;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f32510a.m20514a().setColor(i);
    }

    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setIndeterminateProgressMode(boolean z) {
        this.f32529t = z;
    }

    public void setProgress(int i) {
        this.f32532w = i;
        if (this.f32533x || getWidth() == 0) {
            return;
        }
        this.f32519j.m20516a(this);
        int i2 = this.f32532w;
        if (i2 >= this.f32531v) {
            EnumC11762a enumC11762a = this.f32520k;
            if (enumC11762a == EnumC11762a.PROGRESS) {
                MorphingAnimation m20563a = m20563a(getHeight(), this.f32528s, getHeight(), getWidth());
                m20563a.m20523d(this.f32521l);
                m20563a.m20521e(m20560a(this.f32514e));
                m20563a.m20519f(this.f32522m);
                m20563a.m20518g(m20560a(this.f32514e));
                m20563a.m20530a(this.f32535z);
                m20563a.m20534a();
            } else if (enumC11762a == EnumC11762a.IDLE) {
                MorphingAnimation m20550c = m20550c();
                m20550c.m20523d(m20560a(this.f32513d));
                m20550c.m20521e(m20560a(this.f32514e));
                m20550c.m20519f(m20560a(this.f32513d));
                m20550c.m20518g(m20560a(this.f32514e));
                m20550c.m20530a(this.f32535z);
                m20550c.m20534a();
            }
        } else if (i2 > 0) {
            EnumC11762a enumC11762a2 = this.f32520k;
            if (enumC11762a2 == EnumC11762a.IDLE) {
                setWidth(getWidth());
                MorphingAnimation m20563a2 = m20563a(this.f32528s, getHeight(), getWidth(), getHeight());
                m20563a2.m20523d(m20560a(this.f32513d));
                m20563a2.m20521e(this.f32521l);
                m20563a2.m20519f(m20560a(this.f32513d));
                m20563a2.m20518g(this.f32523n);
                m20563a2.m20530a(this.f32534y);
                m20563a2.m20534a();
            } else if (enumC11762a2 == EnumC11762a.PROGRESS) {
                invalidate();
            }
        } else if (i2 == -1) {
            EnumC11762a enumC11762a3 = this.f32520k;
            if (enumC11762a3 == EnumC11762a.PROGRESS) {
                MorphingAnimation m20563a3 = m20563a(getHeight(), this.f32528s, getHeight(), getWidth());
                m20563a3.m20523d(this.f32521l);
                m20563a3.m20521e(m20560a(this.f32515f));
                m20563a3.m20519f(this.f32522m);
                m20563a3.m20518g(m20560a(this.f32515f));
                m20563a3.m20530a(this.f32509B);
                m20563a3.m20534a();
            } else if (enumC11762a3 == EnumC11762a.IDLE) {
                MorphingAnimation m20550c2 = m20550c();
                m20550c2.m20523d(m20560a(this.f32513d));
                m20550c2.m20521e(m20560a(this.f32515f));
                m20550c2.m20519f(m20560a(this.f32513d));
                m20550c2.m20518g(m20560a(this.f32515f));
                m20550c2.m20530a(this.f32509B);
                m20550c2.m20534a();
            }
        } else if (i2 == 0) {
            EnumC11762a enumC11762a4 = this.f32520k;
            if (enumC11762a4 == EnumC11762a.COMPLETE) {
                MorphingAnimation m20550c3 = m20550c();
                m20550c3.m20523d(m20560a(this.f32514e));
                m20550c3.m20521e(m20560a(this.f32513d));
                m20550c3.m20519f(m20560a(this.f32514e));
                m20550c3.m20518g(m20560a(this.f32513d));
                m20550c3.m20530a(this.f32508A);
                m20550c3.m20534a();
            } else if (enumC11762a4 == EnumC11762a.PROGRESS) {
                if (this.f32529t) {
                    MorphingAnimation m20563a4 = m20563a(getHeight(), this.f32528s, getHeight(), getWidth());
                    m20563a4.m20523d(this.f32521l);
                    m20563a4.m20521e(m20560a(this.f32513d));
                    m20563a4.m20519f(this.f32522m);
                    m20563a4.m20518g(m20560a(this.f32513d));
                    m20563a4.m20530a(new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.5
                        @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
                        /* renamed from: a */
                        public final void mo20517a() {
                            MBCircularProgressButton.this.m20564a();
                            MBCircularProgressButton.this.f32533x = false;
                            MBCircularProgressButton.this.f32520k = EnumC11762a.IDLE;
                            MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
                        }
                    });
                    m20563a4.m20534a();
                }
            } else if (enumC11762a4 == EnumC11762a.ERROR) {
                MorphingAnimation m20550c4 = m20550c();
                m20550c4.m20523d(m20560a(this.f32515f));
                m20550c4.m20521e(m20560a(this.f32513d));
                m20550c4.m20519f(m20560a(this.f32515f));
                m20550c4.m20518g(m20560a(this.f32513d));
                m20550c4.m20530a(this.f32508A);
                m20550c4.m20534a();
            }
        }
    }

    public void setStrokeColor(int i) {
        this.f32510a.m20512b(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f32511b || super.verifyDrawable(drawable);
    }

    /* renamed from: b */
    private void m20555b() {
        int m20560a = m20560a(this.f32513d);
        int m20552b = m20552b(this.f32513d);
        int m20549c = m20549c(this.f32513d);
        int m20547d = m20547d(this.f32513d);
        if (this.f32510a == null) {
            this.f32510a = m20562a(m20560a);
        }
        StrokeGradientDrawable m20562a = m20562a(m20547d);
        StrokeGradientDrawable m20562a2 = m20562a(m20549c);
        StrokeGradientDrawable m20562a3 = m20562a(m20552b);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f32516g = stateListDrawable;
        stateListDrawable.addState(new int[]{16842919}, m20562a3.m20514a());
        this.f32516g.addState(new int[]{16842908}, m20562a2.m20514a());
        this.f32516g.addState(new int[]{-16842910}, m20562a.m20514a());
        this.f32516g.addState(StateSet.WILD_CARD, this.f32510a.m20514a());
    }

    /* renamed from: c */
    private int m20549c(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842908}, 0);
    }

    /* renamed from: c */
    private MorphingAnimation m20550c() {
        this.f32533x = true;
        MorphingAnimation morphingAnimation = new MorphingAnimation(this, this.f32510a);
        morphingAnimation.m20533a(this.f32528s);
        morphingAnimation.m20529b(this.f32528s);
        morphingAnimation.m20528b(getWidth());
        morphingAnimation.m20525c(getWidth());
        if (this.f32530u) {
            morphingAnimation.m20532a(1);
        } else {
            morphingAnimation.m20532a(500);
        }
        this.f32530u = false;
        return morphingAnimation;
    }

    /* renamed from: a */
    private void m20561a(Context context, AttributeSet attributeSet) {
        this.f32526q = 0;
        m20553b(context, attributeSet);
        this.f32531v = 100;
        this.f32520k = EnumC11762a.IDLE;
        this.f32519j = new StateManager(this);
        m20555b();
        setBackgroundCompat(this.f32516g);
    }

    public MBCircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32534y = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.1
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.PROGRESS;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32535z = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.2
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                if (MBCircularProgressButton.this.f32524o != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.m20558a(mBCircularProgressButton, mBCircularProgressButton.f32524o);
                }
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.COMPLETE;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32508A = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.3
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                MBCircularProgressButton.this.m20564a();
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.IDLE;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32509B = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.4
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                if (MBCircularProgressButton.this.f32525p != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.m20558a(mBCircularProgressButton, mBCircularProgressButton.f32525p);
                }
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.ERROR;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        m20561a(context, attributeSet);
    }

    /* renamed from: a */
    private int m20560a(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    /* renamed from: a */
    private StrokeGradientDrawable m20562a(int i) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(ResourceUtil.m21814a(getContext(), "mbridge_cpb_background", "drawable")).mutate();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(this.f32528s);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.m20512b(i);
        strokeGradientDrawable.m20513a(this.f32526q);
        return strokeGradientDrawable;
    }

    public MBCircularProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32534y = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.1
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.PROGRESS;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32535z = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.2
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                if (MBCircularProgressButton.this.f32524o != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.m20558a(mBCircularProgressButton, mBCircularProgressButton.f32524o);
                }
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.COMPLETE;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32508A = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.3
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                MBCircularProgressButton.this.m20564a();
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.IDLE;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        this.f32509B = new OnAnimationEndListener() { // from class: com.mbridge.msdk.widget.custom.baseview.MBCircularProgressButton.4
            @Override // com.mbridge.msdk.widget.custom.baseview.OnAnimationEndListener
            /* renamed from: a */
            public final void mo20517a() {
                if (MBCircularProgressButton.this.f32525p != 0) {
                    MBCircularProgressButton mBCircularProgressButton = MBCircularProgressButton.this;
                    MBCircularProgressButton.m20558a(mBCircularProgressButton, mBCircularProgressButton.f32525p);
                }
                MBCircularProgressButton.this.f32533x = false;
                MBCircularProgressButton.this.f32520k = EnumC11762a.ERROR;
                MBCircularProgressButton.this.f32519j.m20515b(MBCircularProgressButton.this);
            }
        };
        m20561a(context, attributeSet);
    }

    /* renamed from: b */
    private int m20552b(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842919}, 0);
    }

    /* renamed from: b */
    private void m20553b(Context context, AttributeSet attributeSet) {
        this.f32528s = 100.0f;
        this.f32527r = 0;
        int m20554b = m20554b(ResourceUtil.m21814a(context, "mbridge_cpb_green", "color"));
        int m20554b2 = m20554b(ResourceUtil.m21814a(context, "mbridge_cpb_white", "color"));
        int m20554b3 = m20554b(ResourceUtil.m21814a(context, "mbridge_cpb_grey", "color"));
        this.f32513d = getResources().getColorStateList(ResourceUtil.m21814a(context, "mbridge_cpb_idle_state_selector", "color"));
        this.f32514e = getResources().getColorStateList(ResourceUtil.m21814a(context, "mbridge_cpb_complete_state_selector", "color"));
        this.f32515f = getResources().getColorStateList(ResourceUtil.m21814a(context, "mbridge_cpb_error_state_selector", "color"));
        this.f32521l = m20554b2;
        this.f32522m = m20554b;
        this.f32523n = m20554b3;
    }

    /* renamed from: a */
    private MorphingAnimation m20563a(float f, float f2, int i, int i2) {
        this.f32533x = true;
        MorphingAnimation morphingAnimation = new MorphingAnimation(this, this.f32510a);
        morphingAnimation.m20533a(f);
        morphingAnimation.m20529b(f2);
        morphingAnimation.m20526c(this.f32527r);
        morphingAnimation.m20528b(i);
        morphingAnimation.m20525c(i2);
        if (this.f32530u) {
            morphingAnimation.m20532a(1);
        } else {
            morphingAnimation.m20532a(500);
        }
        this.f32530u = false;
        return morphingAnimation;
    }

    /* renamed from: a */
    protected final void m20564a() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(0, 0, 0, 0);
    }

    /* renamed from: a */
    static /* synthetic */ void m20558a(MBCircularProgressButton mBCircularProgressButton, int i) {
        Drawable drawable = mBCircularProgressButton.getResources().getDrawable(i);
        if (drawable != null) {
            mBCircularProgressButton.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            mBCircularProgressButton.setPadding((mBCircularProgressButton.getWidth() / 2) - (drawable.getIntrinsicWidth() / 2), 0, 0, 0);
        }
    }

    /* renamed from: b */
    private int m20554b(int i) {
        return getResources().getColor(i);
    }
}
