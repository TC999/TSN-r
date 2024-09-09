package com.beizi.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.ad.AdActivity;
import com.beizi.ad.R;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.Hex;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.internal.utilities.W3CEvent;
import com.beizi.ad.internal.view.AdWebView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MRAIDImplementation.java */
@SuppressLint({"InlinedApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    protected static final String[] f14291a = {"default", "expanded"};

    /* renamed from: b  reason: collision with root package name */
    protected final AdWebView f14292b;

    /* renamed from: e  reason: collision with root package name */
    int f14295e;

    /* renamed from: f  reason: collision with root package name */
    int f14296f;

    /* renamed from: g  reason: collision with root package name */
    int f14297g;

    /* renamed from: j  reason: collision with root package name */
    boolean f14300j;

    /* renamed from: l  reason: collision with root package name */
    private int f14302l;

    /* renamed from: m  reason: collision with root package name */
    private int f14303m;

    /* renamed from: n  reason: collision with root package name */
    private Activity f14304n;

    /* renamed from: o  reason: collision with root package name */
    private ViewGroup f14305o;

    /* renamed from: q  reason: collision with root package name */
    private int f14307q;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14301k = false;

    /* renamed from: c  reason: collision with root package name */
    boolean f14293c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f14294d = false;

    /* renamed from: h  reason: collision with root package name */
    boolean f14298h = false;

    /* renamed from: i  reason: collision with root package name */
    boolean f14299i = false;

    /* renamed from: p  reason: collision with root package name */
    private int[] f14306p = new int[4];

    /* renamed from: r  reason: collision with root package name */
    private boolean f14308r = false;

    /* renamed from: s  reason: collision with root package name */
    private g f14309s = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MRAIDImplementation.java */
    /* renamed from: com.beizi.ad.internal.view.f$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14316a;

        static {
            int[] iArr = new int[AdActivity.b.values().length];
            f14316a = iArr;
            try {
                iArr[AdActivity.b.landscape.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14316a[AdActivity.b.portrait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14316a[AdActivity.b.none.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MRAIDImplementation.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        top_left,
        top_right,
        center,
        bottom_left,
        bottom_right,
        top_center,
        bottom_center
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MRAIDImplementation.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        STARTING_DEFAULT,
        STARTING_EXPANDED
    }

    public f(AdWebView adWebView) {
        this.f14292b = adWebView;
    }

    private void c(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = Uri.decode((String) next.second);
            }
        }
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.f14292b.b(str);
        this.f14292b.c();
    }

    private void d(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.store_picture_error));
            return;
        }
        final String decode = Uri.decode(str);
        AlertDialog.Builder builder = new AlertDialog.Builder(ViewUtil.getTopContext(this.f14292b));
        builder.setTitle(R.string.store_picture_title);
        builder.setMessage(R.string.store_picture_message);
        builder.setPositiveButton(R.string.store_picture_accept, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.f.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v49 */
            @Override // android.content.DialogInterface.OnClickListener
            @SuppressLint({"NewApi"})
            public void onClick(DialogInterface dialogInterface, int i4) {
                String str2;
                String string;
                FileOutputStream fileOutputStream;
                int i5;
                int i6;
                byte[] decode2;
                try {
                    if (decode.startsWith("data:")) {
                        String str3 = ".png";
                        if (decode.contains("image/gif")) {
                            str3 = ".gif";
                        } else {
                            if (!decode.contains("image/jpeg") && !decode.contains("image/pjpeg")) {
                                if (!decode.contains("image/png")) {
                                    if (decode.contains("image/tiff")) {
                                        str3 = ".tif";
                                    } else if (decode.contains("image/svg+xml")) {
                                        str3 = ".svg";
                                    }
                                }
                            }
                            str3 = ".jpg";
                        }
                        boolean contains = decode.contains("base64");
                        File b4 = com.beizi.ad.lance.a.h.b(f.this.f14292b.getContext());
                        File file = new File(b4, System.currentTimeMillis() + str3);
                        FileOutputStream fileOutputStream2 = 0;
                        try {
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    boolean canWrite = file.canWrite();
                                    i5 = canWrite;
                                    if (canWrite) {
                                        if (!contains) {
                                            String str4 = decode;
                                            int lastIndexOf = str4.lastIndexOf(",") + 1;
                                            decode2 = Hex.hexStringToByteArray(str4.substring(lastIndexOf, decode.length()));
                                            i6 = lastIndexOf;
                                        } else {
                                            String str5 = decode;
                                            i6 = false;
                                            decode2 = Base64.decode(str5.substring(str5.lastIndexOf(",") + 1, decode.length()), 0);
                                        }
                                        fileOutputStream.write(decode2);
                                        i5 = i6;
                                    }
                                } catch (FileNotFoundException unused) {
                                    fileOutputStream2 = fileOutputStream;
                                    HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.store_picture_error));
                                    fileOutputStream2 = fileOutputStream2;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            fileOutputStream2 = fileOutputStream2;
                                        } catch (IOException unused2) {
                                            str2 = HaoboLog.mraidLogTag;
                                            string = HaoboLog.getString(R.string.store_picture_error);
                                            HaoboLog.d(str2, string);
                                            f.this.f14292b.c();
                                        }
                                    }
                                    f.this.f14292b.c();
                                } catch (IOException unused3) {
                                    fileOutputStream2 = fileOutputStream;
                                    HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.store_picture_error));
                                    fileOutputStream2 = fileOutputStream2;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            fileOutputStream2 = fileOutputStream2;
                                        } catch (IOException unused4) {
                                            str2 = HaoboLog.mraidLogTag;
                                            string = HaoboLog.getString(R.string.store_picture_error);
                                            HaoboLog.d(str2, string);
                                            f.this.f14292b.c();
                                        }
                                    }
                                    f.this.f14292b.c();
                                } catch (IllegalArgumentException unused5) {
                                    fileOutputStream2 = fileOutputStream;
                                    HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.store_picture_error));
                                    fileOutputStream2 = fileOutputStream2;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            fileOutputStream2 = fileOutputStream2;
                                        } catch (IOException unused6) {
                                            str2 = HaoboLog.mraidLogTag;
                                            string = HaoboLog.getString(R.string.store_picture_error);
                                            HaoboLog.d(str2, string);
                                            f.this.f14292b.c();
                                        }
                                    }
                                    f.this.f14292b.c();
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream2 = fileOutputStream;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException unused7) {
                                            HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.store_picture_error));
                                        }
                                    }
                                    throw th;
                                }
                            } catch (FileNotFoundException unused8) {
                            } catch (IOException unused9) {
                            } catch (IllegalArgumentException unused10) {
                            }
                            try {
                                fileOutputStream.close();
                                fileOutputStream2 = i5;
                            } catch (IOException unused11) {
                                str2 = HaoboLog.mraidLogTag;
                                string = HaoboLog.getString(R.string.store_picture_error);
                                HaoboLog.d(str2, string);
                                f.this.f14292b.c();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    f.this.f14292b.c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
        builder.setNegativeButton(R.string.store_picture_decline, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.f.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
            }
        });
        builder.create().show();
    }

    private void e() {
        Activity activity = (Activity) this.f14292b.getContextFromMutableContext();
        this.f14292b.getLocationOnScreen(r2);
        int[] iArr = {0, iArr[1] - activity.getWindow().findViewById(16908290).getTop()};
        this.f14292b.measure(0, 0);
        int[] iArr2 = {this.f14292b.getMeasuredWidth(), this.f14292b.getMeasuredHeight()};
        ViewUtil.convertFromPixelsToDP(activity, iArr2);
        this.f14292b.c(String.format("javascript:window.mraid.util.setDefaultPosition(%d, %d, %d, %d)", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1])));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1f
            int r0 = r2.size()     // Catch: java.io.UnsupportedEncodingException -> L1e
            if (r0 <= 0) goto L1f
            r0 = 0
            java.lang.Object r2 = r2.get(r0)     // Catch: java.io.UnsupportedEncodingException -> L1e
            android.util.Pair r2 = (android.util.Pair) r2     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.Object r2 = r2.second     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.String r0 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r0)     // Catch: java.io.UnsupportedEncodingException -> L1e
            com.beizi.ad.internal.utilities.W3CEvent r2 = com.beizi.ad.internal.utilities.W3CEvent.createFromJSON(r2)     // Catch: java.io.UnsupportedEncodingException -> L1e
            goto L20
        L1e:
            return
        L1f:
            r2 = 0
        L20:
            if (r2 == 0) goto L44
            android.content.Intent r2 = r2.getInsertIntent()     // Catch: java.lang.Exception -> L44
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r2.setFlags(r0)     // Catch: java.lang.Exception -> L44
            com.beizi.ad.internal.view.AdWebView r0 = r1.f14292b     // Catch: java.lang.Exception -> L44
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> L44
            r0.startActivity(r2)     // Catch: java.lang.Exception -> L44
            com.beizi.ad.internal.view.AdWebView r2 = r1.f14292b     // Catch: java.lang.Exception -> L44
            r2.c()     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = com.beizi.ad.internal.utilities.HaoboLog.mraidLogTag     // Catch: java.lang.Exception -> L44
            int r0 = com.beizi.ad.R.string.create_calendar_event     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = com.beizi.ad.internal.utilities.HaoboLog.getString(r0)     // Catch: java.lang.Exception -> L44
            com.beizi.ad.internal.utilities.HaoboLog.d(r2, r0)     // Catch: java.lang.Exception -> L44
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.view.f.f(java.util.ArrayList):void");
    }

    private void g(ArrayList<Pair<String, String>> arrayList) {
        AdActivity.b bVar = AdActivity.b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        int i4 = 1;
        boolean z3 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("allow_orientation_change")) {
                z3 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                bVar = a((String) next.second);
            }
        }
        if (this.f14293c || this.f14292b.adViewImpl.e()) {
            AdWebView adWebView = this.f14292b;
            Activity c4 = adWebView.f14193a ? c() : (Activity) ViewUtil.getTopContext(adWebView);
            if (z3) {
                AdActivity.b(c4);
                return;
            }
            int i5 = AnonymousClass4.f14316a[bVar.ordinal()];
            if (i5 == 1) {
                i4 = 2;
            } else if (i5 != 2) {
                i4 = 0;
            }
            AdActivity.a(c4, i4);
        }
    }

    private void h(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        int i4 = 0;
        int i5 = -1;
        String str = "top-right";
        int i6 = -1;
        int i7 = 0;
        boolean z3 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            try {
                if (((String) next.first).equals("w")) {
                    i5 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("h")) {
                    i6 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_x")) {
                    i4 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_y")) {
                    i7 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("custom_close_position")) {
                    str = (String) next.second;
                } else if (((String) next.first).equals("allow_offscreen")) {
                    z3 = Boolean.parseBoolean((String) next.second);
                }
            } catch (NumberFormatException unused) {
                HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.number_format));
                return;
            }
        }
        if (i5 > this.f14302l && i6 > this.f14303m) {
            this.f14292b.c("javascript:mraid.util.errorEvent('Resize called with resizeProperties larger than the screen.', 'mraid.resize()')");
            return;
        }
        a aVar = a.top_right;
        try {
            aVar = a.valueOf(str.replace('-', '_'));
        } catch (IllegalArgumentException unused2) {
        }
        int i8 = i5;
        int i9 = i6;
        int i10 = i4;
        int i11 = i7;
        boolean z4 = z3;
        HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.resize, i8, i9, i10, i11, str, z4));
        this.f14292b.resize(i8, i9, i10, i11, aVar, z4);
        this.f14292b.c();
        this.f14292b.c("javascript:window.mraid.util.stateChangeEvent('resized');");
        this.f14294d = true;
    }

    void b(ArrayList<Pair<String, String>> arrayList) {
        AdActivity.b bVar = AdActivity.b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        final AdActivity.b bVar2 = bVar;
        int i4 = -1;
        int i5 = -1;
        boolean z3 = false;
        final boolean z4 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("w")) {
                try {
                    i4 = Integer.parseInt((String) next.second);
                } catch (NumberFormatException unused) {
                }
            } else if (((String) next.first).equals("h")) {
                i5 = Integer.parseInt((String) next.second);
            } else if (((String) next.first).equals("useCustomClose")) {
                z3 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("url")) {
                str = Uri.decode((String) next.second);
            } else if (((String) next.first).equals("allow_orientation_change")) {
                z4 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                bVar2 = a((String) next.second);
            }
        }
        if (!StringUtil.isEmpty(str)) {
            try {
                g gVar = new g(this.f14292b.adViewImpl, this);
                this.f14309s = gVar;
                gVar.a(str);
                this.f14292b.adViewImpl.a(this.f14309s.getMRAIDImplementation(), z3, new AdWebView.b() { // from class: com.beizi.ad.internal.view.f.1
                    @Override // com.beizi.ad.internal.view.AdWebView.b
                    public void a() {
                        if (f.this.c() != null) {
                            f.this.f14309s.a(f.this.c(), z4, bVar2);
                            AdViewImpl.setMRAIDFullscreenListener(null);
                        }
                    }
                });
            } catch (Exception e4) {
                String str2 = HaoboLog.baseLogTag;
                HaoboLog.e(str2, "Exception initializing the redirect webview: " + e4.getMessage());
            }
        } else {
            this.f14292b.a(i4, i5, z3, this, z4, bVar2);
        }
        this.f14292b.c("javascript:window.mraid.util.stateChangeEvent('expanded');");
        this.f14293c = true;
        if (this.f14292b.adViewImpl.e()) {
            return;
        }
        this.f14292b.adViewImpl.getAdDispatcher().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AdWebView adWebView, String str) {
        if (this.f14301k) {
            return;
        }
        String str2 = this.f14292b.adViewImpl.d() ? "inline" : "interstitial";
        boolean equals = str.equals(f14291a[b.STARTING_EXPANDED.ordinal()]);
        this.f14308r = equals;
        this.f14292b.f14193a = equals;
        adWebView.c("javascript:window.mraid.util.setPlacementType('" + str2 + "')");
        if (!this.f14308r) {
            a(adWebView);
            g();
            f();
            e();
        }
        this.f14292b.f();
        adWebView.c("javascript:window.mraid.util.stateChangeEvent('" + str + "')");
        adWebView.c("javascript:window.mraid.util.readyEvent();");
        this.f14295e = this.f14292b.getLayoutParams().width;
        this.f14296f = this.f14292b.getLayoutParams().height;
        if (this.f14292b.adViewImpl.getMediaType().equals(k.BANNER)) {
            this.f14297g = ((FrameLayout.LayoutParams) this.f14292b.getLayoutParams()).gravity;
        }
        this.f14301k = true;
        a(this.f14292b.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity c() {
        return this.f14304n;
    }

    private void f() {
        if (this.f14292b.getContextFromMutableContext() instanceof Activity) {
            Activity activity = (Activity) this.f14292b.getContextFromMutableContext();
            int[] screenSizeAsPixels = ViewUtil.getScreenSizeAsPixels(activity);
            int i4 = screenSizeAsPixels[0];
            float f4 = activity.getResources().getDisplayMetrics().density;
            int i5 = (int) ((i4 / f4) + 0.5f);
            AdWebView adWebView = this.f14292b;
            adWebView.c("javascript:window.mraid.util.setMaxSize(" + i5 + ", " + ((int) (((screenSizeAsPixels[1] - activity.getWindow().findViewById(16908290).getTop()) / f4) + 0.5f)) + ")");
        }
    }

    private void e(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.play_vide_no_uri));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        try {
            intent.setDataAndType(Uri.parse(URLDecoder.decode(str, "UTF-8")), "video/mp4");
            try {
                this.f14292b.getContext().startActivity(intent);
                this.f14292b.c();
            } catch (Exception unused) {
            }
        } catch (UnsupportedEncodingException unused2) {
            HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.unsupported_encoding));
        }
    }

    private void g() {
        if (this.f14292b.getContextFromMutableContext() instanceof Activity) {
            int[] screenSizeAsDP = ViewUtil.getScreenSizeAsDP((Activity) this.f14292b.getContextFromMutableContext());
            this.f14302l = screenSizeAsDP[0];
            this.f14303m = screenSizeAsDP[1];
            AdWebView adWebView = this.f14292b;
            adWebView.c("javascript:window.mraid.util.setScreenSize(" + this.f14302l + ", " + this.f14303m + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroup d() {
        return this.f14305o;
    }

    private void a(AdWebView adWebView, String str, boolean z3) {
        adWebView.c(String.format("javascript:window.mraid.util.setSupports('%s', %s)", str, String.valueOf(z3)));
    }

    @SuppressLint({"NewApi"})
    private void a(AdWebView adWebView) {
        if (a(new Intent("android.intent.action.VIEW", Uri.parse("sms:5555555555")))) {
            a(adWebView, "sms", true);
        }
        if (a(new Intent("android.intent.action.VIEW", Uri.parse("tel:5555555555")))) {
            a(adWebView, "tel", true);
        }
        try {
            if (a(new Intent("android.intent.action.EDIT").setData(Uri.parse(com.beizi.ad.lance.a.b.a("Y29udGVudDovL2NvbS5hbmRyb2lkLmNhbGVuZGFyL2V2ZW50cw=="))))) {
                a(adWebView, "calendar", true);
                this.f14299i = true;
            } else if (a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event"))) {
                a(adWebView, "calendar", true);
                this.f14299i = true;
                W3CEvent.useMIME = true;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        a(adWebView, "inlineVideo", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        boolean g4 = this.f14292b.g();
        if (this.f14300j != g4) {
            a(g4);
        }
    }

    boolean a(Intent intent) {
        return this.f14292b.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    void a(boolean z3) {
        if (this.f14301k) {
            this.f14300j = z3;
            AdWebView adWebView = this.f14292b;
            adWebView.c("javascript:window.mraid.util.setIsViewable(" + z3 + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, int i5, int i6, int i7) {
        int[] iArr = this.f14306p;
        if (iArr[0] == i4 && iArr[1] == i5 && iArr[2] == i6 && iArr[3] == i7) {
            return;
        }
        iArr[0] = i4;
        iArr[1] = i5;
        iArr[2] = i6;
        iArr[3] = i7;
        Activity activity = (Activity) this.f14292b.getContextFromMutableContext();
        int[] iArr2 = {i4, i5 - activity.getWindow().findViewById(16908290).getTop(), i6, i7};
        ViewUtil.convertFromPixelsToDP(activity, iArr2);
        int i8 = iArr2[0];
        int i9 = iArr2[1];
        int i10 = iArr2[2];
        int i11 = iArr2[3];
        this.f14292b.c(String.format("javascript:window.mraid.util.setCurrentPosition(%d, %d, %d, %d)", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11)));
        this.f14292b.c(String.format("javascript:window.mraid.util.sizeChangeEvent(%d, %d)", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    public void a() {
        if (!this.f14293c && !this.f14294d && !this.f14308r) {
            if (this.f14292b.adViewImpl.e()) {
                this.f14292b.adViewImpl.getAdDispatcher().b();
                Activity activity = (Activity) this.f14292b.getContextFromMutableContext();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.finish();
                return;
            }
            this.f14292b.d();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f14292b.getLayoutParams());
        layoutParams.height = this.f14296f;
        layoutParams.width = this.f14295e;
        if (this.f14292b.adViewImpl.getMediaType().equals(k.BANNER)) {
            layoutParams.gravity = this.f14297g;
        } else {
            layoutParams.gravity = 17;
        }
        this.f14292b.setLayoutParams(layoutParams);
        this.f14292b.e();
        this.f14292b.c("javascript:window.mraid.util.stateChangeEvent('default');");
        if (!this.f14292b.adViewImpl.e() && !this.f14308r) {
            this.f14292b.adViewImpl.getAdDispatcher().b();
        }
        Activity activity2 = (Activity) this.f14292b.getContextFromMutableContext();
        if (activity2 != null) {
            activity2.setRequestedOrientation(-1);
        }
        this.f14293c = false;
        this.f14294d = false;
        this.f14309s = null;
    }

    void a(ArrayList<Pair<String, String>> arrayList) {
        this.f14292b.setMRAIDUseCustomClose(Boolean.parseBoolean((String) arrayList.get(0).second));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, boolean z3) {
        String replaceFirst = str.replaceFirst("mraid://", "");
        String[] split = replaceFirst.split("\\?");
        String replaceAll = split[0].replaceAll(TTPathConst.sSeparator, "");
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (split.length > 1) {
            for (String str2 : replaceFirst.substring(replaceFirst.indexOf("?") + 1).split("&")) {
                String[] split2 = str2.split("=");
                if (split2.length >= 2 && !StringUtil.isEmpty(split2[1]) && !"undefined".equals(split2[1])) {
                    arrayList.add(new Pair<>(split2[0], split2[1]));
                }
            }
        }
        if (replaceAll.equals("expand")) {
            if (z3) {
                b(arrayList);
            } else {
                HaoboLog.w(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("close")) {
            a();
        } else if (replaceAll.equals("resize")) {
            if (z3) {
                h(arrayList);
            } else {
                HaoboLog.w(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("setOrientationProperties")) {
            g(arrayList);
        } else if (this.f14299i && replaceAll.equals("createCalendarEvent")) {
            if (z3) {
                f(arrayList);
            } else {
                HaoboLog.w(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("playVideo")) {
            if (z3) {
                e(arrayList);
            } else {
                HaoboLog.w(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.no_user_interaction, replaceFirst));
            }
        } else if (this.f14298h && replaceAll.equals("storePicture")) {
            if (z3) {
                d(arrayList);
            } else {
                HaoboLog.w(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("open")) {
            if (z3) {
                c(arrayList);
            } else {
                HaoboLog.w(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("setUseCustomClose")) {
            a(arrayList);
        } else if (!replaceAll.equals("enable")) {
            HaoboLog.d(HaoboLog.mraidLogTag, HaoboLog.getString(R.string.unsupported_mraid, replaceAll));
        }
    }

    private AdActivity.b a(String str) {
        AdActivity.b bVar = AdActivity.b.none;
        if (str.equals("landscape")) {
            return AdActivity.b.landscape;
        }
        return str.equals("portrait") ? AdActivity.b.portrait : bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4) {
        if (this.f14307q != i4) {
            this.f14307q = i4;
            f();
            g();
        }
    }

    public void a(Activity activity) {
        this.f14304n = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        this.f14305o = viewGroup;
    }
}
