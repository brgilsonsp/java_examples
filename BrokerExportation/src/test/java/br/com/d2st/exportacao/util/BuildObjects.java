package br.com.d2st.exportacao.util;

import java.util.ArrayList;
import java.util.List;

import br.com.d2st.exportacao.model.MessageKind;
import br.com.d2st.exportacao.model.MessageNumber;
import br.com.d2st.exportacao.model.RequestEdx;
import br.com.d2st.exportacao.model.Str;

public abstract class BuildObjects {

	public static Str getStr() {
		return new Str("T", "XMLVR", "ENVRM", "INTNT");
	}
	
	/**
	 * NO banco de dados serão considerados objetos iguais, aqueles que possuem o mesmo MessageNumber E MessageKind, 
	 * @return List de RequestEdx
	 */
	public static List<RequestEdx> getListRequestEdxEquals() {
		List<RequestEdx> listRequest = new ArrayList<>();		
		listRequest.add(new RequestEdx("CONSULTA_LISTA_GTE", "S", "CONSULTA-LISTA", MessageNumber.One, MessageKind.Exportation));
		listRequest.add(new RequestEdx("CONSULTA_EMBARQUE_GTE", "S", "CONSULTA_EMBAR_GTE", MessageNumber.One, MessageKind.Exportation));		
		return listRequest;
	}
	
	public static List<RequestEdx> getListRequestEdx() {
		List<RequestEdx> listRequest = new ArrayList<>();		
		listRequest.add(new RequestEdx("CONSULTA_LISTA_GTE", "S", "CONSULTA-LISTA", MessageNumber.One, MessageKind.Exportation));
		listRequest.add(new RequestEdx("CONSULTA_EMBARQUE_GTE", "S", "CONSULTA_EMBAR_GTE", MessageNumber.Two, MessageKind.Exportation));		
		listRequest.add(new RequestEdx("ATUALIZA_EMBARQUE_GTE", "S", "ATUALIZA_EMBAR_GTE", MessageNumber.Three, MessageKind.Exportation));		
		listRequest.add(new RequestEdx("ATUALIZA_PC_GTE", "S", "ATUALIZA_PC_GTE", MessageNumber.Four, MessageKind.Exportation));		
		listRequest.add(new RequestEdx("CONSULTA_PC_GTE", "S", "CONSULTA_PC_GTE", MessageNumber.Five, MessageKind.Exportation));		
		return listRequest;
	}
}
