package VO;

import java.util.Date;

public class DiaryVO {
	private int DiaryNO;
	private String content;
	private Date writeDate;
	
	public DiaryVO(int diaryNO, String content, Date writeDate) {
		this.DiaryNO = diaryNO;
		this.content = content;
		this.writeDate = writeDate;
	}

	public int getDiaryNO() {
		return DiaryNO;
	}
	
	public void setDiaryNO(int diaryNO) {
		DiaryNO = diaryNO;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}