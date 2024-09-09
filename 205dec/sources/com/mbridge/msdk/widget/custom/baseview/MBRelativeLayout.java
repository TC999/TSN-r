package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.mbridge.msdk.foundation.tools.r;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBRelativeLayout extends RelativeLayout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBRelativeLayout$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41241a;

        static {
            int[] iArr = new int[com.mbridge.msdk.widget.custom.a.c.values().length];
            f41241a = iArr;
            try {
                iArr[com.mbridge.msdk.widget.custom.a.c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.gravity.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.contentDescription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.paddingRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_width.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_height.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_centerHorizontal.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_alignParentBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_alignParentTop.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_centerVertical.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_below.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_above.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_toLeftOf.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_toRightOf.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_marginLeft.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_marginRight.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_marginTop.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_marginBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_alignParentRight.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f41241a[com.mbridge.msdk.widget.custom.a.c.layout_alignParentLeft.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    public MBRelativeLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt instanceof MBLinearLayout) {
                MBLinearLayout mBLinearLayout = (MBLinearLayout) childAt;
                for (int i9 = 0; i9 < mBLinearLayout.getChildCount(); i9++) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) mBLinearLayout.getChildAt(i9).getLayoutParams();
                }
            }
        }
        super.onLayout(z3, i4, i5, i6, i7);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f41241a[cVar.ordinal()];
                if (i5 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (attributeValue.startsWith("@+id/")) {
                        setId(attributeValue.substring(5).hashCode());
                    }
                } else if (i5 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i4);
                    if (attributeValue2.startsWith("#")) {
                        setBackgroundColor(com.mbridge.msdk.widget.custom.a.b.a().b(attributeSet.getAttributeValue(i4)));
                    } else {
                        if (attributeValue2.startsWith("@drawable/")) {
                            attributeValue2 = attributeValue2.substring(10);
                        }
                        setBackgroundResource(r.a(getContext(), attributeValue2, "drawable"));
                    }
                } else if (i5 == 3) {
                    setGravity(com.mbridge.msdk.widget.custom.a.b.a().d(attributeSet.getAttributeValue(i4)));
                } else if (i5 == 4) {
                    setContentDescription(attributeSet.getAttributeValue(i4));
                } else if (i5 == 5) {
                    String attributeValue3 = attributeSet.getAttributeValue(i4);
                    if (!TextUtils.isEmpty(attributeValue3)) {
                        setPadding(getPaddingLeft(), getPaddingTop(), com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue3), getPaddingBottom());
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
        HashMap b4 = com.mbridge.msdk.widget.custom.a.b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = (com.mbridge.msdk.widget.custom.a.c) b4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                switch (AnonymousClass1.f41241a[cVar.ordinal()]) {
                    case 6:
                        String attributeValue = attributeSet.getAttributeValue(i4);
                        if (!attributeValue.startsWith(TTLogUtil.TAG_EVENT_FILL) && !attributeValue.startsWith("match")) {
                            if (attributeValue.startsWith("w")) {
                                layoutParams.width = -2;
                                break;
                            } else {
                                layoutParams.width = com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue);
                                break;
                            }
                        } else {
                            layoutParams.width = -1;
                            continue;
                        }
                        break;
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i4);
                        if (!attributeValue2.startsWith(TTLogUtil.TAG_EVENT_FILL) && !attributeValue2.startsWith("match")) {
                            if (attributeValue2.startsWith("wrap")) {
                                layoutParams.height = -2;
                                continue;
                            } else {
                                layoutParams.height = com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue2);
                                break;
                            }
                        } else {
                            layoutParams.height = -1;
                            break;
                        }
                    case 8:
                        if (attributeSet.getAttributeBooleanValue(i4, false)) {
                            layoutParams.addRule(14, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if (attributeSet.getAttributeBooleanValue(i4, false)) {
                            layoutParams.addRule(12, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if (attributeSet.getAttributeBooleanValue(i4, false)) {
                            layoutParams.addRule(10, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if (attributeSet.getAttributeBooleanValue(i4, false)) {
                            layoutParams.addRule(15, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        String attributeValue3 = attributeSet.getAttributeValue(i4);
                        if (attributeValue3.startsWith("@id")) {
                            layoutParams.addRule(3, attributeValue3.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        String attributeValue4 = attributeSet.getAttributeValue(i4);
                        if (attributeValue4.startsWith("@id")) {
                            layoutParams.addRule(2, attributeValue4.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        String attributeValue5 = attributeSet.getAttributeValue(i4);
                        if (attributeValue5.startsWith("@id")) {
                            layoutParams.addRule(0, attributeValue5.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        String attributeValue6 = attributeSet.getAttributeValue(i4);
                        if (attributeValue6.startsWith("@id")) {
                            layoutParams.addRule(1, attributeValue6.substring(4).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        layoutParams.leftMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 17:
                        layoutParams.rightMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 18:
                        layoutParams.topMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 19:
                        layoutParams.bottomMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 20:
                        if (attributeSet.getAttributeBooleanValue(i4, false)) {
                            layoutParams.addRule(11, -1);
                            break;
                        } else {
                            continue;
                        }
                    case 21:
                        if (attributeSet.getAttributeBooleanValue(i4, false)) {
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
