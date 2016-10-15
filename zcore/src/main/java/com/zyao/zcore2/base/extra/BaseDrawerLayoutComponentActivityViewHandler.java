package com.zyao.zcore2.base.extra;

import android.support.annotation.LayoutRes;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zyao.zcore.R;

/**
 * Class: BaseDrawerLayoutComponentActivityViewHandler
 * Description: 带标题的侧滑菜单
 * Author: Zyao89
 * Time: 2016/9/23 18:47
 */
public abstract class BaseDrawerLayoutComponentActivityViewHandler<RootViewType extends View> extends BaseLazyCoordinatorComponentActivityViewHandler<RootViewType>
{
    private DrawerLayout mDrawerLayout;
    private FrameLayout mLeftNavigation;

    @Override
    public final int getResourceId()
    {
        return R.layout.z_lazy_design_drawer_layout;
    }

    /** 添加View时调用 */
    protected abstract void initContentView ();

    @Override
    protected void initViews ()
    {
        super.initViews();
        initDesignDrawerLayout();
        initDesignNavigation();
    }

    private void initDesignDrawerLayout ()
    {
        View view = findViewById(R.id.z_lazy_design_drawer_layout);
        if (view == null)
        {
            return;
        }
        if (view instanceof DrawerLayout)
        {
            mDrawerLayout = (DrawerLayout) view;
        }
        if (mDrawerLayout == null)
        {
            throw new RuntimeException("mDrawerLayout is null...");
        }
    }

    /**
     * 初始化左侧导航栏
     */
    private void initDesignNavigation ()
    {
        View view = findViewById(R.id.z_lazy_design_navigation);
        if (view == null)
        {
            return;
        }
        if (view instanceof FrameLayout)
        {
            mLeftNavigation = (FrameLayout) view;
        }
        if (mLeftNavigation == null)
        {
            throw new RuntimeException("mLeftNavigation is null...");
        }
    }

    private boolean isLeftNavigationExist ()
    {
        return mLeftNavigation != null;
    }

    protected void setNavigationView (@LayoutRes int layoutResID)
    {
        if (isLeftNavigationExist())
        {
            mLeftNavigation.removeAllViews();
            View.inflate(mContext, layoutResID, mLeftNavigation);
        }
    }

    protected void setNavigationView (View view)
    {
        if (isLeftNavigationExist())
        {
            mLeftNavigation.removeAllViews();
            mLeftNavigation.addView(view);
        }
    }

    protected void setNavigationView (View view, ViewGroup.LayoutParams params)
    {
        if (isLeftNavigationExist())
        {
            mLeftNavigation.removeAllViews();
            mLeftNavigation.addView(view, params);
        }
    }
}
