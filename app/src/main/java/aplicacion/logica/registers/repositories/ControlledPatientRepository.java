package aplicacion.logica.registers.repositories;

import java.util.Map;
import aplicacion.logica.registers.ControlledPatient;

public class ControlledPatientRepository extends Repository<ControlledPatient> {

    public ControlledPatientRepository(Map<Long, ControlledPatient> elements) {
        super(elements);
    }

}
