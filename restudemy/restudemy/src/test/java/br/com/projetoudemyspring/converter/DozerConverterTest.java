package br.com.projetoudemyspring.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import br.com.projetoudemyspring.converter.mocks.MockPerson;
import br.com.projetoudemyspring.model.entities.Person;
import br.com.projetoudemyspring.model.vo.PersonVO;

public class DozerConverterTest {
	
	  MockPerson inputObject;

	    @Before(value = "")
	    public void  setUp() {
	        inputObject = new MockPerson();
	    }

	    @Test
	    public void  parseEntityToVOTest() {
	        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
	        assertEquals(Long.valueOf(0L), output.getId());
	        assertEquals("First Name Test0", output.getFirstName());
	        assertEquals("Last Name Test0", output.getLastName());
	        assertEquals("Addres Test0", output.getAddress());
	        assertEquals("Male", output.getGender());
	    }

	    @Test
	    public void  parseEntityListToVOListTest() {
	        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
	        PersonVO outputZero = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), outputZero.getId());
	        assertEquals("First Name Test0", outputZero.getFirstName());
	        assertEquals("Last Name Test0", outputZero.getLastName());
	        assertEquals("Addres Test0", outputZero.getAddress());
	        assertEquals("Male", outputZero.getGender());
	        
	        PersonVO outputSeven = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), outputSeven.getId());
	        assertEquals("First Name Test7", outputSeven.getFirstName());
	        assertEquals("Last Name Test7", outputSeven.getLastName());
	        assertEquals("Addres Test7", outputSeven.getAddress());
	        assertEquals("Female", outputSeven.getGender());
	        
	        PersonVO outputTwelve = outputList.get(12);
	        
	        assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        assertEquals("First Name Test12", outputTwelve.getFirstName());
	        assertEquals("Last Name Test12", outputTwelve.getLastName());
	        assertEquals("Addres Test12", outputTwelve.getAddress());
	        assertEquals("Male", outputTwelve.getGender());
	    }

	    @Test
	    public void  parseVOToEntityTest() {
	        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
	        assertEquals(Long.valueOf(0L), output.getId());
	        assertEquals("First Name Test0", output.getFirstName());
	        assertEquals("Last Name Test0", output.getLastName());
	        assertEquals("Addres Test0", output.getAddress());
	        assertEquals("Male", output.getGender());
	    }

	    @Test
	    public void  parserVOListToEntityListTest() {
	        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
	        Person outputZero = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), outputZero.getId());
	        assertEquals("First Name Test0", outputZero.getFirstName());
	        assertEquals("Last Name Test0", outputZero.getLastName());
	        assertEquals("Addres Test0", outputZero.getAddress());
	        assertEquals("Male", outputZero.getGender());
	        
	        Person outputSeven = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), outputSeven.getId());
	        assertEquals("First Name Test7", outputSeven.getFirstName());
	        assertEquals("Last Name Test7", outputSeven.getLastName());
	        assertEquals("Addres Test7", outputSeven.getAddress());
	        assertEquals("Female", outputSeven.getGender());
	        
	        Person outputTwelve = outputList.get(12);	
	        
	        assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        assertEquals("First Name Test12", outputTwelve.getFirstName());
	        assertEquals("Last Name Test12", outputTwelve.getLastName());
	        assertEquals("Addres Test12", outputTwelve.getAddress());
	        assertEquals("Male", outputTwelve.getGender());
	    }
	}
