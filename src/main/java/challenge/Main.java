package challenge;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
	List <Player> players = CsvFileReader.readCsv();
	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() throws IOException {
		List<String> nationalities=players.stream().map(player -> player.getNationality()).distinct()
				.collect(Collectors.toList());
		return nationalities.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		List<String> clubs=players.stream().skip(1).map(player->player.getClub()).distinct()
				.collect(Collectors.toList());
		return clubs.size()-1;
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<String> names=players.stream().map(player->player.getName()).limit(20)
				.collect(Collectors.toList());
		return names;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		Collections.sort(players, Comparator.comparing(Player::getEurReleaseClause).reversed());
		List<String> result = players.stream().map(player->player.getFullName()).limit(10)
				.collect(Collectors.toList());
		return result;
	}
	
	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return null;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}

}
