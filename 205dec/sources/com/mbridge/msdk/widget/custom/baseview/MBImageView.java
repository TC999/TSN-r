package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBImageView extends AppCompatImageView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBImageView$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41238a;

        static {
            int[] iArr = new int[com.mbridge.msdk.widget.custom.a.c.values().length];
            f41238a = iArr;
            try {
                iArr[com.mbridge.msdk.widget.custom.a.c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.id.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.src.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.background.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.contentDescription.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.visibility.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.scaleType.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.gravity.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41238a[com.mbridge.msdk.widget.custom.a.c.layout_gravity.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context);
        setAttributeSet(attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        for (int i4 = 0; i4 < 2; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f41238a[cVar.ordinal()];
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
                } else if (i5 == 7) {
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

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, com.mbridge.msdk.widget.custom.a.c> c4 = com.mbridge.msdk.widget.custom.a.b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.widget.custom.a.c cVar = c4.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                switch (AnonymousClass1.f41238a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i4);
                        getLayoutParams();
                        if (attributeValue.startsWith("f")) {
                            break;
                        } else {
                            attributeValue.startsWith("m");
                            continue;
                        }
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i4);
                        if (!attributeValue2.startsWith("f")) {
                            attributeValue2.startsWith("m");
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        String attributeValue3 = attributeSet.getAttributeValue(i4);
                        if (attributeValue3.startsWith("@+id/")) {
                            setId(attributeValue3.substring(5).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        attributeSet.getAttributeValue(i4);
                        continue;
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i4);
                        if (attributeValue4.startsWith("#")) {
                            setBackgroundColor(com.mbridge.msdk.widget.custom.a.b.a().b(attributeSet.getAttributeValue(i4)));
                            continue;
                        } else {
                            if (attributeValue4.startsWith("@drawable/")) {
                                attributeValue4 = attributeValue4.substring(10);
                            }
                            String file = getContext().getFilesDir().toString();
                            Bitmap decodeFile = BitmapFactory.decodeFile(file + TTPathConst.sSeparator + attributeValue4 + ".png");
                            if (decodeFile != null) {
                                setBackgroundDrawable(new BitmapDrawable(decodeFile));
                                break;
                            } else {
                                break;
                            }
                        }
                    case 6:
                        setContentDescription(attributeSet.getAttributeValue(i4));
                        continue;
                    case 7:
                        String attributeValue5 = attributeSet.getAttributeValue(i4);
                        if (TextUtils.isEmpty(attributeValue5)) {
                            continue;
                        } else if (attributeValue5.equals("invisible")) {
                            setVisibility(4);
                            break;
                        } else if (attributeValue5.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                            break;
                        } else if (attributeValue5.equalsIgnoreCase("invisible")) {
                            setVisibility(4);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (!TextUtils.isEmpty(attributeSet.getAttributeValue(i4))) {
                            setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
    }
}
