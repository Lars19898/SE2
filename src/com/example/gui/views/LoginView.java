package com.example.gui.views;

import java.sql.SQLException;

import com.example.control.HotelSearch;
import com.example.control.LoginControl;
import com.example.exceptions.NoSuchUserOrPassword;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Panel;

public class LoginView extends VerticalLayout implements View {

	public void setup() {
		this.setSizeFull();
		TextField username = new TextField();
		PasswordField password = new PasswordField();
		Button loginbutton = new Button("Login", FontAwesome.SEARCH);
		username.setCaption("Bitte Nutzername eingeben");
		password.setCaption("Bitte Passwort eingeben");

		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(username);
		vl.addComponent(password);
		vl.addComponent(loginbutton);

		vl.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(loginbutton, Alignment.MIDDLE_CENTER);

		Panel panel = new Panel("Bitte melden Sie sich am System an");
		this.addComponent(panel);
		this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		panel.setContent(vl);
		panel.setSizeUndefined();

		loginbutton.addClickListener(new ClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void buttonClick(ClickEvent event) {
				String user = username.getValue();
				String pw = password.getValue();

				try {
					LoginControl.checkauthentification(user, pw);
				} catch (SQLException | NoSuchUserOrPassword e) {
					// TODO Auto-generated catch block
					Notification.show("Passwort oder Benutzername falsch", Notification.TYPE_ERROR_MESSAGE);
					username.setValue("");
					password.setValue("");

				}

			}
		});

	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.setup();

	}

}
