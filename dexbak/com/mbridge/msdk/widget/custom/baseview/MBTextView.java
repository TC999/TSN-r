package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.AbsListView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import com.mbridge.msdk.widget.custom.p516a.ParamValue;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBTextView extends AppCompatTextView {

    /* renamed from: a */
    private boolean f32557a;
    public AttributeSet attrs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.widget.custom.baseview.MBTextView$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C117701 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32558a;

        static {
            int[] iArr = new int[ParamValue.values().length];
            f32558a = iArr;
            try {
                iArr[ParamValue.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32558a[ParamValue.text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32558a[ParamValue.ellipsize.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32558a[ParamValue.fadingEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32558a[ParamValue.scrollHorizontally.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32558a[ParamValue.textColor.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32558a[ParamValue.textSize.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32558a[ParamValue.singleLine.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32558a[ParamValue.visibility.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32558a[ParamValue.background.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f32558a[ParamValue.textStyle.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f32558a[ParamValue.style.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f32558a[ParamValue.contentDescription.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f32558a[ParamValue.gravity.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f32558a[ParamValue.layout_width.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f32558a[ParamValue.layout_height.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f32558a[ParamValue.layout_gravity.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public MBTextView(Context context, AttributeSet attributeSet) {
        super(context);
        this.f32557a = false;
        this.attrs = attributeSet;
        setAttributeSet(attributeSet);
    }

    public AbsListView.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -1);
        }
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                int i2 = C117701.f32558a[paramValue.ordinal()];
                if (i2 == 4) {
                    setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i, false));
                } else if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            setGravity(MBResource.m20600a().m20592d(attributeSet.getAttributeValue(i)));
                            continue;
                        case 15:
                            String attributeValue = attributeSet.getAttributeValue(i);
                            if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                                if (attributeValue.startsWith("wrap")) {
                                    layoutParams.width = -2;
                                    continue;
                                } else {
                                    layoutParams.width = MBResource.m20600a().m20594c(attributeValue);
                                    break;
                                }
                            } else {
                                layoutParams.width = -1;
                                break;
                            }
                        case 16:
                            String attributeValue2 = attributeSet.getAttributeValue(i);
                            if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
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
                    }
                } else {
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

    @Override // android.view.View
    public boolean isFocused() {
        if (this.f32557a) {
            return true;
        }
        return super.isFocused();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, ParamValue> m20595c = MBResource.m20600a().m20595c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            ParamValue paramValue = m20595c.get(attributeSet.getAttributeName(i));
            if (paramValue != null) {
                switch (C117701.f32558a[paramValue.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            continue;
                        }
                    case 2:
                        setText(MBResource.m20600a().m20591e(attributeSet.getAttributeValue(i)));
                        continue;
                    case 3:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            this.f32557a = true;
                            setFocusable(true);
                            setFocusableInTouchMode(true);
                            setEllipsize(TextUtils.TruncateAt.END);
                            setMarqueeRepeatLimit(1000);
                            setHorizontallyScrolling(true);
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i, false));
                        continue;
                    case 5:
                        setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i, false));
                        continue;
                    case 6:
                        setTextColor(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i)));
                        continue;
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue2)) {
                            setTextSize(MBResource.m20600a().m20594c(attributeValue2));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        setSingleLine(attributeSet.getAttributeBooleanValue(i, true));
                        continue;
                    case 9:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            continue;
                        } else if (attributeValue3.equals("invisible")) {
                            setVisibility(4);
                            break;
                        } else if (attributeValue3.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                            break;
                        } else if (attributeValue3.equalsIgnoreCase("visible")) {
                            setVisibility(0);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        String attributeValue4 = attributeSet.getAttributeValue(i);
                        if (attributeValue4.startsWith("#")) {
                            setBackgroundColor(MBResource.m20600a().m20596b(attributeSet.getAttributeValue(i)));
                            continue;
                        } else {
                            if (attributeValue4.startsWith("@drawable/")) {
                                attributeValue4 = attributeValue4.substring(10);
                            }
                            String file = getContext().getFilesDir().toString();
                            setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(file + "/" + attributeValue4 + PhotoBitmapUtils.f15141c)));
                            break;
                        }
                    case 11:
                        if ("bold".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                            setTypeface(Typeface.defaultFromStyle(1));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        String attributeValue5 = attributeSet.getAttributeValue(i);
                        String substring = attributeValue5.substring(attributeValue5.indexOf("/") + 1);
                        MBResource m20600a = MBResource.m20600a();
                        Context context = getContext();
                        setTextAppearance(getContext(), m20600a.m20599a(context, "R.style." + substring));
                        continue;
                    case 13:
                        setContentDescription(attributeSet.getAttributeValue(i));
                        continue;
                    case 14:
                        setGravity(MBResource.m20600a().m20592d(attributeSet.getAttributeValue(i)));
                        continue;
                }
            }
        }
    }
}
