package com.internousdev.login.action;

import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String name;
	private String password;

/*	10～11行＝loginjsp→struts.xml→で送られてきたnameとpassword*/

	/*↓executeメソッド↓*/
	public String execute()throws SQLException{
		String ret = ERROR;

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		dto = dao.select(name,password);/*DAOのselectへnameとpassword を送る*/
		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())) {
				ret=SUCCESS;
			}
		}
		return ret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

}
/*前：③struts.xml 　④　次：⑤■loginDAO*/
/*前：⑥loginDTO　⑦　次：⑧sutruts*/