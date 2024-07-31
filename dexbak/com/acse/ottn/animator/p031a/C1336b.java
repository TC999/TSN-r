package com.acse.ottn.animator.p031a;

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

/* renamed from: com.acse.ottn.animator.a.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1336b {

    /* renamed from: b */
    private static final int f2335b = 0;

    /* renamed from: d */
    private static final int f2337d = 0;

    /* renamed from: f */
    private static final int f2339f = 0;

    /* renamed from: g */
    private static final int f2340g = 1;

    /* renamed from: h */
    private static final int f2341h = 2;

    /* renamed from: i */
    private static final int f2342i = 3;

    /* renamed from: j */
    private static final int f2343j = 4;

    /* renamed from: k */
    private static final int f2344k = 5;

    /* renamed from: l */
    private static final int f2345l = 6;

    /* renamed from: m */
    private static final int f2346m = 7;

    /* renamed from: n */
    private static final int f2347n = 0;

    /* renamed from: o */
    private static final int f2348o = 0;

    /* renamed from: a */
    private static final int[] f2334a = {16843490};

    /* renamed from: c */
    private static final int[] f2336c = {16843489};

    /* renamed from: e */
    private static final int[] f2338e = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};

    /* renamed from: a */
    private static C1331L m57112a(Context context, AttributeSet attributeSet, C1331L c1331l) throws Resources.NotFoundException {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2338e);
        long j = obtainStyledAttributes.getInt(1, 0);
        long j2 = obtainStyledAttributes.getInt(2, 0);
        int i2 = obtainStyledAttributes.getInt(7, 0);
        C1331L c1331l2 = c1331l == null ? new C1331L() : c1331l;
        boolean z = i2 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z2 = peekValue != null;
        int i3 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z3 = peekValue2 != null;
        int i4 = z3 ? peekValue2.type : 0;
        if ((z2 && i3 >= 28 && i3 <= 31) || (z3 && i4 >= 28 && i4 <= 31)) {
            c1331l2.m57154a((InterfaceC1325F) new C1345f());
            z = false;
        }
        if (!z) {
            i = 0;
            if (z2) {
                int dimension = i3 == 5 ? (int) obtainStyledAttributes.getDimension(5, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(5, 0) : obtainStyledAttributes.getColor(5, 0);
                if (z3) {
                    c1331l2.mo57041b(dimension, i4 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i4 < 28 || i4 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
                } else {
                    c1331l2.mo57041b(dimension);
                }
            } else if (z3) {
                c1331l2.mo57041b(i4 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i4 < 28 || i4 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
            }
        } else if (z2) {
            float dimension2 = i3 == 5 ? obtainStyledAttributes.getDimension(5, 0.0f) : obtainStyledAttributes.getFloat(5, 0.0f);
            if (z3) {
                i = 0;
                c1331l2.mo57042b(dimension2, i4 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
            } else {
                i = 0;
                c1331l2.mo57042b(dimension2);
            }
        } else {
            i = 0;
            c1331l2.mo57042b(i4 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
        }
        c1331l2.mo57054a(j);
        c1331l2.mo57100b(j2);
        if (obtainStyledAttributes.hasValue(3)) {
            c1331l2.m57155a(obtainStyledAttributes.getInt(3, i));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            c1331l2.m57143b(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i, i);
        if (resourceId > 0) {
            c1331l2.mo57108a(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return c1331l2;
    }

    /* renamed from: a */
    public static AbstractC1334a m57114a(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = context.getResources().getAnimation(i);
                return m57111a(context, (XmlPullParser) xmlResourceParser);
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* renamed from: a */
    private static AbstractC1334a m57111a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return m57110a(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    /* renamed from: a */
    private static AbstractC1334a m57110a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, C1339e c1339e, int i) throws XmlPullParserException, IOException {
        int i2;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        C1355m c1355m = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        c1355m = m57113a(context, attributeSet);
                    } else if (name.equals("animator")) {
                        c1355m = m57112a(context, attributeSet, null);
                    } else if (!name.equals("set")) {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    } else {
                        C1339e c1339e2 = new C1339e();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2334a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        m57110a(context, xmlPullParser, attributeSet, c1339e2, typedValue.type == 16 ? typedValue.data : 0);
                        obtainStyledAttributes.recycle();
                        c1355m = c1339e2;
                    }
                    if (c1339e != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c1355m);
                    }
                }
            }
        }
        if (c1339e != null && arrayList != null) {
            AbstractC1334a[] abstractC1334aArr = new AbstractC1334a[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                abstractC1334aArr[i2] = (AbstractC1334a) it.next();
                i2++;
            }
            if (i == 0) {
                c1339e.m57098b(abstractC1334aArr);
            } else {
                c1339e.m57102a(abstractC1334aArr);
            }
        }
        return c1355m;
    }

    /* renamed from: a */
    private static C1355m m57113a(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        C1355m c1355m = new C1355m();
        m57112a(context, attributeSet, c1355m);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2336c);
        c1355m.m57043b(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return c1355m;
    }
}
