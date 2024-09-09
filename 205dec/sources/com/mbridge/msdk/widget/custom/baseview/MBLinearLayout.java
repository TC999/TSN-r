package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBLinearLayout extends LinearLayout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBLinearLayout$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41239a;

        static {
            int[] iArr = new int[com.mbridge.msdk.widget.custom.a.c.values().length];
            f41239a = iArr;
            try {
                iArr[com.mbridge.msdk.widget.custom.a.c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.orientation.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.visibility.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.contentDescription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_width.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_height.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_centerHorizontal.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_centerVertical.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_weight.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.gravity.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_margin.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_marginLeft.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_marginRight.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_marginTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_marginBottom.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41239a[com.mbridge.msdk.widget.custom.a.c.layout_gravity.ordinal()] = 17;
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
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f41239a[cVar.ordinal()];
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
                } else if (i5 != 3) {
                    if (i5 == 4) {
                        String attributeValue3 = attributeSet.getAttributeValue(i4);
                        if (!TextUtils.isEmpty(attributeValue3)) {
                            if (attributeValue3.equalsIgnoreCase("visible")) {
                                setVisibility(0);
                            } else if (attributeValue3.equalsIgnoreCase("gone")) {
                                setVisibility(8);
                            } else if (attributeValue3.equalsIgnoreCase("visible")) {
                                setVisibility(0);
                            }
                        }
                    } else if (i5 == 5) {
                        setContentDescription(attributeSet.getAttributeValue(i4));
                    }
                } else if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i4))) {
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
        HashMap b4 = com.mbridge.msdk.widget.custom.a.b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = (com.mbridge.msdk.widget.custom.a.c) b4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                switch (AnonymousClass1.f41239a[cVar.ordinal()]) {
                    case 6:
                        String attributeValue = attributeSet.getAttributeValue(i4);
                        if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                            if (attributeValue.startsWith("wrap")) {
                                generateDefaultLayoutParams.width = -2;
                                break;
                            } else {
                                generateDefaultLayoutParams.width = com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue);
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.width = -1;
                            continue;
                        }
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i4);
                        if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                            if (attributeValue2.startsWith("wrap")) {
                                generateDefaultLayoutParams.height = -2;
                                continue;
                            } else {
                                generateDefaultLayoutParams.height = com.mbridge.msdk.widget.custom.a.b.a().c(attributeValue2);
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
                        generateDefaultLayoutParams.weight = attributeSet.getAttributeFloatValue(i4, 0.0f);
                        continue;
                    case 11:
                        setGravity(com.mbridge.msdk.widget.custom.a.b.a().d(attributeSet.getAttributeValue(i4)));
                        continue;
                    case 12:
                        int c4 = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        generateDefaultLayoutParams.bottomMargin = c4;
                        generateDefaultLayoutParams.leftMargin = c4;
                        generateDefaultLayoutParams.rightMargin = c4;
                        generateDefaultLayoutParams.topMargin = c4;
                        continue;
                    case 13:
                        generateDefaultLayoutParams.leftMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 14:
                        generateDefaultLayoutParams.rightMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 15:
                        generateDefaultLayoutParams.topMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 16:
                        generateDefaultLayoutParams.bottomMargin = com.mbridge.msdk.widget.custom.a.b.a().c(attributeSet.getAttributeValue(i4));
                        continue;
                    case 17:
                        generateDefaultLayoutParams.gravity = com.mbridge.msdk.widget.custom.a.b.a().d(attributeSet.getAttributeValue(i4));
                        continue;
                }
            }
        }
        return generateDefaultLayoutParams;
    }
}
