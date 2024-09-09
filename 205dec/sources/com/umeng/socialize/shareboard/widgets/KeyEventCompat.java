package com.umeng.socialize.shareboard.widgets;

import android.annotation.TargetApi;
import android.view.KeyEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class KeyEventCompat {
    private static final KeyEventVersionImpl IMPL = new HoneycombKeyEventVersionImpl();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 247;
        private static final int META_MODIFIER_MASK = 247;

        private BaseKeyEventVersionImpl() {
        }

        private static int metaStateFilterDirectionalModifiers(int i4, int i5, int i6, int i7, int i8) {
            int i9;
            boolean z3 = (i5 & i6) != 0;
            int i10 = i7 | i8;
            boolean z4 = (i5 & i10) != 0;
            if (z3) {
                if (z4) {
                    throw new IllegalArgumentException("bad arguments");
                }
                i9 = i10 ^ (-1);
            } else if (!z4) {
                return i4;
            } else {
                i9 = i6 ^ (-1);
            }
            return i4 & i9;
        }

        private int normalizeMetaState(int i4) {
            if ((i4 & 192) != 0) {
                i4 |= 1;
            }
            if ((i4 & 48) != 0) {
                i4 |= 2;
            }
            return i4 & MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i4, int i5) {
            return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(i4) & MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, i5, 1, 64, 128), i5, 2, 16, 32) == i5;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i4) {
            return (normalizeMetaState(i4) & MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT) == 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @TargetApi(11)
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class HoneycombKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        private HoneycombKeyEventVersionImpl() {
            super();
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i4, int i5) {
            return KeyEvent.metaStateHasModifiers(i4, i5);
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i4) {
            return KeyEvent.metaStateHasNoModifiers(i4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    interface KeyEventVersionImpl {
        boolean metaStateHasModifiers(int i4, int i5);

        boolean metaStateHasNoModifiers(int i4);
    }

    KeyEventCompat() {
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i4) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), i4);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }
}
