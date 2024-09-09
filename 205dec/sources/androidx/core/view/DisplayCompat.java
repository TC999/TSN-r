package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.acse.ottn.f3;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    private DisplayCompat() {
    }

    private static Point getPhysicalDisplaySize(@NonNull Context context, @NonNull Display display) {
        Point parsePhysicalDisplaySizeFromSystemProperties;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 28) {
            parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display);
        } else {
            parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        }
        if (parsePhysicalDisplaySizeFromSystemProperties != null) {
            return parsePhysicalDisplaySizeFromSystemProperties;
        }
        if (isSonyBravia4kTv(context)) {
            return new Point(3840, 2160);
        }
        Point point = new Point();
        if (i4 >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
        } else {
            display.getRealSize(point);
        }
        return point;
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        Point physicalDisplaySize = getPhysicalDisplaySize(context, display);
        if (Build.VERSION.SDK_INT >= 23) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            ArrayList arrayList = new ArrayList(supportedModes.length);
            boolean z3 = false;
            for (int i4 = 0; i4 < supportedModes.length; i4++) {
                if (physicalSizeEquals(supportedModes[i4], physicalDisplaySize)) {
                    arrayList.add(i4, new ModeCompat(supportedModes[i4], true));
                    z3 = true;
                } else {
                    arrayList.add(i4, new ModeCompat(supportedModes[i4], false));
                }
            }
            if (!z3) {
                arrayList.add(new ModeCompat(physicalDisplaySize));
            }
            return (ModeCompat[]) arrayList.toArray(new ModeCompat[0]);
        }
        return new ModeCompat[]{new ModeCompat(physicalDisplaySize)};
    }

    @Nullable
    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(f3.f5657f, String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean isSonyBravia4kTv(@NonNull Context context) {
        return isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    private static boolean isTv(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() == 0) {
            String systemProperty = getSystemProperty(str);
            if (TextUtils.isEmpty(systemProperty)) {
                return null;
            }
            try {
                return parseDisplaySize(systemProperty);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    @RequiresApi(23)
    private static boolean physicalSizeEquals(Display.Mode mode, Point point) {
        return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalDisplaySize;

        ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalDisplaySize == null");
            this.mIsNative = true;
            this.mPhysicalDisplaySize = point;
            this.mMode = null;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalDisplaySize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalDisplaySize.x;
        }

        public boolean isNative() {
            return this.mIsNative;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.mMode;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, boolean z3) {
            Preconditions.checkNotNull(mode, "Display.Mode == null, can't wrap a null reference");
            this.mIsNative = z3;
            this.mPhysicalDisplaySize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.mMode = mode;
        }
    }
}
