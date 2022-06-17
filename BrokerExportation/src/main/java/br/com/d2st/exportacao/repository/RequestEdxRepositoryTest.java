package br.com.d2st.exportacao.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.d2st.exportacao.model.RequestEdx;
import br.com.d2st.exportacao.model.Str;
import br.com.d2st.exportacao.util.BuildObjects;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RequestEdxRepositoryTest {
	
	@Autowired
	private RequestEdxRepository repository;
	
	@Autowired
	private StrRepository strRepository;
	
	private List<RequestEdx> itensEqualsForSave;
	private RequestEdx itemManaged;
	
	@Before
	public void init() {
		Str str = BuildObjects.getStr();
		Str strManeged = strRepository.save(str);
		itensEqualsForSave = BuildObjects.getListRequestEdxEquals();
		itensEqualsForSave.forEach(r -> r.setStr(strManeged));
		RequestEdx itemForSave = itensEqualsForSave.get(0);
		itemManaged = repository.save(itemForSave);
	}
	
	@Test
	public void saveItemAndReturnItemSaved() {
		RequestEdx itemSaved = itensEqualsForSave.get(0);
		
		assertTrue(itemManaged.equals(itemSaved));
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void trhowExceptionIfSaveEqualsItens() {
		RequestEdx itemEqual = itensEqualsForSave.get(1);
		
		repository.save(itemEqual);
	}
	
	@Test
	public void getItemById() {
		RequestEdx itemFound = repository.findOne(itemManaged.getId());
		
		assertTrue(itemFound.equals(itemManaged));
	}
	
	@Test
	public void updateItemManaged() {
		String newValue = "NewValue";	
		RequestEdx itemFound = repository.findOne(itemManaged.getId());		
		itemFound.setType(newValue);		
		RequestEdx itemAltered = repository.save(itemFound);
		
		Boolean isNewValue = itemAltered.getType().equals(newValue);
		Boolean equalsId = itemAltered.getId().equals(itemFound.getId());
		
		assertTrue(isNewValue && equalsId);
		
	}
	
	@Test
	public void removeItemManaged() {
		Long idItemSaved = itemManaged.getId();
		repository.delete(idItemSaved);
		RequestEdx itemFoundNull = repository.findOne(idItemSaved);
		
		assertTrue(itemFoundNull == null);
	}
}
