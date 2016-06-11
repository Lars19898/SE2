package com.example.control;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dto.User;
import com.example.exceptions.NoSuchUserOrPassword;
import com.example.services.db.JDBCConnection;
import com.example.services.util.Roles;
import com.example.services.util.Views;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

public class LoginControl {

	public static void checkauthentification(String user, String password) throws SQLException, NoSuchUserOrPassword {

		PreparedStatement statement = JDBCConnection.getinstance().getLoginStatement("SELECT * FROM myhotelapp.user WHERE username=? AND password=?");
		statement.setString(1, user);
		statement.setString(2, password);
		ResultSet rs = statement.executeQuery();

		User user1 = null;

		if (rs.next()) {
			// instancing DTO Object
			user1 = new User(rs.getString(3), rs.getString(2), rs.getInt(1));

		} else {
			throw new NoSuchUserOrPassword();
		}

		VaadinSession session = VaadinSession.getCurrent();
		session.setAttribute(Roles.Role, user1);
		UI.getCurrent().getNavigator().navigateTo(Views.MAIN);

	}

	public static void logoutUser() {
		UI.getCurrent().getPage().setLocation("/SE2");
		UI.getCurrent().getSession().close();

	}

}
