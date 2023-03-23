package com.vyshnavi.SoapUI_JAXB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jaxb.coursews.AddCourseRequest;
import com.jaxb.coursews.AddCourseResponse;
import com.jaxb.coursews.CourseInfo;
import com.jaxb.coursews.DeleteCourseRequest;
import com.jaxb.coursews.DeleteCourseResponse;
import com.jaxb.coursews.GetAllCoursesResponse;
import com.jaxb.coursews.GetCourseByIdRequest;
import com.jaxb.coursews.GetCourseByIdResponse;
import com.jaxb.coursews.ServiceStatus;
import com.jaxb.coursews.UpdateCourseRequest;
import com.jaxb.coursews.UpdateCourseResponse;
import com.vyshnavi.SoapUI_JAXB.entity.Course;
import com.vyshnavi.SoapUI_JAXB.service.CourseService;

@Endpoint
public class CourseEndpoint {

	private static final String NAMESPACE_URI = "http://www.jaxb.com/coursews";
	
	@Autowired
	private CourseService courseService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCourseByIdRequest")
	@ResponsePayload
	public GetCourseByIdResponse getCourseById(@RequestPayload GetCourseByIdRequest request) 
	{
		GetCourseByIdResponse response = new GetCourseByIdResponse();
		CourseInfo courseInfo = new CourseInfo();
		BeanUtils.copyProperties(courseService.getCourseById(request.getCourseId()), courseInfo);
		response.setCourseInfo(courseInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCoursesRequest")
	@ResponsePayload
	public GetAllCoursesResponse getAllCourses() 
	{
		GetAllCoursesResponse response = new GetAllCoursesResponse();
		List<CourseInfo> courseInfoList = new ArrayList<>();
		List<Course> courseList = courseService.getAllCourses();
		
		for (int i = 0; i < courseList.size(); i++) 
		{
			CourseInfo ob = new CourseInfo();
			BeanUtils.copyProperties(courseList.get(i), ob);
			courseInfoList.add(ob);
		}
		response.getCourseInfo().addAll(courseInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCourseRequest")
	@ResponsePayload
	public AddCourseResponse addCourse(@RequestPayload AddCourseRequest request) 
	{
		AddCourseResponse response = new AddCourseResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Course course = new Course();
		course.setTitle(request.getTitle());
		course.setDescription(request.getDescription());
		boolean flag = courseService.addCourse(course);
		
		if (flag == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Content Already Available");
			response.setServiceStatus(serviceStatus);
		} else {
			CourseInfo courseInfo = new CourseInfo();
			BeanUtils.copyProperties(course, courseInfo);
			response.setCourseInfo(courseInfo);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
			response.setServiceStatus(serviceStatus);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCourseRequest")
	@ResponsePayload
	public UpdateCourseResponse updateCourse(@RequestPayload UpdateCourseRequest request) 
	{
		Course course = new Course();
		BeanUtils.copyProperties(request.getCourseInfo(), course);
		courseService.updateCourse(course);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateCourseResponse response = new UpdateCourseResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCourseRequest")
	@ResponsePayload
	public DeleteCourseResponse deleteCourse(@RequestPayload DeleteCourseRequest request) 
	{
		Course course = courseService.getCourseById(request.getCourseId());
		ServiceStatus serviceStatus = new ServiceStatus();
		if (course == null) {
			serviceStatus.setStatusCode("FAIL");
			serviceStatus.setMessage("Content Not Available");
		} else {
			courseService.deleteCourse(course);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Deleted Successfully");
		}
		DeleteCourseResponse response = new DeleteCourseResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}
	


}