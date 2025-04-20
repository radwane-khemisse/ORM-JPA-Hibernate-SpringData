package ma.enset.hospital;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
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
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository){
		return args -> {
			// Code to run at startup

			Stream.of("salah","redone","houssa")
					.forEach(name -> {
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(true);
				patientRepository.save(patient);
			});
			Stream.of("dr.karim","dr.redone","dr.houssa")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite("Cardiologue");
						medecinRepository.save(medecin);
					});




		};
	}

}
