
package aplicacion;
import aplicacion.logica.Format;
import aplicacion.logica.Validate;
import aplicacion.logica.products.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void medicineTest(){
        String scientificName = "Aspirina 1-2-3";   
        int id = 072065432;
        Medicine testMedicine = new Medicine(scientificName, id);
        
        assertEquals(scientificName, testMedicine.getScientificName());
        assertEquals(id, testMedicine.getId());
    }

    @Test
    void presentationTest(){
        String scientificName = "1 Carajo this is elon muskñ"; 
        long id = 0001422;  
        var medicine = new Medicine(scientificName, id);
        double price = 4.80;
        String commonName = "Aspirina";
        int strengthMg = 5;
        ControlType control = ControlType.FREE;
        var presentation = new Presentation(price, commonName, id, control, medicine, Format.PILL, strengthMg);
        assertEquals(id, presentation.getId());
        assertEquals(strengthMg, presentation.getStrengthMg());
        assertEquals(commonName, presentation.getCommonName());
        assertEquals(medicine, presentation.getMedicine());
        assertEquals(Format.PILL, presentation.getFormat());
        assertEquals(price, presentation.getPrice(),0.01); 
        assertEquals(ControlType.FREE, presentation.getControl());
    }

    @Test
    void validacionesnTest(){
        var exception = IllegalArgumentException.class;
        assertThrows(exception, ()-> Validate.isNotEmpty(null));
        assertThrows(exception, ()-> Validate.isNotEmpty("          "));
        assertThrows(exception, ()-> Validate.isHumanName("pene  e"));
        assertThrows(exception, ()-> Validate.isHumanName("-amapola 23"));
        assertThrows(exception, ()-> Validate.isGreaterThanZero(0));
        assertThrows(exception, ()-> Validate.isPositiveNumber(-7));
    }

    @Test
    void MedicalSupplyTest(){
        long id = 1002932038;
        String name = "Íntima";
        double price = 45.00;
        ControlType control = ControlType.DISPATCH_BOOK;
        var intima = new MedicalSupply(price, name, id, control);
        
        assertEquals(id, intima.getId());
        assertEquals(name, intima.getCommonName());
        assertEquals(price, intima.getPrice());
        assertEquals(ControlType.DISPATCH_BOOK, intima.getControl());
    }
}
