package com.tencent.turingfd.sdk.ams.au;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.if  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class Cif implements Window.Callback {

    /* renamed from: c  reason: collision with root package name */
    public final Window.Callback f52319c;

    public Cif(Window.Callback callback) {
        if (callback != null) {
            this.f52319c = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f52319c.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f52319c.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f52319c.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f52319c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return this.f52319c.dispatchTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f52319c.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f52319c.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f52319c.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f52319c.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f52319c.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i4, Menu menu) {
        return this.f52319c.onCreatePanelMenu(i4, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i4) {
        return this.f52319c.onCreatePanelView(i4);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f52319c.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        return this.f52319c.onMenuItemSelected(i4, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i4, Menu menu) {
        return this.f52319c.onMenuOpened(i4, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        this.f52319c.onPanelClosed(i4, menu);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z3) {
        this.f52319c.onPointerCaptureChanged(z3);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i4, View view, Menu menu) {
        return this.f52319c.onPreparePanel(i4, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i4) {
        this.f52319c.onProvideKeyboardShortcuts(list, menu, i4);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f52319c.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        try {
            this.f52319c.onWindowAttributesChanged(layoutParams);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        this.f52319c.onWindowFocusChanged(z3);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f52319c.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f52319c.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i4) {
        return this.f52319c.onWindowStartingActionMode(callback, i4);
    }
}
