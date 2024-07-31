package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBButton extends MBCircularProgressButton {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBButton$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117551 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32507a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32507a = iArr;
            try {
                iArr[ParamValue.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32507a[ParamValue.text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32507a[ParamValue.ellipsize.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32507a[ParamValue.fadingEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32507a[ParamValue.scrollHorizontally.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32507a[ParamValue.textColor.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32507a[ParamValue.textSize.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32507a[ParamValue.visibility.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32507a[ParamValue.background.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32507a[ParamValue.textStyle.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f32507a[ParamValue.style.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f32507a[ParamValue.src.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f32507a[ParamValue.contentDescription.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f32507a[ParamValue.gravity.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f32507a[ParamValue.paddingBottom.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f32507a[ParamValue.paddingTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f32507a[ParamValue.letterSpacing.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public MBButton(Context context, AttributeSet attributeSet) {
        super(context);
        setAttributeSet(attributeSet);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                switch (C117551.f32507a[paramValue.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            continue;
                        }
                    case 2:
                        setText(MBResource.m20600a().m20591e(attributeSet.getAttributeValue(i)));
                        continue;
                    case 3:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
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
                        setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i, false));
                        continue;
                    case 5:
                        setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i, false));
                        continue;
                    case 6:
                        setTextColor(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i)));
                        continue;
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue2)) {
                            setTextSize(MBResource.m20600a().m20594c(attributeValue2));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
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
                        String attributeValue4 = attributeSet.getAttributeValue(i);
                        if (attributeValue4.startsWith("#")) {
                            setBackgroundColor(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i)));
                            continue;
                        } else {
                            if (attributeValue4.startsWith("@drawable/")) {
                                attributeValue4 = attributeValue4.substring(10);
                            }
                            String file = getContext().getFilesDir().toString();
                            setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(file + "/" + attributeValue4 + PhotoBitmapUtils.f15141c)));
                            break;
                        }
                    case 10:
                        if ("bold".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                            setTypeface(Typeface.defaultFromStyle(1));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        String attributeValue5 = attributeSet.getAttributeValue(i);
                        String substring = attributeValue5.substring(attributeValue5.indexOf("/") + 1);
                        MBResource m20600a = MBResource.m20600a();
                        Context context = getContext();
                        setTextAppearance(getContext(), m20600a.m20599a(context, "R.style." + substring));
                        continue;
                    case 13:
                        setContentDescription(attributeSet.getAttributeValue(i));
                        continue;
                    case 14:
                        setGravity(17);
                        continue;
                    case 15:
                        String attributeValue6 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue6)) {
                            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), MBResource.m20600a().m20594c(attributeValue6));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        String attributeValue7 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue7)) {
                            setPadding(getPaddingLeft(), MBResource.m20600a().m20594c(attributeValue7), getPaddingRight(), getPaddingBottom());
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        String attributeValue8 = attributeSet.getAttributeValue(i);
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
