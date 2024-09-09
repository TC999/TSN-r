package org.apache.harmony.awt.datatransfer;

import java.awt.Point;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DragSourceEventProxy implements Runnable {
    public static final int DRAG_ACTION_CHANGED = 3;
    public static final int DRAG_DROP_END = 6;
    public static final int DRAG_ENTER = 1;
    public static final int DRAG_EXIT = 5;
    public static final int DRAG_MOUSE_MOVED = 4;
    public static final int DRAG_OVER = 2;
    private final DragSourceContext context;
    private final int modifiers;
    private final boolean success;
    private final int targetActions;
    private final int type;
    private final int userAction;

    /* renamed from: x  reason: collision with root package name */
    private final int f61585x;

    /* renamed from: y  reason: collision with root package name */
    private final int f61586y;

    public DragSourceEventProxy(DragSourceContext dragSourceContext, int i4, int i5, int i6, Point point, int i7) {
        this.context = dragSourceContext;
        this.type = i4;
        this.userAction = i5;
        this.targetActions = i6;
        this.f61585x = point.x;
        this.f61586y = point.y;
        this.modifiers = i7;
        this.success = false;
    }

    private DragSourceDragEvent newDragSourceDragEvent() {
        return new DragSourceDragEvent(this.context, this.userAction, this.targetActions, this.modifiers, this.f61585x, this.f61586y);
    }

    @Override // java.lang.Runnable
    public void run() {
        switch (this.type) {
            case 1:
                this.context.dragEnter(newDragSourceDragEvent());
                return;
            case 2:
                this.context.dragOver(newDragSourceDragEvent());
                return;
            case 3:
                this.context.dropActionChanged(newDragSourceDragEvent());
                return;
            case 4:
                this.context.dragMouseMoved(newDragSourceDragEvent());
                return;
            case 5:
                this.context.dragExit(new DragSourceEvent(this.context, this.f61585x, this.f61586y));
                return;
            case 6:
                this.context.dragExit(new DragSourceDropEvent(this.context, this.userAction, this.success, this.f61585x, this.f61586y));
                return;
            default:
                return;
        }
    }

    public DragSourceEventProxy(DragSourceContext dragSourceContext, int i4, int i5, boolean z3, Point point, int i6) {
        this.context = dragSourceContext;
        this.type = i4;
        this.userAction = i5;
        this.targetActions = i5;
        this.f61585x = point.x;
        this.f61586y = point.y;
        this.modifiers = i6;
        this.success = z3;
    }
}
