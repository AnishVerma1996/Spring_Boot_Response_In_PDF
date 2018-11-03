package com.boot.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.app.bean.City;
import com.boot.app.bean.ResponseStatus;
import com.boot.app.service.ICityService;
import com.boot.app.utility.GeneratePdfReport;

@RestController
public class PdfController {
	@Autowired
	ICityService cityService;
@GetMapping("pdfreport")
	//@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> citiesReport() throws IOException {

		List<City> cities = (List<City>) cityService.findAll();

		ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
@PostMapping("/savedata")

public ResponseStatus saveCityData(@RequestBody City city)
{
	ResponseStatus b=cityService.saveCity(city);
	return new ResponseStatus("save successfull");
	
}
}
