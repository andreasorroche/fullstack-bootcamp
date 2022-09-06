package es.avante.fullstackbootcamp.basic.language;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class JavaLanguageFeatures {
	
	@Test
	public void whenVarInitWithString_thenGetStringTypeVar() {
		var message = "Hola";
		assertTrue(message instanceof String);
	}
	
	@Test
	public void whenVarInitWithAnonymous_thenGetAnonymousType() {
		var obj = new Object() {};
		assertFalse(obj.getClass().equals(Object.class));
	}

}
