package cloudconfvarna.org.models;

public class Comment {

	private Long commentId;
	private String date;
	private Long beerId;
	private String comment;
	
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	public Long getCommentId() {
		return commentId;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setBeerId(Long beerId) {
		this.beerId = beerId;
	}
	
	public Long getBeerId() {
		return beerId;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}
}
