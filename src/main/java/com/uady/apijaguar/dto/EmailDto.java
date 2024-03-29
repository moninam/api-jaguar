package com.uady.apijaguar.dto;

public class EmailDto {

    private String email;
	private String content;
    private String subject;
    
    public EmailDto(){}
	
    public EmailDto(String email, String content, String subject){
        this.email = email;
        this.content = content;
        this.subject = subject;
    }
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "EmailBody [email=" + email + ", content=" + content + ", subject=" + subject + "]";
	}
    
}
