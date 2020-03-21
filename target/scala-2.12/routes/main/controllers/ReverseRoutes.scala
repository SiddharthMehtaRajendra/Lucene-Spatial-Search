// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/siddharthmehta/Desktop/Carnegie Mellon University Material/18-655 Service Oriented Computing/Homework 3/Backend/conf/routes
// @DATE:Fri Feb 28 22:26:50 PST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:7
  class ReversePublicationSearch(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def spatialSearch(query:String, yearFrom:Integer, yearTo:Integer, numResultsToSkip:Integer, numResultsToReturn:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "spatialSearch" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("query", query)), Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("yearFrom", yearFrom)), Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("yearTo", yearTo)), Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("numResultsToSkip", numResultsToSkip)), Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("numResultsToReturn", numResultsToReturn)))))
    }
  
    // @LINE:9
    def basicSearch(query:String, numResultsToSkip:Integer, numResultsToReturn:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "basicSearch" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("query", query)), Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("numResultsToSkip", numResultsToSkip)), Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("numResultsToReturn", numResultsToReturn)))))
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
