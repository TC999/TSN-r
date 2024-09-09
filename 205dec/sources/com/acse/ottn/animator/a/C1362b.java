package com.acse.ottn.animator.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import com.acse.ottn.f3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.acse.ottn.animator.a.b  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1362b {

    /* renamed from: b  reason: collision with root package name */
    private static final int f4882b = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f4884d = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f4886f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final int f4887g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f4888h = 2;

    /* renamed from: i  reason: collision with root package name */
    private static final int f4889i = 3;

    /* renamed from: j  reason: collision with root package name */
    private static final int f4890j = 4;

    /* renamed from: k  reason: collision with root package name */
    private static final int f4891k = 5;

    /* renamed from: l  reason: collision with root package name */
    private static final int f4892l = 6;

    /* renamed from: m  reason: collision with root package name */
    private static final int f4893m = 7;

    /* renamed from: n  reason: collision with root package name */
    private static final int f4894n = 0;

    /* renamed from: o  reason: collision with root package name */
    private static final int f4895o = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4881a = {16843490};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f4883c = {16843489};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f4885e = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};

    private static L a(Context context, AttributeSet attributeSet, L l4) throws Resources.NotFoundException {
        int i4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4885e);
        long j4 = obtainStyledAttributes.getInt(1, 0);
        long j5 = obtainStyledAttributes.getInt(2, 0);
        int i5 = obtainStyledAttributes.getInt(7, 0);
        L l5 = l4 == null ? new L() : l4;
        boolean z3 = i5 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z4 = peekValue != null;
        int i6 = z4 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z5 = peekValue2 != null;
        int i7 = z5 ? peekValue2.type : 0;
        if ((z4 && i6 >= 28 && i6 <= 31) || (z5 && i7 >= 28 && i7 <= 31)) {
            l5.a((F) new C1366f());
            z3 = false;
        }
        if (!z3) {
            i4 = 0;
            if (z4) {
                int dimension = i6 == 5 ? (int) obtainStyledAttributes.getDimension(5, 0.0f) : (i6 < 28 || i6 > 31) ? obtainStyledAttributes.getInt(5, 0) : obtainStyledAttributes.getColor(5, 0);
                if (z5) {
                    l5.b(dimension, i7 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i7 < 28 || i7 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
                } else {
                    l5.b(dimension);
                }
            } else if (z5) {
                l5.b(i7 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i7 < 28 || i7 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
            }
        } else if (z4) {
            float dimension2 = i6 == 5 ? obtainStyledAttributes.getDimension(5, 0.0f) : obtainStyledAttributes.getFloat(5, 0.0f);
            if (z5) {
                i4 = 0;
                l5.b(dimension2, i7 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
            } else {
                i4 = 0;
                l5.b(dimension2);
            }
        } else {
            i4 = 0;
            l5.b(i7 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
        }
        l5.a(j4);
        l5.b(j5);
        if (obtainStyledAttributes.hasValue(3)) {
            l5.a(obtainStyledAttributes.getInt(3, i4));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            l5.b(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i4, i4);
        if (resourceId > 0) {
            l5.a(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return l5;
    }

    public static AbstractC1361a a(Context context, int i4) throws Resources.NotFoundException {
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

    private static AbstractC1361a a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return a(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    private static AbstractC1361a a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, C1365e c1365e, int i4) throws XmlPullParserException, IOException {
        int i5;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        m mVar = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        mVar = a(context, attributeSet);
                    } else if (name.equals("animator")) {
                        mVar = a(context, attributeSet, null);
                    } else if (!name.equals(f3.f5659h)) {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    } else {
                        C1365e c1365e2 = new C1365e();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4881a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        a(context, xmlPullParser, attributeSet, c1365e2, typedValue.type == 16 ? typedValue.data : 0);
                        obtainStyledAttributes.recycle();
                        mVar = c1365e2;
                    }
                    if (c1365e != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(mVar);
                    }
                }
            }
        }
        if (c1365e != null && arrayList != null) {
            AbstractC1361a[] abstractC1361aArr = new AbstractC1361a[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                abstractC1361aArr[i5] = (AbstractC1361a) it.next();
                i5++;
            }
            if (i4 == 0) {
                c1365e.b(abstractC1361aArr);
            } else {
                c1365e.a(abstractC1361aArr);
            }
        }
        return mVar;
    }

    private static m a(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        m mVar = new m();
        a(context, attributeSet, mVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4883c);
        mVar.b(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return mVar;
    }
}
