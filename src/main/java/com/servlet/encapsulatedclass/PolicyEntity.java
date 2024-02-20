package com.servlet.encapsulatedclass;

public class PolicyEntity {
    
	
	private String policyid;
	private String policyname;
	private String premiumrange;
	private String Claim;
	private String Entryage;
	private String Endage;
	
	public String getPolicyid() {
		return policyid;
	}
	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	public String getPolicyname() {
		return policyname;
	}
	public void setPolicyname(String policyname) {
		this.policyname = policyname;
	}
	public String getPremiumrange() {
		return premiumrange;
	}
	public void setPremiumrange(String premiumrange) {
		this.premiumrange = premiumrange;
	}
	public String getClaim() {
		return Claim;
	}
	public void setClaim(String claim) {
		Claim = claim;
	}
	public String getEntryage() {
		return Entryage;
	}
	public void setEntryage(String entryage) {
		Entryage = entryage;
	}
	public String getEndage() {
		return Endage;
	}
	public void setEndage(String endage) {
		Endage = endage;
	}
	
	
	
	
}
