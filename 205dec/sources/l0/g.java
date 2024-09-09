package l0;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Field f60806a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f60807b;

    public static Drawable a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f60807b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f60806a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e4);
            }
            f60807b = true;
        }
        Field field = f60806a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e5) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e5);
                f60806a = null;
            }
        }
        return null;
    }
}
