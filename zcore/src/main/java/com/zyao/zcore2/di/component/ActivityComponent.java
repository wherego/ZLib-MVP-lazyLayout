/**
 * Title: ActivityComponent.java
 * Package: com.zyao.zcore2.di.component
 * Description: 本内容来源于Zyao89。
 * Author: Zyao89
 * Date: 2016/9/16
 */
package com.zyao.zcore2.di.component;

import android.app.Activity;

import com.zyao.zcore2.di.ActivityScope;
import com.zyao.zcore2.di.module.ActivityModule;

import dagger.Component;

/**
 * Interface: ActivityComponent
 * Description: 基类
 * Author: Zyao89
 * Time: 2016/9/16 17:01
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent
{
    Activity getActivity (); // Expose the activity to sub-graphs.
}
