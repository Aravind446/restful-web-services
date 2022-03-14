package com.soap.webservices.soapcoursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.spring.course.GetCourseDetailsResponse
@Endpoint
public class CourseDetails {
     @PayloadRoot(namspace="http://spring.com/course", localPart = "")
    public GetCourseDetailsResponse processCourseDetailsRequest(GetCourseDetailsRequest request) {}
  GetCourseDetailsResponse response = new GetCourseDetailsResponse();
  return response;
}
