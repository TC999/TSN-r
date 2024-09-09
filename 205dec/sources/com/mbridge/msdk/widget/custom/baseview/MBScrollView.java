package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBScrollView extends ScrollView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBScrollView$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41243a;

        static {
            int[] iArr = new int[com.mbridge.msdk.widget.custom.a.c.values().length];
            f41243a = iArr;
            try {
                iArr[com.mbridge.msdk.widget.custom.a.c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41243a[com.mbridge.msdk.widget.custom.a.c.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41243a[com.mbridge.msdk.widget.custom.a.c.contentDescription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41243a[com.mbridge.msdk.widget.custom.a.c.fadingEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41243a[com.mbridge.msdk.widget.custom.a.c.visibility.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41243a[com.mbridge.msdk.widget.custom.a.c.layout_marginBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41243a[com.mbridge.msdk.widget.custom.a.c.layout_above.ordinal()] = 7;
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
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f41243a[cVar.ordinal()];
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
                        String file = getContext().getFilesDir().toString();
                        setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(file + TTPathConst.sSeparator + attributeValue2 + ".png")));
                    }
                } else if (i5 == 3) {
                    setContentDescription(attributeSet.getAttributeValue(i4));
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f41243a[cVar.ordinal()];
                if (i5 == 4) {
                    setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i4, false));
                } else if (i5 == 5) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equalsIgnoreCase("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        } else if (attributeValue.equalsIgnoreCase("visible")) {
                            setVisibility(0);
                        }
                    }
                } else if (i5 == 6) {
                    generateDefaultLayoutParams.bottomMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                }
            }
        }
        return generateDefaultLayoutParams;
    }
}
