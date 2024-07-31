package com.mbridge.msdk.widget.custom.p516a;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.widget.custom.p517b.C11754d;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.mbridge.msdk.widget.custom.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MBLayoutInflate {

    /* renamed from: f */
    private static final Class[] f32400f = {Context.class, AttributeSet.class};

    /* renamed from: g */
    private static final HashMap<String, Constructor> f32401g = new HashMap<>();

    /* renamed from: a */
    protected final Context f32402a;

    /* renamed from: c */
    private InterfaceC11740a f32404c;

    /* renamed from: d */
    private InterfaceC11741b f32405d;

    /* renamed from: h */
    private HashMap<String, Boolean> f32407h;

    /* renamed from: b */
    private final boolean f32403b = false;

    /* renamed from: e */
    private final Object[] f32406e = new Object[2];

    /* compiled from: MBLayoutInflate.java */
    /* renamed from: com.mbridge.msdk.widget.custom.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC11740a {
        /* renamed from: a */
        View m20602a(String str, Context context, AttributeSet attributeSet);
    }

    /* compiled from: MBLayoutInflate.java */
    /* renamed from: com.mbridge.msdk.widget.custom.a.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC11741b {
        /* renamed from: a */
        boolean m20601a(Class cls);
    }

    public MBLayoutInflate(Context context) {
        this.f32402a = context;
    }

    /* renamed from: b */
    private void m20604b(String str, String str2, AttributeSet attributeSet) {
        StringBuilder sb = new StringBuilder();
        sb.append(attributeSet.getPositionDescription());
        sb.append(": Class not allowed to be inflated ");
        if (str2 != null) {
            str = str2 + str;
        }
        sb.append(str);
        throw new InflateException(sb.toString());
    }

    /* renamed from: a */
    public final XmlPullParser m20609a(String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new FileInputStream(str), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newPullParser;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r8 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        r2.setLayoutParams(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        m20606a(r0, r2, r1);
        r7.addView(r2);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m20603b(org.xmlpull.v1.XmlPullParser r6, android.view.View r7, android.util.AttributeSet r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof android.view.ViewGroup
            if (r0 == 0) goto Lbb
            r0 = 0
            r1 = 0
            java.lang.String r2 = "layout"
            int r0 = r8.getAttributeResourceValue(r1, r2, r0)
            if (r0 != 0) goto L38
            java.lang.String r6 = r8.getAttributeValue(r1, r2)
            if (r6 != 0) goto L1c
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />"
            r6.<init>(r7)
            throw r6
        L1c:
            android.view.InflateException r7 = new android.view.InflateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "You must specifiy a valid layout reference. The layout ID "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = " is not valid."
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L38:
            android.content.Context r1 = r5.f32402a
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.XmlResourceParser r0 = r1.getLayout(r0)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)     // Catch: java.lang.Throwable -> Lb6
        L46:
            int r2 = r0.next()     // Catch: java.lang.Throwable -> Lb6
            r3 = 1
            r4 = 2
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            goto L46
        L51:
            if (r2 != r4) goto L9b
            java.lang.String r2 = r0.getName()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r4 = "merge"
            boolean r4 = r4.equals(r2)     // Catch: java.lang.Throwable -> Lb6
            if (r4 == 0) goto L63
            r5.m20606a(r0, r7, r1)     // Catch: java.lang.Throwable -> Lb6
            goto L82
        L63:
            android.view.View r2 = r5.m20608a(r2, r1)     // Catch: java.lang.Throwable -> Lb6
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch: java.lang.Throwable -> Lb6
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r8)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L75
            if (r8 == 0) goto L7c
        L6f:
            r2.setLayoutParams(r8)     // Catch: java.lang.Throwable -> Lb6
            goto L7c
        L73:
            r6 = move-exception
            goto L9a
        L75:
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r1)     // Catch: java.lang.Throwable -> L73
            if (r8 == 0) goto L7c
            goto L6f
        L7c:
            r5.m20606a(r0, r2, r1)     // Catch: java.lang.Throwable -> Lb6
            r7.addView(r2)     // Catch: java.lang.Throwable -> Lb6
        L82:
            r0.close()
            int r7 = r6.getDepth()
        L89:
            int r8 = r6.next()
            r0 = 3
            if (r8 != r0) goto L96
            int r0 = r6.getDepth()
            if (r0 <= r7) goto L99
        L96:
            if (r8 == r3) goto L99
            goto L89
        L99:
            return
        L9a:
            throw r6     // Catch: java.lang.Throwable -> Lb6
        L9b:
            android.view.InflateException r6 = new android.view.InflateException     // Catch: java.lang.Throwable -> Lb6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r7.<init>()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r8 = r0.getPositionDescription()     // Catch: java.lang.Throwable -> Lb6
            r7.append(r8)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r8 = ": No start tag found!"
            r7.append(r8)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb6
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb6
            throw r6     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r6 = move-exception
            r0.close()
            throw r6
        Lbb:
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "<include /> can only be used inside of a ViewGroup"
            r6.<init>(r7)
            goto Lc4
        Lc3:
            throw r6
        Lc4:
            goto Lc3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.widget.custom.p516a.MBLayoutInflate.m20603b(org.xmlpull.v1.XmlPullParser, android.view.View, android.util.AttributeSet):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.view.View] */
    /* renamed from: a */
    public final View m20605a(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        int next;
        synchronized (this.f32406e) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f32406e[0] = this.f32402a;
            while (true) {
                try {
                    next = xmlPullParser.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                } catch (IOException e) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e.getMessage());
                    inflateException.initCause(e);
                    throw inflateException;
                } catch (XmlPullParserException e2) {
                    InflateException inflateException2 = new InflateException(e2.getMessage());
                    inflateException2.initCause(e2);
                    throw inflateException2;
                }
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (!"merge".equals(name)) {
                    View m20608a = m20608a(name, asAttributeSet);
                    ViewGroup.LayoutParams layoutParams = null;
                    if (viewGroup != 0) {
                        layoutParams = viewGroup.generateLayoutParams(asAttributeSet);
                        if (!z) {
                            m20608a.setLayoutParams(layoutParams);
                        }
                    }
                    m20606a(xmlPullParser, m20608a, asAttributeSet);
                    if (viewGroup != 0 && z) {
                        viewGroup.addView(m20608a, layoutParams);
                    }
                    if (viewGroup == 0 || !z) {
                        viewGroup = m20608a;
                    }
                } else if (viewGroup != 0 && z) {
                    m20606a(xmlPullParser, (View) viewGroup, asAttributeSet);
                } else {
                    throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
                }
            } else {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
        }
        return viewGroup;
    }

    /* renamed from: a */
    private View m20607a(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        String str3;
        String str4;
        HashMap<String, Constructor> hashMap = f32401g;
        Constructor<?> constructor = hashMap.get(str);
        Class<?> cls = null;
        try {
            if (constructor == null) {
                ClassLoader classLoader = this.f32402a.getClassLoader();
                if (str2 != null) {
                    str4 = str2 + str;
                } else {
                    str4 = str;
                }
                cls = classLoader.loadClass(str4);
                InterfaceC11741b interfaceC11741b = this.f32405d;
                if (interfaceC11741b != null && cls != null && !interfaceC11741b.m20601a(cls)) {
                    m20604b(str, str2, attributeSet);
                }
                constructor = cls.getConstructor(f32400f);
                hashMap.put(str, constructor);
            } else if (this.f32405d != null) {
                Boolean bool = this.f32407h.get(str);
                if (bool == null) {
                    ClassLoader classLoader2 = this.f32402a.getClassLoader();
                    if (str2 != null) {
                        str3 = str2 + str;
                    } else {
                        str3 = str;
                    }
                    cls = classLoader2.loadClass(str3);
                    boolean z = cls != null && this.f32405d.m20601a(cls);
                    this.f32407h.put(str, Boolean.valueOf(z));
                    if (!z) {
                        m20604b(str, str2, attributeSet);
                    }
                } else if (bool.equals(Boolean.FALSE)) {
                    m20604b(str, str2, attributeSet);
                }
            }
            Object[] objArr = this.f32406e;
            objArr[1] = attributeSet;
            return (View) constructor.newInstance(objArr);
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (NoSuchMethodException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(attributeSet.getPositionDescription());
            sb.append(": Error inflating class ");
            if (str2 != null) {
                str = str2 + str;
            }
            sb.append(str);
            InflateException inflateException = new InflateException(sb.toString());
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(attributeSet.getPositionDescription());
            sb2.append(": Error inflating class ");
            sb2.append(cls == null ? "<unknown>" : cls.getName());
            InflateException inflateException2 = new InflateException(sb2.toString());
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    /* renamed from: a */
    private View m20608a(String str, AttributeSet attributeSet) {
        View m20607a;
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            InterfaceC11740a interfaceC11740a = this.f32404c;
            View m20602a = interfaceC11740a == null ? null : interfaceC11740a.m20602a(str, this.f32402a, attributeSet);
            if (m20602a == null) {
                if (-1 == str.indexOf(46)) {
                    if (str.equals("MBStarLevelLayoutView")) {
                        m20607a = m20607a(str, "", attributeSet);
                    } else {
                        m20607a = m20607a(str, C11754d.f32506b, attributeSet);
                    }
                    return m20607a;
                }
                return m20607a(str, (String) null, attributeSet);
            }
            return m20602a;
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    /* renamed from: a */
    private void m20606a(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next2 = xmlPullParser.next();
            if ((next2 == 3 && xmlPullParser.getDepth() <= depth) || next2 == 1) {
                return;
            }
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    view.requestFocus();
                    int depth2 = xmlPullParser.getDepth();
                    do {
                        next = xmlPullParser.next();
                        if (next != 3 || xmlPullParser.getDepth() > depth2) {
                        }
                    } while (next != 1);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() != 0) {
                        m20603b(xmlPullParser, view, attributeSet);
                    } else {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                } else if (!"merge".equals(name)) {
                    View m20608a = m20608a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    m20606a(xmlPullParser, m20608a, attributeSet);
                    viewGroup.addView(m20608a, generateLayoutParams);
                } else {
                    throw new InflateException("<merge /> must be the root element");
                }
            }
        }
    }
}
