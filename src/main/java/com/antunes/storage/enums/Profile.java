package com.antunes.storage.enums;

public enum Profile {

	ESTOQUE(1, "estoque"),
	VENDAS(2, "vendas"),
	CAIXA(3, "caixa");
	
	private int id;
	private String description;
	
	private Profile(int id, String description) {
		this.id = id;
		this.description = description;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public static Profile toEnum(Integer cod) {
		Profile prof = null;
		
		if(cod == null)
			return prof;
		else {
			
			for(Profile profile : Profile.values()) {
				if (cod.equals(profile.getId()))
					prof =  profile;
				else
					return prof;
			}
		}
		return prof;
		
	}
	
}