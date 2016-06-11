package com.example.gui.components;

import com.example.control.LoginControl;
import com.example.dto.User;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;


public class TopPanel extends HorizontalLayout {
	String vorname=null;
	
	public TopPanel(){
		
		this.setSizeFull();		
		Label headLabel=new Label("Mein Hotel -<i>das Reservierungssystem<i>", ContentMode.HTML);
		headLabel.setSizeUndefined();
		
		this.addComponent(headLabel);
		this.setComponentAlignment(headLabel, Alignment.TOP_LEFT);
		
		HorizontalLayout hl=new HorizontalLayout();
		
		User user=(User)UI.getCurrent().getSession().getAttribute("user");
		
		if(user!=null){
			vorname=user.getUsername();
		}
		
		
		Label loggedLabel=new Label("Willkomen "+vorname+"!");
		loggedLabel.setSizeUndefined();
		
		hl.addComponent(loggedLabel);
		hl.setComponentAlignment(loggedLabel, Alignment.MIDDLE_CENTER);
		
		MenuBar bar = new MenuBar();   
		
		
		
		
		
		
		MenuItem item1=bar.addItem("Menu", null);  // liefert Menuitem zurück.
		
		
		item1.addItem("Logout", FontAwesome.SIGN_IN,new Command(){

			@Override
			public void menuSelected(MenuItem selectedItem) {
				LoginControl.logoutUser();
				
				
			}
			
		});
		
		
		item1.addItem("Canel", FontAwesome.UNLINK,null);
		
		
		
		hl.addComponent(bar);
		this.addComponent(hl);
		
		this.setComponentAlignment(hl, Alignment.TOP_RIGHT);
		
		
		
	}
	

}
