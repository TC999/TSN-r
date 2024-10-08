package androidx.databinding.adapters;

import android.widget.Toolbar;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:onMenuItemClick", method = "setOnMenuItemClickListener", type = Toolbar.class), @BindingMethod(attribute = "android:onNavigationClick", method = "setNavigationOnClickListener", type = Toolbar.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ToolbarBindingAdapter {
}
