package com.demo.response;

import java.util.List;

import com.demo.vo.HallVO;

public class HallResponseObject {
	String successMessage;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public List<HallVO> getHallvoList() {
		return hallvoList;
	}
	public void setHallvoList(List<HallVO> hallvoList) {
		this.hallvoList = hallvoList;
	}
	public HallVO getHallVO() {
		return hallVO;
	}
	public void setHallVO(HallVO hallVO) {
		this.hallVO = hallVO;
	}
	String failureMessage;
	List<HallVO> hallvoList;
	HallVO hallVO;
}