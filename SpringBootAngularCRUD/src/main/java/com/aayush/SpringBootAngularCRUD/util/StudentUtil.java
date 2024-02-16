package com.aayush.SpringBootAngularCRUD.util;

import org.springframework.stereotype.Component;

import com.aayush.SpringBootAngularCRUD.model.Student;

@Component
public class StudentUtil {

	
	public void calculateDetails(Student s) {

		var fee = s.getStdFee();
		var disc = fee*10/100.0;
		var gst = fee*12/100.0;
		
		s.setStdFeeDisc(disc);
		s.setStdFeeGst(gst);
		
		
	}
}
