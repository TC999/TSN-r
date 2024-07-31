package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBLinearLayout extends LinearLayout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBLinearLayout$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117661 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32552a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32552a = iArr;
            try {
                iArr[ParamValue.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32552a[ParamValue.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32552a[ParamValue.orientation.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32552a[ParamValue.visibility.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32552a[ParamValue.contentDescription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32552a[ParamValue.layout_width.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32552a[ParamValue.layout_height.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32552a[ParamValue.layout_centerHorizontal.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32552a[ParamValue.layout_centerVertical.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32552a[ParamValue.layout_weight.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f32552a[ParamValue.gravity.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f32552a[ParamValue.layout_margin.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f32552a[ParamValue.layout_marginLeft.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f32552a[ParamValue.layout_marginRight.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f32552a[ParamValue.layout_marginTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f32552a[ParamValue.layout_marginBottom.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f32552a[ParamValue.layout_gravity.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public MBLinearLayout(Context context, AttributeSet attributeSet) {
        super(context);
        setAttributeSet(attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                int i2 = C117661.f32552a[paramValue.ordinal()];
                if (i2 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeValue.startsWith("@+id/")) {
                        setId(attributeValue.substring(5).hashCode());
                    }
                } else if (i2 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (attributeValue2.startsWith("#")) {
                        setBackgroundColor(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i)));
                    } else {
                        if (attributeValue2.startsWith("@drawable/")) {
                            attributeValue2 = attributeValue2.substring(10);
                        }
                        String file = getContext().getFilesDir().toString();
                        setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(file + "/" + attributeValue2 + PhotoBitmapUtils.f15141c)));
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue3)) {
                            if (attributeValue3.equalsIgnoreCase("visible")) {
                                setVisibility(0);
                            } else if (attributeValue3.equalsIgnoreCase("gone")) {
                                setVisibility(8);
                            } else if (attributeValue3.equalsIgnoreCase("visible")) {
                                setVisibility(0);
                            }
                        }
                    } else if (i2 == 5) {
                        setContentDescription(attributeSet.getAttributeValue(i));
                    }
                } else if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                    setOrientation(0);
                } else {
                    setOrientation(1);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap m20597b = MBResource.m20600a().m20597b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = (ParamValue) m20597b.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                switch (C117661.f32552a[paramValue.ordinal()]) {
                    case 6:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                            if (attributeValue.startsWith("wrap")) {
                                generateDefaultLayoutParams.width = -2;
                                break;
                            } else {
                                generateDefaultLayoutParams.width = MBResource.m20600a().m20594c(attributeValue);
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.width = -1;
                            continue;
                        }
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                            if (attributeValue2.startsWith("wrap")) {
                                generateDefaultLayoutParams.height = -2;
                                continue;
                            } else {
                                generateDefaultLayoutParams.height = MBResource.m20600a().m20594c(attributeValue2);
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.height = -1;
                            break;
                        }
                        break;
                    case 8:
                        generateDefaultLayoutParams.gravity = 1;
                        continue;
                    case 9:
                        generateDefaultLayoutParams.gravity = 16;
                        continue;
                    case 10:
                        generateDefaultLayoutParams.weight = attributeSet.getAttributeFloatValue(i, 0.0f);
                        continue;
                    case 11:
                        setGravity(MBResource.m20600a().m20592d(attributeSet.getAttributeValue(i)));
                        continue;
                    case 12:
                        int m20594c = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        generateDefaultLayoutParams.bottomMargin = m20594c;
                        generateDefaultLayoutParams.leftMargin = m20594c;
                        generateDefaultLayoutParams.rightMargin = m20594c;
                        generateDefaultLayoutParams.topMargin = m20594c;
                        continue;
                    case 13:
                        generateDefaultLayoutParams.leftMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 14:
                        generateDefaultLayoutParams.rightMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 15:
                        generateDefaultLayoutParams.topMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 16:
                        generateDefaultLayoutParams.bottomMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 17:
                        generateDefaultLayoutParams.gravity = MBResource.m20600a().m20592d(attributeSet.getAttributeValue(i));
                        continue;
                }
            }
        }
        return generateDefaultLayoutParams;
    }
}
