package com.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.controller.UploadController;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.intercept.GlobalIntercept;
import com.jfinal.intercept.ServiceInterceptor;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		// this.loadPropertyFile(file)
		// PropKit.use("jdbc.txt");
		me.setBaseDownloadPath("/download");
		me.setDevMode(true);
		// me.setUrlParaSeparator("&");
		me.setViewType(ViewType.FREE_MARKER);
		me.setBaseUploadPath("/upload");
	}

	/**
	 * 指定路径
	 */
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		// me.add(new FrontRoute());
		// me.add(new AdminRoute());
		// me.add("/user", UserController.class);
		// me.add("/cache", EhcacheController.class);
		me.add("/upload", UploadController.class);

	}

	/**
	 * 可配置模板引擎
	 */
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	/**
	 * 扩展插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		// DruidPlugin druid = new DruidPlugin(PropKit.get("jdbc.url"),
		// PropKit.get("jdbc.username"),
		// PropKit.get("jdbc.password"), PropKit.get("jdbc.driverClassName"));
		// me.add(druid);
		/**
		 * ActiveRecord 是 JFinal 最核心的组成部分之一，通过 ActiveRecord 来操作数据库，将极大
		 * 地减少代码量，极大地提升开发效率。
		 */
		// ActiveRecordPlugin arp = new ActiveRecordPlugin(druid);
		// me.add(arp);
		// EhCachePlugin cache = new EhCachePlugin();
		// me.add(cache);
		// 配置属性名(字段名)大小写不敏感容器工厂
		//arp.setContainerFactory(new CaseInsensitiveContainerFactory());
		// arp.addMapping("t_user", "id", User.class);

	}

	/**
	 * 这里定义全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.addGlobalActionInterceptor(new GlobalIntercept());// 设置全局拦截器
		me.addGlobalServiceInterceptor(new ServiceInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new ContextPathHandler("contextPath"));
	}

}
