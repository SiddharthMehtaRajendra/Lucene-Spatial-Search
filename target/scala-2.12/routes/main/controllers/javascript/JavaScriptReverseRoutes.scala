// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/siddharthmehta/Desktop/Carnegie Mellon University Material/18-655 Service Oriented Computing/Homework 3/Backend/conf/routes
// @DATE:Fri Feb 28 22:26:50 PST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReversePublicationSearch(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def spatialSearch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicationSearch.spatialSearch",
      """
        function(query0,yearFrom1,yearTo2,numResultsToSkip3,numResultsToReturn4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "spatialSearch" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("query", query0), (""" + implicitly[play.api.mvc.QueryStringBindable[Integer]].javascriptUnbind + """)("yearFrom", yearFrom1), (""" + implicitly[play.api.mvc.QueryStringBindable[Integer]].javascriptUnbind + """)("yearTo", yearTo2), (""" + implicitly[play.api.mvc.QueryStringBindable[Integer]].javascriptUnbind + """)("numResultsToSkip", numResultsToSkip3), (""" + implicitly[play.api.mvc.QueryStringBindable[Integer]].javascriptUnbind + """)("numResultsToReturn", numResultsToReturn4)])})
        }
      """
    )
  
    // @LINE:9
    def basicSearch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicationSearch.basicSearch",
      """
        function(query0,numResultsToSkip1,numResultsToReturn2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "basicSearch" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("query", query0), (""" + implicitly[play.api.mvc.QueryStringBindable[Integer]].javascriptUnbind + """)("numResultsToSkip", numResultsToSkip1), (""" + implicitly[play.api.mvc.QueryStringBindable[Integer]].javascriptUnbind + """)("numResultsToReturn", numResultsToReturn2)])})
        }
      """
    )
  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicationSearch.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
