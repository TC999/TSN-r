package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KSRatingBar extends LinearLayout {
    private boolean aSC;
    private boolean aSD;
    private int aSE;
    private int aSF;
    private a aSG;
    private float aSH;
    private float aSI;
    private float aSJ;
    private Drawable aSK;
    private Drawable aSL;
    private Drawable aSM;
    private boolean aSN;

    /* renamed from: y  reason: collision with root package name */
    private int f38659y;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38659y = 1;
        this.aSN = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.aSM = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aSK = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aSL = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aSH = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aSI = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aSJ = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aSE = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aSF = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aSC = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aSD = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i4 = 0; i4 < this.aSE; i4++) {
            ImageView w3 = w(context, this.aSN);
            w3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.aSC) {
                        if (KSRatingBar.this.aSD) {
                            if (KSRatingBar.this.f38659y % 2 == 0) {
                                KSRatingBar kSRatingBar = KSRatingBar.this;
                                kSRatingBar.setStar(kSRatingBar.indexOfChild(view) + 1.0f);
                            } else {
                                KSRatingBar kSRatingBar2 = KSRatingBar.this;
                                kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 0.5f);
                            }
                            if (KSRatingBar.this.aSG != null) {
                                if (KSRatingBar.this.f38659y % 2 == 0) {
                                    a unused = KSRatingBar.this.aSG;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                }
                                a unused2 = KSRatingBar.this.aSG;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.e(KSRatingBar.this);
                                return;
                            }
                            return;
                        }
                        KSRatingBar kSRatingBar3 = KSRatingBar.this;
                        kSRatingBar3.setStar(kSRatingBar3.indexOfChild(view) + 1.0f);
                        if (KSRatingBar.this.aSG != null) {
                            a unused3 = KSRatingBar.this.aSG;
                            KSRatingBar.this.indexOfChild(view);
                        }
                    }
                }
            });
            addView(w3);
        }
        setStar(this.aSF);
    }

    static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i4 = kSRatingBar.f38659y;
        kSRatingBar.f38659y = i4 + 1;
        return i4;
    }

    private ImageView w(Context context, boolean z3) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aSH), Math.round(this.aSI)));
        imageView.setPadding(0, 0, Math.round(this.aSJ), 0);
        if (z3) {
            imageView.setImageDrawable(this.aSK);
        } else {
            imageView.setImageDrawable(this.aSL);
        }
        return imageView;
    }

    public void setImagePadding(float f4) {
        this.aSJ = f4;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aSG = aVar;
    }

    public void setStar(float f4) {
        int i4 = (int) f4;
        float floatValue = new BigDecimal(Float.toString(f4)).subtract(new BigDecimal(Integer.toString(i4))).floatValue();
        int i5 = this.aSE;
        float f5 = i4 > i5 ? i5 : i4;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        for (int i6 = 0; i6 < f5; i6++) {
            ((ImageView) getChildAt(i6)).setImageDrawable(this.aSL);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.aSM);
            int i7 = this.aSE;
            while (true) {
                i7--;
                if (i7 < 1.0f + f5) {
                    return;
                }
                ((ImageView) getChildAt(i7)).setImageDrawable(this.aSK);
            }
        } else {
            int i8 = this.aSE;
            while (true) {
                i8--;
                if (i8 < f5) {
                    return;
                }
                ((ImageView) getChildAt(i8)).setImageDrawable(this.aSK);
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

    public void setStarImageHeight(float f4) {
        this.aSI = f4;
    }

    public void setStarImageWidth(float f4) {
        this.aSH = f4;
    }

    public void setTotalStarCount(int i4) {
        this.aSE = i4;
    }

    public void setmClickable(boolean z3) {
        this.aSC = z3;
    }
}
