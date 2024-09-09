package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.auth.a;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.life.mall.address.MyAddressListActivity;
import com.bxkj.student.life.mall.collect.CollectGoodsActivity;
import com.bxkj.student.life.mall.order.OrderActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MallHomeActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Toolbar f21603k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            MallHomeActivity mallHomeActivity = MallHomeActivity.this;
            mallHomeActivity.f21603k = (Toolbar) mallHomeActivity.findViewById(2131232779);
            MallHomeActivity mallHomeActivity2 = MallHomeActivity.this;
            mallHomeActivity2.r0(mallHomeActivity2.f21603k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends UniversalItemDecoration {
        b() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            int a4 = u.a(1.0f, ((BaseActivity) MallHomeActivity.this).f1656h);
            if (position != 2) {
                aVar.f19614d = a4;
                aVar.f19610f = -1;
            }
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends CommonAdapter<String> {
        c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder viewHolder, String string) {
            if (viewHolder.f() == 0) {
                viewHolder.r(2131231451, 2131558864);
            } else if (viewHolder.f() == 1) {
                viewHolder.r(2131231451, 2131558994);
            } else {
                viewHolder.r(2131231451, 2131558861);
            }
            viewHolder.J(2131233040, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopupWindow f21607a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements a.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f21609a;

            a(final int val$position) {
                this.f21609a = val$position;
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                d.this.f21607a.dismiss();
                int i4 = this.f21609a;
                if (i4 == 0) {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).f1656h, OrderActivity.class));
                } else if (i4 == 1) {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).f1656h, CollectGoodsActivity.class));
                } else if (i4 != 2) {
                } else {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).f1656h, MyAddressListActivity.class));
                }
            }
        }

        d(final PopupWindow val$window) {
            this.f21607a = val$window;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, final int position) {
            new com.bxkj.base.auth.a(((BaseActivity) MallHomeActivity.this).f1656h).i(new a(position)).b(MallHomeActivity.this.getSupportFragmentManager(), 0);
        }
    }

    private int[] q0(final View anchorView, final View contentView) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        anchorView.getLocationOnScreen(iArr2);
        int height = anchorView.getHeight();
        int i4 = u.K(this.f1656h)[1];
        int i5 = u.K(this.f1656h)[0];
        contentView.measure(0, 0);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        if ((i4 - iArr2[1]) - height < measuredHeight) {
            iArr[0] = i5 - measuredWidth;
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[0] = i5 - measuredWidth;
            iArr[1] = iArr2[1] + height;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupWindow r0(View paramView) {
        View inflate = LayoutInflater.from(this.f1656h).inflate(2131428017, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131232247);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f1656h));
        recyclerView.addItemDecoration(new b());
        ArrayList arrayList = new ArrayList();
        arrayList.add("\u6211\u7684\u8ba2\u5355");
        arrayList.add("\u6211\u7684\u6536\u85cf");
        arrayList.add("\u6536\u8d27\u5730\u5740");
        c cVar = new c(this.f1656h, 2131427680, arrayList);
        recyclerView.setAdapter(cVar);
        PopupWindow popupWindow = new PopupWindow(inflate, u.a(120.0f, this.f1656h), -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(paramView, 53, 0, q0(paramView, this.f21603k)[1]);
        cVar.k(new d(popupWindow));
        return popupWindow;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427435;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5546\u57ce");
        b0(2131558869, new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
