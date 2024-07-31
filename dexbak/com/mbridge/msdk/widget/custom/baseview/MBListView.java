package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBListView extends ListView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBListView$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117671 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32553a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32553a = iArr;
            try {
                iArr[ParamValue.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32553a[ParamValue.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32553a[ParamValue.fadingEdge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32553a[ParamValue.visibility.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32553a[ParamValue.layout_marginTop.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32553a[ParamValue.layout_marginLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32553a[ParamValue.layout_marginRight.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32553a[ParamValue.layout_marginBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32553a[ParamValue.id.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32553a[ParamValue.divider.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f32553a[ParamValue.splitMotionEvents.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public MBListView(Context context, AttributeSet attributeSet) {
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
                switch (C117671.f32553a[paramValue.ordinal()]) {
                    case 9:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            continue;
                        }
                    case 10:
                        setDivider(new ColorDrawable(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i))));
                        continue;
                    case 11:
                        setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i).equals("false"));
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
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < attributeCount; i5++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i5));
            if (paramValue != null) {
                switch (C117671.f32553a[paramValue.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i5);
                        if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                            if (attributeValue.startsWith("wrap")) {
                                layoutParams.width = -2;
                                break;
                            } else {
                                layoutParams.width = MBResource.m20600a().m20594c(attributeValue);
                                break;
                            }
                        } else {
                            layoutParams.width = -1;
                            continue;
                        }
                        break;
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                            if (attributeValue2.startsWith("wrap")) {
                                layoutParams.height = -2;
                                continue;
                            } else {
                                layoutParams.height = MBResource.m20600a().m20594c(attributeValue2);
                                break;
                            }
                        } else {
                            layoutParams.height = -1;
                            break;
                        }
                    case 3:
                        setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i5, false));
                        continue;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i5);
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
                    case 5:
                        i2 = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i5));
                        continue;
                    case 6:
                        i = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i5));
                        continue;
                    case 7:
                        i3 = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i5));
                        continue;
                    case 8:
                        i4 = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i5));
                        continue;
                }
            }
        }
        setPadding(i, i2, i3, i4);
        return layoutParams;
    }
}
