package com.acse.ottn;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public static final int f5745b = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5747d = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5749f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5750g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5751h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5752i = 3;

    /* renamed from: j  reason: collision with root package name */
    public static final int f5753j = 4;

    /* renamed from: k  reason: collision with root package name */
    public static final int f5754k = 5;

    /* renamed from: l  reason: collision with root package name */
    public static final int f5755l = 6;

    /* renamed from: m  reason: collision with root package name */
    public static final int f5756m = 7;

    /* renamed from: n  reason: collision with root package name */
    public static final int f5757n = 0;

    /* renamed from: o  reason: collision with root package name */
    public static final int f5758o = 0;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f5744a = {16843490};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f5746c = {16843489};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f5748e = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};

    public static i a(Context context, int i4) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = context.getResources().getAnimation(i4);
                return a(context, (XmlPullParser) xmlResourceParser);
            } catch (IOException e4) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i4));
                notFoundException.initCause(e4);
                throw notFoundException;
            } catch (XmlPullParserException e5) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i4));
                notFoundException2.initCause(e5);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static i a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return a(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    public static i a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, m mVar, int i4) throws XmlPullParserException, IOException {
        int i5;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        p2 p2Var = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        p2Var = a(context, attributeSet);
                    } else if (name.equals("animator")) {
                        p2Var = a(context, attributeSet, null);
                    } else if (name.equals(f3.f5659h)) {
                        m mVar2 = new m();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5744a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        a(context, xmlPullParser, attributeSet, mVar2, typedValue.type == 16 ? typedValue.data : 0);
                        obtainStyledAttributes.recycle();
                        p2Var = mVar2;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (mVar != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(p2Var);
                    }
                }
            }
        }
        if (mVar != null && arrayList != null) {
            i[] iVarArr = new i[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iVarArr[i5] = (i) it.next();
                i5++;
            }
            if (i4 == 0) {
                mVar.b(iVarArr);
            } else {
                mVar.a(iVarArr);
            }
        }
        return p2Var;
    }

    public static p2 a(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        p2 p2Var = new p2();
        a(context, attributeSet, p2Var);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5746c);
        p2Var.b(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return p2Var;
    }

    public static g4 a(Context context, AttributeSet attributeSet, g4 g4Var) throws Resources.NotFoundException {
        int i4;
        int i5;
        int i6;
        int i7;
        float f4;
        float f5;
        float f6;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5748e);
        long j4 = obtainStyledAttributes.getInt(1, 0);
        long j5 = obtainStyledAttributes.getInt(2, 0);
        int i8 = obtainStyledAttributes.getInt(7, 0);
        g4 g4Var2 = g4Var == null ? new g4() : g4Var;
        boolean z3 = i8 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z4 = peekValue != null;
        int i9 = z4 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z5 = peekValue2 != null;
        int i10 = z5 ? peekValue2.type : 0;
        if ((z4 && i9 >= 28 && i9 <= 31) || (z5 && i10 >= 28 && i10 <= 31)) {
            g4Var2.a((f4) new q());
            z3 = false;
        }
        if (!z3) {
            i4 = 0;
            if (z4) {
                if (i9 == 5) {
                    i6 = (int) obtainStyledAttributes.getDimension(5, 0.0f);
                } else if (i9 >= 28 && i9 <= 31) {
                    i6 = obtainStyledAttributes.getColor(5, 0);
                } else {
                    i6 = obtainStyledAttributes.getInt(5, 0);
                }
                if (z5) {
                    if (i10 == 5) {
                        i7 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                    } else if (i10 >= 28 && i10 <= 31) {
                        i7 = obtainStyledAttributes.getColor(6, 0);
                    } else {
                        i7 = obtainStyledAttributes.getInt(6, 0);
                    }
                    g4Var2.b(i6, i7);
                } else {
                    g4Var2.b(i6);
                }
            } else if (z5) {
                if (i10 == 5) {
                    i5 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                } else if (i10 >= 28 && i10 <= 31) {
                    i5 = obtainStyledAttributes.getColor(6, 0);
                } else {
                    i5 = obtainStyledAttributes.getInt(6, 0);
                }
                g4Var2.b(i5);
            }
        } else if (z4) {
            if (i9 == 5) {
                f5 = obtainStyledAttributes.getDimension(5, 0.0f);
            } else {
                f5 = obtainStyledAttributes.getFloat(5, 0.0f);
            }
            if (z5) {
                if (i10 == 5) {
                    f6 = obtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    f6 = obtainStyledAttributes.getFloat(6, 0.0f);
                }
                i4 = 0;
                g4Var2.b(f5, f6);
            } else {
                i4 = 0;
                g4Var2.b(f5);
            }
        } else {
            i4 = 0;
            if (i10 == 5) {
                f4 = obtainStyledAttributes.getDimension(6, 0.0f);
            } else {
                f4 = obtainStyledAttributes.getFloat(6, 0.0f);
            }
            g4Var2.b(f4);
        }
        g4Var2.a(j4);
        g4Var2.b(j5);
        if (obtainStyledAttributes.hasValue(3)) {
            g4Var2.a(obtainStyledAttributes.getInt(3, i4));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            g4Var2.b(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i4, i4);
        if (resourceId > 0) {
            g4Var2.a(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return g4Var2;
    }
}
