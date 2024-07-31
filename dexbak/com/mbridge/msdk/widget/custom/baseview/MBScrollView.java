package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBScrollView extends ScrollView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBScrollView$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117691 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32556a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32556a = iArr;
            try {
                iArr[ParamValue.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32556a[ParamValue.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32556a[ParamValue.contentDescription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32556a[ParamValue.fadingEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32556a[ParamValue.visibility.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32556a[ParamValue.layout_marginBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32556a[ParamValue.layout_above.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public MBScrollView(Context context, AttributeSet attributeSet) {
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
                int i2 = C117691.f32556a[paramValue.ordinal()];
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
                } else if (i2 == 3) {
                    setContentDescription(attributeSet.getAttributeValue(i));
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                int i2 = C117691.f32556a[paramValue.ordinal()];
                if (i2 == 4) {
                    setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i, false));
                } else if (i2 == 5) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equalsIgnoreCase("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        } else if (attributeValue.equalsIgnoreCase("visible")) {
                            setVisibility(0);
                        }
                    }
                } else if (i2 == 6) {
                    generateDefaultLayoutParams.bottomMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                }
            }
        }
        return generateDefaultLayoutParams;
    }
}
