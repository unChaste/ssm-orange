package io.toya.response;

import java.util.Date;

public class MoodListResponse {
    private Integer moodId;

    private String userNickname;

    private String content;

    private Integer praiseNum;

    private Boolean hasPraised;

    private Date createTime;

    public Integer getMoodId() {
        return moodId;
    }

    public void setMoodId(Integer moodId) {
        this.moodId = moodId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Boolean getHasPraised() {
        return hasPraised;
    }

    public void setHasPraised(Boolean hasPraised) {
        this.hasPraised = hasPraised;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
