package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            return this.view == transitionValues.view && this.values.equals(transitionValues.values);
        }
        return false;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + ShellAdbUtils.f33810d) + "    values:";
        for (String str2 : this.values.keySet()) {
            str = str + "    " + str2 + ": " + this.values.get(str2) + ShellAdbUtils.f33810d;
        }
        return str;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
