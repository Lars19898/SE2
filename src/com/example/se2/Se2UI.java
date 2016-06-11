package com.example.se2;

import java.sql.*;
import java.util.List;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;

import com.example.control.HotelSearch;
import com.example.dto.Hotel;
import com.example.gui.views.LoginView;
import com.example.gui.views.MainView;
import com.example.services.util.Views;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ui.NotificationRole;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.navigator.*;;

@SuppressWarnings("serial")
@Theme("se2")
@PreserveOnRefresh
public class Se2UI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Se2UI.class, widgetset = "com.example.se2.widgetset.Se2Widgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		
		VaadinSession v=VaadinSession.getCurrent();
		System.out.println("Neues UI Objekt: "+UI.getCurrent().toString()+"Assoziert mit Sessionobjekt "+ UI.getCurrent().getSession().toString() );
		
		com.vaadin.navigator.Navigator navi = new com.vaadin.navigator.Navigator(this, this);
		navi.addView(Views.MAIN, MainView.class);
		navi.addView(Views.LOGIN, LoginView.class);

		UI.getCurrent().getNavigator().navigateTo(Views.LOGIN);
	}
}
