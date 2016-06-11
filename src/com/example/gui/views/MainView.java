package com.example.gui.views;

import java.util.List;

import com.example.control.HotelSearch;
import com.example.dto.Hotel;
import com.example.dto.User;
import com.example.gui.components.TopPanel;
import com.example.services.util.Views;
import com.google.gwt.dev.ModuleTabPanel.Session;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class MainView extends VerticalLayout implements View {

	private Hotel hotelselektiert;
	private int counter = 0;
	User user = null;

	@Override
	public void enter(ViewChangeEvent event) {

		user = (User) UI.getCurrent().getSession().getAttribute("user");

		if (user == null) {
			UI.getCurrent().getNavigator().navigateTo(Views.LOGIN);
		} else {
			this.setup();
		}
	}

	public void setup() {

		toString();
		this.addComponent(new TopPanel());

		VaadinSession session = VaadinSession.getCurrent();
		User user = (User) session.getAttribute("user");
		Label label = new Label("Hallo," + user.getUsername());
		HorizontalLayout hl = new HorizontalLayout();
		BeanContainer<Integer, Hotel> data = new BeanContainer<Integer, Hotel>(Hotel.class);
		data.setBeanIdProperty("id");
		Table table = new Table("Treffer", data);
		table.setSizeFull();
		table.setSelectable(true);
		Label label2 = new Label(" " + "Gebe Ort ein");
		TextField textfeld = new TextField();
		Button button = new Button("Suche", FontAwesome.SEARCH);
		Button buttonbuche = new Button("Buche!");
		Button getuser=new Button("Getuser");
		
		
		getuser.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show(user.toString());
				
			}
		});
		
		
		button.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				table.setCaption("Treffer für: "+ user.getUsername() + textfeld.getValue() + "Anzahl der Suchen:" + counter++);
				table.removeAllItems();
				List<Hotel> ergebnisliste = HotelSearch.getinstance().getHotelbyOrt(textfeld.getValue());
				addComponent(table);
				data.addAll(ergebnisliste);
				hl.addComponent(buttonbuche);
				hl.setComponentAlignment(buttonbuche, Alignment.MIDDLE_CENTER);

			}
		});

		buttonbuche.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println("Hotel selektiert" + hotelselektiert.getName());

			}
		});

		table.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {

				BeanItem<Hotel> hotelBean = data.getItem(event.getItemId());
				hotelselektiert = hotelBean.getBean();
				VaadinSession session = UI.getCurrent().getSession();

			}

		});

		hl.addComponent(label);
		hl.addComponent(label2);
		hl.addComponent(textfeld);
		hl.addComponent(button);
		hl.addComponent(getuser);
		addComponent(hl);
		setComponentAlignment(hl, Alignment.MIDDLE_CENTER);

		hl.setMargin(true);

	}

}
