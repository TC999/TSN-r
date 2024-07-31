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
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBImageView extends AppCompatImageView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBImageView$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117651 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32551a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32551a = iArr;
            try {
                iArr[ParamValue.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32551a[ParamValue.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32551a[ParamValue.id.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32551a[ParamValue.src.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32551a[ParamValue.background.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32551a[ParamValue.contentDescription.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32551a[ParamValue.visibility.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32551a[ParamValue.scaleType.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32551a[ParamValue.gravity.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32551a[ParamValue.layout_gravity.ordinal()] = 10;
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
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        for (int i = 0; i < 2; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                int i2 = C117651.f32551a[paramValue.ordinal()];
                if (i2 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                        if (attributeValue.startsWith("wrap")) {
                            layoutParams.width = -2;
                        } else {
                            layoutParams.width = MBResource.m20600a().m20594c(attributeValue);
                        }
                    } else {
                        layoutParams.width = -1;
                    }
                } else if (i2 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                        if (attributeValue2.startsWith("wrap")) {
                            layoutParams.height = -2;
                        } else {
                            layoutParams.height = MBResource.m20600a().m20594c(attributeValue2);
                        }
                    } else {
                        layoutParams.height = -1;
                    }
                } else if (i2 == 7) {
                    String attributeValue3 = attributeSet.getAttributeValue(i);
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
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                switch (C117651.f32551a[paramValue.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        getLayoutParams();
                        if (attributeValue.startsWith("f")) {
                            break;
                        } else {
                            attributeValue.startsWith("m");
                            continue;
                        }
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith("f")) {
                            attributeValue2.startsWith("m");
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (attributeValue3.startsWith("@+id/")) {
                            setId(attributeValue3.substring(5).hashCode());
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        attributeSet.getAttributeValue(i);
                        continue;
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i);
                        if (attributeValue4.startsWith("#")) {
                            setBackgroundColor(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i)));
                            continue;
                        } else {
                            if (attributeValue4.startsWith("@drawable/")) {
                                attributeValue4 = attributeValue4.substring(10);
                            }
                            String file = getContext().getFilesDir().toString();
                            Bitmap decodeFile = BitmapFactory.decodeFile(file + "/" + attributeValue4 + PhotoBitmapUtils.f15141c);
                            if (decodeFile != null) {
                                setBackgroundDrawable(new BitmapDrawable(decodeFile));
                                break;
                            } else {
                                break;
                            }
                        }
                    case 6:
                        setContentDescription(attributeSet.getAttributeValue(i));
                        continue;
                    case 7:
                        String attributeValue5 = attributeSet.getAttributeValue(i);
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
                        if (!TextUtils.isEmpty(attributeSet.getAttributeValue(i))) {
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
