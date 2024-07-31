package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.GridView;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import com.mbridge.msdk.widget.custom.p517b.DensityUtil;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBGridView extends GridView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBGridView$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117641 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32550a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32550a = iArr;
            try {
                iArr[ParamValue.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32550a[ParamValue.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32550a[ParamValue.fadingEdge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32550a[ParamValue.visibility.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32550a[ParamValue.id.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32550a[ParamValue.verticalSpacing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32550a[ParamValue.numColumns.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32550a[ParamValue.splitMotionEvents.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32550a[ParamValue.cacheColorHint.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32550a[ParamValue.horizontalSpacing.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public MBGridView(Context context, AttributeSet attributeSet) {
        super(context);
        setAttributeSet(attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                switch (C117641.f32550a[paramValue.ordinal()]) {
                    case 5:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            continue;
                        }
                    case 6:
                        setVerticalSpacing(DensityUtil.m20577b(getContext(), MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i))));
                        continue;
                    case 7:
                        setNumColumns(attributeSet.getAttributeIntValue(i, 2));
                        continue;
                    case 8:
                        setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i).equals("false"));
                        continue;
                    case 9:
                        setCacheColorHint(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i)));
                        continue;
                    case 10:
                        setHorizontalSpacing(DensityUtil.m20577b(getContext(), MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i))));
                        continue;
                }
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public AbsListView.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                int i2 = C117641.f32550a[paramValue.ordinal()];
                if (i2 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                        if (attributeValue.startsWith("wrap")) {
                            layoutParams.width = -2;
                        } else {
                            layoutParams.width = MBResource.m20600a().m20594c(attributeValue);
                        }
                    } else {
                        layoutParams.width = -1;
                    }
                } else if (i2 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                        if (attributeValue2.startsWith("wrap")) {
                            layoutParams.height = -2;
                        } else {
                            layoutParams.height = MBResource.m20600a().m20594c(attributeValue2);
                        }
                    } else {
                        layoutParams.height = -1;
                    }
                } else if (i2 == 3) {
                    setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i, false));
                } else if (i2 == 4) {
                    String attributeValue3 = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue3)) {
                        if (attributeValue3.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue3.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                }
            }
        }
        return layoutParams;
    }
}
