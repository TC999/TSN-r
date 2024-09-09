package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.GridView;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBGridView extends GridView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBGridView$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41237a;

        static {
            int[] iArr = new int[com.mbridge.msdk.widget.custom.a.c.values().length];
            f41237a = iArr;
            try {
                iArr[com.mbridge.msdk.widget.custom.a.c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.fadingEdge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.visibility.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.id.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.verticalSpacing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.numColumns.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.splitMotionEvents.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.cacheColorHint.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41237a[com.mbridge.msdk.widget.custom.a.c.horizontalSpacing.ordinal()] = 10;
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
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                switch (AnonymousClass1.f41237a[cVar.ordinal()]) {
                    case 5:
                        String attributeValue = attributeSet.getAttributeValue(i4);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            continue;
                        }
                    case 6:
                        setVerticalSpacing(com.mbridge.msdk.widget.custom.b.a.b(getContext(), com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4))));
                        continue;
                    case 7:
                        setNumColumns(attributeSet.getAttributeIntValue(i4, 2));
                        continue;
                    case 8:
                        setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i4).equals("false"));
                        continue;
                    case 9:
                        setCacheColorHint(com.mbridge.msdk.widget.custom.a.b.a().b(attributeSet.getAttributeValue(i4)));
                        continue;
                    case 10:
                        setHorizontalSpacing(com.mbridge.msdk.widget.custom.b.a.b(getContext(), com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4))));
                        continue;
                }
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public AbsListView.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f41237a[cVar.ordinal()];
                if (i5 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                        if (attributeValue.startsWith("wrap")) {
                            layoutParams.width = -2;
                        } else {
                            layoutParams.width = com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue);
                        }
                    } else {
                        layoutParams.width = -1;
                    }
                } else if (i5 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i4);
                    if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                        if (attributeValue2.startsWith("wrap")) {
                            layoutParams.height = -2;
                        } else {
                            layoutParams.height = com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue2);
                        }
                    } else {
                        layoutParams.height = -1;
                    }
                } else if (i5 == 3) {
                    setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i4, false));
                } else if (i5 == 4) {
                    String attributeValue3 = attributeSet.getAttributeValue(i4);
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
