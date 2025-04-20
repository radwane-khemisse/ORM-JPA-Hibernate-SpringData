package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService){
		return args -> {
			// Code to run at startup

			Stream.of("salah","redone","houssa")
					.forEach(name -> {
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(true);
				hospitalService.savePatient(patient);
			});
			Stream.of("dr.karim","dr.redone","dr.houssa")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite("Cardiologue");
						hospitalService.saveMedecin(medecin);
					});
			Patient patient = hospitalService.findPatientById(1L);
			Patient patient1 = hospitalService.findPatientByNom("salah");

			Medecin medecin = hospitalService.findMedecinByNom("dr.houssa");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);

			hospitalService.saveRendezVous(rendezVous);

			RendezVous rendezVous1 = hospitalService.findRendezVousById(1L);
			Consultation consultation= new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("rappport de la consultation ........");
			hospitalService.saveConsultation(consultation);






		};
	}

}
