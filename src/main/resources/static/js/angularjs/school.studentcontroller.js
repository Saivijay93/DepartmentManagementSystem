var controllers = {};

controllers.MainController = function($scope,schoolLan) {
	 	
	
// STUDENT REGISTRATION AND SIGNIN
	$scope.randomValue='';
	$scope.studentRollno='';
	
	$scope.registerStudent = function(studentForm) {
		var p1=studentForm.password, p2=studentForm.password2;
		 //alert("registerStudent: "+p1+" "+p2);
		if ($scope.myForm.$valid && p1 == p2) {
			//alert('our form is amazing');
		schoolLan.studentWS(studentForm).success(function(message) {
			 alert("Registered Successfully");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Already registered or Enrolled students only');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	  }
	}

	$scope.getStudents = function() {
		 //alert("retrivingStudent");
		schoolLan.getStudentsWS().success(function(message) {
			 //alert("Retrieved Successfully");
			$scope.allstudents = message;
		}).error(function(error) {
			$scope.dataLoading = false;
		});
	}
	$scope.getStudents();

	
	$scope.signinStudent = function(signinForm) {
		 //alert("signinStudent"+signinForm);
		 schoolLan.signinWS(signinForm).success(function(message) {
			//$scope.successmsg = ("SUCCESS : " + message);
			 
			var path="StudentDetails2.html"
			//alert("Successfully Verified");
			window.location.href = path;
			
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Please check Student Id and Password');
			//$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	
	
	$scope.sendStudentOtp = function(studentForm) {
		//alert("sendStudentOtp: "+studentForm.rollno);
	$scope.studentRollno=studentForm.rollno;
		schoolLan.sendStudentOtpWS(studentForm).success(function(message) {
			 alert("OTP succesfully sent to registered Email");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.randomValue=message;
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Enter Correct Roll Number');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	
	$scope.updateStudentPswd = function(form) {
		//alert("otpVerification: "+form.otp+" "+form.password);
		var a=form.otp, b=form.password;
		if(a==$scope.randomValue && b != null){
			alert("hello student");
			form.number=$scope.studentRollno;			
			schoolLan.updateStudentPswdWs(form).success(function(message) {
				 alert("succesfully updated");
				$scope.successmsg = ("SUCCESS : " + message);
				//$scope.randomValue=message;
				$scope.errormsg = null;
			}).error(function(error) {
				 alert("Error updating");
				$scope.errormsg = ("ERROR : " + error);
				$scope.successmsg = null;
				$scope.dataLoading = false;
			});
	}
		else{
			alert("Enter correct OTP and Password");
		}
	}
    
	
	
// STAFF REGISTRATION AND SIGNIN
	$scope.staffRandomInt='';
	$scope.staffRollno='';
	
	$scope.registerStaff = function(staffForm) {
		var p1=staffForm.password, p2=staffForm.password2;
		 //alert("registerStudent: "+p1+" "+p2);
		if ($scope.myForm.$valid && p1 == p2) {
		schoolLan.staffWS(staffForm).success(function(message) {
			 alert("Registered Successfully");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Enrolled students only or Already registered');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	  }
	}

	$scope.getStaff = function() {
		 //alert("retrivingStaff");
		schoolLan.getStaffWS().success(function(message) {
			 //alert("Retrieved Successfully");
			$scope.allStaff = message;
		}).error(function(error) {
			$scope.dataLoading = false;
		});
	}
	$scope.getStaff();

	
	$scope.signinStaff = function(signinstaffForm) {
		 //alert("signinStaff"+signinstaffForm);
		 schoolLan.signinstaffWS(signinstaffForm).success(function(message) {
			//$scope.successmsg = ("SUCCESS : " + message);
			
			var path="StaffDetails2.html"
			//alert("Successfully Verified");
			window.location.href = path;
			
			$scope.errormsg = null;
		}).error(function(error) {
			alert('Please check Staff Id and Password');
			//$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	
	$scope.$on('$locationChangeStart', function(event, next, current){            
	    // Here you can take the control and call your own functions:
	    alert('Sorry ! Back Button is disabled');
	    // Prevent the browser default action (Going back):
	    event.preventDefault();            
	});
	
	
	$scope.sendStaffOtp = function(staffForm) {
		//alert("sendStaffOtp: "+staffForm.idno);
	$scope.staffRollno=staffForm.idno;
		schoolLan.sendStaffOtpWS(staffForm).success(function(message) {
			 alert("OTP succesfully sent to your Email");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.staffRandomInt=message;
			$scope.errormsg = null;
		}).error(function(error) {
			 alert("Error correct id number");
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	$scope.updateStaffPswd = function(form) {
		//alert("otpVerification: "+form.otp+" "+form.password);
		var a=form.otp, b=form.password;
		if(a==$scope.staffRandomInt && b != null){
			alert("hello staff");
			form.number=$scope.staffRollno;			
			schoolLan.staffPasswordWs(form).success(function(message) {
				 alert("succesfully updated");
				$scope.successmsg = ("SUCCESS : " + message);
				//$scope.randomValue=message;
				$scope.errormsg = null;
			}).error(function(error) {
				 alert("Updating failed");
				$scope.errormsg = ("ERROR : " + error);
				$scope.successmsg = null;
				$scope.dataLoading = false;
			});
	}
		else{
			alert("Enter correct OTP and Password");
		}
	}
	
	
	
	
// ADMIN UPDATIONS ON STUDENT	
	
	$scope.addGender = ["Male", "Female"];
	$scope.addBatch = ["2016-19", "2015-18", "2014-17","2013-16", "2012-15", "2011-14", "2010-13", "2009-12", "2008-11"];
	$scope.registerAdminstudent = function(adminstudentForm) {
		 //alert("registerStudent"+adminstudentForm);
		schoolLan.adminstudentWS(adminstudentForm).success(function(message) {
			 //alert("Registered Successfully");
			alert("Successfully Added");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			alert('Failed to add student');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}	

	$scope.getAdminstudents = function() {
		 //alert("retrivingStudent");
		schoolLan.getAdminstudentsWS().success(function(message) {
			 //alert("Retrieved Successfully");
			$scope.allAdminstudents = message;
		}).error(function(error) {
			$scope.dataLoading = false;
		});
	}
	$scope.getAdminstudents();
	
	
	$scope.adminstudent = function(adminstudentForm) {
		 //alert("delete student "+adminstudentForm);
		schoolLan.adminstudWS(adminstudentForm).success(function(message) {
			
			$scope.allAdminstud= message;
			//$scope.successmsg = ("SUCCESS : " + message);
			alert('Student successfully deleted');
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error student deleting');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	
	$scope.updateStudent = function(adminstudentForm) {
		 //alert("updateStudent "+adminstudentForm);
		schoolLan.updatestudentWS(adminstudentForm).success(function(message) {
			
			$scope.allAdminupdates= message;
			alert('Student successfully updated');
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error student updating');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	

	
// Get Alumni Students
	
	$scope.alumni1 = ["2016-19", "2015-18", "2014-17"];
	$scope.alumni2 = ["2013-16", "2012-15", "2011-14", "2010-13", "2009-12", "2008-11"];
	$scope.alumnistudents = function(alumniForm) {
		 //alert("alumni students "+alumniForm.batch);
		schoolLan.alumnistudentsWS(alumniForm).success(function(message) {
			 //alert("Retrieved successfully");
			$scope.allAlumniStudents= message;
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error getting students');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}

	
	
	
// ADMIN UPDATIONS ON STAFF	
	
	$scope.addStaffGender = ["Male", "Female"];
	$scope.branch = ["MCA"];
	$scope.registerAdminstaff = function(adminstaffForm) {
		 //alert("registerStaff"+adminstaffForm);
		schoolLan.adminstaffWS(adminstaffForm).success(function(message) {
			alert("Successfully Added");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error adding Staff');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	$scope.getAdminstaff = function() {
		 //alert("retrivingStaff");
		schoolLan.getAdminstaffWS().success(function(message) {
			 //alert("Retrieved Successfully");
			$scope.allAdminstaff = message;
		}).error(function(error) {
			$scope.dataLoading = false;
		});
	}
	$scope.getAdminstaff();
	
	$scope.updateStaff = function(adminstaffForm) {
		 //alert("updateStudent "+adminstaffForm);
		schoolLan.updatestaffWS(adminstaffForm).success(function(message) {
			
			$scope.allAdminupdates= message;
			alert('Staff successfully updated');
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error staff updating');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	$scope.deletestaff = function(adminstaffForm) {
		 //alert("delete staff "+adminstaffForm);
		schoolLan.deletestaffWS(adminstaffForm).success(function(message) {
			
			$scope.allDeletestaff= message;
			//$scope.successmsg = ("SUCCESS : " + message);
			alert('Staff successfully deleted');
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error staff deleting');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	
	
// ADMIN UPDATIONS ON TIMETABLE	
	
	$scope.addtimetablesem = ["1", "2", "3", "4", "5"];
	$scope.addtimetableday = ["MON", "TUE", "WED", "THU", "FRI", "SAT"];
	$scope.addTimetable = function(timetableForm) {
		 //alert("addTimetable"+timetableForm);
		schoolLan.addTimetableWS(timetableForm).success(function(message) {
			 alert("Timetable added successfully");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error adding Timetable');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}

	/*$scope.getAdminTimetable = function() {
		 //alert("retrieving Timetable");
		schoolLan.getTimetableWS().success(function(message) {
			 //alert("Retrieved Successfully");
			$scope.allTimetables = message;
		}).error(function(error) {
			$scope.dataLoading = false;
		});
	}
	$scope.getAdminTimetable();*/
	
	$scope.timetable = ["1", "2", "3", "4", "5"];
	$scope.timetableList = function(timetableForm) {
		 //alert("timetable "+timetableForm);
		 //alert("timetable "+timetableForm.sem);
		schoolLan.timetableWS(timetableForm).success(function(message) {
			 //alert("Retrieved successfully");
			$scope.allTimetablelist= message;
			
		}).error(function(error) {
			 alert('Error getting timetable');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	

// ADMIN UPDATIONS ON MID EXAM RESULTS
	
	$scope.semester = ["1", "2", "3", "4", "5"];
	$scope.mids = ["I", "II"];
	$scope.registerExamResults = function(examForm) {
		 //alert("registerExamResults "+examForm);
		schoolLan.registerExamResultsWS(examForm).success(function(message) {
			 alert("MID Exam results added Successfully");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error adding results');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}

	/*$scope.getAdminExamResults = function() {
		 //alert("retrieving Timetable");
		schoolLan.getExamResultsWS().success(function(message) {
			 //alert("Retrieved Successfully");
			$scope.allResults = message;
		}).error(function(error) {
			$scope.dataLoading = false;
		});
	}
	$scope.getAdminExamResults();*/
	
	$scope.names = ["1", "2", "3", "4", "5"];
	$scope.names2 = ["I", "II"];
	$scope.midexamresults = function(midresultsForm) {
		 //alert("mid exam results "+midresultsForm);
		 //alert("mid exam results "+midresultsForm.sem);
		schoolLan.midexamresultsWS(midresultsForm).success(function(message) {
			 //alert("Retrieved successfully");
			$scope.allStudentresults= message;
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error getting students');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
	
	
	
// ADMIN UPDATIONS ON NOTIFICATIONS	
	
	$scope.person = ["Student", "Staff"];
	$scope.registerMsg = function(addMessages) {
		 //alert("registerMsg"+addMessages);
		schoolLan.registerMsgWS(addMessages).success(function(message) {
			 alert("Notification added Successfully");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error adding notification');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}

	$scope.getStaffMsg = function() {
		 //alert("retrieving Staff messages");
		schoolLan.getStaffMsgWS().success(function(message) {
			 //alert("Retrieved staff messages successfully");
			$scope.getStaffMsgs = message;
		}).error(function(error) {
			$scope.dataLoading = false;
		});
	}
	$scope.getStaffMsg();
	
	$scope.getStudentMsg = function() {
		 //alert("retrieving student messages");
		schoolLan.getStudentMsgWS().success(function(message) {
			//alert("Retrieved student messages successfully");
			$scope.getStudentMsgs = message;
		}).error(function(error) {
			//alert("Error retriving student messages");
			$scope.dataLoading = false;
		});
	}
	$scope.getStudentMsg();
	
	
	
// ADMIN UPDATIONS ON Syllabus	
	
	/*$scope.registerFile = function(){
		  var f = document.getElementById('file').files[0],
		      r = new FileReader();
		  alert("registerFile "+f);
		  alert("registerFile 2"+r);
		  r.onloadend = function(e){
		    var data = e.target.result;
		    schoolLan.fileSelectedWS(data).success(function(message) {
				 alert("Files added Successfully");
				$scope.errormsg = null;
			}).error(function(error) {
				 alert('Error adding files');
				$scope.successmsg = null;
				$scope.dataLoading = false;
			});
		    //send your binary data via $http or $resource or do anything else with it
		  }
		  r.readAsBinaryString(f);
		}*/
	
	$scope.registerFile = function(addFile) {
		 alert("registerFile "+addFile);
		schoolLan.fileSelectedWS(addFile).success(function(message) {
			 alert("Files added Successfully");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Error adding files');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}
	
		

	
// CONTACT MESSAGES
	
	$scope.contactForm = function(studentForm) {
		alert("contactForm: "+studentForm.name+" "+studentForm.mail+" "+studentForm.msg);
		schoolLan.contactFormWS(studentForm).success(function(message) {
			 alert("Thank you for contact with us");
			$scope.successmsg = ("SUCCESS : " + message);
			$scope.randomValue=message;
			$scope.errormsg = null;
		}).error(function(error) {
			 alert('Enter Correct details');
			$scope.errormsg = ("ERROR : " + error);
			$scope.successmsg = null;
			$scope.dataLoading = false;
		});
	}	
	
	

// ADMIN LOGIN
	
	$scope.registerAdmin = function(adminLogin) {
		 //alert("registerAdmin"+adminLogin);
		 //alert(adminLogin.pass);
		 
		 if(adminLogin.key=="admin" && adminLogin.userName=="admin")
		     {
			    //alert("successfully logined");
			    var path="AdminUpdations.html"
			    //var path="admin/abc.html"
	
			 window.location.href = path;
			 }
		 else{
			 alert("Please check Admin Name and Password");
			 }
	}
	
	
}
schoolApp.controller(controllers);
