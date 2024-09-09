package com.bytedance.sdk.component.panglearmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends View.AccessibilityDelegate {
    public static Field sr;

    /* renamed from: c  reason: collision with root package name */
    public View.AccessibilityDelegate f29984c;

    /* renamed from: w  reason: collision with root package name */
    public View f29985w;
    public static c xv = new c(null, null);
    public static int ux = 0;

    /* renamed from: f  reason: collision with root package name */
    public static String f29982f = "";

    /* renamed from: r  reason: collision with root package name */
    public static Set<Integer> f29983r = new HashSet();

    static {
        sr = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                sr = declaredField;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public c(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.f29984c = accessibilityDelegate;
        this.f29985w = view;
        SoftDecTool.f29980h = true;
    }

    public static void c(View view) {
        if (f29983r.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z3 = true;
        View.AccessibilityDelegate accessibilityDelegate = null;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                Field field = sr;
                if (field != null) {
                    accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            z3 = false;
        }
        if (!(accessibilityDelegate instanceof c) && z3) {
            view.setAccessibilityDelegate(new c(accessibilityDelegate, view));
            f29983r.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        view.setAccessibilityDelegate(this.f29984c);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                } else {
                    super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean dispatchPopulateAccessibilityEvent;
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        view.setAccessibilityDelegate(this.f29984c);
        view.setAccessibilityDelegate(this.f29984c);
        View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
        if (accessibilityDelegate != null) {
            dispatchPopulateAccessibilityEvent = accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        view.setAccessibilityDelegate(this);
        return dispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        view.setAccessibilityDelegate(this.f29984c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f29979f = true;
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        view.setAccessibilityDelegate(this.f29984c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        if (c()) {
            return;
        }
        view.setAccessibilityDelegate(this.f29984c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean onRequestSendAccessibilityEvent;
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        viewGroup.setAccessibilityDelegate(this.f29984c);
        View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
        if (accessibilityDelegate != null) {
            onRequestSendAccessibilityEvent = accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        } else {
            onRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        viewGroup.setAccessibilityDelegate(this);
        return onRequestSendAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
        boolean performAccessibilityAction;
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        SoftDecTool.f29977a = true;
        view.setAccessibilityDelegate(this.f29984c);
        View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
        if (accessibilityDelegate != null) {
            performAccessibilityAction = accessibilityDelegate.performAccessibilityAction(view, i4, bundle);
        } else {
            performAccessibilityAction = super.performAccessibilityAction(view, i4, bundle);
        }
        view.setAccessibilityDelegate(this);
        return performAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i4) {
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        view.setAccessibilityDelegate(this.f29984c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i4);
            } else {
                super.sendAccessibilityEvent(view, i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        ux = hashCode();
        f29982f = String.valueOf(this.f29984c);
        view.setAccessibilityDelegate(this.f29984c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f29984c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        view.setAccessibilityDelegate(this);
    }

    public boolean c() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i4 = 4; i4 < stackTrace.length; i4++) {
            if (stackTrace[i4] != null && stackTraceElement.getMethodName().equals(stackTrace[i4].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i4].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
