'use strict';

var sys = {
	//
	// declare an empty app
	app: {},
	//
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicitly call 'app.receivedEvent(...);'
    onDeviceReady: function() {
    	sys.receivedEvent('deviceready');
    },

    // Update DOM on a Received Event
    receivedEvent: function(id) {
        console.log('Received Event: ' + id);
    }
};

sys.app = angular.module('myApp', ['onsen.directives']);

sys.app.config(function($sceDelegateProvider) {
   $sceDelegateProvider.resourceUrlWhitelist([
     // Allow same origin resource loads.
     'self',
     // Allow loading from our assets domain.  Notice the difference between * and **.
     'http://www.youtube.com/**'
   ]);
});

var SERVER_URL = 'http://localhost:8080'

	app.factory('$Login', function() {
		var user = false

		return {
			getLogin : function() {
				return (user) ? user : false
			},
			setUser : function(newUser) {
				user = newUser
			}
		}
	})