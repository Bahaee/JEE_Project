package model;

import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserModel {
	
	private String motCle;
	List<User> produits = new ArrayList<>();
	
	
	public UserModel() {
		super();
	}
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<User> getProduits() {
		return produits;
	}
	public void setProduits(List<User> produits) {
		this.produits = produits;
	}
	
}
