package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBRelativeLayout extends RelativeLayout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBRelativeLayout$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117681 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32554a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32554a = iArr;
            try {
                iArr[ParamValue.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32554a[ParamValue.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32554a[ParamValue.gravity.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32554a[ParamValue.contentDescription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32554a[ParamValue.paddingRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32554a[ParamValue.layout_width.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32554a[ParamValue.layout_height.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32554a[ParamValue.layout_centerHorizontal.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32554a[ParamValue.layout_alignParentBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32554a[ParamValue.layout_alignParentTop.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f32554a[ParamValue.layout_centerVertical.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f32554a[ParamValue.layout_below.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f32554a[ParamValue.layout_above.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f32554a[ParamValue.layout_toLeftOf.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f32554a[ParamValue.layout_toRightOf.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f32554a[ParamValue.layout_marginLeft.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f32554a[ParamValue.layout_marginRight.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f32554a[ParamValue.layout_marginTop.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f32554a[ParamValue.layout_marginBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f32554a[ParamValue.layout_alignParentRight.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f32554a[ParamValue.layout_alignParentLeft.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    public MBRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt instanceof MBLinearLayout) {
                MBLinearLayout mBLinearLayout = (MBLinearLayout) childAt;
                for (int i6 = 0; i6 < mBLinearLayout.getChildCount(); i6++) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) mBLinearLayout.getChildAt(i6).getLayoutParams();
                }
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                int i2 = C117681.f32554a[paramValue.ordinal()];
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
                        setBackgroundResource(ResourceUtil.m21814a(getContext(), attributeValue2, "drawable"));
                    }
                } else if (i2 == 3) {
                    setGravity(MBResource.m20600a().m20592d(attributeSet.getAttributeValue(i)));
                } else if (i2 == 4) {
                    setContentDescription(attributeSet.getAttributeValue(i));
                } else if (i2 == 5) {
                    String attributeValue3 = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue3)) {
                        setPadding(getPaddingLeft(), getPaddingTop(), MBResource.m20600a().m20594c(attributeValue3), getPaddingBottom());
                    }
                }
            }
        }
    }

    public MBRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context);
        setAttributeSet(attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        HashMap m20597b = MBResource.m20600a().m20597b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = (ParamValue) m20597b.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                switch (C117681.f32554a[paramValue.ordinal()]) {
                    case 6:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith(TTLogUtil.TAG_EVENT_FILL) && !attributeValue.startsWith("match")) {
                            if (attributeValue.startsWith(IAdInterListener.AdReqParam.WIDTH)) {
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
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith(TTLogUtil.TAG_EVENT_FILL) && !attributeValue2.startsWith("match")) {
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
                    case 8:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(14, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(12, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(10, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(15, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (attributeValue3.startsWith("@id")) {
                            layoutParams.addRule(3, attributeValue3.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        String attributeValue4 = attributeSet.getAttributeValue(i);
                        if (attributeValue4.startsWith("@id")) {
                            layoutParams.addRule(2, attributeValue4.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        String attributeValue5 = attributeSet.getAttributeValue(i);
                        if (attributeValue5.startsWith("@id")) {
                            layoutParams.addRule(0, attributeValue5.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        String attributeValue6 = attributeSet.getAttributeValue(i);
                        if (attributeValue6.startsWith("@id")) {
                            layoutParams.addRule(1, attributeValue6.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        layoutParams.leftMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 17:
                        layoutParams.rightMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 18:
                        layoutParams.topMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 19:
                        layoutParams.bottomMargin = MBResource.m20600a().m20594c(attributeSet.getAttributeValue(i));
                        continue;
                    case 20:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(11, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 21:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(9, -1);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
        return layoutParams;
    }

    public MBRelativeLayout(Context context) {
        super(context);
    }
}
