package challenge;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileReader {
	final static String fileName = "data.csv";
	
	
	private CsvFileReader() {
	}
	public  static List<Player> readCsv() {
			List<Player> players = new ArrayList<Player>();
			try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
				players=lines.skip(1).map(line-> {
					String[] newLine = line.split(",");
					Player player = new Player();
					player.setFullName(newLine[Columns.FULL_NAME]);
					player.setName(newLine[Columns.NAME]);
					player.setClub(newLine[Columns.CLUB]);
					player.setNationality(newLine[Columns.NATIONALITY]);
					if(newLine[Columns.EUR_RELEASE_CLAUSE].length()==0) {
						player.setEurReleaseClause(new BigDecimal(0));
					}else {
						player.setEurReleaseClause(new BigDecimal(newLine[Columns.EUR_RELEASE_CLAUSE]));
					}	
					return player;
					}).collect(Collectors.toList());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return players;
			
	}
}