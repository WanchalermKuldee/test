(function(){
	  'use strict';
	  var module = angular.module('app', ['onsen']);

	  module.controller('AppController', function($scope, $data, $Login) {
	    $scope.doSomething = function() {
	      setTimeout(function() {
	        alert('tappaed');
	      }, 100);
	    };
	    $scope.logout = function() {
			$Login.setUser(false)
			$scope.userName = ""; 
			$scope.passWord = "";
			loginModel.show();
		};
	  });

	    module.controller('MasterController', function($scope, $data) {
	    $scope.items = $data.items; 
	    
	    $scope.showDetail = function(index) {
	      var selectedItem = $data.items[index];
	      $data.selectedItem = selectedItem;
	      $scope.ons.navigator.pushPage('page1.html', {title : selectedItem.title});
	    };
	  });
	  
	  module.controller('MasterController2', function($scope, $data) {
		    $scope.items = $data.items2; 
		    
		    $scope.showDetail2 = function(index) {
		      var selectedItem = $data.items2[index];
		      $data.selectedItem = selectedItem;
		      $scope.ons.navigator.pushPage('page8_3.html', {title : selectedItem.title});
		    };
		  });
	  module.controller('MasterController3', function($scope, $data) {
		    $scope.items = $data.items3; 
		    
		    $scope.showDetail3 = function(index) {
		      var selectedItem = $data.items3[index];
		      $data.selectedItem = selectedItem;
		      $scope.ons.navigator.pushPage('page5.html', {title : selectedItem.title});
		    };
		  });
	  module.controller('MasterController4', function($scope, $data) {
		    $scope.items = $data.items4; 
		    
		    $scope.showDetail4 = function(index) {
		      var selectedItem = $data.items4[index];
		      $data.selectedItem = selectedItem;
		      $scope.ons.navigator.pushPage('page9_4.html', {title : selectedItem.title});
		    };
		  });
	  module.controller('MasterController5', function($scope, $data) {
		    $scope.items = $data.items5; 
		    
		    $scope.showDetail5 = function(index) {
		      var selectedItem = $data.items5[index];
		      $data.selectedItem = selectedItem;
		      $scope.ons.navigator.pushPage('page3.html', {title : selectedItem.title});
		    };
		  });
	  module.controller('MasterController6', function($scope, $data) {
		    $scope.items = $data.items6; 
		    
		    $scope.showDetail6 = function(index) {
		      var selectedItem = $data.items6[index];
		      $data.selectedItem = selectedItem;
		      $scope.ons.navigator.pushPage('page7.html', {title : selectedItem.title});
		    };
		  });
	  module.controller('MasterController7', function($scope, $data) {
		    $scope.items = $data.items7; 
		    
		    $scope.showDetail7 = function(index) {
		      var selectedItem = $data.items7[index];
		      $data.selectedItem = selectedItem;
		      $scope.ons.navigator.pushPage('page8_4.html', {title : selectedItem.title});
		    };
		  });

	  module.factory('$data', function() {
	      var data = {};
	      
	      data.items = [
	                    	{ 
	                    		title: 'เพิ่มข้อมูลลูกค้า',
	                    		desc: 'เพิ่มข้อมูลลูกค้าสำหรับติดต่อใช้บริการ'
	                    	}
	                    ]; 
	      data.items1 = [
	                     	{ 
	                     		title: 'แสดงข้อมูลสินค้า',
	                     		desc: 'แสดงข้อมูลการจัดส่งสินค้าและสถานที่ในการจัดส่ง'
	                     	}
	                     ]; 
	      data.items2 = [
	                     	{ 
	                     		title: 'เพิ่มใบรายการสินค้า',
	                    	 	desc: 'เพิ่มใบรายการสินค้าตามความต้องของลูกค้า'
	                     	}
	                     ];
	      data.items3 = [
	                     	{ 
	                     		title: 'สั่งสินค้าจากผู้ให้บริการ',
	                     		desc: 'เพิ่มข้อมูลการสั่งของจากผู้ให้บริการ พร้อมคำนวนราคา ตั้งต้น'
	                     	}
	                    ];
		data.items4 = [
		               		{ 
		               			title: 'การผลิต',
		               			desc: 'จัดสรรการผลิตสินค้า'
		               		}
		               	];
		data.items5 = [
		               		{ 
		               			title: 'การจัดพนักงานลงไลน์การผลิต',
		               			desc: 'จัดสรรพนักงานเหมาะสมกับการผลืตสินค้า'
		               		}
		               	];
		data.items6 = [
		               		{ 
		               			title: 'การจัดส่ง',
		               			desc: 'เลือกจำนวนวันและรูปแบบการจัดส่งสินค้าให้ลูกค้า'
		               		}
		               	];
	    data.items7 = [
	                     	{ 
	                     		title: 'ค้นหาใบรายการสินค้า',
	                    	 	desc: 'ค้นหาใบรายการสินค้าตามที่ต้องการ'
	                     	}
	                     ];
	      return data;
	  });
	})();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
app.service('sharedProperties3',function(){
	var id = 0;
	
	return{
		setId:function(value){
			id = value;
		},
		getId:function(){
			return id;
		}
	};
});
app.controller('ManaController', function($scope, $http,$data){
	
$scope.item5 = $data.selectedItem;
	
$scope.addManager = function(){
		
		var data = {

				
				name:					$scope.name,	
				nameLineManager:		$scope.nameLineManager, 
				detel:					$scope.detel,
				telphone:   				$scope.telphone,
				lastname:  				$scope.lastname
				

		};
		
		$http.post('http://localhost:8080/man/save', data).success(function(data){
			alert(data.message);
			$scope.clear();
			
		}).error(function (data, status, headers, config){
			
			alert('กรุณากรอกข้อมูล');
		});
		
	}
	$scope.clear = function(){

			$scope.name="";
			$scope.nameLineManager="";
			$scope.detel="";
			$scope.telphone="";
			$scoop.lastname="";
	}

	
});
app.controller('ManaController2', function($scope, $http, sharedProperties3,$data){



	$scope.showall3 = function(){
			$http.get("http://localhost:8080/manager/show").success(function(data){
			$scope.datas = data;
			}).error(function(data,status,headers,config){
				console.log("ERR"+status);
				console.log("ERR"+headers);
			});
		}

			$scope.showall3();




	$scope.setManager = function(id){
		sharedProperties3.setId(id);
		myNavigator.pushPage('page3_3.html',{animation:'slide'});
	}
	
	$scope.managerDetail = function(){
		var id = sharedProperties3.getId();
		$http.get("http://localhost:8080/manager/detail/"+id).success(function(data){
			$scope.id			   =	data[0].id;
			$scope.nameLineManager =    data[0].nameLineManager;
			$scope.name            =	data[0].name;
			$scope.lastname		   = 	data[0].lastname;
			$scope.telphone		   =    data[0].telphone;
			$scope.detel		   =    data[0].detel;	
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
	}
	$scope.managerDetail();
	
	$scope.managerUpdate = function(){
		var data =
			{
				"id"			        :$scope.id,
				"nameLineManager"		:$scope.nameLineManager,
				"name"					:$scope.name,
				"lastname"				:$scope.lastname,
				"telphone"				:$scope.telphone,
				"detel"					:$scope.detel
			};
		$http.post('http://localhost:8080/manager/update',data).success(function(data){
			alert(data.message);
			$scope.ons.navigator.pushPage('page3_4.html');
			$scope.clear2();
			}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
	}
			$scope.clear2 = function(){

			$scope.name="";
			$scope.lastname="";
			$scope.nameLineManager="";
			$scope.detel="";
			$scope.telphone="";
	}


	});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
app.service('sharedProperties2',function(){
	
	  var id;
	  var username;
	  var email;

	  return {
		  getId: function() {
	          return id;
	      },
	      setId: function(ids) {
	        id = ids;
	      },
	      getUsername: function(){
	    	  return username;
	      },
	      setUsername: function(usernames){
	    	  username = usernames;
	      },
	      getEmail: function(){
	    	  return email;
	      },
	      setEmail: function(emails){
	    	  email = emails;
	      }
	};
});
app.controller('OrderProductController', function($scope, $http, sharedProperties2, $data){
	$scope.item2 = $data.selectedItem;
	
	$scope.unit = 0;
	$scope.sumcom = 0;
	
	$scope.comeco = 0;
	$scope.comgaming = 0;
	$scope.comoffice = 0;
	
	$scope.caleco = function(){
		$scope.comeco = 32000;
		$scope.unit = $scope.comeco;
	}
	$scope.calgaming = function(){
		$scope.comgaming = 85000;
		$scope.unit = $scope.comgaming;
	}
	$scope.caloffice = function(){
		$scope.comoffice = 55000;
		$scope.unit = $scope.comoffice;
	}
	
$scope.showall2 = function(){
$http.get("http://localhost:8080/user/show").success(function(data){
	$scope.datas = data;
}).error(function(data,status,headers,config){
	console.log("ERR"+status);
	console.log("ERR"+headers);
});
}
$scope.showall2();

$scope.setShared2 = function(id, username, email){
sharedProperties2.setId(id);
sharedProperties2.setUsername(username);
sharedProperties2.setEmail(email);
myNavigator.pushPage('page8.html',{animation:'slide'});
}

$scope.orderDetail = function(){
var id = sharedProperties2.getId();
$http.get("http://localhost:8080/order/detail/"+id).success(function(data){
	$scope.id			=	data[0].id;
	$scope.productname	=	data[0].productname;
	$scope.amount		=	data[0].amount;
	$scope.price		=	data[0].price;
	$scope.totalprice	=	data[0].totalprice;

}).error(function(data,status,headers,config){
	console.log("ERR"+status);
	console.log("ERR"+headers);
});
}
$scope.orderDetail();

$scope.addOrderProduct = function(){
	var username1	= sharedProperties2.getUsername();
	$scope.username	= username1;
	var email1	= sharedProperties2.getEmail();
	$scope.email	= email1;
	var totalprice1 = $scope.amount*$scope.unit;
	$scope.totalprice = totalprice1;
	var price1 = $scope.unit;
	$scope.price = price1;
var data = {
		"id"			:$scope.id,
		"customername"	:$scope.username,
		"emailcustomer"	:$scope.email,
		"productname"	:$scope.productname,
		"amount"		:$scope.amount,
		"price"			:$scope.price,
		"totalprice"	:$scope.totalprice
		
};


$http.post('http://localhost:8080/order/add', data).success(function(data){
	alert(data.message);
}).error(function (data, status, headers, config){
	alert('error');
});

		
}	
$scope.amount = 1;
});

app.controller('OrderProductController2', function($scope, $http){

	
	$scope.showall = function(){
	$http.get("http://localhost:8080/order/find").success(function(data){
	$scope.datas = data;
}).error(function(data,status,headers,config){
	console.log("ERR"+status);
	console.log("ERR"+headers);
});
}
$scope.showall();

});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
app.controller('DatauserController', function($scope, $http, $data){
	
	$scope.item = $data.selectedItem;
	
	$scope.addDatauser = function(){
		var data = {
				username:	$scope.username,
		 		age:		$scope.age,
				address:	$scope.address,
				tel:		$scope.tel,
				email:		$scope.email
				
		};
		$http.post('http://localhost:8080/data/add', data).success(function(data){
			$scope.clr();
			//alert(data.message);
		}).error(function (data, status, headers, config){
			alert('error');
		});
	}
	
	$scope.clr = function(){
		$scope.username="";
 		$scope.age="";
		$scope.address="";
		$scope.tel="";
		$scope.email="";
		
	}
	
});

app.controller('ShowController', function($scope, $http){

	
	$scope.showall = function(){
	$http.get("http://localhost:8080/show").success(function(data){
	$scope.datas = data;
}).error(function(data,status,headers,config){
	console.log("ERR"+status);
	console.log("ERR"+headers);
});
}
$scope.showall();

});

//////////////////////////////////////POND///////////////////////////////////////
app.service('sharedProperties', function () {
	  var id;
	  var customername;

	  return {
		  getId: function() {
	          return id;
	      },
	      setId: function(ids) {
	        id = ids;
	      },
	      getCustomername: function(){
	    	  return customername;
	      },
	      setCustomername: function(customernames){
	    	  customername = customernames;
	      }
	  };
	})
app.controller('DeliveryController', function($scope, $http,sharedProperties,$data){
	
	$scope.item6 = $data.selectedItem;
	
	$scope.showall = function(){
		$http.get("http://localhost:8080/delivery/showall").success(function(data){
			$scope.datas = data;
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
	}
	$scope.showall();
	
	$scope.setShared = function(id,customername){
		sharedProperties.setId(id);
		sharedProperties.setCustomername(customername);
		myNavigator.pushPage('page7_1_1.html',{animation:'slide'});
	}
	
	$scope.setShared2 = function(id,customername){
		sharedProperties.setId(id);
		sharedProperties.setCustomername(customername);
		myNavigator.pushPage('page7_2_1.html',{animation:'slide'});
	}
	
	$scope.deliveryDetail = function(){
		var id = sharedProperties.getId();
		$http.get("http://localhost:8080/delivery/detail/"+id).success(function(data){
			$scope.id			=	data[0].id;
			$scope.daytotal		=	data[0].dayTotal;
			$scope.deliverytype	=	data[0].deliveryType;
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
	}
	$scope.deliveryDetail();
	
	$scope.deliveryUpdate = function(){
		var customername1	= sharedProperties.getCustomername();
		$scope.customername	= customername1;
		var data =
			{
				"id"			:$scope.id,
				"customername"	:$scope.customername,
				"dayTotal"		:$scope.daytotal,
				"deliveryType"	:$scope.deliverytype
			};
		$http.post('http://localhost:8080/delivery/update',data).success(function(data){
			alert(data.message);
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
	}
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
app.service('watProperties',function(){
	var id = 0;
	var name = "";
	
	return{
		setId:function(value){
			id = value;
		},
		getId:function(){
			return id;
		},
		setname:function(value){
			name = value;
		},
		getname:function(){
			return name;
		}
	};
});
app.controller('supplierController', function($scope, $http ,$data ,watProperties) {
	
	$scope.item3 = $data.selectedItem;
	
	
	$scope.emp = "";
	
	$scope.showall = function(){
		$http.get("http://localhost:8080/Supplier/showall").success(function(data){
			$scope.datas = data;
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
	}
	
	$scope.showall2 = function(){
		$http.get("http://localhost:8080/user/show").success(function(data){
			$scope.datas = data;
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
		}
		$scope.showall2();

		$scope.watShared2 = function(id,name){
		watProperties.setId(id);
		watProperties.setname(name);
		//alert(name);
		$scope.m = watProperties.getname();
		$scope.emp = watProperties.getId();
		selType7.hide();
		}
	
	$scope.showall = function() {
		$http.get("http://localhost:8080/Supplier/showall").success(function(data) {
			$scope.datas = data;
		}).error(function(data, status, headers, config) {
			console.log("EER:" + status);
			console.log("EER:" + header);
		});

	}
	$scope.showall();
	
	$scope.count	= 0;
	$scope.count2	= 0;
	$scope.count3	= 0;
	$scope.count4	= 0;
	$scope.count5	= 0;
	$scope.count6	= 0;
	$scope.com 		= 0;
	
	$scope.scount	= 0;
	$scope.scount2	= 0;
	$scope.scount3	= 0;
	$scope.scount4	= 0;
	$scope.scount5	= 0;
	$scope.scount6	= 0;

	$scope.sum = 0;
	$scope.sum2 = 0;
	$scope.sum3 = 0;
	$scope.sum4 = 0;
	$scope.sum5 = 0;
	$scope.sum6 = 0;
	
	$scope.sum7 = 0;
	$scope.sum8 = 0;
	$scope.sum9 = 0;
	$scope.sum10 = 0;
	$scope.sum11 = 0;
	$scope.sum12 = 0;
	


	$scope.cal = function() {
		
		$scope.sum = 9700;
	
		$scope.sum = $scope.sum * $scope.count;
		

		
		

	}
	$scope.cal2 = function() {

		$scope.sum2 = 5700;

		$scope.sum2 = $scope.sum2 * $scope.count2;

	}
	$scope.cal3 = function() {

		$scope.sum3 = 2700;

		$scope.sum3 = $scope.sum3 * $scope.count3;

	}
	$scope.cal4 = function() {

		$scope.sum4 = 12700;

		$scope.sum4 = $scope.sum4 * $scope.count4;

	}
	$scope.cal5 = function() {

		$scope.sum5 = 1700;

		$scope.sum5 = $scope.sum5 * $scope.count5;

	}
	$scope.cal6 = function() {

		$scope.sum6 = 4700;

		$scope.sum6 = $scope.sum6 * $scope.count6;

	}
	$scope.cal7 = function() {

		$scope.total7 = 0;
		$scope.total7 = $scope.sum + $scope.sum2 + $scope.sum3 + $scope.sum4 + $scope.sum5 + $scope.sum6;

		
	}
	$scope.eco = function(){
		$scope.count	= 1;
		$scope.count2	= 1;
		$scope.count3	= 2;
		$scope.count4	= 0;
		$scope.count5	= 1;
		$scope.count6	= 1;
		$scope.scount	= $scope.count  * $scope.com;
		$scope.scount2	= $scope.count2 * $scope.com;
		$scope.scount3	= $scope.count3 * $scope.com;
		$scope.scount4	= $scope.count4 * $scope.com;
		$scope.scount5	= $scope.count5 * $scope.com;
		$scope.scount6	= $scope.count6 * $scope.com;
		$scope.sum = 9700;
		$scope.sum = $scope.sum * $scope.count * $scope.com;
		$scope.sum2 = 5700;
		$scope.sum2 = $scope.sum2 * $scope.count2 * $scope.com;
		$scope.sum3 = 2700;
		$scope.sum3 = $scope.sum3 * $scope.count3 * $scope.com;
		$scope.sum4 = 12700;
		$scope.sum4 = $scope.sum4 * $scope.count4 * $scope.com;
		$scope.sum5 = 1700;
		$scope.sum5 = $scope.sum5 * $scope.count5 * $scope.com;
		$scope.sum6 = 4700;
		$scope.sum6 = $scope.sum6 * $scope.count6 * $scope.com;
		$scope.total7 = 0;
		$scope.total7 = $scope.sum + $scope.sum2 + $scope.sum3 + $scope.sum4 + $scope.sum5 + $scope.sum6;
		}
	$scope.game = function(){
		$scope.count	= 1;
		$scope.count2	= 1;
		$scope.count3	= 8;
		$scope.count4	= 3;
		$scope.count5	= 1;
		$scope.count6	= 1;
		$scope.scount	= $scope.count  * $scope.com;
		$scope.scount2	= $scope.count2 * $scope.com;
		$scope.scount3	= $scope.count3 * $scope.com;
		$scope.scount4	= $scope.count4 * $scope.com;
		$scope.scount5	= $scope.count5 * $scope.com;
		$scope.scount6	= $scope.count6 * $scope.com;
		$scope.sum = 9700;
		$scope.sum = $scope.sum * $scope.count * $scope.com;
		$scope.sum2 = 5700;
		$scope.sum2 = $scope.sum2 * $scope.count2 * $scope.com;
		$scope.sum3 = 2700;
		$scope.sum3 = $scope.sum3 * $scope.count3 * $scope.com;
		$scope.sum4 = 12700;
		$scope.sum4 = $scope.sum4 * $scope.count4 * $scope.com;
		$scope.sum5 = 1700;
		$scope.sum5 = $scope.sum5 * $scope.count5 * $scope.com;
		$scope.sum6 = 4700;
		$scope.sum6 = $scope.sum6 * $scope.count6 * $scope.com;
		$scope.total7 = 0;
		$scope.total7 = $scope.sum + $scope.sum2 + $scope.sum3 + $scope.sum4 + $scope.sum5 + $scope.sum6;
	}
	$scope.office = function(){
		$scope.count	= 1;
		$scope.count2	= 1;
		$scope.count3	= 4;
		$scope.count4	= 1;
		$scope.count5	= 1;
		$scope.count6	= 1;
		$scope.scount	= $scope.count  * $scope.com;
		$scope.scount2	= $scope.count2 * $scope.com;
		$scope.scount3	= $scope.count3 * $scope.com;
		$scope.scount4	= $scope.count4 * $scope.com;
		$scope.scount5	= $scope.count5 * $scope.com;
		$scope.scount6	= $scope.count6 * $scope.com;
		$scope.sum = 9700;
		$scope.sum = $scope.sum * $scope.count * $scope.com;
		$scope.sum2 = 5700;
		$scope.sum2 = $scope.sum2 * $scope.count2 * $scope.com;
		$scope.sum3 = 2700;
		$scope.sum3 = $scope.sum3 * $scope.count3 * $scope.com;
		$scope.sum4 = 12700;
		$scope.sum4 = $scope.sum4 * $scope.count4 * $scope.com;
		$scope.sum5 = 1700;
		$scope.sum5 = $scope.sum5 * $scope.count5 * $scope.com;
		$scope.sum6 = 4700;
		$scope.sum6 = $scope.sum6 * $scope.count6 * $scope.com;
		$scope.total7 = 0;
		$scope.total7 = $scope.sum + $scope.sum2 + $scope.sum3 + $scope.sum4 + $scope.sum5 + $scope.sum6;
	}
	$scope.sumcomp = function(){
		$scope.com = 1;
		$scope.com = scope.com + 1;
		$scope.total7 * $scope.com;
	}
	$scope.sumcoml = function(){
		$scope.com = 1;
		$scope.com -= 1;
		$scope.total7 * $scope.com;
	}
	$scope.addSupplier = function(){
		var data = {
				cpu:			$scope.count,
				mainboard:		$scope.count2,
				ram:			$scope.count3,
				vga:			$scope.count4,
				dvd:			$scope.count5,
				acces:			$scope.count6,
				price:			$scope.total7,
				emp:			watProperties.getname()
		};
		
		$http.post('http://localhost:8080/Supplier/save',data).success(function(data){
			alert(data.message);
		}).error(function (data, status, headers, config){
			alert('error');
		});
	}
	
});
////////////////KAPITAL////////////////////////////////////////////////////////////////////////////////////////////
app.service('sharedProperties5', function () {
	  var id;
	  var customername;
	  var productname;
	  var amount;

	  return {
		  getId: function() {
	          return id;
	      },
	      setId: function(ids) {
	        id = ids;
	      },
	      getCustomername: function(){
	    	  return customername;
	      },
	      setCustomername: function(customernames){
	    	  customername = customernames;
	      },
	      getProductname: function() {
	          return productname;
	      },
	      setProductname: function(productnames) {
	        productname = productnames;
	      },
	      getAmount: function() {
	          return amount;
	      },
	      setAmount: function(amounts) {
	        amount = amounts;
	      }
	  };
	})
app.controller('ManufacController', function($scope, $http,sharedProperties5,$data){
	
	$scope.item4 = $data.selectedItem;
	
	$scope.showall = function(){
		$http.get("http://localhost:8080/manufac/showall").success(function(data){
			$scope.datas = data;
			console.log(data);
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
		
	}
	$scope.showall();
	
	$scope.setShared5 = function(id,customername,productname,amount){
		sharedProperties5.setId(id);
		sharedProperties5.setCustomername(customername);
		sharedProperties5.setProductname(productname);
		sharedProperties5.setAmount(amount);
		//alert(sharedProperties5.getId());
		myNavigator.pushPage('page9.html',{animation:'slide'});
	}
	
	$scope.manufacDetail = function(){
		
		var id = sharedProperties5.getId();
		var customername1		= sharedProperties5.getCustomername();
		$scope.customername		= customername1;
		
		var productname1	= sharedProperties5.getProductname();
		$scope.productname	= productname1;
		
		var amount1				= sharedProperties5.getAmount();
		$scope.amount			= amount1;
		//alert(amount);
		//alert(amount1);
		$http.get("http://localhost:8080/manufac/detail/"+id).success(function(data){
			$scope.id			=	data.id;
			$scope.sumall		=	data.amountcpu;
			$scope.sumall2		=	data.amountmainboard;
			$scope.sumall3		=	data.amountram;
			$scope.sumall4		=	data.amountvga;
			$scope.sumall5		=	data.amountdvd;
			$scope.sumall6		=	data.amountaccessoeies;
			
		}).error(function(data,status,headers,config){
			console.log("ERR"+status);
			console.log("ERR"+headers);
		});
	}
	$scope.manufacDetail();
	
		$scope.sum;
		$scope.sum2;
		$scope.sum3;
		$scope.sum4;
		$scope.sum5;
		$scope.sum6;
		
				
		
		if(sharedProperties5.getProductname()=="eco"){
			$scope.sum = 1;
			$scope.sum2 = 1;
			$scope.sum3 = 2;
			$scope.sum4 = 0;
			$scope.sum5 = 1;
			$scope.sum6 = 1;
		}
		else if(sharedProperties5.getProductname()=="office"){
			$scope.sum = 1;
			$scope.sum2 = 1;
			$scope.sum3 = 4;
			$scope.sum4 = 1;
			$scope.sum5 = 1;
			$scope.sum6 = 1;
		}
		else if(sharedProperties5.getProductname()=="gaming"){
			$scope.sum = 1;
			$scope.sum2 = 1;
			$scope.sum3 = 8;
			$scope.sum4 = 3;
			$scope.sum5 = 1;
			$scope.sum6 = 1;
		}
			

		
		
		
$scope.addManufac = function(){
			
			
			var data = {
					"id" 					:	$scope.id,
					"productname"       	:	$scope.productname,
					"customername"			:	$scope.customername,
					"amount" 				:	$scope.amount,
					"amountcpu" 			:	$scope.sum * $scope.amount,
					"amountmainboard"		:	$scope.sum2 * $scope.amount,
					"amountram"				:	$scope.sum3 * $scope.amount,
					"amountvga"				:	$scope.sum4 * $scope.amount,
					"amountdvd"				:	$scope.sum5 * $scope.amount,
					"amountaccessoeies"		:	$scope.sum6 * $scope.amount
					
			};
			
		
			
			$http.post('http://localhost:8080/Manufacs',data).success(function(data){
				
				//alert($scope.sumall6);
				alert(data.message);
			}).error(function (data, status, headers, config){
				alert('error');
			});
			
			$scope.show = function() {
				$http.get("http://localhost:8080/manufac/detail/showall").success(function(data) {
					console.log(data[0])
					$scope.datas = data;
				}).error(function(data, status, headers, config) {
					console.log("EER:" + status);
					console.log("EER:" + header);
				});

			}
		}
		
	
		
	
});
////////////KAPITAL/////////////////////////////////////////////////////////////////////////////
app.controller('ProbController', function($scope, $http ,$data) {
	
	$scope.addProblem = function(){
		
		console.log($scope.titlepb)
		console.log($scope.detailpb)

	var data = {
		titlepb: $scope.titlepb,
		detailpb: $scope.detailpb
	};
		
		
		$http.post('http://localhost:8080//Prob/add',data).success(function(data){
			alert(data.message);
		}).error(function (data, status, headers, config){
			alert('error');
		})
	}
	
		$scope.show = function() {
			$http.get("http://localhost:8080//Prob/show").success(function(data) {
				console.log(data[0])
				$scope.datas = data;
			}).error(function(data, status, headers, config) {
				console.log("EER:" + status);
				console.log("EER:" + header);
			});

		}
			
		
		$scope.show();
			
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
app.controller('LoginController', function($scope, $http, $Login) {
	
	$scope.login = function() {
		var userName = $scope.userName; 
		var passWord = $scope.passWord; 
		
		$scope.userName = ""; 
		$scope.passWord = "";

		$http.get(SERVER_URL + '/login/'+userName+'/'+passWord)
		.success(function(user) {

			$Login.setUser(user)
			
			if(user) {
				loginModel.hide();
				}
			else {
				ons.notification.alert({
					message: 'Username หรือ Password ไม่ถูกต้อง โปรดลองอีกครั้ง!!!!!!!'
				})
			}
		});
	}
});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
document.addEventListener("pageinit", function(e) {
  	if (e.target.id == "my-page") {
  		loginModel.show();
  	}
}, false);