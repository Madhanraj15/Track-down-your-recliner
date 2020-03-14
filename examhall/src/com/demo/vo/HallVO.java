package com.demo.vo;
public class HallVO {
	private int hall_id; 
	public int getHall_id() {
		return hall_id;
	}
	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}
	public String getHall_invigilater_name() {
		return hall_invigilater_name;
	}
	@Override
	public String toString() {
		return "HallVO [hall_id=" + hall_id + ", hall_invigilater_name=" + hall_invigilater_name
				+ ", invigilater_gender=" + invigilater_gender + ", invigilater_college=" + invigilater_college
				+ ", getHall_id()=" + getHall_id() + ", getHall_invigilater_name()=" + getHall_invigilater_name()
				+ ", getInvigilater_gender()=" + getInvigilater_gender() + ", getInvigilater_college()="
				+ getInvigilater_college() + "]";
	}
	public void setHall_invigilater_name(String hall_invigilater_name) {
		this.hall_invigilater_name = hall_invigilater_name;
	}
	public String getInvigilater_gender() {
		return invigilater_gender;
	}
	public void setInvigilater_gender(String invigilater_gender) {
		this.invigilater_gender = invigilater_gender;
	}
	public String getInvigilater_college() {
		return invigilater_college;
	}
	public void setInvigilater_college(String invigilater_college) {
		this.invigilater_college = invigilater_college;
	}
	private String hall_invigilater_name ;
	private String invigilater_gender ;
	private String invigilater_college ;
	 {
		// TODO Auto-generated method stub
		
	}

}
