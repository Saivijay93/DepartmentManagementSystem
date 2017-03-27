
angular.module('Route', [ 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/Index', {
				templateUrl : 'index.html'
			}).when('/Student', {
				templateUrl : 'Student.html'
			}).when('/Staff', {
				templateUrl : 'Staff.html'
			}).when('/Admin', {
				templateUrl : 'Admin.html'
			}).when('/AboutUs', {
				templateUrl : 'AboutUs.html'
					
			}).when('/StudentRegistration', {
				templateUrl : 'StudentRegistration.html'
			}).when('/StudentList', {
				templateUrl : 'StudentList.html'					
			}).when('/Signin', {
				templateUrl : 'Signin.html'
					
			}).when('/StaffRegistration', {
				templateUrl : 'StaffRegistration.html'
			}).when('/StaffRegisteredList', {
				templateUrl : 'StaffRegisteredList.html'					
			}).when('/SigninStaff', {
				templateUrl : 'SigninStaff.html'
					
			}).when('/AdminUpdations', {
				templateUrl : 'AdminUpdations.html'
			}).when('/AdminStudent', {
				templateUrl : 'AdminStudent.html'
			}).when('/AdminStaff', {
				templateUrl : 'AdminStaff.html'
			}).when('/DeleteStudent', {
				templateUrl : 'DeleteStudent.html'
			}).when('/DeleteStaff', {
				templateUrl : 'DeleteStaff.html'
			}).when('/UpdateStudent', {
				templateUrl : 'UpdateStudent.html'
			}).when('/UpdateStaff', {
				templateUrl : 'UpdateStaff.html'
			}).when('/MidExamResults', {
				templateUrl : 'MidExamResults.html'
			}).when('/AddNotifications', {
				templateUrl : 'AddNotifications.html'					
			}).when('/AddTimetable', {
				templateUrl : 'AddTimetable.html'					
					
			}).when('/StudentInfo', {
				templateUrl : 'StudentInfo.html'
			}).when('/StaffInfo', {
				templateUrl : 'StaffInfo.html'
			}).when('/StudentDetails', {
				templateUrl : 'StudentDetails.html'
			}).when('/StaffDetails', {
				templateUrl : 'StaffDetails.html'					
			}).when('/Syllabus', {
				templateUrl : 'Syllabus.html'	
			}).when('/Results', {
				templateUrl : 'Results2.html'
			}).when('/Notifications1', {
				templateUrl : 'Notifications1.html'
			}).when('/Timetable', {
				templateUrl : 'Timetable.html'					

			}).when('/Alumni', {
				templateUrl : 'Alumni.html'							
					
			}).otherwise({
				redirectTo : '/Index'
			});
		} ]);

