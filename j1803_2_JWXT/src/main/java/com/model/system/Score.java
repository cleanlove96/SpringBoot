package com.model.system;

public class Score {
    private String scoreId;

    private String tId;

    private String subjectId;

    private String sId;

    private Double score;

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", tId=" + tId + ", subjectId=" + subjectId + ", sId=" + sId + ", score="
				+ score + "]";
	}
}