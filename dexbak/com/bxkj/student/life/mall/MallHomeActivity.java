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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.auth.AuthorizationUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.life.mall.address.MyAddressListActivity;
import com.bxkj.student.life.mall.collect.CollectGoodsActivity;
import com.bxkj.student.life.mall.order.OrderActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MallHomeActivity extends BaseActivity {

    /* renamed from: k */
    private Toolbar f18288k;

    /* renamed from: com.bxkj.student.life.mall.MallHomeActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4974a implements BaseActivity.InterfaceC1107c {
        C4974a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            MallHomeActivity mallHomeActivity = MallHomeActivity.this;
            mallHomeActivity.f18288k = (Toolbar) mallHomeActivity.findViewById(2131232779);
            MallHomeActivity mallHomeActivity2 = MallHomeActivity.this;
            mallHomeActivity2.m40909r0(mallHomeActivity2.f18288k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.MallHomeActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4975b extends UniversalItemDecoration {
        C4975b() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        /* renamed from: a */
        public UniversalItemDecoration.AbstractC4246b mo40391a(int position) {
            UniversalItemDecoration.C4245a c4245a = new UniversalItemDecoration.C4245a();
            int m57620a = Tools.m57620a(1.0f, ((BaseActivity) MallHomeActivity.this).f1669h);
            if (position != 2) {
                c4245a.f16215d = m57620a;
                c4245a.f16211f = -1;
            }
            return c4245a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.MallHomeActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4976c extends CommonAdapter<String> {
        C4976c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder viewHolder, String string) {
            if (viewHolder.m57864f() == 0) {
                viewHolder.m57852r(2131231451, C4215R.mipmap.my_order);
            } else if (viewHolder.m57864f() == 1) {
                viewHolder.m57852r(2131231451, C4215R.mipmap.star_white);
            } else {
                viewHolder.m57852r(2131231451, C4215R.mipmap.my_address);
            }
            viewHolder.m57874J(2131233040, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.MallHomeActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4977d implements OnItemClickListener {

        /* renamed from: a */
        final /* synthetic */ PopupWindow f18292a;

        /* renamed from: com.bxkj.student.life.mall.MallHomeActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4978a implements AuthorizationUtils.InterfaceC3827g {

            /* renamed from: a */
            final /* synthetic */ int f18294a;

            C4978a(final int val$position) {
                this.f18294a = val$position;
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                C4977d.this.f18292a.dismiss();
                int i = this.f18294a;
                if (i == 0) {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).f1669h, OrderActivity.class));
                } else if (i == 1) {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).f1669h, CollectGoodsActivity.class));
                } else if (i != 2) {
                } else {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).f1669h, MyAddressListActivity.class));
                }
            }
        }

        C4977d(final PopupWindow val$window) {
            this.f18292a = val$window;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, final int position) {
            new AuthorizationUtils(((BaseActivity) MallHomeActivity.this).f1669h).m44322i(new C4978a(position)).m44329b(MallHomeActivity.this.getSupportFragmentManager(), 0);
        }
    }

    /* renamed from: q0 */
    private int[] m40910q0(final View anchorView, final View contentView) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        anchorView.getLocationOnScreen(iArr2);
        int height = anchorView.getHeight();
        int i = Tools.m57636K(this.f1669h)[1];
        int i2 = Tools.m57636K(this.f1669h)[0];
        contentView.measure(0, 0);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        if ((i - iArr2[1]) - height < measuredHeight) {
            iArr[0] = i2 - measuredWidth;
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[0] = i2 - measuredWidth;
            iArr[1] = iArr2[1] + height;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public PopupWindow m40909r0(View paramView) {
        View inflate = LayoutInflater.from(this.f1669h).inflate(2131428017, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131232247);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f1669h));
        recyclerView.addItemDecoration(new C4975b());
        ArrayList arrayList = new ArrayList();
        arrayList.add("我的订单");
        arrayList.add("我的收藏");
        arrayList.add("收货地址");
        C4976c c4976c = new C4976c(this.f1669h, C4215R.C4221layout.item_for_classify_name, arrayList);
        recyclerView.setAdapter(c4976c);
        PopupWindow popupWindow = new PopupWindow(inflate, Tools.m57620a(120.0f, this.f1669h), -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(paramView, 53, 0, m40910q0(paramView, this.f18288k)[1]);
        c4976c.m57834k(new C4977d(popupWindow));
        return popupWindow;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_mall_home;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("商城");
        m57925b0(2131558869, new C4974a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
