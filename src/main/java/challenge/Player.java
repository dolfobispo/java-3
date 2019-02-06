package challenge;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
	private String fullName;
	private String name;
	private String club;
	private String nationality;
	private LocalDate birthDate;
	private BigDecimal eurWage;
	private Integer age;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public BigDecimal getEurWage() {
		return eurWage;
	}
	public void setEurWage(BigDecimal eurWage) {
		this.eurWage = eurWage;
	}
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
	public static Player mockPlayer(String line) {
		String[] newLine = line.split(",");
		Player player = new Player();
		player.setFullName(newLine[Columns.FULL_NAME]);
		player.setName(newLine[Columns.NAME]);
		player.setClub(newLine[Columns.CLUB]);
		player.setNationality(newLine[Columns.NATIONALITY]);
		LocalDate birthDate= FormatDate.format(newLine[Columns.BIRTH_DATE]);
		player.setBirthDate(birthDate);
		player.setEurWage(new BigDecimal(newLine[Columns.EUR_WAGE]));
		Integer age=Integer.valueOf(newLine[Columns.AGE]); 
		player.setAge(age);
		if(newLine[Columns.EUR_RELEASE_CLAUSE].length()==0) {
			player.setEurReleaseClause(new BigDecimal(0));
		}else {
			player.setEurReleaseClause(new BigDecimal(newLine[Columns.EUR_RELEASE_CLAUSE]));
		}	
		return player;
	}
	public  static List<Player> readPlayerCsv(String fileName) {
		List<Player> result = new ArrayList<Player>();
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			result=lines.skip(1).map(line-> {
				Player player= Player.mockPlayer(line);
				return player;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.getMessage();
		}

		return result;

	}
	private BigDecimal eurReleaseClause;

}
