package CyVHHabzCrUqKeyhTwFaxBD;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.ResourcesHook;
import android.content.Context;
import android.content.pm.PackageParser;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LayoutInflated;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;
import xposed.dummy.XResourcesSuperClass;
import xposed.dummy.XTypedArraySuperClass;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class ources extends XResourcesSuperClass {
    private static final String EXTRA_XML_INSTANCE_DETAILS = "xmlInstanceDetails";
    private String mPackageName;
    private byte[] mReplacementsCache;
    private String mResDir;
    private static final SparseArray sReplacements = new SparseArray();
    private static final SparseArray sResourceNames = new SparseArray();
    private static final byte[] sSystemReplacementsCache = new byte[256];
    private static final HashMap sReplacementsCacheMap = new HashMap();
    private static final SparseArray sColorStateListCache = new SparseArray(0);
    private static final SparseArray sLayoutCallbacks = new SparseArray();
    private static final WeakHashMap sXmlInstanceDetails = new WeakHashMap();
    private static final ThreadLocal sIncludedLayouts = ThreadLocal.withInitial(new Object());
    private static final HashMap sResDirLastModified = new HashMap();
    private static final HashMap sResDirPackageNames = new HashMap();
    private static ThreadLocal sLatestResKey = null;

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public class DimensionReplacement {
        private final int mUnit;
        private final float mValue;

        public DimensionReplacement(float f4, int i4) {
            this.mValue = f4;
            this.mUnit = i4;
        }

        public float getDimension(DisplayMetrics displayMetrics) {
            return TypedValue.applyDimension(this.mUnit, this.mValue, displayMetrics);
        }

        public int getDimensionPixelOffset(DisplayMetrics displayMetrics) {
            return (int) TypedValue.applyDimension(this.mUnit, this.mValue, displayMetrics);
        }

        public int getDimensionPixelSize(DisplayMetrics displayMetrics) {
            int applyDimension = (int) (TypedValue.applyDimension(this.mUnit, this.mValue, displayMetrics) + 0.5f);
            if (applyDimension != 0) {
                return applyDimension;
            }
            float f4 = this.mValue;
            if (f4 == 0.0f) {
                return 0;
            }
            return f4 > 0.0f ? 1 : -1;
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public abstract class DrawableLoader {
        public abstract Drawable newDrawable(ources ourcesVar, int i4);

        public Drawable newDrawableForDensity(ources ourcesVar, int i4, int i5) {
            return newDrawable(ourcesVar, i4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public class ResourceNames {
        public final String fullName;
        public final int id;
        public final String name;
        public final String pkg;
        public final String type;

        public /* synthetic */ ResourceNames(int i4, String str, String str2, String str3, int i5) {
            this(i4, str, str2, str3);
        }

        public boolean equals(String str, String str2, String str3, int i4) {
            return (str == null || str.equals(this.pkg)) && (str2 == null || str2.equals(this.name)) && ((str3 == null || str3.equals(this.type)) && (i4 == 0 || i4 == this.id));
        }

        private ResourceNames(int i4, String str, String str2, String str3) {
            this.id = i4;
            this.pkg = str;
            this.name = str2;
            this.type = str3;
            this.fullName = str + ":" + str3 + TTPathConst.sSeparator + str2;
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    class XMLInstanceDetails {
        public final XposedBridge.CopyOnWriteSortedSet callbacks;
        public final ources res;
        public final ResourceNames resNames;
        public final String variant;

        public /* synthetic */ XMLInstanceDetails(ources ourcesVar, ResourceNames resourceNames, String str, XposedBridge.CopyOnWriteSortedSet copyOnWriteSortedSet, int i4) {
            this(resourceNames, str, copyOnWriteSortedSet);
        }

        private XMLInstanceDetails(ResourceNames resourceNames, String str, XposedBridge.CopyOnWriteSortedSet copyOnWriteSortedSet) {
            ources.this = r1;
            this.res = r1;
            this.resNames = resourceNames;
            this.variant = str;
            this.callbacks = copyOnWriteSortedSet;
        }
    }

    public ources(ClassLoader classLoader, String str) {
        super(classLoader);
        this.mResDir = str;
        this.mPackageName = getPackageName(str);
        if (str != null) {
            HashMap hashMap = sReplacementsCacheMap;
            synchronized (hashMap) {
                this.mReplacementsCache = (byte[]) hashMap.computeIfAbsent(str, new L0(0));
            }
        }
    }

    public static int getFakeResId(String str) {
        return (str.hashCode() & 16777215) | 2113929216;
    }

    public static String getPackageNameDuringConstruction() {
        Object obj;
        ThreadLocal threadLocal = sLatestResKey;
        if (threadLocal == null || (obj = threadLocal.get()) == null) {
            throw new IllegalStateException("This method can only be called during getTopLevelResources()");
        }
        return getPackageName((String) XposedHelpers.getObjectField(obj, "mResDir"));
    }

    public Object getReplacement(int i4) {
        HashMap hashMap;
        if (i4 <= 0) {
            return null;
        }
        if (i4 < 2130706432) {
            if ((sSystemReplacementsCache[((i4 & 458752) >> 11) | ((i4 & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT) >> 3)] & (1 << (i4 & 7))) == 0) {
                return null;
            }
        } else if (this.mResDir != null) {
            if ((this.mReplacementsCache[((i4 & 458752) >> 12) | ((i4 & 120) >> 3)] & (1 << (i4 & 7))) == 0) {
                return null;
            }
        }
        SparseArray sparseArray = sReplacements;
        synchronized (sparseArray) {
            hashMap = (HashMap) sparseArray.get(i4);
        }
        if (hashMap == null) {
            return null;
        }
        synchronized (hashMap) {
            try {
                Object obj = hashMap.get(this.mResDir);
                if (obj == null && this.mResDir != null) {
                    return hashMap.get(null);
                }
                return obj;
            } finally {
            }
        }
    }

    private ResourceNames getResourceNames(int i4) {
        return new ResourceNames(i4, getResourcePackageName(i4), getResourceTypeName(i4), getResourceEntryName(i4), 0);
    }

    private static ResourceNames getSystemResourceNames(int i4) {
        Resources system = getSystem();
        return new ResourceNames(i4, system.getResourcePackageName(i4), system.getResourceTypeName(i4), system.getResourceEntryName(i4), 0);
    }

    private static XC_LayoutInflated.Unhook hookLayoutInternal(String str, int i4, ResourceNames resourceNames, XC_LayoutInflated xC_LayoutInflated) {
        HashMap hashMap;
        XposedBridge.CopyOnWriteSortedSet copyOnWriteSortedSet;
        if (i4 != 0) {
            if (str == null) {
                try {
                    XposedInit.hookResources();
                } catch (Throwable th) {
                    throw new IllegalStateException("Failed to initialize resources hook", th);
                }
            }
            SparseArray sparseArray = sLayoutCallbacks;
            synchronized (sparseArray) {
                try {
                    hashMap = (HashMap) sparseArray.get(i4);
                    if (hashMap == null) {
                        hashMap = new HashMap();
                        sparseArray.put(i4, hashMap);
                    }
                } finally {
                }
            }
            synchronized (hashMap) {
                try {
                    copyOnWriteSortedSet = (XposedBridge.CopyOnWriteSortedSet) hashMap.get(str);
                    if (copyOnWriteSortedSet == null) {
                        copyOnWriteSortedSet = new XposedBridge.CopyOnWriteSortedSet();
                        hashMap.put(str, copyOnWriteSortedSet);
                    }
                } finally {
                }
            }
            copyOnWriteSortedSet.add(xC_LayoutInflated);
            putResourceNames(str, resourceNames);
            Objects.requireNonNull(xC_LayoutInflated);
            return new XC_LayoutInflated.Unhook(str, i4);
        }
        throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
    }

    public static XC_LayoutInflated.Unhook hookSystemWideLayout(int i4, XC_LayoutInflated xC_LayoutInflated) {
        if (i4 < 2130706432) {
            return hookLayoutInternal(null, i4, getSystemResourceNames(i4), xC_LayoutInflated);
        }
        throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
    }

    public static void init(ThreadLocal threadLocal) {
        sLatestResKey = threadLocal;
        XposedHelpers.findAndHookMethod(LayoutInflater.class, "inflate", XmlPullParser.class, ViewGroup.class, Boolean.TYPE, new XC_MethodHook() { // from class: CyVHHabzCrUqKeyhTwFaxBD.ources.1
            @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
            public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
                XMLInstanceDetails xMLInstanceDetails;
                if (methodHookParam.hasThrowable()) {
                    return;
                }
                synchronized (ources.sXmlInstanceDetails) {
                    xMLInstanceDetails = (XMLInstanceDetails) ources.sXmlInstanceDetails.get(methodHookParam.args[0]);
                }
                if (xMLInstanceDetails != null) {
                    XC_LayoutInflated.LayoutInflatedParam layoutInflatedParam = new XC_LayoutInflated.LayoutInflatedParam(xMLInstanceDetails.callbacks);
                    layoutInflatedParam.view = (View) methodHookParam.getResult();
                    layoutInflatedParam.resNames = xMLInstanceDetails.resNames;
                    layoutInflatedParam.variant = xMLInstanceDetails.variant;
                    layoutInflatedParam.res = xMLInstanceDetails.res;
                    XCallback.callAll(layoutInflatedParam);
                }
            }
        });
        XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", XmlPullParser.class, Context.class, View.class, AttributeSet.class, new XC_MethodHook() { // from class: CyVHHabzCrUqKeyhTwFaxBD.ources.2
            @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
            public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
                XMLInstanceDetails xMLInstanceDetails;
                ((LinkedList) ources.sIncludedLayouts.get()).pop();
                if (methodHookParam.hasThrowable() || (xMLInstanceDetails = (XMLInstanceDetails) methodHookParam.getObjectExtra(ources.EXTRA_XML_INSTANCE_DETAILS)) == null) {
                    return;
                }
                XC_LayoutInflated.LayoutInflatedParam layoutInflatedParam = new XC_LayoutInflated.LayoutInflatedParam(xMLInstanceDetails.callbacks);
                ViewGroup viewGroup = (ViewGroup) methodHookParam.args[2];
                layoutInflatedParam.view = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                layoutInflatedParam.resNames = xMLInstanceDetails.resNames;
                layoutInflatedParam.variant = xMLInstanceDetails.variant;
                layoutInflatedParam.res = xMLInstanceDetails.res;
                XCallback.callAll(layoutInflatedParam);
            }

            @Override // ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook
            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
                ((LinkedList) ources.sIncludedLayouts.get()).push(methodHookParam);
            }
        });
    }

    private static boolean isXmlCached(Resources resources, int i4) {
        int[] iArr = (int[]) XposedHelpers.getObjectField(XposedHelpers.getObjectField(resources, "mResourcesImpl"), "mCachedXmlBlockCookies");
        synchronized (iArr) {
            try {
                for (int i5 : iArr) {
                    if (i5 == i4) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ byte[] lambda$new$1(String str) {
        return new byte[128];
    }

    public static /* synthetic */ LinkedList lambda$static$0() {
        return new LinkedList();
    }

    private static void putResourceNames(String str, ResourceNames resourceNames) {
        int i4 = resourceNames.id;
        SparseArray sparseArray = sResourceNames;
        synchronized (sparseArray) {
            try {
                HashMap hashMap = (HashMap) sparseArray.get(i4);
                if (hashMap == null) {
                    hashMap = new HashMap();
                    sparseArray.put(i4, hashMap);
                }
                synchronized (hashMap) {
                    hashMap.put(str, resourceNames);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setPackageNameForResDir(String str, String str2) {
        HashMap hashMap = sResDirPackageNames;
        synchronized (hashMap) {
            hashMap.put(str2, str);
        }
    }

    public static void setSystemWideReplacement(int i4, Object obj) {
        setReplacement(i4, obj, null);
    }

    private static int translateAttrId(String str, ources ourcesVar) {
        try {
            return ourcesVar.getIdentifier(str, "attr", ourcesVar.mPackageName);
        } catch (Resources.NotFoundException unused) {
            XposedBridge.log("Attribute " + str + " not found in original resources");
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0023, code lost:
        if (r4.data != 0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0053 A[Catch: Exception -> 0x0010, TryCatch #0 {Exception -> 0x0010, blocks: (B:39:0x0000, B:41:0x000b, B:46:0x0013, B:48:0x0021, B:55:0x002e, B:57:0x0034, B:60:0x0053, B:62:0x0059, B:64:0x005f), top: B:69:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int translateResId(int r7, CyVHHabzCrUqKeyhTwFaxBD.ources r8, android.content.res.Resources r9) {
        /*
            java.lang.String r0 = r9.getResourceEntryName(r7)     // Catch: java.lang.Exception -> L10
            java.lang.String r1 = r9.getResourceTypeName(r7)     // Catch: java.lang.Exception -> L10
            java.lang.String r2 = r8.mPackageName     // Catch: java.lang.Exception -> L10
            r3 = 0
            int r2 = r8.getIdentifier(r0, r1, r2)     // Catch: java.lang.Exception -> L10 android.content.res.Resources.NotFoundException -> L12
            goto L13
        L10:
            r8 = move-exception
            goto L68
        L12:
            r2 = r3
        L13:
            android.util.TypedValue r4 = new android.util.TypedValue     // Catch: java.lang.Exception -> L10 android.content.res.Resources.NotFoundException -> L27
            r4.<init>()     // Catch: java.lang.Exception -> L10 android.content.res.Resources.NotFoundException -> L27
            r9.getValue(r7, r4, r3)     // Catch: java.lang.Exception -> L10 android.content.res.Resources.NotFoundException -> L27
            int r5 = r4.type     // Catch: java.lang.Exception -> L10 android.content.res.Resources.NotFoundException -> L27
            r6 = 18
            if (r5 != r6) goto L25
            int r4 = r4.data     // Catch: java.lang.Exception -> L10 android.content.res.Resources.NotFoundException -> L27
            if (r4 == 0) goto L27
        L25:
            r4 = 1
            goto L28
        L27:
            r4 = r3
        L28:
            java.lang.String r5 = "id"
            if (r4 != 0) goto L51
            if (r2 != 0) goto L51
            boolean r6 = r1.equals(r5)     // Catch: java.lang.Exception -> L10
            if (r6 != 0) goto L51
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L10
            r8.<init>()     // Catch: java.lang.Exception -> L10
            r8.append(r1)     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = "/"
            r8.append(r9)     // Catch: java.lang.Exception -> L10
            r8.append(r0)     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = " is neither defined in module nor in original resources"
            r8.append(r9)     // Catch: java.lang.Exception -> L10
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L10
            ulL.WeEFDVoZmmWVmW.yXd.XposedBridge.log(r8)     // Catch: java.lang.Exception -> L10
            return r3
        L51:
            if (r2 != 0) goto L57
            int r2 = getFakeResId(r9, r7)     // Catch: java.lang.Exception -> L10
        L57:
            if (r4 == 0) goto L67
            boolean r0 = r1.equals(r5)     // Catch: java.lang.Exception -> L10
            if (r0 != 0) goto L67
            CyVHHabzCrUqKeyhTwFaxBD.Forwarder r0 = new CyVHHabzCrUqKeyhTwFaxBD.Forwarder     // Catch: java.lang.Exception -> L10
            r0.<init>(r9, r7)     // Catch: java.lang.Exception -> L10
            r8.setReplacement(r2, r0)     // Catch: java.lang.Exception -> L10
        L67:
            return r2
        L68:
            ulL.WeEFDVoZmmWVmW.yXd.XposedBridge.log(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: CyVHHabzCrUqKeyhTwFaxBD.ources.translateResId(int, CyVHHabzCrUqKeyhTwFaxBD.ources, android.content.res.Resources):int");
    }

    public static void unhookLayout(String str, int i4, XC_LayoutInflated xC_LayoutInflated) {
        SparseArray sparseArray = sLayoutCallbacks;
        synchronized (sparseArray) {
            try {
                HashMap hashMap = (HashMap) sparseArray.get(i4);
                if (hashMap == null) {
                    return;
                }
                synchronized (hashMap) {
                    try {
                        XposedBridge.CopyOnWriteSortedSet copyOnWriteSortedSet = (XposedBridge.CopyOnWriteSortedSet) hashMap.get(str);
                        if (copyOnWriteSortedSet == null) {
                            return;
                        }
                        copyOnWriteSortedSet.remove(xC_LayoutInflated);
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    public int addResource(Resources resources, int i4) {
        int fakeResId = getFakeResId(resources, i4);
        SparseArray sparseArray = sReplacements;
        synchronized (sparseArray) {
            try {
                if (sparseArray.indexOfKey(fakeResId) < 0) {
                    setReplacement(fakeResId, new Forwarder(resources, i4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fakeResId;
    }

    public XmlResourceParser getAnimation(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            Resources resources = forwarder.getResources();
            int id = forwarder.getId();
            boolean isXmlCached = isXmlCached(resources, id);
            XmlResourceParser animation = resources.getAnimation(id);
            if (!isXmlCached) {
                ResourcesHook.rewriteXmlReferencesNative(XposedHelpers.getLongField(animation, "mParseState"), this, resources);
            }
            return animation;
        }
        return super.getAnimation(i4);
    }

    public boolean getBoolean(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Boolean) {
            return ((Boolean) replacement).booleanValue();
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getBoolean(forwarder.getId());
        }
        return super.getBoolean(i4);
    }

    public int getColor(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Integer) {
            return ((Integer) replacement).intValue();
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getColor(forwarder.getId());
        }
        return super.getColor(i4);
    }

    public ColorStateList getColorStateList(int i4) {
        ColorStateList colorStateList;
        Object replacement = getReplacement(i4);
        if (replacement instanceof ColorStateList) {
            return (ColorStateList) replacement;
        }
        if (!(replacement instanceof Integer)) {
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getColorStateList(forwarder.getId());
            }
            return super.getColorStateList(i4);
        }
        int intValue = ((Integer) replacement).intValue();
        SparseArray sparseArray = sColorStateListCache;
        synchronized (sparseArray) {
            try {
                colorStateList = (ColorStateList) sparseArray.get(intValue);
                if (colorStateList == null) {
                    colorStateList = ColorStateList.valueOf(intValue);
                    sparseArray.put(intValue, colorStateList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return colorStateList;
    }

    public float getDimension(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof DimensionReplacement) {
            return ((DimensionReplacement) replacement).getDimension(getDisplayMetrics());
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getDimension(forwarder.getId());
        }
        return super.getDimension(i4);
    }

    public int getDimensionPixelOffset(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof DimensionReplacement) {
            return ((DimensionReplacement) replacement).getDimensionPixelOffset(getDisplayMetrics());
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getDimensionPixelOffset(forwarder.getId());
        }
        return super.getDimensionPixelOffset(i4);
    }

    public int getDimensionPixelSize(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof DimensionReplacement) {
            return ((DimensionReplacement) replacement).getDimensionPixelSize(getDisplayMetrics());
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getDimensionPixelSize(forwarder.getId());
        }
        return super.getDimensionPixelSize(i4);
    }

    public Drawable getDrawable(int i4) {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(i4);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawable = ((DrawableLoader) replacement).newDrawable(this, i4);
                    if (newDrawable != null) {
                        XposedHelpers.decrementMethodDepth("getDrawable");
                        return newDrawable;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return colorDrawable;
                } else if (replacement instanceof Forwarder) {
                    Drawable drawable = ((Forwarder) replacement).getResources().getDrawable(((Forwarder) replacement).getId());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return drawable;
                }
            }
            Drawable drawable2 = super.getDrawable(i4);
            XposedHelpers.decrementMethodDepth("getDrawable");
            return drawable2;
        } catch (Throwable th) {
            XposedHelpers.decrementMethodDepth("getDrawable");
            throw th;
        }
    }

    public Drawable getDrawableForDensity(int i4, int i5) {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(i4);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawableForDensity = ((DrawableLoader) replacement).newDrawableForDensity(this, i4, i5);
                    if (newDrawableForDensity != null) {
                        XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                        return newDrawableForDensity;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return colorDrawable;
                } else if (replacement instanceof Forwarder) {
                    Drawable drawableForDensity = ((Forwarder) replacement).getResources().getDrawableForDensity(((Forwarder) replacement).getId(), i5);
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return drawableForDensity;
                }
            }
            Drawable drawableForDensity2 = super.getDrawableForDensity(i4, i5);
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
            return drawableForDensity2;
        } catch (Throwable th) {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
            throw th;
        }
    }

    public float getFloat(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Float) {
            return ((Float) replacement).floatValue();
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getFloat(forwarder.getId());
        }
        return super.getFloat(i4);
    }

    public Typeface getFont(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Typeface) {
            return (Typeface) replacement;
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getFont(forwarder.getId());
        }
        return super.getFont(i4);
    }

    public float getFraction(int i4, int i5, int i6) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getFraction(forwarder.getId(), i5, i6);
        }
        return super.getFraction(i4, i5, i6);
    }

    public int[] getIntArray(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof int[]) {
            return (int[]) replacement;
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getIntArray(forwarder.getId());
        }
        return super.getIntArray(i4);
    }

    public int getInteger(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Integer) {
            return ((Integer) replacement).intValue();
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getInteger(forwarder.getId());
        }
        return super.getInteger(i4);
    }

    public XmlResourceParser getLayout(int i4) {
        XmlResourceParser layout;
        HashMap hashMap;
        XposedBridge.CopyOnWriteSortedSet copyOnWriteSortedSet;
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            Resources resources = forwarder.getResources();
            int id = forwarder.getId();
            boolean isXmlCached = isXmlCached(resources, id);
            layout = resources.getLayout(id);
            if (!isXmlCached) {
                ResourcesHook.rewriteXmlReferencesNative(XposedHelpers.getLongField(layout, "mParseState"), this, resources);
            }
        } else {
            layout = super.getLayout(i4);
        }
        SparseArray sparseArray = sLayoutCallbacks;
        synchronized (sparseArray) {
            hashMap = (HashMap) sparseArray.get(i4);
        }
        if (hashMap != null) {
            synchronized (hashMap) {
                try {
                    XposedBridge.CopyOnWriteSortedSet copyOnWriteSortedSet2 = (XposedBridge.CopyOnWriteSortedSet) hashMap.get(this.mResDir);
                    if (copyOnWriteSortedSet2 == null && this.mResDir != null) {
                        copyOnWriteSortedSet2 = (XposedBridge.CopyOnWriteSortedSet) hashMap.get(null);
                    }
                    copyOnWriteSortedSet = copyOnWriteSortedSet2;
                } finally {
                }
            }
            if (copyOnWriteSortedSet != null) {
                String str = "layout";
                TypedValue typedValue = (TypedValue) XposedHelpers.getObjectField(this, "mTmpValue");
                getValue(i4, typedValue, true);
                if (typedValue.type == 3) {
                    String[] split = typedValue.string.toString().split(TTPathConst.sSeparator, 3);
                    if (split.length == 3) {
                        str = split[1];
                    } else {
                        XposedBridge.log("Unexpected resource path \"" + typedValue.string.toString() + "\" for resource id 0x" + Integer.toHexString(i4));
                    }
                } else {
                    XposedBridge.log(new Resources.NotFoundException("Could not find file name for resource id 0x") + Integer.toHexString(i4));
                }
                String str2 = str;
                WeakHashMap weakHashMap = sXmlInstanceDetails;
                synchronized (weakHashMap) {
                    SparseArray sparseArray2 = sResourceNames;
                    synchronized (sparseArray2) {
                        HashMap hashMap2 = (HashMap) sparseArray2.get(i4);
                        if (hashMap2 != null) {
                            synchronized (hashMap2) {
                                try {
                                    XMLInstanceDetails xMLInstanceDetails = new XMLInstanceDetails(this, (ResourceNames) hashMap2.get(this.mResDir), str2, copyOnWriteSortedSet, 0);
                                    weakHashMap.put(layout, xMLInstanceDetails);
                                    XC_MethodHook.MethodHookParam methodHookParam = (XC_MethodHook.MethodHookParam) ((LinkedList) sIncludedLayouts.get()).peek();
                                    if (methodHookParam != null) {
                                        methodHookParam.setObjectExtra(EXTRA_XML_INSTANCE_DETAILS, xMLInstanceDetails);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
            }
        }
        return layout;
    }

    public Movie getMovie(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getMovie(forwarder.getId());
        }
        return super.getMovie(i4);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public CharSequence getQuantityText(int i4, int i5) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getQuantityText(forwarder.getId(), i5);
        }
        return super.getQuantityText(i4, i5);
    }

    public String[] getStringArray(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof String[]) {
            return (String[]) replacement;
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getStringArray(forwarder.getId());
        }
        return super.getStringArray(i4);
    }

    public CharSequence getText(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof CharSequence) {
            return (CharSequence) replacement;
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getText(forwarder.getId());
        }
        return super.getText(i4);
    }

    public CharSequence[] getTextArray(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof CharSequence[]) {
            return (CharSequence[]) replacement;
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getTextArray(forwarder.getId());
        }
        return super.getTextArray(i4);
    }

    public void getValue(int i4, TypedValue typedValue, boolean z3) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            forwarder.getResources().getValue(forwarder.getId(), typedValue, z3);
            return;
        }
        if (replacement != null) {
            XposedBridge.log("Replacement of resource ID #0x" + Integer.toHexString(i4) + " escaped because of deprecated replacement. Please use XResForwarder instead.");
        }
        super.getValue(i4, typedValue, z3);
    }

    public void getValueForDensity(int i4, int i5, TypedValue typedValue, boolean z3) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            forwarder.getResources().getValueForDensity(forwarder.getId(), i5, typedValue, z3);
            return;
        }
        if (replacement != null) {
            XposedBridge.log("Replacement of resource ID #0x" + Integer.toHexString(i4) + " escaped because of deprecated replacement. Please use XResForwarder instead.");
        }
        super.getValueForDensity(i4, i5, typedValue, z3);
    }

    public XmlResourceParser getXml(int i4) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            Resources resources = forwarder.getResources();
            int id = forwarder.getId();
            boolean isXmlCached = isXmlCached(resources, id);
            XmlResourceParser xml = resources.getXml(id);
            if (!isXmlCached) {
                ResourcesHook.rewriteXmlReferencesNative(XposedHelpers.getLongField(xml, "mParseState"), this, resources);
            }
            return xml;
        }
        return super.getXml(i4);
    }

    public XC_LayoutInflated.Unhook hookLayout(int i4, XC_LayoutInflated xC_LayoutInflated) {
        return hookLayoutInternal(this.mResDir, i4, getResourceNames(i4), xC_LayoutInflated);
    }

    public boolean isFirstLoad() {
        synchronized (sReplacements) {
            try {
                if (this.mResDir == null) {
                    return false;
                }
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                Long valueOf = Long.valueOf(new File(this.mResDir).lastModified());
                HashMap hashMap = sResDirLastModified;
                Long l4 = (Long) hashMap.get(this.mResDir);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                if (valueOf.equals(l4)) {
                    return false;
                }
                hashMap.put(this.mResDir, valueOf);
                if (l4 == null) {
                    return true;
                }
                int i4 = 0;
                while (true) {
                    SparseArray sparseArray = sReplacements;
                    if (i4 >= sparseArray.size()) {
                        Arrays.fill(this.mReplacementsCache, (byte) 0);
                        return true;
                    }
                    ((HashMap) sparseArray.valueAt(i4)).remove(this.mResDir);
                    i4++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setReplacement(int i4, Object obj) {
        setReplacement(i4, obj, this);
    }

    public static int getFakeResId(Resources resources, int i4) {
        return getFakeResId(resources.getResourceName(i4));
    }

    private static String getPackageName(String str) {
        String str2;
        String str3;
        if (str == null) {
            return "android";
        }
        HashMap hashMap = sResDirPackageNames;
        synchronized (hashMap) {
            str2 = (String) hashMap.get(str);
        }
        if (str2 != null) {
            return str2;
        }
        try {
            PackageParser.PackageLite parsePackageLite = PackageParser.parsePackageLite(new File(str), 0);
            if (parsePackageLite != null && (str3 = parsePackageLite.packageName) != null) {
                setPackageNameForResDir(str3, str);
                return str3;
            }
            throw new IllegalStateException("Could not determine package name for ".concat(str));
        } catch (PackageParser.PackageParserException e4) {
            throw new IllegalStateException("Could not determine package name for ".concat(str), e4);
        }
    }

    @Deprecated
    public static void setSystemWideReplacement(String str, Object obj) {
        int identifier = getSystem().getIdentifier(str, null, null);
        if (identifier != 0) {
            setReplacement(identifier, obj, null);
            return;
        }
        throw new Resources.NotFoundException(str);
    }

    @Deprecated
    public XC_LayoutInflated.Unhook hookLayout(String str, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getIdentifier(str, null, null);
        if (identifier != 0) {
            return hookLayout(identifier, xC_LayoutInflated);
        }
        throw new Resources.NotFoundException(str);
    }

    @Deprecated
    public void setReplacement(String str, Object obj) {
        int identifier = getIdentifier(str, null, null);
        if (identifier != 0) {
            setReplacement(identifier, obj, this);
            return;
        }
        throw new Resources.NotFoundException(str);
    }

    @Deprecated
    public static XC_LayoutInflated.Unhook hookSystemWideLayout(String str, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getSystem().getIdentifier(str, null, null);
        if (identifier != 0) {
            return hookSystemWideLayout(identifier, xC_LayoutInflated);
        }
        throw new Resources.NotFoundException(str);
    }

    public static void setSystemWideReplacement(String str, String str2, String str3, Object obj) {
        int identifier = getSystem().getIdentifier(str3, str2, str);
        if (identifier != 0) {
            setReplacement(identifier, obj, null);
            return;
        }
        throw new Resources.NotFoundException(str + ":" + str2 + TTPathConst.sSeparator + str3);
    }

    public XC_LayoutInflated.Unhook hookLayout(String str, String str2, String str3, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getIdentifier(str3, str2, str);
        if (identifier != 0) {
            return hookLayout(identifier, xC_LayoutInflated);
        }
        throw new Resources.NotFoundException(str + ":" + str2 + TTPathConst.sSeparator + str3);
    }

    public void setReplacement(String str, String str2, String str3, Object obj) {
        int identifier = getIdentifier(str3, str2, str);
        if (identifier != 0) {
            setReplacement(identifier, obj, this);
            return;
        }
        throw new Resources.NotFoundException(str + ":" + str2 + TTPathConst.sSeparator + str3);
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public class XTypedArray extends XTypedArraySuperClass {
        public XTypedArray(Resources resources) {
            super(resources);
        }

        public boolean getBoolean(int i4, boolean z3) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Boolean) {
                return ((Boolean) replacement).booleanValue();
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getBoolean(forwarder.getId());
            }
            return super.getBoolean(i4, z3);
        }

        public int getColor(int i4, int i5) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Integer) {
                return ((Integer) replacement).intValue();
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getColor(forwarder.getId());
            }
            return super.getColor(i4, i5);
        }

        public ColorStateList getColorStateList(int i4) {
            ColorStateList colorStateList;
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof ColorStateList) {
                return (ColorStateList) replacement;
            }
            if (!(replacement instanceof Integer)) {
                if (replacement instanceof Forwarder) {
                    Forwarder forwarder = (Forwarder) replacement;
                    return forwarder.getResources().getColorStateList(forwarder.getId());
                }
                return super.getColorStateList(i4);
            }
            int intValue = ((Integer) replacement).intValue();
            synchronized (ources.sColorStateListCache) {
                try {
                    colorStateList = (ColorStateList) ources.sColorStateListCache.get(intValue);
                    if (colorStateList == null) {
                        colorStateList = ColorStateList.valueOf(intValue);
                        ources.sColorStateListCache.put(intValue, colorStateList);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return colorStateList;
        }

        public float getDimension(int i4, float f4) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getDimension(forwarder.getId());
            }
            return super.getDimension(i4, f4);
        }

        public int getDimensionPixelOffset(int i4, int i5) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getDimensionPixelOffset(forwarder.getId());
            }
            return super.getDimensionPixelOffset(i4, i5);
        }

        public int getDimensionPixelSize(int i4, int i5) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getDimensionPixelSize(forwarder.getId());
            }
            return super.getDimensionPixelSize(i4, i5);
        }

        public Drawable getDrawable(int i4) {
            int resourceId = getResourceId(i4, 0);
            ources ourcesVar = (ources) getResources();
            Object replacement = ourcesVar.getReplacement(resourceId);
            if (replacement instanceof DrawableLoader) {
                try {
                    Drawable newDrawable = ((DrawableLoader) replacement).newDrawable(ourcesVar, resourceId);
                    if (newDrawable != null) {
                        return newDrawable;
                    }
                } catch (Throwable th) {
                    XposedBridge.log(th);
                }
            } else if (replacement instanceof Integer) {
                return new ColorDrawable(((Integer) replacement).intValue());
            } else {
                if (replacement instanceof Forwarder) {
                    Forwarder forwarder = (Forwarder) replacement;
                    return forwarder.getResources().getDrawable(forwarder.getId());
                }
            }
            return super.getDrawable(i4);
        }

        public float getFloat(int i4, float f4) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getDimension(forwarder.getId());
            }
            return super.getFloat(i4, f4);
        }

        public Typeface getFont(int i4) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Typeface) {
                return (Typeface) replacement;
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getFont(forwarder.getId());
            }
            return super.getFont(i4);
        }

        public float getFraction(int i4, int i5, int i6, float f4) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getFraction(forwarder.getId(), i5, i6);
            }
            return super.getFraction(i4, i5, i6, f4);
        }

        public int getInt(int i4, int i5) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Integer) {
                return ((Integer) replacement).intValue();
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getInteger(forwarder.getId());
            }
            return super.getInt(i4, i5);
        }

        public int getInteger(int i4, int i5) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Integer) {
                return ((Integer) replacement).intValue();
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getInteger(forwarder.getId());
            }
            return super.getInteger(i4, i5);
        }

        public int getLayoutDimension(int i4, int i5) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getDimensionPixelSize(forwarder.getId());
            }
            return super.getLayoutDimension(i4, i5);
        }

        public String getString(int i4) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof CharSequence) {
                return replacement.toString();
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getString(forwarder.getId());
            }
            return super.getString(i4);
        }

        public CharSequence getText(int i4) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof CharSequence) {
                return (CharSequence) replacement;
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getText(forwarder.getId());
            }
            return super.getText(i4);
        }

        public CharSequence[] getTextArray(int i4) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof CharSequence[]) {
                return (CharSequence[]) replacement;
            }
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getTextArray(forwarder.getId());
            }
            return super.getTextArray(i4);
        }

        public boolean getValue(int i4, TypedValue typedValue) {
            int resourceId = getResourceId(i4, 0);
            Object replacement = ((ources) getResources()).getReplacement(resourceId);
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                forwarder.getResources().getValue(forwarder.getId(), typedValue, true);
                return typedValue.type != 0;
            }
            if (replacement != null) {
                XposedBridge.log("Replacement of resource ID #0x" + Integer.toHexString(resourceId) + " escaped because of deprecated replacement. Please use XResForwarder instead.");
            }
            return super.getValue(i4, typedValue);
        }

        public TypedValue peekValue(int i4) {
            int resourceId = getResourceId(i4, 0);
            Object replacement = ((ources) getResources()).getReplacement(resourceId);
            if (replacement instanceof Forwarder) {
                if (XposedHelpers.getBooleanField(this, "mRecycled")) {
                    throw new RuntimeException("Cannot make calls to a recycled instance!");
                }
                TypedValue typedValue = (TypedValue) XposedHelpers.getObjectField(this, "mValue");
                Forwarder forwarder = (Forwarder) replacement;
                forwarder.getResources().getValue(forwarder.getId(), typedValue, true);
                return typedValue;
            }
            if (replacement != null) {
                XposedBridge.log("Replacement of resource ID #0x" + Integer.toHexString(resourceId) + " escaped because of deprecated replacement. Please use XResForwarder instead.");
            }
            return super.peekValue(i4);
        }

        public int getLayoutDimension(int i4, String str) {
            Object replacement = ((ources) getResources()).getReplacement(getResourceId(i4, 0));
            if (replacement instanceof Forwarder) {
                Forwarder forwarder = (Forwarder) replacement;
                return forwarder.getResources().getDimensionPixelSize(forwarder.getId());
            }
            return super.getLayoutDimension(i4, str);
        }
    }

    public static XC_LayoutInflated.Unhook hookSystemWideLayout(String str, String str2, String str3, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getSystem().getIdentifier(str3, str2, str);
        if (identifier != 0) {
            return hookSystemWideLayout(identifier, xC_LayoutInflated);
        }
        throw new Resources.NotFoundException(str + ":" + str2 + TTPathConst.sSeparator + str3);
    }

    private static void setReplacement(int i4, Object obj, ources ourcesVar) {
        String str = ourcesVar != null ? ourcesVar.mResDir : null;
        if (ourcesVar == null) {
            XposedInit.hookResources();
        }
        if (i4 == 0) {
            throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
        }
        if (str == null && i4 >= 2130706432) {
            throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
        }
        if (!(obj instanceof Drawable)) {
            if (i4 < 2130706432) {
                int i5 = ((i4 & 458752) >> 11) | ((i4 & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT) >> 3);
                byte[] bArr = sSystemReplacementsCache;
                synchronized (bArr) {
                    bArr[i5] = (byte) ((1 << (i4 & 7)) | bArr[i5]);
                }
            } else {
                int i6 = ((i4 & 458752) >> 12) | ((i4 & 120) >> 3);
                synchronized (ourcesVar.mReplacementsCache) {
                    byte[] bArr2 = ourcesVar.mReplacementsCache;
                    bArr2[i6] = (byte) ((1 << (i4 & 7)) | bArr2[i6]);
                }
            }
            SparseArray sparseArray = sReplacements;
            synchronized (sparseArray) {
                try {
                    HashMap hashMap = (HashMap) sparseArray.get(i4);
                    if (hashMap == null) {
                        hashMap = new HashMap();
                        sparseArray.put(i4, hashMap);
                    }
                    hashMap.put(str, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Drawable replacements are deprecated since Xposed 2.1. Use DrawableLoader instead.");
    }

    public CharSequence getText(int i4, CharSequence charSequence) {
        Object replacement = getReplacement(i4);
        if (replacement instanceof CharSequence) {
            return (CharSequence) replacement;
        }
        if (replacement instanceof Forwarder) {
            Forwarder forwarder = (Forwarder) replacement;
            return forwarder.getResources().getText(forwarder.getId(), charSequence);
        }
        return super.getText(i4, charSequence);
    }

    public Drawable getDrawable(int i4, Resources.Theme theme) {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(i4);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawable = ((DrawableLoader) replacement).newDrawable(this, i4);
                    if (newDrawable != null) {
                        XposedHelpers.decrementMethodDepth("getDrawable");
                        return newDrawable;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return colorDrawable;
                } else if (replacement instanceof Forwarder) {
                    Drawable drawable = ((Forwarder) replacement).getResources().getDrawable(((Forwarder) replacement).getId());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return drawable;
                }
            }
            Drawable drawable2 = super.getDrawable(i4, theme);
            XposedHelpers.decrementMethodDepth("getDrawable");
            return drawable2;
        } catch (Throwable th) {
            XposedHelpers.decrementMethodDepth("getDrawable");
            throw th;
        }
    }

    public Drawable getDrawableForDensity(int i4, int i5, Resources.Theme theme) {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(i4);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawableForDensity = ((DrawableLoader) replacement).newDrawableForDensity(this, i4, i5);
                    if (newDrawableForDensity != null) {
                        XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                        return newDrawableForDensity;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return colorDrawable;
                } else if (replacement instanceof Forwarder) {
                    Drawable drawableForDensity = ((Forwarder) replacement).getResources().getDrawableForDensity(((Forwarder) replacement).getId(), i5);
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return drawableForDensity;
                }
            }
            Drawable drawableForDensity2 = super.getDrawableForDensity(i4, i5, theme);
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
            return drawableForDensity2;
        } catch (Throwable th) {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
            throw th;
        }
    }
}
