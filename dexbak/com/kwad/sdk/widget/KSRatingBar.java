package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.C9659R;
import java.math.BigDecimal;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSRatingBar extends LinearLayout {
    private boolean aSC;
    private boolean aSD;
    private int aSE;
    private int aSF;
    private InterfaceC11142a aSG;
    private float aSH;
    private float aSI;
    private float aSJ;
    private Drawable aSK;
    private Drawable aSL;
    private Drawable aSM;
    private boolean aSN;

    /* renamed from: y */
    private int f29689y;

    /* renamed from: com.kwad.sdk.widget.KSRatingBar$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11142a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29689y = 1;
        this.aSN = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(C9659R.C9661drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_KSRatingBar);
        this.aSM = obtainStyledAttributes.getDrawable(C9659R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aSK = obtainStyledAttributes.getDrawable(C9659R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aSL = obtainStyledAttributes.getDrawable(C9659R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aSH = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aSI = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aSJ = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aSE = obtainStyledAttributes.getInteger(C9659R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aSF = obtainStyledAttributes.getInteger(C9659R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aSC = obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aSD = obtainStyledAttributes.getBoolean(C9659R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i = 0; i < this.aSE; i++) {
            ImageView m23552w = m23552w(context, this.aSN);
            m23552w.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.aSC) {
                        if (KSRatingBar.this.aSD) {
                            if (KSRatingBar.this.f29689y % 2 == 0) {
                                KSRatingBar kSRatingBar = KSRatingBar.this;
                                kSRatingBar.setStar(kSRatingBar.indexOfChild(view) + 1.0f);
                            } else {
                                KSRatingBar kSRatingBar2 = KSRatingBar.this;
                                kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 0.5f);
                            }
                            if (KSRatingBar.this.aSG != null) {
                                if (KSRatingBar.this.f29689y % 2 == 0) {
                                    InterfaceC11142a unused = KSRatingBar.this.aSG;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.m23553e(KSRatingBar.this);
                                    return;
                                }
                                InterfaceC11142a unused2 = KSRatingBar.this.aSG;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.m23553e(KSRatingBar.this);
                                return;
                            }
                            return;
                        }
                        KSRatingBar kSRatingBar3 = KSRatingBar.this;
                        kSRatingBar3.setStar(kSRatingBar3.indexOfChild(view) + 1.0f);
                        if (KSRatingBar.this.aSG != null) {
                            InterfaceC11142a unused3 = KSRatingBar.this.aSG;
                            KSRatingBar.this.indexOfChild(view);
                        }
                    }
                }
            });
            addView(m23552w);
        }
        setStar(this.aSF);
    }

    /* renamed from: e */
    static /* synthetic */ int m23553e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.f29689y;
        kSRatingBar.f29689y = i + 1;
        return i;
    }

    /* renamed from: w */
    private ImageView m23552w(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aSH), Math.round(this.aSI)));
        imageView.setPadding(0, 0, Math.round(this.aSJ), 0);
        if (z) {
            imageView.setImageDrawable(this.aSK);
        } else {
            imageView.setImageDrawable(this.aSL);
        }
        return imageView;
    }

    public void setImagePadding(float f) {
        this.aSJ = f;
    }

    public void setOnRatingChangeListener(InterfaceC11142a interfaceC11142a) {
        this.aSG = interfaceC11142a;
    }

    public void setStar(float f) {
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.aSE;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.aSL);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.aSM);
            int i4 = this.aSE;
            while (true) {
                i4--;
                if (i4 < 1.0f + f2) {
                    return;
                }
                ((ImageView) getChildAt(i4)).setImageDrawable(this.aSK);
            }
        } else {
            int i5 = this.aSE;
            while (true) {
                i5--;
                if (i5 < f2) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.aSK);
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aSK = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aSL = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aSM = drawable;
    }

    public void setStarImageHeight(float f) {
        this.aSI = f;
    }

    public void setStarImageWidth(float f) {
        this.aSH = f;
    }

    public void setTotalStarCount(int i) {
        this.aSE = i;
    }

    public void setmClickable(boolean z) {
        this.aSC = z;
    }
}
