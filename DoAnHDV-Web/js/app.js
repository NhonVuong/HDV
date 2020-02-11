import {Student} from "./model.js";
console.log(Student({
    id:"ghj",
    address:"dfghjk",
    firstName:"fghj",
    lastName:"ghjk",
    objectClassId:"fghjk",
    className:"abc"
}));

var Service = (function () {
    let JsonLinkService = getLinkService();
    function getLinkService() {
        let myJson = null;
        let outData = function (result) { myJson = result; };
        $.ajax({
            "async": false,
            "type": "GET",
            "url": "../ConfigWeb/linkService.json",
            "dataType": "json",
            "global": false,
            "success": outData
        });
        return myJson;
    };
    let getListStudent = function () {
        let linkSV = (JsonLinkService.ListStudent) ? JsonLinkService.ListStudent : console.log("Không tồn tại link");;
        let setting = {
            "async": false,
            "dataType": "json",
            "global": false,
            "url": linkSV,
            "type": "GET",
            "dataType": "json"
        }
        return $.ajax(setting);
    };

    let getListClass = function () {
        let linkSV = (JsonLinkService.ListClass) ? JsonLinkService.ListClass : console.log("Không tồn tại link");;
        let setting = {
            "url": linkSV,
            "type": "GET",
            "dataType": "json"
        }
        return $.ajax(setting);
    }

    let getListFaculty = function() {
        let linkSV = (JsonLinkService.ListFaculty) ? JsonLinkService.ListFaculty : console.log("Không tồn tại link");;
        let setting = {
            "url": linkSV,
            "type": "GET",
            "dataType": "json"
        }
        return $.ajax(setting);
    }

    return {
        getListClass,
        getListStudent,
        getListFaculty
    }
})();
(function () {
    let onInit = function () {
        startEvent();
    }
    // cacheDOM 
    let $menuLeft = $("#listProvider");
    let $itemMenuLeft = $menuLeft.find("li");
    let $tabs = $("#contentTabs");
    let $itemTabs = $tabs.find(".ub-tab-item");
    // func
    let startEvent = function () {
        $menuLeft.on("click", Click_itemMenuleft);
    };
    let Click_itemMenuleft = function (event) {
        let elm = $(event.target).closest("li");
        $itemMenuLeft.removeClass("active");
        elm.addClass("active");
        let idTarget = elm.attr("data-target");
        $itemTabs.removeClass("active");
        $(idTarget).addClass("active");
    };
    // start
    onInit();
})();
// module loaddata
(function () {
    let ArrStudent = [];
    let onInit = function () {
        cacheDOM.$btnLoadStudent.on("click", LoadDataListStudent);
        cacheDOM.$btnLoadClass.on("click", LoadDataListClass);
        cacheDOM.$btnLoadFaculty.on("click", LoadDataListFaculty);
        AddEvent();
        // start
        cacheDOM.$btnLoadStudent.click();
    }
    let cacheDOM = {
        $elmStudent: $("#isStudent"),
        $elmClass: $("#isClass"),
        $elmFaculty: $("#isFaculty"),

        $elmBodyStudent : $("#isStudent tbody"),
        $elmBodyProduct : $("#isClass tbody"),

        $btnLoadStudent: $("#listProvider [data-target='#isStudent']"),
        $btnLoadClass: $("#listProvider [data-target='#isClass']"),
        $btnLoadFaculty: $("#listProvider [data-target='#isFaculty']"),
        $dialogCreateStudent: $("#dialogCreateStudent")

    }
    // event create
    let AddEvent = function() {
        cacheDOM.$elmBodyStudent.delegate(".del","click", DeleteStudent);
        cacheDOM.$elmBodyStudent.delegate(".edit","click", EditStudent);
        cacheDOM.$elmStudent.find(".create").on("click", OpenFormCreateStudent);
        cacheDOM.$dialogCreateStudent.delegate(".destroy", "click", CloseFormCreateStudent);
        cacheDOM.$dialogCreateStudent.delegate(".submit", "click", CreateStudent);


    }
    // student
    let LoadDataListStudent = function () {
        let template = cacheDOM.$elmBodyStudent.find("script").html();
        Service.getListStudent().done(function (result) {
            console.log(result);
            ArrStudent = result;
            cacheDOM.$elmBodyStudent.html(
                Mustache.render(template, {
                    "ListStudent": ArrStudent,
                    "Sex": function() {
                        return (this.Gender)? "Nam" : "Nữ";
                    },
                    "Index":function() {
                        return ArrStudent.indexOf(this) + 1;
                    }
                })
            );
        });
    }
    let CreateStudent = function() {
       
    }
    let DeleteStudent = function(event) {
        let $elm = $(event.target).closest(".item");
        let index = $elm.attr("data-index") - 1;
        console.log(ArrStudent[index]);
    }
    let EditStudent = function(event) {
        let $elm = $(event.target).closest(".item");
        let index = $elm.attr("data-index") - 1;
        console.log(ArrStudent[index]);
    }
    let OpenFormCreateStudent = function() {
        cacheDOM.$dialogCreateStudent.css("display","block");
    }
    let CloseFormCreateStudent = function(){
        cacheDOM.$dialogCreateStudent.css("display","none");
    }

    // class
    let LoadDataListClass = function () {
        console.log("vao class");
        Service.getListClass().done(function (result) {
            console.log(result);
        });
    }
    // Faculty
    let LoadDataListFaculty = function () {
        console.log("vao Faculty");
        Service.getListFaculty().done(function (result) {
            console.log(result);
        });
    }
    
    // start
    onInit();
})();
