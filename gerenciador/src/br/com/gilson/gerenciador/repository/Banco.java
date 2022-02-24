package br.com.gilson.gerenciador.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.gilson.gerenciador.model.Empresa;

public class Banco {
	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer CHAVE_SEQUENCIAL = 1;
	
	static {
		addEmpresaStatic(new Empresa("Doce Inspiração", new Date(118, 2, 4)));
		addEmpresaStatic(new Empresa("JK Store", new Date(87, 4, 23)));
		addEmpresaStatic(new Empresa("Itaú", new Date(60, 12, 7)));
		addEmpresaStatic(new Empresa("Auto Peças do Gerente", new Date(103, 0, 30)));
	}
	
	private static void addEmpresaStatic(Empresa empresa) {
		empresa.setId(Banco.CHAVE_SEQUENCIAL++);
		Banco.empresas.add(empresa);
	}

	public void adiciona(Empresa empresa) {
		Banco.addEmpresaStatic(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.empresas);
	}

	public Empresa getEmpresaById(Integer id) { 
		return Banco.empresas.stream()
			.filter(item -> item.getId().equals(id))
			.findFirst()
			.orElse(new Empresa());
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> iterator = Banco.empresas.iterator();
		
		while(iterator.hasNext()) {
			Empresa next = iterator.next();
			if(id.equals(next.getId())) {
				iterator.remove();
			}
		}
		
	}
}
