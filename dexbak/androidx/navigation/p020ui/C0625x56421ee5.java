package androidx.navigation.p020ui;

import androidx.navigation.p020ui.AppBarConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import p617l1.InterfaceC15269a;

/* compiled from: AppBarConfiguration.kt */
@Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 1, 16})
/* renamed from: androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C0625x56421ee5 implements AppBarConfiguration.OnNavigateUpListener {
    private final /* synthetic */ InterfaceC15269a function;

    public C0625x56421ee5(InterfaceC15269a interfaceC15269a) {
        this.function = interfaceC15269a;
    }

    @Override // androidx.navigation.p020ui.AppBarConfiguration.OnNavigateUpListener
    public final /* synthetic */ boolean onNavigateUp() {
        Object invoke = this.function.invoke();
        C14342f0.m8192h(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
