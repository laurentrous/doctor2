package com.doctorTests.doctor2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class Doctor2Application {

	public static void main(String[] args) {
		SpringApplication.run(Doctor2Application.class, args);
	}

	@RequestMapping("/doctor/{number}")
	@ResponseBody
	public String doctor2(@PathVariable int number) {
		if (number >= 1 && number <= 8) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "test 303");
			// statut 303
		} else if (number > 8 && number <= 13) {
			String doctors[] = {"Christopher Eccleston","David Tennant","Matt Smith","Peter Capaldi","Jodie Whittaker"};
			return "{number: " + number + ", name : " + doctors[number-9] + "}";
			//incarnation json
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "test 404");
			//404
		}
	}

}
