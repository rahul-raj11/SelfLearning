$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM LoginFeature",
  "description": "",
  "id": "free-crm-loginfeature",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#Without \u0027Examples\u0027 keyword"
    },
    {
      "line": 4,
      "value": "#Scenario: Free CRM Login Test"
    },
    {
      "line": 5,
      "value": "#"
    },
    {
      "line": 6,
      "value": "#Given user is already on login page"
    },
    {
      "line": 7,
      "value": "#When title of login page is Cogmento CRM"
    },
    {
      "line": 8,
      "value": "#Then user enters \"sikriwal.rahulraj@gmail.com\" and \"123Admin\""
    },
    {
      "line": 9,
      "value": "#Then user clicks on login button"
    },
    {
      "line": 10,
      "value": "#And user is on home page"
    },
    {
      "line": 11,
      "value": "#With \u0027Examples\u0027 keyword"
    },
    {
      "line": 12,
      "value": "#Scenario Outline: Free CRM Login Test"
    },
    {
      "line": 13,
      "value": "#"
    },
    {
      "line": 14,
      "value": "#Given user is already on login page"
    },
    {
      "line": 15,
      "value": "#When title of login page is Cogmento CRM"
    },
    {
      "line": 16,
      "value": "#Then user enters \"\u003cusername\u003e\" and \"\u003cpassword\u003e\""
    },
    {
      "line": 17,
      "value": "#Then user clicks on login button"
    },
    {
      "line": 18,
      "value": "#And user is on home page"
    },
    {
      "line": 19,
      "value": "#"
    },
    {
      "line": 20,
      "value": "#Examples:"
    },
    {
      "line": 21,
      "value": "#\t\t| username                    | password |"
    },
    {
      "line": 22,
      "value": "#\t\t| sikriwal.rahulraj@gmail.com | 123Admin |"
    },
    {
      "line": 23,
      "value": "#Using DataTables"
    },
    {
      "line": 24,
      "value": "#Scenario: Free CRM Login Test"
    },
    {
      "line": 25,
      "value": "#Given user is already on login page"
    },
    {
      "line": 26,
      "value": "#When title of login page is Cogmento CRM"
    },
    {
      "line": 27,
      "value": "#Then user enters username and password"
    },
    {
      "line": 28,
      "value": "#| sikriwal.rahulraj@gmail.com | 123Admin |"
    },
    {
      "line": 29,
      "value": "#Then user clicks on login button"
    },
    {
      "line": 30,
      "value": "#And user is on home page"
    },
    {
      "line": 33,
      "value": "#Data driven using Map"
    }
  ],
  "line": 34,
  "name": "Free CRM Login Test",
  "description": "",
  "id": "free-crm-loginfeature;free-crm-login-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 35,
  "name": "user is already on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "title of login page is Cogmento CRM",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "user enters username and password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 38
    },
    {
      "cells": [
        "sikriwal.rahulraj@gmail.com",
        "123Admin"
      ],
      "line": 39
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "user clicks on login button",
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "user is on home page",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefination.user_already_on_login_page()"
});
formatter.result({
  "duration": 7971972800,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefination.title_of_login_page_is_cogmento_CRM()"
});
formatter.result({
  "duration": 28849300,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefination.user_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 1669675000,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefination.user_clicks_on_login_button()"
});
formatter.result({
  "duration": 105131600,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefination.user_is_on_home_page()"
});
formatter.result({
  "duration": 1864581200,
  "status": "passed"
});
});