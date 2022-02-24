package br.com.gilson.estudo.collections;

import java.util.Arrays;
import java.util.List;

public class Utils {

	public static List<Aula> getAulas(){
		Aula java = new Aula("java");
		Aula node = new Aula("node");
		Aula csharp = new Aula("csharp");
		Aula flutter = new Aula("flutter");
		
		return Arrays.asList(node, csharp, java, flutter);
		
	}
}
