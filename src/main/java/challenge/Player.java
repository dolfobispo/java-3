package challenge;

import java.math.BigDecimal;

public class Player {
	private String fullName;
	private String name;
	private String club;
	private String nationality;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public Player(String fullName, String name, String club, String nationality, BigDecimal eurReleaseClause) {
		super();
		this.fullName = fullName;
		this.name = name;
		this.club = club;
		this.nationality = nationality;
		this.eurReleaseClause = eurReleaseClause;
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public BigDecimal getEurReleaseClause() {
		return eurReleaseClause;
	}
	public void setEurReleaseClause(BigDecimal eurReleaseClause) {
		this.eurReleaseClause = eurReleaseClause;
	}
	private BigDecimal eurReleaseClause;
	
}
