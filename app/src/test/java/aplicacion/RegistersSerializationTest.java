package org.example;

import aplicacion.logica.products.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class RegistersSerializationTest {
    @Test
    
    void productsSerialized(){
        var controlType = ControlType.FREE;
        long id = Long.parseLong("03120766886");
        double price = 50.5;
        String name = "espadadrapo";

        var espadadrapo = new MedicalSupply(price, name, id, controlType);

        try(var fos = new FileOutputStream("espadadrapo.med");
            var oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(espadadrapo);
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }

        try(var fis = new FileInputStream("espadadrapo.med");
            var ois = new ObjectInputStream(fis))
        {
            var dupplicated = (MedicalSupply)(ois.readObject());
            dupplicated.setId(id);
            assertEquals(espadadrapo,dupplicated);
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
        catch (ClassNotFoundException e) 
        {
            System.err.println(e.getMessage());
        }    
    }
}
