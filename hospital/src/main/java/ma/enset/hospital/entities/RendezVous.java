package ma.enset.hospital.entities;

import java.util.Date;

public class RendezVous {
    private Long id;
    private Date date;
    private StatusRDV status;
    private boolean annule;
    private Patient patient;
    private Medecin medecin;

}
