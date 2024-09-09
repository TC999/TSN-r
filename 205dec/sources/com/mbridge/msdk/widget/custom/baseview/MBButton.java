package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBButton extends MBCircularProgressButton {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBButton$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41196a;

        static {
            int[] iArr = new int[com.mbridge.msdk.widget.custom.a.c.values().length];
            f41196a = iArr;
            try {
                iArr[com.mbridge.msdk.widget.custom.a.c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.ellipsize.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.fadingEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.scrollHorizontally.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.textColor.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.textSize.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.visibility.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.background.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.textStyle.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.style.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.src.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.contentDescription.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.gravity.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.paddingBottom.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.paddingTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41196a[com.mbridge.msdk.widget.custom.a.c.letterSpacing.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public MBButton(Context context, AttributeSet attributeSet) {
        super(context);
        setAttributeSet(attributeSet);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                switch (AnonymousClass1.f41196a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i4);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            continue;
                        }
                    case 2:
                        setText(com.mbridge.msdk.widget.custom.a.b.a().e(attributeSet.getAttributeValue(i4)));
                        continue;
                    case 3:
                        if (attributeSet.getAttributeBooleanValue(i4, false)) {
                            setFocusable(true);
                            setFocusableInTouchMode(true);
                            setSingleLine(true);
                            setEllipsize(TextUtils.TruncateAt.MARQUEE);
                            setMarqueeRepeatLimit(1000);
                            setSingleLine();
                            setHorizontallyScrolling(true);
                            requestFocus();
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i4, false));
                        continue;
                    case 5:
                        setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i4, false));
                        continue;
                    case 6:
                        setTextColor(com.mbridge.msdk.widget.custom.a.b.a().b(attributeSet.getAttributeValue(i4)));
                        continue;
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i4);
                        if (!TextUtils.isEmpty(attributeValue2)) {
                            setTextSize(com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue2));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        String attributeValue3 = attributeSet.getAttributeValue(i4);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            continue;
                        } else if (attributeValue3.equals("invisible")) {
                            setVisibility(4);
                            break;
                        } else if (attributeValue3.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        String attributeValue4 = attributeSet.getAttributeValue(i4);
                        if (attributeValue4.startsWith("#")) {
                            setBackgroundColor(com.mbridge.msdk.widget.custom.a.b.a().b(attributeSet.getAttributeValue(i4)));
                            continue;
                        } else {
                            if (attributeValue4.startsWith("@drawable/")) {
                                attributeValue4 = attributeValue4.substring(10);
                            }
                            String file = getContext().getFilesDir().toString();
                            setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(file + TTPathConst.sSeparator + attributeValue4 + ".png")));
                            break;
                        }
                    case 10:
                        if ("bold".equalsIgnoreCase(attributeSet.getAttributeValue(i4))) {
                            setTypeface(Typeface.defaultFromStyle(1));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        String attributeValue5 = attributeSet.getAttributeValue(i4);
                        String substring = attributeValue5.substring(attributeValue5.indexOf(TTPathConst.sSeparator) + 1);
                        com.mbridge.msdk.widget.custom.a.b a4 = com.mbridge.msdk.widget.custom.a.b.a();
                        Context context = getContext();
                        setTextAppearance(getContext(), a4.a(context, "R.style." + substring));
                        continue;
                    case 13:
                        setContentDescription(attributeSet.getAttributeValue(i4));
                        continue;
                    case 14:
                        setGravity(17);
                        continue;
                    case 15:
                        String attributeValue6 = attributeSet.getAttributeValue(i4);
                        if (!TextUtils.isEmpty(attributeValue6)) {
                            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue6));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        String attributeValue7 = attributeSet.getAttributeValue(i4);
                        if (!TextUtils.isEmpty(attributeValue7)) {
                            setPadding(getPaddingLeft(), com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue7), getPaddingRight(), getPaddingBottom());
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        String attributeValue8 = attributeSet.getAttributeValue(i4);
                        if (TextUtils.isEmpty(attributeValue8)) {
                            continue;
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            setLetterSpacing(Float.parseFloat(attributeValue8));
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
    }
}
