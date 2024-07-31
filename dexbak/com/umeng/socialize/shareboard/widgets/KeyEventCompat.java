package com.umeng.socialize.shareboard.widgets;

import android.annotation.TargetApi;
import android.view.KeyEvent;
import com.alibaba.fastjson.asm.Opcodes;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class KeyEventCompat {
    private static final KeyEventVersionImpl IMPL = new HoneycombKeyEventVersionImpl();

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 247;
        private static final int META_MODIFIER_MASK = 247;

        private BaseKeyEventVersionImpl() {
        }

        private static int metaStateFilterDirectionalModifiers(int i, int i2, int i3, int i4, int i5) {
            int i6;
            boolean z = (i2 & i3) != 0;
            int i7 = i4 | i5;
            boolean z2 = (i2 & i7) != 0;
            if (z) {
                if (z2) {
                    throw new IllegalArgumentException("bad arguments");
                }
                i6 = i7 ^ (-1);
            } else if (!z2) {
                return i;
            } else {
                i6 = i3 ^ (-1);
            }
            return i & i6;
        }

        private int normalizeMetaState(int i) {
            if ((i & Opcodes.CHECKCAST) != 0) {
                i |= 1;
            }
            if ((i & 48) != 0) {
                i |= 2;
            }
            return i & 247;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i, int i2) {
            return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i) {
            return (normalizeMetaState(i) & 247) == 0;
        }
    }

    @TargetApi(11)
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class HoneycombKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        private HoneycombKeyEventVersionImpl() {
            super();
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i, int i2) {
            return KeyEvent.metaStateHasModifiers(i, i2);
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i) {
            return KeyEvent.metaStateHasNoModifiers(i);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    interface KeyEventVersionImpl {
        boolean metaStateHasModifiers(int i, int i2);

        boolean metaStateHasNoModifiers(int i);
    }

    KeyEventCompat() {
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), i);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }
}
