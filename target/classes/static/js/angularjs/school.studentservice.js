var schoolApp = angular.module('schoolApp', [ 'Route' ]);

schoolApp.factory('schoolLan', function($http) {

	var schoolLan = {};

	var url = 'http://localhost:8090/school/';
	
	
// STUDENT REGISTRATION AND LOGIN
	
	schoolLan.studentWS = function(studentForm) {
		 //alert("in StudentWS");
		return $http.post(url + 'student/StudentRegister', studentForm);
	};
	
	schoolLan.getStudentsWS = function() {
		 //alert("in getStudentsWS");
		return $http.get(url + 'student/getRegisteredStudents');

	};
	
	schoolLan.signinWS = function(signinForm) {
		 //alert("in getSigninWS");
		return $http.post(url + 'student/SinginStudent', signinForm);

	};
	
	schoolLan.sendStudentOtpWS = function(studentForm) {
		 alert("Wait few seconds you have another pop up box for sent mail or not");
		return $http.post(url + 'student/sendStudentOTPWS', studentForm);

	};
	
	schoolLan.updateStudentPswdWs = function(form) {
		 //alert("in updateStudentPswdWs");
		 return $http.post(url + 'student/updateStudentPswd', form);

	};
	
	

	
	
// STAFF REGISTRAION AND LOGIN
	
	schoolLan.staffWS = function(staffForm) {
		 //alert("in StaffWS");
		return $http.post(url + 'staff/StaffRegister', staffForm);
	};
	
	schoolLan.getStaffWS = function() {
		 //alert("in getStaffWS");
		return $http.get(url + 'staff/getRegisteredStaff');

	};
	
	schoolLan.signinstaffWS = function(signinstaffForm) {
		 //alert("in getSigninWS");
		return $http.post(url + 'staff/SinginStaff', signinstaffForm);

	};

	schoolLan.sendStaffOtpWS = function(staffForm) {
		 alert("Wait few seconds you have another pop up box for sent mail or not");
		return $http.post(url + 'staff/sendStaffOTP', staffForm);

	};
	
	schoolLan.staffPasswordWs = function(form) {
		 //alert("staffPasswordWs");
		 return $http.post(url + 'staff/updatePass', form);

	};
	
	

// ADMIN UPDATIONS ON STUDENT
	
	schoolLan.adminstudentWS = function(adminstudentForm) {
		 //alert("in adminstudentWS");
		return $http.post(url + 'adminstudent/StudentRegister', adminstudentForm);
	};
	
	schoolLan.getAdminstudentsWS = function() {
		 //alert("in getAdminstudentsWS");
		return $http.get(url + 'adminstudent/getRegisteredStudents');

	};
	
	schoolLan.adminstudWS = function(adminstudentForm) {
		 //alert("in adminstudWS delete");
		return $http.post(url + 'adminstudent/deleteStud', adminstudentForm);

	};

	schoolLan.updatestudentWS = function(adminstudentForm) {
		 //alert("in updatestudentWS");
		return $http.post(url + 'adminstudent/updateStud', adminstudentForm);
	};
	
	
	

// ADMIN UPDATIONS ON STAFF
	
	schoolLan.adminstaffWS = function(adminstaffForm) {
		 //alert("in adminstaffWS");
		return $http.post(url + 'adminstaff/StaffRegister', adminstaffForm);
	};
	
	schoolLan.getAdminstaffWS = function() {
		 //alert("in getAdminstaffWS");
		return $http.get(url + 'adminstaff/getRegisteredStaff');

	};
	
	schoolLan.updatestaffWS = function(adminstaffForm) {
		 //alert("in updatestaffWS");
		return $http.post(url + 'adminstaff/updateStaff', adminstaffForm);
	};
	
	schoolLan.deletestaffWS = function(adminstaffForm) {
		 //alert("in deletestaffWS delete");
		return $http.post(url + 'adminstaff/deleteStaff', adminstaffForm);

	};
	
	
	

// Get Alumni Students
	
	schoolLan.alumnistudentsWS = function(alumniForm) {
		 //alert("in alumnistudentsWS");
		return $http.post(url + 'adminstudent/retrievingAlumnistudents', alumniForm);
	};
	
	
	

// ADMIN UPDATIONS ON TIMETABLE
	
	schoolLan.addTimetableWS = function(timetableForm) {
		 //alert("in addTimetableWS");
		return $http.post(url + 'timetable/newTimetable', timetableForm);
	};
	
	/*schoolLan.getTimetableWS = function() {
		 //alert("in getTimetableWS");
		return $http.get(url + 'timetable/getAdminTimetable');

	};*/
	
	schoolLan.timetableWS = function(timetableForm) {
		 //alert("in timetableWS");
		return $http.post(url + 'timetable/getTimetable', timetableForm);
	};
	
	

	
// ADMIN UPDATIONS ON NOTIFICATIONS
	
	schoolLan.registerMsgWS = function(addMessages) {
		 //alert("in registerMsgWS");
		return $http.post(url + 'message/addMessage', addMessages);
	};
	
	schoolLan.getStaffMsgWS = function() {
		 //alert("in getStaffMsgWS");
		return $http.get(url + 'message/getStaffMessage');

	};
	
	schoolLan.getStudentMsgWS = function() {
		 //alert("in getStudentMsgWS");
		return $http.get(url + 'message/getStudentMessage');

	};
	
	

	
// ADMIN UPDATIONS ON MID EXAM RESULTS

	schoolLan.registerExamResultsWS = function(examForm) {
		 //alert("in registerExamResultsWS");
		return $http.post(url + 'results/addExamResults', examForm);
	};
	
	/*schoolLan.getExamResultsWS = function() {
		 //alert("in getExamResultsWS");
		return $http.get(url + 'results/getExamResults');

	};*/
	
	schoolLan.midexamresultsWS = function(midresultsForm) {
		 //alert("in midexamresultsWS");
		return $http.post(url + 'results/getStudentresults', midresultsForm);
	};
	
	
	
// ADMIN UPDATIONS ON Syllabus

	schoolLan.fileSelectedWS = function(addFile) {
		 alert("in registerFileWS");
		return $http.post(url + 'files/addFiles', addFile);
	};
	
	
// CONTACT MESSAGES
	
	schoolLan.contactFormWS = function(studentForm) {
		 alert("Wait few seconds you have another pop up box for sent mail or not");
		return $http.post(url + 'student/studentContact', studentForm);

	};
	
	
	
	return schoolLan;
});