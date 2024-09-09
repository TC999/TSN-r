package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBListView extends ListView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBListView$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41240a;

        static {
            int[] iArr = new int[com.mbridge.msdk.widget.custom.a.c.values().length];
            f41240a = iArr;
            try {
                iArr[com.mbridge.msdk.widget.custom.a.c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.fadingEdge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.visibility.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.layout_marginTop.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.layout_marginLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.layout_marginRight.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.layout_marginBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.id.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.divider.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41240a[com.mbridge.msdk.widget.custom.a.c.splitMotionEvents.ordinal()] = 11;
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
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                switch (AnonymousClass1.f41240a[cVar.ordinal()]) {
                    case 9:
                        String attributeValue = attributeSet.getAttributeValue(i4);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            continue;
                        }
                    case 10:
                        setDivider(new ColorDrawable(com.mbridge.msdk.widget.custom.a.b.a().b(attributeSet.getAttributeValue(i4))));
                        continue;
                    case 11:
                        setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i4).equals("false"));
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
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < attributeCount; i8++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i8));
            if (cVar != null) {
                switch (AnonymousClass1.f41240a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i8);
                        if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                            if (attributeValue.startsWith("wrap")) {
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
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i8);
                        if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
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
                    case 3:
                        setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i8, false));
                        continue;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i8);
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
                        i5 = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i8));
                        continue;
                    case 6:
                        i4 = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i8));
                        continue;
                    case 7:
                        i6 = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i8));
                        continue;
                    case 8:
                        i7 = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i8));
                        continue;
                }
            }
        }
        setPadding(i4, i5, i6, i7);
        return layoutParams;
    }
}
