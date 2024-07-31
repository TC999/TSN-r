package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBFrameLayout extends FrameLayout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBFrameLayout$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117631 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32549a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32549a = iArr;
            try {
                iArr[ParamValue.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32549a[ParamValue.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32549a[ParamValue.layout_gravity.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32549a[ParamValue.layout_marginLeft.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32549a[ParamValue.layout_margin.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MBFrameLayout(Context context, AttributeSet attributeSet) {
        super(context);
        setLayoutParams(generateLayoutParams(attributeSet));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap m20597b = MBResource.m20600a().m20597b();
        generateDefaultLayoutParams.width = -2;
        generateDefaultLayoutParams.height = -2;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = (ParamValue) m20597b.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                int i2 = C117631.f32549a[paramValue.ordinal()];
                if (i2 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                        if (attributeValue.startsWith(IAdInterListener.AdReqParam.WIDTH)) {
                            generateDefaultLayoutParams.width = -2;
                        } else {
                            generateDefaultLayoutParams.width = MBResource.m20600a().m20594c(attributeValue);
                        }
                    } else {
                        generateDefaultLayoutParams.width = -1;
                    }
                } else if (i2 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                        if (attributeValue2.startsWith(IAdInterListener.AdReqParam.WIDTH)) {
                            generateDefaultLayoutParams.width = -2;
                        } else {
                            generateDefaultLayoutParams.height = MBResource.m20600a().m20594c(attributeValue2);
                        }
                    } else {
                        generateDefaultLayoutParams.width = -1;
                    }
                } else if (i2 == 3) {
                    generateDefaultLayoutParams.gravity = MBResource.m20600a().m20592d(attributeSet.getAttributeValue(i));
                } else if (i2 == 4) {
                    generateDefaultLayoutParams.leftMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                } else if (i2 == 5) {
                    int m20594c = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                    generateDefaultLayoutParams.setMargins(m20594c, m20594c, m20594c, m20594c);
                }
            }
        }
        return generateDefaultLayoutParams;
    }
}
